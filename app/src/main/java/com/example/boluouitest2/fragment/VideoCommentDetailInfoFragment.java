package com.example.boluouitest2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.transition.Transition;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.boluouitest2.R;





import android.app.Dialog;
import android.content.Context;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.VHDelegate.VideoCommentVHDelegate;
import com.example.boluouitest2.ViewHelper.RecyclerViewHelper;
import com.example.boluouitest2.bean.AppUser;
import com.example.boluouitest2.bean.UserBean;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.bean.VideoCommentBean;
import com.example.boluouitest2.comod.baselib.fragment.AbsLazyFragment;
import com.example.boluouitest2.httpUtil.HttpCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.util.ApiUrlUtil;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.DialogUtil;
import com.example.boluouitest2.util.ObjUtil;
import com.example.boluouitest2.util.ToastUtil;
import com.lzy.okgo.model.HttpParams;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 评论
 */
/* loaded from: classes.dex */
public class VideoCommentDetailInfoFragment extends AbsLazyFragment {

    /* renamed from: e */
    public RecyclerViewHelper f1362e;

    /* renamed from: f */
    public VideoBean f1363f;

    /* renamed from: g */
    public View f1364g;

    /* renamed from: h */
    public LinearLayout f1365h;

    /* renamed from: i */
    public TextView f1366i;

    /* renamed from: com.blmvl.blvl.fragment.VideoCommentDetailInfoFragment$c */
    /* loaded from: classes.dex */
//    public class C0782c implements DialogUtil.AbstractC4243c {
//        public C0782c() {
//        }
//
//        @Override // p067e.p103c.p104a.p113k.DialogUtil.AbstractC4243c
//        /* renamed from: a */
//        public void mo9438a() {
//        }
//
//        @Override // p067e.p103c.p104a.p113k.DialogUtil.AbstractC4244d
//        /* renamed from: a */
//        public void mo9437a(Dialog dialog, String str) {
//            try {
//                BuyMemberActivity.m21257a(VideoCommentDetailInfoFragment.this.getContext());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override // p067e.p103c.p104a.p113k.DialogUtil.AbstractC4242b
//        /* renamed from: b */
//        public void mo9439b() {
//        }
//    }

    /* renamed from: com.blmvl.blvl.fragment.VideoCommentDetailInfoFragment$d */
    /* loaded from: classes.dex */
    public class C0783d extends HttpCallback {
        public C0783d() {
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onException(int i, String str) {
            super.onException(i, str);
            if (!TextUtils.isEmpty(str)) {
                ToastUtil.m9102c(VideoCommentDetailInfoFragment.this.getContext(), str);
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onSuccess(String str, String str2, boolean z, boolean z2) {
            super.onSuccess(str, str2, z, z2);
            try {
                ToastUtil.m9102c(VideoCommentDetailInfoFragment.this.getContext(), VideoCommentDetailInfoFragment.this.getString(R.string.comment_success));
                if (ObjUtil.m9224a(VideoCommentDetailInfoFragment.this.f1362e)) {
                    VideoCommentDetailInfoFragment.this.f1362e.m9390E();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.comod.baselib.fragment.AbsLazyFragment
    public void initView(View view) {
        this.f1364g = view;
        m20283b(view);
    }

    @Override // com.comod.baselib.fragment.AbsLazyFragment
    public void onLazyLoad() {
    }

    @Override // com.comod.baselib.fragment.AbsFragment
    /* renamed from: r */
    public int mo20158r() {
        return R.layout.layout_video_comment_detail_info;
    }

    /* renamed from: v */
    public final void m20278v() {
        Toast.makeText(getContext(), "VideoCommentDetailInfoFragment::143", Toast.LENGTH_SHORT).show();
//        DialogUtil.m9453a(getContext(), CustomWordUtil.m9463a((int) R.string.str_tips), CustomWordUtil.m9463a((int) R.string.become_member_to_comment_hint), CustomWordUtil.m9463a((int) R.string.no_need), CustomWordUtil.m9463a((int) R.string.str_become_vip), false, false, new C0782c());
    }

    /* renamed from: com.blmvl.blvl.fragment.VideoCommentDetailInfoFragment$a */
    /* loaded from: classes.dex */
    public class C0780a extends RecyclerViewHelper<VideoCommentBean> {
        public C0780a(Context context, View view) {
            super(context, view);
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: a */
        public List<VideoCommentBean> mo9379a(String str) {
            ArrayList arrayList = new ArrayList();
            try {
                return !TextUtils.isEmpty(str) ? JSON.parseArray(str, VideoCommentBean.class) : arrayList;
            } catch (Exception e) {
                e.printStackTrace();
                return arrayList;
            }
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: b */
        public VHDelegateImpl<VideoCommentBean> mo9376b(int i) {
            VideoCommentVHDelegate i2Var = new VideoCommentVHDelegate(new VideoCommentVHDelegate.AbstractC4095c() { // from class: e.c.a.g.s0
                @Override // p067e.p103c.p104a.p107e.VideoCommentVHDelegate.AbstractC4095c
                /* renamed from: a */
                public final void mo9805a() {
                    VideoCommentDetailInfoFragment.C0780a.this.m9390E();
                }
            });
            i2Var.m10114a(VideoCommentDetailInfoFragment.this.f1363f);
            return i2Var;
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: p */
        public String mo9357p() {
            return "getVideoCommentList";
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: s */
        public boolean mo9354s() {
            return true;
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: b */
        public String mo9377b() {
            return ApiUrlUtil.m9219a("/api/comments/list");
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: a */
        public void mo9381a(HttpParams httpParams) {
            super.mo9381a(httpParams);
            if (ObjUtil.m9224a(VideoCommentDetailInfoFragment.this.f1363f)) {
                httpParams.put("id", VideoCommentDetailInfoFragment.this.f1363f.getId(), new boolean[0]);
            }
        }
    }

    /* renamed from: b */
    public final void m20283b(View view) {
        this.f1365h = (LinearLayout) view.findViewById(R.id.layout_comment);
        this.f1365h.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.g.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoCommentDetailInfoFragment.this.m20281c(view2);
            }
        });
        this.f1366i = (TextView) view.findViewById(R.id.tv_comment_hint);
        UserBean user = AppUser.getInstance().getUser();
        if (user == null || !user.isRealVip()) {
            this.f1366i.setText(getString(R.string.str_not_vip_comment_hint));
        } else {
            this.f1366i.setText(getString(R.string.str_vip_comment_hint));
        }
    }

    /* renamed from: c */
    public /* synthetic */ void m20281c(View view) {
        m20284a(false, "");
    }

    /* renamed from: a */
    public void m20287a(VideoBean videoBean) {
        this.f1363f = videoBean;
        this.f1362e = new C0780a(getContext(), this.f1364g);
        this.f1362e.m9390E();
    }

    /* renamed from: a */
    public void m20284a(boolean z, String str) {
        try {
//            new CommentEditTextDialog((Context) Objects.requireNonNull(getContext()), z, str, new C0781b()).show(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportFragmentManager(), "dialog");
            Toast.makeText(getContext(), "VideoCommentDetailInfoFragment::new CommentEditTextDialog((Context)241", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: com.blmvl.blvl.fragment.VideoCommentDetailInfoFragment$b */
    /* loaded from: classes.dex */
//    public class C0781b implements CommentEditTextDialog.AbstractC0731b {
//        public C0781b() {
//        }
//
//        @Override // com.blmvl.blvl.dialog.CommentEditTextDialog.AbstractC0731b
//        /* renamed from: a */
//        public void mo10105a(String str) {
//            try {
//                if (!TextUtils.isEmpty(str)) {
//                    UserBean user = AppUser.getInstance().getUser();
//                    if (user == null || !user.isRealVip()) {
//                        VideoCommentDetailInfoFragment.this.m20278v();
//                        C4757b.m4784a(VideoCommentDetailInfoFragment.this.f1364g);
//                    } else {
//                        VideoCommentDetailInfoFragment.this.m20288a(VideoCommentDetailInfoFragment.this.f1363f.getId(), str, 0);
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override // com.blmvl.blvl.dialog.CommentEditTextDialog.AbstractC0731b
//        /* renamed from: a */
//        public void mo10106a(SaoTalkOptionBean saoTalkOptionBean) {
//            try {
//                VideoCommentDetailInfoFragment.this.m20288a(VideoCommentDetailInfoFragment.this.f1363f.getId(), saoTalkOptionBean.getTips(), saoTalkOptionBean.getId());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

    /* renamed from: a */
    public final void m20288a(int i, String str, int i2) {
        HttpUtil.m9777a(i, str, i2, new C0783d());
    }


}