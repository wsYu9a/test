package com.google.zxing.pdf417.decoder;

/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final int f8684a = -1;

    /* renamed from: b, reason: collision with root package name */
    private final int f8685b;

    /* renamed from: c, reason: collision with root package name */
    private final int f8686c;

    /* renamed from: d, reason: collision with root package name */
    private final int f8687d;

    /* renamed from: e, reason: collision with root package name */
    private final int f8688e;

    /* renamed from: f, reason: collision with root package name */
    private int f8689f = -1;

    d(int i2, int i3, int i4, int i5) {
        this.f8685b = i2;
        this.f8686c = i3;
        this.f8687d = i4;
        this.f8688e = i5;
    }

    int a() {
        return this.f8687d;
    }

    int b() {
        return this.f8686c;
    }

    int c() {
        return this.f8689f;
    }

    int d() {
        return this.f8685b;
    }

    int e() {
        return this.f8688e;
    }

    int f() {
        return this.f8686c - this.f8685b;
    }

    boolean g() {
        return h(this.f8689f);
    }

    boolean h(int i2) {
        return i2 != -1 && this.f8687d == (i2 % 3) * 3;
    }

    void i(int i2) {
        this.f8689f = i2;
    }

    void j() {
        this.f8689f = ((this.f8688e / 30) * 3) + (this.f8687d / 3);
    }

    public String toString() {
        return this.f8689f + "|" + this.f8688e;
    }
}
