package com.fyj.gank.view.main;

/**
 *
 * Created by Fyj on 2016/6/6.
 */
public class MainPresenter extends MainContract.Presenter {


    public void onStart() {
        mView.updataListView(mModel.getTabs(),mModel.getFragments(),mModel.getTitles());
    }
}
