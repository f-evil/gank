package com.fyj.gank.net;

import com.fyj.gank.bean.DataHistoryBean;
import com.fyj.gank.bean.HistoryBean;
import com.fyj.gank.bean.SearchBean;
import com.fyj.gank.bean.SingleTypeBean;

import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * gank api
 * Created by Fyj on 2016/6/8.
 */
public interface ApiService {


    /**
     * 获取某几日干货网站数据:
     * http://gank.io/api/history/content/2/1
     *
     * @param data 时间
     * @return json对象
     */
    @GET("history/content/{date}")
    Observable<HistoryBean> getNoControlHistory(@Path("date") String data);

    /**
     * 获取特定日期干货网站数据:
     * http://gank.io/api/history/content/day/2016/05/11
     *
     * @param data 时间
     * @return json对象
     */
    @GET("history/content/day/{date}")
    Observable<HistoryBean> getSingleHistory(@Path("date") String data);

    /**
     * 获取发过干货日期接口:
     * http://gank.io/api/day/history 方式 GET
     *
     * @return json对象
     */
    @GET("day/history")
    Observable<DataHistoryBean> getDataHistory();

    /**
     * 每日数据:
     * http://gank.io/api/day/2015/08/07 方式 GET
     *
     * @return json对象
     */
    @GET("day/{date}")
    Observable<String> getSingleData(@Path("date") String data);

    /**
     * 分类数据:
     * http://gank.io/api/data/数据类型/请求个数/第几页
     * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * 请求个数： 数字，大于0
     * 第几页：   数字，大于0
     *
     * @return json对象
     */
    @GET("data/{type}/{count}/{page}")
    Observable<SingleTypeBean> getSingleTypeData(@Path("type") String type, @Path("count") String count, @Path("page") String page);

    /**
     * 随机数据:
     * http://gank.io/api/random/data/分类/个数
     * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端
     * 个数：    数字，大于0
     *
     * @return json对象
     */
    @GET("random/data/{type}/{count}")
    Observable<SingleTypeBean> getRandomData(@Path("data") String data, @Path("count") String count);

    /**
     * 搜索
     * http://gank.io/api/search/query/listview/category/Android/count/10/page/1
     * category 后面可接受参数 all | Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
     * count 最大 50
     *
     * @return json对象
     */
    @GET("search/query/listview/category/{type}/count/{count}/page/{page}")
    Observable<SearchBean> getSearchData(@Path("type") String type, @Path("count") String count, @Path("page") String page);

}
