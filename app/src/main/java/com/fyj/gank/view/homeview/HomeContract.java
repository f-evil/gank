package com.fyj.gank.view.homeview;

import com.fyj.gank.base.BaseModel;
import com.fyj.gank.base.BasePresenter;
import com.fyj.gank.base.BaseView;

/**
 * Created by Fyj on 2016/6/6.
 */
public interface HomeContract {

    interface Model extends BaseModel {

    }

    interface View extends BaseView{
        void updataListView(String jsonString);
    }

    abstract class Presenter extends BasePresenter{

    }

}
