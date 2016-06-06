package com.fyj.gank;

import android.app.Application;

import com.fyj.gank.utils.CrashHandler;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;

/**
 * Created by Fyj on 2016/6/3.
 */
public class GankApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

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
}
