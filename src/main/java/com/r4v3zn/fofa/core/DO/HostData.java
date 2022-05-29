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
 * Title: StatsData
 * Description: this is fofa host data
 * Date:2022-05-29 14:49
 * Email:woo0nise@gmail.com
 * Company:fofa.info
 *
 * @author R4v3zn
 * @version 1.0.0
 */
public class HostData {

    /**
     * host
     */
    private String host;

    /**
     * ip
     */
    private String ip;

    /**
     * asn
     */
    private Integer asn;

    /**
     * org
     */
    private String org;

    /**
     * country name
     */
    private String countryName;

    /**
     * country code
     */
    private String countryCode;

    /**
     * protocol
     */
    private List<String> protocol;

    /**
     * port
     */
    private List<String> port;

    /**
     * category
     */
    private List<String> category;

    /**
     * product
     */
    private List<String> product;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getAsn() {
        return asn;
    }

    public void setAsn(Integer asn) {
        this.asn = asn;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<String> getProtocol() {
        return protocol;
    }

    public void setProtocol(List<String> protocol) {
        this.protocol = protocol;
    }

    public List<String> getPort() {
        return port;
    }

    public void setPort(List<String> port) {
        this.port = port;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public List<String> getProduct() {
        return product;
    }

    public void setProduct(List<String> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "HostData{" +
                "host='" + host + '\'' +
                ", ip='" + ip + '\'' +
                ", asn=" + asn +
                ", org='" + org + '\'' +
                ", countryName='" + countryName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", protocol=" + protocol +
                ", port=" + port +
                ", category=" + category +
                ", product=" + product +
                '}';
    }
}
