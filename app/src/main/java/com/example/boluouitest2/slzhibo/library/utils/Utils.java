package com.example.boluouitest2.slzhibo.library.utils;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Utils {
    /* renamed from: c */
    public static Application f327c;
    /* renamed from: a */
    public static final C0585a f325a = new C0585a();
    /* renamed from: b */
    public static final Handler f326b = new Handler(Looper.getMainLooper());

    /* renamed from: com.blankj.utilcode.util.Utils$a */
    /* loaded from: classes.dex */
    public static class C0585a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: b */
        public final LinkedList<Activity> f328b = new LinkedList<>();

        /* renamed from: c */
        public final Map<Object, AbstractC0588c> f329c = new HashMap();

        /* renamed from: d */
        public final Map<Activity, Set<AbstractC0587b>> f330d = new HashMap();

        /* renamed from: e */
        public int f331e = 0;

        /* renamed from: f */
        public int f332f = 0;

        /* renamed from: g */
        public boolean f333g = false;

        /* renamed from: com.blankj.utilcode.util.Utils$a$a */
        /* loaded from: classes.dex */
        public class RunnableC0586a implements Runnable {

            /* renamed from: b */
            public final /* synthetic */ Activity f334b;

            /* renamed from: c */
            public final /* synthetic */ Object f335c;

            public RunnableC0586a(C0585a aVar, Activity activity, Object obj) {
                this.f334b = activity;
                this.f335c = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f334b.getWindow().setSoftInputMode(((Integer) this.f335c).intValue());
            }
        }

        /* renamed from: a */
        public Activity m21308a() {
            if (!this.f328b.isEmpty()) {
                for (int size = this.f328b.size() - 1; size >= 0; size--) {
                    Activity activity = this.f328b.get(size);
                    if (!(activity == null || activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()))) {
                        return activity;
                    }
                }
            }
            Activity b = m21303b();
            if (b != null) {
                m21302b(b);
            }
            return b;
        }

        /* renamed from: b */
        public final void m21302b(Activity activity) {
            if (!"com.blankj.utilcode.util.PermissionUtils$PermissionActivity".equals(activity.getClass().getName())) {
                if (!this.f328b.contains(activity)) {
                    this.f328b.addLast(activity);
                } else if (!this.f328b.getLast().equals(activity)) {
                    this.f328b.remove(activity);
                    this.f328b.addLast(activity);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            LanguageUtils.m10330a(activity);
            Utils.m21309l();
            m21302b(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            this.f328b.remove(activity);
            m21307a(activity);
            Utils.m21322a(activity.getWindow());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            m21302b(activity);
            if (this.f333g) {
                this.f333g = false;
                m21304a(true);
            }
            m21305a(activity, false);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (!this.f333g) {
                m21302b(activity);
            }
            int i = this.f332f;
            if (i < 0) {
                this.f332f = i + 1;
            } else {
                this.f331e++;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (activity.isChangingConfigurations()) {
                this.f332f--;
            } else {
                this.f331e--;
                if (this.f331e <= 0) {
                    this.f333g = true;
                    m21304a(false);
                }
            }
            m21305a(activity, true);
        }

        /* renamed from: b */
        public final Activity m21303b() {
            Map map = null;
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivityList");
                declaredField.setAccessible(true);
                map = (Map) declaredField.get(invoke);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
            if (map == null) {
                return null;
            }
            for (Object obj : map.values()) {

                try {
                    Class<?> cls2 = obj.getClass();
                    Field declaredField2 = cls2.getDeclaredField("paused");
                    declaredField2.setAccessible(true);
                    if (!declaredField2.getBoolean(obj)) {
                        Field declaredField3 = cls2.getDeclaredField("activity");
                        declaredField3.setAccessible(true);
                        return (Activity) declaredField3.get(obj);
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }

        /* renamed from: a */
        public void m21306a(Activity activity, AbstractC0587b bVar) {
            Set<AbstractC0587b> set;
            if (activity != null && bVar != null) {
                if (!this.f330d.containsKey(activity)) {
                    set = new HashSet<>();
                    this.f330d.put(activity, set);
                } else {
                    set = this.f330d.get(activity);
                    if (set.contains(bVar)) {
                        return;
                    }
                }
                set.add(bVar);
            }
        }

        /* renamed from: a */
        public final void m21305a(Activity activity, boolean z) {
            if (z) {
                activity.getWindow().getDecorView().setTag(-123, Integer.valueOf(activity.getWindow().getAttributes().softInputMode));
                activity.getWindow().setSoftInputMode(3);
                return;
            }
            Object tag = activity.getWindow().getDecorView().getTag(-123);
            if (tag instanceof Integer) {
                Utils.m21320a(new RunnableC0586a(this, activity, tag), 100L);
            }
        }

        /* renamed from: a */
        public final void m21304a(boolean z) {
            AbstractC0588c next;
            if (!this.f329c.isEmpty()) {
                Iterator<AbstractC0588c> it = this.f329c.values().iterator();
                while (it.hasNext() && (next = it.next()) != null) {
                    if (z) {
                        next.m21301a();
                    } else {
                        next.m21300b();
                    }
                }
            }
        }

        /* renamed from: a */
        public final void m21307a(Activity activity) {
            Iterator<Map.Entry<Activity, Set<AbstractC0587b>>> it = this.f330d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Activity, Set<AbstractC0587b>> next = it.next();
                if (next.getKey() == activity) {
                    for (AbstractC0587b bVar : next.getValue()) {
                        bVar.onActivityDestroyed(activity);
                    }
                    it.remove();
                }
            }
        }
    }




    /* renamed from: a */
    public static void m21324a(Application application) {
        if (f327c == null) {
            if (application == null) {
                f327c = m21317d();
            } else {
                f327c = application;
            }
            f327c.registerActivityLifecycleCallbacks(f325a);
        } else if (application != null && application.getClass() != f327c.getClass()) {
            f327c.unregisterActivityLifecycleCallbacks(f325a);
            f325a.f328b.clear();
            f327c = application;
            f327c.registerActivityLifecycleCallbacks(f325a);
        }
    }

    /* renamed from: d */
    public static Application m21317d() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            if (invoke != null) {
                return (Application) invoke;
            }
            throw new NullPointerException("u should init first");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            throw new NullPointerException("u should init first");
        }
    }




    /* renamed from: com.blankj.utilcode.util.Utils$c */
    /* loaded from: classes.dex */
    public interface AbstractC0588c {
        /* renamed from: a */
        void m21301a();

        /* renamed from: b */
        void m21300b();
    }

    /* renamed from: com.blankj.utilcode.util.Utils$b */
    /* loaded from: classes.dex */
    public interface AbstractC0587b {
        void onActivityDestroyed(Activity activity);
    }



    /* renamed from: c */
    public static Application m21318c() {
        Application application = f327c;
        if (application != null) {
            return application;
        }
        Application d = m21317d();
        m21324a(d);
        return d;
    }


    /* renamed from: i */
    public static SPUtils m21312i() {
        return SPUtils.m10234d("Utils");
    }



    /* renamed from: l */
    public static void m21309l() {
        if (Build.VERSION.SDK_INT < 26 || !ValueAnimator.areAnimatorsEnabled()) {
            try {
                @SuppressLint("SoonBlockedPrivateApi") Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                declaredField.setAccessible(true);
                if (((Float) declaredField.get(null)).floatValue() == 0.0f) {
                    declaredField.set(null, Float.valueOf(1.0f));
                    Log.i("Utils", "setAnimatorsEnabled: Animators are enabled now!");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m21322a(Window window) {
        InputMethodManager inputMethodManager = (InputMethodManager) m21318c().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            for (String str : new String[]{"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"}) {
                try {
                    Field declaredField = InputMethodManager.class.getDeclaredField(str);
                    if (declaredField != null) {
                        if (!declaredField.isAccessible()) {
                            declaredField.setAccessible(true);
                        }
                        Object obj = declaredField.get(inputMethodManager);
                        if ((obj instanceof View) && ((View) obj).getRootView() == window.getDecorView().getRootView()) {
                            declaredField.set(inputMethodManager, null);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }






    /* renamed from: a */
    public static void m21320a(Runnable runnable, long j) {
        f326b.postDelayed(runnable, j);
    }





}
