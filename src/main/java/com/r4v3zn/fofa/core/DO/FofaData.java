package com.r4v3zn.fofa.core.DO;

import java.util.List;

/**
 * Title: FofaData
 * Descrption: this is fofa datas
 * Date:2019-06-08 17:49
 * Email:woo0nise@gmail.com
 * Company:www.j2ee.app
 *
 * @author R4v3zn
 * @version 1.0.0
 */
public class FofaData {

    /**
     * mode
     */
    private String mode;

    /**
     * current page no
     */
    private Integer page;

    /**
     * total size
     */
    private Integer size;

    /**
     * total page
     */
    private Integer totalPage;

    /**
     * query
     */
    private String query;

    /**
     * results
     */
    private List<List<String>> results;

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public String getMode() {
        return mode;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }

    public List<List<String>> getResults() {
        return results;
    }

    public void setResults(List<List<String>> results) {
        this.results = results;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "FofaData{" +
                "mode='" + mode + '\'' +
                ", page=" + page +
                ", size=" + size +
                ", totalPage=" + totalPage +
                ", query='" + query + '\'' +
                ", results=" + results +
                '}';
    }
}
