package com.fyj.gank.baseview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *
 * Created by Fyj on 2016/6/3.
 */
public abstract class BaseLazyFragment extends Fragment {

    /**
     * 是否可见状态
     */
    private boolean isVisible;
    /**
     * 标志位，View已经初始化完成。
     */
    private boolean isPrepared;
    /**
     * 是否第一次加载
     */
    private boolean isFirstLoad = true;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        isFirstLoad = true;
        View view = initViews(inflater, container, savedInstanceState);
        isPrepared = true;
        load();
        return view;
    }

    /**
     * 如果是与ViewPager一起使用，调用的是setUserVisibleHint
     *
     * @param isVisibleToUser 是否显示出来了
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 如果是通过FragmentTransaction的show和hide的方法来控制显示，调用的是onHiddenChanged.
     * 若是初始就show的Fragment 为了触发该事件 需要先hide再show
     *
     * @param hidden hidden True if the fragment is now hidden, false if it is not
     *               visible.
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
        load();
    }

    protected void onInvisible() {
    }

    /**
     * 要实现延迟加载Fragment内容,需要在 onCreateView
     * isPrepared = true;
     */
    protected void load() {
        if (!isPrepared || !isVisible || !isFirstLoad) {
            return;
        }
        isFirstLoad = false;
        initData();
        lazyLoad();
    }

    protected abstract void lazyLoad();

    protected abstract View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void initData();

}
