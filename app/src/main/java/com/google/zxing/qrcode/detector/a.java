package com.google.zxing.qrcode.detector;

import com.google.zxing.l;

/* loaded from: classes.dex */
public final class a extends l {

    /* renamed from: c */
    private final float f8778c;

    a(float f2, float f3, float f4) {
        super(f2, f3);
        this.f8778c = f4;
    }

    boolean f(float f2, float f3, float f4) {
        if (Math.abs(f3 - d()) > f2 || Math.abs(f4 - c()) > f2) {
            return false;
        }
        float abs = Math.abs(f2 - this.f8778c);
        return abs <= 1.0f || abs <= this.f8778c;
    }

    a g(float f2, float f3, float f4) {
        return new a((c() + f3) / 2.0f, (d() + f2) / 2.0f, (this.f8778c + f4) / 2.0f);
    }
}
