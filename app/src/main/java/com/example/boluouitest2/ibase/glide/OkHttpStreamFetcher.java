package com.example.boluouitest2.ibase.glide;

import android.util.Log;

import androidx.annotation.NonNull;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.Preconditions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpStreamFetcher implements DataFetcher<InputStream>, Callback {

    public static final String TAG = "OkHttpFetcher";
    public volatile Call call;
    public DataFetcher.DataCallback<? super InputStream> callback;
    public final Call.Factory client;
    public ResponseBody responseBody;
    public InputStream stream;
    public final GlideUrl url;

    public OkHttpStreamFetcher(Call.Factory factory, GlideUrl glideUrl) {
        this.client = factory;
        this.url = glideUrl;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        try {
            if (this.stream != null) {
                this.stream.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody = this.responseBody;
        if (responseBody != null) {
            responseBody.close();
        }
        this.callback = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        Request.Builder url = new Request.Builder().url(this.url.toStringUrl());
        for (Map.Entry<String, String> entry : this.url.getHeaders().entrySet()) {
            url.addHeader(entry.getKey(), entry.getValue());
        }
        Request build = url.build();
        this.callback = dataCallback;
        this.call = this.client.newCall(build);
        this.call.enqueue(this);
    }

    @Override // okhttp3.Callback
    public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "OkHttp failed to obtain result", iOException);
        }
        this.callback.onLoadFailed(iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(@NonNull Call call, @NonNull Response response) {
        this.responseBody = response.body();
        if (response.isSuccessful()) {
            this.stream = ContentLengthInputStream.obtain(this.responseBody.byteStream(), ((ResponseBody) Preconditions.checkNotNull(this.responseBody)).contentLength());
            this.callback.onDataReady(this.stream);
            return;
        }
        this.callback.onLoadFailed(new HttpException(response.message(), response.code()));
    }

}
