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

package com.r4v3zn.fofa.core.util;

import cn.hutool.core.lang.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Title: HttpUtils
 * Description: HttpUtils
 * Date:2019-06-10 19:10
 * Email:woo0nise@gmail.com
 * Company:www.j2ee.app
 * @author R4v3zn
 * @version 1.0.0
 */
public class HttpUtils {
    /**
     * private
     */
    private HttpUtils(){}

    /**
     * do get
     * @param url requests url
     * @return response info
     */
    public static String doGet(String url){
        return doGet(url,null);
    }

    /**
     * do get
     * @param actionUrl requests url
     * @param map requests param
     * @return response info
     */
    public static  String doGet(String actionUrl,Map<String,Object> map) {
        String result = "";
        try {
            if(map != null && map.size() > 0){
                actionUrl += "?";

                StringBuilder actionUrlBuilder = new StringBuilder(actionUrl);
                for (String key: map.keySet()) {
                    actionUrlBuilder.append(key).append("=")
                            .append(URLEncoder.encode(map.get(key).toString(), "UTF-8")).append("&");
                }
                actionUrl = actionUrlBuilder.toString();
            }
            URL url = new URL(actionUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = null;
            if(HttpURLConnection.HTTP_OK == connection.getResponseCode()){
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            }else{
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), StandardCharsets.UTF_8));
            }
            StringBuilder s = new StringBuilder();
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                s.append(temp);
            }
            result = s.toString();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
