package com.fyj.gank.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Fyj on 2016/6/13.
 */
public class SingleTypeBean implements Serializable {

    /**
     * error : false
     * results : [{"_id":"575e1faf421aa93009aa647f","createdAt":"2016-06-13T10:51:27.941Z","desc":"水平的滑轮","publishedAt":"2016-06-13T11:38:17.247Z","source":"chrome","type":"Android","url":"https://github.com/shchurov/HorizontalWheelView","used":true,"who":"有时放纵"},{"_id":"575e10d1421aa9297197ca89","createdAt":"2016-06-13T09:48:01.845Z","desc":"PinLockView","publishedAt":"2016-06-13T11:38:17.247Z","source":"chrome","type":"Android","url":"https://github.com/aritraroy/PinLockView","used":true,"who":"蒋朋"},{"_id":"575df33e421aa9296bddf5a3","createdAt":"2016-06-13T07:41:50.373Z","desc":"一个支持多种状态的自定义View,可以方便的切换到：加载中视图、错误视图、空数据视图、网络异常视图、内容视图","publishedAt":"2016-06-13T11:38:17.247Z","source":"chrome","type":"Android","url":"https://github.com/qyxxjd/MultipleStatusView","used":true,"who":"大熊"},{"_id":"575df2f2421aa9296bddf5a2","createdAt":"2016-06-13T07:40:34.686Z","desc":"DMGameApp是一款基于3DMGAME的一个游戏门户app","publishedAt":"2016-06-13T11:38:17.247Z","source":"chrome","type":"Android","url":"https://github.com/xiaohaibin/DMGameApp","used":true,"who":"大熊"},{"_id":"575d5d57421aa92969038925","createdAt":"2016-06-12T21:02:15.536Z","desc":"仿照Google+在卡片上滚动显示最新评论的TextSwitcher。","publishedAt":"2016-06-13T11:38:17.247Z","source":"chrome","type":"Android","url":"https://github.com/SumiMakito/AdvancedTextSwitcher","used":true,"who":"Jason"},{"_id":"575d0bcb421aa917a9018526","createdAt":"2016-06-12T15:14:19.851Z","desc":"一种可根据展开是否超出屏幕来判断父控件是否自动滚动的ExpandableLayout","publishedAt":"2016-06-13T11:38:17.247Z","source":"web","type":"Android","url":"https://github.com/SilenceDut/ExpandableLayout","used":true,"who":null},{"_id":"575cb383421aa96b20cafaca","createdAt":"2016-06-12T08:57:39.269Z","desc":"滤镜SDK","publishedAt":"2016-06-12T12:04:04.308Z","source":"chrome","type":"Android","url":"https://github.com/Zomato/AndroidPhotoFilters","used":true,"who":"MVP"},{"_id":"575bc54e421aa94333c67783","createdAt":"2016-06-11T16:01:18.858Z","desc":"Default colors and dimens per Material Design guidelines and Android Design guidelines inside one library.","publishedAt":"2016-06-13T11:38:17.247Z","source":"web","type":"Android","url":"https://github.com/DmitryMalkovich/material-design-dimens","used":true,"who":"潇涧"},{"_id":"5757d1a0421aa90ec0cb273b","createdAt":"2016-06-08T16:04:48.304Z","desc":"LoadingDrawable 一些酷炫的加载动画， 可以与任何View配合使用，作为加载动画或者Progressbar, 此外很适合与RecyclerRefreshLayout 配合使用作为刷新的loading 动画","publishedAt":"2016-06-12T12:04:04.308Z","source":"web","type":"Android","url":"https://github.com/dinuscxj/LoadingDrawable","used":true,"who":"郑铉"},{"_id":"5756c258421aa90ec3956a5b","createdAt":"2016-06-07T20:47:20.837Z","desc":"一个可以把数据库存在sdcard的工具","publishedAt":"2016-06-08T12:39:36.270Z","source":"chrome","type":"Android","url":"https://github.com/yaming116/android-sdcard-helper","used":true,"who":"花开堪折枝"}]
     */

    private boolean error;
    /**
     * _id : 575e1faf421aa93009aa647f
     * createdAt : 2016-06-13T10:51:27.941Z
     * desc : 水平的滑轮
     * publishedAt : 2016-06-13T11:38:17.247Z
     * source : chrome
     * type : Android
     * url : https://github.com/shchurov/HorizontalWheelView
     * used : true
     * who : 有时放纵
     */

    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
