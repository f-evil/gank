package com.fyj.dependlib.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast显示工具类
 * 防止Toast多次显示的问题
 * <p/>
 * Created by fyj on 2015/9/19.
 */
public class ToastUtil {

    private static Toast mToast = null;
    private static Context mContext = null;

    public static void setContext(Context context) {
        mContext = context;
    }


    public static void makeText(CharSequence msg) {

        if (null == msg) {
            return;
        }

        if (mToast == null) {
            mToast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }

        mToast.show();

    }

}
