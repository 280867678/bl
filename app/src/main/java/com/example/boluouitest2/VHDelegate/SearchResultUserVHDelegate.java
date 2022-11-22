package com.example.boluouitest2.VHDelegate;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.boluouitest2.R;
import com.example.boluouitest2.activity.HomePageActivity;
import com.example.boluouitest2.bean.AppUser;
import com.example.boluouitest2.bean.UserBean;
import com.example.boluouitest2.httpUtil.CommonCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.NumberUtil;
import com.example.boluouitest2.util.SpecialTxtColorUtil;
import com.makeramen.roundedimageview.RoundedImageView;


/**
 * 搜索用户视图
 */
public class SearchResultUserVHDelegate extends VHDelegateImpl<UserBean> implements View.OnClickListener{


    /* renamed from: g */
    public RoundedImageView f12587g;

    /* renamed from: h */
    public TextView f12588h;

    /* renamed from: i */
    public TextView f12589i;

    /* renamed from: j */
    public ImageView f12590j;

    /* renamed from: k */
    public TextView f12591k;

    /* renamed from: l */
    public TextView f12592l;

    /* renamed from: m */
    public String f12593m;

    /* renamed from: n */
    public View f12594n;

    public SearchResultUserVHDelegate(String str) {
        this.f12593m = str;
    }

    /* renamed from: b */
    public final void m10027b(View view) {
        this.f12587g = (RoundedImageView) view.findViewById(R.id.img_avatar);
        this.f12588h = (TextView) view.findViewById(R.id.tv_name);
        this.f12589i = (TextView) view.findViewById(R.id.tv_sign);
        this.f12590j = (ImageView) view.findViewById(R.id.img_arrow);
        this.f12590j.setVisibility(View.GONE);
        this.f12591k = (TextView) view.findViewById(R.id.tv_fans_num);
        this.f12592l = (TextView) view.findViewById(R.id.tv_work_num);
        this.f12594n = view.findViewById(R.id.btn_follow);
        this.f12594n.setOnClickListener(this);
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_search_user;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HttpUtil.m9783a(m9230c().getUid(), (CommonCallback<Integer>) null);
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        m10027b(view);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(UserBean userBean, int i) {
        super.mo9233a( userBean, i);
        if (userBean != null) {
            try {
                ImgLoader.m9426b(m9232b(), CustomWordUtil.m9462a(userBean.getAvatar_url()), this.f12587g);
                if (!TextUtils.isEmpty(userBean.getNickname())) {
                    String nickname = userBean.getNickname();
                    this.f12588h.setText(nickname);
                    if (!TextUtils.isEmpty(this.f12593m)) {
                        this.f12588h.setText(SpecialTxtColorUtil.m9513a(-206539, nickname, this.f12593m));
                    }
                }
                this.f12589i.setText(CustomWordUtil.m9461b(userBean.getPerson_signnatrue()));
                this.f12591k.setText(String.format("粉絲：%s", NumberUtil.m9067a(userBean.getFans_count(), 2)));
                this.f12592l.setText(String.format("作品：%s", NumberUtil.m9067a(userBean.getVideos_count(), 2)));
                if (userBean.getUid() == AppUser.getInstance().getUser().getUid()) {
                    this.f12590j.setVisibility(View.VISIBLE);
                    this.f12594n.setVisibility(View.GONE);
                } else if (userBean.getIs_attention() == 1) {
                    this.f12590j.setVisibility(View.VISIBLE);
                    this.f12594n.setVisibility(View.GONE);
                } else {
                    this.f12590j.setVisibility(View.GONE);
                    this.f12594n.setVisibility(View.VISIBLE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9235a(View view, UserBean userBean, int i) {
        super.mo9235a(view, userBean, i);
        if (userBean != null) {
            try {
                HomePageActivity.m21102a(m9232b(), userBean.getUid());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
