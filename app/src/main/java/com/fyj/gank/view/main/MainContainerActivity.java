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
import com.fyj.gank.model.TabEntity;

import java.util.ArrayList;

import butterknife.Bind;

public class MainContainerActivity extends BaseActivity {

    private ArrayList<CustomTabEntity> mTabEntities;
    private ArrayList<Fragment> mFragments;

    private String[] mTitles = {"最新", "分类", "随机"};
    private int[] mIconUnselectIds = {
            R.mipmap.icon_home_up, R.mipmap.icon_type_up,
            R.mipmap.icon_random_up};
    private int[] mIconSelectIds = {
            R.mipmap.icon_home_down, R.mipmap.icon_type_down,
            R.mipmap.icon_random_down};
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
        mFragments = new ArrayList<>();
        mTabEntities = new ArrayList<>();

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
    }

    @Override
    protected void initView() {

        setSupportActionBar(toolbar);
        supportActionBar = getSupportActionBar();
        if (supportActionBar!=null){
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }
        mViewpagerContainer.setOffscreenPageLimit(4);
        mCtlButtom.setTabData(mTabEntities);
        setTitle("首页");

        initViewpager();

    }

    private void initViewpager() {

        mViewpagerContainer.setAdapter(new MainContainerAdapter(getSupportFragmentManager(), mFragments, mTitles));

        mCtlButtom.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewpagerContainer.setCurrentItem(position);
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

    public void setTitle(String title) {
        if (supportActionBar!=null){
            supportActionBar.setTitle(title);
        }
    }

}
