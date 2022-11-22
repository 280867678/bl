package com.example.boluouitest2.VHDelegate;

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

public class VideoHSmallCoverVHDelegate extends VHDelegateImpl<VideoBean> {


    /* renamed from: g */
    public RoundedImageView f12549g;

    /* renamed from: h */
    public CustomTextView f12550h;

    /* renamed from: i */
    public CustomTextView f12551i;

    /* renamed from: j */
    public TextView f12552j;

    /* renamed from: b */
    public final void m10049b(View view) {
        this.f12549g = (RoundedImageView) view.findViewById(R.id.img_cover);
        this.f12550h = (CustomTextView) view.findViewById(R.id.tv_play_num);
        this.f12551i = (CustomTextView) view.findViewById(R.id.tv_like_num);
        this.f12552j = (TextView) view.findViewById(R.id.tv_title);
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_video_h_small_cover;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        m10049b(view);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(VideoBean videoBean, int i) {
        super.mo9233a( videoBean, i);
        if (videoBean != null) {
            try {
                this.f12552j.setText(CustomWordUtil.m9462a(videoBean.getTitle()));
                this.f12551i.setText(NumberUtil.m9066a(String.valueOf(videoBean.getLike()), 1));
                this.f12550h.setText(String.format("%s%s", NumberUtil.m9067a(videoBean.getRating(), 1), "次播放"));
                ImgLoader.m9424b(CustomWordUtil.m9462a(videoBean.getCover_thumb_url()), this.f12549g, (int) R.drawable.bg_cover_default_horizontal);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9235a(View view, VideoBean videoBean, int i) {
        super.mo9235a(view, videoBean, i);
        if (ObjUtil.m9224a(videoBean)) {
            JumpUtil.m9417a().m9414a(m9232b(), videoBean.getId());
        }
    }


}
