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

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

/**
 * Title: Base64Utils
 * Descrption: TODO
 * Date:2019-06-08 17:52
 * Email:woo0nise@gmail.com
 * Company:www.j2ee.app
 *
 * @author R4v3zn
 * @version 1.0.0
 */
public class Base64Utils {

    private Base64Utils(){}

    /**
     * encode
     * @param str need encode str
     * @return encode result
     */
    public static String encode(String str){
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            new BASE64Encoder().encode(b);
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    /**
     * decode
     * @param str need decode str
     * @return decode result
     */
    public static String decode(String str){
        byte[] b = null;
        String result = null;
        if (str != null && str != "") {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(str);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Test
     * @param args
     */
    public static void main(String[] args) {
        String encodeStr = encode("app=\"Solr\"");
        System.out.println(encodeStr);
        System.out.println(decode(encodeStr));
    }
}
