package com.example.boluouitest2.videoplayer;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.example.boluouitest2.EventBus.CurSelectVideoIdEvent;

import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.AppUser;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.comod.baselib.view.CustomTextView;
import com.example.boluouitest2.comod.baselib.view.ResizableImageView;
import com.example.boluouitest2.httpUtil.HttpCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.util.DpUtil;
import com.example.boluouitest2.util.PlayNumUtil;
import com.example.boluouitest2.util.SpUtil;
import com.example.boluouitest2.util.ToastUtil;
import com.example.boluouitest2.util.WordUtil;
import com.google.android.exoplayer2.util.Log;
import com.shuyu.gsyvideoplayer.listener.GSYVideoProgressListener;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import java.util.HashMap;

public class HVideoPlayer extends StandardGSYVideoPlayer implements View.OnClickListener {
    String url;


    public boolean isSubmited = false;
    public TextView mBtnGoInvite;
    public CustomTextView mBtnPayCoin;
    public TextView mBtnRechargeVip;
    public int mCurSeconds;
    public int mCurVideoDuration;
    public ImageView mImgSeekBack;
    public ImageView mImgSeekTo;
    public ImageView mImgStatus;
    public ResizableImageView mImgThumb;
    public LinearLayout mLayoutCoinVideoHint;
    public LinearLayout mLayoutRunOutHint;
    public FrameLayout mLayoutWatchVideoHint;
    public RelativeLayout mSurfaceContainer;
    public CustomTextView mTvCoinNum;
    public VideoBean mVideoBean;

    public HVideoPlayer(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buyVideoByCoin() {
        ToastUtil.m9102c(mContext,"HVideoPlayer:70:buyVideoByCoin()");
//        VideoBean videoBean = this.mVideoBean;
//        if (videoBean != null) {
//            HttpUtil.m9741b(videoBean.getId(), new HttpCallback() { // from class: com.blmvl.blvl.videoplayer.HVideoPlayer.3
//                @Override // p067e.p103c.p104a.p111i.HttpCallback
//                public void onError() {
//                    super.onError();
//                }
//
//                @Override // p067e.p103c.p104a.p111i.HttpCallback
//                public void onException(int i, String str) {
//                    super.onException(i, str);
//                    if (i == 1008) {
//                        try {
//                            new RechargeCoinDialogFragment().show(((AppCompatActivity) HVideoPlayer.this.getContext()).getSupportFragmentManager(), String.valueOf(HVideoPlayer.this.mVideoBean.getId()));
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            return;
//                        }
//                    }
//                    if (!TextUtils.isEmpty(str)) {
//                        ToastUtil.m9102c(HVideoPlayer.this.getContext(), str);
//                    }
//                }
//
//                @Override // p067e.p103c.p104a.p111i.HttpCallback
//                public void onNetworkError() {
//                    super.onNetworkError();
//                }
//
//                @Override // p067e.p103c.p104a.p111i.HttpCallback
//                public void onSuccess(String str, String str2, boolean z, boolean z2) {
//                    super.onSuccess(str, str2, z, z2);
//                    EventBus.m309d().m320a(new CurSelectVideoIdEvent(HVideoPlayer.this.mVideoBean.getId()));
//                    ToastUtil.m9102c(HVideoPlayer.this.getContext(), HVideoPlayer.this.getContext().getString(R.string.str_buy_success));
//                }
//            });
//        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buyVideoByTicket() {
        ToastUtil.m9102c(mContext,"HVideoPlayer:112:buyVideoByTicket()");
//        VideoBean videoBean = this.mVideoBean;
//        if (videoBean != null) {
//            HttpUtil.m9650q(videoBean.getId(), new HttpCallback() { // from class: com.blmvl.blvl.videoplayer.HVideoPlayer.2
//                @Override // p067e.p103c.p104a.p111i.HttpCallback
//                public void onException(int i, String str) {
//                    super.onException(i, str);
//                    try {
//                        if (!TextUtils.isEmpty(str)) {
//                            ToastUtil.m9102c(HVideoPlayer.this.getContext(), str);
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                @Override // p067e.p103c.p104a.p111i.HttpCallback
//                public void onSuccess(String str, String str2, boolean z, boolean z2) {
//                    super.onSuccess(str, str2, z, z2);
//                    try {
//                        EventBus.m309d().m320a(new CurSelectVideoIdEvent(HVideoPlayer.this.mVideoBean.getId()));
//                        ToastUtil.m9102c(HVideoPlayer.this.getContext(), HVideoPlayer.this.getContext().getString(R.string.str_buy_success));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
    }

    private void hideAllHintView() {
        this.mLayoutWatchVideoHint.setVisibility(View.GONE);
        this.mLayoutCoinVideoHint.setVisibility(View.GONE);
        this.mLayoutRunOutHint.setVisibility(View.GONE);
    }

    private void hideThumbView() {
        if (this.mImgThumb.getVisibility() == View.VISIBLE) {
            setViewShowState(this.mImgThumb, 8);
        }
    }

    private void initAction() {
        try {
            this.mImgStatus.setOnClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initSuperView() {
        this.mTitleTextView = (TextView) findViewById(R.id.title);
        this.mBackButton = (ImageView) findViewById(R.id.back);
        this.mCurrentTimeTextView = (TextView) findViewById(R.id.current);
        this.mProgressBar = (SeekBar) findViewById(R.id.progress);
        this.mTotalTimeTextView = (TextView) findViewById(R.id.total);
        this.mLockScreen = (ImageView) findViewById(R.id.lock_screen);
        this.mLoadingProgressBar = findViewById(R.id.loading);
        this.mBottomProgressBar = (ProgressBar) findViewById(R.id.bottom_progressbar);
        if (isIfCurrentIsFullscreen()) {
            this.mTitleTextView.setVisibility(View.VISIBLE);
        } else {
            this.mTitleTextView.setVisibility(View.GONE);
        }
    }

    private void initViews() {
        initSuperView();
        this.mSurfaceContainer = (RelativeLayout) findViewById(R.id.surface_container);
        this.mImgStatus = (ImageView) findViewById(R.id.img_status);
        this.mFullscreenButton = (ImageView) findViewById(R.id.fullscreen);
        this.mImgThumb = (ResizableImageView) findViewById(R.id.img_thumb);
        this.mLayoutWatchVideoHint = (FrameLayout) findViewById(R.id.layout_watch_video_hint);
        this.mLayoutCoinVideoHint = (LinearLayout) findViewById(R.id.layout_coin_video_hint);
        this.mLayoutRunOutHint = (LinearLayout) findViewById(R.id.layout_run_out_hint);
        this.mTvCoinNum = (CustomTextView) findViewById(R.id.tv_coin_num);
        this.mBtnGoInvite = (TextView) findViewById(R.id.btn_go_invite);
        this.mBtnRechargeVip = (TextView) findViewById(R.id.btn_recharge_vip);
        this.mBtnGoInvite.setOnClickListener(this);
        this.mBtnRechargeVip.setOnClickListener(this);
        this.mLayoutCoinVideoHint.setPadding(DpUtil.m9101a(getContext(), 12), DpUtil.m9101a(getContext(), 12), DpUtil.m9101a(getContext(), 12), DpUtil.m9101a(getContext(), 12));
        this.mLayoutRunOutHint.setPadding(DpUtil.m9101a(getContext(), 12), DpUtil.m9101a(getContext(), 12), DpUtil.m9101a(getContext(), 12), DpUtil.m9101a(getContext(), 12));
        this.mBtnPayCoin = (CustomTextView) findViewById(R.id.btn_pay_coin);
        this.mBtnPayCoin.setOnClickListener(this);
        this.mImgSeekBack = (ImageView) findViewById(R.id.img_seek_back);
        this.mImgSeekTo = (ImageView) findViewById(R.id.img_seek_to);
        this.mImgSeekBack.setOnClickListener(this);
        this.mImgSeekTo.setOnClickListener(this);
        if (isIfCurrentIsFullscreen()) {
            this.mImgSeekBack.setVisibility(View.VISIBLE);
            this.mImgSeekTo.setVisibility(View.VISIBLE);
            return;
        }
        this.mImgSeekBack.setVisibility(View.GONE);
        this.mImgSeekTo.setVisibility(View.GONE);
    }

//    https://m3u8.ktpdgao.cn/watch/05aec690bc0eef58939a3cba204c6c4d/05aec690bc0eef58939a3cba204c6c4d.m3u8?auth_key=1649939205-0-0-1d65e9ec9781dded5fc0c635841c2f58
//    https://m3u8.ktpdgao.cn/watch/05aec690bc0eef58939a3cba204c6c4d/05aec690bc0eef58939a3cba204c6c4d.m3u8?auth_key=1649939205-0-0-1d65e9ec9781dded5fc0c635841c2f58
//    https://m3u8.ktpdgao.cn/watch/05aec690bc0eef58939a3cba204c6c4d/05aec690bc0eef58939a3cba204c6c4d.m3u8?auth_key=1649939205-0-0-1d65e9ec9781dded5fc0c635841c2f58
//            546

    private void showBuyDialog() {
        ToastUtil.m9102c(mContext,"HVideoPlayer:210:showBuyDialog()");
        hideAllHintView();
        startPlayVideo(this.mVideoBean);
        ToastUtil.m9102c(mContext,this.mVideoBean.getPlay_url());
        Log.e("播放地址：showBuyDialog:::",this.mVideoBean.getPlay_url());
        Log.e("播放地址：showBuyDialog222:::",url);
//        if (this.mVideoBean != null) {
//            UnlockFullVersionDialog m0Var = new UnlockFullVersionDialog(getContext(), this.mVideoBean);
//            m0Var.m9895a(new UnlockFullVersionDialog.AbstractC4144a() { // from class: com.blmvl.blvl.videoplayer.HVideoPlayer.1
//                @Override // p067e.p103c.p104a.p108f.UnlockFullVersionDialog.AbstractC4144a
//                public void onBuyTicket() {
//                    HVideoPlayer.this.buyVideoByTicket();
//                }
//
//                @Override // p067e.p103c.p104a.p108f.UnlockFullVersionDialog.AbstractC4144a
//                public void onConfirmBuy() {
//                    HVideoPlayer.this.buyVideoByCoin();
//                }
//            });
//            C4326m.m9108a(getContext(), m0Var);
//        }
    }

    private void showCoinVideoHintView() {
        this.mLayoutWatchVideoHint.setVisibility(View.VISIBLE);
        this.mLayoutCoinVideoHint.setVisibility(View.VISIBLE);
        this.mLayoutRunOutHint.setVisibility(View.GONE);
    }

    private void showRunOutView() {
        this.mLayoutWatchVideoHint.setVisibility(View.VISIBLE);
        this.mLayoutCoinVideoHint.setVisibility(View.GONE);
        this.mLayoutRunOutHint.setVisibility(View.VISIBLE);
    }

    private void showThumbView() {
        if (this.mImgThumb.getVisibility() != View.VISIBLE) {
            setViewShowState(this.mImgThumb, 0);
        }
    }

    private void startPlayVideo(VideoBean videoBean) {
        try {
            if (!TextUtils.isEmpty(videoBean.getPlay_url())) {
                setUp(videoBean.getPlay_url(), true, WordUtil.m9084a(videoBean.getTitle()));
                startPlayLogic();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void subWatchLog() {
        try {
            if (this.mVideoBean == null) {
                return;
            }
            if (this.mVideoBean.getUser() == null || AppUser.getInstance().getUser() == null || this.mVideoBean.getUser().getUid() != AppUser.getInstance().getUser().getUid()) {
                HashMap hashMap = new HashMap();
                hashMap.put(String.valueOf(this.mVideoBean.getId()), Integer.valueOf(this.mCurSeconds));
//                SpUtil.m9573D().m9528l(JSON.toJSONString(hashMap));
//                PlayNumUtil.m9398b().m9400a(this.mVideoBean);
            }
        } catch (Exception e) {
            try {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void updateStartImg() {
        try {
            if (!(this.mCurrentState == 2 || this.mCurrentState == 0 || this.mCurrentState == 1 || this.mCurrentState == 3)) {
                this.mImgStatus.setImageResource(R.drawable.icon_video_play);
            }
            this.mImgStatus.setImageResource(R.drawable.icon_video_pause);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m20177a(int i, int i2, int i3, int i4) {
        try {
            this.mCurSeconds = i3 / 1000;
            this.mCurVideoDuration = i4 / 1000;
            this.mProgressBar.setProgress(i);
            this.mProgressBar.setSecondaryProgress(i2);
            if (this.mCurSeconds > 0 && !this.isSubmited) {
                this.isSubmited = true;
                subWatchLog();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
    public void changeUiToClear() {
        super.changeUiToClear();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
    public void changeUiToCompleteClear() {
        super.changeUiToCompleteClear();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void changeUiToCompleteShow() {
        super.changeUiToCompleteShow();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
    public void changeUiToPauseClear() {
        super.changeUiToPauseClear();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void changeUiToPauseShow() {
        super.changeUiToPauseShow();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
    public void changeUiToPlayingBufferingClear() {
        super.changeUiToPlayingBufferingClear();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void changeUiToPlayingBufferingShow() {
        super.changeUiToPlayingBufferingShow();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
    public void changeUiToPlayingClear() {
        super.changeUiToPlayingClear();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void changeUiToPlayingShow() {
        super.changeUiToPlayingShow();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
    public void changeUiToPrepareingClear() {
        super.changeUiToPrepareingClear();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void changeUiToPreparingShow() {
        super.changeUiToPreparingShow();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public int getLayoutId() {
        return R.layout.view_h_video_player;
    }

    public ImageView getLockView() {
        return this.mLockScreen;
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void hideAllWidget() {
        super.hideAllWidget();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView, com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public void init(Context context) {
        super.init(context);
        try {
            initViews();
            initAction();
            setGSYVideoProgressListener(new GSYVideoProgressListener() {
                @Override
                public void onProgress(int progress, int secProgress, int currentPosition, int duration) {
                    HVideoPlayer.this.m20177a(progress, secProgress, currentPosition, duration);
                } // from class: e.c.a.l.a
//                @Override // p067e.p291s.p292a.p295f.GSYVideoProgressListener
//                /* renamed from: a */
//                public final void mo4673a(int i, int i2, int i3, int i4) {
//                    HVideoPlayer.this.m20177a(i, i2, i3, i4);
//                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.img_status) {
            clickStartIcon();
        } else if (view.getId() == R.id.back) {
            if (!isIfCurrentIsFullscreen()) {
                ((Activity) getContext()).finish();
            }
        } else if (view.getId() == R.id.btn_go_invite) {
            if (isIfCurrentIsFullscreen()) {
                onBackFullscreen();
            } else {
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                MyQRCodeActivity.m21004a(getContext());
                ToastUtil.m9102c(mContext,"HVideoPlayer:415:MyQRCodeActivity.m21004a");
            }
        } else if (view.getId() == R.id.btn_recharge_vip) {
            if (isIfCurrentIsFullscreen()) {
                onBackFullscreen();
            } else {
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                BuyMemberActivity.m21257a(getContext());
                ToastUtil.m9102c(mContext,"HVideoPlayer:423:BuyMemberActivity.m21257a()");
            }
        } else if (view.getId() == R.id.btn_pay_coin) {
            try {
                if (isIfCurrentIsFullscreen()) {
                    onBackFullscreen();
                } else {
                    showBuyDialog();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (view.getId() == R.id.img_seek_back) {
            if (this.mCurrentState == 2) {
                getGSYVideoManager().seekTo(Math.max(getGSYVideoManager().getCurrentPosition() - 15000, 0L)); /// TooltipCompatHandler.HOVER_HIDE_TIMEOUT_MS
            }
        } else if (view.getId() == R.id.img_seek_to && this.mCurrentState == 2) {
            getGSYVideoManager().seekTo(Math.min(getGSYVideoManager().getCurrentPosition() + 15000, getGSYVideoManager().getDuration()));  //// TooltipCompatHandler.HOVER_HIDE_TIMEOUT_MS
        }
    }


    @Override
    protected void onClickUiToggle(MotionEvent e) {
        if (isIfCurrentIsFullscreen()) {
            super.onClickUiToggle(e);
        }
    }

//    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
//    public void onClickUiToggle() {
//        if (isIfCurrentIsFullscreen()) {
//            super.onClickUiToggle();
//        }
//    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYTextureRenderView, p067e.p291s.p292a.p298i.p301d.p302b.IGSYSurfaceListener
    public void onSurfaceUpdated(Surface surface) {
        super.onSurfaceUpdated(surface);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public void release() {
        super.release();
        this.isSubmited = false;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void resolveUIState(int i) {
        try {
            super.resolveUIState(i);
            if (i == 0) {
                Log.e("----------CURRENT_STATE_NORMAL-------","");
                changeUiToNormal();
                showThumbView();
                cancelDismissControlViewTimer();
            } else if (i == 1) {
                Log.e("----------CURRENT_STATE_PREPAREING-------","");
                changeUiToPreparingShow();
                showThumbView();
                if (isIfCurrentIsFullscreen()) {
                    startDismissControlViewTimer();
                } else {
                    cancelDismissControlViewTimer();
                }
            } else if (i == 2) {
                Log.e("----------CURRENT_STATE_PLAYING-------","");
                changeUiToPlayingShow();
                hideThumbView();
                if (isIfCurrentIsFullscreen()) {
                    startDismissControlViewTimer();
                } else {
                    cancelDismissControlViewTimer();
                }
            } else if (i == 3) {
                Log.e("----CURRENT_STATE_PLAYING_BUFFERING_START----","");
                changeUiToPlayingBufferingShow();
                hideThumbView();
            } else if (i == 5) {
                Log.e("----------CURRENT_STATE_PAUSE-------","");
                changeUiToPauseShow();
                hideThumbView();
                cancelDismissControlViewTimer();
            } else if (i == 6) {
                Log.e("----------CURRENT_STATE_AUTO_COMPLETE-------","");
                changeUiToCompleteShow();
                showThumbView();
                cancelDismissControlViewTimer();
                if (isIfCurrentIsFullscreen()) {
                    backFromFull(getContext());
                }
            } else if (i == 7) {
                Log.e("----------CURRENT_STATE_ERROR-------","");
                try {
                    showThumbView();
                    changeUiToError();
                    ToastUtil.m9102c(getContext(), getContext().getString(R.string.str_play_fail_hint));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            updateStartImg();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setVideoData(VideoBean videoBean, boolean z) {
        if (z) {
            try {
                this.isSubmited = false;
                setUp("", true, "");
                this.mCurSeconds = 0;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.mVideoBean = videoBean;
        url = videoBean.getPlay_url();
        hideAllHintView();
        ImgLoader.m15404c(getContext(), WordUtil.m15774a(videoBean.getCover_thumb_url()), this.mImgThumb);
        Log.e("播放地址0：：：",videoBean.getPlay_url());
        Log.e("播放地址：：videoBean.getCoins()：", String.valueOf(videoBean.getCoins()));
        Log.e("播放地址：：videoBean.getIs_pay()：", String.valueOf(videoBean.getIs_pay()));
        Log.e("播放地址：：videoBean.getUser().getUid()：", String.valueOf(videoBean.getUser().getUid()));
        Log.e("播放地址：：AppUser.getInstance().getUser().getUid()：", String.valueOf(AppUser.getInstance().getUser().getUid()));
        Log.e("播放地址111122：：：", String.valueOf(PlayNumUtil.m15426b().mo35003b(videoBean)));
        if (videoBean.getCoins() > 0) {
            if (videoBean.getIs_pay() != 1) {
                if (videoBean.getUser().getUid() != AppUser.getInstance().getUser().getUid()) {
                    showCoinVideoHintView();
                    this.mTvCoinNum.setText(String.format("该视频需要花费%s%s", String.valueOf(this.mVideoBean.getCoins()), "鑽石"));
                    return;
                }
            }
            if (z) {
                startPlayVideo(videoBean);
            }
        } else if (!PlayNumUtil.m15426b().mo35003b(videoBean)) {
            showRunOutView();
        } else if (z) {
            startPlayVideo(videoBean);
        }
    }


    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void setViewShowState(View view, int i) {
        super.setViewShowState(view, i);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void startDismissControlViewTimer() {
        if (isIfCurrentIsFullscreen()) {
            super.startDismissControlViewTimer();
        }
    }

    public HVideoPlayer(Context context, Boolean bool) {
        super(context, bool);
    }

    public HVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }



}
