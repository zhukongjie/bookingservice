package com.alibaba.spring.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * Created by jack on 2018/3/17.
 */
public class JsonUtils {

    private JsonUtils() {
    }

    public static String arrayToJsonString(Object object) {
        return JSONArray.toJSONString(object);
    }

    public static String objectToJsonString(Object object) {
        return JSONObject.toJSONString(object);
    }

    public static <T> T parseObject(String text, TypeReference<T> type) {
        return JSON.parseObject(text, type);
    }

    public static <T> T parseObject(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    public static <T> List<T> parseArray(String text, Class<T> clazz){
        return JSON.parseArray(text, clazz);
    }

    public static String objectToJsonString(Object object, SerializeFilter serializeFilter) {
        return JSONArray.toJSONString(object, serializeFilter);
    }

    public static String objectToPrettyJsonString(Object object, SerializeFilter serializeFilter) {
        return JSONArray.toJSONString(object, serializeFilter, SerializerFeature.PrettyFormat, SerializerFeature.WriteDateUseDateFormat);
    }

    public static String objectToJsonString(Object object, SerializerFeature... features){
        return JSONObject.toJSONString(object, features);
    }
}
