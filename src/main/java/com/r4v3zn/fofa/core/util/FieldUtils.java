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

import com.r4v3zn.fofa.core.exception.FofaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title: FieldUtils
 * Description: this is fofa data
 * Date:2022-05-29 14:14
 * Email:woo0nise@gmail.com
 * Company:fofa.info
 *
 * @author R4v3zn
 * @version 1.0.0
 */
public class FieldUtils {

    /**
     * check field
     * @param fieldList white list
     * @param fields fields
     * @throws FofaException error exception
     */
    public static void checkField(List<String> fieldList, String... fields) throws FofaException {
        List<String> splitList = Arrays.asList(fields);
        splitList = new ArrayList<String>(splitList);
        splitList.removeAll(fieldList);
        if(splitList.size() > 0){
            throw new FofaException(splitList+" not's fields,please delete that");
        }
    }
}
