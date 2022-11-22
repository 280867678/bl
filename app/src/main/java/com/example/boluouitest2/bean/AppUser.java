package com.example.boluouitest2.bean;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.example.boluouitest2.httpUtil.CommonCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.util.SpUtil;

public class AppUser {

    public static AppUser mInstance;
    public UserBean mUserBean;

    public static AppUser getInstance() {
        if (mInstance == null) {
            synchronized (AppUser.class) {
                if (mInstance == null) {
                    mInstance = new AppUser();
                }
            }
        }
        return mInstance;
    }

    public UserBean getUser() {
        String r = SpUtil.m9573D().m9522r();
        Log.e("AppUser:::29：",r);
        if (!TextUtils.isEmpty(r)) {
            this.mUserBean = (UserBean) JSON.parseObject(r, UserBean.class);
        }
        return this.mUserBean;
    }

    public boolean hasMsg() {
        UserBean userBean = this.mUserBean;
        return userBean != null && userBean.getMessage_tip() > 0;
    }

    public boolean isRealVip() {
        UserBean userBean = this.mUserBean;
        return userBean != null && userBean.getIs_vip() == 1 && this.mUserBean.getVip_level() > 0;
    }

    public void setUser(UserBean userBean) {
        SpUtil.m9573D().m9532j(JSON.toJSONString(userBean));
    }

    public void getUser(CommonCallback<UserBean> aVar) {
        if (aVar != null) {
            try {
                UserBean user = getUser();
                if (user != null) {
                    aVar.mo9799a(user);
                } else {
                    HttpUtil.m9737b(aVar);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
