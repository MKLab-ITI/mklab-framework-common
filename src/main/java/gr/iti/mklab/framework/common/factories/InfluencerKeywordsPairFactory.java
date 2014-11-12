/*
 * Copyright 2014 stzoannos.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gr.iti.mklab.framework.common.factories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gr.iti.mklab.framework.common.influencers.InfluencerKeywordsPair;

/**
 *
 * @author etzoannos - e.tzoannos@atc.gr
 */
public class InfluencerKeywordsPairFactory {

    static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public static synchronized InfluencerKeywordsPair create(String json) {
        synchronized (gson) {
            InfluencerKeywordsPair pair = gson.fromJson(json, InfluencerKeywordsPair.class);
            return pair;
        }
    }
}


