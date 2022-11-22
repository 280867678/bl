package com.example.boluouitest2.util;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;


import com.example.boluouitest2.EventBus.CurSelectVideoIdEvent;
import com.example.boluouitest2.R;
import com.example.boluouitest2.activity.VideoDetailInfoActivity;

import org.greenrobot.eventbus.EventBus;

public class JumpUtil {


    /* renamed from: a */
    public static JumpUtil f13057a;

    /* renamed from: a */
    public static JumpUtil m9417a() {
        if (f13057a == null) {
            synchronized (JumpUtil.class) {
                if (f13057a == null) {
                    f13057a = new JumpUtil();
                }
            }
        }
        return f13057a;
    }



    /* renamed from: a */
    public void m9414a(Context context, final int i) {
        try {
            VideoDetailInfoActivity.m20690a(context);
//            Log.e("VideoDetailInfoActivity",":::::.m20690a(context)");
            new Handler().postDelayed(new Runnable() { // from class: e.c.a.k.e
                @Override // java.lang.Runnable
                public final void run() {
//                    EventBus.m309d().m320a(new CurSelectVideoIdEvent(i));
                    EventBus.getDefault().post(new CurSelectVideoIdEvent(i));
                }
            }, 400L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




























    /* renamed from: a */
    public void m9413a(Context context, int i, String str) {
        try {
            if (i == 1 || i == 5) {
                if (!TextUtils.isEmpty(str)) {
//                    WebViewUtil.m9087a(context, str);
                    ToastUtil.m9102c(context, "JumpUtil:WebViewUtil.m9087a(context, str)61");
                }
            } else if (i == 3 || i == 0) {
                if (!TextUtils.isEmpty(str)) {
//                    WebViewActivity.m20642a(context, str);
                    ToastUtil.m9102c(context, "JumpUtil:WebViewActivity.m20642a(context, str)66");
                }
            } else if (i == 4) {
                m9412a(context, str);
            } else if (i == 6) {
//                BuyMemberActivity.m21257a(context);
                ToastUtil.m9102c(context, "JumpUtil:BuyMemberActivity.m21257a(context)72");
            } else if (i == 7) {
//                CoinRechargeActivity.m21240a(context);
                ToastUtil.m9102c(context, "JumpUtil:CoinRechargeActivity.m21240a(context)75");
            } else if (i == 8) {
//                GameJumpUtil.m9432a(context, Integer.parseInt(str));
                ToastUtil.m9102c(context, "JumpUtil:GameJumpUtil.m9432a(context, Integer.parseInt(str))78");
            } else {
                ToastUtil.m9102c(context, context.getString(R.string.lower_version_tips));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /* renamed from: a */
    public final void m9412a(Context context, String str) {
        m9417a().m9414a(context, Integer.parseInt(str));
    }





}
