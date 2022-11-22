package com.example.boluouitest2.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class InputMethodUtil {
    /* renamed from: a */
    public static void m9082a(Context context, View view) {
        ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 2);
    }
}
