package com.fyj.gank.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Fyj on 2016/6/3.
 */
public class MainContainerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragments;
    private String[] mTitles = {"最新", "分类", "随机"};

    public MainContainerAdapter(FragmentManager fm,ArrayList<Fragment> mFragments,String[] mTitles) {
        super(fm);
        this.mFragments=mFragments;
        this.mTitles=mTitles;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }
}
