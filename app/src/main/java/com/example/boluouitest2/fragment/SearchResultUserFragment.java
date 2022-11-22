package com.example.boluouitest2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.example.boluouitest2.Adapter.SearchResultUserAdapter;
import com.example.boluouitest2.EventBus.FollowEvent;
import com.example.boluouitest2.R;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;
import com.example.boluouitest2.bean.UserBean;
import com.example.boluouitest2.util.RecyclerViewUtil;
import com.lzy.okgo.model.HttpParams;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


public class SearchResultUserFragment extends AbsLazyListFragment<UserBean>  {

    /* renamed from: o */
    public String f1350o;

    /* renamed from: b */
    public static SearchResultUserFragment m20308b(String str) {
//        Log.e("搜索用户2：：","SearchResultUserFragment");
        SearchResultUserFragment searchResultUserFragment = new SearchResultUserFragment();
        Bundle bundle = new Bundle();
        bundle.putString("keyword", str);
        searchResultUserFragment.setArguments(bundle);
        return searchResultUserFragment;
    }

    @Override // com.blmvl.blvl.fragment.AbsLazyListFragment
    /* renamed from: A */
    public RecyclerView.LayoutManager mo20312A() {
//        Log.e("搜索用户2：：","RecyclerView.LayoutManager");
        return RecyclerViewUtil.m9212a(getContext());
    }

    @Override // com.blmvl.blvl.fragment.AbsLazyListFragment
    /* renamed from: E */
    public BaseListViewAdapter<UserBean> mo20311E() {
//        Log.e("搜索用户2：：","BaseListViewAdapter<UserBean>");
        return new SearchResultUserAdapter();
    }

    @Override // com.blmvl.blvl.fragment.AbsLazyListFragment
    /* renamed from: I */
    public String mo20298I() {
        Log.e("搜索用户2：：","mo20298I");
        return "getSearchUserList";
    }

    @Override // com.blmvl.blvl.fragment.AbsLazyListFragment
    /* renamed from: a */
    public void mo20310a(Bundle bundle) {
//        Log.e("搜索用户2：：","mo20310a");
        super.mo20310a(bundle);
        this.f1350o = bundle.getString("keyword");
    }

    @Override // com.blmvl.blvl.fragment.AbsLazyListFragment
    /* renamed from: c */
    public void mo20292c(View view) {
        super.mo20292c(view);
        ((SearchResultUserAdapter) this.f1121k).m20586a(this.f1350o);
//        EventBus.m309d().m310c(this);
        //注册
        EventBus.getDefault().register(this);
        Log.e("搜索用户1：：","onFollowEvent");
//        LogUtil.m9410a("BL_SEARCH_RESULT_USER_PAGE");
    }

    @Override // com.blmvl.blvl.fragment.AbsLazyListFragment, android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
//        EventBus.m309d().m308d(this);
        //取消注册
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(FollowEvent followEvent) {
        Log.e("搜索用户2：：","onFollowEvent");
        try {
            if (!(this.f1121k == null || this.f1121k.getItems().isEmpty())) {
                Log.e("搜索用户3：：","onFollowEvent");
                for (int i = 0; i < this.f1121k.getItems().size(); i++) {
                    Log.e("搜索用户4：：","onFollowEvent");
                    UserBean userBean = (UserBean) this.f1121k.getItems().get(i);
                    if (userBean != null && userBean.getUid() == followEvent.getToUid()) {
                        Log.e("搜索用户5：：","onFollowEvent");
                        userBean.setIs_attention(followEvent.getIsAttention());
                        this.f1121k.notifyItemChanged(i);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.blmvl.blvl.fragment.AbsLazyListFragment
    /* renamed from: w */
    public String mo20289w() {
        Log.e("搜索用户2：：","mo20289w");
        return "/api/search/user";
    }

    @Override // com.blmvl.blvl.fragment.AbsLazyListFragment
    /* renamed from: a */
    public List<UserBean> mo20295a(String str) {
        Log.e("搜索用户2：：","mo20295a");
        try {
            if (!TextUtils.isEmpty(str)) {
                return JSON.parseArray(JSON.parseObject(str).getString("list"), UserBean.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList();
    }

    @Override // com.blmvl.blvl.fragment.AbsLazyListFragment
    /* renamed from: a */
    public void mo20309a(HttpParams httpParams) {
        Log.e("搜索用户2：：","mo20309a");
        super.mo20309a(httpParams);
        httpParams.put("kwy", this.f1350o, new boolean[0]);
    }


















}