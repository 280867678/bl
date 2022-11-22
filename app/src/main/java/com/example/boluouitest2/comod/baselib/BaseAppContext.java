package com.example.boluouitest2.comod.baselib;

import android.app.Activity;
import android.app.Application;

import java.util.Stack;

public class BaseAppContext extends Application {
    /* renamed from: b */
    public static BaseAppContext f1509b;

    /* renamed from: c */
    public static Stack<Activity> f1510c = new Stack<>();

    /* renamed from: a */
    public static BaseAppContext m20167a() {
        return f1509b;
    }


    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f1509b = this;
    }


    /* renamed from: a */
    public void mo20166a(Activity activity) {
        try {
            if (f1510c == null) {
                f1510c = new Stack<>();
            }
            f1510c.add(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }


    /* renamed from: b */
    public void mo20165b(Activity activity) {
        if (activity != null) {
            try {
                if (f1510c != null) {
                    f1510c.remove(activity);
                }
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }


}
