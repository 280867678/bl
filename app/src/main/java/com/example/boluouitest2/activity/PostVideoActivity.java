package com.example.boluouitest2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.example.boluouitest2.R;

import java.util.List;

public class PostVideoActivity extends AbsActivity implements View.OnClickListener  {

    /* renamed from: a */
    public static void m20990a(Context context) {
        context.startActivity(new Intent(context, PostVideoActivity.class));
    }


    @Override
    public void onClick(View view) {
//        if (view.getId() == R.id.layout_upload_video) {
//            m20996N();
//        } else if (view.getId() == R.id.layout_add_cover) {
//            m20997G();
//        } else if (view.getId() == R.id.btn_post_video) {
//            m20992V();
//        } else if (view.getId() == R.id.layout_tag) {
//            try {
//                if (this.f667y != null && this.f667y.getTags() != null && !this.f667y.getTags().isEmpty()) {
//                    SelectTagsDialog k0Var = new SelectTagsDialog(this, this.f667y.getTags());
//                    k0Var.setConfirmListener(new SelectTagsDialog.AbstractC4140b() { // from class: e.c.a.c.m0
//                        @Override // p067e.p103c.p104a.p108f.SelectTagsDialog.AbstractC4140b
//                        /* renamed from: a */
//                        public final void mo9903a(List list, String str) {
//                            PostVideoActivity.this.m20984b(list, str);
//                        }
//                    });
//                    DialogUtil.m9457a(this, k0Var);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if (view.getId() == R.id.tv_upload_rule) {
//            try {
//                if (this.f667y != null && !TextUtils.isEmpty(this.f667y.getRule_text())) {
//                    PlainTextActivity.m20998a(this, this.f667y.getRule_text(), getString(R.string.str_upload_rule));
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        } else if (view.getId() == R.id.layout_video && !TextUtils.isEmpty(this.f661s)) {
//            VideoSimplePlayActivity.m20653a(this, this.f661s);
//        }
    }

    @Override
    public void mo20592a(Bundle bundle) {
//        try {
//            m21291d(getString(R.string.str_post_video));
//            EventBus.m309d().m310c(this);
//            this.f664v = new UploadVideoBean();
//            m20994R();
//            m20983b0();
//            m20980c0();
//            this.f659q = new ProcessResultUtil(this);
//            LogUtil.m9410a("BL_POST_VIDEO_PAGE");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public int mo20588z() {
        return R.layout.activity_post_video;
    }
}