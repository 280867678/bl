package com.example.boluouitest2.VHDelegate;


import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boluouitest2.Adapter.DiscoverHotCollectAdapter;
import com.example.boluouitest2.R;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;
import com.example.boluouitest2.activity.VideoCollectDetailActivity;
import com.example.boluouitest2.bean.MainHotVideoCollectBean;
import com.example.boluouitest2.bean.VideoCollectInfoBean;
import com.example.boluouitest2.comod.baselib.util.GridSpacingItemDecoration;
import com.example.boluouitest2.util.DpUtil;


/* renamed from: e.c.a.e.o0 */
/* loaded from: classes.dex */
public class HotCollectVHDelegate extends VHDelegateImpl<MainHotVideoCollectBean> {

    /* renamed from: g */
    public RecyclerView f12530g;

    /* renamed from: h */
    public DiscoverHotCollectAdapter f12531h;

    /* renamed from: b */
    public final void m10062b(View view) {
        try {
            this.f12530g = (RecyclerView) view.findViewById(R.id.recyclerView);
            this.f12530g.setLayoutManager(new GridLayoutManager(m9232b(), 2));
            this.f12530g.addItemDecoration(new GridSpacingItemDecoration(2, DpUtil.m9101a(m9232b(), 10), true, false, true));
            this.f12531h = new DiscoverHotCollectAdapter();
            this.f12530g.setAdapter(this.f12531h);
            this.f12531h.setOnItemClickListener(new BaseListViewAdapter.AbstractC0888a() { // from class: e.c.a.e.f
                @Override // com.comod.baselib.list.BaseListViewAdapter.AbstractC0888a
                /* renamed from: a */
                public final void mo9802a(View view2, Object obj, int i) {
                    HotCollectVHDelegate.this.m10064a(view2, (VideoCollectInfoBean) obj, i);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_discover_hot;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        m10062b(view);
    }

    /* renamed from: a */
    public /* synthetic */ void m10064a(View view, VideoCollectInfoBean videoCollectInfoBean, int i) {
        if (videoCollectInfoBean != null) {
            VideoCollectDetailActivity.m20749a(m9232b(), videoCollectInfoBean.getId());
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(MainHotVideoCollectBean mainHotVideoCollectBean, int i) {
        super.mo9233a( mainHotVideoCollectBean, i);
        if (mainHotVideoCollectBean != null) {
            try {
                this.f12531h.refreshAddItems(mainHotVideoCollectBean.getItem());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

