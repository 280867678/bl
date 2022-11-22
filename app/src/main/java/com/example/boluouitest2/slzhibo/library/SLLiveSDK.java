package com.example.boluouitest2.slzhibo.library;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.boluouitest2.slzhibo.library.DownLoadManager.GiftDownLoadManager;
import com.example.boluouitest2.slzhibo.library.model.LiveStatusEntity;
import com.example.boluouitest2.slzhibo.library.model.UserEntity;
import com.example.boluouitest2.slzhibo.library.utils.BasePopupSDK;
import com.example.boluouitest2.slzhibo.library.utils.C4783c;
import com.example.boluouitest2.slzhibo.library.utils.ConstantUtils.CommonTransferUtils;
import com.example.boluouitest2.slzhibo.library.utils.SPUtils;
import com.example.boluouitest2.slzhibo.library.utils.Utils;
import com.lzy.okgo.db.DBUtils;

import java.util.ArrayList;
import java.util.Iterator;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SLLiveSDK {
    public String ADV_CHANNEL_ID;
    public String ADV_CHANNEL_TYPE;
    public String API_URL;
    public String APP_ID;
    public String APP_KEY;
    public String APP_NAME;
    public String CUSTOMIZE_GAME;
    public String DATA_REPORT_CONFIG_URL;
    public String DATA_REPORT_URL;
    public String GAME_CHANNEL;
    public String IMG_DOWN_URL;
    public String IMG_UP_URL;
    public String YOUDAO_KEY;
    public Application application;
    public boolean isEnableNewYearSkin;
    public SLLiveSDKCallbackListener sdkCallbackListener;

    public SLLiveSDK() {
        this.YOUDAO_KEY = "1fdd2bb053fdb5bf";
        this.sdkCallbackListener = null;
        this.API_URL = "";
        this.IMG_UP_URL = "";
        this.IMG_DOWN_URL = "";
        this.APP_KEY = "";
        this.APP_ID = "";
        this.APP_NAME = "";
        this.ADV_CHANNEL_TYPE = "";
        this.ADV_CHANNEL_ID = "";
        this.GAME_CHANNEL = "";
        this.CUSTOMIZE_GAME = "";
        this.DATA_REPORT_URL = "";
        this.DATA_REPORT_CONFIG_URL = "";
        this.isEnableNewYearSkin = false;
        RxJavaPlugins.setErrorHandler(C4783c.f17515b);
    }

    /* loaded from: classes2.dex */
    public interface LiveSDKLoginCallbackListener {
        void onLoginFailListener(Context context);

        void onLoginSuccessListener(Context context);
    }

    /* loaded from: classes2.dex */
    public interface LiveSDKLogoutCallbackListener {
        void onLogoutFailListener(Context context);

        void onLogoutSuccessListener(Context context);
    }

    /* loaded from: classes2.dex */
    public interface OnAdvChannelCallbackListener {
        void onAdvDataFail(int i, String str);

        void onAdvDataSuccess(Context context, String str);
    }

    /* loaded from: classes2.dex */
    public interface OnCommonCallbackListener {
        void onDataFail(Throwable th, int i);

        void onDataSuccess(Context context, Object obj);
    }

    /* loaded from: classes2.dex */
    public interface OnLiveStatusCallbackListener {
        void onLiveStatusFail(int i, String str);

        void onLiveStatusSuccess(Context context, LiveStatusEntity liveStatusEntity);
    }

    /* loaded from: classes2.dex */
    public interface SLLiveSDKCallbackListener {
        void onAdClickListener(Context context, String str);

        void onAdvChannelHitsListener(Context context, String str, String str2);

        void onAdvChannelListener(Context context, String str, OnAdvChannelCallbackListener onAdvChannelCallbackListener);

        void onAdvChannelLiveNoticeListener(Context context, OnAdvChannelCallbackListener onAdvChannelCallbackListener);

        void onAppCommonCallbackListener(Context context, int i, OnCommonCallbackListener onCommonCallbackListener);

        boolean onEnterLivePermissionListener(Context context, int i);

        void onGiftRechargeListener(Context context);

        void onIncomeWithdrawalListener(Context context);

        void onLiveGameJSListener(Context context, String str);

        void onLoginListener(Context context);

        void onScoreListener(Context context);

        void onUserHomepageListener(Context context, UserEntity userEntity);

        void onUserOfflineListener(Context context);
    }

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        public static final SLLiveSDK INSTANCE = new SLLiveSDK();
    }


    public static SLLiveSDK getSingleton() {
        return SingletonHolder.INSTANCE;
    }

    /* renamed from: a */
    public static /* synthetic */ void m18469a(Throwable th) throws Exception {
    }



    public void initSDK(Application application, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, boolean z3, String str9, String str10, String str11, SLLiveSDKCallbackListener sLLiveSDKCallbackListener) {
        this.application = application;
        this.sdkCallbackListener = sLLiveSDKCallbackListener;
        this.APP_ID = str;
        this.APP_KEY = str2;
        this.APP_NAME = str3;
        this.API_URL = str4;
        this.IMG_UP_URL = str5;
        this.IMG_DOWN_URL = str6;
        this.ADV_CHANNEL_ID = str7;
        this.ADV_CHANNEL_TYPE = str8;
        this.GAME_CHANNEL = str9;
        this.CUSTOMIZE_GAME = str10;
        updateDataReportUrl(str11);
        CommonTransferUtils.m1583a().m1581a(z);
        BasePopupSDK.m1815d().m1820a(application);            ///广告
        Utils.m21324a(application);
//        C6112i.m798a(application, this.YOUDAO_KEY);
//        LitePal.initialize(application);
//        initHttpCacheDir(application);
//        UserInfoManager.getInstance().setAppId(str);
//        SysConfigInfoManager.getInstance().setEnableVisitorPermission(z2);
//        SysConfigInfoManager.getInstance().setEnableExchangeProportion(z3);
//        SPUtils.m10252a().m10238b("SHOW_MOBIE_TIP", false);
//        CacheUtils.cleanCacheDisk("GENERAL_TURNTABLE_KEY", "LUXURY_TURNTABLE_KEY");
//        initSDKSendRequestData();
//        initQbSdkWebView();
    }


    public void updateDataReportUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.DATA_REPORT_URL = str;
            this.DATA_REPORT_CONFIG_URL = str;
        }
    }







    public void loadOperationActivityDialog(Context context) {
//        if (context != null && (context instanceof FragmentActivity)) {
//            final FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
//            ArrayList<ActivityListEntity> operateActivityListByType = CacheUtils.getOperateActivityListByType(false);
//            if (operateActivityListByType != null) {
//                Observable.m503a(operateActivityListByType).m489b(Schedulers.m549b()).m507a(AndroidSchedulers.m453a()).m494b(new Consumer<ArrayList<ActivityListEntity>>() { // from class: com.slzhibo.library.SLLiveSDK.36
//                    public void accept(ArrayList<ActivityListEntity> arrayList) throws Exception {
//                        if (arrayList != null && !arrayList.isEmpty()) {
//                            Iterator<ActivityListEntity> it = arrayList.iterator();
//                            while (it.hasNext()) {
//                                ActivityListEntity next = it.next();
//                                if (next.isCorrectLink()) {
//                                    ActivityDBEntity f = DBUtils.m1526f(next.f4621id);
//                                    DBUtils.m1575a(next);
//                                    if (f == null) {
//                                        GiftBagWebViewDialog.m15748a(next).show(supportFragmentManager);
//                                    } else if (f.isShowActivityDialog()) {
//                                        GiftBagWebViewDialog.m15748a(next).show(supportFragmentManager);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                });
//            }
//        }
    }

    public void initAnim() {
//        GiftDownLoadManager.m4388g().m4389f();
//        NobilityDownLoadManager.m4362b().m4373a();
    }



}
