package com.example.boluouitest2.slzhibo.library.CustomDialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;

import com.example.boluouitest2.R;
import com.example.boluouitest2.util.DialogUtil;

public class CustomDialogUtil {

    /* compiled from: CustomDialogUtil.java */
    /* renamed from: e.c.a.k.j$a */
    /* loaded from: classes.dex */
    public static class C4239a implements DialogUtil.AbstractC4242b {

        /* renamed from: a */
        public final /* synthetic */ Context f13020a;

        public C4239a(Context context) {
            this.f13020a = context;
        }

        @Override // p067e.p103c.p104a.p113k.DialogUtil.AbstractC4244d
        /* renamed from: a */
        public void mo9437a(Dialog dialog, String str) {
//            BuyMemberActivity.m21257a(this.f13020a);
            Toast.makeText(dialog.getContext(), "CustomDialogUtil::28::BuyMemberActivity.m21257a(this.f13020a)", Toast.LENGTH_SHORT).show();
        }

        @Override // p067e.p103c.p104a.p113k.DialogUtil.AbstractC4242b
        /* renamed from: b */
        public void mo9439b() {
        }
    }

    /* renamed from: a */
    public static void m9483a(Context context) {
            Toast.makeText(context.getApplicationContext(), "CustomDialogUtil:39:直播功能僅對付費會員開放，開通VIP後即可無限觀看美女大秀噢～",Toast.LENGTH_LONG).show();
//        DialogUtil.m9454a(context, context.getResources().getString(R.string.str_watch_live_tips), context.getResources().getString(R.string.str_wander), context.getResources().getString(R.string.str_buy_vip_now), new C4239a(context));
    }


}
