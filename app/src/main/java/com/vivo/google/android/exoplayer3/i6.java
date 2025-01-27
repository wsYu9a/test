package com.vivo.google.android.exoplayer3;

/* loaded from: classes4.dex */
public final class i6 {

    /* renamed from: a */
    public final int f27513a;

    /* renamed from: b */
    public final int f27514b;

    /* renamed from: c */
    public final int f27515c;

    /* renamed from: d */
    public final long f27516d;

    public i6(byte[] bArr, int i2) {
        m6 m6Var = new m6(bArr);
        m6Var.b(i2 * 8);
        m6Var.a(16);
        m6Var.a(16);
        m6Var.a(24);
        m6Var.a(24);
        this.f27513a = m6Var.a(20);
        this.f27514b = m6Var.a(3) + 1;
        this.f27515c = m6Var.a(5) + 1;
        this.f27516d = ((m6Var.a(4) & 15) << 32) | (m6Var.a(32) & 4294967295L);
    }
}
