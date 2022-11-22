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
import com.example.boluouitest2.util.SpecialTxtColorUtil;
import com.makeramen.roundedimageview.RoundedImageView;

/**
 * 搜索视频视图
 */
public class SearchVideoListVHDelegate extends VHDelegateImpl<VideoBean> {


    /* renamed from: g */
    public String f12609g;

    /* renamed from: h */
    public TextView f12610h;

    /* renamed from: i */
    public TextView f12611i;

    /* renamed from: j */
    public RoundedImageView f12612j;

    /* renamed from: k */
    public RoundedImageView f12613k;

    /* renamed from: l */
    public TextView f12614l;

    /* renamed from: m */
    public CustomTextView f12615m;

    /* renamed from: n */
    public CustomTextView f12616n;

    public SearchVideoListVHDelegate(String str) {
        this.f12609g = str;
    }

    /* renamed from: b */
    public final void m10018b(View view) {
        this.f12610h = (TextView) view.findViewById(R.id.tv_title);
        this.f12611i = (TextView) view.findViewById(R.id.tv_like_num);
        this.f12612j = (RoundedImageView) view.findViewById(R.id.img_cover);
        this.f12613k = (RoundedImageView) view.findViewById(R.id.img_avatar);
        this.f12614l = (TextView) view.findViewById(R.id.tv_name);
        this.f12615m = (CustomTextView) view.findViewById(R.id.tv_play_num);
        this.f12616n = (CustomTextView) view.findViewById(R.id.tv_duration);
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_video_mid_cover;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        m10018b(view);
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
                    String title = videoBean.getTitle();
                    this.f12610h.setText(title);
                    if (!TextUtils.isEmpty(this.f12609g)) {
                        this.f12610h.setText(SpecialTxtColorUtil.m9513a(-206539, title, this.f12609g));
                    }
                }
                this.f12611i.setText(NumberUtil.m9066a(String.valueOf(videoBean.getLike()), 2));
                ImgLoader.m9424b(CustomWordUtil.m9462a(videoBean.getCover_thumb_url()), this.f12612j, (int) R.drawable.bg_cover_default_horizontal);
                this.f12615m.setText(String.format("%s%s", NumberUtil.m9067a(videoBean.getRating(), 1), "次播放"));
                if (!TextUtils.isEmpty(videoBean.getDuration_str())) {
                    this.f12616n.setVisibility(View.VISIBLE);
                    this.f12616n.setText(CustomWordUtil.m9462a(videoBean.getDuration_str()));
                } else {
                    this.f12616n.setVisibility(View.INVISIBLE);
                }
                if (videoBean.getUser() != null) {
                    this.f12614l.setText(CustomWordUtil.m9462a(videoBean.getUser().getNickname()));
                    ImgLoader.m9426b(m9232b(), CustomWordUtil.m9462a(videoBean.getUser().getAvatar_url()), this.f12613k);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
