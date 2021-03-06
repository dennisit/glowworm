/*
* Copyright 360buy
*
*    Licensed under the Apache License, Version 2.0 (the "License");
*    you may not use this file except in compliance with the License.
*    You may obtain a copy of the License at
*
*        http://www.apache.org/licenses/LICENSE-2.0
*
*    Unless required by applicable law or agreed to in writing, software
*    distributed under the License is distributed on an "AS IS" BASIS,
*    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*    See the License for the specific language governing permissions and
*    limitations under the License.
*/
package com.jd.dd.glowworm.deserializer.primary;

import com.jd.dd.glowworm.deserializer.ObjectDeserializer;
import com.jd.dd.glowworm.deserializer.PBDeserializer;

import java.lang.reflect.Type;

public class DoubleArrayDeserializer implements ObjectDeserializer {

    public final static DoubleArrayDeserializer instance = new DoubleArrayDeserializer();

    @Override
    public <T> T deserialize(PBDeserializer deserializer, Type type, boolean needConfirmExist, Object... extraParams) {
        double[] doubles = null;
        try {
            if (needConfirmExist && deserializer.isObjectExist() || !needConfirmExist) {
                doubles = deserializer.scanDoubleArray();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) doubles;
    }
}
