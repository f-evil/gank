package com.fyj.gank.view.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.fyj.gank.R;
import com.fyj.gank.adapter.MainContainerAdapter;
import com.fyj.gank.base.BaseActivity;

import java.util.ArrayList;

import butterknife.Bind;

public class MainContainerActivity extends BaseActivity<MainPresenter, MainModel> implements MainContract.View {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.viewpager_container)
    ViewPager mViewpagerContainer;
    @Bind(R.id.ctl_buttom)
    CommonTabLayout mCtlButtom;

    private ActionBar supportActionBar;


    public static void MainContainerActivitySkip(Context mContext) {
        mContext.startActivity(new Intent(mContext, MainContainerActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_container;
    }

    @Override
    protected void initDate() {
        super.initDate();
    }

    @Override
    protected void initView() {

        setSupportActionBar(toolbar);
        supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }
        mViewpagerContainer.setOffscreenPageLimit(4);

        setTitle("首页");

        initViewpager();

    }

    private void initViewpager() {

        mCtlButtom.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewpagerContainer.setCurrentItem(position);
                setTitle(mModel.getTitles()[position]);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mViewpagerContainer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCtlButtom.setCurrentTab(position);
                setTitle(mModel.getTitles()[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewpagerContainer.setCurrentItem(0);

    }

    @Override
    protected void getDate() {

    }

    @Override
    protected void initBroadCast() {

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    public void setTitle(String title) {
        if (supportActionBar != null) {
            supportActionBar.setTitle(title);
        }
    }

    @Override
    public void updataListView(ArrayList<CustomTabEntity> tabs, ArrayList<Fragment> fragments, String[] titles) {
        mCtlButtom.setTabData(tabs);
        mViewpagerContainer.setAdapter(new MainContainerAdapter(getSupportFragmentManager(), fragments, titles));
    }
}
