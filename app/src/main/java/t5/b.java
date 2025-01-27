package t5;

import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    public final a f30699a;

    /* renamed from: b */
    public z5.b f30700b;

    public b(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f30699a = aVar;
    }

    public b a(int i10, int i11, int i12, int i13) {
        return new b(this.f30699a.a(this.f30699a.e().a(i10, i11, i12, i13)));
    }

    public z5.b b() throws NotFoundException {
        if (this.f30700b == null) {
            this.f30700b = this.f30699a.b();
        }
        return this.f30700b;
    }

    public z5.a c(int i10, z5.a aVar) throws NotFoundException {
        return this.f30699a.c(i10, aVar);
    }

    public int d() {
        return this.f30699a.d();
    }

    public int e() {
        return this.f30699a.f();
    }

    public boolean f() {
        return this.f30699a.e().g();
    }

    public boolean g() {
        return this.f30699a.e().h();
    }

    public b h() {
        return new b(this.f30699a.a(this.f30699a.e().i()));
    }

    public b i() {
        return new b(this.f30699a.a(this.f30699a.e().j()));
    }

    public String toString() {
        try {
            return b().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
