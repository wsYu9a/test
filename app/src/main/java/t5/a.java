package t5;

import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a */
    public final e f30698a;

    public a(e eVar) {
        this.f30698a = eVar;
    }

    public abstract a a(e eVar);

    public abstract z5.b b() throws NotFoundException;

    public abstract z5.a c(int i10, z5.a aVar) throws NotFoundException;

    public final int d() {
        return this.f30698a.b();
    }

    public final e e() {
        return this.f30698a;
    }

    public final int f() {
        return this.f30698a.e();
    }
}
