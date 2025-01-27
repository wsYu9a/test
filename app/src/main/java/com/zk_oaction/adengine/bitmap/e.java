package com.zk_oaction.adengine.bitmap;

import android.graphics.Bitmap;

/* loaded from: classes5.dex */
public class e implements com.zk_oaction.adengine.lk_interfaces.b {

    /* renamed from: a */
    public int f34744a;

    /* renamed from: b */
    public int f34745b;

    /* renamed from: c */
    public Bitmap.Config f34746c;

    /* renamed from: d */
    public Bitmap f34747d;

    public e(int i2, int i3, Bitmap.Config config) {
        this.f34744a = i2;
        this.f34745b = i3;
        this.f34746c = config;
        a();
    }

    public void a() {
        synchronized (this) {
            if (this.f34747d == null) {
                this.f34747d = Bitmap.createBitmap(this.f34744a, this.f34745b, this.f34746c);
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.b
    public Bitmap b() {
        Bitmap bitmap;
        synchronized (this) {
            bitmap = this.f34747d;
        }
        return bitmap;
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.b
    public int c() {
        int i2;
        synchronized (this) {
            i2 = this.f34744a;
        }
        return i2;
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.b
    public int d() {
        int i2;
        synchronized (this) {
            i2 = this.f34745b;
        }
        return i2;
    }

    public void e() {
        synchronized (this) {
            Bitmap bitmap = this.f34747d;
            if (bitmap != null) {
                bitmap.recycle();
                this.f34747d = null;
            }
        }
    }
}
