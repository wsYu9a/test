package com.google.zxing.o.e;

/* loaded from: classes.dex */
abstract class g {

    /* renamed from: a */
    static final g f8500a = new e(null, 0, 0);

    /* renamed from: b */
    private final g f8501b;

    g(g gVar) {
        this.f8501b = gVar;
    }

    final g a(int i2, int i3) {
        return new e(this, i2, i3);
    }

    final g b(int i2, int i3) {
        return new b(this, i2, i3);
    }

    abstract void c(com.google.zxing.common.a aVar, byte[] bArr);

    final g d() {
        return this.f8501b;
    }
}
