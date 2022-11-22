package com.example.boluouitest2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.boluouitest2.R;
import com.example.boluouitest2.comod.baselib.view.MyViewPager;
import com.example.boluouitest2.comod.baselib.view.magicindicator.MagicIndicator;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class VideoCreatorActivity extends AbsActivity {
    /* renamed from: b */
    public ImageView f892b;

    /* renamed from: c */
    public RoundedImageView f893c;

    /* renamed from: d */
    public TextView f894d;

    /* renamed from: e */
    public TextView f895e;

    /* renamed from: f */
    public TextView f896f;

    /* renamed from: g */
    public RecyclerView f897g;

    /* renamed from: h */
//    public VideoCreatorAdapter f898h;

    /* renamed from: i */
    public MagicIndicator f899i;

    /* renamed from: j */
    public MyViewPager f900j;

    /* renamed from: k */
    public List<String> f901k = null;

    /* renamed from: l */
    public LinearLayout f902l;

    /* renamed from: m */
    public int f903m;

    /* renamed from: n */
    public TextView f904n;

    /* renamed from: o */
    public ImageView f905o;

    /* renamed from: p */
//    public VideoCreatorRecommendBean f906p;

    @Override
    public void mo20592a(Bundle bundle) {
//        try {
//            this.f903m = getIntent().getIntExtra("index", 0);
//            m20726U();
//            m20729N();
//            m20730G();
//            m20727R();
//            m20728Q();
//            EventBus.m309d().m310c(this);
//            LogUtil.m9410a("BL_VIDEO_CREATOR_PAGE");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public int mo20588z() {
        return R.layout.activity_video_creator;
    }


    /* renamed from: a */
    public static void m20725a(Context context, int i) {
        Intent intent = new Intent(context, VideoCreatorActivity.class);
        intent.putExtra("index", i);
        context.startActivity(intent);
    }


}