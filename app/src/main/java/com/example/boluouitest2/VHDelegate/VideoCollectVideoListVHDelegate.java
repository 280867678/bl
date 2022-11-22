package com.example.boluouitest2.VHDelegate;



import android.view.View;
import android.widget.TextView;

import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.comod.baselib.view.CustomTextView;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.NumberUtil;
import com.makeramen.roundedimageview.RoundedImageView;


/* renamed from: e.c.a.e.g2 */
/* loaded from: classes.dex */
public class VideoCollectVideoListVHDelegate extends VHDelegateImpl<VideoBean> {

    /* renamed from: g */
    public RoundedImageView f12421g;

    /* renamed from: h */
    public CustomTextView f12422h;

    /* renamed from: i */
    public CustomTextView f12423i;

    /* renamed from: j */
    public TextView f12424j;

    /* renamed from: k */
    public TextView f12425k;

    /* renamed from: l */
    public TextView f12426l;

    /* renamed from: b */
    public final void m10122b(View view) {
        this.f12421g = (RoundedImageView) view.findViewById(R.id.img_cover);
        this.f12422h = (CustomTextView) view.findViewById(R.id.tv_play_num);
        this.f12423i = (CustomTextView) view.findViewById(R.id.tv_video_duration);
        this.f12424j = (TextView) view.findViewById(R.id.tv_title);
        this.f12425k = (TextView) view.findViewById(R.id.tv_num);
        this.f12426l = (TextView) view.findViewById(R.id.tv_like_num);
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_video_collect_video_list;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        m10122b(view);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(VideoBean videoBean, int i) {
        super.mo9233a( videoBean, i);
        if (videoBean != null) {
            try {
                this.f12424j.setText(String.format("第%s集 | %s", String.valueOf(i + 1), CustomWordUtil.m9462a(videoBean.getTitle())));
                this.f12423i.setText(CustomWordUtil.m9462a(videoBean.getDuration_str()));
                if (videoBean.getCoins() > 0) {
                    this.f12425k.setText(String.format("%s%s", String.valueOf(videoBean.getCoins()), "鑽石"));
                    this.f12425k.setTextColor(m9232b().getResources().getColor(R.color.color_d2a152));
                } else {
                    this.f12425k.setText(m9232b().getString(R.string.str_free));
                    this.f12425k.setTextColor(m9232b().getResources().getColor(R.color.third_text_color));
                }
                this.f12422h.setText(String.format("%s次播放", NumberUtil.m9067a(videoBean.getRating(), 1)));
                ImgLoader.m9424b(CustomWordUtil.m9462a(videoBean.getCover_thumb_url()), this.f12421g, (int) R.drawable.bg_cover_default_horizontal);
                this.f12426l.setText(NumberUtil.m9066a(String.valueOf(videoBean.getLike()), 2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

