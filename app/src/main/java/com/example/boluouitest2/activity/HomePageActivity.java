package com.example.boluouitest2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.boluouitest2.EventBus.FollowEvent;
import com.example.boluouitest2.EventBus.PersonalSearchEvent;
import com.example.boluouitest2.EventBus.PositionChangeEvent;
import com.example.boluouitest2.EventBus.UserInfoChangeEvent;
import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.AppUser;
import com.example.boluouitest2.bean.UserBean;
import com.example.boluouitest2.comod.baselib.view.CustomTextView;
import com.example.boluouitest2.comod.baselib.view.MyViewPager;
import com.example.boluouitest2.comod.baselib.view.ViewPagerHelper;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.CommonNavigatorAdapter;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.CommonPagerAdapter;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.IPagerIndicator;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.IPagerTitleView;
import com.example.boluouitest2.comod.baselib.view.magicindicator.CommonNavigator;
import com.example.boluouitest2.comod.baselib.view.magicindicator.MagicIndicator;
import com.example.boluouitest2.fragment.PersonalVideoCollectListFragment;
import com.example.boluouitest2.fragment.PersonalVideoListFragment;
import com.example.boluouitest2.httpUtil.CommonCallback;
import com.example.boluouitest2.httpUtil.HttpCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.util.ColorUtil;
import com.example.boluouitest2.util.CustomMagicIndicatorUtil;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.DpUtil;
import com.example.boluouitest2.util.IntentUtil;
import com.example.boluouitest2.util.NumberUtil;
import com.example.boluouitest2.util.ScreenUtil;
import com.example.boluouitest2.util.ToastUtil;
import com.example.boluouitest2.util.VipMakerMarkUtil;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.gyf.immersionbar.ImmersionBar;
import com.makeramen.roundedimageview.RoundedImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AbsActivity implements View.OnClickListener  {
    /* renamed from: b */
    public RoundedImageView f528b;

    /* renamed from: c */
    public TextView f529c;

    /* renamed from: d */
    public ImageView f530d;

    /* renamed from: e */
    public TextView f531e;

    /* renamed from: f */
    public LinearLayout f532f;

    /* renamed from: g */
    public LinearLayout f533g;

    /* renamed from: h */
    public CustomTextView f534h;

    /* renamed from: i */
    public TextView f535i;

    /* renamed from: j */
    public ImageView f536j;

    /* renamed from: k */
    public TextView f537k;

    /* renamed from: l */
    public LinearLayout f538l;

    /* renamed from: m */
    public CustomTextView f539m;

    /* renamed from: n */
    public CustomTextView f540n;

    /* renamed from: o */
    public CustomTextView f541o;

    /* renamed from: p */
    public TextView f542p;

    /* renamed from: q */
    public Toolbar f543q;

    /* renamed from: r */
    public CollapsingToolbarLayout f544r;

    /* renamed from: s */
    public MagicIndicator f545s;

    /* renamed from: t */
    public AppBarLayout f546t;

    /* renamed from: u */
    public MyViewPager f547u;

    /* renamed from: v */
    public int f548v;

    /* renamed from: w */
    public int f549w = 0;

    /* renamed from: x */
    public int f550x = 0;

    /* renamed from: y */
    public List<String> f551y = null;

    /* renamed from: z */
    public UserBean f552z;



    @Override
    public void mo20592a(Bundle bundle) {
        try {
            this.f548v = getIntent().getIntExtra("uid", -1);
            if (this.f548v != -1) {
                m21103Q();
//                EventBus.m309d().m310c(this);
                EventBus.getDefault().register(this);
//                LogUtil.m9410a("BL_HOME_PAGE");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    /* renamed from: Q */
    public final void m21103Q() {
        this.f528b = (RoundedImageView) findViewById(R.id.img_avatar);
        this.f529c = (TextView) findViewById(R.id.tv_name);
        this.f530d = (ImageView) findViewById(R.id.img_vip);
        this.f530d.setVisibility(View.GONE);
        this.f531e = (TextView) findViewById(R.id.tv_video_maker_level);
        this.f532f = (LinearLayout) findViewById(R.id.layout_video_maker_level);
        this.f533g = (LinearLayout) findViewById(R.id.layout_mark);
        this.f533g.setVisibility(View.GONE);
        this.f534h = (CustomTextView) findViewById(R.id.tv_uid);
        this.f535i = (TextView) findViewById(R.id.tv_edit_info);
        this.f536j = (ImageView) findViewById(R.id.img_add);
        this.f537k = (TextView) findViewById(R.id.tv_follow);
        this.f538l = (LinearLayout) findViewById(R.id.btn_follow);
        this.f538l.setOnClickListener(this);
        this.f535i.setVisibility(View.GONE);
        this.f538l.setVisibility(View.GONE);
        this.f539m = (CustomTextView) findViewById(R.id.tv_fans_num);
        this.f539m.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.c.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
//                HomePageActivity.this.m21100a(view);
                Toast.makeText(HomePageActivity.this, "HomePageActivity.this.m21100a(view)173", Toast.LENGTH_SHORT).show();
            }
        });
        this.f540n = (CustomTextView) findViewById(R.id.tv_follow_num);
        this.f540n.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.c.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
//                HomePageActivity.this.m21093b(view);
                Toast.makeText(HomePageActivity.this, "HomePageActivity.this.m21093b(view)181", Toast.LENGTH_SHORT).show();
            }
        });
        this.f541o = (CustomTextView) findViewById(R.id.tv_like_num);
        this.f542p = (TextView) findViewById(R.id.tv_sign);
        this.f543q = (Toolbar) findViewById(R.id.toolbar);
        this.f544r = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        this.f545s = (MagicIndicator) findViewById(R.id.indicator);
        this.f546t = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.f547u = (MyViewPager) findViewById(R.id.viewPager);
        findViewById(R.id.line1);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f543q.getLayoutParams();
        layoutParams.height = ScreenUtil.m9200d(this) + DpUtil.m9101a(this, 44);
        this.f543q.setPadding(0, ScreenUtil.m9200d(this), DpUtil.m9101a(this, 70), 0);
        this.f543q.setLayoutParams(layoutParams);
        setSupportActionBar(this.f543q);
        this.f543q.setNavigationOnClickListener(new View.OnClickListener() { // from class: e.c.a.c.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomePageActivity.this.m21089c(view);
                Toast.makeText(HomePageActivity.this, "HomePageActivity.this.m21089c(view)201", Toast.LENGTH_SHORT).show();
            }
        });
        this.f544r = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        this.f544r.setExpandedTitleTextAppearance(R.style.ExpandedTitleTextAppearance);
        this.f544r.setCollapsedTitleTextAppearance(R.style.CollapsedTitleTextAppearance);
        this.f546t = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.f546t.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: e.c.a.c.y
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener, android.support.design.widget.AppBarLayout.BaseOnOffsetChangedListener
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                //搜索
                HomePageActivity.this.m21101a(appBarLayout, i);
//                Toast.makeText(HomePageActivity.this, "HomePageActivity.this.m21101a(appBarLayout, i)211", Toast.LENGTH_SHORT).show();
            }
        });
        m21105G();
    }

    /* renamed from: c */
    public /* synthetic */ void m21089c(View view) {
        finish();
    }
    /* renamed from: G */
    public final void m21105G() {
        HttpUtil.m9674i(this.f548v, new C0629a());
    }
    /* renamed from: com.blmvl.blvl.activity.HomePageActivity$a */
    /* loaded from: classes.dex */
    public class C0629a extends HttpCallback {
        public C0629a() {
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onError() {
            super.onError();
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onException(int i, String str) {
            super.onException(i, str);
            if (!TextUtils.isEmpty(str)) {
                ToastUtil.m9102c(HomePageActivity.this, str);
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onNetworkError() {
            super.onNetworkError();
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onSuccess(String str, String str2, boolean z, boolean z2) {
            super.onSuccess(str, str2, z, z2);
            try {
                HomePageActivity.this.f552z = (UserBean) JSON.parseObject(str, UserBean.class);
                HomePageActivity.this.m21094a(HomePageActivity.this.f552z);
                boolean z3 = HomePageActivity.this.f548v == AppUser.getInstance().getUser().getUid();
                HomePageActivity.this.m21090b(z3, HomePageActivity.this.f552z.getIs_attention());
                HomePageActivity.this.m21083f(z3);
                HomePageActivity.this.m21104N();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /* renamed from: a */
    public final void m21094a(UserBean userBean) {
        if (userBean != null) {
            try {
                VipMakerMarkUtil.m9495a(this.f533g, this.f530d, this.f532f, this.f531e, userBean);
                this.f529c.setText(userBean.getNickname());
                ImgLoader.m9426b(this, userBean.getAvatar_url(), this.f528b);
                this.f534h.setText(String.format("ID：%s", String.valueOf(userBean.getUid())));
                this.f539m.setText(NumberUtil.m9067a(userBean.getFans_count(), 2));
                this.f540n.setText(NumberUtil.m9067a(userBean.getFollowed_count(), 2));
                this.f541o.setText(NumberUtil.m9067a(userBean.getFabulous_count(), 2));
                this.f542p.setText(CustomWordUtil.m9461b(userBean.getPerson_signnatrue()));
                this.f544r.setTitle(userBean.getNickname());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /* renamed from: b */
    public final void m21090b(boolean z, int i) {
        if (z) {
            this.f535i.setVisibility(View.VISIBLE);
            this.f538l.setVisibility(View.GONE);
            this.f535i.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.c.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Toast.makeText(HomePageActivity.this, "HomePageActivity.this.m21087d(view)288", Toast.LENGTH_SHORT).show();
                    HomePageActivity.this.m21087d(view);
                }
            });
            return;
        }
        this.f535i.setVisibility(View.GONE);
        m21082l(i);
    }
    /* renamed from: d */
    public /* synthetic */ void m21087d(View view) {
//        EditProfileActivity.m21162a(this);
        Toast.makeText(HomePageActivity.this, "EditProfileActivity.m21162a(this)315", Toast.LENGTH_SHORT).show();
    }


    /* renamed from: l */
    public final void m21082l(int i) {
        if (i == 1) {
            this.f538l.setVisibility(View.VISIBLE);
            this.f538l.setSelected(true);
            this.f536j.setVisibility(View.GONE);
            this.f537k.setText(getString(R.string.following));
            this.f537k.setTextColor(getResources().getColor(R.color.white));
            return;
        }
        this.f538l.setVisibility(View.VISIBLE);
        this.f538l.setSelected(false);
        this.f536j.setVisibility(View.VISIBLE);
        this.f537k.setText(getString(R.string.follow));
        this.f537k.setTextColor(getResources().getColor(R.color.black));
    }


    /* renamed from: f */
    public final void m21083f(boolean z) {
        ArrayList arrayList = new ArrayList();
        this.f551y = new ArrayList();
//        、、視頻
        arrayList.add(PersonalVideoListFragment.m20383a(1, this.f548v));
        this.f551y.add(CustomWordUtil.m9463a((int) R.string.str_video));
//        、、合集
        arrayList.add(PersonalVideoCollectListFragment.m20389a(1, this.f548v));
        this.f551y.add(CustomWordUtil.m9463a((int) R.string.str_set));
        this.f547u.setAdapter(new CommonPagerAdapter(getSupportFragmentManager(), arrayList));
    }



    /* renamed from: N */
    public final void m21104N() {
        try {
            CommonNavigator commonNavigator = new CommonNavigator(this);
            commonNavigator.setAdjustMode(false);
            commonNavigator.setAdapter(new C0630b());
            this.f545s.setNavigator(commonNavigator);
            ViewPagerHelper.m8992a(this.f545s, this.f547u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: com.blmvl.blvl.activity.HomePageActivity$b */
    /* loaded from: classes.dex */
    public class C0630b extends CommonNavigatorAdapter {
        public C0630b() {
        }

        @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.CommonNavigatorAdapter
        /* renamed from: a */
        public int mo8987a() {
            if (HomePageActivity.this.f551y == null) {
                return 0;
            }
            return HomePageActivity.this.f551y.size();
        }

        @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.CommonNavigatorAdapter
        /* renamed from: a */
        public IPagerTitleView mo8985a(Context context, int i) {
            return CustomMagicIndicatorUtil.m9466a(context, i, HomePageActivity.this.f551y, HomePageActivity.this.f547u, 16, HomePageActivity.this.getResources().getColor(R.color.color_999), HomePageActivity.this.getResources().getColor(R.color.color_1a));
        }

        @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.CommonNavigatorAdapter
        /* renamed from: a */
        public IPagerIndicator mo8986a(Context context) {
            return CustomMagicIndicatorUtil.m9469a(context, HomePageActivity.this.getResources().getColor(R.color.color_fcd935));
        }
    }



























    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onChangePositionEvent(PositionChangeEvent positionChangeEvent) {
        try {
            if (positionChangeEvent.getFrom() == 13 || positionChangeEvent.getFrom() == 14) {
                this.f546t.setExpanded(false, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HttpUtil.m9783a(this.f548v, new C0631c());
//        Toast.makeText(this, "HttpUtil.m9783a(this.f548v, new C0631c())", Toast.LENGTH_SHORT).show();
    }


    /* renamed from: com.blmvl.blvl.activity.HomePageActivity$c */
    /* loaded from: classes.dex */
    public class C0631c extends CommonCallback<Integer> {
        public C0631c() {
        }

        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo9799a(Integer num) {
            HomePageActivity.this.m21082l(num.intValue());
            int fans_count = HomePageActivity.this.f552z.getFans_count();
            int max = num.intValue() == 1 ? fans_count + 1 : Math.max(fans_count - 1, 0);
            HomePageActivity.this.f552z.setFans_count(max);
            HomePageActivity.this.f539m.setText(NumberUtil.m9067a(max, 2));
        }
    }





    @Override // com.blmvl.blvl.activity.AbsActivity, android.support.p004v7.app.AppCompatActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
//        EventBus.m309d().m308d(this);
        //取消注册
        EventBus.getDefault().unregister(this);
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(FollowEvent followEvent) {
        try {
            if (this.f548v == followEvent.getToUid()) {
                m21090b(this.f548v == AppUser.getInstance().getUser().getUid(), followEvent.getIsAttention());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPersonalSearchEvent(PersonalSearchEvent personalSearchEvent) {
        try {
            if (this.f546t != null) {
                this.f546t.setExpanded(false, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUserInfoChangeEvent(UserInfoChangeEvent userInfoChangeEvent) {
        try {
            m21094a(AppUser.getInstance().getUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 搜索
     * @return
     */
    /* renamed from: a */
    public /* synthetic */ void m21101a(AppBarLayout appBarLayout, int i) {
        this.f543q.setNavigationIcon(R.mipmap.ic_back_black);
        this.f543q.setBackgroundColor(ColorUtil.m9199a(this, R.color.transparent));
        if (i == 0) {
            this.f543q.setNavigationIcon(R.mipmap.ic_back_white);
//            ImmersionBar b = ImmersionBar.m5078b(this);
//            b.m5105D();
//            b.m5070c(false);
//            b.m5072c(R.color.white);
//            b.m5045w();
            ImmersionBar mBarParams = ImmersionBar.with(this);
            mBarParams.reset();
            mBarParams.autoDarkModeEnable(false);
            mBarParams.navigationBarColor(R.color.white);
            mBarParams.init();

        } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
//            ImmersionBar b2 = ImmersionBar.m5078b(this);
//            b2.m5105D();
//            b2.m5075b(true, 0.2f);
//            b2.m5072c(R.color.white);
//            b2.m5045w();
            ImmersionBar mBarParams = ImmersionBar.with(this);
            mBarParams.reset();
            mBarParams.navigationBarDarkIcon(true, 0.8f);
            mBarParams.navigationBarColor(R.color.white);
            mBarParams.init();
        }
        this.f549w = Math.abs(i);
        this.f550x = appBarLayout.getTotalScrollRange();
        int i2 = (int) (((this.f549w * 1.0f) / this.f550x) * 255.0f);
        if (i2 >= 255) {
            i2 = 255;
        }
        this.f543q.setBackgroundColor(Color.argb(i2, 255, 255, 255));
        this.f544r.setCollapsedTitleTextColor(Color.argb(i2, 0, 0, 0));
    }



    @Override
    public int mo20588z() {
        return R.layout.activity_home_page;
    }



    /* renamed from: a */
    public static void m21102a(Context context, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("uid", i);
        IntentUtil.m9080a(context, HomePageActivity.class, bundle);
    }



}