package com.opos.exoplayer.core.c.a;

import com.opos.exoplayer.core.c.f;
import com.opos.exoplayer.core.c.g;
import com.opos.exoplayer.core.c.h;
import com.opos.exoplayer.core.c.k;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public final class a implements com.opos.exoplayer.core.c.e {

    /* renamed from: a */
    public static final h f17761a = new h() { // from class: com.opos.exoplayer.core.c.a.a.1
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new a()};
        }
    };

    /* renamed from: b */
    private static final int f17762b = u.f("FLV");

    /* renamed from: h */
    private g f17768h;
    private int k;
    private int l;
    private int m;
    private long n;
    private boolean o;
    private c p;
    private e q;

    /* renamed from: c */
    private final m f17763c = new m(4);

    /* renamed from: d */
    private final m f17764d = new m(9);

    /* renamed from: e */
    private final m f17765e = new m(11);

    /* renamed from: f */
    private final m f17766f = new m();

    /* renamed from: g */
    private final d f17767g = new d();

    /* renamed from: i */
    private int f17769i = 1;

    /* renamed from: j */
    private long f17770j = C.TIME_UNSET;

    /* renamed from: com.opos.exoplayer.core.c.a.a$1 */
    static final class AnonymousClass1 implements h {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new a()};
        }
    }

    private void a() {
        if (!this.o) {
            this.f17768h.a(new l.b(C.TIME_UNSET));
            this.o = true;
        }
        if (this.f17770j == C.TIME_UNSET) {
            this.f17770j = this.f17767g.a() == C.TIME_UNSET ? -this.n : 0L;
        }
    }

    private boolean b(f fVar) {
        if (!fVar.a(this.f17764d.f19048a, 0, 9, true)) {
            return false;
        }
        this.f17764d.c(0);
        this.f17764d.d(4);
        int g2 = this.f17764d.g();
        boolean z = (g2 & 4) != 0;
        boolean z2 = (g2 & 1) != 0;
        if (z && this.p == null) {
            this.p = new c(this.f17768h.a(8, 1));
        }
        if (z2 && this.q == null) {
            this.q = new e(this.f17768h.a(9, 2));
        }
        this.f17768h.a();
        this.k = (this.f17764d.o() - 9) + 4;
        this.f17769i = 2;
        return true;
    }

    private void c(f fVar) {
        fVar.b(this.k);
        this.k = 0;
        this.f17769i = 3;
    }

    private boolean d(f fVar) {
        if (!fVar.a(this.f17765e.f19048a, 0, 11, true)) {
            return false;
        }
        this.f17765e.c(0);
        this.l = this.f17765e.g();
        this.m = this.f17765e.k();
        this.n = this.f17765e.k();
        this.n = ((this.f17765e.g() << 24) | this.n) * 1000;
        this.f17765e.d(3);
        this.f17769i = 4;
        return true;
    }

    private boolean e(f fVar) {
        b bVar;
        int i2 = this.l;
        boolean z = true;
        if (i2 == 8 && this.p != null) {
            a();
            bVar = this.p;
        } else {
            if (i2 != 9 || this.q == null) {
                if (i2 != 18 || this.o) {
                    fVar.b(this.m);
                    z = false;
                } else {
                    this.f17767g.a(f(fVar), this.n);
                    long a2 = this.f17767g.a();
                    if (a2 != C.TIME_UNSET) {
                        this.f17768h.a(new l.b(a2));
                        this.o = true;
                    }
                }
                this.k = 4;
                this.f17769i = 2;
                return z;
            }
            a();
            bVar = this.q;
        }
        bVar.a(f(fVar), this.f17770j + this.n);
        this.k = 4;
        this.f17769i = 2;
        return z;
    }

    private m f(f fVar) {
        if (this.m > this.f17766f.e()) {
            m mVar = this.f17766f;
            mVar.a(new byte[Math.max(mVar.e() * 2, this.m)], 0);
        } else {
            this.f17766f.c(0);
        }
        this.f17766f.b(this.m);
        fVar.b(this.f17766f.f19048a, 0, this.m);
        return this.f17766f;
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(f fVar, k kVar) {
        while (true) {
            int i2 = this.f17769i;
            if (i2 != 1) {
                if (i2 == 2) {
                    c(fVar);
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        throw new IllegalStateException();
                    }
                    if (e(fVar)) {
                        return 0;
                    }
                } else if (!d(fVar)) {
                    break;
                }
            } else if (!b(fVar)) {
                break;
            }
        }
        return -1;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j2, long j3) {
        this.f17769i = 1;
        this.f17770j = C.TIME_UNSET;
        this.k = 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(g gVar) {
        this.f17768h = gVar;
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(f fVar) {
        fVar.c(this.f17763c.f19048a, 0, 3);
        this.f17763c.c(0);
        if (this.f17763c.k() != f17762b) {
            return false;
        }
        fVar.c(this.f17763c.f19048a, 0, 2);
        this.f17763c.c(0);
        if ((this.f17763c.h() & 250) != 0) {
            return false;
        }
        fVar.c(this.f17763c.f19048a, 0, 4);
        this.f17763c.c(0);
        int o = this.f17763c.o();
        fVar.a();
        fVar.c(o);
        fVar.c(this.f17763c.f19048a, 0, 4);
        this.f17763c.c(0);
        return this.f17763c.o() == 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
