package com.example.boluouitest2.VHDelegate;



import android.text.TextUtils;
import android.view.View;

import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.VideoDailyMoreInfoBean;
import com.example.boluouitest2.comod.baselib.view.CustomTextView;

import java.text.SimpleDateFormat;
import java.util.Locale;


/* renamed from: e.c.a.e.n2 */
/* loaded from: classes.dex */
public class VideoDailyMoreTitleVHDelegate extends VHDelegateImpl<VideoDailyMoreInfoBean> {

    /* renamed from: g */
    public CustomTextView f12528g;

    /* renamed from: b */
    public final void m10065b(View view) {
        this.f12528g =  view.findViewById(R.id.tv_title);
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_video_daily_more_title;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        m10065b(view);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(VideoDailyMoreInfoBean videoDailyMoreInfoBean, int i) {
        super.mo9233a( videoDailyMoreInfoBean, i);
        if (videoDailyMoreInfoBean != null) {
            try {
                if (!TextUtils.isEmpty(videoDailyMoreInfoBean.getDay())) {
                    this.f12528g.setText(String.format("%s推薦", new SimpleDateFormat("MM月dd日", Locale.getDefault()).format(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(videoDailyMoreInfoBean.getDay()))));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

