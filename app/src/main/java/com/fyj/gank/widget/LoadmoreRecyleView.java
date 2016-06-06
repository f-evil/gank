package com.fyj.gank.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

public class LoadmoreRecyleView extends RecyclerView {

    /**
     * adapter
     */
    private Adapter mAdapter;
    /**
     * 上拉加载回调
     */
    private LoadMoreListener mListener;
    /**
     * 是否上拉加载
     */
    private boolean mIsLoadingMore;

    public LoadmoreRecyleView(Context context) {
        super(context);
        init();
    }

    public LoadmoreRecyleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadmoreRecyleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        mAdapter = adapter;
    }

    private void init() {
        super.addOnScrollListener(new OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int lastVisiblePosition = getLastVisiblePosition();
                    int totoalItemCount = 0;

                    if (mAdapter != null) {
                        totoalItemCount = mAdapter.getItemCount();
                    }

                    if (null != mListener && mIsLoadingMore && lastVisiblePosition + 1 == totoalItemCount) {
                        setLoadingMore(true);
                        mListener.onLoadMore();
                    }
                }
            }
        });
    }

    /**
     * 获得当前展示最小的position
     *
     * @param positions poss
     * @return pos
     */
    private int getMinPositions(int[] positions) {
        int minPosition = Integer.MAX_VALUE;
        for (int pos : positions) {
            minPosition = Math.min(minPosition, pos);
        }

        return minPosition;
    }

    /**
     * 获得最大的位置
     *
     * @param positions pos
     * @return pos
     */
    private int getMaxPosition(int[] positions) {
        int maxPosition = Integer.MIN_VALUE;
        for (int pos : positions) {
            maxPosition = Math.min(maxPosition, pos);
        }
        return maxPosition;
    }

    /**
     * 获取最后一条展示的位置
     *
     * @return pos
     */
    private int getLastVisiblePosition() {
        int position;
        if (getLayoutManager() instanceof LinearLayoutManager) {
            position = ((LinearLayoutManager) getLayoutManager()).findLastVisibleItemPosition();
        } else if (getLayoutManager() instanceof GridLayoutManager) {
            position = ((GridLayoutManager) getLayoutManager()).findLastVisibleItemPosition();
        } else if (getLayoutManager() instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager layoutManager = (StaggeredGridLayoutManager) getLayoutManager();
            int[] lastPositions = layoutManager.findLastVisibleItemPositions(new int[layoutManager.getSpanCount()]);
            position = getMaxPosition(lastPositions);
        } else {
            position = getLayoutManager().getItemCount() - 1;
        }
        return position;
    }

    /**
     * 设置加载更多的监听
     *
     * @param listener listener
     */
    public void setLoadMoreListener(LoadMoreListener listener) {
        mListener = listener;
    }

    /**
     * 设置正在加载更多
     *
     * @param loadingMore loadingMore
     */
    public void setLoadingMore(boolean loadingMore) {
        this.mIsLoadingMore = loadingMore;
    }

    /**
     * 加载更多监听
     */
    public interface LoadMoreListener {
        /**
         * 加载更多
         */
        void onLoadMore();
    }

    /**
     * 通知更多的数据已经加载
     *
     * 每次加载完成之后添加了Data数据，用notifyItemRemoved来刷新列表展示，
     * 而不是用notifyDataSetChanged来刷新列表
     *
     * @param hasMore
     */
    public void notifyMoreFinish(boolean hasMore) {
        mIsLoadingMore = hasMore;
        if (mAdapter!=null){
            mAdapter.notifyDataSetChanged();
        }
    }
}
