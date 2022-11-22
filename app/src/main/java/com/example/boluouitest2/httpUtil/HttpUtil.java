package com.example.boluouitest2.httpUtil;

import android.text.TextUtils;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.boluouitest2.AppContext;
import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.AppUser;
import com.example.boluouitest2.bean.ConfigBean;
import com.example.boluouitest2.bean.ResponseJsonBean;
import com.example.boluouitest2.bean.UserBean;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.SpUtil;
import com.example.boluouitest2.util.ToastUtil;
import com.example.boluouitest2.util.VersionUtil;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.PostRequest;

import java.util.List;
import java.util.Map;

public class HttpUtil {


    /* renamed from: a */
    public static void m9766a(CommonCallback<ConfigBean> aVar) {
        ((PostRequest) C4220b.m9794b().m9793b("/api/home/getConfig", "getConfigInfo").params(m9700e())).execute(new C4221a(aVar));
    }

    /* renamed from: e */
    public static HttpParams m9700e() {
        HttpParams a = m9789a();

        m9767a(a);
        return a;
    }

    /* renamed from: a */
    public static HttpParams m9789a() {
//        Log.e("getConfig:oauth_id:",SpUtil.m9573D().m9535i());
//        Log.e("getConfig:version:",VersionUtil.m9100a(AppContext.m21299a()));
////        Log.e("getConfig:token:",AppUser.getInstance().getUser().getToken());
//        Log.e("getConfig:bundle_id:",AppContext.m21299a().getPackageName());
//        Log.e("getConfig:237:",str);
//        Log.e("getConfig:237:",str);
//        Log.e("getConfig:237:",str);
        HttpParams httpParams = new HttpParams();
        httpParams.put("oauth_type", "android", new boolean[0]);
        httpParams.put("oauth_id", SpUtil.m9573D().m9535i(), new boolean[0]);

        httpParams.put("version", VersionUtil.m9100a(AppContext.m21299a()), new boolean[0]);


        if (AppUser.getInstance().getUser() == null || TextUtils.isEmpty(AppUser.getInstance().getUser().getToken())) {
            httpParams.put("token", "", new boolean[0]);
        } else {
            httpParams.put("token", AppUser.getInstance().getUser().getToken(), new boolean[0]);
//            Log.e("getConfig:token:",AppUser.getInstance().getUser().getToken());
        }
        httpParams.put("new_player", "fx", new boolean[0]);

        //////////////////////////////////////////////////////////////////////////////////////////

        httpParams.put("bundle_id", AppContext.m21299a().getPackageName(), new boolean[0]);
//        httpParams.put("bundle_id", "com.dnedu.blmv", new boolean[0]);

        return httpParams;
    }


    /* renamed from: b */
    public static void m9737b(CommonCallback<UserBean> aVar) {
        ((PostRequest) C4220b.m9794b().m9793b("/api/users/getBaseInfo", "getBaseInfo").params(m9745b())).execute(new C4222b(aVar));
    }


    /* renamed from: a */
    public static HttpParams m9767a(HttpParams httpParams) {
//        Log.e("getConfig:84getValue8484:","entry.getValue().get(0)1111111111111111111111");
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, List<String>> entry : httpParams.urlParamsMap.entrySet()) {
                jSONObject.put(entry.getKey(), (Object) entry.getValue().get(0));
//                Log.e("getConfig:84getKey8484:",entry.getKey());
//                Log.e("getConfig:84getValue8484:",entry.getValue().get(0));

            }
            httpParams.urlParamsMap.clear();
            JSONObject parseObject = JSON.parseObject(HttpParamUtil.m9791a(jSONObject.toJSONString()));
            httpParams.put("timestamp", parseObject.getString("timestamp"), new boolean[0]);
            httpParams.put(CacheEntity.DATA, parseObject.getString(CacheEntity.DATA), new boolean[0]);
            httpParams.put("sign", parseObject.getString("sign"), new boolean[0]);
            Log.e("請求參數加密後=====", httpParams.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpParams;
    }


    /* compiled from: HttpUtil.java */
    /* renamed from: e.c.a.i.d$a */
    /* loaded from: classes.dex */
    public static class C4221a extends HttpCallback {

        /* renamed from: a */
        public final /* synthetic */ CommonCallback f12975a;

        public C4221a(CommonCallback aVar) {
            this.f12975a = aVar;
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onError() {
            CommonCallback aVar = this.f12975a;
            if (aVar != null) {
                aVar.mo9799a(null);
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onException(int i, String str) {
            super.onException(i, str);
            CommonCallback aVar = this.f12975a;
            if (aVar != null) {
                aVar.mo9799a(null);
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onNetworkError() {
            super.onNetworkError();
            CommonCallback aVar = this.f12975a;
            if (aVar != null) {
                aVar.mo9799a(null);
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onSuccess(String str, String str2, boolean z, boolean z2) {
            try {
                SpUtil.m9573D().m9552c(str);
                JSONObject parseObject = JSON.parseObject(str);
                Log.e("getConfig:::::::", parseObject.toString());
                if (parseObject != null) {
                    SpUtil.m9573D().m9571a(parseObject.getIntValue("watch_is_fee_count"));
                    int intValue = parseObject.getIntValue("watch_count");
                    if (intValue > 0) {
                        SpUtil.m9573D().m9548d(intValue);
                    }
                    long longValue = parseObject.getLongValue("timestamp");
                    long w = SpUtil.m9573D().m9517w();
                    SpUtil.m9573D().m9530k(parseObject.getString("feature_page_ads"));
                    if (longValue != w) {
                        SpUtil.m9573D().m9561b(longValue);
                        SpUtil.m9573D().m9549d();
                        SpUtil.m9573D().m9554c();
                    }
                    SpUtil.m9573D().m9562b(parseObject.getIntValue("game_bottom_nav_show"));
                }
                ConfigBean configBean = (ConfigBean) JSON.parseObject(str, ConfigBean.class);
                if (configBean != null && !TextUtils.isEmpty(configBean.getSpareUrls())) {
                    SpUtil.m9573D().m9534i(configBean.getSpareUrls());
                }
                if (this.f12975a != null) {
                    this.f12975a.mo9799a(configBean);
                }
            } catch (Exception e) {
                e.printStackTrace();
                CommonCallback aVar = this.f12975a;
                if (aVar != null) {
                    aVar.mo9799a(null);
                }
            }
        }
    }


    /* renamed from: b */
    public static HttpParams m9745b() {
        HttpParams a = m9789a();
        m9767a(a);
        return a;
    }


    /* compiled from: HttpUtil.java */
    /* renamed from: e.c.a.i.d$b */
    /* loaded from: classes.dex */
    public static class C4222b extends HttpCallback {

        /* renamed from: a */
        public final /* synthetic */ CommonCallback f12976a;

        public C4222b(CommonCallback aVar) {
            this.f12976a = aVar;
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onError() {
            super.onError();
            CommonCallback aVar = this.f12976a;
            if (aVar != null) {
                aVar.mo9799a(null);
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onException(int i, String str) {
            super.onException(i, str);
            CommonCallback aVar = this.f12976a;
            if (aVar != null) {
                aVar.mo9799a(null);
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onNetworkError() {
            super.onNetworkError();
            CommonCallback aVar = this.f12976a;
            if (aVar != null) {
                aVar.mo9799a(null);
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onSuccess(String str, String str2, boolean z, boolean z2) {
            super.onSuccess(str, str2, z, z2);
            Log.e("getBaseInfo:", str);
            try {
                SpUtil.m9573D().m9532j(str);
                JSONObject parseObject = JSON.parseObject(str);
                if (parseObject != null) {
                    int intValue = parseObject.getIntValue("can_watch");
                    if (intValue >= 0) {
                        SpUtil.m9573D().m9553c(intValue);
                    }
                    long longValue = parseObject.getLongValue("expired_at");
                    if (longValue > 0) {
                        SpUtil.m9573D().m9570a(longValue);
                    }
                    SpUtil.m9573D().m9564a(parseObject.getBooleanValue("isCanWatchLive"));
                    SpUtil.m9573D().m9550c(parseObject.getBooleanValue("isRealUser"));
                }
                Log.e("HttpUtil:237:", str);
                UserBean userBean = (UserBean) JSON.parseObject(str, UserBean.class);
                if (userBean != null) {
                    if (this.f12976a != null) {
                        this.f12976a.mo9799a(userBean);
                        HttpUtil.m9706d(str);
                    }
                } else if (this.f12976a != null) {
                    this.f12976a.mo9799a(null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }





    /* renamed from: d */

    /**
     * 直播信息
     *
     * @param str
     */
    public static void m9706d(String str) {
        try {
            JSONObject parseObject = JSON.parseObject(str);
            String string = parseObject.getString("zbToken");
            String string2 = parseObject.getString("zbUid");
            UserBean userBean = (UserBean) JSON.parseObject(str, UserBean.class);
//            UserEntity userEntity = new UserEntity();
//            userEntity.setUserId(string2);
//            userEntity.setName(userBean.getNickname());
//            userEntity.setAvatar(userBean.getAvatar_url());
//            userEntity.setToken(string);
//            userEntity.setIsRisk("0");
//            userEntity.setSex(String.valueOf(userBean.getSexType()));
//            UserInfoManager.getInstance().loadUserInfo(userEntity);
//            SLLiveSDK.getSingleton().loginSDK(AppContext.m21299a(), new C4223c());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /* renamed from: e */
    public static void m9694e(String str, String str2, HttpCallback aVar) {
        ((PostRequest) C4220b.m9794b().m9793b("/api/mv/watching", "submit_play_data").params(m9761a(str, SpUtil.m9573D().m9517w(), str2))).execute(aVar);
    }

    /* renamed from: a */
    public static HttpParams m9761a(String str, long j, String str2) {
        Log.e("HttpUtil::::", "/api/mv/watching:::" + str + "\n" + j + "\n" + str2);
        HttpParams a = m9789a();
        a.put("timestamp", j, new boolean[0]);
        a.put("id_log", str2, new boolean[0]);
        a.put("log", str, new boolean[0]);
        m9767a(a);
        return a;
    }


    /* renamed from: l */
    public static void m9664l(HttpCallback aVar) {
        PostRequest<ResponseJsonBean> b = C4220b.m9794b().m9793b("/api/tab/index", "getHomePageSortInfo");
        HttpParams a = m9789a();
        m9767a(a);
        ((PostRequest) b.params(a)).execute(aVar);
    }


    /* renamed from: b */
    public static void m9735b(String str) {
        C4220b.m9794b().m9797a(str);
    }


    /* renamed from: a */
    public static void m9783a(int i, CommonCallback<Integer> aVar) {
        if (i == AppUser.getInstance().getUser().getUid()) {
            ToastUtil.m9102c(AppContext.m21299a(), CustomWordUtil.m9463a((int) R.string.cannot_follow_self));
        } else {
            ((PostRequest) C4220b.m9794b().m9793b("/api/users/following", "addAttention").params(m9654p(i))).execute(new C4224d(i, aVar));
        }
    }

    /* renamed from: p */
    public static HttpParams m9654p(int i) {
        HttpParams a = m9789a();
        a.put("to_uid", i, new boolean[0]);
        m9767a(a);
        return a;
    }


    /* compiled from: HttpUtil.java */
    /* renamed from: e.c.a.i.d$d */
    /* loaded from: classes.dex */
    public static class C4224d extends HttpCallback {

        /* renamed from: a */
        public final /* synthetic */ int f12977a;

        /* renamed from: b */
        public final /* synthetic */ CommonCallback f12978b;

        public C4224d(int i, CommonCallback aVar) {
            this.f12977a = i;
            this.f12978b = aVar;
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onException(int i, String str) {
            super.onException(i, str);
            if (!TextUtils.isEmpty(str)) {
                ToastUtil.m9102c(AppContext.m21299a(), str);
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onSuccess(String str, String str2, boolean z, boolean z2) {
            try {
                JSONObject parseObject = JSON.parseObject(str);
                int intValue = parseObject.getIntValue("is_attention");
                String string = parseObject.getString(NotificationCompat.CATEGORY_MESSAGE);
                if (!TextUtils.isEmpty(string)) {
                    ToastUtil.m9102c(AppContext.m21299a(), string);
                }
//                EventBus.m309d().m320a(new FollowEvent(this.f12977a, intValue));
                if (this.f12978b != null) {
                    this.f12978b.mo9799a(Integer.valueOf(intValue));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /* renamed from: b */
    public static void m9738b(long j, HttpCallback aVar) {
        ((PostRequest) C4220b.m9794b().m9793b("/api/mvnew/detail", "getVideoDetail").params(m9739b(j))).execute(aVar);
    }

    /* renamed from: b */
    public static HttpParams m9739b(long j) {

        Log.e("HttpUtil::::", "/api/mvnew/detail:::" + j);


        HttpParams a = m9789a();
        a.put("id", j, new boolean[0]);
        m9767a(a);
        return a;
    }


    /* renamed from: q */
    public static void m9649q(HttpCallback aVar) {
        PostRequest<ResponseJsonBean> b = C4220b.m9794b().m9793b("/api/search/conf", "getSearchNormalInfo");
        HttpParams a = m9789a();
        m9767a(a);
        ((PostRequest) b.params(a)).execute(aVar);
    }


    /* renamed from: i */
    public static void m9674i(int i, HttpCallback aVar) {
        ((PostRequest) C4220b.m9794b().m9793b("/api/users/getUserHome", "get_user_info").params(m9666l(i))).execute(aVar);
    }

    /* renamed from: l */
    public static HttpParams m9666l(int i) {
        HttpParams a = m9789a();
        a.put("to_uid", i, new boolean[0]);
        m9767a(a);
        return a;
    }


    /* renamed from: b */
    public static void m9727b(String str, String str2, String str3, int i, HttpCallback aVar) {
        ((PostRequest) C4220b.m9794b().m9793b(str, str).params(m9775a(i, str2, str3))).execute(aVar);
    }

    /* renamed from: a */
    public static HttpParams m9775a(int i, String str, String str2) {
        HttpParams a = m9789a();
        a.put("page", i, new boolean[0]);
        a.put("uid", str, new boolean[0]);
        a.put("kwy", str2, new boolean[0]);
        m9767a(a);
        return a;
    }


    /* renamed from: j */
    public static void m9671j(int i, HttpCallback aVar) {
        ((PostRequest) C4220b.m9794b().m9793b("/api/usertopic/listmvOfTopic", "getVideoCollectDetail").params(m9663m(i))).execute(aVar);
    }

    /* renamed from: m */
    public static HttpParams m9663m(int i) {
        HttpParams a = m9789a();
        a.put("topic_id", i, new boolean[0]);
        m9767a(a);
        return a;
    }


    /* renamed from: k */
    public static void m9668k(int i, HttpCallback aVar) {
        ((PostRequest) C4220b.m9794b().m9793b("/api/usertopic/toggle_like", "likeVideoCollectAction").params(m9660n(i))).execute(aVar);
    }

    /* renamed from: n */
    public static HttpParams m9660n(int i) {
        HttpParams a = m9789a();
        a.put("topic_id", i, new boolean[0]);
        m9767a(a);
        return a;
    }


    //    2022/4/23
    /* renamed from: a */
    public static void m9782a(int i, HttpCallback aVar) {
        ((PostRequest) C4220b.m9794b().m9793b("/api/comments/liking", "addCommentLike").params(m9724c(i))).execute(aVar);
    }

    /* renamed from: c */
    public static HttpParams m9724c(int i) {
        HttpParams a = m9789a();
        a.put("id", i, new boolean[0]);
        m9767a(a);
        return a;
    }


    /* renamed from: a */
    public static void m9778a(int i, String str, int i2, int i3, HttpCallback aVar) {
        ((PostRequest) C4220b.m9794b().m9793b("/api/comments/create", "setComment").params(m9779a(i, str, i2, i3))).execute(aVar);
    }

    /* renamed from: a */
    public static HttpParams m9779a(int i, String str, int i2, int i3) {
        HttpParams a = m9789a();
        a.put("mv_id", i, new boolean[0]);
        a.put("c_id", i2, new boolean[0]);
        if (i3 > 0) {
            a.put("s_id", i3, new boolean[0]);
        }
        a.put("comment", str, new boolean[0]);
        m9767a(a);
        return a;
    }

    /* renamed from: a */
    public static void m9777a(int i, String str, int i2, HttpCallback aVar) {
        ((PostRequest) C4220b.m9794b().m9793b("/api/comments/create", "addComment").params(m9780a(i, str, i2))).execute(aVar);
    }

    /* renamed from: a */
    public static HttpParams m9780a(int i, String str, int i2) {
        HttpParams a = m9789a();
        a.put("mv_id", i, new boolean[0]);
        a.put("c_id", 0, new boolean[0]);
        if (i2 > 0) {
            a.put("s_id", i2, new boolean[0]);
        }
        a.put("comment", str, new boolean[0]);
        m9767a(a);
        return a;
    }




    /* renamed from: u */
    public static void m9642u(HttpCallback aVar) {
        PostRequest<ResponseJsonBean> b = C4220b.m9794b().m9793b("/api/topvideo/commentTop1", "getVideoHotTalk");
        HttpParams a = m9789a();
        m9767a(a);
        ((PostRequest) b.params(a)).execute(aVar);
    }


    /* renamed from: a */
    public static void m9760a(String str, HttpCallback aVar) {
        PostRequest<ResponseJsonBean> b = C4220b.m9794b().m9793b(str, str);
        HttpParams a = m9789a();
        m9767a(a);
        ((PostRequest) b.params(a)).execute(aVar);
    }





}
