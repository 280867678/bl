package com.example.boluouitest2.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class HomeTabItem implements Parcelable {


    public static final Parcelable.Creator<HomeTabItem> CREATOR = new Parcelable.Creator<HomeTabItem>() { // from class: com.blmvl.blvl.bean.HomeTabItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HomeTabItem createFromParcel(Parcel parcel) {
            return new HomeTabItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HomeTabItem[] newArray(int i) {
            return new HomeTabItem[i];
        }
    };
    public String api;
    public boolean current;

    /* renamed from: id */
    public int f1041id;
    public String name;
    public String params;
    public String type;

    public HomeTabItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getApi() {
        return this.api;
    }

    public int getId() {
        return this.f1041id;
    }

    public String getName() {
        return this.name;
    }

    public String getParams() {
        return this.params;
    }

    public String getType() {
        return this.type;
    }

    public boolean isCurrent() {
        return this.current;
    }

    public void setApi(String str) {
        this.api = str;
    }

    public void setCurrent(boolean z) {
        this.current = z;
    }

    public void setId(int i) {
        this.f1041id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setParams(String str) {
        this.params = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.current ? (byte) 1 : (byte) 0);
        parcel.writeString(this.name);
        parcel.writeInt(this.f1041id);
        parcel.writeString(this.api);
        parcel.writeString(this.type);
        parcel.writeString(this.params);
    }

    public HomeTabItem(Parcel parcel) {
        this.current = parcel.readByte() != 0;
        this.name = parcel.readString();
        this.f1041id = parcel.readInt();
        this.api = parcel.readString();
        this.type = parcel.readString();
        this.params = parcel.readString();
    }



}
