package com.example.boluouitest2;

import android.app.Activity;
import android.net.Uri;

import androidx.annotation.Nullable;

import com.example.boluouitest2.comod.baselib.BaseAppContext;
import com.example.boluouitest2.dataSource.CustomHttpDataSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.hls.DefaultHlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.shuyu.gsyvideoplayer.cache.CacheFactory;
import com.shuyu.gsyvideoplayer.player.PlayerFactory;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;

import java.io.File;
import java.util.Map;
import java.util.Stack;

import tv.danmaku.ijk.media.exo2.Exo2PlayerManager;
import tv.danmaku.ijk.media.exo2.ExoMediaSourceInterceptListener;
import tv.danmaku.ijk.media.exo2.ExoPlayerCacheManager;
import tv.danmaku.ijk.media.exo2.ExoSourceManager;

public class AppContext extends BaseAppContext {

    public static AppContext f336e;

    /* renamed from: f */
    public static Stack<Activity> f337f = new Stack<>();

    @Override // com.comod.baselib.BaseAppContext, android.app.Application
    public void onCreate() {
        super.onCreate();
        f336e = this;
//        new FlurryAgent.Builder().withLogEnabled(true).build(this, "N4C76RRY8FSFNZ83F3MP");
        PlayerFactory.setPlayManager(Exo2PlayerManager.class);
        CacheFactory.setCacheManager(ExoPlayerCacheManager.class);
        GSYVideoType.setShowType(0);
        ExoSourceManager.setExoMediaSourceInterceptListener(new C0589a(this));
//        m21296d();
//        startService(new Intent(this, UploadService.class));
    }


    /* renamed from: com.blmvl.blvl.AppContext$a */
    /* loaded from: classes.dex */
    public class C0589a implements ExoMediaSourceInterceptListener {
        public C0589a(AppContext appContext) {
        }

//        /* renamed from: a */
//        public static DataSource m21295a(int i) {
//            return new CustomHttpDataSource("dd", null);
//        }

        @Override // tv.danmaku.ijk.media.exo2.ExoMediaSourceInterceptListener
        public MediaSource getMediaSource(String str, boolean z, boolean z2, boolean z3, File file) {
            if (!str.contains(".m3u8")) {
                return null;
            }
            DataSource.Factory m=new CustomHttpDataSource.Factory();
            return new HlsMediaSource.Factory(m).createMediaSource(Uri.parse(str));
        }

        @Override
        public DataSource.Factory getHttpDataSourceFactory(String s, @Nullable TransferListener transferListener, int i, int i1, Map<String, String> map, boolean b) {
            return null;
        }
    }





    /* renamed from: a */
    public static AppContext m21299a() {
        return f336e;
    }



    @Override // com.comod.baselib.BaseAppContext
    /* renamed from: a */
    public void mo20166a(Activity activity) {
        try {
            if (f337f == null) {
                f337f = new Stack<>();
            }
            f337f.add(activity);
        } catch (Throwable th) {
//            L.m9079a(th.toString());
        }
    }



    @Override // com.comod.baselib.BaseAppContext
    /* renamed from: b */
    public void mo20165b(Activity activity) {
        if (activity != null) {
            try {
                if (f337f != null) {
                    f337f.remove(activity);
                }
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            } catch (Throwable th) {
//                L.m9079a(th.toString());
            }
        }
    }



}
