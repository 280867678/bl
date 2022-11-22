package com.example.boluouitest2.VHDelegate;


import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boluouitest2.Adapter.VideoSmallCoverAdapter;
import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.FeaturedVideoBean;
import com.example.boluouitest2.comod.baselib.util.GridSpacingItemDecoration;
import com.example.boluouitest2.util.DpUtil;
import com.example.boluouitest2.util.ListUtil;


/* renamed from: e.c.a.e.v0 */
/* loaded from: classes.dex */
public class MainFeaturedVideoBodyVHDelegate extends VHDelegateImpl<FeaturedVideoBean> {

    /* renamed from: g */
    public RecyclerView f12638g;

    /* renamed from: h */
    public VideoSmallCoverAdapter f12639h;

    /* renamed from: b */
    public final void m10004b(View view) {
        this.f12638g = (RecyclerView) view.findViewById(R.id.recyclerView);
        this.f12638g.setLayoutManager(new GridLayoutManager(m9232b(), 2));
        this.f12638g.addItemDecoration(new GridSpacingItemDecoration(2, DpUtil.m9101a(m9232b(), 10), true, false, true));
        this.f12639h = new VideoSmallCoverAdapter();
        this.f12638g.setAdapter(this.f12639h);
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_main_featured_video_body;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        m10004b(view);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(FeaturedVideoBean featuredVideoBean, int i) {
        super.mo9233a( featuredVideoBean, i);
        if (featuredVideoBean != null) {
            try {
                if (ListUtil.m9075b(featuredVideoBean.getItemList())) {
                    this.f12639h.refreshAddItems(featuredVideoBean.getItemList());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

