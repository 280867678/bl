package com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;

public abstract class CommonNavigatorAdapter {

    /* renamed from: a */
    public final DataSetObservable f13255a = new DataSetObservable();

    /* renamed from: a */
    public abstract int mo8987a();

    /* renamed from: a */
    public abstract IPagerIndicator mo8986a(Context context);

    /* renamed from: a */
    public abstract IPagerTitleView mo8985a(Context context, int i);

    /* renamed from: a */
    public final void m8984a(DataSetObserver dataSetObserver) {
        this.f13255a.registerObserver(dataSetObserver);
    }

    /* renamed from: b */
    public float mo8982b(Context context, int i) {
        return 1.0f;
    }

    /* renamed from: b */
    public final void m8981b(DataSetObserver dataSetObserver) {
        this.f13255a.unregisterObserver(dataSetObserver);
    }

    /* renamed from: b */
    public final void m8983b() {
        this.f13255a.notifyChanged();
    }
}
