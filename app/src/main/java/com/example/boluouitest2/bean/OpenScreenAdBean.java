package com.example.boluouitest2.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class OpenScreenAdBean implements Parcelable {

    /* renamed from: id */
    public String f1046id;
    public String img_url;
    public String jump_url;
    public String local_path;
    public String name;
    public String type;

    public OpenScreenAdBean() {
    }

    public static final Creator<OpenScreenAdBean> CREATOR = new Creator<OpenScreenAdBean>() {
        @Override
        public OpenScreenAdBean createFromParcel(Parcel in) {
            return new OpenScreenAdBean(in);
        }

        @Override
        public OpenScreenAdBean[] newArray(int size) {
            return new OpenScreenAdBean[size];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.f1046id;
    }

    public String getImg_url() {
        return this.img_url;
    }

    public String getJump_url() {
        return this.jump_url;
    }

    public String getLocal_path() {
        return this.local_path;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public void setId(String str) {
        this.f1046id = str;
    }

    public void setImg_url(String str) {
        this.img_url = str;
    }

    public void setJump_url(String str) {
        this.jump_url = str;
    }

    public void setLocal_path(String str) {
        this.local_path = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.img_url);
        parcel.writeString(this.jump_url);
        parcel.writeString(this.type);
        parcel.writeString(this.local_path);
        parcel.writeString(this.f1046id);
        parcel.writeString(this.name);
    }

    public OpenScreenAdBean(Parcel parcel) {
        this.img_url = parcel.readString();
        this.jump_url = parcel.readString();
        this.type = parcel.readString();
        this.local_path = parcel.readString();
        this.f1046id = parcel.readString();
        this.name = parcel.readString();
    }
}
