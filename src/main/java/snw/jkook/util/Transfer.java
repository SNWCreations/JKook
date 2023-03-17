/*
 * Copyright 2022 - 2023 JKook contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package snw.jkook.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;

import snw.jkook.JKook;

public class Transfer {
    public static final Map<String, Object> map = new HashMap<>();

    public static void mount(String key, Object value){
        map.put(key, value);
    }

    public static <T> T extract(String value, Class<T> typeOfClass){
        Object object = map.get(value);
        if(object == null) return null;
        return typeOfClass.cast(object);
    }

    public static void close(String value){
        if(map.get(value) == null) return;
        map.remove(value);
    }

    public static void clear(){
        map.clear();
    }

    public static void ls(){
        Logger logger = JKook.getLogger();
        map.entrySet().forEach(l -> {
            String key = l.getKey();
            String value = l.getValue().getClass().getSimpleName();;
            logger.info(
                """
                    [ key: {} ] [ value : {} ]
                    -------------------
                    """,
                key,
                value
            );
        });
    }
}
