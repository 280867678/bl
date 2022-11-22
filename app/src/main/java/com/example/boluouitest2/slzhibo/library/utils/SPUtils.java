package com.example.boluouitest2.slzhibo.library.utils;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;


@SuppressLint({"ApplySharedPref"})
public class SPUtils {
    /* renamed from: b */
    public static final Map<String, SPUtils> f12157b = new HashMap();

    /* renamed from: a */
    public SharedPreferences f12158a;
    public SPUtils(String str, int i) {
        this.f12158a = Utils.m21318c().getSharedPreferences(str, i);
    }


    /* renamed from: c */
    public String m10237c(@NonNull String str) {
        if (str != null) {
            return m10246a(str, "");
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }
    /* renamed from: a */
    public String m10246a(@NonNull String str, String str2) {
        if (str != null) {
            return this.f12158a.getString(str, str2);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }


    /* renamed from: d */
    public static SPUtils m10234d(String str) {
        return m10236c(str, 0);
    }


    /* renamed from: c */
    public static SPUtils m10236c(String str, int i) {
        if (m10233e(str)) {
            str = "spUtils";
        }
        SPUtils mVar = f12157b.get(str);
        if (mVar == null) {
            synchronized (SPUtils.class) {
                mVar = f12157b.get(str);
                if (mVar == null) {
                    mVar = new SPUtils(str, i);
                    f12157b.put(str, mVar);
                }
            }
        }
        return mVar;
    }


    /* renamed from: e */
    public static boolean m10233e(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }




    /* renamed from: a */
    public boolean m10244a(@NonNull String str, boolean z) {
        if (str != null) {
            return this.f12158a.getBoolean(str, z);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }





}
