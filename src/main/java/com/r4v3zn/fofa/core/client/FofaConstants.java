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

import java.util.Arrays;
import java.util.List;

/**
 * Title: FofaConstants
 * Description: this is FOFA Pro client
 * Date:2022-05-29 13:07
 * Email:woo0nise@gmail.com
 * Company:fofa.info
 * @author R4v3zn
 * @version 1.0.0
 */
public abstract class FofaConstants {
    /**
     * Base FOFA Pro
     */
    public static String BASE_URL = "https://fofa.info";

    /**
     * get user info uri
     */
    public static String GET_USER_INFO_URI = "/api/v1/info/my";

    /**
     * search all uri
     */
    public static String SEARCH_ALL_URI = "/api/v1/search/all";

    /**
     * search stats uri
     */
    public static String SEARCH_STATS_URI = "/api/v1/search/stats";

    /**
     * search next uri
     */
    public static String SEARCH_NEXT_URI = "/api/v1/search/next";

    /**
     * host uri
     */
    public static String HOST_URI = "/api/v1/host/";
    /**
     * search all max size
     */
    public static Integer SEARCH_MAX_SIZE = 10000;

    /**
     * search all full default of value
     */
    public static Boolean SEARCH_FULL_DEFAULT_VALUE = false;

    /**
     * search all page default of value
     */
    public static Integer SEARCH_ALL_PAGE_DEFAULT_VALUE = 1;

    /**
     * search all size default of value
     */
    public static Integer SEARCH_SIZE_DEFAULT_VALUE = 10000;

    /**
     * query field contains cert and banner default
     */
    public static Integer SEARCH_CERT_OR_BANNER_DEFAULT_VALUE = 2000;

    /**
     * query field contains body default
     */
    public static Integer SEARCH_BODY_DEFAULT_VALUE = 500;

    /**
     * query field contains cert and banner max
     */
    public static Integer SEARCH_CERT_OR_BANNER_MAX_SIZE = 2000;

    /**
     * query field contains cert and banner max
     */
    public static Integer SEARCH_BODY_MAX_SIZE = 500;

    /**
     * search all fields default of value
     */
    public static String[] SEARCH_FIELDS_DEFAULT_VALUE = new String[]{"host"};

    /**
     * search stats fields default of value
     */
    public static String[] SEARCH_STATS_FIELDS_DEFAULT_VALUE = new String[]{"country"};

    /**
     * search all fields list
     */
    public static List<String> SEARCH_ALL_FIELDS_LIST = Arrays.asList("host","title","ip","domain","port","country", "province",
            "city","country_name","header","protocol","banner","cert","isp","as_number", "as_organization", "latitude",
            "longitude", "region", "os", "server", "body", "icp", "jarm", "structinfo", "cname");


    /**
     * search stats fields list
     */
    public static List<String> SEARCH_STATS_FIELDS_LIST = Arrays.asList("protocol", "domain", "port", "title", "os", "server", "country");
}