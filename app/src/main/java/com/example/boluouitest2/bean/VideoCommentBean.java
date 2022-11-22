package com.example.boluouitest2.bean;




import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;

import java.util.List;

/* loaded from: classes.dex */
public class VideoCommentBean extends BaseListViewAdapter.C0890c {
    public int cID;
    public List<VideoCommentBean> child;
    public String comment;
    public String createdAt;
    public String createdAtStr;
    public boolean hasLike;

    /* renamed from: id */
    public int f1059id;
    public int likes;
    public int mvID;
    public UserBean user;

    public int getCID() {
        return this.cID;
    }

    public List<VideoCommentBean> getChild() {
        return this.child;
    }

    public String getComment() {
        return this.comment;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getCreatedAtStr() {
        return this.createdAtStr;
    }

    public int getId() {
        return this.f1059id;
    }

    public int getLikes() {
        return this.likes;
    }

    public int getMvID() {
        return this.mvID;
    }

    public UserBean getUser() {
        return this.user;
    }

    public boolean isHasLike() {
        return this.hasLike;
    }

    public void setCID(int i) {
        this.cID = i;
    }

    public void setChild(List<VideoCommentBean> list) {
        this.child = list;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public void setCreatedAtStr(String str) {
        this.createdAtStr = str;
    }

    public void setHasLike(boolean z) {
        this.hasLike = z;
    }

    public void setId(int i) {
        this.f1059id = i;
    }

    public void setLikes(int i) {
        this.likes = i;
    }

    public void setMvID(int i) {
        this.mvID = i;
    }

    public void setUser(UserBean userBean) {
        this.user = userBean;
    }
}

