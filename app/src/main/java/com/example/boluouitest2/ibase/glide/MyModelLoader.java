package com.example.boluouitest2.ibase.glide;



import android.content.Context;

import androidx.annotation.Nullable;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

/* renamed from: e.n.a.h */
/* loaded from: classes.dex */
public class MyModelLoader implements ModelLoader<IPicture, InputStream> {

    /* renamed from: a */
    public Context f17160a;

    /* compiled from: MyModelLoader.java */
    /* renamed from: e.n.a.h$a */
    /* loaded from: classes.dex */
    public static class C4713a implements ModelLoaderFactory<IPicture, InputStream> {

        /* renamed from: a */
        public Context f17161a;

        public C4713a(Context context) {
            this.f17161a = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<IPicture, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MyModelLoader(this.f17161a);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    /* compiled from: MyModelLoader.java */
    /* renamed from: e.n.a.h$b */
    /* loaded from: classes.dex */
    public static class C4714b implements DataFetcher<InputStream> {

        /* renamed from: b */
        public IPicture f17162b;

        /* renamed from: c */
        public boolean f17163c;

        /* renamed from: d */
        public InputStream f17164d = null;

        /* renamed from: e */
        public String f17165e;

        public C4714b(IPicture gVar, Context context) {
            this.f17162b = gVar;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.f17163c = true;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            InputStream inputStream = this.f17164d;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
            if (!this.f17163c) {
                if (!C4712a.m4955b().m4959a()) {
                    this.f17165e = this.f17162b.m4949a();
                } else {
                    try {
                        this.f17165e = C4712a.m4955b().m4958a(new File(this.f17162b.m4949a()));
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.f17165e = this.f17162b.m4949a();
                    }
                }
                try {
                    this.f17164d = new FileInputStream(this.f17165e);
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            dataCallback.onDataReady(this.f17164d);
        }
    }

    /* compiled from: MyModelLoader.java */
    /* renamed from: e.n.a.h$c */
    /* loaded from: classes.dex */
    public static class C4715c implements Key {

        /* renamed from: a */
        public IPicture f17166a;

        public C4715c(IPicture gVar) {
            this.f17166a = gVar;
        }

        @Override // com.bumptech.glide.load.Key
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C4715c.class != obj.getClass()) {
                return false;
            }
            IPicture gVar = this.f17166a;
            IPicture gVar2 = ((C4715c) obj).f17166a;
            return gVar != null ? gVar.equals(gVar2) : gVar2 == null;
        }

        @Override // com.bumptech.glide.load.Key
        public int hashCode() {
            IPicture gVar = this.f17166a;
            if (gVar != null) {
                return gVar.hashCode();
            }
            return 0;
        }

        @Override // com.bumptech.glide.load.Key
        public void updateDiskCacheKey(MessageDigest messageDigest) {
            messageDigest.update(this.f17166a.m4949a().getBytes(Key.CHARSET));
        }
    }

    public MyModelLoader(Context context) {
        this.f17160a = context;
    }

    @Nullable
    /* renamed from: a */
    public ModelLoader.LoadData<InputStream> buildLoadData(IPicture gVar, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new C4715c(gVar), new C4714b(gVar, this.f17160a));
    }

    /* renamed from: a */
    public boolean handles(IPicture gVar) {
        return true;
    }
}
