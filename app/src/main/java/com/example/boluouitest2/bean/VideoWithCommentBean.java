package com.example.boluouitest2.bean;



import java.util.List;

/* loaded from: classes.dex */
public class VideoWithCommentBean extends VideoBean {
    public List<VideoCommentBean> comment_list;

    public List<VideoCommentBean> getComment_list() {
        return this.comment_list;
    }

    public void setComment_list(List<VideoCommentBean> list) {
        this.comment_list = list;
    }
}

