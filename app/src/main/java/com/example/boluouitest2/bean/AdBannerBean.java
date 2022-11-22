package com.example.boluouitest2.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class AdBannerBean implements Parcelable {

    public static final Parcelable.Creator<AdBannerBean> CREATOR = new Parcelable.Creator<AdBannerBean>() { // from class: com.comod.baselib.bean.AdBannerBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdBannerBean createFromParcel(Parcel parcel) {
            return new AdBannerBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdBannerBean[] newArray(int i) {
            return new AdBannerBean[i];
        }
    };

    /* renamed from: id */
    public int f1517id;
    public String img_url;
    public String title;
    public int type;
    public String url;
    public String value;

    public AdBannerBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return this.f1517id;
    }

    public String getImgUrl() {
        return this.img_url;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getValue() {
        return this.value;
    }

    public void setId(int i) {
        this.f1517id = i;
    }

    public void setImgUrl(String str) {
        this.img_url = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1517id);
        parcel.writeString(this.title);
        parcel.writeString(this.img_url);
        parcel.writeString(this.url);
        parcel.writeInt(this.type);
        parcel.writeString(this.value);
    }

    public AdBannerBean(Parcel parcel) {
        this.f1517id = parcel.readInt();
        this.title = parcel.readString();
        this.img_url = parcel.readString();
        this.url = parcel.readString();
        this.type = parcel.readInt();
        this.value = parcel.readString();
    }


}
