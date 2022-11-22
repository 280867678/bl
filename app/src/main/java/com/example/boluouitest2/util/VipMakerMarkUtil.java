package com.example.boluouitest2.util;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.UserBean;

public class VipMakerMarkUtil {

    /* renamed from: a */
    public static void m9496a(ImageView imageView, UserBean userBean) {
        try {
            if (userBean.getIs_vip() == 0 && userBean.getAuth_level() == 0) {
                imageView.setVisibility(View.GONE);
            } else if (userBean.getAuth_level() > 0) {
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.mipmap.ic_video_maker_level_small);
            } else if (userBean.getIs_vip() == 1 && userBean.getVip_level() > 0) {
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(m9494b(userBean.getVip_level()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static int m9494b(int i) {
        if (i == 1) {
            return R.mipmap.ic_vip_month_small;
        }
        if (i == 2) {
            return R.mipmap.ic_vip_season_small;
        }
        if (i == 3) {
            return R.mipmap.ic_vip_year_small;
        }
        if (i == 4) {
            return R.mipmap.ic_vip_forever_small;
        }
        return 0;
    }







    /* renamed from: a */
    public static void m9495a(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView, UserBean userBean) {
        try {
            if (userBean.getIs_vip() == 0 && userBean.getAuth_level() == 0) {
                linearLayout.setVisibility(View.GONE);
                return;
            }
            if (userBean.getIs_vip() != 1 || userBean.getVip_level() <= 0) {
                imageView.setVisibility(View.GONE);
            } else {
                linearLayout.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(m9497a(userBean.getVip_level()));
            }
            if (userBean.getAuth_level() > 0) {
                linearLayout.setVisibility(View.VISIBLE);
                linearLayout2.setVisibility(View.VISIBLE);
                textView.setText(String.format("%s%s", "UP主LV.", String.valueOf(userBean.getAuth_level())));
            } else {
                linearLayout2.setVisibility(View.GONE);
            }
            if (imageView.getVisibility() == View.GONE && linearLayout2.getVisibility() == View.GONE) {
                linearLayout.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static int m9497a(int i) {
        if (i == 1) {
            return R.mipmap.ic_vip_month;
        }
        if (i == 2) {
            return R.mipmap.ic_vip_season;
        }
        if (i == 3) {
            return R.mipmap.ic_vip_year;
        }
        if (i == 4) {
            return R.mipmap.ic_vip_forever;
        }
        return 0;
    }


}
