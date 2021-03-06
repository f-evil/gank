package com.fyj.gank.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.flyco.systembar.SystemBarHelper;
import com.fyj.dependlib.utils.XLog;
import com.fyj.gank.R;

public abstract class BaseFragmentActivity extends FragmentActivity {

    public String TAG=this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        XLog.e(TAG, "on creating ...");
        initDate();
        initView();
        getDate();
        initBroadCast();
        bindEvent();
        changeSystembar();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected abstract void initView();

    protected abstract void getDate();

    protected abstract void initBroadCast();

    protected abstract void bindEvent();

    protected void initDate() {
    }

    private void changeSystembar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            titleColor();
        }
    }

    protected void titleColor() {
        int color;

        if (Build.VERSION.SDK_INT >= 23) {
            color= getResources().getColor(R.color.stausbar_color, getTheme());
        }else {
            color= getResources().getColor(R.color.stausbar_color);
        }
        SystemBarHelper.tintStatusBar(this,color );
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
