package com.martian.libmars.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.martian.libmars.activity.h1;
import java.io.File;

/* loaded from: classes.dex */
public class n0 {

    /* loaded from: classes2.dex */
    static class a extends CustomTarget<Drawable> {

        /* renamed from: a */
        final /* synthetic */ c f10173a;

        a(final c val$imageListener) {
            this.f10173a = val$imageListener;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: a */
        public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
            c cVar = this.f10173a;
            if (cVar != null) {
                cVar.onSuccess(resource);
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable placeholder) {
            c cVar = this.f10173a;
            if (cVar != null) {
                cVar.onError();
            }
        }
    }

    /* loaded from: classes2.dex */
    static class b implements RequestListener {

        /* renamed from: a */
        final /* synthetic */ c f10174a;

        b(final c val$imageListener) {
            this.f10174a = val$imageListener;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException e2, Object model, Target target, boolean isFirstResource) {
            c cVar = this.f10174a;
            if (cVar == null) {
                return false;
            }
            cVar.onError();
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {
            c cVar = this.f10174a;
            if (cVar == null) {
                return false;
            }
            cVar.onSuccess((Drawable) resource);
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void onError();

        void onSuccess(Drawable resource);
    }

    public static void A(Context context, String url, ImageView imageView, int radius, int pResId, int eResId) {
        if (a(context, imageView)) {
            Glide.with(context).load(url).transform(new RoundedCorners(com.martian.libmars.d.h.b(radius))).placeholder(pResId).error(eResId).into(imageView);
        }
    }

    public static boolean B(Context context) {
        return D(context, true);
    }

    public static boolean C(Context context) {
        return D(context, false);
    }

    public static boolean D(Context context, boolean needAttachToWindow) {
        if (needAttachToWindow && (context instanceof h1)) {
            return ((h1) context).K0();
        }
        if (!(context instanceof Activity)) {
            return context != null;
        }
        Activity activity = (Activity) context;
        return com.martian.libsupport.l.n() ? !activity.isDestroyed() : !activity.isFinishing();
    }

    public static void E(Context context, String url, final c imageListener) {
        if (C(context)) {
            Glide.with(context).load(url).into((RequestBuilder<Drawable>) new a(imageListener));
        }
    }

    public static void F(Context context) {
        if (!C(context) || Glide.with(context).isPaused()) {
            return;
        }
        Glide.with(context).pauseRequests();
    }

    public static void G(Context context) {
        if (C(context) && Glide.with(context).isPaused()) {
            Glide.with(context).resumeRequests();
        }
    }

    private static boolean a(Context context, ImageView imageView) {
        return imageView != null && C(context);
    }

    public static void b(Context context, ImageView imageView) {
        if (a(context, imageView)) {
            Glide.with(context).clear(imageView);
        }
    }

    public static boolean c(Context context) {
        if (context == null) {
            return true;
        }
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        return com.martian.libsupport.l.n() ? activity.isDestroyed() : activity.isFinishing();
    }

    public static void d(Context context, String url, ImageView imageView, int radius) {
        if (a(context, imageView)) {
            Glide.with(context).load(url).transform(new CenterCrop(), new RoundedCorners(com.martian.libmars.d.h.b(radius))).into(imageView);
        }
    }

    public static void e(Context context, String url, ImageView imageView) {
        if (a(context, imageView)) {
            Glide.with(context).load(url).transform(new CircleCrop()).into(imageView);
        }
    }

    public static void f(Context context, String url, ImageView imageView, int pResId, int eResId) {
        if (a(context, imageView)) {
            Glide.with(context).load(url).transform(new CircleCrop()).placeholder(pResId).error(eResId).into(imageView);
        }
    }

    public static void g(Context context, int resId, ImageView imageView) {
        if (a(context, imageView)) {
            Glide.with(context).load(Integer.valueOf(resId)).into(imageView);
        }
    }

    public static void h(Context context, Drawable drawable, ImageView imageView, int radius) {
        if (a(context, imageView)) {
            if (radius > 0) {
                Glide.with(context).load(drawable).transform(new FitCenter(), new RoundedCorners(com.martian.libmars.d.h.b(radius))).into(imageView);
            } else {
                Glide.with(context).load(drawable).into(imageView);
            }
        }
    }

    public static void i(Context context, Uri uri, ImageView imageView) {
        if (a(context, imageView)) {
            Glide.with(context).load(uri).into(imageView);
        }
    }

    public static void j(Context context, File file, ImageView imageView) {
        if (a(context, imageView)) {
            Glide.with(context).load(file).into(imageView);
        }
    }

    public static void k(Context context, String url, ImageView imageView) {
        if (a(context, imageView)) {
            Glide.with(context).load(url).into(imageView);
        }
    }

    public static void l(Context context, String url, ImageView imageView, int pResId) {
        if (a(context, imageView)) {
            Glide.with(context).load(url).placeholder(pResId).into(imageView);
        }
    }

    public static void m(Context context, String url, ImageView imageView, int pResId, int eResId) {
        if (a(context, imageView)) {
            Glide.with(context).load(url).placeholder(pResId).error(eResId).into(imageView);
        }
    }

    public static void n(Context context, String url, ImageView imageView, int pResId, int eResId, boolean canShowImage, int radius) {
        if (canShowImage) {
            A(context, url, imageView, radius, pResId, eResId);
        } else {
            v(context, url, imageView, pResId, eResId, radius);
        }
    }

    public static void o(Context context, String url, ImageView imageView, int pResId, boolean canShowImage) {
        if (canShowImage) {
            l(context, url, imageView, pResId);
        } else {
            t(context, url, imageView, pResId);
        }
    }

    public static void p(Context context, String url, ImageView imageView, int pResId, boolean canShowImage, int radius) {
        if (canShowImage) {
            z(context, url, imageView, radius, pResId);
        } else {
            u(context, url, imageView, pResId, radius);
        }
    }

    public static void q(Context context, String url, ImageView imageView, final c imageListener) {
        if (a(context, imageView)) {
            Glide.with(context).load(url).listener(new b(imageListener)).override(com.martian.libmars.d.h.b(360.0f), com.martian.libmars.d.h.b(640.0f)).into(imageView);
        }
    }

    public static void r(Context context, byte[] bytes, ImageView imageView) {
        if (a(context, imageView)) {
            Glide.with(context).load(bytes).into(imageView);
        }
    }

    public static void s(Context context, String resource, ImageView imageView, int width, int height) {
        if (a(context, imageView)) {
            Glide.with(context).load(resource).override(width, height).into(imageView);
        }
    }

    public static void t(Context context, String url, ImageView imageView, int pResId) {
        if (com.martian.libmars.d.h.F().U0()) {
            l(context, url, imageView, pResId);
        } else if (a(context, imageView)) {
            Glide.with(context).load(url).placeholder(pResId).onlyRetrieveFromCache(true).into(imageView);
        }
    }

    public static void u(Context context, String url, ImageView imageView, int pResId, int radius) {
        if (com.martian.libmars.d.h.F().U0()) {
            z(context, url, imageView, radius, pResId);
        } else if (a(context, imageView)) {
            Glide.with(context).load(url).transform(new CenterCrop(), new RoundedCorners(com.martian.libmars.d.h.b(radius))).placeholder(pResId).onlyRetrieveFromCache(true).into(imageView);
        }
    }

    public static void v(Context context, String url, ImageView imageView, int pResId, int eResId, int radius) {
        if (com.martian.libmars.d.h.F().U0()) {
            A(context, url, imageView, radius, pResId, eResId);
        } else if (a(context, imageView)) {
            Glide.with(context).load(url).transform(new CenterCrop(), new RoundedCorners(com.martian.libmars.d.h.b(radius))).placeholder(pResId).error(eResId).onlyRetrieveFromCache(true).into(imageView);
        }
    }

    public static void w(Context context, int resId, ImageView imageView, int radius) {
        if (a(context, imageView)) {
            Glide.with(context).load(Integer.valueOf(resId)).transform(new RoundedCorners(com.martian.libmars.d.h.b(radius))).into(imageView);
        }
    }

    public static void x(Context context, Uri uri, ImageView imageView, int radius) {
        if (a(context, imageView)) {
            Glide.with(context).load(uri).transform(new RoundedCorners(com.martian.libmars.d.h.b(radius))).into(imageView);
        }
    }

    public static void y(Context context, String url, ImageView imageView, int radius) {
        if (a(context, imageView)) {
            Glide.with(context).load(url).transform(new RoundedCorners(com.martian.libmars.d.h.b(radius))).into(imageView);
        }
    }

    public static void z(Context context, String url, ImageView imageView, int radius, int pResId) {
        if (a(context, imageView)) {
            Glide.with(context).load(url).transform(new CenterCrop(), new RoundedCorners(com.martian.libmars.d.h.b(radius))).placeholder(pResId).into(imageView);
        }
    }
}
