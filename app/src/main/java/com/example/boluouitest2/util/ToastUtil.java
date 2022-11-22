package com.example.boluouitest2.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.boluouitest2.comod.baselib.BaseAppContext;

public class ToastUtil {

    /* renamed from: a */
    public static void m9106a(Context context, int i) {
        m9102c(context, context.getResources().getString(i));
    }


    /* renamed from: c */
    public static void m9102c(Context context, CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m9103b(context, charSequence);
        }
    }

    /* renamed from: b */
    public static void m9103b(Context context, CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        Toast.makeText(context, charSequence, Toast.LENGTH_LONG).show();
//        CustomToast.m9065a(context, charSequence, 0).show();
    }






    /* renamed from: a */
    public static void m9104a(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m9103b(BaseAppContext.m20167a(), charSequence);
        }
    }



}
