package com.example.boluouitest2.VHDelegate;



import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.boluouitest2.R;
import com.example.boluouitest2.activity.VideoCreatorActivity;
import com.example.boluouitest2.bean.VideoRankBean;
import com.example.boluouitest2.bean.VideoRankItemBean;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;


/* renamed from: e.c.a.e.w2 */
/* loaded from: classes.dex */
public class VideoTopRankVHDelegate extends VHDelegateImpl<VideoRankBean> {

    /* renamed from: g */
    public ViewFlipper f12672g;

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_video_top_rank;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        this.f12672g = (ViewFlipper) view.findViewById(R.id.flipper);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(VideoRankBean videoRankBean, int i) {
        super.mo9233a( videoRankBean, i);
        if (videoRankBean != null) {
            try {
                if (!videoRankBean.getItemBeans().isEmpty()) {
                    for (int i2 = 0; i2 < videoRankBean.getItemBeans().size(); i2++) {
                        View inflate = LayoutInflater.from(m9232b()).inflate(R.layout.layout_viewflipper_rank, (ViewGroup) null);
                        TextView textView = (TextView) inflate.findViewById(R.id.tv_title);
                        RoundedImageView roundedImageView = (RoundedImageView) inflate.findViewById(R.id.img_avatar_1);
                        RoundedImageView roundedImageView2 = (RoundedImageView) inflate.findViewById(R.id.img_avatar_2);
                        RoundedImageView roundedImageView3 = (RoundedImageView) inflate.findViewById(R.id.img_avatar_3);
                        if (videoRankBean.getItemBeans().get(i2) != null) {
                            final VideoRankItemBean videoRankItemBean = videoRankBean.getItemBeans().get(i2);
                            List<String> item = videoRankItemBean.getItem();
                            if (item.size() > 0) {
                                ImgLoader.m9426b(m9232b(), item.get(0), roundedImageView);
                            }
                            if (item.size() > 1) {
                                ImgLoader.m9426b(m9232b(), item.get(1), roundedImageView2);
                            }
                            if (item.size() > 2) {
                                ImgLoader.m9426b(m9232b(), item.get(2), roundedImageView3);
                            }
                            if (!TextUtils.isEmpty(videoRankItemBean.getName())) {
                                textView.setText(videoRankItemBean.getName());
                            }
                            inflate.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.e.m
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    VideoTopRankVHDelegate.this.m9974a(videoRankItemBean, view);
                                }
                            });
                            this.f12672g.addView(inflate);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m9974a(VideoRankItemBean videoRankItemBean, View view) {
        if (!TextUtils.isEmpty(videoRankItemBean.getType())) {
            String type = videoRankItemBean.getType();
            char c = 65535;
            int hashCode = type.hashCode();
            int i = 0;
            if (hashCode != -1184259671) {
                if (hashCode != 3346) {
                    if (hashCode == 3739 && type.equals("up")) {
                        c = 1;
                    }
                } else if (type.equals("hz")) {
                    c = 0;
                }
            } else if (type.equals("income")) {
                c = 2;
            }
            if (c != 0) {
                if (c == 1) {
                    i = 1;
                } else if (c == 2) {
                    i = 2;
                }
            }
            VideoCreatorActivity.m20725a(m9232b(), i);
        }
    }
}

