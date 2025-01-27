package com.google.zxing.u.c;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final byte[][] f8852a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8853b;

    /* renamed from: c, reason: collision with root package name */
    private final int f8854c;

    public b(int i2, int i3) {
        this.f8852a = (byte[][]) Array.newInstance((Class<?>) byte.class, i3, i2);
        this.f8853b = i2;
        this.f8854c = i3;
    }

    public void a(byte b2) {
        for (int i2 = 0; i2 < this.f8854c; i2++) {
            for (int i3 = 0; i3 < this.f8853b; i3++) {
                this.f8852a[i2][i3] = b2;
            }
        }
    }

    public byte b(int i2, int i3) {
        return this.f8852a[i3][i2];
    }

    public byte[][] c() {
        return this.f8852a;
    }

    public int d() {
        return this.f8854c;
    }

    public int e() {
        return this.f8853b;
    }

    public void f(int i2, int i3, byte b2) {
        this.f8852a[i3][i2] = b2;
    }

    public void g(int i2, int i3, int i4) {
        this.f8852a[i3][i2] = (byte) i4;
    }

    public void h(int i2, int i3, boolean z) {
        this.f8852a[i3][i2] = z ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f8853b * 2 * this.f8854c) + 2);
        for (int i2 = 0; i2 < this.f8854c; i2++) {
            for (int i3 = 0; i3 < this.f8853b; i3++) {
                byte b2 = this.f8852a[i2][i3];
                if (b2 == 0) {
                    sb.append(" 0");
                } else if (b2 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
