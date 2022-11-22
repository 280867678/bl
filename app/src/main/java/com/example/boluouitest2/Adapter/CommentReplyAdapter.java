package com.example.boluouitest2.Adapter;

import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.VHDelegate.VideoCommentReplyVHDelegate;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;
import com.example.boluouitest2.bean.VideoBean;

/* loaded from: classes.dex */
public class CommentReplyAdapter extends BaseListViewAdapter {

    /* renamed from: a */
    public VideoBean f1019a;

    public CommentReplyAdapter(VideoBean videoBean) {
        this.f1019a = videoBean;
    }

    @Override // com.comod.baselib.list.BaseListViewAdapter
    public VHDelegateImpl createVHDelegate(int i) {
        return new VideoCommentReplyVHDelegate(this, this.f1019a);
    }
}
