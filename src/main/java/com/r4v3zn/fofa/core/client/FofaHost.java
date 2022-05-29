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
import com.r4v3zn.fofa.core.DO.HostData;
import com.r4v3zn.fofa.core.exception.FofaException;
import com.r4v3zn.fofa.core.util.HttpUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.r4v3zn.fofa.core.client.FofaConstants.*;

/**
 * Title: Fofa host
 * Description: this is Fofa host
 * Date:2022-05-29 14:48
 * Email:woo0nise@gmail.com
 * Company:fofa.info
 * @author R4v3zn
 * @version 1.0.0
 */
public class FofaHost {

    /**
     * Jackson mapper
     */
    private final ObjectMapper MAPPER  = new ObjectMapper();

    private FofaClient fofaClient;

    public FofaHost(FofaClient fofaClient){
        this.fofaClient = fofaClient;
    }

    public FofaClient getFofaClient() {
        return fofaClient;
    }

    public void setFofaClient(FofaClient fofaClient) {
        this.fofaClient = fofaClient;
    }

    /**
     * host
     * @param host host
     * @return host data
     * @throws Exception error exception
     */
    public HostData host(String host)throws Exception{
        // check search query
        if(host == null || "".equals(host)) {
            throw new FofaException("host can't be empty");
        }
        String url = BASE_URL + HOST_URI + "/"+host;
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("key", this.fofaClient.getKey());
        map.put("email",this.fofaClient.getEmail());
        String rsp = HttpUtils.doGet(url, map);
        JsonNode node = MAPPER.readTree(rsp);
        JsonNode errorNode = node.get("error");
        if(errorNode != null && errorNode.asBoolean()){
            throw new FofaException(node.get("errmsg").asText());
        }
        HostData hostData = new HostData();
        if (node.get("host") != null){
            hostData.setHost(node.get("host").asText());
        }
        if (node.get("asn") != null){
            hostData.setAsn(node.get("asn").asInt());
        }
        if (node.get("ip") != null){
            hostData.setIp(node.get("ip").asText());
        }
        if (node.get("country_name") != null){
            hostData.setCountryName(node.get("country_name").asText());
        }
        if (node.get("country_code") != null){
            hostData.setCountryCode(node.get("country_code").asText());
        }
        if (node.get("category") != null){
            hostData.setCategory(MAPPER.readValue(node.get("category").toString(), List.class));
        }
        if (node.get("port") != null){
            hostData.setPort(MAPPER.readValue(node.get("port").toString(), List.class));
        }
        if (node.get("product") != null){
            hostData.setProduct(MAPPER.readValue(node.get("product").toString(), List.class));
        }
        if (node.get("protocol") != null){
            hostData.setProtocol(MAPPER.readValue(node.get("protocol").toString(), List.class));
        }
        return hostData;
    }

    public static void main(String[] args) throws Exception {
        String email = "";
        String key = "";
        BASE_URL = "https://fofa.info";
        FofaClient fofaClient = new FofaClient(email, key);
        FofaHost fofaHost = new FofaHost(fofaClient);
        String host = "fofa.info";
        Console.log(fofaHost.host(host));
    }
}
