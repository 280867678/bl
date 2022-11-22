package com.example.boluouitest2.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class IntentUtil {
    /* renamed from: a */
    public static void m9081a(Context context, Class<?> cls) {
        m9080a(context, cls, null);
    }

    /* renamed from: a */
    public static void m9080a(Context context, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(context, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }
}
