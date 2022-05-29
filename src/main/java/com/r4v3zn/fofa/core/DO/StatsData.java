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
import java.util.Map;

/**
 * Title: StatsData
 * Description: this is fofa stats data
 * Date:2022-05-29 14:00
 * Email:woo0nise@gmail.com
 * Company:fofa.info
 *
 * @author R4v3zn
 * @version 1.0.0
 */
public class StatsData {

    /**
     * distinct
     */
    private Map<String, Integer> distinct;

    /**
     * aggs
     */
    private Map<String, List<Map<String, Object>>> aggs;

    public Map<String, Integer> getDistinct() {
        return distinct;
    }

    public void setDistinct(Map<String, Integer> distinct) {
        this.distinct = distinct;
    }

    public Map<String, List<Map<String, Object>>> getAggs() {
        return aggs;
    }

    public void setAggs(Map<String, List<Map<String, Object>>> aggs) {
        this.aggs = aggs;
    }

    @Override
    public String toString() {
        return "StatsData{" +
                "distinct=" + distinct +
                ", aggs=" + aggs +
                '}';
    }
}