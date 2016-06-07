package com.fyj.gank.view.main;

import android.support.v4.app.Fragment;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.fyj.gank.R;
import com.fyj.gank.model.TabEntity;
import com.fyj.gank.view.homeview.HomeFragment;
import com.fyj.gank.view.randeom.RandomFragment;
import com.fyj.gank.view.type.TypeFragment;

import java.util.ArrayList;

/**
 *
 * Created by Fyj on 2016/6/6.
 */
public class MainModel implements MainContract.Model {

    private String[] mTitles = {"最新", "分类", "随机"};
    private int[] mIconUnselectIds = {
            R.mipmap.icon_home_up, R.mipmap.icon_type_up,
            R.mipmap.icon_random_up};
    private int[] mIconSelectIds = {
            R.mipmap.icon_home_down, R.mipmap.icon_type_down,
            R.mipmap.icon_random_down};

    @Override
    public ArrayList<CustomTabEntity> getTabs() {

        ArrayList<CustomTabEntity> mTabEntities=new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }

        return mTabEntities;
    }

    @Override
    public ArrayList<Fragment> getFragments() {

        ArrayList<Fragment> mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new TypeFragment());
        mFragments.add(new RandomFragment());
        return mFragments;
    }

    @Override
    public String[] getTitles() {
        return mTitles;
    }
}
