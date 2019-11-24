package com.example.single_signon.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：nightwalker
 * @date ：Created in 19-11-24 下午12:49
 * @description：存放sessionId
 */
public class MemoryData {
    /**
     * 存放sessionId
     */
    private static Map<String, String> sessionIdMap = new HashMap<>();

    public static Map<String, String> getSessionIdMap() {
        return sessionIdMap;
    }

    public static void setSessionIdMap(Map<String, String> sessionIdMap) {
        MemoryData.sessionIdMap = sessionIdMap;
    }
}
