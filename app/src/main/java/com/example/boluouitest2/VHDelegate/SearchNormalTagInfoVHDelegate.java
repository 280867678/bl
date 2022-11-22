package com.example.boluouitest2.VHDelegate;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.boluouitest2.EventBus.CurSelectVideoIdEvent;
import com.example.boluouitest2.EventBus.SearchKeyWordEvent;
import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.TagInfoBean;
import com.example.boluouitest2.comod.baselib.view.flow.AutoFlowLayout;
import com.example.boluouitest2.comod.baselib.view.flow.FlowAdapter;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.ObjUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


/**
 * 搜索标签
 */
public class SearchNormalTagInfoVHDelegate extends VHDelegateImpl<TagInfoBean> {


    /* renamed from: g */
    public TextView f12574g;

    /* renamed from: h */
    public AutoFlowLayout f12575h;

    /* compiled from: SearchNormalTagInfoVHDelegate.java */
    /* renamed from: e.c.a.e.r1$a */
    /* loaded from: classes.dex */
    public class C4108a extends FlowAdapter<String> {

        /* renamed from: b */
        public final /* synthetic */ List f12576b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C4108a(List list, List list2) {
            super(list);
            this.f12576b = list2;
        }

        @Override // p067e.p130f.p131a.p136e.p142d.FlowAdapter
        /* renamed from: a */
        public View mo11688a(int i) {
            try {
                if (!TextUtils.isEmpty(((String) this.f12576b.get(i)).trim())) {
                    View inflate = LayoutInflater.from(SearchNormalTagInfoVHDelegate.this.m9232b()).inflate(R.layout.item_bg_search_tag, (ViewGroup) null, false);
                    ((TextView) inflate.findViewById(R.id.text_tag)).setText(String.format("%s", ((String) this.f12576b.get(i)).trim()));
                    return inflate;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: b */
    public final void m10033b(View view) {
        this.f12574g = (TextView) view.findViewById(R.id.tv_name_tags);
        this.f12575h = (AutoFlowLayout) view.findViewById(R.id.layout_tags);
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_search_normal_tag_info;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        m10033b(view);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(TagInfoBean tagInfoBean, int i) {
        super.mo9233a( tagInfoBean, i);
        if (ObjUtil.m9224a(tagInfoBean)) {
            this.f12574g.setText(CustomWordUtil.m9462a(tagInfoBean.getName()));
            m10035a(tagInfoBean.getData());
        }
    }

    /* renamed from: a */
    public final void m10035a(final List<String> list) {
        try {
            this.f12575h.mo15218a();
            this.f12575h.setAdapter(new C4108a(list, list));
            this.f12575h.setOnItemClickListener(new AutoFlowLayout.AbstractC0912c() { // from class: e.c.a.e.h
                @Override // com.comod.baselib.view.flow.AutoFlowLayout.AbstractC0912c
                /* renamed from: a */
                public final void mo15256a(int i, View view) {
                    SearchNormalTagInfoVHDelegate.m10034a(list, i, view);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m10034a(List list, int i, View view) {
        try {
            if (i < list.size()) {
//                EventBus.m309d().m320a(new SearchKeyWordEvent((String) list.get(i)));
                EventBus.getDefault().post(new SearchKeyWordEvent((String) list.get(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
