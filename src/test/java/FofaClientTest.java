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

import com.r4v3zn.fofa.core.client.FofaClient;

import java.io.*;
import java.util.Base64;

/**
 * Title: FofaClientTest
 * Descrption: TODO
 * Date:2019-06-08 13:38
 * Email:woo0nise@gmail.com
 * Company:www.j2ee.app
 *
 * @author R4v3zn
 * @version 1.0.0
 */
public class FofaClientTest {
    public static void main(String[] args) throws Exception {
        // FOFA Pro email
        String email = "xxx";
        // FOFA Pro key
        String key = "xxx";
        String q = "app=\"Solr\"";
        FofaClient client = new FofaClient(email, key);
        System.out.println(client.getData(q));
    }
}