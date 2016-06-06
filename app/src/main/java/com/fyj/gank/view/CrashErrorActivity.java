package com.fyj.gank.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.fyj.gank.R;
import com.fyj.gank.baseview.BaseActivity;
import com.umeng.analytics.MobclickAgent;

public class CrashErrorActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void initView() {
		setContentView(R.layout.customactivityoncrash_default_error_activity);

		Button restartButton = (Button) findViewById(R.id.customactivityoncrash_error_activity_restart_button);

		restartButton.setText("点击唤醒");
		restartButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent i = getBaseContext().getPackageManager()
						.getLaunchIntentForPackage(getBaseContext().getPackageName());
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
				MobclickAgent.onKillProcess(CrashErrorActivity.this);
				android.os.Process.killProcess(Process.myPid());
			}
		});
	}

	@Override
	protected void getDate() {

	}

	@Override
	protected void initBroadCast() {

	}

	@Override
	protected void bindEvent() {

	}

}
