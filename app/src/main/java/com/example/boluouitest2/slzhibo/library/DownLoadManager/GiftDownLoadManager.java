package com.example.boluouitest2.slzhibo.library.DownLoadManager;

import com.example.boluouitest2.slzhibo.library.utils.live.AppUtils;
import com.example.boluouitest2.slzhibo.library.utils.live.SimpleRxObserver;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class GiftDownLoadManager {

    public GiftDownLoadManager() {
    }


    /* renamed from: g */
    public static GiftDownLoadManager m4388g() {
        return C4816g.f17626a;
    }

    /* compiled from: GiftDownLoadManager.java */
    /* renamed from: e.t.a.f.k$g */
    /* loaded from: classes2.dex */
    public static class C4816g {

        /* renamed from: a */
        public static final GiftDownLoadManager f17626a = new GiftDownLoadManager(null);
    }
    public /* synthetic */ GiftDownLoadManager(C4810a aVar) {
        this();
    }



    /* compiled from: GiftDownLoadManager.java */
    /* renamed from: e.t.a.f.k$a */
    /* loaded from: classes2.dex */
    public class C4810a extends SimpleRxObserver<List<GiftDownloadItemEntity>> {
        public C4810a() {
        }

        public void accept(List<GiftDownloadItemEntity> list) {
            GiftDownLoadManager.this.m4393d(list);
        }
    }



    /* renamed from: d */
    public final void m4393d(List<GiftDownloadItemEntity> list) {
//        List<GiftDownloadItemEntity> a = m4412a();
//        if (a != null && !a.isEmpty()) {
//            LinkedHashMap linkedHashMap = new LinkedHashMap();
//            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
//            for (GiftDownloadItemEntity giftDownloadItemEntity : a) {
//                linkedHashMap.put(giftDownloadItemEntity.markId, giftDownloadItemEntity);
//            }
//            for (GiftDownloadItemEntity giftDownloadItemEntity2 : list) {
//                if (linkedHashMap.containsKey(giftDownloadItemEntity2.markId)) {
//                    GiftDownloadItemEntity giftDownloadItemEntity3 = (GiftDownloadItemEntity) linkedHashMap.get(giftDownloadItemEntity2.markId);
//                    if (C6014k.m1337i(AppUtils.getLocalGiftFilePath(giftDownloadItemEntity3.giftDirPath))) {
//                        giftDownloadItemEntity2.giftDirPath = giftDownloadItemEntity3.giftDirPath;
//                    }
//                }
//                linkedHashMap2.put(giftDownloadItemEntity2.markId, giftDownloadItemEntity2);
//            }
//            linkedHashMap.clear();
//            a.clear();
//            a.addAll(linkedHashMap2.values());
//            list = a;
//        }
//        m4399b(list);
//        m4396c(list);
    }


    /* renamed from: a */
    public synchronized List<GiftDownloadItemEntity> m4412a() {
//        try {
//            List<GiftDownloadItemDBEntity> b = DBUtils.m1548b(GiftDownloadItemDBEntity.class);
//            if (b == null) {
//                return null;
//            }
//            ArrayList arrayList = new ArrayList();
//            for (GiftDownloadItemDBEntity giftDownloadItemDBEntity : b) {
//                arrayList.add(m4409a(giftDownloadItemDBEntity));
//            }
//            return arrayList;
//        } catch (Exception unused) {
//            return null;
//        }
        return  null;
    }






}
