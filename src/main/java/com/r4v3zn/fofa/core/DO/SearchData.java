/*
 * Copyright (c) 2019. r4v3zn.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.r4v3zn.fofa.core.DO;

import java.util.List;

/**
 * Title: SearchData
 * Description: this is fofa data
 * Date:2022-05-29 13:07
 * Email:woo0nise@gmail.com
 * Company:fofa.info
 *
 * @author R4v3zn
 * @version 1.0.0
 */
public class SearchData {

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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<List<String>> getResults() {
        return results;
    }

    public void setResults(List<List<String>> results) {
        this.results = results;
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
