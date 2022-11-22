package com.example.boluouitest2.util;

public class ApiUrlUtil {
    public static String m9219a(String str) {
        if (str.startsWith("/")) {
            return str;
        }
        return "/" + str;
    }

}
