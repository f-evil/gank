package com.fyj.gank.view.homeview;

import com.fyj.gank.base.BaseModel;
import com.fyj.gank.base.BasePresenter;
import com.fyj.gank.base.BaseView;

/**
 *
 * Created by Fyj on 2016/6/7.
 */
public interface HomeContract {

    interface Model extends BaseModel {
        void getDataFromWeb();
    }

    interface View extends BaseView {
        void updateView(String json);
        void dataError(String msg);
    }

    abstract class Presenter extends BasePresenter<Model, View> {

    }
}
