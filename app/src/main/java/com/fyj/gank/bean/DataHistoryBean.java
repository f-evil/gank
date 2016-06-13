package com.fyj.gank.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Fyj on 2016/6/13.
 */
public class DataHistoryBean implements Serializable {

    /**
     * error : false
     * results : ["2016-06-13","2016-06-12"]
     */

    private boolean error;
    private List<String> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "DataHistoryBean{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}
