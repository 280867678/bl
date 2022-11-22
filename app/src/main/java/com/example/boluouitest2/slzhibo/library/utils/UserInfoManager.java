package com.example.boluouitest2.slzhibo.library.utils;

public class UserInfoManager {


    public final String APP_ID;
    public final String APP_OPEN_ID;
    public final String CHANNEL_TOKEN;
    public final String EXP_GRADE;
    public final String IS_ENTER_HIDE;
    public final String IS_ENTER_LIVE_PERMISSION;
    public final String IS_INBANGROUP;
    public final String IS_LOGIN;
    public final String IS_RISK;
    public final String IS_SUPER_ADMIN;
    public final String IS_VISITOR_USER;
    public final String SDK_USER_ID;
    public final String SPNAME;
    public final String TOKEN;
    public final String USER_AVATAR;
    public final String USER_NICKNAME;
    public final String USER_NOBITLITY_TYPE;
    public final String USER_SEX;
    public UserInfoManager() {
        this.SPNAME = "fq_user";
        this.IS_LOGIN = "isLogin";
        this.APP_OPEN_ID = "userId";
        this.APP_ID = "appId";
        this.TOKEN = "token";
        this.CHANNEL_TOKEN = "channelToken";
        this.SDK_USER_ID = "sdkUserId";
        this.USER_NICKNAME = "userNickname";
        this.USER_AVATAR = "userAvatar";
        this.USER_SEX = "userSex";
        this.USER_NOBITLITY_TYPE = "userNobitlityType";
        this.IS_INBANGROUP = "isInBanGroup";
        this.IS_ENTER_HIDE = "isEnterHide";
        this.IS_SUPER_ADMIN = "isSuperAdmin";
        this.IS_VISITOR_USER = "isVisitorUser";
        this.IS_ENTER_LIVE_PERMISSION = "isEnterLivePermission";
        this.EXP_GRADE = "expGrade";
        this.IS_RISK = "IS_RISK";
    }

    public static UserInfoManager getInstance() {
        return C3122b.f9732a;
    }

    /* renamed from: com.slzhibo.library.utils.UserInfoManager$b */
    /* loaded from: classes2.dex */
    public static class C3122b {

        /* renamed from: a */
        public static final UserInfoManager f9732a = new UserInfoManager();
    }

    public String getToken() {
        return SPUtils.m10234d("fq_user").m10244a("isLogin", false) ? SPUtils.m10234d("fq_user").m10246a("token", "") : "";
    }


}
