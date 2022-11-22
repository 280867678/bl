package com.example.boluouitest2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.boluouitest2.EventBus.CurSelectVideoIdEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.bean.VideoDetailBean;
import com.example.boluouitest2.comod.baselib.view.ComViewPagerHelper;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.IPagerIndicator;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.IPagerTitleView;
import com.example.boluouitest2.fragment.VideoCommentDetailInfoFragment;
import com.example.boluouitest2.fragment.VideoDetailInfoFragment;
import com.example.boluouitest2.httpUtil.HttpCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.util.CustomLayoutParamsUtil;
import com.example.boluouitest2.util.CustomMagicIndicatorUtil;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.IntentUtil;
import com.example.boluouitest2.util.ObjUtil;
import com.example.boluouitest2.videoplayer.HVideoPlayer;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.GSYVideoHelper;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;

import java.util.ArrayList;
import java.util.List;

public class VideoDetailInfoActivity extends AbsActivity {
    /* renamed from: b */
    public HVideoPlayer f917b;

    /* renamed from: c */
    public LinearLayout f918c;

    /* renamed from: f */
    public OrientationUtils f921f;

    /* renamed from: g */
    public GSYVideoOptionBuilder f922g;

    /* renamed from: h */
    public VideoBean f923h;

    /* renamed from: j */
    public VideoDetailInfoFragment f925j;

    /* renamed from: k */
    public VideoCommentDetailInfoFragment f926k;

    /* renamed from: d */
    public boolean f919d = false;

    /* renamed from: e */
    public boolean f920e = true;

    /* renamed from: i */
    public boolean f924i = false;


    @Override
    public void mo20592a(Bundle bundle) {
        getWindow().setFlags(8192, 8192);
        m20693Q();
        m20695G();
        m20694N();
//        EventBus.m309d().m310c(this);
        EventBus.getDefault().register(this);
    }

    /* renamed from: Q */
    public final void m20693Q() {
        this.f918c = (LinearLayout) findViewById(R.id.layout_complaint);
        this.f918c.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.c.f2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoDetailInfoActivity.this.m20683b(view);
                Toast.makeText(VideoDetailInfoActivity.this, "VideoDetailInfoActivity.this.m20683b(view)66", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /* renamed from: G */
    public final void m20695G() {
        try {
            this.f917b = (HVideoPlayer) findViewById(R.id.videoPlayer);
            CustomLayoutParamsUtil.m9474a(this, this.f917b);
            this.f917b.setLooping(true);
            this.f917b.setShowPauseCover(true);
            this.f921f = new OrientationUtils(this, this.f917b);
            this.f921f.setEnable(false);
            this.f922g = new GSYVideoOptionBuilder();
            this.f922g.setCacheWithPlay(true)
                    .setFullHideActionBar(true)
                    .setFullHideStatusBar(true)
                    .setIsTouchWiget(false)
                    .setRotateViewAuto(false)
                    .setLockLand(true)
                    .setAutoFullWithSize(true)
                    .setShowFullAnimation(false)
                    .setNeedLockFull(true)
                    .setEnlargeImageRes(R.mipmap.ic_enter_fullscreen)
                    .setShrinkImageRes(R.mipmap.ic_exit_fullscreen)
                    .setLockClickListener(new LockClickListener() {
                        @Override
                        public void onClick(View view, boolean lock) {
                            Toast.makeText(VideoDetailInfoActivity.this, "VideoDetailInfoActivity.this.m20688a(view, z)87", Toast.LENGTH_SHORT).show();
                        } // from class: e.c.a.c.e2
                        //                @Override // p067e.p291s.p292a.p295f.LockClickListener
                        //                /* renamed from: a */
                        //                public final void mo4671a(View view, boolean z) {
//                                            VideoDetailInfoActivity.this.m20688a(view, z);
                        //                }
                    }).setVideoAllCallBack(new C0698c()).build((StandardGSYVideoPlayer) this.f917b);
            ///全屏
            this.f917b.getFullscreenButton().setOnClickListener(new View.OnClickListener() { // from class: e.c.a.c.d2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoDetailInfoActivity.this.m20689a(view);
//                    Toast.makeText(VideoDetailInfoActivity.this, "哈哈138", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /* renamed from: N */
    public final void m20694N() {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(CustomWordUtil.m9463a((int) R.string.str_detail));
            arrayList.add(CustomWordUtil.m9463a((int) R.string.str_comment));
            this.f925j = new VideoDetailInfoFragment();
            arrayList2.add(this.f925j);
            this.f926k = new VideoCommentDetailInfoFragment();
            arrayList2.add(this.f926k);
            new C0696a(this, this, this, arrayList, arrayList2, null, getSupportFragmentManager());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public int mo20588z() {
        return R.layout.activity_video_detail_info;
    }


    /* renamed from: a */
    public static void m20690a(Context context) {
        IntentUtil.m9081a(context, VideoDetailInfoActivity.class);
    }


    /* renamed from: com.blmvl.blvl.activity.VideoDetailInfoActivity$c */
    /* loaded from: classes.dex */
    public class C0698c extends GSYSampleCallBack {
        public C0698c() {
        }

        @Override
        public void onQuitFullscreen(String url, Object... objects) {
            super.onQuitFullscreen(url, objects);
            try {
                if (VideoDetailInfoActivity.this.f921f != null) {
                    VideoDetailInfoActivity.this.f921f.backToProtVideo();
                }
                HVideoPlayer hVideoPlayer = (HVideoPlayer) objects[1];
                if (hVideoPlayer != null) {
                    hVideoPlayer.setVideoData(VideoDetailInfoActivity.this.f923h, false);
                    hVideoPlayer.getLockView().setVisibility(View.GONE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        //        mo4662i = = onQuitFullscreen
//        @Override // p067e.p291s.p292a.p295f.GSYSampleCallBack, p067e.p291s.p292a.p295f.VideoAllCallBack
//        /* renamed from: i */
//        public void mo4662i(String str, Object... objArr) {
//            super.mo4662i(str, objArr);
//            try {
//                if (VideoDetailInfoActivity.this.f921f != null) {
//                    VideoDetailInfoActivity.this.f921f.backToProtVideo();
//                }
//                HVideoPlayer hVideoPlayer = (HVideoPlayer) objArr[1];
//                if (hVideoPlayer != null) {
//                    hVideoPlayer.setVideoData(VideoDetailInfoActivity.this.f923h, false);
//                    hVideoPlayer.getLockView().setVisibility(View.GONE);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        @Override
        public void onPrepared(String url, Object... objects) {
            super.onPrepared(url, objects);
            try {
                if (VideoDetailInfoActivity.this.f921f != null) {
                    VideoDetailInfoActivity.this.f921f.setEnable(true);
                }
                VideoDetailInfoActivity.this.f919d = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


//        mo4659l ===onPrepared
//        @Override // p067e.p291s.p292a.p295f.GSYSampleCallBack, p067e.p291s.p292a.p295f.VideoAllCallBack
//        /* renamed from: l */
//        public void mo4659l(String str, Object... objArr) {
//            super.mo4659l(str, objArr);
//            try {
//                if (VideoDetailInfoActivity.this.f921f != null) {
//                    VideoDetailInfoActivity.this.f921f.setEnable(true);
//                }
//                VideoDetailInfoActivity.this.f919d = true;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        @Override
        public void onEnterFullscreen(String url, Object... objects) {
            super.onEnterFullscreen(url, objects);
            try {
                HVideoPlayer hVideoPlayer = (HVideoPlayer) objects[1];
                if (hVideoPlayer != null) {
                    hVideoPlayer.setVideoData(VideoDetailInfoActivity.this.f923h, false);
                    hVideoPlayer.getLockView().setVisibility(View.VISIBLE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



//        mo4658m  ==onEnterFullscreen


//        @Override // p067e.p291s.p292a.p295f.GSYSampleCallBack, p067e.p291s.p292a.p295f.VideoAllCallBack
//        /* renamed from: m */
//        public void mo4658m(String str, Object... objArr) {
//            super.mo4658m(str, objArr);
//            try {
//                HVideoPlayer hVideoPlayer = (HVideoPlayer) objArr[1];
//                if (hVideoPlayer != null) {
//                    hVideoPlayer.setVideoData(VideoDetailInfoActivity.this.f923h, false);
//                    hVideoPlayer.getLockView().setVisibility(View.VISIBLE);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }


    /* renamed from: com.blmvl.blvl.activity.VideoDetailInfoActivity$a */
    /* loaded from: classes.dex */
    public class C0696a extends ComViewPagerHelper {
        public C0696a(VideoDetailInfoActivity videoDetailInfoActivity, Context context, Activity activity, List list, List list2, List list3, FragmentManager fragmentManager) {
            super(context, activity, list, list2, list3, fragmentManager);
        }

        @Override // p067e.p130f.p131a.p135d.ComViewPagerHelper
        /* renamed from: a */
        public IPagerTitleView mo9153a(Context context, int i, ViewPager viewPager, List<String> list, List<Integer> list2) {
            return CustomMagicIndicatorUtil.m9467a(context, i, list, viewPager);
        }

        @Override // p067e.p130f.p131a.p135d.ComViewPagerHelper
        /* renamed from: a */
        public boolean mo9157a() {
            return false;
        }

        @Override // p067e.p130f.p131a.p135d.ComViewPagerHelper
        /* renamed from: c */
        public IPagerIndicator mo9144c(Context context) {
            return CustomMagicIndicatorUtil.m9464b(context);
        }
    }


    @Override
    // android.support.p004v7.app.AppCompatActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            if (this.f919d && !this.f920e && this.f917b != null && this.f921f != null) {
                this.f917b.onConfigurationChanged(this, configuration, this.f921f, true, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCurSelectVideoIdEvent(CurSelectVideoIdEvent curSelectVideoIdEvent) {
        try {
            m20677l(curSelectVideoIdEvent.getVideoId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: l */
    public final void m20677l(int i) {
        if (!this.f924i) {
            if (i == -1) {
                finish();
                return;
            }
            this.f924i = true;
            HttpUtil.m9738b(i, new C0697b());
        }
    }

    /* renamed from: com.blmvl.blvl.activity.VideoDetailInfoActivity$b */
    /* loaded from: classes.dex */
    public class C0697b extends HttpCallback {
        public C0697b() {
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onError() {
            super.onError();
            VideoDetailInfoActivity.this.f924i = false;
            VideoDetailInfoActivity.this.finish();
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onException(int i, String str) {
            super.onException(i, str);
            VideoDetailInfoActivity.this.f924i = false;
            VideoDetailInfoActivity.this.finish();
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onNetworkError() {
            super.onNetworkError();
            VideoDetailInfoActivity.this.f924i = false;
            VideoDetailInfoActivity.this.finish();
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onSuccess(String str, String str2, boolean z, boolean z2) {
            super.onSuccess(str, str2, z, z2);
            VideoDetailInfoActivity.this.f924i = false;
            Log.e("播放地址呢1：：：：", "videoBean.getPlay_url()");
            Log.e("HttpCallback111386：：：：", str);
            try {
                if (!TextUtils.isEmpty(str)) {
                    VideoDetailBean videoDetailBean = (VideoDetailBean) JSON.parseObject(str, VideoDetailBean.class);
                    VideoDetailInfoActivity.this.f923h = videoDetailBean.getRow();
                    if (ObjUtil.m9224a(VideoDetailInfoActivity.this.f923h)) {
                        VideoDetailInfoActivity.this.f923h.setMy_ticket_number(videoDetailBean.getMy_ticket_number());
                        VideoDetailInfoActivity.this.m20684a(VideoDetailInfoActivity.this.f923h);
                        if (VideoDetailInfoActivity.this.f925j != null) {
                            //详情页
                            VideoDetailInfoActivity.this.f925j.m20242c(videoDetailBean);
                        }
                        if (VideoDetailInfoActivity.this.f926k != null) {
                            //评论页
//                            VideoDetailInfoActivity.this.f926k.m20287a(videoDetailBean.getRow());
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m20684a(VideoBean videoBean) {
//        Log.e("播放地址呢1：：：：", videoBean.getPlay_url());
        if (!TextUtils.isEmpty(videoBean.getPlay_url())) {
//            Log.e("播放地址呢：：：：", videoBean.getPlay_url());
            Log.e("播放地址呢：：：：", "VideoDetailInfoActivity::::"+videoBean.getPlay_url());
            this.f917b.setVideoData(videoBean, true);
        } else {
            finish();
        }
    }


    @Override
    // com.blmvl.blvl.activity.AbsActivity, android.support.p004v7.app.AppCompatActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.f919d) {
                this.f917b.getCurrentPlayer().release();
            }
            if (this.f921f != null) {
                this.f921f.releaseListener();
            }
//            EventBus.m309d().m308d(this);
            //取消注册
            EventBus.getDefault().unregister(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        HVideoPlayer hVideoPlayer = this.f917b;
        if (hVideoPlayer != null) {
            hVideoPlayer.getCurrentPlayer().onVideoPause();
        }
        super.onPause();
        this.f920e = true;
    }


    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        HVideoPlayer hVideoPlayer = this.f917b;
        if (hVideoPlayer != null) {
            hVideoPlayer.getCurrentPlayer().onVideoResume();
        }
        super.onResume();
        this.f920e = false;
    }


    /* renamed from: a */
    public void m20689a(View view) {
        m20691U();
    }


    /* renamed from: U */
    @SuppressLint("LongLogTag")
    public final void m20691U() {
        try {


            if (this.f919d && !this.f920e) {
//                Log.e("getFullscreenButton", "22");
                this.f917b.startWindowFullscreen(this, true, true);

                if (this.f921f != null && this.f921f.getIsLand() != 1) {
                    this.f921f.resolveByClick();
//                    Log.e("getFullscreenButton", "33");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override // com.blmvl.blvl.activity.AbsActivity
    /* renamed from: B */
    public void mo20620B() {
//        ImmersionBar b = ImmersionBar.m5078b(this);
//        b.m5105D();                       reset
//        b.m5082a(true, R.color.black);    fitsSystemWindows  fitsSystemWindowsInt
//        b.m5062g(R.color.black);        statusBarColor  navigationBarColor barColor  statusBarColorTransform  navigationBarColorTransform  barColorTransform  flymeOSStatusBarFontColor
//        b.m5072c(R.color.white);
//        b.m5045w();                   init



//        m5078b = with
//        m5105D = reset;

        ImmersionBar mBarParams = ImmersionBar.with(this);
        mBarParams.reset();
        mBarParams.fitsSystemWindows(true, R.color.black);
        mBarParams.statusBarColor(R.color.black);      ////////
        mBarParams.navigationBarColor(R.color.white);      ///////
        mBarParams.init();

//        ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_BAR).init();
    }


    /* renamed from: b */
    public /* synthetic */ void m20683b(View view) {
        m20692R();
    }

    /* renamed from: R */
    public final void m20692R() {
        try {
            if (ObjUtil.m9224a(this.f923h)) {
//                C4326m.m9108a(this, new ComplaintOptionsDialog(this, this.f923h));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}