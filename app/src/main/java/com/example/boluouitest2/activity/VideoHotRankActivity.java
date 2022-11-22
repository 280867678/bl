package com.example.boluouitest2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.alibaba.fastjson.JSON;
import com.example.boluouitest2.EventBus.PositionChangeEvent;
import com.example.boluouitest2.R;
import com.example.boluouitest2.TitleView.ScaleTransitionPagerTitleView;
import com.example.boluouitest2.bean.VideoCommentBean;
import com.example.boluouitest2.bean.VideoWithCommentBean;
import com.example.boluouitest2.comod.baselib.view.MyViewPager;
import com.example.boluouitest2.comod.baselib.view.ViewPagerHelper;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.CommonNavigatorAdapter;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.CommonPagerAdapter;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.IPagerIndicator;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.IPagerTitleView;
import com.example.boluouitest2.comod.baselib.view.magicindicator.CommonNavigator;
import com.example.boluouitest2.comod.baselib.view.magicindicator.MagicIndicator;
import com.example.boluouitest2.comod.baselib.view.magicindicator.buildins.commonnavigator.titles.LineGradientPagerIndicator;
import com.example.boluouitest2.fragment.HotVideoCollectListFragment;
import com.example.boluouitest2.fragment.VideoHotRankListFragment;
import com.example.boluouitest2.httpUtil.HttpCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.JumpUtil;
import com.example.boluouitest2.util.ObjUtil;
import com.example.boluouitest2.util.UIUtil;
import com.google.android.material.appbar.AppBarLayout;
import com.makeramen.roundedimageview.RoundedImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


/**
 * 热榜视频
 */
public class VideoHotRankActivity extends AbsActivity {
    /* renamed from: b */
    public ImageView f929b;

    /* renamed from: c */
    public TextView f930c;

    /* renamed from: d */
    public TextView f931d;

    /* renamed from: e */
    public MagicIndicator f932e;

    /* renamed from: f */
    public MyViewPager f933f;

    /* renamed from: g */
    public List<String> f934g = null;

    /* renamed from: h */
    public RoundedImageView f935h;

    /* renamed from: i */
    public ViewFlipper f936i;

    /* renamed from: j */
    public FrameLayout f937j;

    /* renamed from: k */
    public int f938k;

    /* renamed from: l */
    public AppBarLayout f939l;

    /* renamed from: a */
    public static void m20671a(Context context, int i) {
        Intent intent = new Intent(context, VideoHotRankActivity.class);
        intent.putExtra("index", i);
        context.startActivity(intent);
    }




    @Override
    public void mo20592a(Bundle bundle) {
        this.f938k = getIntent().getIntExtra("index", 0);
        m20672U();
        m20675N();
        m20676G();
        m20673R();
        m20674Q();
//        EventBus.m309d().m310c(this);
        EventBus.getDefault().register(this);
//        LogUtil.m9410a("BL_VIDEO_HOT_RANK_PAGE");
    }


    /* renamed from: U */
    public final void m20672U() {
        this.f929b = (ImageView) findViewById(R.id.img_back);
        this.f930c = (TextView) findViewById(R.id.tv_title);
        this.f931d = (TextView) findViewById(R.id.tv_hint);
        this.f932e = (MagicIndicator) findViewById(R.id.indicator);
        this.f933f = (MyViewPager) findViewById(R.id.viewPager);
        this.f929b.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.c.i2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
//                VideoHotRankActivity.this.m20670a(view);
                Toast.makeText(VideoHotRankActivity.this, " VideoHotRankActivity.this.m20670a(view):::125", Toast.LENGTH_SHORT).show();
            }
        });
        this.f935h = (RoundedImageView) findViewById(R.id.img_cover);
        this.f936i = (ViewFlipper) findViewById(R.id.vf_comment);
        this.f937j = (FrameLayout) findViewById(R.id.layout_hot_video);
        this.f939l = (AppBarLayout) findViewById(R.id.appBarLayout);
    }

    /* renamed from: N */
    public final void m20675N() {
        this.f934g = new ArrayList();
        this.f934g.add(CustomWordUtil.m9463a((int) R.string.str_hot_like));
        this.f934g.add(CustomWordUtil.m9463a((int) R.string.str_hot_video_buy));
        this.f934g.add(CustomWordUtil.m9463a((int) R.string.str_hot_video_collect));
    }


    /* renamed from: G */
    public final void m20676G() {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(VideoHotRankListFragment.m20232a(1, 1));
            arrayList.add(VideoHotRankListFragment.m20232a(2, 1));
            arrayList.add(HotVideoCollectListFragment.newInstance());
            this.f933f.setAdapter(new CommonPagerAdapter(getSupportFragmentManager(), arrayList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: R */
    public final void m20673R() {
        try {
            CommonNavigator commonNavigator = new CommonNavigator(this);
            commonNavigator.setAdapter(new C0700b());
            this.f932e.setNavigator(commonNavigator);
            ViewPagerHelper.m8992a(this.f932e, this.f933f);
            this.f933f.setCurrentItem(this.f938k);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: com.blmvl.blvl.activity.VideoHotRankActivity$b */
    /* loaded from: classes.dex */
    public class C0700b extends CommonNavigatorAdapter {
        public C0700b() {
        }

        @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.CommonNavigatorAdapter
        /* renamed from: a */
        public int mo8987a() {
            if (VideoHotRankActivity.this.f934g == null) {
                return 0;
            }
            return VideoHotRankActivity.this.f934g.size();
        }

        @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.CommonNavigatorAdapter
        /* renamed from: a */
        public IPagerTitleView mo8985a(Context context, final int i) {
            ScaleTransitionPagerTitleView scaleTransitionPagerTitleView = new ScaleTransitionPagerTitleView(context);
            scaleTransitionPagerTitleView.setText((CharSequence) VideoHotRankActivity.this.f934g.get(i));
            scaleTransitionPagerTitleView.setTextSize(16.0f);
            scaleTransitionPagerTitleView.setNormalColor(VideoHotRankActivity.this.getResources().getColor(R.color.color_80fff));
            scaleTransitionPagerTitleView.setSelectedColor(VideoHotRankActivity.this.getResources().getColor(R.color.white));
            scaleTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.c.h2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoHotRankActivity.C0700b.this.m20661a(i, view);
                }
            });
            return scaleTransitionPagerTitleView;
        }

        /* renamed from: a */
        public /* synthetic */ void m20661a(int i, View view) {
            VideoHotRankActivity.this.f933f.setCurrentItem(i);
        }

        @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.CommonNavigatorAdapter
        /* renamed from: a */
        public IPagerIndicator mo8986a(Context context) {
            LineGradientPagerIndicator lineGradientPagerIndicator = new LineGradientPagerIndicator(context);
            lineGradientPagerIndicator.setMode(2);
            lineGradientPagerIndicator.setLineHeight(UIUtil.m8988a(context, 3.0d));
            lineGradientPagerIndicator.setLineWidth(UIUtil.m8988a(context, 18.0d));
            lineGradientPagerIndicator.setRoundRadius(UIUtil.m8988a(context, 3.0d));
            lineGradientPagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            lineGradientPagerIndicator.setEndInterpolator(new DecelerateInterpolator(1.5f));
            lineGradientPagerIndicator.setGradientColorList(new int[]{VideoHotRankActivity.this.getResources().getColor(R.color.color_cb4aed), VideoHotRankActivity.this.getResources().getColor(R.color.color_5d3ef9)});
            lineGradientPagerIndicator.setGradientPositionList(new float[]{0.0f, 1.0f});
            return lineGradientPagerIndicator;
        }
    }

    /* renamed from: Q */
    public final void m20674Q() {
        HttpUtil.m9642u(new C0699a());
    }

    /* renamed from: com.blmvl.blvl.activity.VideoHotRankActivity$a */
    /* loaded from: classes.dex */
    public class C0699a extends HttpCallback {
        public C0699a() {
        }

        /* renamed from: a */
        public /* synthetic */ void m20662a(VideoWithCommentBean videoWithCommentBean, View view) {
            try {
                if (ObjUtil.m9224a(videoWithCommentBean)) {
                    JumpUtil.m9417a().m9414a(VideoHotRankActivity.this, videoWithCommentBean.getId());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onError() {
            super.onError();
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onException(int i, String str) {
            super.onException(i, str);
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onNetworkError() {
            super.onNetworkError();
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onSuccess(String str, String str2, boolean z, boolean z2) {
            super.onSuccess(str, str2, z, z2);
            try {
                List parseArray = JSON.parseArray(str, VideoWithCommentBean.class);
                if (!(parseArray == null || parseArray.isEmpty())) {
                    final VideoWithCommentBean videoWithCommentBean = (VideoWithCommentBean) parseArray.get(0);
                    if (videoWithCommentBean != null) {
                        if (!TextUtils.isEmpty(videoWithCommentBean.getTitle())) {
                            VideoHotRankActivity.this.f930c.setText(videoWithCommentBean.getTitle());
                        }
                        VideoHotRankActivity.this.f931d.setText(String.format("%s%s", String.valueOf(videoWithCommentBean.getComment()), VideoHotRankActivity.this.getString(R.string.str_hot_talk_hint)));
                        ImgLoader.m9423c(VideoHotRankActivity.this, videoWithCommentBean.getCover_thumb_url(), VideoHotRankActivity.this.f935h);
                        List<VideoCommentBean> comment_list = videoWithCommentBean.getComment_list();
                        VideoHotRankActivity.this.f937j.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.c.g2
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                VideoHotRankActivity.C0699a.this.m20662a(videoWithCommentBean, view);
                            }
                        });
                        if (!(comment_list == null || comment_list.isEmpty())) {
                            for (int i = 0; i < comment_list.size(); i++) {
                                View inflate = LayoutInflater.from(VideoHotRankActivity.this).inflate(R.layout.layout_viewflipper_comment, (ViewGroup) null);
                                RoundedImageView roundedImageView = (RoundedImageView) inflate.findViewById(R.id.img_avatar);
                                TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
                                if (comment_list.get(i) != null) {
                                    String comment = comment_list.get(i).getComment();
                                    String avatar_url = comment_list.get(i).getUser().getAvatar_url();
                                    if (!TextUtils.isEmpty(comment)) {
                                        textView.setText(comment);
                                    }
                                    ImgLoader.m9426b(VideoHotRankActivity.this, avatar_url, roundedImageView);
                                }
                                VideoHotRankActivity.this.f936i.addView(inflate);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onChangePositionEvent(PositionChangeEvent positionChangeEvent) {
        try {
            if (positionChangeEvent.getFrom() == 8 || positionChangeEvent.getFrom() == 9) {
                this.f939l.setExpanded(false, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.blmvl.blvl.activity.AbsActivity, android.support.p004v7.app.AppCompatActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
//        EventBus.m309d().m308d(this);
        EventBus.getDefault().unregister(this);
    }







    @Override
    public int mo20588z() {
        return R.layout.activity_video_hot_rank;
    }
}