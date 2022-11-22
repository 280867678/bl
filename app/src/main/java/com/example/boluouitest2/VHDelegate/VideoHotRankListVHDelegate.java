package com.example.boluouitest2.VHDelegate;



import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.boluouitest2.R;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.comod.baselib.view.CustomTextView;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.NumberUtil;
import com.example.boluouitest2.util.WordUtil;
import com.makeramen.roundedimageview.RoundedImageView;


/* renamed from: e.c.a.e.q2 */
/* loaded from: classes.dex */
public class VideoHotRankListVHDelegate extends VHDelegateImpl<VideoBean> {

    /* renamed from: g */
    public RoundedImageView f12561g;

    /* renamed from: h */
    public TextView f12562h;

    /* renamed from: i */
    public CustomTextView f12563i;

    /* renamed from: j */
    public RoundedImageView f12564j;

    /* renamed from: k */
    public TextView f12565k;

    /* renamed from: l */
    public CustomTextView f12566l;

    public VideoHotRankListVHDelegate(BaseListViewAdapter baseListViewAdapter) {
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_video_hot_rank_list;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        try {
            this.f12561g = (RoundedImageView) view.findViewById(R.id.img_cover);
            this.f12562h = (TextView) view.findViewById(R.id.tv_title);
            this.f12563i = (CustomTextView) view.findViewById(R.id.tv_top);
            this.f12564j = (RoundedImageView) view.findViewById(R.id.img_avatar);
            this.f12565k = (TextView) view.findViewById(R.id.tv_name);
            this.f12566l = (CustomTextView) view.findViewById(R.id.tv_like_num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(VideoBean videoBean, int i) {
        try {
            if (i == 0) {
                this.f12563i.setBackgroundResource(R.mipmap.ic_top_1);
            } else if (i == 1) {
                this.f12563i.setBackgroundResource(R.mipmap.ic_top_2);
            } else if (i == 2) {
                this.f12563i.setBackgroundResource(R.mipmap.ic_top_3);
            } else {
                this.f12563i.setBackgroundResource(R.mipmap.ic_top_other);
            }
            this.f12563i.setText(String.format("TOP%s", String.valueOf(i + 1)));
            if (videoBean != null) {
                this.f12562h.setText(CustomWordUtil.m9462a(videoBean.getTitle()));
                ImgLoader.m9425b(m9232b(), WordUtil.m9084a(videoBean.getCover_thumb_url()), this.f12561g, R.drawable.bg_cover_default_horizontal);
                if (videoBean.getUser() != null) {
                    ImgLoader.m9428a(CustomWordUtil.m9462a(videoBean.getUser().getAvatar_url()), this.f12564j);
                    if (!TextUtils.isEmpty(videoBean.getUser().getNickname())) {
                        this.f12565k.setText(CustomWordUtil.m9462a(videoBean.getUser().getNickname()));
                    }
                }
                this.f12566l.setText(NumberUtil.m9067a(videoBean.getLike(), 2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

