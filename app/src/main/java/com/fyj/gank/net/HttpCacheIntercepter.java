package com.fyj.gank.net;

import com.fyj.dependlib.utils.NetWorkUtil;
import com.fyj.gank.GankApp;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * cache拦截器
 * Created by Fyj on 2016/6/13.
 */
class HttpCacheIntercepter implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        if (!NetWorkUtil.isNetConnected(GankApp.getAppContext())) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }

        Response response = chain.proceed(request);
        if (NetWorkUtil.isNetConnected(GankApp.getAppContext())) {
            String cahceControl = request.cacheControl().toString();
            return response.newBuilder()
                    .header("Cache-Control", cahceControl)
                    .removeHeader("Pragma")
                    .build();
        } else {
            return response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                    .removeHeader("Pragma")
                    .build();
        }
    }
}
