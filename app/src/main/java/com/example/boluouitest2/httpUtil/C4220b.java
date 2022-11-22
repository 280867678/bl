package com.example.boluouitest2.httpUtil;

import android.util.Log;

import com.example.boluouitest2.bean.ResponseJsonBean;
import com.example.boluouitest2.util.SpUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.PostRequest;

import okhttp3.OkHttpClient;

public class C4220b {

    /* renamed from: b */
    public static C4220b f12973b;

    /* renamed from: a */
    public OkHttpClient f12974a;

    /* renamed from: b */
    public static C4220b m9794b() {
        if (f12973b == null) {
            synchronized (C4220b.class) {
                if (f12973b == null) {
                    f12973b = new C4220b();
                }
            }
        }
        return f12973b;
    }



    /* renamed from: b */
    public PostRequest<ResponseJsonBean> m9793b(String str, String str2) {
        return m9792b(m9798a(), str, str2);
    }


    /* renamed from: b */
    public PostRequest<ResponseJsonBean> m9792b(String str, String str2, String str3) {
        Log.e("C4220b:41:base_url--->" , str + str2);
        return (PostRequest) OkGo.post(str + str2).tag(str3);
    }


    /* renamed from: a */
    public final String m9798a() {
        return SpUtil.m9573D().m9542f();
    }








    /* renamed from: a */
    public GetRequest<ResponseJsonBean> m9796a(String str, String str2) {
        return m9795a(m9798a(), str, str2);
    }


    /* renamed from: a */
    public GetRequest<ResponseJsonBean> m9795a(String str, String str2, String str3) {
        Log.e("base_url--->" , str);
        return (GetRequest) OkGo.get(str + str2).tag(str3);
    }


    /* renamed from: a */
    public void m9797a(String str) {
        OkGo.cancelTag(this.f12974a, str);
    }

}
