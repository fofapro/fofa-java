package com.r4v3zn.fofa.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: HttpUtils
 * Descrption: HttpUtils
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

                for (String key: map.keySet()) {
                    actionUrl += key + "="+URLEncoder.encode(map.get(key).toString(), "UTF-8")+"&";
                }
            }
            URL url = new URL(actionUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            try {
                //获取URL的响应
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
                String s = "";
                String temp = "";
                while ((temp = reader.readLine()) != null) {
                    s += temp;
                }
                result = s;
                reader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
