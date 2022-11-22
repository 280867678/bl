package com.example.boluouitest2.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.boluouitest2.R;
import com.example.boluouitest2.VHDelegate.PersonalVideoCollectListVHDelegate;
import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;
import com.example.boluouitest2.activity.VideoCollectDetailActivity;
import com.example.boluouitest2.bean.VideoCollectInfoBean;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

/**
*合集
 *
 */
public class PersonalVideoCollectListFragment extends AbsLazyListFragment<VideoCollectInfoBean> {
    /* renamed from: o */
    public String f1280o;

    /* renamed from: p */
    public int f1281p;

    /* renamed from: q */
    public int f1282q;

    /* renamed from: r */
    public String f1283r;


    /* renamed from: a */
    public static PersonalVideoCollectListFragment m20389a(int i, int i2) {
        PersonalVideoCollectListFragment personalVideoCollectListFragment = new PersonalVideoCollectListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key_load_method", 1);
        bundle.putInt("key_type_collect", i);
        bundle.putInt("key_uid", i2);
        personalVideoCollectListFragment.setArguments(bundle);
        return personalVideoCollectListFragment;
    }






    @Override
    public String mo20298I() {
        return this.f1280o;
    }

    @SuppressLint("LongLogTag")
    @Override
    public List<VideoCollectInfoBean> mo20295a(String str) {
        List<VideoCollectInfoBean> arrayList = new ArrayList<>();
        Log.e("PersonalVideoCollectListFragment","71");
        try {
            if (!TextUtils.isEmpty(str)) {
                Object parse = JSON.parse(str);
                if (parse instanceof JSONObject) {
                    JSONObject parseObject = JSON.parseObject(str);
                    if (parseObject.containsKey("list")) {
                        arrayList = JSON.parseArray(parseObject.getString("list"), VideoCollectInfoBean.class);
                        Log.e("PersonalVideoCollectListFragment","78");
                    }
                    Log.e("PersonalVideoCollectListFragment","79");
                } else if (parse instanceof JSONArray) {
                    arrayList = JSON.parseArray(str, VideoCollectInfoBean.class);
                    Log.e("PersonalVideoCollectListFragment","83");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @Override
    public String mo20289w() {
        return this.f1283r;
    }




































    @Override // com.blmvl.blvl.fragment.AbsLazyListFragment
    /* renamed from: b */
    public VHDelegateImpl<VideoCollectInfoBean> mo20294b(int i) {
        return new PersonalVideoCollectListVHDelegate(this.f1281p);
    }

    @Override // com.blmvl.blvl.fragment.AbsLazyListFragment
    /* renamed from: c */
    public void mo20292c(View view) {
        super.mo20292c(view);
        m20387d(view);
    }

    /* renamed from: d */
    public final void m20387d(View view) {
        this.f1121k.setOnItemClickListener(new BaseListViewAdapter.AbstractC0888a() { // from class: e.c.a.g.q
            @Override // com.comod.baselib.list.BaseListViewAdapter.AbstractC0888a
            /* renamed from: a */
            public final void mo9802a(View view2, Object obj, int i) {
                PersonalVideoCollectListFragment.this.m20388a(view2, (VideoCollectInfoBean) obj, i);
            }
        });
    }


    @SuppressLint("LongLogTag")
    @Override // com.blmvl.blvl.fragment.AbsLazyListFragment
    /* renamed from: a */
    public void mo20310a(Bundle bundle) {
        super.mo20310a(bundle);
        this.f1281p = getArguments().getInt("key_type_collect");
        int i = this.f1281p;
        if (i == 1) {
            this.f1283r = "/api/usertopic/listOfTopic";
            this.f1280o = "get_video_collect_list";
//            LogUtil.m9410a("BL_PERSONAL_VIDEO_COLLECT_LIST_PAGE");
        } else if (i == 2) {
            this.f1283r = "/api/usertopic/likeOfTopic";
            this.f1280o = "get_like_video_collect_list";
//            LogUtil.m9410a("BL_PERSONAL_VIDEO_COLLECT_LIKE_LIST_PAGE");
        }
        this.f1282q = getArguments().getInt("key_uid");

        Log.e("PersonalVideoCollectListFragment176：", String.valueOf(this.f1281p));
        Log.e("PersonalVideoCollectListFragment177：", String.valueOf(this.f1282q));
    }


    @Override // com.blmvl.blvl.fragment.AbsLazyListFragment
    /* renamed from: a */
    public void mo20309a(HttpParams httpParams) {
        super.mo20309a(httpParams);
        httpParams.put("uid", this.f1282q, new boolean[0]);
    }

    /* renamed from: a */
    @SuppressLint("LongLogTag")
    public /* synthetic */ void m20388a(View view, VideoCollectInfoBean videoCollectInfoBean, int i) {
        Log.e("PersonalVideoCollectListFragment","180");
        if (videoCollectInfoBean != null) {
            try {
                Log.e("PersonalVideoCollectListFragment","videoCollectInfoBean != null 185");
                VideoCollectDetailActivity.m20749a(getContext(), videoCollectInfoBean.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }






}