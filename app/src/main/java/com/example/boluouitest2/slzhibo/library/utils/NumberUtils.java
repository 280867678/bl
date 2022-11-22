package com.example.boluouitest2.slzhibo.library.utils;

import android.text.TextUtils;

public class NumberUtils {

    public static int string2int(String str) {
        return string2int(str, 0);
    }

    public static int string2int(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

}
