package com.example.boluouitest2.fragment;

import android.content.Context;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.example.boluouitest2.Adapter.VideoSetAdapter;
import com.example.boluouitest2.EventBus.FollowEvent;
import com.example.boluouitest2.R;
import com.example.boluouitest2.ViewHelper.RecyclerViewHelper;
import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.VHDelegate.VideoMidCoverVHDelegate;
import com.example.boluouitest2.activity.HomePageActivity;
import com.example.boluouitest2.activity.VideoCollectDetailActivity;
import com.example.boluouitest2.bean.AdBannerBean;
import com.example.boluouitest2.bean.AppUser;
import com.example.boluouitest2.bean.UserBean;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.bean.VideoCollectInfoBean;
import com.example.boluouitest2.bean.VideoDetailBean;
import com.example.boluouitest2.comod.baselib.fragment.AbsLazyFragment;
import com.example.boluouitest2.comod.baselib.view.CustomTextView;
import com.example.boluouitest2.comod.baselib.view.banner.XBanner;
import com.example.boluouitest2.comod.baselib.view.flow.AutoFlowLayout;
import com.example.boluouitest2.comod.baselib.view.flow.FlowAdapter;
import com.example.boluouitest2.comod.baselib.view.magicindicator.util.SpacesItemDecoration;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.util.ApiUrlUtil;
import com.example.boluouitest2.util.CustomAdBannerUtil;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.DpUtil;
import com.example.boluouitest2.util.ListUtil;
import com.example.boluouitest2.util.NumberUtil;
import com.example.boluouitest2.util.ObjUtil;
import com.example.boluouitest2.util.WordUtil;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.lzy.okgo.model.HttpParams;
import com.makeramen.roundedimageview.RoundedImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * 详情
 */
public class VideoDetailInfoFragment extends AbsLazyFragment {
    /* renamed from: A */
    public View f1386A;

    /* renamed from: B */
    public ImageView f1387B;

    /* renamed from: C */
    public TextView f1388C;

    /* renamed from: e */
    public TextView f1389e;

    /* renamed from: f */
    public TextView f1390f;

    /* renamed from: g */
    public XBanner f1391g;

    /* renamed from: h */
    public LinearLayout f1392h;

    /* renamed from: i */
    public ImageView f1393i;

    /* renamed from: j */
    public CustomTextView f1394j;

    /* renamed from: k */
    public LinearLayout f1395k;

    /* renamed from: l */
    public int f1396l;

    /* renamed from: m */
    public RecyclerViewHelper f1397m;

    /* renamed from: n */
    public AutoFlowLayout<String> f1398n;

    /* renamed from: o */
    public VideoBean f1399o;

    /* renamed from: p */
    public AppBarLayout f1400p;

    /* renamed from: q */
    public ShimmerRecyclerView f1401q;

    /* renamed from: r */
    public CoordinatorLayout f1402r;

    /* renamed from: s */
    public ProgressBar f1403s;

    /* renamed from: t */
    public RoundedImageView f1404t;

    /* renamed from: u */
    public TextView f1405u;

    /* renamed from: v */
    public TextView f1406v;

    /* renamed from: w */
    public TextView f1407w;

    /* renamed from: x */
    public LinearLayout f1408x;

    /* renamed from: y */
    public RecyclerView f1409y;

    /* renamed from: z */
    public VideoSetAdapter f1410z;







    @Override
    public int mo20158r() {
        return R.layout.fragment_video_detail;
    }

    @Override
    public void initView(View view) {
        m20244c(view);
    }

    /* renamed from: c */
    public final void m20244c(View view) {
        this.f1402r = (CoordinatorLayout) view.findViewById(R.id.layout_video_info);
        this.f1403s = (ProgressBar) view.findViewById(R.id.loading);
        this.f1403s.setVisibility(View.VISIBLE);
        this.f1402r.setVisibility(View.GONE);
        this.f1389e = (TextView) view.findViewById(R.id.tv_title);
        this.f1390f = (TextView) view.findViewById(R.id.tv_play_num);
        this.f1392h = (LinearLayout) view.findViewById(R.id.layout_share);
        this.f1393i = (ImageView) view.findViewById(R.id.img_like);
        this.f1394j = (CustomTextView) view.findViewById(R.id.tv_like_num);
        this.f1395k = (LinearLayout) view.findViewById(R.id.layout_like);
        this.f1398n = (AutoFlowLayout) view.findViewById(R.id.layout_tags);
        this.f1391g = (XBanner) view.findViewById(R.id.banner);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsingToolbarLayout);
        this.f1400p = (AppBarLayout) view.findViewById(R.id.appBarLayout);
        this.f1401q = (ShimmerRecyclerView) view.findViewById(R.id.recyclerView);
        this.f1404t = (RoundedImageView) view.findViewById(R.id.img_avatar);
        this.f1405u = (TextView) view.findViewById(R.id.tv_name);
        this.f1406v = (TextView) view.findViewById(R.id.tv_signature);
        this.f1387B = (ImageView) view.findViewById(R.id.img_add);
        this.f1388C = (TextView) view.findViewById(R.id.tv_follow);
        this.f1386A = view.findViewById(R.id.btn_follow);
        this.f1386A.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.g.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
//                VideoDetailInfoFragment.this.m20239d(view2);
                Toast.makeText(getContext(), "VideoDetailInfoFragment.this.m20239d(view2);177", Toast.LENGTH_SHORT).show();
            }
        });
        CustomAdBannerUtil.m9484d(getContext(), this.f1391g);
        this.f1395k.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.g.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
//                VideoDetailInfoFragment.this.m20238e(view2);
                Toast.makeText(getContext(), "VideoDetailInfoFragment.this.m20238e(view2);185", Toast.LENGTH_SHORT).show();
            }
        });
        this.f1392h.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.g.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
//                VideoDetailInfoFragment.this.m20237f(view2);
                Toast.makeText(getContext(), "VideoDetailInfoFragment.this.m20237f(view2)192", Toast.LENGTH_SHORT).show();
            }
        });
        this.f1407w = (TextView) view.findViewById(R.id.tv_set_title);
        this.f1408x = (LinearLayout) view.findViewById(R.id.layout_set_info);
        this.f1409y = (RecyclerView) view.findViewById(R.id.setRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        this.f1409y.setLayoutManager(linearLayoutManager);
        this.f1409y.setHasFixedSize(true);
        this.f1409y.addItemDecoration(new SpacesItemDecoration(DpUtil.m9101a((Context) requireContext(), 10)));
        this.f1410z = new VideoSetAdapter();
        this.f1409y.setAdapter(this.f1410z);
        m20252b(view);
//        EventBus.m309d().m310c(this);
        EventBus.getDefault().register(this);
    }

    /* renamed from: b */
    public final void m20252b(View view) {
        this.f1397m = new C0790d(getContext(), view);
    }

    /* renamed from: com.blmvl.blvl.fragment.VideoDetailInfoFragment$d */
    /* loaded from: classes.dex */
    public class C0790d extends RecyclerViewHelper<VideoBean> {
        public C0790d(Context context, View view) {
            super(context, view);
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: a */
        public List<VideoBean> mo9379a(String str) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return JSON.parseArray(JSON.parseObject(str).getString("list"), VideoBean.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ArrayList();
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: b */
        public VHDelegateImpl<VideoBean> mo9376b(int i) {
            return new VideoMidCoverVHDelegate();
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: c */
        public int mo9374c() {
            return R.layout.item_video_mid_video_default;
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: p */
        public String mo9357p() {
            return "getRecVideoList";
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: s */
        public boolean mo9354s() {
            return true;
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: b */
        public String mo9377b() {
            return ApiUrlUtil.m9219a("/api/mvnew/detailRecommend");
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: a */
        public void mo9381a(HttpParams httpParams) {
            super.mo9381a(httpParams);
            if (ObjUtil.m9224a(VideoDetailInfoFragment.this.f1399o)) {
                httpParams.put("id", VideoDetailInfoFragment.this.f1399o.getId(), new boolean[0]);
            }
        }
    }









    @Override
    public void onLazyLoad() {

    }





    /* renamed from: c */
    public void m20242c(VideoDetailBean videoDetailBean) {
        this.f1399o = videoDetailBean.getRow();
        if (this.f1399o != null) {
            this.f1403s.setVisibility(View.GONE);
            this.f1402r.setVisibility(View.VISIBLE);
            m20262A();
            m20258a(this.f1399o);
            m20257a(videoDetailBean);
            m20250b(videoDetailBean);
            return;
        }
        this.f1403s.setVisibility(View.VISIBLE);
        this.f1402r.setVisibility(View.GONE);
    }


    /* renamed from: A */
    public final void m20262A() {
        try {
            this.f1401q.scrollToPosition(0);
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.f1400p.getLayoutParams()).getBehavior();
            if (behavior instanceof AppBarLayout.Behavior) {
                AppBarLayout.Behavior behavior2 = (AppBarLayout.Behavior) behavior;
                if (behavior2.getTopAndBottomOffset() != 0) {
                    behavior2.setTopAndBottomOffset(0);
                    this.f1400p.setExpanded(true, true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m20258a(VideoBean videoBean) {
        try {
            boolean z = true;
            this.f1389e.setText(String.format("%s", WordUtil.m9084a(videoBean.getTitle())));
            this.f1390f.setText(String.format("%s次播放", NumberUtil.m9067a(videoBean.getRating(), 1)));
            this.f1396l = videoBean.getLike();
            m20234x();
            m20245c(videoBean.getIs_like());
            if (ObjUtil.m9224a(videoBean.getUser())) {
                final UserBean user = videoBean.getUser();
                ImgLoader.m9428a(WordUtil.m9084a(user.getAvatar_url()), this.f1404t);
                this.f1405u.setText(WordUtil.m9084a(user.getNickname()));
                this.f1406v.setText(CustomWordUtil.m9461b(user.getPerson_signnatrue()));
                this.f1404t.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.g.k0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
//                        头像点击事件
                        VideoDetailInfoFragment.this.m20259a(user, view);
                        Toast.makeText(getContext(), "VideoDetailInfoFragment.this.m20259a(user, view);344", Toast.LENGTH_SHORT).show();
                    }
                });
                this.f1405u.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.g.l0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
//                        VideoDetailInfoFragment.this.m20251b(user, view);
                        Toast.makeText(getContext(), "VideoDetailInfoFragment.this.m20251b(user, view);351", Toast.LENGTH_SHORT).show();
                    }
                });
                this.f1406v.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.g.f0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
//                        VideoDetailInfoFragment.this.m20243c(user, view);
                        Toast.makeText(getContext(), "VideoDetailInfoFragment.this.m20243c(user, view);358", Toast.LENGTH_SHORT).show();
                    }
                });
                if (user.getUid() != AppUser.getInstance().getUser().getUid()) {
                    z = false;
                }
                m20246b(z, user.getIs_attention());
            }
            if (ListUtil.m9075b(videoBean.getTags_list())) {
                this.f1398n.setVisibility(View.VISIBLE);
                List<String> tags_list = videoBean.getTags_list();
                m20247b(tags_list.subList(0, Math.min(5, tags_list.size())));
            } else {
                this.f1398n.setVisibility(View.GONE);
            }
            if (ObjUtil.m9224a(this.f1397m)) {
                this.f1397m.m9390E();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m20259a(UserBean userBean, View view) {
        HomePageActivity.m21102a(getContext(), userBean.getUid());
    }

    /* renamed from: x */
    public final void m20234x() {
        this.f1394j.setText(String.format("%s", NumberUtil.m9067a(this.f1396l, 1)));
    }


    /* renamed from: c */
    public final void m20245c(int i) {
        if (i == 1) {
            this.f1393i.setImageResource(R.mipmap.ic_like_red);
            this.f1394j.setTextColor(getResources().getColor(R.color.color_ff454a));
            return;
        }
        this.f1393i.setImageResource(R.mipmap.ic_like_gray);
        this.f1394j.setTextColor(getResources().getColor(R.color.color_a1a1b2));
    }

    /* renamed from: b */
    public final void m20246b(boolean z, int i) {
        if (z) {
            this.f1386A.setVisibility(View.GONE);
        } else {
            m20253b(i);
        }
    }

    /* renamed from: b */
    public final void m20253b(int i) {
        if (i == 1) {
            this.f1386A.setVisibility(View.VISIBLE);
            this.f1386A.setSelected(true);
            this.f1387B.setVisibility(View.GONE);
            this.f1388C.setText(CustomWordUtil.m9463a((int) R.string.following));
            this.f1388C.setTextColor(getContext().getResources().getColor(R.color.color_b4));
            return;
        }
        this.f1386A.setVisibility(View.VISIBLE);
        this.f1386A.setSelected(false);
        this.f1387B.setVisibility(View.VISIBLE);
        this.f1388C.setText(CustomWordUtil.m9463a((int) R.string.follow));
        this.f1388C.setTextColor(getContext().getResources().getColor(R.color.black));
    }

    /* renamed from: b */
    public final void m20247b(final List<String> list) {
        try {
            this.f1398n.mo15218a();
            this.f1398n.setAdapter(new C0789c(list, list));
            this.f1398n.setOnItemClickListener(new AutoFlowLayout.AbstractC0912c() { // from class: e.c.a.g.i0
                @Override // com.comod.baselib.view.flow.AutoFlowLayout.AbstractC0912c
                /* renamed from: a */
                public final void mo15256a(int i, View view) {
//                    VideoDetailInfoFragment.this.m20254a(list, i, view);
                    Toast.makeText(getContext(), "VideoDetailInfoFragment.this.m20254a(list, i, view);435", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /* renamed from: com.blmvl.blvl.fragment.VideoDetailInfoFragment$c */
    /* loaded from: classes.dex */
    public class C0789c extends FlowAdapter<String> {

        /* renamed from: b */
        public final /* synthetic */ List f1414b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0789c(List list, List list2) {
            super(list);
            this.f1414b = list2;
        }

        @Override // p067e.p130f.p131a.p136e.p142d.FlowAdapter
        /* renamed from: a */
        public View mo11688a(int i) {
            try {
                if (!TextUtils.isEmpty(((String) this.f1414b.get(i)).trim())) {
                    View inflate = LayoutInflater.from(VideoDetailInfoFragment.this.getContext()).inflate(R.layout.item_video_detail_tag, (ViewGroup) null, false);
                    ((TextView) inflate.findViewById(R.id.text_tag)).setText(String.format("%s", ((String) this.f1414b.get(i)).trim()));
                    return inflate;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new View(VideoDetailInfoFragment.this.getContext());
        }

    }














    /* renamed from: a */
    public final void m20257a(VideoDetailBean videoDetailBean) {
        List<AdBannerBean> ads = videoDetailBean.getAds();
        if (ListUtil.m9075b(ads)) {
            this.f1391g.setVisibility(View.VISIBLE);
            CustomAdBannerUtil.m9489a(getContext(), this.f1391g, R.layout.xbanner_item_normal, ads);
            return;
        }
        this.f1391g.setVisibility(View.GONE);
    }

    /* renamed from: b */
    public final void m20250b(VideoDetailBean videoDetailBean) {
        List<VideoBean> topic_mv = videoDetailBean.getTopic_mv();
        if (ListUtil.m9075b(topic_mv)) {
            this.f1408x.setVisibility(View.VISIBLE);
            this.f1409y.setVisibility(View.VISIBLE);
            this.f1410z.refreshAddItems(topic_mv);
            if (ObjUtil.m9224a(videoDetailBean.getTopic())) {
                VideoCollectInfoBean topic = videoDetailBean.getTopic();
                this.f1407w.setText(CustomWordUtil.m9461b(topic.getTitle()));
                this.f1408x.setOnClickListener(new View$OnClickListenerC0788b(topic));
                return;
            }
            return;
        }
        this.f1408x.setVisibility(View.GONE);
        this.f1409y.setVisibility(View.GONE);
    }

    /* renamed from: com.blmvl.blvl.fragment.VideoDetailInfoFragment$b */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0788b implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ VideoCollectInfoBean f1412b;

        public View$OnClickListenerC0788b(VideoCollectInfoBean videoCollectInfoBean) {
            this.f1412b = videoCollectInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoCollectDetailActivity.m20749a(VideoDetailInfoFragment.this.getContext(), this.f1412b.getId());
        }
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(FollowEvent followEvent) {
        try {
            if (this.f1399o != null && this.f1399o.getUser() != null && this.f1399o.getUser().getUid() == followEvent.getToUid()) {
                m20246b(this.f1399o.getUser().getUid() == AppUser.getInstance().getUser().getUid(), followEvent.getIsAttention());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}