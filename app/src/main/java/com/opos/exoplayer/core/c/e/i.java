package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.i.m;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
abstract class i {

    /* renamed from: a */
    private final e f18055a = new e();

    /* renamed from: b */
    private n f18056b;

    /* renamed from: c */
    private com.opos.exoplayer.core.c.g f18057c;

    /* renamed from: d */
    private g f18058d;

    /* renamed from: e */
    private long f18059e;

    /* renamed from: f */
    private long f18060f;

    /* renamed from: g */
    private long f18061g;

    /* renamed from: h */
    private int f18062h;

    /* renamed from: i */
    private int f18063i;

    /* renamed from: j */
    private a f18064j;
    private long k;
    private boolean l;
    private boolean m;

    static class a {

        /* renamed from: a */
        Format f18065a;

        /* renamed from: b */
        g f18066b;

        a() {
        }
    }

    private static final class b implements g {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public long a(long j2) {
            return 0L;
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public long a(com.opos.exoplayer.core.c.f fVar) {
            return -1L;
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public l c() {
            return new l.b(C.TIME_UNSET);
        }
    }

    private int a(com.opos.exoplayer.core.c.f fVar) {
        boolean z = true;
        while (z) {
            if (!this.f18055a.a(fVar)) {
                this.f18062h = 3;
                return -1;
            }
            this.k = fVar.c() - this.f18060f;
            z = a(this.f18055a.c(), this.f18060f, this.f18064j);
            if (z) {
                this.f18060f = fVar.c();
            }
        }
        Format format = this.f18064j.f18065a;
        this.f18063i = format.s;
        if (!this.m) {
            this.f18056b.a(format);
            this.m = true;
        }
        g gVar = this.f18064j.f18066b;
        if (gVar != null) {
            this.f18058d = gVar;
        } else if (fVar.d() == -1) {
            this.f18058d = new b();
        } else {
            f b2 = this.f18055a.b();
            this.f18058d = new c(this.f18060f, fVar.d(), this, b2.f18050i + b2.f18049h, b2.f18044c);
        }
        this.f18064j = null;
        this.f18062h = 2;
        this.f18055a.d();
        return 0;
    }

    private int b(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        long a2 = this.f18058d.a(fVar);
        if (a2 >= 0) {
            kVar.f18323a = a2;
            return 1;
        }
        if (a2 < -1) {
            c(-(a2 + 2));
        }
        if (!this.l) {
            this.f18057c.a(this.f18058d.c());
            this.l = true;
        }
        if (this.k <= 0 && !this.f18055a.a(fVar)) {
            this.f18062h = 3;
            return -1;
        }
        this.k = 0L;
        m c2 = this.f18055a.c();
        long b2 = b(c2);
        if (b2 >= 0) {
            long j2 = this.f18061g;
            if (j2 + b2 >= this.f18059e) {
                long a3 = a(j2);
                this.f18056b.a(c2, c2.c());
                this.f18056b.a(a3, 1, c2.c(), 0, null);
                this.f18059e = -1L;
            }
        }
        this.f18061g += b2;
        return 0;
    }

    final int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        int i2 = this.f18062h;
        if (i2 == 0) {
            return a(fVar);
        }
        if (i2 != 1) {
            if (i2 == 2) {
                return b(fVar, kVar);
            }
            throw new IllegalStateException();
        }
        fVar.b((int) this.f18060f);
        this.f18062h = 2;
        return 0;
    }

    protected long a(long j2) {
        return (j2 * C.MICROS_PER_SECOND) / this.f18063i;
    }

    final void a(long j2, long j3) {
        this.f18055a.a();
        if (j2 == 0) {
            a(!this.l);
        } else if (this.f18062h != 0) {
            this.f18059e = this.f18058d.a(j3);
            this.f18062h = 2;
        }
    }

    void a(com.opos.exoplayer.core.c.g gVar, n nVar) {
        this.f18057c = gVar;
        this.f18056b = nVar;
        a(true);
    }

    protected void a(boolean z) {
        int i2;
        if (z) {
            this.f18064j = new a();
            this.f18060f = 0L;
            i2 = 0;
        } else {
            i2 = 1;
        }
        this.f18062h = i2;
        this.f18059e = -1L;
        this.f18061g = 0L;
    }

    protected abstract boolean a(m mVar, long j2, a aVar);

    protected long b(long j2) {
        return (this.f18063i * j2) / C.MICROS_PER_SECOND;
    }

    protected abstract long b(m mVar);

    protected void c(long j2) {
        this.f18061g = j2;
    }
}
