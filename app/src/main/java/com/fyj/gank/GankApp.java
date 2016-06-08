package com.fyj.gank;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.fyj.dependlib.utils.ToastUtil;
import com.fyj.gank.utils.CrashHandler;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;

import java.lang.ref.SoftReference;

/**
 * Created by Fyj on 2016/6/3.
 */
public class GankApp extends Application {

    public static SoftReference<Context> gankApp;

    @Override
    public void onCreate() {
        super.onCreate();

        gankApp = new SoftReference<>(getApplicationContext());

        ToastUtil.setContext(gankApp.get());

        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this, this.getPackageName());

        CrashReport.initCrashReport(this, "900032407", false);
        MobclickAgent.openActivityDurationTrack(false);

        initUMengShare();

    }

    private void initUMengShare() {
        //微信
        PlatformConfig.setWeixin("", "");
        //新浪微博
        PlatformConfig.setSinaWeibo("", "");
        //QQ空间
        PlatformConfig.setQQZone("", "");
        //回流
        Config.isloadUrl = true;
    }

    public static Context getAppContext() {
        if (gankApp!=null){
            return gankApp.get();
        }
        return getAppContext();
    }

    public static Resources getAppResources() {
        if (gankApp!=null){
            return gankApp.get().getResources();
        }
        return getAppContext().getResources();
    }
}
