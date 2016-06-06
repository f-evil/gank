package com.fyj.gank.db;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;


/**
 * @author fyj
 * @version 创建时间：2016-3-26 上午11:34:09
 * @description http Response cache
 */
public class HttpCacheDB2 {

    private Context _context;

    public DBOperator dbOperator;

    public HttpCacheDB2(Context context) {
        dbOperator = new DBOperator(context);
        _context = context;
    }

    public boolean isExistUrl(String url) {
        String sql = "select * from tblHttpCache where url=? and userid= ?";
        String[] params = new String[]{url, "gank"};

        int count = this.dbOperator.getCount(sql, params);

        if (count == 0)
            return false;

        return true;
    }

    /**
     * 插入http response
     *
     * @param url      url
     * @param response response
     */
    public void addUrlResopnse(String url, String response) {

        if (isExistUrl(url)) {
            updateHttpResponse(url, response);
            return;
        }

        Object[] params;
        String sql = "insert into tblHttpCache (url,response,userid) values(?,?,?)";

        params = new Object[]{url, response, "gank"};

        dbOperator.operator(sql, params);
    }

    /**
     * 更新http response
     *
     * @param url      url
     * @param response response
     */
    public void updateHttpResponse(String url, String response) {

        String sql = "update tblHttpCache set response=? where url=? and userid=?";

        String[] params = new String[]{response, url, "gank"};

        dbOperator.operator(sql, params);
    }

    /**
     * 获取缓存
     *
     * @param url url
     * @return Response
     */
    public String getHttpResponse(String url) {
        String response = "";
        String sql = "select * from tblHttpCache where url=? and userid= ?";
        String[] params = new String[]{url, "gank"};

        List<Map> resList = this.dbOperator.query(sql, params, new String[]{"response"});
        if (resList != null && resList.size() > 0) {
            response = String.valueOf(resList.get(0).get("response"));
        }

        if (response != null && !response.isEmpty()) {
            if (response.startsWith("[")) {
                try {
                    JSONArray ja = new JSONArray(response);
                    response = ja.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    JSONObject jo = new JSONObject(response);
                    response = jo.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        return response;
    }

}
