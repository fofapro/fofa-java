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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.r4v3zn.fofa.core.DO.User;
import com.r4v3zn.fofa.core.DO.UserLogin;
import com.r4v3zn.fofa.core.enmus.UserVipLevelEnum;
import com.r4v3zn.fofa.core.exception.FofaException;
import com.r4v3zn.fofa.core.util.HttpUtils;
import java.util.*;

/**
 * Title: FofaClient
 * Description: this is FOFA Pro client
 * Date:2019-06-07 14:21
 * Email:woo0nise@gmail.com
 * Company:www.j2ee.app
 * @author R4v3zn
 * @version 1.0.0
 */
public class FofaClient {

    /**
     * email
     */
    private String email;

    /**
     * key
     */
    private String key;

    /**
     * Constructor
     * @param email email
     * @param key key
     */
    public FofaClient(String email, String key){
        this.email = email;
        this.key = key;
    }

    /**
     * Jackson mapper
     */
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * getUserLogin
     * @return user login
     */
    public UserLogin getUserLogin(){
        return new UserLogin(email, key);
    }

    /**
     * get user info
     * @throws Exception error
     * @return user info
     */
    public User getUser() throws Exception{
        String loginEmail = this.email;
        String loginKey = this.key;
        // get user
        String url = FofaConstants.BASE_URL + FofaConstants.GET_USER_INFO_URI;
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("email", loginEmail);
        map.put("key", loginKey);
        String rsp = HttpUtils.doGet(url, map);
        JsonNode node = mapper.readTree(rsp);
        JsonNode errorNode = node.get("error");
        if(errorNode != null && errorNode.asBoolean()){
            throw new FofaException(node.get("errmsg").asText());
        }
        String email = node.get("email").asText();
        String userName = node.get("username").asText();
        Integer fCoin = node.get("fcoin").asInt();
        Boolean isVip = node.get("isvip").asBoolean();
        int vipLevel = node.get("vip_level").asInt();
        Boolean isVerified = node.get("is_verified").asBoolean();
        String avatar = node.get("avatar").asText();
        Integer message = node.get("message").asInt();
        String fofacliVersion = node.get("fofacli_ver").asText();
        Boolean fofaServer = node.get("fofacli_ver").asBoolean();
        UserVipLevelEnum vipLevelEnum = vipLevel == 1?UserVipLevelEnum.VIP:UserVipLevelEnum.SVIP;
        return new User(email,userName,fCoin,isVip,vipLevelEnum,isVerified,avatar,message,fofacliVersion, fofaServer);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}