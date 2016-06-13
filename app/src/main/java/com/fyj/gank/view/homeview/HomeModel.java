package com.fyj.gank.view.homeview;

import com.fyj.dependlib.utils.XLog;
import com.fyj.gank.bean.HistoryBean;
import com.fyj.gank.net.Api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import rx.Observable;

/**
 * Created by Fyj on 2016/6/7.
 */
public class HomeModel implements HomeContract.Model {


    @Override
    public Observable<HistoryBean> getDataFromWeb() {

        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

        String str = df.format(new Date());

        XLog.e(str);

        return Api.getInstance()
                .mApiService
                .getSingleHistory(str);
    }
}
