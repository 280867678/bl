package com.example.boluouitest2.VHDelegate;



import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.comod.baselib.view.CustomTextView;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.JumpUtil;
import com.example.boluouitest2.util.NumberUtil;
import com.example.boluouitest2.util.ObjUtil;
import com.makeramen.roundedimageview.RoundedImageView;


/* renamed from: e.c.a.e.t2 */
/* loaded from: classes.dex */
public class VideoMidCoverVHDelegate extends VHDelegateImpl<VideoBean> {

    /* renamed from: g */
    public TextView f12617g;

    /* renamed from: h */
    public TextView f12618h;

    /* renamed from: i */
    public RoundedImageView f12619i;

    /* renamed from: j */
    public RoundedImageView f12620j;

    /* renamed from: k */
    public TextView f12621k;

    /* renamed from: l */
    public CustomTextView f12622l;

    /* renamed from: m */
    public CustomTextView f12623m;

    /* renamed from: b */
    public final void m10015b(View view) {
        this.f12617g = (TextView) view.findViewById(R.id.tv_title);
        this.f12618h = (TextView) view.findViewById(R.id.tv_like_num);
        this.f12619i = (RoundedImageView) view.findViewById(R.id.img_cover);
        this.f12620j = (RoundedImageView) view.findViewById(R.id.img_avatar);
        this.f12621k = (TextView) view.findViewById(R.id.tv_name);
        this.f12622l = (CustomTextView) view.findViewById(R.id.tv_play_num);
        this.f12623m = (CustomTextView) view.findViewById(R.id.tv_duration);
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_video_mid_cover;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        m10015b(view);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9235a(View view, VideoBean videoBean, int i) {
        super.mo9235a(view,  videoBean, i);
        if (ObjUtil.m9224a(videoBean)) {
            JumpUtil.m9417a().m9414a(m9232b(), videoBean.getId());
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(VideoBean videoBean, int i) {
        super.mo9233a( videoBean, i);
        if (videoBean != null) {
            try {
                if (!TextUtils.isEmpty(videoBean.getTitle())) {
                    this.f12617g.setText(videoBean.getTitle());
                }
                this.f12618h.setText(NumberUtil.m9066a(String.valueOf(videoBean.getLike()), 2));
                ImgLoader.m9424b(CustomWordUtil.m9462a(videoBean.getCover_thumb_url()), this.f12619i, (int) R.drawable.bg_cover_default_horizontal);
                this.f12622l.setText(String.format("%s%s", NumberUtil.m9067a(videoBean.getRating(), 1), "次播放"));
                if (!TextUtils.isEmpty(videoBean.getDuration_str())) {
                    this.f12623m.setVisibility(View.VISIBLE);
                    this.f12623m.setText(CustomWordUtil.m9462a(videoBean.getDuration_str()));
                } else {
                    this.f12623m.setVisibility(View.INVISIBLE);
                }
                if (videoBean.getUser() != null) {
                    this.f12621k.setText(CustomWordUtil.m9462a(videoBean.getUser().getNickname()));
                    ImgLoader.m9426b(m9232b(), CustomWordUtil.m9462a(videoBean.getUser().getAvatar_url()), this.f12620j);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

