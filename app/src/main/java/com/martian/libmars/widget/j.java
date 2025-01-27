package com.martian.libmars.widget;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.martian.libmars.utils.i0;
import com.martian.libmars.utils.u0;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class j extends AsyncTask<Void, Void, BitmapDrawable> {

    /* renamed from: a */
    private final String f10399a;

    /* renamed from: b */
    private final WeakReference<ImageView> f10400b;

    public j(ImageView imageView, String url) {
        this.f10400b = new WeakReference<>(imageView);
        this.f10399a = url;
    }

    private BitmapDrawable a(byte[] bytes) {
        return b(bytes, this.f10399a, d());
    }

    private static synchronized BitmapDrawable b(byte[] bytes, String url, ImageView imageView) {
        synchronized (j.class) {
            if (imageView == null) {
                return null;
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            int i2 = -1;
            int i3 = layoutParams == null ? -1 : layoutParams.width;
            if (layoutParams != null) {
                i2 = layoutParams.height;
            }
            Bitmap j2 = i0.j(bytes, i3, i2);
            if (j2 == null) {
                return null;
            }
            if (!(imageView instanceof RecylingImageView)) {
                return new BitmapDrawable(imageView.getResources(), j2);
            }
            Drawable drawable = imageView.getDrawable();
            n nVar = new n(imageView.getResources(), j2, drawable instanceof i ? (i) drawable : null);
            ((RecylingImageView) imageView).a(url, nVar);
            return nVar;
        }
    }

    private ImageView d() {
        return this.f10400b.get();
    }

    @Override // android.os.AsyncTask
    /* renamed from: c */
    public BitmapDrawable doInBackground(Void... params) {
        byte[] c2 = u0.c(this.f10399a);
        if (c2 == null) {
            return null;
        }
        ImageView d2 = d();
        if (d2 instanceof RecylingImageView) {
            ((RecylingImageView) d2).n(this.f10399a, c2);
        }
        return a(c2);
    }

    public String e() {
        return this.f10399a;
    }

    @Override // android.os.AsyncTask
    /* renamed from: f */
    public void onPostExecute(BitmapDrawable bd) {
        ImageView d2 = d();
        if (isCancelled() || bd == null || d2 == null) {
            return;
        }
        d2.setImageDrawable(bd);
        if (d2 instanceof RecylingImageView) {
            ((RecylingImageView) d2).m(this.f10399a, bd);
        }
    }
}
