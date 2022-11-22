package com.example.boluouitest2.slzhibo.library.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Locale;

public class LanguageUtils {

    /* renamed from: a */
    public static void m10330a(@NonNull Activity activity) {
        if (activity != null) {
            String c = Utils.m21312i().m10237c("KEY_LOCALE");
            if (!TextUtils.isEmpty(c)) {
                if ("VALUE_FOLLOW_SYSTEM".equals(c)) {
                    Locale locale = Resources.getSystem().getConfiguration().locale;
                    m10329a(Utils.m21318c(), locale);
                    m10329a(activity, locale);
                    return;
                }
                String[] split = c.split("\\$");
                if (split.length != 2) {
                    Log.e("LanguageUtils", "The string of " + c + " is not in the correct format.");
                    return;
                }
                Locale locale2 = new Locale(split[0], split[1]);
                m10329a(Utils.m21318c(), locale2);
                m10329a(activity, locale2);
                return;
            }
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }





    /* renamed from: a */
    public static void m10329a(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale2 = configuration.locale;
        if (!m10328a(locale2.getLanguage(), locale.getLanguage()) || !m10328a(locale2.getCountry(), locale.getCountry())) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                configuration.setLocale(locale);
                context.createConfigurationContext(configuration);
            } else {
                configuration.locale = locale;
            }
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }



    /* renamed from: a */
    public static boolean m10328a(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }




}
