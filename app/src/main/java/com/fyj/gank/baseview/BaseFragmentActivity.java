package com.fyj.gank.baseview;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.fyj.dependlib.utils.XLog;

public abstract class BaseFragmentActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		XLog.e("BaseFragmentActivity", this.getClass().getSimpleName());
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
	}

	@Override
	protected void onResume() {
		super.onResume();
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
		finish();
	}

}
