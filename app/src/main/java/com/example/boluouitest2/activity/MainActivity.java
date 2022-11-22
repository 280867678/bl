package com.example.boluouitest2.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.AppConfig;
import com.example.boluouitest2.comod.baselib.view.ComViewPagerHelper;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.IPagerTitleView;
import com.example.boluouitest2.comod.baselib.view.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;
import com.example.boluouitest2.fragment.GameFragment;
import com.example.boluouitest2.fragment.HomeFragment;
import com.example.boluouitest2.fragment.LiveHomeFragment;
import com.example.boluouitest2.fragment.MainVideoFeaturedFragment;
import com.example.boluouitest2.fragment.MineFragment;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.slzhibo.library.SLLiveSDK;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.IntentUtil;
import com.example.boluouitest2.util.SpUtil;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AbsActivity {
    /* renamed from: e */
    public ComViewPagerHelper f598e;

    /* renamed from: f */
    public ImageView f599f;

    /* renamed from: g */
    public ImageView f600g;

    /* renamed from: h */
    public FrameLayout f601h;

    /* renamed from: b */
    public long f595b = 0;

    /* renamed from: c */
    public List<String> f596c = new ArrayList();

    /* renamed from: d */
    public List<Integer> f597d = new ArrayList();

    /* renamed from: i */
    public int f602i = 0;

    /* renamed from: j */
    public boolean f603j = false;




    @Override // com.blmvl.blvl.activity.AbsActivity
    /* renamed from: B */
    public void mo20620B() {
        super.mo20620B();
//        ImmersionBar b = ImmersionBar.m5078b(this);
//        b.m5105D();
//        b.m5082a(true, R.color.white);        fitsSystemWindows
//        b.m5075b(true, 0.2f);                 navigationBarDarkIcon  autoDarkModeEnable  autoStatusBarDarkModeEnable  autoNavigationBarDarkModeEnable
//        b.m5072c(R.color.white);              navigationBarColor
//        b.m5045w();


        ImmersionBar mBarParams = ImmersionBar.with(this);
        mBarParams.reset();
        mBarParams.fitsSystemWindows(true, R.color.white);
        mBarParams.autoDarkModeEnable(true, 0.2f);      ////////
        mBarParams.navigationBarColor(R.color.white);      ///////
        mBarParams.init();
//        ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_BAR).init();
    }



    /* renamed from: a */
    public static void m21036a(Context context) {
        IntentUtil.m9081a(context, MainActivity.class);
    }


    @Override
    public void mo20592a(Bundle bundle) {
        m21042G();
        m21039R(); //初始化控件
//        m21040Q();

        //直播
        SLLiveSDK.getSingleton().loadOperationActivityDialog(this);
        SLLiveSDK.getSingleton().initAnim();
//        LogUtil.m9410a("BL_MAIN_PAGE");
    }

    /* renamed from: G */
    public final void m21042G() {
        this.f596c.add(CustomWordUtil.m9463a((int) R.string.str_home));   //首页
        this.f596c.add(CustomWordUtil.m9463a((int) R.string.featured));   //精選
        if (SpUtil.m9573D().m9515y()) {
            this.f596c.add(CustomWordUtil.m9463a((int) R.string.live));  //直播
        }
        if (SpUtil.m9573D().m9574C() == 1) {
            this.f596c.add(CustomWordUtil.m9463a((int) R.string.str_game)); //游戏
        }
        this.f596c.add(CustomWordUtil.m9463a((int) R.string.mine));    //我的
        ArrayList arrayList = new ArrayList();
        arrayList.add(HomeFragment.newInstance());
        arrayList.add(MainVideoFeaturedFragment.newInstance());
        if (SpUtil.m9573D().m9515y()) {
            arrayList.add(LiveHomeFragment.newInstance(false));
        }
        if (SpUtil.m9573D().m9574C() == 1) {
            arrayList.add(GameFragment.m20456b("/api/game/index", 2));
        }
        arrayList.add(MineFragment.newInstance());
        this.f597d.add(Integer.valueOf((int) R.drawable.ic_video_seletor));
        this.f597d.add(Integer.valueOf((int) R.drawable.ic_featured_seletor));
        if (SpUtil.m9573D().m9515y()) {
            this.f597d.add(Integer.valueOf((int) R.drawable.ic_live_seletor));
        }
        if (SpUtil.m9573D().m9574C() == 1) {
            this.f597d.add(Integer.valueOf((int) R.drawable.ic_game_seletor));
        }
        this.f597d.add(Integer.valueOf((int) R.drawable.ic_mine_seletor));
        this.f598e = new C0639a(this, this, this.f596c, arrayList, this.f597d, getSupportFragmentManager());
    }




    @Override
    public int mo20588z() {
        return R.layout.activity_main;
    }




    /* renamed from: R */
    public final void m21039R() {
        this.f599f = (ImageView) findViewById(R.id.img_game);
        this.f600g = (ImageView) findViewById(R.id.img_close);
        this.f600g.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.c.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
//                MainActivity.this.m21035a(view);
                Toast.makeText(MainActivity.this, "MainActivity.this.m21035a(view)164", Toast.LENGTH_SHORT).show();
            }
        });
        this.f601h = (FrameLayout) findViewById(R.id.layout_game);
        this.f601h.setVisibility(View.GONE);
        if (SpUtil.m9573D().m9574C() == 1) {
            if (!(AppConfig.getInstance().getConfig() == null || AppConfig.getInstance().getConfig().getGame_float() == null || TextUtils.isEmpty(AppConfig.getInstance().getConfig().getGame_float().getIcon()))) {
                this.f601h.setVisibility(View.VISIBLE);
                ImgLoader.m9424b(AppConfig.getInstance().getConfig().getGame_float().getIcon(), this.f599f, (int) R.drawable.bg_square_default);
            }
            this.f601h.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.c.h0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
//                    MainActivity.this.m21032b(view);
                    Toast.makeText(MainActivity.this, "MainActivity.this.m21032b(view)178", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }































    /* renamed from: com.blmvl.blvl.activity.MainActivity$a */
    /* loaded from: classes.dex */
    public class C0639a extends ComViewPagerHelper {

        /* renamed from: com.blmvl.blvl.activity.MainActivity$a$a */
        /* loaded from: classes.dex */
        public class C0640a implements CommonPagerTitleView.AbstractC0922b {

            /* renamed from: a */
            public final /* synthetic */ ImageView f605a;

            /* renamed from: b */
            public final /* synthetic */ TextView f606b;

            public C0640a(C0639a aVar, ImageView imageView, TextView textView) {
                this.f605a = imageView;
                this.f606b = textView;
            }

            @Override // com.comod.view.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView.AbstractC0922b
            /* renamed from: a */
            public void mo19970a(int i, int i2) {
                this.f605a.setSelected(false);
                this.f606b.setSelected(false);
            }

            @Override // com.comod.view.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView.AbstractC0922b
            /* renamed from: a */
            public void mo19969a(int i, int i2, float f, boolean z) {
            }

            @Override // com.comod.view.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView.AbstractC0922b
            /* renamed from: b */
            public void mo19968b(int i, int i2) {
                this.f605a.setSelected(true);
                this.f606b.setSelected(true);
            }

            @Override // com.comod.view.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView.AbstractC0922b
            /* renamed from: b */
            public void mo19967b(int i, int i2, float f, boolean z) {
            }
        }

        public C0639a(Context context, Activity activity, List list, List list2, List list3, FragmentManager fragmentManager) {
            super(context, activity, list, list2, list3, fragmentManager);
        }

        @Override // p067e.p130f.p131a.p135d.ComViewPagerHelper
        /* renamed from: a */
        public IPagerTitleView mo9153a(Context context, final int i, ViewPager viewPager, List<String> list, List<Integer> list2) {
            CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);
            View inflate = LayoutInflater.from(context).inflate(R.layout.view_main_bottom_tab, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_tab);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.img_tab);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.img_badge);
            textView.setText((CharSequence) MainActivity.this.f596c.get(i));
            if (((String) MainActivity.this.f596c.get(i)).equals(CustomWordUtil.m9463a((int) R.string.str_game))) {
                MainActivity.this.f602i = i;
                imageView2.setVisibility(View.VISIBLE);
            } else {
                imageView2.setVisibility(View.INVISIBLE);
            }
            textView.setTextColor(MainActivity.this.getResources().getColorStateList(R.color.main_tab_text_dark_selector));
            imageView.setImageResource(list2.get(i).intValue());
            commonPagerTitleView.setContentView(inflate);
            commonPagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.c.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.C0639a.this.m21025a(i, view);
                }
            });
            commonPagerTitleView.setOnPagerTitleChangeListener(new C0640a(this, imageView, textView));
            return commonPagerTitleView;
        }

        @Override // p067e.p130f.p131a.p135d.ComViewPagerHelper
        /* renamed from: a */
        public boolean mo9157a() {
            return true;
        }


        @Override // p067e.p130f.p131a.p135d.ComViewPagerHelper
        /* renamed from: b */
        public void mo9148b(int i) {
            super.mo9148b(i);
            if (SpUtil.m9573D().m9574C() == 1) {
                if (i == MainActivity.this.f602i) {
                    if (MainActivity.this.f601h.getVisibility() == View.VISIBLE) {
                        MainActivity.this.f601h.setVisibility(View.GONE);
                    }
                } else if (!MainActivity.this.f603j && MainActivity.this.f601h.getVisibility() == View.GONE) {
                    if (AppConfig.getInstance().getConfig() == null || AppConfig.getInstance().getConfig().getGame_float() == null || TextUtils.isEmpty(AppConfig.getInstance().getConfig().getGame_float().getIcon())) {
                        MainActivity.this.f601h.setVisibility(View.GONE);
                    } else {
                        MainActivity.this.f601h.setVisibility(View.VISIBLE);
                    }
                }
            }
            if (i == m9146c() - 1) {

//                ImmersionBar b = ImmersionBar.m5078b(MainActivity.this);
//                b.m5105D();
//                b.m5075b(true, 0.8f);
//                b.m5072c(R.color.white);
//                b.m5045w();


                ImmersionBar mBarParams = ImmersionBar.with(MainActivity.this);
                mBarParams.reset();
                mBarParams.navigationBarDarkIcon(true, 0.8f);
                mBarParams.navigationBarColor(R.color.white);      ////////
                mBarParams.init();

//                ImmersionBar.with(MainActivity.this).hideBar(BarHide.FLAG_HIDE_BAR).init();
                return;
            }
//            ImmersionBar.with(MainActivity.this).hideBar(BarHide.FLAG_HIDE_BAR).init();
//            ImmersionBar b2 = ImmersionBar.m5078b(MainActivity.this);
//            b2.m5105D();
//            b2.m5082a(true, R.color.white);
//            b2.m5075b(true, 0.2f);
//            b2.m5072c(R.color.white);
//            b2.m5045w();

            ImmersionBar mBarParams2 = ImmersionBar.with(MainActivity.this);
            mBarParams2.reset();
            mBarParams2.fitsSystemWindows(true, R.color.white);
            mBarParams2.navigationBarDarkIcon(true, 0.2f);      ////////
            mBarParams2.navigationBarColor(R.color.white);      ///////
            mBarParams2.init();
        }

        /* renamed from: a */
        public /* synthetic */ void m21025a(int i, View view) {
            m9145c(i);
        }
    }








}