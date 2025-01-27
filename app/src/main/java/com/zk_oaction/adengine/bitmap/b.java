package com.zk_oaction.adengine.bitmap;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes5.dex */
class b {

    /* renamed from: a */
    String f34714a;

    /* renamed from: b */
    float f34715b;

    /* renamed from: e */
    private Bitmap f34718e;

    /* renamed from: c */
    private int f34716c = -1;

    /* renamed from: d */
    private int f34717d = -1;

    /* renamed from: f */
    private HashSet<WeakReference<h>> f34719f = new HashSet<>();

    b(String str, float f2) {
        this.f34714a = str;
        this.f34715b = f2;
    }

    public int a() {
        int size;
        synchronized (this.f34719f) {
            HashSet hashSet = new HashSet();
            Iterator<WeakReference<h>> it = this.f34719f.iterator();
            while (it.hasNext()) {
                WeakReference<h> next = it.next();
                if (next.get() != null) {
                    hashSet.add(next);
                }
            }
            this.f34719f.clear();
            this.f34719f.addAll(hashSet);
            size = this.f34719f.size();
        }
        return size;
    }

    public void b(int i2, int i3) {
        synchronized (this) {
            this.f34716c = i2;
            this.f34717d = i3;
        }
    }

    public void c(Bitmap bitmap) {
        synchronized (this) {
            this.f34718e = bitmap;
            if (bitmap != null) {
                this.f34716c = bitmap.getWidth();
                this.f34717d = bitmap.getHeight();
            }
        }
    }

    public void d(h hVar) {
        synchronized (this.f34719f) {
            Iterator<WeakReference<h>> it = this.f34719f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    this.f34719f.add(new WeakReference<>(hVar));
                    break;
                } else if (it.next().get() == hVar) {
                    break;
                }
            }
        }
    }

    public void e(boolean z) {
        synchronized (this.f34719f) {
            Iterator<WeakReference<h>> it = this.f34719f.iterator();
            while (it.hasNext()) {
                h hVar = it.next().get();
                if (hVar != null) {
                    hVar.b(this.f34714a, this.f34715b, z);
                }
            }
        }
    }

    public void f() {
        synchronized (this) {
            Bitmap bitmap = this.f34718e;
            if (bitmap != null) {
                bitmap.recycle();
                this.f34718e = null;
            }
        }
    }

    public int g() {
        int i2;
        synchronized (this) {
            i2 = this.f34716c;
        }
        return i2;
    }

    public int h() {
        int i2;
        synchronized (this) {
            i2 = this.f34717d;
        }
        return i2;
    }

    public Bitmap i() {
        Bitmap bitmap;
        synchronized (this) {
            bitmap = this.f34718e;
        }
        return bitmap;
    }

    public boolean j() {
        boolean z;
        synchronized (this) {
            if (this.f34716c != -1) {
                z = this.f34717d != -1;
            }
        }
        return z;
    }
}
