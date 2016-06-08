package com.fyj.gank.view.homeview;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fyj.dependlib.widget.LoadMoreRecyclerView;
import com.fyj.gank.R;
import com.fyj.gank.base.BaseLazyFragment;


public class HomeFragment extends BaseLazyFragment<HomePresenter,HomeModel> implements HomeContract.View {

    private SwipeRefreshLayout mSrlList;
    private LoadMoreRecyclerView mLrvList;
    private TextView mTvEmpty;

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




    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void updateView(String json) {

    }

    @Override
    public void dataError(String msg) {

    }
}
