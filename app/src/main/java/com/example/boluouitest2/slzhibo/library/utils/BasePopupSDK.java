package com.example.boluouitest2.slzhibo.library.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import java.lang.ref.WeakReference;

public class BasePopupSDK {



    /* renamed from: d */
    public static BasePopupSDK m1815d() {
        return C5937b.f19904a;
    }

    /* compiled from: BasePopupSDK.java */
    /* renamed from: e.t.a.h.f.k.y.a.c$b */
    /* loaded from: classes2.dex */
    public static class C5937b {

        /* renamed from: a */
        public static BasePopupSDK f19904a = new BasePopupSDK(null);
    }

    public /* synthetic */ BasePopupSDK(C5936a aVar) {
        this();
    }

    public BasePopupSDK() {
    }


    /* renamed from: b */
    public static volatile Application f19901b;

    /* renamed from: a */
    public WeakReference<Activity> f19902a;

    /* compiled from: BasePopupSDK.java */
    /* renamed from: e.t.a.h.f.k.y.a.c$a */
    /* loaded from: classes2.dex */
    public class C5936a implements Application.ActivityLifecycleCallbacks {
        public C5936a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (BasePopupSDK.this.f19902a != null) {
                BasePopupSDK.this.f19902a.clear();
            }
            BasePopupSDK.this.f19902a = new WeakReference(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }




    /* renamed from: a */
    public synchronized void m1820a(Context context) {
        if (f19901b == null) {
            f19901b = (Application) context.getApplicationContext();
            m1817b();
        }
    }

    /* renamed from: b */
    public final void m1817b() {
        f19901b.registerActivityLifecycleCallbacks(new C5936a());
    }


}
