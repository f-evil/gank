package com.fyj.gank.view.homeview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.fyj.gank.R;
import com.fyj.gank.adapter.MainContainerAdapter;
import com.fyj.gank.baseview.BaseFragmentActivity;
import com.fyj.gank.model.TabEntity;

import java.util.ArrayList;

public class MainContainerActivity extends BaseFragmentActivity {

    private ArrayList<CustomTabEntity> mTabEntities;
    private ArrayList<Fragment> mFragments;

    private String[] mTitles = {"最新", "分类", "随机"};
    private int[] mIconUnselectIds = {
            R.mipmap.icon_home_up, R.mipmap.icon_type_up,
            R.mipmap.icon_random_up};
    private int[] mIconSelectIds = {
            R.mipmap.icon_home_down, R.mipmap.icon_type_down,
            R.mipmap.icon_random_down};

    private ViewPager mViewpagerContainer;
    private CommonTabLayout mCtlButtom;


    public static void MainContainerActivitySkip(Context mContext){
        mContext.startActivity(new Intent(mContext,MainContainerActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initDate() {
        super.initDate();
        mFragments = new ArrayList<>();
        mTabEntities=new ArrayList<>();

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
            mFragments.add(new DemoFragmente());
        }
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main_container);

        mViewpagerContainer = (ViewPager) findViewById(R.id.viewpager_container);
        mViewpagerContainer.setOffscreenPageLimit(1);
        mCtlButtom = (CommonTabLayout) findViewById(R.id.ctl_buttom);
        mCtlButtom.setTabData(mTabEntities);

        initViewpager();

    }

    private void initViewpager() {

        mViewpagerContainer.setAdapter(new MainContainerAdapter(getSupportFragmentManager(),mFragments,mTitles));

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
                mViewpagerContainer.setOffscreenPageLimit(4);
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

}
