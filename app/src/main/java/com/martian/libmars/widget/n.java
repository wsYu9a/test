package com.martian.libmars.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;

/* loaded from: classes2.dex */
public class n extends i {

    /* renamed from: c */
    public int f10412c;

    /* renamed from: d */
    public int f10413d;

    /* renamed from: e */
    private boolean f10414e;

    n(Resources res, Bitmap bm, j task) {
        super(res, bm, task);
        this.f10412c = 0;
        this.f10413d = 0;
    }

    private synchronized void c() {
        if (this.f10412c <= 0 && this.f10413d <= 0 && this.f10414e && d()) {
            getBitmap().recycle();
        }
    }

    private synchronized boolean d() {
        boolean z;
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            z = bitmap.isRecycled() ? false : true;
        }
        return z;
    }

    public void e(boolean isCached) {
        synchronized (this) {
            if (isCached) {
                this.f10412c++;
            } else {
                this.f10412c--;
            }
        }
        c();
    }

    public void f(boolean isDisplayed) {
        synchronized (this) {
            if (isDisplayed) {
                this.f10413d++;
                this.f10414e = true;
            } else {
                this.f10413d--;
            }
        }
        c();
    }

    n(Resources res, Bitmap bm, i drawable) {
        super(res, bm, drawable == null ? null : drawable.a());
        this.f10412c = 0;
        this.f10413d = 0;
    }
}
