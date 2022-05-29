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

package com.r4v3zn.fofa.core.client;
import cn.hutool.core.lang.Console;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.r4v3zn.fofa.core.DO.SearchData;
import com.r4v3zn.fofa.core.DO.StatsData;
import com.r4v3zn.fofa.core.exception.FofaException;
import com.r4v3zn.fofa.core.util.HttpUtils;
import java.util.*;
import static cn.hutool.core.codec.Base64.encode;
import static com.r4v3zn.fofa.core.client.FofaConstants.*;
import static com.r4v3zn.fofa.core.util.FieldUtils.checkField;

/**
 * Title: Fofa Search
 * Description: this is Fofa Search
 * Date:2022-05-29 13:07
 * Email:woo0nise@gmail.com
 * Company:fofa.info
 * @author R4v3zn
 * @version 1.0.0
 */
public class FofaSearch {

    /**
     * Jackson mapper
     */
    private final ObjectMapper MAPPER  = new ObjectMapper();

    private FofaClient fofaClient;

    public FofaClient getFofaClient() {
        return fofaClient;
    }

    public void setFofaClient(FofaClient fofaClient) {
        this.fofaClient = fofaClient;
    }

    public FofaSearch(FofaClient fofaClient){
        this.fofaClient = fofaClient;
    }

    /**
     * search all
     * <p>
     *     page default 1
     *     size default 10000
     *     full default false
     * </p>
     * @param query search query
     * @param fields search result data
     * @return fofa search result data
     * @throws Exception error exception
     */
    public SearchData all(String query, String... fields) throws Exception {
        return this.all(query, SEARCH_ALL_PAGE_DEFAULT_VALUE, fields);
    }

    /**
     * search all
     * <p>
     *     fields default host
     *     size default 10000
     *     full default false
     * </p>
     * @param query search query
     * @param page page number
     * @return fofa search result data
     * @throws Exception error exception
     */
    public SearchData all(String query, Integer page) throws Exception {
        return this.all(query, page, SEARCH_ALL_FIELDS_DEFAULT_VALUE);
    }


    /**
     * search all
     * <p>
     *     size default 10000
     *     full default false
     * </p>
     * @param query search query
     * @param page page number
     * @param fields fields
     * @return fofa search result data
     * @throws Exception error exception
     */
    public SearchData all(String query, Integer page, String... fields) throws Exception {
        return this.all(query, page, SEARCH_ALL_SIZE_DEFAULT_VALUE, fields);
    }

    /**
     * search all
     * <p>
     *     full default false
     * </p>
     * @param query search query
     * @param page page number
     * @param size page size
     * @param fields fields
     * @return fofa search result data
     * @throws Exception error exception
     */
    public SearchData all(String query, Integer page, Integer size, String... fields)throws Exception{
        return this.all(query, page, size, SEARCH_ALL_FULL_DEFAULT_VALUE, fields);
    }


    /**
     * search all
     * @param query search query
     * @param page page number
     * @param size page size
     * @param full is full data
     * @param fields fields
     * @return fofa search result data
     * @throws Exception error exception
     */
    public SearchData all(String query, Integer page, Integer size, Boolean full, String... fields) throws Exception {
        // check search query
        if(query == null || "".equals(query)){
            throw  new FofaException("search query cannot be empty");
        }
        // check page
        page = page < 0 ? 1:page;
        // check max size
        if(size > SEARCH_ALL_MAX_SIZE){
            throw new FofaException("max size "+ SEARCH_ALL_MAX_SIZE);
        }
        // check full is not null
        full = full != null && full;
        String url = BASE_URL + SEARCH_ALL_URI;
        // fields
        if (fields == null || fields.length == 0){
            fields = SEARCH_ALL_FIELDS_DEFAULT_VALUE;
        }
        // check fields
        checkField(SEARCH_ALL_FIELDS_LIST, fields);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("qbase64", encode(query));
        map.put("page", page);
        map.put("size", size);
        map.put("fields", String.join(",", fields));
        map.put("full",full);
        map.put("key", this.fofaClient.getKey());
        map.put("email",this.fofaClient.getEmail());
        String rsp = HttpUtils.doGet(url, map);
        JsonNode node = MAPPER.readTree(rsp);
        JsonNode errorNode = node.get("error");
        if(errorNode != null && errorNode.asBoolean()){
            throw new FofaException(node.get("errmsg").asText());
        }
        String mode = node.get("mode").asText();
        Integer rspPage = node.get("page").asInt();
        Integer totalSize = node.get("size").asInt();
        String results = node.get("results").toString();
        Integer totalPage = totalSize%size == 0 ? totalSize/size:totalSize/size + 1;
        SearchData searchData = new SearchData();
        searchData.setMode(mode);
        searchData.setPage(rspPage);
        searchData.setSize(totalSize);
        searchData.setQuery(node.get("query").asText());
        searchData.setTotalPage(totalPage);
        List<List<String>> list = MAPPER.readValue(results, List.class);
        searchData.setResults(list);
        return searchData;
    }

    /**
     * stats
     * @param query search query
     * @param fields fields
     * @return fofa stats result data
     * @throws Exception error exception
     */
    public StatsData stats(String query, String... fields) throws Exception {
        // check search query
        if(query == null || "".equals(query)){
            throw  new FofaException("search query cannot be empty");
        }
        if (fields == null || fields.length == 0){
            fields = SEARCH_STATS_FIELDS_DEFAULT_VALUE;
        }
        // check fields
        checkField(SEARCH_STATS_FIELDS_LIST, fields);
        String url = BASE_URL + SEARCH_STATS_URI;
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("qbase64", encode(query));
        map.put("fields", String.join(",", fields));
        map.put("key", this.fofaClient.getKey());
        map.put("email",this.fofaClient.getEmail());
        String rsp = HttpUtils.doGet(url, map);
        JsonNode node = MAPPER.readTree(rsp);
        JsonNode errorNode = node.get("error");
        if(errorNode != null && errorNode.asBoolean()){
            throw new FofaException(node.get("errmsg").asText());
        }
        StatsData statsData = new StatsData();
        statsData.setDistinct(MAPPER.readValue(node.get("distinct").toString(), Map.class));
        statsData.setAggs(MAPPER.readValue(node.get("aggs").toString(), Map.class));
        return statsData;
    }


    public static void main(String[] args) throws Exception {
        String email = "";
        String key = "";
        BASE_URL = "https://fofa.info";
        FofaClient fofaClient = new FofaClient(email, key);
        FofaSearch fofaSearch = new FofaSearch(fofaClient);
        String query = "host=\"fofa.info\"";
        Console.log(fofaSearch.all(query));
        Console.log(fofaSearch.stats(query));
    }
}
