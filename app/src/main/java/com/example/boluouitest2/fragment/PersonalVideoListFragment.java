package com.example.boluouitest2.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.boluouitest2.Adapter.PersonalVideoAdapter;
import com.example.boluouitest2.Adapter.VideoMidCoverAdapter;
import com.example.boluouitest2.EventBus.ChangeVideoEvent;
import com.example.boluouitest2.EventBus.GetGameInfoEvent;
import com.example.boluouitest2.EventBus.PersonalSearchEvent;
import com.example.boluouitest2.EventBus.PositionChangeEvent;
import com.example.boluouitest2.R;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.comod.baselib.fragment.AbsLazyFragment;
import com.example.boluouitest2.comod.baselib.util.CenterAlignImageSpan;
import com.example.boluouitest2.comod.baselib.util.GridSpacingItemDecoration;
import com.example.boluouitest2.comod.baselib.view.MultipleStatusLayout;
import com.example.boluouitest2.httpUtil.HttpCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.util.DpUtil;
import com.example.boluouitest2.util.InputMethodUtil;
import com.example.boluouitest2.util.JumpUtil;
import com.example.boluouitest2.util.ObjUtil;
import com.example.boluouitest2.util.SmartRefreshLayoutUtil;
import com.example.boluouitest2.util.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 視頻
 */
public class PersonalVideoListFragment  extends AbsLazyFragment implements OnRefreshListener, OnRefreshLoadMoreListener {
    /* renamed from: e */
    public RecyclerView f1284e;

    /* renamed from: f */
    public SmartRefreshLayout f1285f;

    /* renamed from: g */
    public String f1286g;

    /* renamed from: h */
    public MultipleStatusLayout f1287h;

    /* renamed from: l */
    public BaseListViewAdapter f1291l;

    /* renamed from: m */
    public int f1292m;

    /* renamed from: n */
    public int f1293n;

    /* renamed from: o */
    public int f1294o;

    /* renamed from: p */
    public EditText f1295p;

    /* renamed from: i */
    public boolean f1288i = false;

    /* renamed from: j */
    public int f1289j = 1;

    /* renamed from: k */
    public boolean f1290k = true;

    /* renamed from: q */
    public String f1296q = "";

    /* renamed from: r */
    public LinearLayoutManager f1297r = null;




    /* renamed from: a */
    public static PersonalVideoListFragment m20383a(int i, int i2) {
        PersonalVideoListFragment personalVideoListFragment = new PersonalVideoListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key_type_video", i);
        bundle.putInt("key_uid", i2);
        personalVideoListFragment.setArguments(bundle);
        return personalVideoListFragment;
    }




    @Override
    public int mo20158r() {
        return R.layout.fragment_personal_video;
    }

    @Override
    public void initView(View view) {
        try {
            if (getArguments() != null) {
                this.f1294o = getArguments().getInt("key_type_video");
                if (this.f1294o == 1) {
                    this.f1286g = "/api/users/videos";
                    this.f1293n = 13;
//                    LogUtil.m9410a("BL_PERSONAL_VIDEO_LIST_PAGE");
                } else if (this.f1294o == 2) {
                    this.f1286g = "/api/users/likes";
                    this.f1293n = 14;
//                    LogUtil.m9410a("BL_PERSONAL_VIDEO_LIKE_LIST_PAGE");
                }
                this.f1292m = getArguments().getInt("key_uid");
                m20378b(view);
//                EventBus.m309d().m310c(this);
                EventBus.getDefault().register(this);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /* renamed from: b */
    public final void m20378b(View view) {
        try {
            this.f1284e = (RecyclerView) view.findViewById(R.id.recyclerView);
            this.f1285f = (SmartRefreshLayout) view.findViewById(R.id.smartRefreshLayout);
            this.f1285f.setRefreshHeader(SmartRefreshLayoutUtil.m9579b(getContext()));
            this.f1285f.setRefreshFooter(SmartRefreshLayoutUtil.m9581a(getContext()));
            this.f1285f.setOnLoadMoreListener((OnLoadMoreListener) this);
            this.f1285f.setOnRefreshListener((OnRefreshListener) this);
            if (this.f1294o == 1) {
                this.f1297r = new GridLayoutManager(getContext(), 2);
                this.f1284e.setLayoutManager(this.f1297r);
                this.f1284e.addItemDecoration(new GridSpacingItemDecoration(2, DpUtil.m9101a((Context) requireContext(), 10), true, true, true));
                this.f1291l = new PersonalVideoAdapter(this.f1294o);
                this.f1284e.setAdapter(this.f1291l);
            } else if (this.f1294o == 2) {
                this.f1297r = new LinearLayoutManager(getContext());
                this.f1297r.setOrientation(RecyclerView.VERTICAL);
                this.f1284e.setLayoutManager(this.f1297r);
                this.f1291l = new VideoMidCoverAdapter();
                this.f1284e.setAdapter(this.f1291l);
            }
            this.f1287h = (MultipleStatusLayout) view.findViewById(R.id.multipleStatusLayout);
            this.f1287h.setOnRetryClickListener(new View.OnClickListener() { // from class: e.c.a.g.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PersonalVideoListFragment.this.m20375c(view2);
//                    Toast.makeText(getContext(), "PersonalVideoListFragment.this.m20375c(view2)167", Toast.LENGTH_SHORT).show();
                }
            });
            this.f1284e.addOnScrollListener(new C0765a());
            this.f1291l.setOnItemClickListener(new BaseListViewAdapter.AbstractC0888a() { // from class: e.c.a.g.s
                @Override // com.comod.baselib.list.BaseListViewAdapter.AbstractC0888a
                /* renamed from: a */
                public final void mo9802a(View view2, Object obj, int i) {
                    PersonalVideoListFragment.this.m20377b(view2, (VideoBean) obj, i);
//                    Toast.makeText(getContext(), "PersonalVideoListFragment.this.m20377b(view2, (VideoBean) obj, i)176", Toast.LENGTH_SHORT).show();
                }
            });
            this.f1295p = (EditText) view.findViewById(R.id.et_search);
            this.f1295p.setVisibility(View.GONE);
            m20384E();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: com.blmvl.blvl.fragment.PersonalVideoListFragment$a */
    /* loaded from: classes.dex */
    public class C0765a extends RecyclerView.OnScrollListener {
        public C0765a() {
        }

        @Override // android.support.p004v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override // android.support.p004v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            try {
                if (PersonalVideoListFragment.this.f1291l.getItemCount() - PersonalVideoListFragment.this.f1297r.findLastVisibleItemPosition() < 6) {
                    PersonalVideoListFragment.this.m20386A();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    /* renamed from: E */
    public final void m20384E() {
        String format = String.format("  %s", getResources().getString(R.string.str_personal_video_search_hint));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        Drawable drawable = ContextCompat.getDrawable((Context) requireContext(), R.mipmap.ic_search);
        if (drawable != null) {
            drawable.setBounds(0, 0, DpUtil.m9101a(getContext(), 12), DpUtil.m9101a(getContext(), 12));
            spannableStringBuilder.setSpan(new CenterAlignImageSpan(drawable, 1), 0, 1, 17);
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-5000269), 2, format.length(), 33);
        this.f1295p.setHint(spannableStringBuilder);
        this.f1295p.setOnEditorActionListener(new C0766b());
        this.f1295p.addTextChangedListener(new C0767c());
    }

    /* renamed from: com.blmvl.blvl.fragment.PersonalVideoListFragment$b */
    /* loaded from: classes.dex */
    public class C0766b implements TextView.OnEditorActionListener {
        public C0766b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3) {
                return false;
            }
            HttpUtil.m9735b(PersonalVideoListFragment.this.f1286g);
            PersonalVideoListFragment.this.m20364w();
//            EventBus.m309d().m320a(new PersonalSearchEvent());
            //                发送消息
            EventBus.getDefault().post(new PersonalSearchEvent());
            return true;
        }
    }

    /* renamed from: w */
    public final void m20364w() {
        String trim = this.f1295p.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            ToastUtil.m9102c(getContext(), getContext().getResources().getString(R.string.key_word_empty_hint));
        } else {
            m20379a(trim);
        }
    }
    /* renamed from: a */
    public final void m20379a(String str) {
        this.f1296q = str;
        InputMethodUtil.m9082a((Context) requireContext(), this.f1295p);
        this.f1284e.smoothScrollToPosition(0);
        this.f1285f.autoRefreshAnimationOnly();
    }

    /* renamed from: com.blmvl.blvl.fragment.PersonalVideoListFragment$c */
    /* loaded from: classes.dex */
    public class C0767c implements TextWatcher {
        public C0767c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (TextUtils.isEmpty(charSequence.toString())) {
                HttpUtil.m9735b(PersonalVideoListFragment.this.f1286g);
                PersonalVideoListFragment.this.m20379a("");
            }
        }
    }


    @Override
    public void onLazyLoad() {
        SmartRefreshLayout smartRefreshLayout = this.f1285f;
        if (smartRefreshLayout != null) {
//            smartRefreshLayout.m18551a();
            smartRefreshLayout.autoRefresh();
        }
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        m20386A();
    }

    /* renamed from: A */
    public final void m20386A() {
        if (!this.f1288i && this.f1290k) {
            this.f1288i = true;
            m20363x();
        }
    }





    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        m20385D();
    }

    /* renamed from: D */
    public final void m20385D() {
        if (!this.f1288i) {
            this.f1288i = true;
            this.f1289j = 1;
            this.f1285f.setEnableLoadMore(true);
            this.f1285f.resetNoMoreData();
            this.f1290k = true;
            m20363x();
        }
    }
    /* renamed from: x */
    public final void m20363x() {
        this.f1287h.m20141a();
        HttpUtil.m9727b(this.f1286g, String.valueOf(this.f1292m), this.f1296q, this.f1289j, new C0768d());
    }

    /* renamed from: com.blmvl.blvl.fragment.PersonalVideoListFragment$d */
    /* loaded from: classes.dex */
    public class C0768d extends HttpCallback {
        public C0768d() {
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onError() {
            super.onError();
            PersonalVideoListFragment.this.m20365v();
            if (PersonalVideoListFragment.this.f1291l.getItemCount() == 0) {
                PersonalVideoListFragment.this.f1287h.m20128d();
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onException(int i, String str) {
            super.onException(i, str);
            if (!TextUtils.isEmpty(str)) {
                ToastUtil.m9102c(PersonalVideoListFragment.this.getContext(), str);
            }
            PersonalVideoListFragment.this.m20365v();
            if (PersonalVideoListFragment.this.f1291l.getItemCount() == 0) {
                PersonalVideoListFragment.this.f1287h.m20128d();
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onNetworkError() {
            super.onNetworkError();
            PersonalVideoListFragment.this.m20365v();
            if (PersonalVideoListFragment.this.f1291l.getItemCount() == 0) {
                PersonalVideoListFragment.this.f1287h.m20124f();
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onSuccess(String str, String str2, boolean z, boolean z2) {
            super.onSuccess(str, str2, z, z2);
            try {
                PersonalVideoListFragment.this.m20365v();
                if (!TextUtils.isEmpty(str)) {
                    List parseArray = JSON.parseArray(str, VideoBean.class);
                    if (parseArray == null || parseArray.isEmpty()) {
                        if (PersonalVideoListFragment.this.f1289j == 1) {
                            PersonalVideoListFragment.this.f1291l.clear();
                        }
                        PersonalVideoListFragment.this.f1285f.setEnableLoadMore(false);
                        PersonalVideoListFragment.this.f1285f.resetNoMoreData();
                        PersonalVideoListFragment.this.f1290k = false;
                    } else {
                        if (PersonalVideoListFragment.this.f1289j == 1) {
                            PersonalVideoListFragment.this.f1291l.refreshAddItems(parseArray);
                        } else {
                            PersonalVideoListFragment.this.f1291l.addItems(parseArray);
                        }
                        PersonalVideoListFragment.m20367j(PersonalVideoListFragment.this);
                    }
                }
                if (PersonalVideoListFragment.this.f1291l.getItemCount() == 0) {
                    PersonalVideoListFragment.this.f1287h.m20131c();
                } else {
                    PersonalVideoListFragment.this.f1295p.setVisibility(View.VISIBLE);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (PersonalVideoListFragment.this.f1291l.getItemCount() == 0) {
                    PersonalVideoListFragment.this.f1287h.m20128d();
                }
            }
        }
    }
    /* renamed from: v */
    public final void m20365v() {
        this.f1288i = false;
        this.f1285f.finishRefresh();
        this.f1285f.finishLoadMore();
    }


    /* renamed from: j */
    public static /* synthetic */ int m20367j(PersonalVideoListFragment personalVideoListFragment) {
        int i = personalVideoListFragment.f1289j;
        personalVideoListFragment.f1289j = i + 1;
        return i;
    }




    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onChangeVideoEvent(ChangeVideoEvent changeVideoEvent) {
        ArrayList arrayList;
        try {
            if (this.f1294o == 2) {
                m20385D();
            } else if (this.f1291l != null && (arrayList = (ArrayList) this.f1291l.getItems()) != null && !arrayList.isEmpty()) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i) != null && ((VideoBean) arrayList.get(i)).getId() == changeVideoEvent.getVid()) {
                        this.f1291l.setItem(i, changeVideoEvent.getItem());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
//        EventBus.m309d().m308d(this);
        EventBus.getDefault().unregister(this);
        HttpUtil.m9735b(this.f1286g);
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPositionChangeEvent(PositionChangeEvent positionChangeEvent) {
        try {
            if (positionChangeEvent.getFrom() == this.f1293n) {
                this.f1284e.smoothScrollToPosition(positionChangeEvent.getPosition());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /* renamed from: c */
    public /* synthetic */ void m20375c(View view) {
        this.f1285f.autoRefreshAnimationOnly();
    }

    /* renamed from: b */

    /**
     * 列表点击
     * @param view
     * @param videoBean
     * @param i
     */
    public /* synthetic */ void m20377b(View view, VideoBean videoBean, int i) {
        try {
            if (ObjUtil.m9224a(videoBean)) {
                JumpUtil.m9417a().m9414a(getContext(), videoBean.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}