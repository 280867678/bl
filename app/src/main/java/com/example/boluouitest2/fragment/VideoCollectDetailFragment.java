package com.example.boluouitest2.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.boluouitest2.Adapter.VideoCollectVideoListAdapter;
import com.example.boluouitest2.R;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;
import com.example.boluouitest2.activity.HomePageActivity;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.bean.VideoCollectBean;
import com.example.boluouitest2.comod.baselib.fragment.AbsFragment;
import com.example.boluouitest2.comod.baselib.view.CustomTextView;
import com.example.boluouitest2.httpUtil.HttpCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.JumpUtil;
import com.example.boluouitest2.util.NumberUtil;
import com.example.boluouitest2.util.ObjUtil;
import com.example.boluouitest2.util.ToastUtil;
import com.example.boluouitest2.util.WordUtil;
import com.makeramen.roundedimageview.RoundedImageView;


public class VideoCollectDetailFragment extends AbsFragment implements View.OnClickListener, BaseListViewAdapter.AbstractC0888a<VideoBean> {
    /* renamed from: b */
    public RoundedImageView img_cover;

    /* renamed from: c */
    public TextView tv_collect_title;

    /* renamed from: d */
    public RoundedImageView img_avatar;

    /* renamed from: e */
    public TextView tv_name;

    /* renamed from: f */
    public CustomTextView f1088f;

    /* renamed from: g */
    public TextView f1089g;

    /* renamed from: h */
    public LinearLayout f1090h;

    /* renamed from: i */
    public RecyclerView f1091i;

    /* renamed from: j */
    public VideoCollectVideoListAdapter f1092j;

    /* renamed from: k */
    public ImageView f1093k;

    /* renamed from: l */
    public TextView f1094l;

    /* renamed from: m */
    public int f1095m;

    /* renamed from: n */
    public LinearLayout f1096n;

    /* renamed from: o */
    public View f1097o;

    /* renamed from: p */
    public VideoCollectBean videoCollectBean;

    /* renamed from: d */
    public static VideoCollectDetailFragment m20548d(int i) {
        VideoCollectDetailFragment videoCollectDetailFragment = new VideoCollectDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("VIDEO_COLLECT_ID", i);
        videoCollectDetailFragment.setArguments(bundle);
        return videoCollectDetailFragment;
    }




    @Override
    public void onClick(View view) {
        m20546v();
    }

    /* renamed from: v */
    public final void m20546v() {
        HttpUtil.m9668k(this.f1095m, new C0736c());
    }

    /* renamed from: com.blmvl.blvl.dialog.VideoCollectDetailFragment$c */
    /* loaded from: classes.dex */
    public class C0736c extends HttpCallback {
        public C0736c() {
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onException(int i, String str) {
            super.onException(i, str);
            if (!TextUtils.isEmpty(str)) {
                ToastUtil.m9102c(VideoCollectDetailFragment.this.getContext(), str);
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onSuccess(String str, String str2, boolean z, boolean z2) {
            int i;
            super.onSuccess(str, str2, z, z2);
            try {
                String string = JSON.parseObject(str).getString("status");
                int like_count = VideoCollectDetailFragment.this.videoCollectBean.getInfo().getLike_count();
                if (string.equals("set")) {
                    VideoCollectDetailFragment.this.m20550c(1);
                    i = like_count + 1;
                } else {
                    VideoCollectDetailFragment.this.m20550c(0);
                    i = like_count - 1;
                }
                VideoCollectDetailFragment.this.videoCollectBean.getInfo().setLike_count(i);
                VideoCollectDetailFragment.this.m20555b(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




    @Override
    public void mo20157a(View view) {
        try {
            this.f1095m = getArguments().getInt("VIDEO_COLLECT_ID", -1);
            Log.e("VideoCollectDetail","mo20157a");
            if (this.f1095m != -1) {
                m20554b(view);
                m20560a(this.f1095m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /* renamed from: b */
    public final void m20554b(View view) {
        try {
            this.img_cover = (RoundedImageView) view.findViewById(R.id.img_cover);
            this.tv_collect_title = (TextView) view.findViewById(R.id.tv_collect_title);
            this.img_avatar = (RoundedImageView) view.findViewById(R.id.img_avatar);
            this.tv_name = (TextView) view.findViewById(R.id.tv_name);
            this.f1088f = (CustomTextView) view.findViewById(R.id.tv_num);
            this.f1089g = (TextView) view.findViewById(R.id.tv_intro);
            this.f1090h = (LinearLayout) view.findViewById(R.id.layout_like_collect);
            this.f1090h.setOnClickListener(this);
            this.f1091i = (RecyclerView) view.findViewById(R.id.recyclerView);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            this.f1091i.setLayoutManager(linearLayoutManager);
            this.f1092j = new VideoCollectVideoListAdapter();
            this.f1091i.setAdapter(this.f1092j);
            this.f1092j.setOnItemClickListener(this);
            this.f1093k = (ImageView) view.findViewById(R.id.img_like_tag);
            this.f1094l = (TextView) view.findViewById(R.id.tv_like_hint);
            this.f1096n = (LinearLayout) view.findViewById(R.id.layout_user_info);
            this.f1097o = view.findViewById(R.id.view_loading);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m20560a(int i) {
        this.f1097o.setVisibility(View.VISIBLE);
        HttpUtil.m9671j(i, new C0734a());
    }


    /* renamed from: com.blmvl.blvl.dialog.VideoCollectDetailFragment$a */
    /* loaded from: classes.dex */
    public class C0734a extends HttpCallback {
        public C0734a() {
        }

        @SuppressLint("LongLogTag")
        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onError() {
            super.onError();
            VideoCollectDetailFragment.this.m20547t();
            VideoCollectDetailFragment.this.f1097o.setVisibility(View.GONE);
            Log.e("VideoCollectDetailFragment233::2:","onError");
        }

        @SuppressLint("LongLogTag")
        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onException(int i, String str) {
            super.onException(i, str);
            if (!TextUtils.isEmpty(str)) {
                ToastUtil.m9102c(VideoCollectDetailFragment.this.getContext(), str);
            }
            VideoCollectDetailFragment.this.m20547t();
            VideoCollectDetailFragment.this.f1097o.setVisibility(View.GONE);
            Log.e("VideoCollectDetailFragment233::2:","onException");
        }

        @SuppressLint("LongLogTag")
        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onNetworkError() {
            super.onNetworkError();
            VideoCollectDetailFragment.this.m20547t();
            VideoCollectDetailFragment.this.f1097o.setVisibility(View.GONE);
            Log.e("VideoCollectDetailFragment233::2:","onNetworkError");
        }

        @SuppressLint("LongLogTag")
        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onSuccess(String str, String str2, boolean z, boolean z2) {
            super.onSuccess(str, str2, z, z2);
            try {
                Log.e("VideoCollectDetailFragment233::1:",str);
                Log.e("VideoCollectDetailFragment233::2:",str2);
                VideoCollectDetailFragment.this.f1097o.setVisibility(View.GONE);
                VideoCollectDetailFragment.this.m20556a(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /* renamed from: t */
    public final void m20547t() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            ((DialogFragment) parentFragment).dismiss();
        }
    }

    /* renamed from: a */
    public final void m20556a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.videoCollectBean = (VideoCollectBean) JSON.parseObject(str, VideoCollectBean.class);
                if (this.videoCollectBean != null) {
                    if (this.videoCollectBean.getInfo() != null) {
                        ImgLoader.m9424b(WordUtil.m9084a(this.videoCollectBean.getInfo().getImage_url()), this.img_cover, (int) R.drawable.bg_cover_default_horizontal);
                        this.tv_collect_title.setText(CustomWordUtil.m9462a(this.videoCollectBean.getInfo().getTitle()));
                        ImgLoader.m9426b(getContext(), this.videoCollectBean.getInfo().getUser().getAvatar_url(), this.img_avatar);
                        this.tv_name.setText(this.videoCollectBean.getInfo().getUser().getNickname());
                        m20555b(this.videoCollectBean.getInfo().getLike_count());
                        String format = String.format("合集简介：%s", this.videoCollectBean.getInfo().getDesp());
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(-10066330), 5, format.length(), 33);
                        this.f1089g.setText(spannableStringBuilder);
                        this.f1096n.setOnClickListener(new View$OnClickListenerC0735b());
                    }
                    if (this.videoCollectBean.getList() != null) {
                        this.f1092j.refreshAddItems(this.videoCollectBean.getList());
                    }
                    m20550c(this.videoCollectBean.getInfo().getIs_like());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /* renamed from: b */
    public final void m20555b(int i) {
        this.f1088f.setText(String.format("%s人喜欢ㆍ共%s集", NumberUtil.m9067a(i, 1), String.valueOf(this.videoCollectBean.getInfo().getVideo_count())));
    }
    /* renamed from: c */
    public final void m20550c(int i) {
        if (i == 1) {
            this.f1093k.setImageResource(R.mipmap.ic_collect_liked);
            this.f1094l.setText(getResources().getString(R.string.str_liked));
            return;
        }
        this.f1093k.setImageResource(R.mipmap.ic_collect_like);
        this.f1094l.setText(getResources().getString(R.string.str_like_collect));
    }


    @Override
    public int mo20158r() {
        return R.layout.fragment_video_collect_detail;
    }

    @Override
    public void mo9802a(View view, VideoBean videoBean, int i) {
        try {
            if (ObjUtil.m9224a(videoBean)) {
                JumpUtil.m9417a().m9414a(getContext(), videoBean.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






















    /* renamed from: com.blmvl.blvl.dialog.VideoCollectDetailFragment$b */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0735b implements View.OnClickListener {
        public View$OnClickListenerC0735b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HomePageActivity.m21102a(VideoCollectDetailFragment.this.getContext(), VideoCollectDetailFragment.this.videoCollectBean.getInfo().getUser().getUid());
        }
    }





}