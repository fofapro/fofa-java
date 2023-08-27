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
 * FOFA Search next API Entity
 * @author R4v3zn woo0nise@gmail.com
 * @version 1.0.0
 */
public class NextSearchData {

    /**
     * current id
     */
    private String id;

    /**
     * next id
     */
    private String next;

    /**
     * mode
     */
    private String mode;

    /**
     * total size
     */
    private Integer size;

    /**
     * query
     */
    private String query;
    /**
     * results
     */
    private List<List<String>> results;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
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
        return "NextSearchData{" +
                "id='" + id + '\'' +
                ", next='" + next + '\'' +
                ", mode='" + mode + '\'' +
                ", size=" + size +
                ", query='" + query + '\'' +
                ", results=" + results +
                '}';
    }
}