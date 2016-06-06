package com.fyj.dependlib.constant;
/**
 * 请求地址集合
 * Created by Fyj on 2016/6/3.
 */
public class HttpInterface {

    public interface History {

        /**
         * 获取某几日干货网站数据:
         * http://gank.io/api/history/content/2/1
         */
        String CONTENT_SOMEDAYS = "http://gank.io/api/history/content/";

        /**
         * 获取特定日期网站数据::
         * http://gank.io/api/history/content/day/2016/05/11
         */
        String CONTENT_SOMEDAY = "http://gank.io/api/history/content/day/";
    }

    public interface Day {

        /**
         * 获取发过干货日期接口:
         * http://gank.io/api/day/history 方式 GET
         */
        String CHOOSE_DAY_LIST = "http://gank.io/api/day/history";

        /**
         * 每日数据:
         * http://gank.io/api/day/2015/08/07 方式 GET
         */
        String DAY_CONTANT = "http://gank.io/api/day/";

    }

    public interface Add {

        /**
         * 支持提交干货到审核区:
         * https://gank.io/api/add2gank 方式: POST
         * url	想要提交的网页地址
         * desc	对干货内容的描述	单独的文字描述
         * who	提交者 ID	干货提交者的网络 ID
         * type	干货类型	可选参数: Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
         * debug	当前提交为测试数据	如果想要测试数据是否合法, 请设置 debug 为 true! 可选参数: true | false
         */
        String ADD_TO_GANK = "https://gank.io/api/add2gank";

    }

    public interface Data {

        /**
         * 支持提交干货到审核区:
         * http://gank.io/api/data/数据类型/请求个数/第几页
         * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
         * 请求个数： 数字，大于0
         * 第几页：   数字，大于0
         */
        String ADD_TO_GANK = "http://gank.io/api/data/";

    }

    public interface Random {

        /**
         * 随机数据:
         * http://gank.io/api/random/data/分类/个数
         * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端
         * 个数：    数字，大于0
         */
        String RANDOM_DATA = "http://gank.io/api/random/data/";

    }

    public interface Web {

        /**
         * 网页:
         * http://gank.io/2016/06/02
         */
        String WEB = "http://gank.io/";

    }
}
