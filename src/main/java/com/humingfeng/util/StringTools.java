package com.humingfeng.util;

/**
*@ClassName     StringTools
*@description   TODO
*@author        胡铭锋
*@Date          2018/9/24 21:51
*@Version       1.0
**/
public class StringTools {

    public static boolean isNullOrEmpty(String str) {
        return null == str || "".equals(str) || "null".equals(str);
    }

    public static boolean isNullOrEmpty(Object obj) {
        return null == obj || "".equals(obj);
    }
}
