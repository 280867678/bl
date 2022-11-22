package com.example.boluouitest2.VHDelegate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;

/* renamed from: e.f.a.b.d */
/* loaded from: classes.dex */
public abstract class VHDelegateImpl<T extends BaseListViewAdapter.C0890c> implements VHDelegate<T> {

    /* renamed from: b */
    public Context f13159b;

    /* renamed from: c */
    public View f13160c;

    /* renamed from: d */
    public T f13161d;

    /* renamed from: e */
    public int f13162e;

    /* renamed from: f */
    public BaseListViewAdapter<T> f13163f;

    /* renamed from: a */
    public View m9234a(ViewGroup viewGroup, BaseListViewAdapter<T> baseListViewAdapter) {
        try {
            this.f13159b = viewGroup.getContext();
//            Log.e("VHDelegateImpl:::","viewGroup.getContext()");
            this.f13163f = baseListViewAdapter;
//            Log.e("VHDelegateImpl:::","baseListViewAdapter");
//            if(this.f13159b == null){
//                Log.e("VHDelegateImpl:::","viewGroup.getContext()空空空");
//            }
//            if(viewGroup == null){
//                Log.e("VHDelegateImpl:::","viewGroup空空空");
//            }
//            if(mo9228e() == 0 ){
//                Log.e("VHDelegateImpl:::","mo9228e() 空空空");
//            }
//            Log.e("VHDelegateImpl:::mo9228e():::", String.valueOf(mo9228e()));
            this.f13160c = LayoutInflater.from(this.f13159b).inflate(mo9228e(), viewGroup, false);
//            Log.e("VHDelegateImpl:::",f13159b.toString());


            return this.f13160c;
        } catch (Exception unused) {
//            Log.e("VHDelegateImpl1:::",unused.getMessage());
//            Log.e("VHDelegateImpl2:::",unused.toString());
            return null;
        }
    }

    /* renamed from: a */
    public void mo9235a(View view, T t, int i) {
    }

    /* renamed from: b */
    public Context m9232b() {
        return this.f13159b;
    }

    /* renamed from: b */
    public boolean m9231b(View view, T t, int i) {
        return false;
    }

    /* renamed from: c */
    public T m9230c() {
        return this.f13161d;
    }

    /* renamed from: d */
    public int m9229d() {
        return this.f13162e;
    }

    /* renamed from: e */
    public abstract int mo9228e();

    /* renamed from: f */
    public View m9227f() {
        return this.f13160c;
    }

    /* renamed from: a */
    public BaseListViewAdapter<T> m9236a() {
        return this.f13163f;
    }

    /* renamed from: a */
    public void mo9233a(T t, int i) {
        this.f13161d = t;
        this.f13162e = i;
    }
}

