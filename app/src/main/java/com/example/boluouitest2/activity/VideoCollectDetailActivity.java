package com.example.boluouitest2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.boluouitest2.R;
import com.example.boluouitest2.fragment.VideoCollectDetailFragment;
import com.example.boluouitest2.util.IntentUtil;

public class VideoCollectDetailActivity extends AbsActivity {
    /* renamed from: a */
    public static void m20749a(Context context, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("VIDEO_COLLECT_ID", i);
        IntentUtil.m9080a(context, VideoCollectDetailActivity.class, bundle);
    }

    @Override
    public void mo20592a(Bundle bundle) {
        m20750G();
    }

    /* renamed from: G */
    @SuppressLint("LongLogTag")
    public final void m20750G() {
        try {
            int i = getIntent().getExtras().getInt("VIDEO_COLLECT_ID", -1);
            if (i == -1) {
                finish();
                return;
            }
            m21291d(getString(R.string.str_video_collect_detail));
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(R.id.container, VideoCollectDetailFragment.m20548d(i));
            beginTransaction.commitAllowingStateLoss();
            Log.e("VideoCollectDetailActivity","39");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @Override
    public int mo20588z() {
        return R.layout.activity_video_collect_detail;
    }
}