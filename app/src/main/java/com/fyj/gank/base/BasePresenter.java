package com.fyj.gank.base;

import android.content.Context;

/**
 * Created by Fyj on 2016/6/6.
 */
public abstract class BasePresenter<E, T> {
    public Context context;
    public E mModel;
    public T mView;

    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    public abstract void onStart();

}
