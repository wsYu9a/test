package com.martian.libmars.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.martian.libmars.utils.o0;

/* loaded from: classes2.dex */
public class RecylingImageView extends AppCompatImageView {

    /* renamed from: a */
    private b f10362a;

    /* renamed from: b */
    private a f10363b;

    /* renamed from: c */
    private o0 f10364c;

    public interface a {
        void a(String url, BitmapDrawable bd);
    }

    public interface b {
        void a(String url, byte[] bytes);
    }

    public RecylingImageView(Context context) {
        super(context);
        this.f10362a = null;
        this.f10363b = null;
        this.f10364c = null;
    }

    /* renamed from: e */
    public /* synthetic */ void f(final int defaultResId, final String url) {
        i(d(defaultResId).getBitmap(), url);
    }

    private String getBitmapDownloadederUrl() {
        Drawable drawable = getDrawable();
        if (drawable instanceof i) {
            return ((i) drawable).b();
        }
        return null;
    }

    private j getBitmapDownloaderTask() {
        Drawable drawable = getDrawable();
        if (drawable instanceof i) {
            return ((i) drawable).a();
        }
        return null;
    }

    private void i(Bitmap defaultBitmap, String url) {
        if (b(url)) {
            BitmapDrawable c2 = c(url);
            if (c2 != null) {
                setImageDrawable(c2);
                m(url, c2);
            } else {
                j jVar = new j(this, url);
                setImageDrawable(new i(getResources(), defaultBitmap, jVar));
                jVar.execute(new Void[0]);
            }
        }
    }

    private static void l(Drawable drawable, final boolean isDisplayed) {
        if (drawable instanceof n) {
            ((n) drawable).f(isDisplayed);
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                l(layerDrawable.getDrawable(i2), isDisplayed);
            }
        }
    }

    public void a(String url, BitmapDrawable bitmap) {
        o0 o0Var = this.f10364c;
        if (o0Var != null) {
            o0Var.d(url, bitmap);
        }
    }

    public boolean b(String url) {
        j bitmapDownloaderTask = getBitmapDownloaderTask();
        if (url.equals(getBitmapDownloadederUrl())) {
            return false;
        }
        if (bitmapDownloaderTask != null) {
            bitmapDownloaderTask.cancel(true);
        }
        return true;
    }

    public BitmapDrawable c(String url) {
        o0 o0Var = this.f10364c;
        if (o0Var != null) {
            return o0Var.b(url);
        }
        return null;
    }

    public BitmapDrawable d(int defaultResId) {
        Drawable drawable = getResources().getDrawable(defaultResId);
        return drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : new BitmapDrawable(getResources(), (Bitmap) null);
    }

    public void g(final int defaultResId, final String url) {
        i(d(defaultResId).getBitmap(), url);
    }

    public void h(final int defaultResId, final String url, o0 imageCache) {
        setImageCache(imageCache);
        g(defaultResId, url);
    }

    public void j(final int defaultResId, final String url) {
        post(new Runnable() { // from class: com.martian.libmars.widget.g
            @Override // java.lang.Runnable
            public final void run() {
                RecylingImageView.this.f(defaultResId, url);
            }
        });
    }

    public void k(final int defaultResId, final String url, o0 imageCache) {
        setImageCache(imageCache);
        j(defaultResId, url);
    }

    public void m(String url, BitmapDrawable bd) {
        a aVar = this.f10363b;
        if (aVar != null) {
            aVar.a(url, bd);
        }
    }

    public void n(String url, byte[] bytes) {
        b bVar = this.f10362a;
        if (bVar != null) {
            bVar.a(url, bytes);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        setImageDrawable(null);
        super.onDetachedFromWindow();
    }

    public void setImageCache(o0 imageCache) {
        this.f10364c = imageCache;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        if (drawable2 == drawable) {
            return;
        }
        super.setImageDrawable(drawable);
        l(drawable, true);
        l(drawable2, false);
    }

    public void setOnBitmapLoadedListener(a onBitmapLoadedListener) {
        this.f10363b = onBitmapLoadedListener;
    }

    public void setOnByteArrayDownloadedListner(b ll) {
        this.f10362a = ll;
    }

    public RecylingImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f10362a = null;
        this.f10363b = null;
        this.f10364c = null;
    }

    public RecylingImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f10362a = null;
        this.f10363b = null;
        this.f10364c = null;
    }
}
