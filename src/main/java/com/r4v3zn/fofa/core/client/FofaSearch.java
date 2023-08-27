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
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Console;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.r4v3zn.fofa.core.DO.NextSearchData;
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
        return this.all(query, page, SEARCH_FIELDS_DEFAULT_VALUE);
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
        return this.all(query, page, getDefaultSize(fields), fields);
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
        return this.all(query, page, size, SEARCH_FULL_DEFAULT_VALUE, fields);
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
        return (SearchData) this.search(query, page, size, null, full, fields);
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


    /**
     * search next (large-scale data)
     * @param query search query
     * @param fields fields
     * @return fofa search result data
     * @throws Exception error exception
     */
    public NextSearchData next(String query, String... fields) throws Exception {
        return this.next(query, "",fields);
    }

    /**
     * search next (large-scale data)
     * @param query search query
     * @param next next id
     * @return fofa search result data
     * @throws Exception error exception
     */
    public NextSearchData next(String query, String next) throws Exception{
        return this.next(query, next, SEARCH_FIELDS_DEFAULT_VALUE);
    }

    /**
     * search next (large-scale data)
     * @param query search query
     * @param next next id
     * @param fields fields
     * @return fofa search result data
     * @throws Exception error exception
     */
    public NextSearchData next(String query, String next, String... fields)throws Exception{
        return this.next(query, getDefaultSize(fields),next,fields);
    }

    /**
     * search next (large-scale data)
     * @param query search query
     * @param size page size
     * @param next next id
     * @param fields fields
     * @return fofa search result data
     * @throws Exception error exception
     */
    public NextSearchData next(String query, Integer size, String next,String... fields) throws Exception {
        return this.next(query, size, next, SEARCH_FULL_DEFAULT_VALUE, fields);
    }

    /**
     * search next (large-scale data)
     * @param query search query
     * @param size page size
     * @param next next id
     * @param full if full data
     * @param fields fields
     * @return fofa search result data
     * @throws Exception error exception
     */
    public NextSearchData next(String query,Integer size,String next,Boolean full, String... fields) throws Exception {
        next = next == null ? "" : next;
        return (NextSearchData) this.search(query, null, size, next, full, fields);
    }

    /**
     * fofa search
     * @param query search query
     * @param page page number
     * @param size page size
     * @param next next search id
     * @param full if full data
     * @param fields fields
     * @return fofa search result data
     * @throws Exception error exception
     */
    public Object search(String query, Integer page, Integer size, String next, Boolean full, String... fields) throws Exception {
        // check page and next
        if (page == null && next == null){
            throw new FofaException("search mode error, neither page nor next id can be null");
        }
        if (page !=null && next != null){
            throw new FofaException("search mode error, neither page nor next id can have a value");
        }
        // check search query
        if(query == null || "".equals(query)){
            throw new FofaException("search query cannot be empty");
        }
        // check page
        if (page != null){
            page = page < 0 ? 1:page;
        }
        // fields
        if (fields == null || fields.length == 0){
            fields = SEARCH_FIELDS_DEFAULT_VALUE;
        }
        // check fields
        checkField(SEARCH_ALL_FIELDS_LIST, fields);
        for (String field:fields) {
            if ((field.equalsIgnoreCase("banner") || field.equalsIgnoreCase("cert")) && size > SEARCH_CERT_OR_BANNER_MAX_SIZE){
                throw new FofaException("contains "+field+" max size "+ SEARCH_CERT_OR_BANNER_MAX_SIZE);
            }
            if (field.equalsIgnoreCase("body") && size > SEARCH_BODY_MAX_SIZE){
                throw new FofaException("contains "+field+" max size "+ SEARCH_BODY_MAX_SIZE);
            }
        }
        // check max size
        if(size > SEARCH_MAX_SIZE){
            throw new FofaException("max size "+ SEARCH_MAX_SIZE);
        }
        // check full is not null
        full = full != null && full;
        String url = BASE_URL;
        if (page != null){
            url += SEARCH_ALL_URI;
        }else{
            url += SEARCH_NEXT_URI;
        }
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("qbase64", encode(query));
        if (page != null){
            map.put("page", page);
        }else {
            map.put("next", next);
        }
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
        SearchData searchData = new SearchData();
        // mode
        if (node.get("mode") != null){
            searchData.setMode(node.get("mode").asText());
        }
        // current page
        if (node.get("page") != null){
            searchData.setPage(node.get("page").asInt());
        }
        // total size
        if (node.get("size") != null){
            searchData.setSize(node.get("size").asInt());
        }
        // total page
        if (searchData.getSize() != null){
            searchData.setTotalPage(searchData.getSize()%size == 0 ? searchData.getSize()/size:searchData.getSize()/size + 1);
        }
        // results
        if (node.get("results") != null){
            List<List<String>> list = MAPPER.readValue(node.get("results").toString(), List.class);
            searchData.setResults(list);
        }
        // query
        if (node.get("query") != null){
            searchData.setQuery(node.get("query").asText());
        }
        if (page != null){
            return searchData;
        }
        NextSearchData nextSearchData = new NextSearchData();
        BeanUtil.copyProperties(searchData, nextSearchData);
        nextSearchData.setId(next);
        if (size > nextSearchData.getResults().size()){
            nextSearchData.setNext("");
        }else if (node.get("next") != null){
            nextSearchData.setNext(node.get("next").asText());
        }
        return nextSearchData;
    }

    /**
     * get default size
     * @param fields fields
     * @return size
     */
    private Integer getDefaultSize(String... fields){
        int size = SEARCH_SIZE_DEFAULT_VALUE;
        if (fields == null){
            return size;
        }
        for (String field:fields) {
            if ((field.equalsIgnoreCase("cert") || field.equalsIgnoreCase("banner")) && size > SEARCH_CERT_OR_BANNER_MAX_SIZE){
                size = SEARCH_CERT_OR_BANNER_DEFAULT_VALUE;
            }
            if (field.equalsIgnoreCase("body") && size > SEARCH_BODY_MAX_SIZE){
                size = SEARCH_BODY_DEFAULT_VALUE;
                break;
            }
        }
        return size;
    }

    public static void main(String[] args) throws Exception {
        String email = "";
        String key = "";
        FofaClient fofaClient = new FofaClient(email, key);
        FofaSearch fofaSearch = new FofaSearch(fofaClient);
        String query = "host=\"fofa.info\"";
        Console.log(fofaSearch.all(query));
        Console.log(fofaSearch.stats(query));
        String next = "";
        do {
            NextSearchData nextSearchData = fofaSearch.next(query, 10, next);
            next = nextSearchData.getNext();
            Console.log(nextSearchData);
        }while (!next.equals(""));
    }
}
