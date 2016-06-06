package com.fyj.gank.view.welcomeview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.fyj.dependlib.listener.SubMultipleClickListener;
import com.fyj.gank.R;
import com.fyj.gank.view.main.MainContainerActivity;

public class WelcomeActivitye extends AppCompatActivity {

    private Button mDummyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_activitye);

        mDummyButton = (Button) findViewById(R.id.dummy_button);
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
