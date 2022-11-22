package com.example.boluouitest2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boluouitest2.EventBus.SearchKeyWordEvent;
import com.example.boluouitest2.R;
import com.example.boluouitest2.fragment.SearchNormalFragment;
import com.example.boluouitest2.fragment.SearchResultFragment;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.util.InputMethodUtil;
import com.example.boluouitest2.util.IntentUtil;
import com.example.boluouitest2.util.SpUtil;
import com.example.boluouitest2.util.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SearchActivity extends AbsActivity {
    /* renamed from: b */
    public TextView btn_back;

    /* renamed from: c */
    public EditText et_key_word;

    @Override
    public void mo20592a(Bundle bundle) {
//        EventBus.m309d().m310c(this);
        //注册
        EventBus.getDefault().register(this);
        m20902N();
        m20899a(SearchNormalFragment.newInstance());
        m20903G();
//        LogUtil.m9410a("BL_SEARCH_PAGE");
    }

    /* renamed from: N */
    public final void m20902N() {
        this.btn_back = (TextView) findViewById(R.id.btn_back);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.container);
        this.btn_back.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.c.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                //取消返回
//                Toast.makeText(SearchActivity.this, "SearchActivity.this.m20898a(view)43", Toast.LENGTH_SHORT).show();
                SearchActivity.this.m20898a(view);
            }
        });
        this.et_key_word = (EditText) findViewById(R.id.et_key_word);
        this.et_key_word.requestFocus();
    }

    /* renamed from: a */
    public final void m20899a(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.container, fragment);
        beginTransaction.commitAllowingStateLoss();
    }

    /* renamed from: G */
    public final void m20903G() {
        this.et_key_word.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: e.c.a.c.x0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return SearchActivity.this.m20897a(textView, i, keyEvent);
            }
        });
        this.et_key_word.addTextChangedListener(new C0666a(this));
    }

    /* renamed from: com.blmvl.blvl.activity.SearchActivity$a */
    /* loaded from: classes.dex */
    public class C0666a implements TextWatcher {
        public C0666a(SearchActivity searchActivity) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            HttpUtil.m9735b("search");
        }
    }

    /* renamed from: a */
    public /* synthetic */ boolean m20897a(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        HttpUtil.m9735b("search");
        m20901Q();
        return true;
    }
    /* renamed from: Q */
    public final void m20901Q() {
        String trim = this.et_key_word.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            ToastUtil.m9102c(this, getString(R.string.key_word_empty_hint));
            return;
        }
        InputMethodUtil.m9082a(this, this.et_key_word);
        m20896h(trim);
    }
    /* renamed from: h */
    public final void m20896h(String str) {
        SpUtil.m9573D().m9536h(str);
        m20899a(SearchResultFragment.m20317a(str));
    }



    @Override
    public int mo20588z() {
        return R.layout.activity_search;
    }





    /* renamed from: a */
    public static void m20900a(Context context) {
        IntentUtil.m9081a(context, SearchActivity.class);
    }







    @Override // com.blmvl.blvl.activity.AbsActivity, android.support.p004v7.app.AppCompatActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        HttpUtil.m9735b("search");
//        EventBus.m309d().m308d(this);
        //取消注册
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSearchKeyWordEvent(SearchKeyWordEvent searchKeyWordEvent) {
        if (searchKeyWordEvent != null) {
            try {
                if (!TextUtils.isEmpty(searchKeyWordEvent.getKeyword())) {
                    String keyword = searchKeyWordEvent.getKeyword();
                    this.et_key_word.setText(keyword);
                    this.et_key_word.setSelection(keyword.length());
                    m20896h(keyword);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m20898a(View view) {
        finish();
    }

}