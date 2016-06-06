package com.fyj.dependlib.listener;

import android.view.View;

/**
 * 防爆点击
 * Created by Fyj on 2016/5/30.
 */
public abstract class SubMultipleClickListener implements View.OnClickListener {

    /**
     * 延迟点击
     */
    private final static float DELAY_TIME=1800;

    /**
     * 最后一次有效点击时间
     */
    private long lastClickTime;

    public SubMultipleClickListener() {
        lastClickTime=0;
    }

    @Override
    public void onClick(View v) {
        if (!canTransmit()){
            return;

        }
        onSubClick(v);
    }

    public void onSubClick(View v){

    }

    protected boolean canTransmit(){

        long temTime= System.currentTimeMillis();

        float ttTime= Math.abs(temTime-lastClickTime);

        if (ttTime<DELAY_TIME&&ttTime>0){
            return false;
        }

        lastClickTime= System.currentTimeMillis();
        return true;
    }
}
