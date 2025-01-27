package com.google.zxing;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a */
    private final e f8192a;

    protected a(e eVar) {
        this.f8192a = eVar;
    }

    public abstract a a(e eVar);

    public abstract com.google.zxing.common.b b() throws NotFoundException;

    public abstract com.google.zxing.common.a c(int i2, com.google.zxing.common.a aVar) throws NotFoundException;

    public final int d() {
        return this.f8192a.b();
    }

    public final e e() {
        return this.f8192a;
    }

    public final int f() {
        return this.f8192a.e();
    }
}
