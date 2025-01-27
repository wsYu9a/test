package com.google.zxing;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    private final a f8200a;

    /* renamed from: b */
    private com.google.zxing.common.b f8201b;

    public b(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f8200a = aVar;
    }

    public b a(int i2, int i3, int i4, int i5) {
        return new b(this.f8200a.a(this.f8200a.e().a(i2, i3, i4, i5)));
    }

    public com.google.zxing.common.b b() throws NotFoundException {
        if (this.f8201b == null) {
            this.f8201b = this.f8200a.b();
        }
        return this.f8201b;
    }

    public com.google.zxing.common.a c(int i2, com.google.zxing.common.a aVar) throws NotFoundException {
        return this.f8200a.c(i2, aVar);
    }

    public int d() {
        return this.f8200a.d();
    }

    public int e() {
        return this.f8200a.f();
    }

    public boolean f() {
        return this.f8200a.e().g();
    }

    public boolean g() {
        return this.f8200a.e().h();
    }

    public b h() {
        return new b(this.f8200a.a(this.f8200a.e().i()));
    }

    public b i() {
        return new b(this.f8200a.a(this.f8200a.e().j()));
    }

    public String toString() {
        try {
            return b().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
