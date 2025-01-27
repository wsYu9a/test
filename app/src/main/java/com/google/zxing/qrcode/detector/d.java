package com.google.zxing.qrcode.detector;

import com.google.zxing.l;

/* loaded from: classes.dex */
public final class d extends l {

    /* renamed from: c */
    private final float f8790c;

    /* renamed from: d */
    private final int f8791d;

    d(float f2, float f3, float f4) {
        this(f2, f3, f4, 1);
    }

    boolean f(float f2, float f3, float f4) {
        if (Math.abs(f3 - d()) > f2 || Math.abs(f4 - c()) > f2) {
            return false;
        }
        float abs = Math.abs(f2 - this.f8790c);
        return abs <= 1.0f || abs <= this.f8790c;
    }

    d g(float f2, float f3, float f4) {
        int i2 = this.f8791d;
        int i3 = i2 + 1;
        float c2 = (i2 * c()) + f3;
        float f5 = i3;
        return new d(c2 / f5, ((this.f8791d * d()) + f2) / f5, ((this.f8791d * this.f8790c) + f4) / f5, i3);
    }

    int h() {
        return this.f8791d;
    }

    public float i() {
        return this.f8790c;
    }

    private d(float f2, float f3, float f4, int i2) {
        super(f2, f3);
        this.f8790c = f4;
        this.f8791d = i2;
    }
}
