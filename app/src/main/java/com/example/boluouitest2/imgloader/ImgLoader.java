package com.example.boluouitest2.imgloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.example.boluouitest2.R;


public class ImgLoader {
    /* renamed from: a */
    public static DrawableCrossFadeFactory f13055a = new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();



    /* renamed from: b */
    public static void m9424b(String str, ImageView imageView, int i) {
        Glide.with(imageView.getContext()).load(str).error(i).placeholder(i).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    /* renamed from: a */
    public static void m9428a(String str, ImageView imageView) {
        m9421c(str, imageView, (int) R.drawable.fq_ic_placeholder_avatar);
    }

    /* renamed from: c */
    public static void m9421c(String str, ImageView imageView, int i) {
        Glide.with(imageView.getContext()).load(str).error(i).placeholder(i).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }





















    /* renamed from: b */
    public static void m9425b(Context context, String str, ImageView imageView, int i) {
        Glide.with(context).load(str).error(i).placeholder(i).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }
    /* renamed from: b */
    public static void m9426b(Context context, String str, ImageView imageView) {
        m9422c(context, str, imageView, R.drawable.fq_ic_placeholder_avatar);
    }
    /* renamed from: c */
    public static void m9422c(Context context, String str, ImageView imageView, int i) {
        if (context != null) {
            try {
                Glide.with(context).load(str).error(i).placeholder(i).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




    /* renamed from: c */
    public static void m15404c(Context context, String str, ImageView imageView) {
        Glide.with(context).load(str).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    /* renamed from: a */
    public static void m9430a(Context context, String str, ImageView imageView, int i) {
        Glide.with(context).load(str).error(i).placeholder(i).transition((TransitionOptions<?, ? super Drawable>) DrawableTransitionOptions.withCrossFade(f13055a)).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    /* renamed from: c */
    public static void m9423c(Context context, String str, ImageView imageView) {
        Glide.with(context).load(str).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }


}
