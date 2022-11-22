package com.example.boluouitest2.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.boluouitest2.R;

public class C4326m {

    /* renamed from: a */
    public static Dialog m9109a(Context context) {
        return m9107a(context, "");
    }

    /* renamed from: a */
    public static Dialog m9107a(Context context, String str) {
        TextView textView;
        Dialog dialog = new Dialog(context, R.style.dialog_style);
        dialog.setContentView(R.layout.dialog_loading);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        if (!TextUtils.isEmpty(str) && (textView = (TextView) dialog.findViewById(R.id.text)) != null) {
            textView.setText(str);
        }
        return dialog;
    }

    /* renamed from: a */
    public static void m9108a(Context context, Dialog dialog) {
        if (dialog != null && !dialog.isShowing() && !((Activity) context).isFinishing()) {
            dialog.show();
        }
    }

    /* renamed from: a */
    public static void m9110a(Dialog dialog) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }


}
