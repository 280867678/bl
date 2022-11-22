package com.example.boluouitest2.bean;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.example.boluouitest2.httpUtil.CommonCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.util.SpUtil;

import java.util.List;

public class AppConfig {

    public static AppConfig mInstance;
    public ConfigBean mConfigBean;

    public static AppConfig getInstance() {
        if (mInstance == null) {
            synchronized (AppConfig.class) {
                if (mInstance == null) {
                    mInstance = new AppConfig();
                }
            }
        }
        return mInstance;
    }

    public ConfigBean getConfig() {
        String g = SpUtil.m9573D().m9539g();
        if (!TextUtils.isEmpty(g)) {
            this.mConfigBean = (ConfigBean) JSON.parseObject(g, ConfigBean.class);
        }
        return this.mConfigBean;
    }

    public List<PaySortBean> getPaySortList() {
        return getConfig().getPaySort();
    }

    public void getConfig(CommonCallback<ConfigBean> aVar) {
        if (aVar != null) {
            ConfigBean config = getConfig();
            if (config != null) {
                aVar.mo9799a(config);
            } else {
                HttpUtil.m9766a(aVar);
            }
        }
    }


}
