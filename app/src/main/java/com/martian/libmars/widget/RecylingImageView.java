package com.martian.libmars.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.martian.libmars.widget.RecylingImageView;
import l9.n0;
import n9.o;

/* loaded from: classes3.dex */
public class RecylingImageView extends AppCompatImageView {

    /* renamed from: b */
    public b f12672b;

    /* renamed from: c */
    public a f12673c;

    /* renamed from: d */
    public n0 f12674d;

    public interface a {
        void a(String str, BitmapDrawable bitmapDrawable);
    }

    public interface b {
        void a(String str, byte[] bArr);
    }

    public RecylingImageView(Context context) {
        super(context);
        this.f12672b = null;
        this.f12673c = null;
        this.f12674d = null;
    }

    private String getBitmapDownloadederUrl() {
        Drawable drawable = getDrawable();
        if (drawable instanceof n9.a) {
            return ((n9.a) drawable).b();
        }
        return null;
    }

    private n9.b getBitmapDownloaderTask() {
        Drawable drawable = getDrawable();
        if (drawable instanceof n9.a) {
            return ((n9.a) drawable).a();
        }
        return null;
    }

    public static void l(Drawable drawable, boolean z10) {
        if (drawable instanceof o) {
            ((o) drawable).f(z10);
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i10 = 0; i10 < numberOfLayers; i10++) {
                l(layerDrawable.getDrawable(i10), z10);
            }
        }
    }

    public void b(String str, BitmapDrawable bitmapDrawable) {
        n0 n0Var = this.f12674d;
        if (n0Var != null) {
            n0Var.d(str, bitmapDrawable);
        }
    }

    public boolean c(String str) {
        n9.b bitmapDownloaderTask = getBitmapDownloaderTask();
        if (str.equals(getBitmapDownloadederUrl())) {
            return false;
        }
        if (bitmapDownloaderTask != null) {
            bitmapDownloaderTask.cancel(true);
        }
        return true;
    }

    public BitmapDrawable d(String str) {
        n0 n0Var = this.f12674d;
        if (n0Var != null) {
            return n0Var.b(str);
        }
        return null;
    }

    public BitmapDrawable e(int i10) {
        Drawable drawable = getResources().getDrawable(i10);
        return drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : new BitmapDrawable(getResources(), (Bitmap) null);
    }

    public final /* synthetic */ void f(int i10, String str) {
        i(e(i10).getBitmap(), str);
    }

    public void g(int i10, String str) {
        i(e(i10).getBitmap(), str);
    }

    public void h(int i10, String str, n0 n0Var) {
        setImageCache(n0Var);
        g(i10, str);
    }

    public final void i(Bitmap bitmap, String str) {
        if (c(str)) {
            BitmapDrawable d10 = d(str);
            if (d10 != null) {
                setImageDrawable(d10);
                m(str, d10);
            } else {
                n9.b bVar = new n9.b(this, str);
                setImageDrawable(new n9.a(getResources(), bitmap, bVar));
                bVar.execute(new Void[0]);
            }
        }
    }

    public void j(int i10, String str) {
        post(new Runnable() { // from class: n9.p

            /* renamed from: c */
            public final /* synthetic */ int f28829c;

            /* renamed from: d */
            public final /* synthetic */ String f28830d;

            public /* synthetic */ p(int i102, String str2) {
                i10 = i102;
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                RecylingImageView.this.f(i10, str);
            }
        });
    }

    public void k(int i10, String str, n0 n0Var) {
        setImageCache(n0Var);
        j(i10, str);
    }

    public void m(String str, BitmapDrawable bitmapDrawable) {
        a aVar = this.f12673c;
        if (aVar != null) {
            aVar.a(str, bitmapDrawable);
        }
    }

    public void n(String str, byte[] bArr) {
        b bVar = this.f12672b;
        if (bVar != null) {
            bVar.a(str, bArr);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        setImageDrawable(null);
        super.onDetachedFromWindow();
    }

    public void setImageCache(n0 n0Var) {
        this.f12674d = n0Var;
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

    public void setOnBitmapLoadedListener(a aVar) {
        this.f12673c = aVar;
    }

    public void setOnByteArrayDownloadedListner(b bVar) {
        this.f12672b = bVar;
    }

    public RecylingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12672b = null;
        this.f12673c = null;
        this.f12674d = null;
    }

    public RecylingImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12672b = null;
        this.f12673c = null;
        this.f12674d = null;
    }
}
