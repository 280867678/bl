package com.example.boluouitest2.slzhibo.library.model;


import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.example.boluouitest2.slzhibo.library.utils.NumberUtils;

import java.util.List;

/* loaded from: classes2.dex */
public class UserEntity extends BaseUserEntity implements Comparable<UserEntity>, Parcelable {
    public static final Parcelable.Creator<UserEntity> CREATOR = new Parcelable.Creator<UserEntity>() { // from class: com.slzhibo.library.model.UserEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserEntity createFromParcel(Parcel parcel) {
            return new UserEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserEntity[] newArray(int i) {
            return new UserEntity[i];
        }
    };
    public List<String> followTargetIds;
    public String inBanGroup;
    public String isBanPost;
    public String isNewUser;
    public String isRisk;
    public String isSuperAdmin;
    public String liveAdminBanPost;
    public List<String> markUrls;
    public String offlinePrivateMessageFlag;
    public String partDrawNumber;
    public List<String> shieldTargetIds;
    public String staySeconds;
    public String token;
    public String type;

    public UserEntity() {
        this.isRisk = "";
    }

    @Override // com.slzhibo.library.model.BaseUserEntity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getExpGrade() {
        return this.expGrade;
    }

    public List<String> getFollowTargetIds() {
        return this.followTargetIds;
    }

    public int getGuardType() {
        return NumberUtils.string2int(this.guardType);
    }

    public String getIsRisk() {
        return this.isRisk;
    }

    public String getLiveId() {
        return this.liveId;
    }

    public String getLiveStatus() {
        return this.liveStatus;
    }

    public String getLiveStaySeconds() {
        return this.staySeconds;
    }

    public List<String> getMarkUrls() {
        return this.markUrls;
    }

    public String getName() {
        return this.name;
    }

    public int getNobilityType() {
        return this.nobilityType;
    }

    public String getOpenId() {
        return this.openId;
    }

    public int getPartHdLotteryCount() {
        if (TextUtils.isEmpty(this.partDrawNumber)) {
            return 0;
        }
        return NumberUtils.string2int(this.partDrawNumber);
    }

    public String getRole() {
        return this.role;
    }

    public String getSex() {
        return this.sex;
    }

    public List<String> getShieldTargetIds() {
        return this.shieldTargetIds;
    }

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public int getWeight() {
        if (getNobilityType() == -1) {
            this.nobilityType = 0;
        }
        return (getNobilityType() * 10000) + (getGuardType() * 1000) + NumberUtils.string2int(this.expGrade);
    }

    public boolean isBanPostBoolean() {
        return TextUtils.equals(this.isBanPost, "1");
    }

    public boolean isInBanGroup() {
        return TextUtils.equals(this.inBanGroup, "1");
    }

    public boolean isNewUserBoolean() {
        return TextUtils.equals(this.isNewUser, "1");
    }

    public boolean isOfflinePrivateMsg() {
        return TextUtils.equals(this.offlinePrivateMessageFlag, "1");
    }

    public boolean isSuperAdmin() {
        return TextUtils.equals(this.isSuperAdmin, "1");
    }

    public boolean isSuperBanPost() {
        return TextUtils.equals(this.liveAdminBanPost, "1");
    }

    public boolean isVisitorUser() {
        return TextUtils.equals(this.type, "2");
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setExpGrade(String str) {
        this.expGrade = str;
    }

    public void setFollowTargetIds(List<String> list) {
        this.followTargetIds = list;
    }

    public void setGuardType(int i) {
        this.guardType = String.valueOf(i);
    }

    public void setIsRisk(String str) {
        this.isRisk = str;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setLiveStatus(String str) {
        this.liveStatus = str;
    }

    public void setMarkUrls(List<String> list) {
        this.markUrls = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNobilityType(int i) {
        this.nobilityType = i;
    }

    public void setOpenId(String str) {
        this.openId = str;
    }

    public void setRole(String str) {
        this.role = str;
    }

    public void setSex(String str) {
        this.sex = str;
    }

    public void setShieldTargetIds(List<String> list) {
        this.shieldTargetIds = list;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserRole(String str) {
        this.userRole = str;
    }

    public String toString() {
        return "UserEntity{userId='" + this.userId + "', nickname='" + this.nickname + "', role='" + this.role + "', guardType='" + this.guardType + "', nobilityType=" + this.nobilityType + '}';
    }

    @Override // com.slzhibo.library.model.BaseUserEntity, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.liveAdminBanPost);
        parcel.writeString(this.type);
        parcel.writeString(this.token);
        parcel.writeString(this.inBanGroup);
        parcel.writeString(this.isBanPost);
        parcel.writeString(this.staySeconds);
        parcel.writeString(this.isSuperAdmin);
        parcel.writeString(this.isRisk);
        parcel.writeStringList(this.followTargetIds);
        parcel.writeStringList(this.shieldTargetIds);
        parcel.writeStringList(this.markUrls);
        parcel.writeString(this.isNewUser);
        parcel.writeString(this.offlinePrivateMessageFlag);
        parcel.writeString(this.partDrawNumber);
    }

    public int compareTo(@NonNull UserEntity userEntity) {
        return getWeight() > userEntity.getWeight() ? -1 : 1;
    }

    public UserEntity(Parcel parcel) {
        super(parcel);
        this.isRisk = "";
        this.liveAdminBanPost = parcel.readString();
        this.type = parcel.readString();
        this.token = parcel.readString();
        this.inBanGroup = parcel.readString();
        this.isBanPost = parcel.readString();
        this.staySeconds = parcel.readString();
        this.isSuperAdmin = parcel.readString();
        this.isRisk = parcel.readString();
        this.followTargetIds = parcel.createStringArrayList();
        this.shieldTargetIds = parcel.createStringArrayList();
        this.markUrls = parcel.createStringArrayList();
        this.isNewUser = parcel.readString();
        this.offlinePrivateMessageFlag = parcel.readString();
        this.partDrawNumber = parcel.readString();
    }
}
