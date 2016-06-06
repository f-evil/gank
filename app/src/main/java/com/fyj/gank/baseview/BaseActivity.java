package com.fyj.gank.baseview;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.fyj.dependlib.utils.XLog;
import com.umeng.analytics.MobclickAgent;

public abstract class BaseActivity extends Activity {

	public String TAG=this.getClass().getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		XLog.e("BaseActivity",TAG);
		initDate();
		initView();
		getDate();
		initBroadCast();
		bindEvent();
		changeSystembar();
	}

	@Override
	protected void onPause() {
		super.onPause();
		MobclickAgent.onPageEnd(this.toString());
		MobclickAgent.onPause(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		MobclickAgent.onPageStart(this.toString());
		MobclickAgent.onResume(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

	}

	protected abstract void initView();

	protected abstract void getDate();

	protected abstract void initBroadCast();

	protected abstract void bindEvent();

	protected void initDate(){

	}

	private void changeSystembar(){
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			titleColor();
		}
	}

	protected void titleColor(){

	}

	@Override
	public void onBackPressed() {
//		super.onBackPressed();
		finish();
	}

}
