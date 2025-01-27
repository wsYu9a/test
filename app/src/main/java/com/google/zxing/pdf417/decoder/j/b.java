package com.google.zxing.pdf417.decoder.j;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public static final b f8705a = new b(com.google.zxing.t.a.f8819a, 3);

    /* renamed from: b */
    private final int[] f8706b;

    /* renamed from: c */
    private final int[] f8707c;

    /* renamed from: d */
    private final c f8708d;

    /* renamed from: e */
    private final c f8709e;

    /* renamed from: f */
    private final int f8710f;

    private b(int i2, int i3) {
        this.f8710f = i2;
        this.f8706b = new int[i2];
        this.f8707c = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f8706b[i5] = i4;
            i4 = (i4 * i3) % i2;
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.f8707c[this.f8706b[i6]] = i6;
        }
        this.f8708d = new c(this, new int[]{0});
        this.f8709e = new c(this, new int[]{1});
    }

    int a(int i2, int i3) {
        return (i2 + i3) % this.f8710f;
    }

    c b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f8708d;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new c(this, iArr);
    }

    int c(int i2) {
        return this.f8706b[i2];
    }

    c d() {
        return this.f8709e;
    }

    int e() {
        return this.f8710f;
    }

    c f() {
        return this.f8708d;
    }

    int g(int i2) {
        if (i2 != 0) {
            return this.f8706b[(this.f8710f - this.f8707c[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    int h(int i2) {
        if (i2 != 0) {
            return this.f8707c[i2];
        }
        throw new IllegalArgumentException();
    }

    int i(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f8706b;
        int[] iArr2 = this.f8707c;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f8710f - 1)];
    }

    int j(int i2, int i3) {
        int i4 = this.f8710f;
        return ((i2 + i4) - i3) % i4;
    }
}
