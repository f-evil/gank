package com.fyj.gank.view.main;

import android.support.v4.app.Fragment;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.fyj.gank.base.BaseModel;
import com.fyj.gank.base.BasePresenter;
import com.fyj.gank.base.BaseView;

import java.util.ArrayList;

/**
 * Created by Fyj on 2016/6/6.
 */
public interface MainContract {

    interface Model extends BaseModel {
        ArrayList<CustomTabEntity> getTabs();
        ArrayList<Fragment> getFragments();
        String[] getTitles();
    }

    interface View extends BaseView {
        void updataListView(ArrayList<CustomTabEntity> tabs,ArrayList<Fragment> fragments,String[] titles);
    }

    abstract class Presenter extends BasePresenter<Model,View> {

    }
}
