package com.example.boluouitest2.VHDelegate;



import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.VideoCollectInfoBean;
import com.example.boluouitest2.comod.baselib.view.CustomTextView;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.DpUtil;
import com.example.boluouitest2.util.NumberUtil;
import com.example.boluouitest2.util.ScreenUtil;
import com.makeramen.roundedimageview.RoundedImageView;


/* renamed from: e.c.a.e.c0 */
/* loaded from: classes.dex */
public class DiscoverHotVideoCollectVHDelegate extends VHDelegateImpl<VideoCollectInfoBean> {

    /* renamed from: g */
    public RoundedImageView f12353g;

    /* renamed from: h */
    public CustomTextView f12354h;

    /* renamed from: i */
    public CustomTextView f12355i;

    /* renamed from: j */
    public CustomTextView f12356j;

    /* renamed from: k */
    public TextView f12357k;

    /* renamed from: b */
    public final void m10158b(View view) {
        this.f12353g = (RoundedImageView) view.findViewById(R.id.img_cover);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f12353g.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (((ScreenUtil.m9202b(m9232b()) - (DpUtil.m9101a(m9232b(), 10) * 3)) / 2) * 10) / 16;
        this.f12354h = (CustomTextView) view.findViewById(R.id.tv_top);
        this.f12354h.setVisibility(View.GONE);
        this.f12355i = (CustomTextView) view.findViewById(R.id.tv_like_num);
        this.f12356j = (CustomTextView) view.findViewById(R.id.tv_video_num);
        this.f12357k = (TextView) view.findViewById(R.id.tv_title);
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_discover_hot_video_collect;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        m10158b(view);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(VideoCollectInfoBean videoCollectInfoBean, int i) {
        super.mo9233a( videoCollectInfoBean, i);
        try {
            if (i == 0) {
                this.f12354h.setBackgroundResource(R.mipmap.ic_top_1);
            } else if (i == 1) {
                this.f12354h.setBackgroundResource(R.mipmap.ic_top_2);
            } else if (i == 2) {
                this.f12354h.setBackgroundResource(R.mipmap.ic_top_3);
            } else {
                this.f12354h.setBackgroundResource(R.mipmap.ic_top_other);
            }
            this.f12354h.setText(String.format("TOP%s", String.valueOf(i + 1)));
            if (videoCollectInfoBean != null) {
                this.f12357k.setText(CustomWordUtil.m9462a(videoCollectInfoBean.getTitle()));
                this.f12355i.setText(String.format("%s%s", NumberUtil.m9067a(videoCollectInfoBean.getLike_count(), 1), "人喜欢"));
                this.f12356j.setText(String.format("%s集", String.valueOf(videoCollectInfoBean.getVideo_count())));
                ImgLoader.m9425b(m9232b(), CustomWordUtil.m9462a(videoCollectInfoBean.getImage_url()), this.f12353g, R.drawable.bg_cover_default_horizontal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

