package com.example.boluouitest2.slzhibo.library.DownLoadManager;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class GiftBatchItemEntity implements Serializable {
    public int active_time;
    public String animalUrl;
    public String desc;
    public int duration;
    public int num;

    public GiftBatchItemEntity() {
    }

    public String toString() {
        return "GiftBatchItemEntity{desc='" + this.desc + "', num=" + this.num + '}';
    }

    public GiftBatchItemEntity(String str, int i) {
        this.desc = str;
        this.num = i;
    }
}
