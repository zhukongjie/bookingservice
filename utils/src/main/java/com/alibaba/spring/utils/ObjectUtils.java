package com.alibaba.spring.utils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by jack on 2018/3/17.
 */
public class ObjectUtils {

    private ObjectUtils() {
    }

    public static String STRING_EMPTY = "";

    public static boolean isNull(Object obj) {
        return obj == null ? true : false;
    }

    public static boolean nonNull(Object o) {
        return !isNull(o);
    }

    public static <T> boolean isNullOrEmpty(T[] a) {
        return (a == null || a.length == 0) ? true : false;
    }

    public static boolean isNullOrEmpty(Collection<?> list) {
        return (list == null || list.size() == 0) ? true : false;
    }

    public static boolean nonNullOrEmpty(Collection<?> list) {
        return !isNullOrEmpty(list);
    }

    public static boolean isNullOrEmpty(Map<?, ?> map) {
        return (map == null || map.size() == 0) ? true : false;
    }

    public static <T> boolean nonNullOrEmpty(T[] a) {
        return !isNullOrEmpty(a);
    }

    public static boolean nonNullOrEmpty(Map<?, ?> map) {
        return !isNullOrEmpty(map);
    }

    public static boolean equals(CharSequence str1,CharSequence str2){
        return str1!=null&&str1.equals(str2);
    }

    public static boolean equalsIgnoreCase(String str1,String str2){
        return str1!=null&&str1.equalsIgnoreCase(str2);
    }

    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean nonNullOrEmpty(String s) {
        return !isNullOrEmpty(s);
    }

    public static String nullToEmpty(String str) {
        return isNull(str) ? "" : str;
    }

    public static String orElse(String value, String defaultValue) {
        if(isNullOrEmpty(value))
            return defaultValue;
        return value;
    }
}
