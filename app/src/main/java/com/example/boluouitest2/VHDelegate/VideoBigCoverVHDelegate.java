package com.example.boluouitest2.VHDelegate;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boluouitest2.AppContext;
import com.example.boluouitest2.R;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;
import com.example.boluouitest2.activity.HomePageActivity;
import com.example.boluouitest2.bean.AppUser;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.comod.baselib.view.CustomTextView;
import com.example.boluouitest2.httpUtil.CommonCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.util.CustomLayoutParamsUtil;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.JumpUtil;
import com.example.boluouitest2.util.NumberUtil;
import com.example.boluouitest2.util.ObjUtil;
import com.example.boluouitest2.util.VipMakerMarkUtil;
import com.makeramen.roundedimageview.RoundedImageView;

/**
 * 首页视图
 */
public class VideoBigCoverVHDelegate extends VHDelegateImpl<VideoBean> implements View.OnClickListener {



    /* renamed from: g */
    public TextView f12330g;

    /* renamed from: h */
    public TextView f12331h;

    /* renamed from: i */
    public RoundedImageView f12332i;

    /* renamed from: j */
    public RoundedImageView f12333j;

    /* renamed from: k */
    public TextView f12334k;

    /* renamed from: l */
    public ImageView f12335l;

    /* renamed from: m */
    public CustomTextView f12336m;

    /* renamed from: n */
    public CustomTextView f12337n;

    /* renamed from: o */
    public CustomTextView f12338o;

    /* renamed from: p */
    public View f12339p;

    /* renamed from: q */
    public ImageView f12340q;

    /* renamed from: r */
    public TextView f12341r;

    /* compiled from: VideoBigCoverVHDelegate.java */
    /* renamed from: e.c.a.e.b2$a */
    /* loaded from: classes.dex */
    public class C4084a extends CommonCallback<Integer> {
        public C4084a() {
        }

        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo9799a(Integer num) {
            VideoBigCoverVHDelegate.this.m9230c().getUser().setIs_attention(num.intValue());
            VideoBigCoverVHDelegate.this.m9236a().notifyItemChanged(VideoBigCoverVHDelegate.this.m9229d());
        }
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_video_big_cover;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (!(view.getId() == R.id.img_avatar || view.getId() == R.id.tv_name)) {
                if (view.getId() == R.id.btn_follow) {
                    HttpUtil.m9783a(m9230c().getUid(), new C4084a());
                }
            }
            VideoBean c = m9230c();
//            Toast.makeText(f13159b, c.getUser().getUid(), Toast.LENGTH_SHORT).show();
            Log.e("HomePageActivity96:::::", String.valueOf(c.getUser().getUid()));
            if (c != null && ObjUtil.m9224a(c.getUser())) {
                HomePageActivity.m21102a(m9232b(), c.getUser().getUid());
                Toast.makeText(AppContext.m21299a(),"VideoBigConverVHDE:HomePageActivity:92",Toast.LENGTH_LONG).show();
                Log.e("HomePageActivity98:::::"," ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        try {
            this.f12330g = (TextView) view.findViewById(R.id.tv_title);
            this.f12331h = (TextView) view.findViewById(R.id.tv_like_num);
            this.f12332i = (RoundedImageView) view.findViewById(R.id.img_cover);
            this.f12333j = (RoundedImageView) view.findViewById(R.id.img_avatar);
            this.f12334k = (TextView) view.findViewById(R.id.tv_name);
            this.f12335l = (ImageView) view.findViewById(R.id.image_vip);
            this.f12336m = (CustomTextView) view.findViewById(R.id.tv_play_num);
            this.f12337n = (CustomTextView) view.findViewById(R.id.tv_comment_num);
            this.f12338o = (CustomTextView) view.findViewById(R.id.tv_duration);
            CustomLayoutParamsUtil.m9473a(m9232b(), (ImageView) this.f12332i);
            this.f12338o.setVisibility(View.GONE);
            this.f12333j.setOnClickListener(this);
            this.f12334k.setOnClickListener(this);
            this.f12340q = (ImageView) view.findViewById(R.id.img_add);
            this.f12341r = (TextView) view.findViewById(R.id.tv_follow);
            this.f12339p = view.findViewById(R.id.btn_follow);
            this.f12339p.setOnClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(VideoBean videoBean, int i) {
        super.mo9233a(videoBean, i);
        if (videoBean != null) {
            try {
                this.f12330g.setText(CustomWordUtil.m9462a(videoBean.getTitle()));
                boolean z = true;
                this.f12331h.setText(NumberUtil.m9066a(String.valueOf(videoBean.getLike()), 1));
                this.f12337n.setText(NumberUtil.m9066a(String.valueOf(videoBean.getComment()), 1));
                this.f12336m.setText(String.format("%s%s", NumberUtil.m9067a(videoBean.getRating(), 1), "次播放"));
                if (!TextUtils.isEmpty(videoBean.getDuration_str())) {
                    this.f12338o.setVisibility(View.VISIBLE);
                    this.f12338o.setText(CustomWordUtil.m9462a(videoBean.getDuration_str()));
                } else {
                    this.f12338o.setVisibility(View.GONE);
                }
                ImgLoader.m9424b(CustomWordUtil.m9462a(videoBean.getCover_thumb_url()), this.f12332i, (int) R.drawable.bg_cover_default_horizontal);
                if (videoBean.getUser() != null) {
                    ImgLoader.m9428a(CustomWordUtil.m9462a(videoBean.getUser().getAvatar_url()), this.f12333j);
                    this.f12334k.setText(CustomWordUtil.m9462a(videoBean.getUser().getNickname()));
                    VipMakerMarkUtil.m9496a(this.f12335l, videoBean.getUser());
                    if (videoBean.getUser().getUid() != AppUser.getInstance().getUser().getUid()) {
                        z = false;
                    }
                    m10164a(z, videoBean.getUser().getIs_attention());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m10164a(boolean z, int i) {
        if (z) {
            this.f12339p.setVisibility(View.GONE);
        } else {
            m10167a(i);
        }
    }

    /* renamed from: a */
    public final void m10167a(int i) {
        if (i == 1) {
            this.f12339p.setVisibility(View.VISIBLE);
            this.f12339p.setSelected(true);
            this.f12340q.setVisibility(View.GONE);
            this.f12341r.setText(CustomWordUtil.m9463a((int) R.string.following));
            this.f12341r.setTextColor(m9232b().getResources().getColor(R.color.color_b4));
            return;
        }
        this.f12339p.setVisibility(View.VISIBLE);
        this.f12339p.setSelected(false);
        this.f12340q.setVisibility(View.VISIBLE);
        this.f12341r.setText(CustomWordUtil.m9463a((int) R.string.follow));
        this.f12341r.setTextColor(m9232b().getResources().getColor(R.color.black));
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */

    /**
     * 调整播放页面
     * @param view
     * @param videoBean
     * @param i
     */
    public void mo9235a(View view, VideoBean videoBean, int i) {
        super.mo9235a(view,  videoBean, i);

//        Toast.makeText(f13159b, videoBean.getTitle(), Toast.LENGTH_SHORT).show();
        if (ObjUtil.m9224a(videoBean)) {
            //VideoDetailInfoActivity
            JumpUtil.m9417a().m9414a(m9232b(), videoBean.getId());
        }
    }



}
