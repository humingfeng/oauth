package com.humingfeng.util;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
*@ClassName     JsonUtils
*@description   Json工具类
*@author        胡铭锋
*@Date          2018/9/24 22:08
*@Version       1.0
**/
public class JsonUtils {

    /**
     * 对象转化成json字符串
     * @param object
     * @return
     */
    public static String objectToJson(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     *  将json结果集转化为对象
     * @param jsonData
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> clazz) {
        return JSON.parseObject(jsonData, clazz);
    }

    /**
     * json字符串转LIST
     * @param jsonData
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> clazz){

        return JSON.parseArray(jsonData, clazz);

    }




}