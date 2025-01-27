package n9;

import android.content.res.Resources;
import android.graphics.Bitmap;

/* loaded from: classes3.dex */
public class o extends a {

    /* renamed from: c */
    public int f28825c;

    /* renamed from: d */
    public int f28826d;

    /* renamed from: e */
    public boolean f28827e;

    public o(Resources resources, Bitmap bitmap, b bVar) {
        super(resources, bitmap, bVar);
        this.f28825c = 0;
        this.f28826d = 0;
    }

    public final synchronized void c() {
        if (this.f28825c <= 0 && this.f28826d <= 0 && this.f28827e && d()) {
            getBitmap().recycle();
        }
    }

    public final synchronized boolean d() {
        boolean z10;
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            z10 = bitmap.isRecycled() ? false : true;
        }
        return z10;
    }

    public void e(boolean z10) {
        synchronized (this) {
            try {
                if (z10) {
                    this.f28825c++;
                } else {
                    this.f28825c--;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        c();
    }

    public void f(boolean z10) {
        synchronized (this) {
            try {
                if (z10) {
                    this.f28826d++;
                    this.f28827e = true;
                } else {
                    this.f28826d--;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        c();
    }

    public o(Resources resources, Bitmap bitmap, a aVar) {
        super(resources, bitmap, aVar == null ? null : aVar.a());
        this.f28825c = 0;
        this.f28826d = 0;
    }
}
