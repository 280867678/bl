package com.example.boluouitest2.VHDelegate;



import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.comod.baselib.view.CustomTextView;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.util.CustomLayoutParamsUtil;
import com.example.boluouitest2.util.NumberUtil;
import com.example.boluouitest2.util.WordUtil;


/* renamed from: e.c.a.e.k1 */
/* loaded from: classes.dex */
public class PersonalVideoVHDelegate extends VHDelegateImpl<VideoBean> {

    /* renamed from: g */
    public int f12487g;

    /* renamed from: h */
    public ImageView f12488h;

    /* renamed from: i */
    public CustomTextView f12489i;

    /* renamed from: j */
    public TextView f12490j;

    /* renamed from: k */
    public TextView f12491k;

    /* renamed from: l */
    public CustomTextView f12492l;

    public PersonalVideoVHDelegate(int i) {
        this.f12487g = i;
    }

    /* renamed from: b */
    public final void m10085b(View view) {
        this.f12488h = (ImageView) view.findViewById(R.id.img_cover);
        CustomLayoutParamsUtil.m9472b(m9232b(), this.f12488h);
        this.f12489i = (CustomTextView) view.findViewById(R.id.tv_like_num);
        this.f12490j = (TextView) view.findViewById(R.id.tv_top);
        this.f12490j.setVisibility(View.GONE);
        this.f12491k = (TextView) view.findViewById(R.id.tv_title);
        this.f12492l = (CustomTextView) view.findViewById(R.id.tv_play_num);
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_personal_video;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        m10085b(view);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(VideoBean videoBean, int i) {
        super.mo9233a( videoBean, i);
        if (videoBean != null) {
            try {
                if (this.f12487g == 1 && videoBean.getIs_top() == 1) {
                    this.f12490j.setVisibility(View.VISIBLE);
                } else {
                    this.f12490j.setVisibility(View.GONE);
                }
                this.f12489i.setText(NumberUtil.m9067a(videoBean.getLike(), 1));
                this.f12492l.setText(String.format("%s%s", NumberUtil.m9067a(videoBean.getRating(), 1), "次播放"));
                ImgLoader.m9424b(WordUtil.m9084a(videoBean.getCover_thumb_url()), this.f12488h, (int) R.drawable.bg_cover_default_horizontal);
                this.f12491k.setText(WordUtil.m9084a(videoBean.getTitle()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

