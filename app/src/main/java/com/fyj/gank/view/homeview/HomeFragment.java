package com.fyj.gank.view.homeview;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fyj.dependlib.utils.XLog;
import com.fyj.dependlib.widget.LoadMoreRecyclerView;
import com.fyj.gank.R;
import com.fyj.gank.base.BaseLazyFragment;
import com.fyj.gank.bean.HistoryBean;
import com.fyj.gank.imageloader.ImageLoaderHelper;

import butterknife.Bind;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;


public class HomeFragment extends BaseLazyFragment<HomePresenter,HomeModel> implements HomeContract.View {

    private SwipeRefreshLayout mSrlList;
    private LoadMoreRecyclerView mLrvList;
    private TextView mTvEmpty;

    ImageView iv1;
    ImageView iv2;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void lazyLoad(View view) {
        mSrlList = (SwipeRefreshLayout) view.findViewById(R.id.srl_list);
        mLrvList = (LoadMoreRecyclerView) view.findViewById(R.id.lrv_list);
        mTvEmpty = (TextView) view.findViewById(R.id.tv_empty);
        iv1 = (ImageView) view.findViewById(R.id.iv1);
        iv2 = (ImageView) view.findViewById(R.id.iv2);

    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this, mModel);
    }


    @Override
    public void updateView(Observable<HistoryBean> data) {
        data
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HistoryBean>() {
                    @Override
                    public void call(HistoryBean historyBean) {
                        XLog.e(historyBean.toString());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }

    @Override
    public void dataError(String msg) {

    }
}
