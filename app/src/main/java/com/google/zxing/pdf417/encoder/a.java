package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private final b[] f8713a;

    /* renamed from: b */
    private int f8714b;

    /* renamed from: c */
    private final int f8715c;

    /* renamed from: d */
    private final int f8716d;

    a(int i2, int i3) {
        b[] bVarArr = new b[i2];
        this.f8713a = bVarArr;
        int length = bVarArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f8713a[i4] = new b(((i3 + 4) * 17) + 1);
        }
        this.f8716d = i3 * 17;
        this.f8715c = i2;
        this.f8714b = -1;
    }

    b a() {
        return this.f8713a[this.f8714b];
    }

    public byte[][] b() {
        return c(1, 1);
    }

    public byte[][] c(int i2, int i3) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f8715c * i3, this.f8716d * i2);
        int i4 = this.f8715c * i3;
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[(i4 - i5) - 1] = this.f8713a[i5 / i3].b(i2);
        }
        return bArr;
    }

    void d(int i2, int i3, byte b2) {
        this.f8713a[i3].c(i2, b2);
    }

    void e() {
        this.f8714b++;
    }
}
