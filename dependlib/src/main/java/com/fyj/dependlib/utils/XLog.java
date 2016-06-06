package com.fyj.dependlib.utils;

import android.util.Log;

/**
 * 日志打印控制类
 * 正式发布版本时,LEVEL调为0,将不打印所有LOG
 *
 * Created by fyj on 2015/9/18.
 */
public class XLog {

	private static int LEVEL = 6;
	private static String TAG = "Gank.io";

	private static final int V = 1;
	private static final int D = 2;
	private static final int I = 3;
	private static final int W = 4;
	private static final int E = 5;

	public static void v(String msg){

		if (msg==null||msg.isEmpty()){
			msg="data is null";
		}

		if (LEVEL>=V){
			Log.v(TAG,msg);
		}

	}

	public static void v(String TAG, String msg){

		if (msg==null||msg.isEmpty()){
			msg="data is null";
		}

		if (LEVEL>=V){
			Log.v(TAG,msg);
		}

	}

	public static void d(String msg){

		if (msg==null||msg.isEmpty()){
			msg="data is null";
		}

		if (LEVEL>=D){
			Log.d(TAG, msg);
		}

	}

	public static void d(String TAG, String msg){

		if (msg==null||msg.isEmpty()){
			msg="data is null";
		}

		if (LEVEL>=D){
			Log.d(TAG, msg);
		}

	}

	public static void i(String msg){

		if (msg==null||msg.isEmpty()){
			msg="data is null";
		}

		if (LEVEL>=I){
			Log.i(TAG, msg);
		}

	}

	public static void i(String TAG, String msg){

		if (msg==null||msg.isEmpty()){
			msg="data is null";
		}

		if (LEVEL>=I){
			Log.i(TAG, msg);
		}

	}

	public static void w(String msg){

		if (msg==null||msg.isEmpty()){
			msg="data is null";
		}

		if (LEVEL>=W){
			Log.w(TAG, msg);
		}

	}

	public static void w(String TAG, String msg){

		if (msg==null||msg.isEmpty()){
			msg="data is null";
		}

		if (LEVEL>=W){
			Log.w(TAG, msg);
		}

	}

	public static void e(String msg){

		if (msg==null){
			msg="data is null";

		}else {
			if (msg.isEmpty()){
				msg="data is \" \"";
			}
		}

		if (LEVEL>=E){
			Log.e(TAG, msg);
		}

	}

	public static void e(String TAG, String msg){

		if (msg==null){
			msg="data is null";

		}else {
			if (msg.isEmpty()){
				msg="data is \" \"";
			}
		}

		if (LEVEL>=E){
			Log.e(TAG, msg);
		}

	}

	public static void e(int msg){
		if (LEVEL>=E){
			Log.e(TAG,msg+"");
		}

	}

	public static void e(String TAG, int msg){
		if (LEVEL>=E){
			Log.e(TAG,msg+"");
		}

	}

	public static void e(boolean msg){
		if (LEVEL>=E){
			Log.e(TAG,msg+"");
		}

	}

	public static void e(String TAG, boolean msg){
		if (LEVEL>=E){
			Log.e(TAG,msg+"");
		}
	}

	public static void e(String msg, Throwable tr) {
		if (LEVEL>=E){
			Log.e(TAG, msg, tr);
		}
	}

	public static void e(String TAG, String msg, Throwable tr) {
		if (LEVEL>=E){
			Log.e(TAG, msg, tr);
		}
	}

	public static void e( float msg) {
		if (LEVEL>=E){
			Log.e(TAG,msg+"");
		}
	}

	public static void e(String TAG, float msg) {
		if (LEVEL>=E){
			Log.e(TAG,msg+"");
		}
	}

	public static void e(Exception ex) {
		if (LEVEL>=E&&ex!=null){
			Log.e(TAG,ex.getLocalizedMessage());
		}
	}

	public static void e(String TAG, Exception ex) {
		if (LEVEL>=E&&ex!=null){
			Log.e(TAG,ex.getLocalizedMessage());
		}
	}
}
