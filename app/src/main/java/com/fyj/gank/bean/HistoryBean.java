package com.fyj.gank.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Fyj on 2016/6/13.
 */
public class HistoryBean implements Serializable {

    /**
     * error : false
     * results : [{"_id":"575e2a14421aa93009aa6481","content":" ","publishedAt":"2016-06-13T11:33:00.0Z","title":"快来试试你的耳朵，mp3与无损差别测试~"},{"_id":"575cdecf421aa90d77487f1a","content":" ","publishedAt":"2016-06-12T11:59:00.0Z","title":"8分钟速读《魔兽》电影原著（见休息视频）"}]
     */

    private boolean error;
    /**
     * _id : 575e2a14421aa93009aa6481
     * content :
     * publishedAt : 2016-06-13T11:33:00.0Z
     * title : 快来试试你的耳朵，mp3与无损差别测试~
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
        private String content;
        private String publishedAt;
        private String title;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "_id='" + _id + '\'' +
                    ", content='" + content + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "HistoryBean{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}
