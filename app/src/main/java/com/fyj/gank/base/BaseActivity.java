package com.fyj.gank.base;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.flyco.systembar.SystemBarHelper;
import com.fyj.dependlib.utils.TUtil;
import com.fyj.dependlib.utils.XLog;
import com.fyj.gank.R;
import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends AppCompatActivity {

    public T mPresenter;
    public E mModel;
    public Context mContext;

    public String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        XLog.e("BaseActivity", TAG);
        super.onCreate(savedInstanceState);
        this.setContentView(this.getLayoutId());
        ButterKnife.bind(this);
        mContext = this;
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        initDate();
        initPresenter();
        initView();
        getDate();
        initBroadCast();
        bindEvent();
        changeSystembar();
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(this.toString());
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(this.toString());
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void getDate();

    protected abstract void initBroadCast();

    protected abstract void bindEvent();

    protected abstract void initPresenter();

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
//		super.onBackPressed();
        finish();
    }

}
