package com.example.boluouitest2.httpUtil;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.example.boluouitest2.AppContext;
import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.AppUser;
import com.example.boluouitest2.bean.JsonBean;
import com.example.boluouitest2.bean.ResponseJsonBean;
import com.example.boluouitest2.bean.UserBean;
import com.example.boluouitest2.util.Cfb_256crypt;
import com.example.boluouitest2.util.SpUtil;
import com.example.boluouitest2.util.ToastUtil;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

public class HttpCallback extends AbsCallback<ResponseJsonBean> {
    public static final int STATUS_FAIL_CODE = 0;
    public static final int STATUS_SUCCESS_CODE = 1;



    /* compiled from: HttpCallback.java */
    /* renamed from: e.c.a.i.a$a */
    /* loaded from: classes.dex */
    public class C4219a extends CommonCallback<UserBean> {

        /* renamed from: a */
        public final /* synthetic */ int f12967a;

        /* renamed from: b */
        public final /* synthetic */ JsonBean f12968b;

        /* renamed from: c */
        public final /* synthetic */ String f12969c;

        /* renamed from: d */
        public final /* synthetic */ boolean f12970d;

        /* renamed from: e */
        public final /* synthetic */ boolean f12971e;

        public C4219a(int i, JsonBean jsonBean, String str, boolean z, boolean z2) {
            this.f12967a = i;
            this.f12968b = jsonBean;
            this.f12969c = str;
            this.f12970d = z;
            this.f12971e = z2;
        }

        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo9799a(UserBean userBean) {
            if (userBean == null) {
                HttpCallback.this.onException(0, "");
            } else if (this.f12967a == 1) {
                HttpCallback.this.onSuccess(this.f12968b.getData(), this.f12969c, this.f12970d, this.f12971e);
            } else {
                Log.e(">>>>>--onException-->>>>>","");
                HttpCallback.this.onException(this.f12967a, this.f12969c);
            }
        }
    }

    public void onError() {
    }

    @Override // com.lzy.okgo.callback.AbsCallback, com.lzy.okgo.callback.Callback
    public void onError(Response<ResponseJsonBean> response) {
        Throwable exception = response.getException();
        if ((exception instanceof SocketTimeoutException) || (exception instanceof UnknownHostException) || (exception instanceof UnknownServiceException) || (exception instanceof SocketException)) {
            ToastUtil.m9106a(AppContext.m21299a(), (int) R.string.net_exception_hint);
            Log.e(">>>>>--onNetworkError->>>>>","");
            onNetworkError();
            return;
        }
        ToastUtil.m9106a(AppContext.m21299a(), (int) R.string.get_data_error);
        Log.e(">>>>>--onError-->>>>>","");
        onError();
    }

    public void onException(int i, String str) {
    }

    @Override // com.lzy.okgo.callback.AbsCallback, com.lzy.okgo.callback.Callback
    public void onFinish() {
    }

    public void onNetworkError() {
    }

    public void onStart() {
    }

    @Override // com.lzy.okgo.callback.AbsCallback, com.lzy.okgo.callback.Callback
    public void onStart(Request<ResponseJsonBean, ? extends Request> request) {
        onStart();
    }








    @SuppressLint("LongLogTag")
    @Override
    public void onSuccess(Response<ResponseJsonBean> response) {
        if (response != null) {
            try {
                if (response.body() != null) {
                    ResponseJsonBean body = response.body();
                    if (body.getErrcode() == 0) {
                        String data = body.getData();
                        if (!TextUtils.isEmpty(data)) {
                            String a = Cfb_256crypt.m9209a("ljhlksslgkjfhlksuo8472rju6p2od03", data);
                            Log.e("rawData---->" , a);
                            if (!TextUtils.isEmpty(a)) {
                                JsonBean jsonBean = (JsonBean) JSON.parseObject(a, JsonBean.class);
                                if (jsonBean != null) {
                                    int status = jsonBean.getStatus();
                                    String msg = jsonBean.getMsg();
                                    boolean isVV = jsonBean.isVV();
                                    boolean isCrypt = jsonBean.isCrypt();
                                    boolean isNeedLogin = jsonBean.isNeedLogin();
                                    boolean A = SpUtil.m9573D().m9576A();
                                    if (!(AppUser.getInstance() == null || AppUser.getInstance().getUser() == null)) {
                                        AppUser.getInstance().getUser().setIs_vip(isVV ? 1 : 0);
                                    }
                                    SpUtil.m9573D().m9555b(jsonBean.isLogin());
                                    if (A || !isNeedLogin) {
                                        SpUtil.m9573D().m9540f(isNeedLogin);
                                        if (status == 1) {
                                            String data2 = jsonBean.getData();
                                            Log.e("resultData---->" , data2);
                                            onSuccess(data2, msg, isVV, isCrypt);
                                            return;
                                        }
                                        Log.e(">>>>>--onException-1->>>>>","");
//                                        onException(status, msg);
                                        return;
                                    }
                                    SpUtil.m9573D().m9572a();
                                    SpUtil.m9573D().m9540f(true);
                                    HttpUtil.m9737b(new C4219a(status, jsonBean, msg, isVV, isCrypt));
                                    return;
                                }
                                Log.e(">>>>>--onException-2->>>>>","");
//                                onException(0, "");
                                return;
                            }
                            Log.e(">>>>>--onException-3->>>>>","");
//                            onException(0, "");
                            return;
                        }
                        Log.e(">>>>>--onException-4->>>>>","");
//                        onException(0, "");
                        return;
                    }
                    Log.e(">>>>>--onException-5->>>>>","");
//                    onException(0, "");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(">>>>>--onException-7->>>>>","");
                Log.e("e----->" , e.getMessage());
//                onException(0, "");
                return;
            }
        }
        Log.e(">>>>>--onException-6->>>>>","");
//        onException(0, "");
    }

    @Override
    public ResponseJsonBean convertResponse(okhttp3.Response response) throws Throwable {
        if (response == null || response.body() == null) {
            return null;
        }
        String string = response.body().string();
        Log.e("responseStr---->" , string);
        if (!TextUtils.isEmpty(string)) {
            return (ResponseJsonBean) JSON.parseObject(string, ResponseJsonBean.class);
        }
        return null;
    }


    public void onSuccess(String str, String str2, boolean z, boolean z2) {
    }

}
