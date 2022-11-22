package com.example.boluouitest2.VHDelegate;



import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.boluouitest2.Adapter.CommentReplyAdapter;
import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.bean.VideoCommentBean;
import com.example.boluouitest2.httpUtil.HttpCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.NumberUtil;
import com.example.boluouitest2.util.VipMakerMarkUtil;
import com.makeramen.roundedimageview.RoundedImageView;

/* renamed from: e.c.a.e.h2 */
/* loaded from: classes.dex */
public class VideoCommentReplyVHDelegate extends VHDelegateImpl<VideoCommentBean> implements View.OnClickListener {

    /* renamed from: g */
    public RoundedImageView f12432g;

    /* renamed from: h */
    public ImageView f12433h;

    /* renamed from: i */
    public TextView f12434i;

    /* renamed from: j */
    public ImageView f12435j;

    /* renamed from: k */
    public TextView f12436k;

    /* renamed from: l */
    public TextView f12437l;

    /* renamed from: m */
    public ImageView f12438m;

    /* renamed from: n */
    public TextView f12439n;

    /* renamed from: o */
    public LinearLayout f12440o;

    /* renamed from: p */
    public CommentReplyAdapter f12441p;

    /* renamed from: q */
    public VideoBean f12442q;

    public VideoCommentReplyVHDelegate(CommentReplyAdapter commentReplyAdapter, VideoBean videoBean) {
        this.f12441p = commentReplyAdapter;
        this.f12442q = videoBean;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_video_comment_reply;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (view.getId() == R.id.linear_like) {
                if (m9230c().isHasLike()) {
                    m9230c().setHasLike(false);
                    int likes = m9230c().getLikes();
                    if (likes > 0) {
                        m9230c().setLikes(likes - 1);
                    }
                } else {
                    m9230c().setHasLike(true);
                    m9230c().setLikes(m9230c().getLikes() + 1);
                }
                this.f12441p.notifyItemChanged(m9229d());
                HttpUtil.m9782a(m9230c().getId(), new HttpCallback());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        this.f12432g = (RoundedImageView) view.findViewById(R.id.img_avatar);
        this.f12433h = (ImageView) view.findViewById(R.id.image_vip);
        this.f12434i = (TextView) view.findViewById(R.id.tv_name);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_sex);
        this.f12435j = (ImageView) view.findViewById(R.id.image_worker);
        this.f12436k = (TextView) view.findViewById(R.id.tv_time);
        this.f12437l = (TextView) view.findViewById(R.id.tv_context);
        this.f12438m = (ImageView) view.findViewById(R.id.image_like);
        this.f12439n = (TextView) view.findViewById(R.id.text_like_num);
        this.f12440o = (LinearLayout) view.findViewById(R.id.linear_like);
        this.f12440o.setOnClickListener(this);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(VideoCommentBean videoCommentBean, int i) {
        super.mo9233a( videoCommentBean, i);
        if (videoCommentBean != null) {
            try {
                if (videoCommentBean.getUser() != null) {
                    this.f12434i.setText(CustomWordUtil.m9462a(videoCommentBean.getUser().getNickname()));
                    ImgLoader.m9426b(m9232b(), CustomWordUtil.m9462a(videoCommentBean.getUser().getThumb()), this.f12432g);
                    if (this.f12442q.getUser().getUid() == videoCommentBean.getUser().getUid()) {
                        this.f12435j.setVisibility(View.VISIBLE);
                    } else {
                        this.f12435j.setVisibility(View.INVISIBLE);
                    }
                    VipMakerMarkUtil.m9496a(this.f12433h, videoCommentBean.getUser());
                }
                this.f12437l.setText(CustomWordUtil.m9462a(videoCommentBean.getComment()));
                if (videoCommentBean.getLikes() > 0) {
                    this.f12439n.setText(NumberUtil.m9067a(videoCommentBean.getLikes(), 2));
                } else {
                    this.f12439n.setText(m9232b().getString(R.string.str_like_action));
                }
                this.f12436k.setText(CustomWordUtil.m9462a(videoCommentBean.getCreatedAt()));
                if (videoCommentBean.isHasLike()) {
                    this.f12438m.setImageResource(R.mipmap.icon_like_checked);
                } else {
                    this.f12438m.setImageResource(R.mipmap.icon_like_gray);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

