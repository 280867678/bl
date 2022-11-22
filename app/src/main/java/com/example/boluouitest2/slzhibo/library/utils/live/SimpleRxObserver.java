package com.example.boluouitest2.slzhibo.library.utils.live;



import android.content.Context;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;


/* loaded from: classes2.dex */
public abstract class SimpleRxObserver<T> implements Observer<T> {
    public WeakReference<Context> context;
    public boolean isToastErrorMsg;

    public SimpleRxObserver() {
        this.isToastErrorMsg = true;
    }

    public abstract void accept(T t);

    @Override // p481f.p482a.Observer
    public void onComplete() {
    }

    public void onError(int i, String str) {
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override // p481f.p482a.Observer
    public void onError(Throwable th) {
        Context context;
        th.printStackTrace();
        if (th instanceof ApiException) {
            ApiException apiException = (ApiException) th;
            int code = apiException.getCode();
            onError(code, apiException.getMsg());
            if (AppUtils.isTokenInvalidErrorCode(code)) {
                WeakReference<Context> weakReference = this.context;
                if (weakReference != null && weakReference.get() != null && (context = this.context.get()) != null && (context instanceof FragmentActivity)) {
                    AppUtils.handlerTokenInvalid(context);
                }
            } else if (this.isToastErrorMsg && AppUtils.isToastAPIRequestErrorMsg(code, apiException.getMsg())) {
//                ToastUtils.m10208a(apiException.getMsg());
//                Toast.makeText(context.getApplicationContext(), "", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override // p481f.p482a.Observer
    public void onNext(T t) {
        accept(t);
    }

    @Override // p481f.p482a.Observer
    public void onSubscribe(Disposable bVar) {
    }

    public SimpleRxObserver(Context context) {
        this(context, true);
    }

    public SimpleRxObserver(Context context, boolean z) {
        this.isToastErrorMsg = true;
        this.context = new WeakReference<>(context);
        this.isToastErrorMsg = z;
    }

    public SimpleRxObserver(boolean z) {
        this.isToastErrorMsg = true;
        this.isToastErrorMsg = z;
    }
}

