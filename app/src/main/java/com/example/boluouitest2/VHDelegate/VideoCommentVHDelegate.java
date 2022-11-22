package com.example.boluouitest2.VHDelegate;


import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boluouitest2.Adapter.CommentReplyAdapter;
import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.bean.VideoCommentBean;
import com.example.boluouitest2.httpUtil.HttpCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.NumberUtil;
import com.example.boluouitest2.util.ObjUtil;
import com.example.boluouitest2.util.ToastUtil;
import com.example.boluouitest2.util.VipMakerMarkUtil;
import com.makeramen.roundedimageview.RoundedImageView;


/* renamed from: e.c.a.e.i2 */
/* loaded from: classes.dex */
public class VideoCommentVHDelegate extends VHDelegateImpl<VideoCommentBean> implements View.OnClickListener {

    /* renamed from: g */
    public RoundedImageView f12453g;

    /* renamed from: h */
    public ImageView f12454h;

    /* renamed from: i */
    public TextView f12455i;

    /* renamed from: j */
    public ImageView f12456j;

    /* renamed from: k */
    public TextView f12457k;

    /* renamed from: l */
    public TextView f12458l;

    /* renamed from: m */
    public ImageView f12459m;

    /* renamed from: n */
    public TextView f12460n;

    /* renamed from: o */
    public LinearLayout f12461o;

    /* renamed from: p */
    public RecyclerView f12462p;

    /* renamed from: q */
    public VideoBean f12463q;

    /* renamed from: r */
    public AbstractC4095c f12464r;

    /* compiled from: VideoCommentVHDelegate.java */
    /* renamed from: e.c.a.e.i2$b */
    /* loaded from: classes.dex */
    public class C4094b extends HttpCallback {
        public C4094b() {
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onException(int i, String str) {
            super.onException(i, str);
            if (!TextUtils.isEmpty(str)) {
                ToastUtil.m9102c(VideoCommentVHDelegate.this.m9232b(), str);
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onSuccess(String str, String str2, boolean z, boolean z2) {
            super.onSuccess(str, str2, z, z2);
            ToastUtil.m9102c(VideoCommentVHDelegate.this.m9232b(), VideoCommentVHDelegate.this.m9232b().getResources().getString(R.string.comment_success));
            if (VideoCommentVHDelegate.this.f12464r != null) {
                VideoCommentVHDelegate.this.f12464r.mo9805a();
            }
        }
    }

    /* compiled from: VideoCommentVHDelegate.java */
    /* renamed from: e.c.a.e.i2$c */
    /* loaded from: classes.dex */
    public interface AbstractC4095c {
        /* renamed from: a */
        void mo9805a();
    }

    public VideoCommentVHDelegate(AbstractC4095c cVar) {
        this.f12464r = cVar;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_video_comment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            int id = view.getId();
            if (id == R.id.linear_like) {
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
                m9236a().notifyItemChanged(m9229d());
                HttpUtil.m9782a(m9230c().getId(), new HttpCallback());
            } else if (id == R.id.tv_context) {
                try {
                    String nickname = m9230c().getUser().getNickname();
                    if (!TextUtils.isEmpty(nickname)) {
//                        new CommentEditTextDialog(m9232b(), true, nickname, new C4093a()).show(((AppCompatActivity) m9232b()).getSupportFragmentManager(), "dialog");
                        Toast.makeText(f13159b, "VideoCommentVHDelegate::new CommentEditTextDialog134", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* compiled from: VideoCommentVHDelegate.java */
    /* renamed from: e.c.a.e.i2$a */
    /* loaded from: classes.dex */
//    public class C4093a implements CommentEditTextDialog.AbstractC0731b {
//        public C4093a() {
//        }
//
//        @Override // com.blmvl.blvl.dialog.CommentEditTextDialog.AbstractC0731b
//        /* renamed from: a */
//        public void mo10105a(String str) {
//            if (!TextUtils.isEmpty(str)) {
//                VideoCommentVHDelegate.this.m10110a(str, 0);
//            }
//        }
//
//        @Override // com.blmvl.blvl.dialog.CommentEditTextDialog.AbstractC0731b
//        /* renamed from: a */
//        public void mo10106a(SaoTalkOptionBean saoTalkOptionBean) {
//            if (saoTalkOptionBean != null) {
//                VideoCommentVHDelegate.this.m10110a(saoTalkOptionBean.getTips(), saoTalkOptionBean.getId());
//            }
//        }
//    }

    /* renamed from: a */
    public void m10114a(VideoBean videoBean) {
        this.f12463q = videoBean;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        this.f12453g = (RoundedImageView) view.findViewById(R.id.img_avatar);
        this.f12454h = (ImageView) view.findViewById(R.id.image_vip);
        this.f12455i = (TextView) view.findViewById(R.id.tv_name);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_sex);
        this.f12456j = (ImageView) view.findViewById(R.id.image_worker);
        this.f12457k = (TextView) view.findViewById(R.id.tv_time);
        this.f12458l = (TextView) view.findViewById(R.id.tv_context);
        this.f12459m = (ImageView) view.findViewById(R.id.image_like);
        this.f12460n = (TextView) view.findViewById(R.id.text_like_num);
        this.f12461o = (LinearLayout) view.findViewById(R.id.linear_like);
        this.f12462p = (RecyclerView) view.findViewById(R.id.replyRecyclerView);
        this.f12461o.setOnClickListener(this);
        this.f12458l.setOnClickListener(this);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(VideoCommentBean videoCommentBean, int i) {
        super.mo9233a( videoCommentBean, i);
        if (videoCommentBean != null) {
            try {
                if (videoCommentBean.getUser() != null) {
                    this.f12455i.setText(CustomWordUtil.m9462a(videoCommentBean.getUser().getNickname()));
                    ImgLoader.m9428a(CustomWordUtil.m9462a(videoCommentBean.getUser().getThumb()), this.f12453g);
                    if (ObjUtil.m9224a(this.f12463q) && ObjUtil.m9224a(this.f12463q.getUser())) {
                        if (videoCommentBean.getUser().getUid() == this.f12463q.getUser().getUid()) {
                            this.f12456j.setVisibility(View.VISIBLE);
                        } else {
                            this.f12456j.setVisibility(View.INVISIBLE);
                        }
                    }
                    VipMakerMarkUtil.m9496a(this.f12454h, videoCommentBean.getUser());
                }
                this.f12458l.setText(CustomWordUtil.m9462a(videoCommentBean.getComment()));
                if (videoCommentBean.getLikes() > 0) {
                    this.f12460n.setText(NumberUtil.m9067a(videoCommentBean.getLikes(), 2));
                } else {
                    this.f12460n.setText(m9232b().getString(R.string.str_like_action));
                }
                this.f12457k.setText(CustomWordUtil.m9462a(videoCommentBean.getCreatedAt()));
                if (videoCommentBean.isHasLike()) {
                    this.f12459m.setImageResource(R.mipmap.icon_like_checked);
                } else {
                    this.f12459m.setImageResource(R.mipmap.icon_like_gray);
                }
                if (videoCommentBean.getChild() == null || videoCommentBean.getChild().isEmpty()) {
                    this.f12462p.setVisibility(View.GONE);
                    return;
                }
                this.f12462p.setVisibility(View.VISIBLE);
                CommentReplyAdapter commentReplyAdapter = new CommentReplyAdapter(this.f12463q);
                this.f12462p.setLayoutManager(new LinearLayoutManager(m9232b()));
                this.f12462p.setNestedScrollingEnabled(false);
                this.f12462p.setFocusableInTouchMode(false);
                this.f12462p.requestFocus();
                this.f12462p.setAdapter(commentReplyAdapter);
                commentReplyAdapter.addItems(videoCommentBean.getChild());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m10110a(String str, int i) {
        HttpUtil.m9778a(m9230c().getMvID(), str, m9230c().getId(), i, new C4094b());
    }
}

