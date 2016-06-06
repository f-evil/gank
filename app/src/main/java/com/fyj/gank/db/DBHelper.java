package com.fyj.gank.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.fyj.dependlib.utils.XLog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DBHelper extends SQLiteOpenHelper {
    public static final String USER_DBNAME = "gank.db";

    private static final int DATABASE_VERSION = 8;

    private static final String DB_PATH = "schema";
    private static final String ZOOM_SQL_NAME = "xxx.sql";

    private Context mContext;

    private static final String CREATE_HTTPCACHE = "CREATE TABLE IF NOT EXISTS tblHttpCache(" +
            "_c_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "url text," +
            "response text," +
            "userid text)";

    private static final String CREATE_HTTPCACHE_IDX = "CREATE INDEX idx_httpCache_url ON tblHttpCache(url);";


    public DBHelper(Context context) {
        super(context, USER_DBNAME, null, DATABASE_VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        XLog.e("Tag", "DataBase onCreate ...");
        try {

            db.execSQL(CREATE_HTTPCACHE);
            db.execSQL(CREATE_HTTPCACHE_IDX);

        } catch (Exception ex) {
            XLog.e("Tag", ex);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("ALTER TABLE user ADD COLUMN other TEXT");
        XLog.e("Tag", "DataBase onUpgrade ...version" + newVersion);
        switch (oldVersion) {

        }
    }

    /**
     * 读取数据库文件（.sql），并执行sql语句
     */
    private void executeAssetsSQL(SQLiteDatabase db, String schemaName) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(mContext.getAssets()
                    .open(DBHelper.DB_PATH + "/" + schemaName)));

            System.out.println("路径:" + DBHelper.DB_PATH + "/" + schemaName);
            String line;
            String buffer = "";
            while ((line = in.readLine()) != null) {
                buffer += line;
                if (line.trim().endsWith(";")) {
                    db.execSQL(buffer.replace(";", ""));
                    buffer = "";
                }
            }
        } catch (IOException e) {
            XLog.e("db-error", e.toString());
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                XLog.e("db-error", e.toString());
            }
        }
    }
}
