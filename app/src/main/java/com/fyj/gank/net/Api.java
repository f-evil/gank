package com.fyj.gank.net;

import com.fyj.dependlib.constant.HttpInterface;
import com.fyj.gank.GankApp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建网络拦截器
 * 初始化okhttp
 * !!!!!!!!!单例!!!!!!!!
 * Created by Fyj on 2016/6/8.
 */
public class Api {

    private static final String DATE_FORMAT="yyyy-MM-dd'T'HH:mm:ssZ";
    private static final int TIME_OUT =5000;

    public Retrofit retrofit;

    public ApiService mApiService;

    Interceptor mInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder().addHeader("Content-Type", "application/json").build());
        }
    };

    private static class SingletonInstance{
        private static final Api INSTANCE=new Api();
    }

    public static Api getInstance(){
        return SingletonInstance.INSTANCE;
    }

    private Api() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        File cacheFile = new File(GankApp.getAppContext().getCacheDir(), "gank_web_cache");
        Cache mCache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb

        OkHttpClient mOkHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(mInterceptor)
                .addInterceptor(interceptor)
                .addNetworkInterceptor(new HttpCacheIntercepter())
                .cache(mCache)
                .build();

        Gson gson=new GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .serializeNulls()
                .create();

        retrofit=new Retrofit.Builder()
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(HttpInterface.BASE_NIUPAI_URL)
                .build();

        mApiService=retrofit.create(ApiService.class);
    }

}
