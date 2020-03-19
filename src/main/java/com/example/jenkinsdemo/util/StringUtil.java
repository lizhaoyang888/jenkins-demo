package com.example.jenkinsdemo.util;

import org.apache.logging.log4j.core.util.ArrayUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @Author: lichaoyang
 * @Date: 2020-03-19 23:05
 */
public class StringUtil {
    public static final String NULL = "null";

    public StringUtil() {
    }

    public static boolean isNull(String obj) {
        return obj == null || obj.trim().isEmpty() || obj.trim().toLowerCase().equals("null");
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof String) {
            return isNull((String)obj);
        } else if (obj instanceof Collection) {
            return ((Collection)obj).isEmpty();
        } else if (obj instanceof Map) {
            return ((Map)obj).isEmpty();
        } else if (obj.getClass().isArray()) {
            return ArrayUtils.getLength(obj) == 0;
        } else {
            return false;
        }
    }

    public static boolean isNotNull(String obj) {
        return !isNull(obj);
    }
}