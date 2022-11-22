package com.example.boluouitest2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.boluouitest2.R;
import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.VHDelegate.VideoBigCoverVHDelegate;
import com.example.boluouitest2.VHDelegate.VideoDailyMoreLineVHDelegate;
import com.example.boluouitest2.VHDelegate.VideoDailyMoreTitleVHDelegate;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;
import com.example.boluouitest2.ViewHelper.RecyclerViewHelper;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.bean.VideoDailyMoreBean;
import com.example.boluouitest2.bean.VideoDailyMoreInfoBean;
import com.example.boluouitest2.util.ListUtil;
import com.example.boluouitest2.util.ObjUtil;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Progress;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * 每日推荐。。。更多
 */
public class VideoDailyMoreActivity extends AbsActivity implements View.OnClickListener  {

    /* renamed from: b */
    public ImageView f909b;

    /* renamed from: c */
    public TextView f910c;

    /* renamed from: d */
    public TextView f911d;

    /* renamed from: e */
    public FrameLayout f912e;

    /* renamed from: f */
    public String f913f;

    /* renamed from: g */
    public RecyclerViewHelper f914g;

    /* renamed from: h */
    public boolean f915h = true;

    /* renamed from: G */
    public final void m20704G() {
        try {
            this.f909b = (ImageView) findViewById(R.id.img_back);
            this.f909b.setOnClickListener(this);
            this.f910c = (TextView) findViewById(R.id.tv_title);
            ImageView imageView = (ImageView) findViewById(R.id.img_calendar);
            this.f911d = (TextView) findViewById(R.id.tv_date);
            this.f912e = (FrameLayout) findViewById(R.id.layout_calendar);
            this.f912e.setOnClickListener(this);
            this.f910c.setText(getString(R.string.str_daily_recommend));
            this.f914g = new C0695a(this, this);
//            LogUtil.m9410a("BL_DAILY_VIDEO_MORE_PAGE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /* renamed from: com.blmvl.blvl.activity.VideoDailyMoreActivity$a */
    /* loaded from: classes.dex */
    public class C0695a extends RecyclerViewHelper {
        public C0695a(Context context, Activity activity) {
            super(context, activity);
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: D */
        public void mo9391D() {
            VideoDailyMoreActivity.this.f913f = "";
            VideoDailyMoreActivity.this.f915h = true;
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: a */
        public List<BaseListViewAdapter.C0890c> mo9379a(String str) {
            VideoDailyMoreBean videoDailyMoreBean = (VideoDailyMoreBean) JSON.parseObject(str, VideoDailyMoreBean.class);
            ArrayList arrayList = new ArrayList();
            if (videoDailyMoreBean != null) {
                if (m9363j() == 1 && ObjUtil.m9224a(videoDailyMoreBean.getInfo()) && !TextUtils.isEmpty(videoDailyMoreBean.getInfo().getDay())) {
                    try {
                        Date parse = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(videoDailyMoreBean.getInfo().getDay());
                        if (ObjUtil.m9224a(parse)) {
                            VideoDailyMoreActivity.this.f911d.setText(new SimpleDateFormat("dd", Locale.getDefault()).format(parse));
                            if (VideoDailyMoreActivity.this.f915h) {
                                VideoDailyMoreActivity.this.f910c.setText(VideoDailyMoreActivity.this.getString(R.string.str_daily_recommend));
                            } else {
                                VideoDailyMoreActivity.this.f910c.setText(String.format("%s推荐", new SimpleDateFormat("MM月dd日", Locale.getDefault()).format(parse)));
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if (ListUtil.m9075b(videoDailyMoreBean.getList())) {
                    if (VideoDailyMoreActivity.this.f915h && ObjUtil.m9224a(videoDailyMoreBean.getInfo())) {
                        VideoDailyMoreInfoBean info = videoDailyMoreBean.getInfo();
                        info.setViewRenderType(1);
                        arrayList.add(info);
                    }
                    List<VideoBean> list = videoDailyMoreBean.getList();
                    for (VideoBean videoBean : list) {
                        videoBean.setViewRenderType(2);
                    }
                    arrayList.addAll(list);
                }
            }
            return arrayList;
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: b */
        public VHDelegateImpl mo9376b(int i) {
            if (i == 1) {
                return new VideoDailyMoreTitleVHDelegate();
            }
            if (i == 3) {
                return new VideoDailyMoreLineVHDelegate();
            }
            return new VideoBigCoverVHDelegate();
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: b */
        public String mo9377b() {
            return "/api/dailyvideo/list";
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: c */
        public int mo9374c() {
            return R.layout.layout_list_big_cover_view_default;
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: p */
        public String mo9357p() {
            return "getVideoDailyMore";
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: v */
        public boolean mo9351v() {
            return VideoDailyMoreActivity.this.f915h;
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: a */
        public void mo9381a(HttpParams httpParams) {
            httpParams.put(Progress.DATE, VideoDailyMoreActivity.this.f913f, new boolean[0]);
        }
    }



























    /* renamed from: a */
    public static void m20703a(Context context) {
        context.startActivity(new Intent(context, VideoDailyMoreActivity.class));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.img_back) {
            finish();
        } else if (view.getId() == R.id.layout_calendar) {
            Toast.makeText(this, "VideoDailyMoreActivity:::215", Toast.LENGTH_SHORT).show();
//            try {
//                DatePickerDialog b0Var = new DatePickerDialog(this);
//                b0Var.setOnPickerListener(new DatePickerDialog.AbstractC4121a() { // from class: e.c.a.c.c2
//                    @Override // p067e.p103c.p104a.p108f.DatePickerDialog.AbstractC4121a
//                    /* renamed from: a */
//                    public final void mo9939a(String str) {
//                        VideoDailyMoreActivity.this.m20696h(str);
//                    }
//                });
//                b0Var.show();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
    }

    @Override
    public void mo20592a(Bundle bundle) {
        m20704G();
    }

    @Override
    public int mo20588z() {
        return R.layout.activity_video_daily_more;
    }
}