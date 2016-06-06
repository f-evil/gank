package com.fyj.gank.view.homeview;

import android.graphics.PixelXorXfermode;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.fyj.dependlib.mock.DummyContent;
import com.fyj.dependlib.utils.XLog;
import com.fyj.gank.R;
import com.fyj.gank.adapter.MyItemRecyclerViewAdapter;
import com.fyj.gank.baseview.BaseLazyFragment;
import com.fyj.gank.widget.LoadmoreRecyleView;

public class DemoFragmente extends BaseLazyFragment {

    private LoadmoreRecyleView mRcvContent;
    private MyItemRecyclerViewAdapter mmyItemRecyclerViewAdapter;

    private ProgressBar mPbP;
    private SwipeRefreshLayout mSrlP;

    private int page = 0;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_demo_fragmente, container, false);
        mRcvContent = (LoadmoreRecyleView) view.findViewById(R.id.rcv_content);
        mRcvContent.setHasFixedSize(true);
        mPbP = (ProgressBar) view.findViewById(R.id.pb_p);
        mSrlP = (SwipeRefreshLayout) view.findViewById(R.id.srl_p);
        return view;
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void lazyLoad() {

        mSrlP.setRefreshing(true);

        mSrlP.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSrlP.setRefreshing(false);
                page = 0;
                mmyItemRecyclerViewAdapter.setData(DummyContent.generyData(page));
                mmyItemRecyclerViewAdapter.notifyDataSetChanged();
            }
        });

        mmyItemRecyclerViewAdapter = new MyItemRecyclerViewAdapter(DummyContent.generyData(page));
        mRcvContent.notifyMoreFinish(DummyContent.hasMore(page));
        mRcvContent.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRcvContent.setAdapter(mmyItemRecyclerViewAdapter);
        mRcvContent.setLoadMoreListener(new LoadmoreRecyleView.LoadMoreListener() {
            @Override
            public void onLoadMore() {
                mRcvContent.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        XLog.e("dwadwadwadaw");
                        mmyItemRecyclerViewAdapter.addDatas(DummyContent.generyData(++page));
                        mRcvContent.notifyMoreFinish(DummyContent.hasMore(page));
                        mSrlP.setRefreshing(false);
                        mPbP.setVisibility(View.GONE);
                    }
                }, 1000);
            }
        });


    }
}
