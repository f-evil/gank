package com.fyj.gank.view.welcomeview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fyj.dependlib.listener.SubMultipleClickListener;
import com.fyj.gank.R;
import com.fyj.gank.baseview.BaseActivity;
import com.fyj.gank.view.homeview.MainContainerActivity;

public class WelcomeActivitye extends BaseActivity {

    private Button mDummyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_welcome_activitye);

        mDummyButton = (Button) findViewById(R.id.dummy_button);

    }

    @Override
    protected void getDate() {

    }

    @Override
    protected void initBroadCast() {

    }

    @Override
    protected void bindEvent() {
        mDummyButton.setOnClickListener(new SubMultipleClickListener(){
            @Override
            public void onSubClick(View v) {
                super.onSubClick(v);
                MainContainerActivity.MainContainerActivitySkip(WelcomeActivitye.this);
                finish();
            }
        });
    }

}
