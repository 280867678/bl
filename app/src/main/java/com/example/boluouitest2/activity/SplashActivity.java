package com.example.boluouitest2.activity;

import androidx.annotation.NonNull;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.boluouitest2.AppContext;
import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.ConfigBean;
import com.example.boluouitest2.bean.LiveBaseInfoBean;
import com.example.boluouitest2.bean.OpenScreenAdBean;
import com.example.boluouitest2.bean.UserBean;
import com.example.boluouitest2.comod.baselib.view.CountDownProgressView;
import com.example.boluouitest2.comod.baselib.view.other.OnFinishListener;
import com.example.boluouitest2.dialog.UpgradeDialog;
import com.example.boluouitest2.httpUtil.CommonCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.httpUtil.NetworkUtil;
import com.example.boluouitest2.service.DownloadAdImgService;
import com.example.boluouitest2.slzhibo.library.CustomDialog.CustomDialogUtil;
import com.example.boluouitest2.slzhibo.library.SLLiveSDK;
import com.example.boluouitest2.slzhibo.library.model.UserEntity;
import com.example.boluouitest2.util.DialogUtil;
import com.example.boluouitest2.util.PlayNumUtil;
import com.example.boluouitest2.util.SpUtil;
import com.example.boluouitest2.util.SystemUtil;
import com.example.boluouitest2.util.ToastUtil;
import com.example.boluouitest2.util.VersionUtil;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class SplashActivity extends AbsActivity implements EasyPermissions.PermissionCallbacks {
    /* 定义TAG标签，这样可以很好的区分打印出来的log */
    private static final String TAG = "SplashActivity";


    /* renamed from: g */
    public Handler f804g;
    /* renamed from: f */
    public List<String> f803f;
    /* renamed from: h */
    public Dialog f805h;


    /* renamed from: b */
    public ImageView f799b;
    /* renamed from: c */
    public CountDownProgressView f800c;
    /* renamed from: d */
    public TextView f801d;
    /* renamed from: e */
    public RelativeLayout f802e;

    /* renamed from: j */
    public CountDownTimerC0679f f807j;


    /* renamed from: d0 */
    public final void m20830d0() {
        this.f799b = (ImageView) findViewById(R.id.img_splash);
        this.f800c = (CountDownProgressView) findViewById(R.id.progressView);
        this.f801d = (TextView) findViewById(R.id.tv_count_down);
        this.f802e = (RelativeLayout) findViewById(R.id.rl_enter);
        this.f802e.setEnabled(false);
        this.f801d.setEnabled(false);
        this.f801d.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.c.l1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashActivity.this.m20849a(view);
//                ToastUtil.m9102c(getApplicationContext(), "TextView R.id.tv_count_down");
            }
        });
        this.f802e.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.c.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashActivity.this.m20838b(view);
//                ToastUtil.m9102c(getApplicationContext(), "RelativeLayout R.id.rl_enter");
            }
        });
        this.f802e.setVisibility(View.GONE);
    }

    /* renamed from: a */
    public /* synthetic */ void m20849a(View view) {
        try {
            MainActivity.m21036a(this);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /* renamed from: b */
    public /* synthetic */ void m20838b(View view) {
        try {
            MainActivity.m21036a(this);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void mo20592a(Bundle bundle) {
//        ToastUtil.m9102c(this, "獲取數據失敗，請稍候重試～");
//        ToastUtil.m9102c(TAG, "獲取數據失敗，請稍候重試～");
//        Toast.makeText(TAG,"",Toast.LENGTH_LONG).show();

        m20830d0();  //初始化控件
        this.f804g = new HandlerC0680g(this, null);
        this.f803f = new ArrayList();
//        this.f805h = DialogUtil.m9458a(this);
        m20832c0();   //更改封面
        m20821h0();  //获取数据请求
//        LogUtil.m9410a("BL_SPLASH_PAGE");       //统计
    }

    @Override // com.blmvl.blvl.activity.AbsActivity
    /* renamed from: B */
    public void mo20620B() {
//        ImmersionBar b = ImmersionBar.m5078b(this);
//        b.m5105D();                           reset
//        b.m5085a(BarHide.FLAG_HIDE_BAR);      hideBar
//        b.m5099J();                           getBarConfig
//        b.m5076b(true);                       fullScreen
//        b.m5045w();                           init


        ImmersionBar mBarParams = ImmersionBar.with(this);
        mBarParams.reset();
        mBarParams.hideBar(BarHide.FLAG_HIDE_BAR);
        mBarParams.transparentBar();      ////////
        mBarParams.fullScreen(true);      ///////
        mBarParams.init();

//        ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_BAR).init();
    }

    public final void m20821h0() {
        if (NetworkUtil.m9070a(this)) {
            DialogUtil.m9457a(this, this.f805h);
            new Thread(new Runnable() { // from class: e.c.a.c.j1
                @Override // java.lang.Runnable
                public final void run() {
                    SplashActivity.this.m20826f0();
                }
            }).start();
            return;
        }
        DialogUtil.m9459a(this.f805h);
        ToastUtil.m9102c(this, "網絡異常，請檢查後重試～");
    }

    /* renamed from: f0 */
    public /* synthetic */ void m20826f0() {
        try {
            m20818i0();
        } catch (Exception unused) {
            m20818i0();
        }
    }

    /* renamed from: i0 */
    public final void m20818i0() {
        Handler handler = this.f804g;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 0;
            this.f804g.sendMessage(obtainMessage);
        }
    }


    @Override
    public int mo20588z() {
        return R.layout.activity_splash;
    }


    public final void m20839a0() {
        OkGo.<String>get("https://raw.githubusercontent.com/little-5/backup/master/polo.txt").execute(new C0673a());
    }


    /* renamed from: com.blmvl.blvl.activity.SplashActivity$a */
    /* loaded from: classes.dex */
    public class C0673a extends StringCallback {
        public C0673a() {
        }

        @Override // com.lzy.okgo.callback.Callback
        public void onSuccess(Response<String> response) {
            Log.e("119:OkGoresponse：", response.body());

            if (response != null) {
                String body = response.body();
                if (!TextUtils.isEmpty(body)) {
                    String[] split = body.split(",");
                    if (split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            split[i] = split[i].replaceAll("\n", "");
                        }
                        SplashActivity.this.m20840a(split, 0, 2);
                    }
                }
            }
        }
    }


    /* renamed from: com.blmvl.blvl.activity.SplashActivity$g */
    /* loaded from: classes.dex */
    public class HandlerC0680g extends Handler {
        public HandlerC0680g() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            Log.e("HandlerC0680g：", String.valueOf(i));
            if (i == 0) {

                SplashActivity.this.m20835b0();
            } else if (i == 1) {
                try {
                    int i2 = message.arg1 + 1;
                    String[] strArr = (String[]) message.obj;
                    if (i2 < strArr.length) {
                        SplashActivity.this.m20840a(strArr, i2, i);
                    } else {
                        SplashActivity.this.m20839a0();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    SplashActivity.this.m20839a0();
                }
            } else if (i == 2) {
                try {
                    int i3 = message.arg1 + 1;
                    String[] strArr2 = (String[]) message.obj;
                    if (i3 < strArr2.length) {
                        SplashActivity.this.m20840a(strArr2, i3, i);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (i == 3) {
                SplashActivity.this.m20852R();
            }
        }

        public /* synthetic */ HandlerC0680g(SplashActivity splashActivity, C0673a aVar) {
            this();
        }
    }

    /* renamed from: R */
    public final void m20852R() {
        Log.e("187:message==3:", "");
        HttpUtil.m9766a(new C0674b());
    }


    /* renamed from: b0 */
    public final void m20835b0() {
        String q = SpUtil.m9573D().m9523q();
        Log.e("线路检测url后226:", q);
        if (!TextUtils.isEmpty(q)) {
            String[] split = q.split(",");
            if (split.length > 0) {
                m20840a(split, 0, 1);
                Log.e("split.length > 0  269:", q);
            } else {
                m20839a0();
                Log.e("split.length else  272:", q);
            }
        } else {
            Log.e("m20839a0()  275:", q);
            m20839a0();
        }
    }


    /* renamed from: a */
    public final void m20840a(final String[] strArr, final int i, final int i2) {
        new Thread(new Runnable() { // from class: e.c.a.c.m1
            @Override // java.lang.Runnable
            public final void run() {
                SplashActivity.this.m20836b(strArr, i, i2);
            }
        }).start();
    }


    /* renamed from: b */
    public /* synthetic */ void m20836b(String[] strArr, int i, int i2) {
        if (strArr != null && strArr.length != 0) {
            String str = strArr[i];
            try {
                if (!TextUtils.isEmpty(str)) {
                    m20819i(str);  //线路检测url
                    Log.e("259:", str);
                } else {
                    m20833c(strArr, i, i2);
                    Log.e("262:", str);
                }
            } catch (Exception e) {
                Log.e("265catch:", str);
                e.printStackTrace();
                m20833c(strArr, i, i2);
                if (!TextUtils.isEmpty(str)) {
                    m20822h(str);
                }
            }
        }
    }

    /* renamed from: h */
    public final void m20822h(String str) {
        try {
            if (this.f803f != null) {
                this.f803f.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /* renamed from: i */

    /**
     * 线路检测url后
     *
     * @param str
     * @throws IOException
     */
    public final void m20819i(String str) throws IOException {
        Log.e("线路检测url后294----->" + str, "");
        OkGo.get(str).execute();
        SpUtil.m9573D().m9560b(str);
        runOnUiThread(new Runnable() { // from class: e.c.a.c.a
            @Override // java.lang.Runnable
            public final void run() {
                SplashActivity.this.m20855G();
            }
        });
    }


    /* renamed from: c */
    public final void m20833c(String[] strArr, int i, int i2) {
        Log.e("308：", String.valueOf(i));
        Log.e("309：", String.valueOf(i2));
        Handler handler = this.f804g;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = i2;
            obtainMessage.arg1 = i;
            obtainMessage.obj = strArr;
            this.f804g.sendMessage(obtainMessage);
        }
    }

    /* renamed from: G */
    public final void m20855G() {
        m20850V();
    }


    /* renamed from: V */
    public final void m20850V() {
        try {
            String[] strArr = {"android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};

            Log.e("331：", "strArr");
            //获取相关权限
            if (EasyPermissions.hasPermissions(this, strArr)) {
                Log.e("336：", "已经申请过权限，做想做的事");
//                Toast.makeText(getApplicationContext(), "已经申请过权限，做想做的事", Toast.LENGTH_LONG).show();
                m20851U();
            } else {
//                Log.e("302：", "没有申请过权限，现在去申请");
                // 没有申请过权限，现在去申请
                /**
                 *@param host Context对象
                 *@param rationale  权限弹窗上的提示语。
                 *@param requestCode 请求权限的唯一标识码
                 *@param perms 一系列权限
                 */
//                Log.e("347：", "需要授予相關權限");
                EasyPermissions.requestPermissions(this, "需要授予相關權限", 2000, strArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * easypermissions -- 谷歌权限管理框架
     *
     * @param i
     * @param strArr
     * @param iArr
     */
    @Override
    // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.support.p001v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        try {
            // 将结果转发给 EasyPermissions
            EasyPermissions.onRequestPermissionsResult(i, strArr, iArr, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 授予权限
     *
     * @param i
     * @param list
     */
    @Override
    public void onPermissionsGranted(int i, @NonNull List<String> list) {
        // 授予权限
        // ...
        if (i == 2000) {
            try {
                if (list.size() == 3) {
                    Toast.makeText(this, "您已授予相關權限!!!", Toast.LENGTH_LONG).show();
                    m20851U();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 请求权限被拒
     *
     * @param i
     * @param list
     */
    @Override
    public void onPermissionsDenied(int i, @NonNull List<String> list) {
        // 请求权限被拒
        // ...
        if (i == 2000) {
            try {
//                ToastUtil.m9102c(this, "已拒絕授予相關權限，無法正常使用");
                Toast.makeText(this, "已拒絕授予相關權限，無法正常使用", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        /////////////////////////////////////////////
        Log.d(TAG, "onPermissionsDenied:" + i + ":" + list.size());

        // 可选）检查用户是否拒绝了任何权限并选中了“永不再次询问”。
        //这将显示一个对话框，指导他们启用应用程序设置中的权限。
        if (EasyPermissions.somePermissionPermanentlyDenied(this, list)) {
            new AppSettingsDialog.Builder(this).build().show();
        }

    }



    /* renamed from: U */

    /**
     * 获取数据
     */
    public final void m20851U() {
        new Thread(new Runnable() { // from class: e.c.a.c.k1
            @Override // java.lang.Runnable
            public final void run() {
                SplashActivity.this.m20828e0();
            }
        }).start();
    }


    /* renamed from: e0 */
    public void m20828e0() {
        try {
            String e = SystemUtil.m9118e(this);
            String i = SpUtil.m9573D().m9535i();


            Log.e("420e：", e);
            Log.e("421i：", i);
            if (!TextUtils.isEmpty(i)) {
                if (TextUtils.isEmpty(e)) {
                    SystemUtil.m9124a(i, this);
                    Log.e("425e：", e);
                    Log.e("426i：", i);
                    e = i;

                }
            } else if (TextUtils.isEmpty(e)) {
                e = SystemUtil.m9125a(this);
                Log.e("432e：", e);
            }
            SpUtil.m9573D().m9544e(e);
            Log.e("435e：", e);
            this.f804g.sendEmptyMessage(3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }




























    /* renamed from: i */
    /**
     * 升级对话框
     */
    public UpgradeDialog f806i;

    /* renamed from: k */
    public UpgradeDialog.AbstractC4147b f808k = new C0675c();

    /* renamed from: com.blmvl.blvl.activity.SplashActivity$c */
    /* loaded from: classes.dex */
    public class C0675c implements UpgradeDialog.AbstractC4147b {
        public C0675c() {
        }

        @Override // p067e.p103c.p104a.p108f.UpgradeDialog.AbstractC4147b
        /* renamed from: a */
        public void mo9881a(String str) {
        }

        @Override // p067e.p103c.p104a.p108f.UpgradeDialog.AbstractC4147b
        public void onCancel() {
            DialogUtil.m9459a(SplashActivity.this.f806i);
            SplashActivity.this.m20853Q();
        }
    }


    /* renamed from: com.blmvl.blvl.activity.SplashActivity$b */
    /* loaded from: classes.dex */
    public class C0674b extends CommonCallback<ConfigBean> {
        public C0674b() {
        }

        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo9799a(ConfigBean configBean) {
            Log.e("直播：","public class C0674b extends CommonCallback<ConfigBean>");
            try {
                if (configBean != null) {
                    SplashActivity.this.m20843a(configBean);
                    if (configBean.getVersion() == null || VersionUtil.m9097c(AppContext.m21299a(), configBean.getVersion().getVersion())) {
                        SplashActivity.this.m20853Q();
                        return;
                    }
                    if (SplashActivity.this.f806i == null) {
                        SplashActivity.this.f806i = new UpgradeDialog(SplashActivity.this, configBean.getVersion());
                    }
                    SplashActivity.this.f806i.m9892a(SplashActivity.this.f808k);
                    DialogUtil.m9457a(SplashActivity.this, SplashActivity.this.f806i);
                    return;
                }
                SplashActivity.this.m20854N();
            } catch (Exception e) {
                e.printStackTrace();
                SplashActivity.this.m20854N();
            }
        }
    }

    /* renamed from: a */
    public final void m20843a(ConfigBean configBean) {
        try {
            String openScreenAdImg = configBean.getOpenScreenAdImg();
            if (!TextUtils.isEmpty(openScreenAdImg)) {
                String openScreenAdUrl = configBean.getOpenScreenAdUrl();
                int openScreenAdType = configBean.getOpenScreenAdType();
                OpenScreenAdBean openScreenAdBean = new OpenScreenAdBean();
                openScreenAdBean.setImg_url(openScreenAdImg);
                openScreenAdBean.setJump_url(openScreenAdUrl);
                openScreenAdBean.setType(String.valueOf(openScreenAdType));
                Intent intent = new Intent(this, DownloadAdImgService.class);
                intent.putExtra("open_screen_ad", openScreenAdBean);
                startService(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /* renamed from: Q */

    /**
     * 直播信息
     */
    public final void m20853Q() {
        HttpUtil.m9737b(new C0676d());
    }

    /* renamed from: com.blmvl.blvl.activity.SplashActivity$d */
    /* loaded from: classes.dex */
    public class C0676d extends CommonCallback<UserBean> {
        public C0676d() {
        }

        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo9799a(UserBean userBean) {
            LiveBaseInfoBean liveBaseInfoBean;
            Log.e("直播：","reason: avoid collision after fix types in other method");
            try {
                if (userBean != null) {
                    String r = SpUtil.m9573D().m9522r();
                    if (!TextUtils.isEmpty(r)) {
                        JSONObject parseObject = JSON.parseObject(r);
                        if (parseObject.containsKey("zbInfo")) {
                            String string = parseObject.getString("zbInfo");
                            if (!TextUtils.isEmpty(string) && (liveBaseInfoBean = (LiveBaseInfoBean) JSON.parseObject(string, LiveBaseInfoBean.class)) != null) {
                                SplashActivity.this.m20842a(liveBaseInfoBean);
                            }
                        }
                    }
                    SplashActivity.this.m20816k0();
                    SplashActivity.this.m20817j0();
                } else {
                    SplashActivity.this.m20854N();
                }
                PlayNumUtil.m9398b().m9399a((PlayNumUtil.AbstractC4249b) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: N */
    public final void m20854N() {
        ToastUtil.m9102c(this, "獲取數據失敗，請稍候重試～");
        DialogUtil.m9459a(this.f805h);
    }

















    /* renamed from: c0 */

    /**
     * 更改画报
     */
    public final void m20832c0() {
        final OpenScreenAdBean openScreenAdBean;
        try {
            String n = SpUtil.m9573D().m9526n();

            if (!TextUtils.isEmpty(n) && (openScreenAdBean = (OpenScreenAdBean) JSON.parseObject(n, OpenScreenAdBean.class)) != null) {
                String local_path = openScreenAdBean.getLocal_path();
                ToastUtil.m9102c(this, "更改画报： " + n);

                if (!TextUtils.isEmpty(local_path)) {
                    File file = new File(local_path);
                    if (file.exists()) {


                        Glide.with(AppContext.m21299a()).load(file).placeholder((int) R.mipmap.launch_screen).diskCacheStrategy(DiskCacheStrategy.ALL).into(this.f799b);
                        ///////////////////////////////////////////////////////////////////////////

                    }
                }
                this.f799b.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.c.g1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SplashActivity.this.m20841a(openScreenAdBean, view);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /* renamed from: a */
    public /* synthetic */ void m20841a(OpenScreenAdBean openScreenAdBean, View view) {
        try {
            String jump_url = openScreenAdBean.getJump_url();
            Log.e("WebViewUtil：", jump_url);
            Toast.makeText(getApplicationContext(), "WebViewUtil", Toast.LENGTH_LONG).show();
            if (!TextUtils.isEmpty(jump_url)) {
//                WebViewUtil.m9087a(this, jump_url);
            }
            Log.e("BL_OPEN_SCREEN_AD_CLICK", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /* renamed from: k0 */
    public final void m20816k0() {
        DialogUtil.m9459a(this.f805h);
    }

    /* renamed from: j0 */
    public final void m20817j0() {
        Toast.makeText(getApplicationContext(),"進入1111",Toast.LENGTH_LONG).show();
        try {
            this.f802e.setVisibility(View.VISIBLE);
            this.f807j = new CountDownTimerC0679f(3000, 1000);
            this.f807j.start();
            this.f800c.m20147a(3000, new OnFinishListener() { // from class: e.c.a.c.i1
                @Override // p067e.p130f.p131a.p134c.OnFinishListener
                public final void onFinish() {
                    SplashActivity.this.m20824g0();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /* renamed from: com.blmvl.blvl.activity.SplashActivity$f */
    /* loaded from: classes.dex */
    public class CountDownTimerC0679f extends CountDownTimer {
        public CountDownTimerC0679f(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Toast.makeText(getApplicationContext(),"進入",Toast.LENGTH_LONG).show();
            SplashActivity.this.f801d.setText("進入");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Toast.makeText(getApplicationContext(),"等待",Toast.LENGTH_LONG).show();
            SplashActivity.this.f801d.setText(String.format("%sS", String.valueOf(((int) ((j - 1) / 1000)) + 1)));
        }
    }

    /* renamed from: g0 */
    public /* synthetic */ void m20824g0() {
        this.f802e.setEnabled(true);
        this.f801d.setEnabled(true);
    }






































































    /* renamed from: a */

    /**
     * 注册直播
     * @param liveBaseInfoBean
     */
    public final void m20842a(LiveBaseInfoBean liveBaseInfoBean) {
        SLLiveSDK.getSingleton().initSDK(AppContext.m21299a(), liveBaseInfoBean.getApp_id(), liveBaseInfoBean.getApp_key(), liveBaseInfoBean.getApp_name(), liveBaseInfoBean.getBase_api_url(), liveBaseInfoBean.getUpload_url(), liveBaseInfoBean.getDownload_url(), liveBaseInfoBean.getBranch_channel_id(), "", true, false, true, liveBaseInfoBean.getGame_channel(), "", liveBaseInfoBean.getReport_url(), new C0677e(this));
    }



    /* renamed from: com.blmvl.blvl.activity.SplashActivity$e */
    /* loaded from: classes.dex */
    public class C0677e implements SLLiveSDK.SLLiveSDKCallbackListener {

        /* renamed from: com.blmvl.blvl.activity.SplashActivity$e$a */
        /* loaded from: classes.dex */
        public class C0678a extends CommonCallback<UserBean> {
            public C0678a(C0677e eVar) {
            }

            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo9799a(UserBean userBean) {
            }
        }

        public C0677e(SplashActivity splashActivity) {
        }

        @SuppressLint("LongLogTag")
        @Override // com.slzhibo.library.SLLiveSDK.SLLiveSDKCallbackListener
        public void onAdClickListener(Context context, String str) {
            Log.e("----------onAdClickListener--------","");
        }

        @Override // com.slzhibo.library.SLLiveSDK.SLLiveSDKCallbackListener
        public void onAdvChannelHitsListener(Context context, String str, String str2) {
        }

        @Override // com.slzhibo.library.SLLiveSDK.SLLiveSDKCallbackListener
        public void onAdvChannelListener(Context context, String str, SLLiveSDK.OnAdvChannelCallbackListener onAdvChannelCallbackListener) {
        }

        @Override // com.slzhibo.library.SLLiveSDK.SLLiveSDKCallbackListener
        public void onAdvChannelLiveNoticeListener(Context context, SLLiveSDK.OnAdvChannelCallbackListener onAdvChannelCallbackListener) {
        }

        @Override // com.slzhibo.library.SLLiveSDK.SLLiveSDKCallbackListener
        public void onAppCommonCallbackListener(Context context, int i, SLLiveSDK.OnCommonCallbackListener onCommonCallbackListener) {
        }

        @Override // com.slzhibo.library.SLLiveSDK.SLLiveSDKCallbackListener
        public boolean onEnterLivePermissionListener(Context context, int i) {
            if (i != 1) {
                return false;
            }
            CustomDialogUtil.m9483a(context);
            return false;
        }

        @SuppressLint("LongLogTag")
        @Override // com.slzhibo.library.SLLiveSDK.SLLiveSDKCallbackListener
        public void onGiftRechargeListener(Context context) {
            Log.e("----------onGiftRechargeListener--------","");
//            CoinRechargeActivity.m21240a(context);
        }

        @SuppressLint("LongLogTag")
        @Override // com.slzhibo.library.SLLiveSDK.SLLiveSDKCallbackListener
        public void onIncomeWithdrawalListener(Context context) {
            Log.e("----------onIncomeWithdrawalListener--------","");
        }

        @Override // com.slzhibo.library.SLLiveSDK.SLLiveSDKCallbackListener
        public void onLiveGameJSListener(Context context, String str) {
        }

        @SuppressLint("LongLogTag")
        @Override // com.slzhibo.library.SLLiveSDK.SLLiveSDKCallbackListener
        public void onLoginListener(Context context) {
            Log.e("----------onLoginListener--------","");
            HttpUtil.m9737b(new C0678a(this));
        }

        @Override // com.slzhibo.library.SLLiveSDK.SLLiveSDKCallbackListener
        public void onScoreListener(Context context) {
        }

        @Override // com.slzhibo.library.SLLiveSDK.SLLiveSDKCallbackListener
        public void onUserHomepageListener(Context context, UserEntity userEntity) {
            if (userEntity != null) {
                try {
//                    HomePageActivity.m21102a(context, Integer.parseInt(userEntity.getUserId()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @SuppressLint("LongLogTag")
        @Override // com.slzhibo.library.SLLiveSDK.SLLiveSDKCallbackListener
        public void onUserOfflineListener(Context context) {
            Log.e("----------onUserOfflineListener--------","");
        }
    }



}