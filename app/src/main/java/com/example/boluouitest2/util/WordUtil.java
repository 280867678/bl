package com.example.boluouitest2.util;

import android.text.TextUtils;

import com.example.boluouitest2.comod.baselib.BaseAppContext;

public class WordUtil {

    /* renamed from: a */
    public static String m9085a(int i) {
        return BaseAppContext.m20167a().getString(i);
    }

    /* renamed from: a */
    public static String m9084a(String str) {
        return m9083a(str, "");
    }

    /* renamed from: a */
    public static String m9083a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }











    /* renamed from: a */
    public static String m15774a(String str) {
        return m15775a(str, "");
    }

    /* renamed from: a */
    public static String m15775a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }




}
