package com.example.boluouitest2.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.boluouitest2.Adapter.VideoHotRankListAdapter;
import com.example.boluouitest2.EventBus.ChangeVideoEvent;
import com.example.boluouitest2.EventBus.FollowEvent;
import com.example.boluouitest2.EventBus.PositionChangeEvent;
import com.example.boluouitest2.R;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.comod.baselib.fragment.AbsLazyFragment;
import com.example.boluouitest2.comod.baselib.view.MultipleStatusLayout;
import com.example.boluouitest2.httpUtil.HttpCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.util.JumpUtil;
import com.example.boluouitest2.util.ObjUtil;
import com.example.boluouitest2.util.SmartRefreshLayoutUtil;
import com.example.boluouitest2.util.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

/**
 * 热门购买 热门点赞
 */
public class VideoHotRankListFragment extends AbsLazyFragment implements OnRefreshListener, BaseListViewAdapter.AbstractC0888a<VideoBean>  {
    /* renamed from: e */
    public RecyclerView f1419e;

    /* renamed from: f */
    public SmartRefreshLayout f1420f;

    /* renamed from: g */
    public MultipleStatusLayout f1421g;

    /* renamed from: h */
    public String f1422h;

    /* renamed from: i */
    public VideoHotRankListAdapter f1423i;

    /* renamed from: j */
    public int f1424j;

    /* renamed from: k */
    public int f1425k;



    /* renamed from: a */
    public static VideoHotRankListFragment m20232a(int i, int i2) {
        VideoHotRankListFragment videoHotRankListFragment = new VideoHotRankListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key_type", i);
        bundle.putInt("key_load_method", i2);
        videoHotRankListFragment.setArguments(bundle);
        return videoHotRankListFragment;
    }


    @Override
    public int mo20158r() {
        return R.layout.fragment_hot_video_rank_list;
    }

    @Override
    public void initView(View view) {
        try {
            Bundle arguments = getArguments();
            if (arguments != null) {
                int i = arguments.getInt("key_type", 1);
                this.f1425k = arguments.getInt("key_load_method", 2);
                if (i == 1) {
                    this.f1422h = "/api/topvideo/like";
                    this.f1424j = 8;
                } else if (i == 2) {
                    this.f1422h = "/api/topvideo/sale";
                    this.f1424j = 9;
                }
//                EventBus.m309d().m310c(this);
                EventBus.getDefault().register(this);
                this.f1419e = (RecyclerView) view.findViewById(R.id.recyclerView);
                this.f1420f = (SmartRefreshLayout) view.findViewById(R.id.smartRefreshLayout);
                this.f1421g = (MultipleStatusLayout) view.findViewById(R.id.multipleStatusLayout);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                this.f1419e.setLayoutManager(linearLayoutManager);
                this.f1420f.setRefreshHeader(SmartRefreshLayoutUtil.m9580a(getContext(), R.mipmap.icon_down_arrow_white, R.color.white, R.color.transparent));
                this.f1420f.setOnRefreshListener(this);
                this.f1423i = new VideoHotRankListAdapter();
                this.f1423i.setOnItemClickListener(this);
                this.f1419e.setAdapter(this.f1423i);
                this.f1421g.setOnRetryClickListener(new View.OnClickListener() { // from class: e.c.a.g.m0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        VideoHotRankListFragment.this.m20230b(view2);
                        Toast.makeText(getContext(), "VideoHotRankListFragment.this.m20230b(view2);112", Toast.LENGTH_SHORT).show();
                    }

                });
                if (this.f1425k == 2) {
                    this.f1420f.autoRefreshAnimationOnly();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public /* synthetic */ void m20230b(View view) {
        SmartRefreshLayout smartRefreshLayout = this.f1420f;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.autoRefreshAnimationOnly();
        }
    }



    @Override
    public void onLazyLoad() {
        if (this.f1425k == 1) {
            this.f1420f.autoRefreshAnimationOnly();
        }
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        this.f1421g.m20141a();
        HttpUtil.m9760a(this.f1422h, new C0792a());
    }

    /* renamed from: com.blmvl.blvl.fragment.VideoHotRankListFragment$a */
    /* loaded from: classes.dex */
    public class C0792a extends HttpCallback {
        public C0792a() {
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onError() {
            super.onError();
            VideoHotRankListFragment.this.f1420f.finishRefresh();
            if (VideoHotRankListFragment.this.f1423i.getItemCount() == 0) {
                VideoHotRankListFragment.this.f1421g.m20128d();
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onException(int i, String str) {
            super.onException(i, str);
            VideoHotRankListFragment.this.f1420f.finishRefresh();
            if (!TextUtils.isEmpty(str)) {
                ToastUtil.m9102c(VideoHotRankListFragment.this.getContext(), str);
            }
            if (VideoHotRankListFragment.this.f1423i.getItemCount() == 0) {
                VideoHotRankListFragment.this.f1421g.m20128d();
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onNetworkError() {
            super.onNetworkError();
            VideoHotRankListFragment.this.f1420f.finishRefresh();
            if (VideoHotRankListFragment.this.f1423i.getItemCount() == 0) {
                VideoHotRankListFragment.this.f1421g.m20124f();
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onSuccess(String str, String str2, boolean z, boolean z2) {
            super.onSuccess(str, str2, z, z2);
            try {
                VideoHotRankListFragment.this.f1420f.finishRefresh();
                if (!TextUtils.isEmpty(str)) {
                    VideoHotRankListFragment.this.f1423i.refreshAddItems(JSON.parseArray(str, VideoBean.class));
                }
                if (VideoHotRankListFragment.this.f1423i.getItemCount() == 0) {
                    VideoHotRankListFragment.this.f1421g.m20131c();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }





    @Override
    public void mo9802a(View view, VideoBean videoBean, int i) {
        try {
            if (ObjUtil.m9224a(videoBean)) {
                JumpUtil.m9417a().m9414a(getContext(), videoBean.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
































    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onChangeVideoEvent(ChangeVideoEvent changeVideoEvent) {
        try {
            ArrayList arrayList = (ArrayList) this.f1423i.getItems();
            if (!(arrayList == null || arrayList.isEmpty())) {
                for (int i = 0; i < arrayList.size(); i++) {
                    try {
                        if (arrayList.get(i) != null && ((VideoBean) arrayList.get(i)).getId() == changeVideoEvent.getVid()) {
                            this.f1423i.setItem(i, changeVideoEvent.getItem());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
//        EventBus.m309d().m308d(this);
        EventBus.getDefault().unregister(this);
        HttpUtil.m9735b(this.f1422h);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(FollowEvent followEvent) {
        try {
            if (!(this.f1423i == null || this.f1423i.getItems().isEmpty())) {
                for (int i = 0; i < this.f1423i.getItems().size(); i++) {
                    VideoBean videoBean = (VideoBean) this.f1423i.getItems().get(i);
                    if (videoBean != null && videoBean.getUser().getUid() == followEvent.getToUid()) {
                        videoBean.getUser().setIs_attention(followEvent.getIsAttention());
                        this.f1423i.notifyItemChanged(i);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPositionChangeEvent(PositionChangeEvent positionChangeEvent) {
        try {
            if (positionChangeEvent.getFrom() == this.f1424j) {
                this.f1419e.smoothScrollToPosition(positionChangeEvent.getPosition());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }







}