package com.example.boluouitest2.util;

import android.text.TextUtils;

import com.example.boluouitest2.AppContext;
import com.example.boluouitest2.R;

public class CustomWordUtil {

    /* renamed from: a */
    public static String m9462a(String str) {
        return !TextUtils.isEmpty(str) ? str : "";
    }


    /* renamed from: a */
    public static String m9463a(int i) {
        return AppContext.m21299a().getString(i);
    }





    /* renamed from: b */
    public static String m9461b(String str) {
        return !TextUtils.isEmpty(str) ? str : m9463a((int) R.string.signature_empty_hint);
    }

}
