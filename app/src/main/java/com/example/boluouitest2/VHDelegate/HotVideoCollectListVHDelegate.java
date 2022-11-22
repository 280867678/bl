package com.example.boluouitest2.VHDelegate;



import android.view.View;
import android.widget.TextView;

import com.example.boluouitest2.R;
import com.example.boluouitest2.activity.VideoCollectDetailActivity;
import com.example.boluouitest2.bean.VideoCollectInfoBean;
import com.example.boluouitest2.comod.baselib.view.CustomTextView;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.NumberUtil;
import com.makeramen.roundedimageview.RoundedImageView;


/* renamed from: e.c.a.e.r0 */
/* loaded from: classes.dex */
public class HotVideoCollectListVHDelegate extends VHDelegateImpl<VideoCollectInfoBean> {

    /* renamed from: g */
    public RoundedImageView f12568g;

    /* renamed from: h */
    public CustomTextView f12569h;

    /* renamed from: i */
    public TextView f12570i;

    /* renamed from: j */
    public RoundedImageView f12571j;

    /* renamed from: k */
    public TextView f12572k;

    /* renamed from: l */
    public CustomTextView f12573l;

    /* renamed from: b */
    public final void m10038b(View view) {
        this.f12568g = (RoundedImageView) view.findViewById(R.id.img_cover);
        this.f12569h = (CustomTextView) view.findViewById(R.id.tv_top);
        this.f12570i = (TextView) view.findViewById(R.id.tv_title);
        this.f12571j = (RoundedImageView) view.findViewById(R.id.img_avatar);
        this.f12572k = (TextView) view.findViewById(R.id.tv_name);
        this.f12573l = (CustomTextView) view.findViewById(R.id.tv_num);
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_hot_video_collect_list;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        m10038b(view);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(VideoCollectInfoBean videoCollectInfoBean, int i) {
        super.mo9233a( videoCollectInfoBean, i);
        try {
            if (i == 0) {
                this.f12569h.setBackgroundResource(R.mipmap.ic_top_1);
            } else if (i == 1) {
                this.f12569h.setBackgroundResource(R.mipmap.ic_top_2);
            } else if (i == 2) {
                this.f12569h.setBackgroundResource(R.mipmap.ic_top_3);
            } else {
                this.f12569h.setBackgroundResource(R.mipmap.ic_top_other);
            }
            this.f12569h.setText(String.format("TOP%s", String.valueOf(i + 1)));
            if (videoCollectInfoBean != null) {
                this.f12570i.setText(CustomWordUtil.m9462a(videoCollectInfoBean.getTitle()));
                ImgLoader.m9425b(m9232b(), CustomWordUtil.m9462a(videoCollectInfoBean.getImage_url()), this.f12568g, R.drawable.bg_cover_default_horizontal);
                if (videoCollectInfoBean.getUser() != null) {
                    ImgLoader.m9426b(m9232b(), CustomWordUtil.m9462a(videoCollectInfoBean.getUser().getAvatar_url()), this.f12571j);
                    this.f12572k.setText(CustomWordUtil.m9462a(videoCollectInfoBean.getUser().getNickname()));
                }
                this.f12573l.setText(String.format("%s人喜欢ㆍ共%s集", NumberUtil.m9067a(videoCollectInfoBean.getLike_count(), 1), String.valueOf(videoCollectInfoBean.getVideo_count())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9235a(View view, VideoCollectInfoBean videoCollectInfoBean, int i) {
        super.mo9235a(view,  videoCollectInfoBean, i);
        if (videoCollectInfoBean != null) {
            try {
                VideoCollectDetailActivity.m20749a(m9232b(), videoCollectInfoBean.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

