package com.fyj.gank.view.homeview;

import com.fyj.gank.base.BaseModel;
import com.fyj.gank.base.BasePresenter;
import com.fyj.gank.base.BaseView;
import com.fyj.gank.bean.HistoryBean;

import rx.Observable;

/**
 *
 * Created by Fyj on 2016/6/7.
 */
public interface HomeContract {

    interface Model extends BaseModel {
        Observable<HistoryBean> getDataFromWeb();
    }

    interface View extends BaseView {
        void updateView(Observable<HistoryBean> data);
        void dataError(String msg);
    }

    abstract class Presenter extends BasePresenter<Model, View> {

    }
}
