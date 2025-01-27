package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.m0;

/* loaded from: classes4.dex */
public abstract class w1 {

    /* renamed from: a */
    public s1 f28216a;

    /* renamed from: b */
    public n0 f28217b;

    /* renamed from: c */
    public i0 f28218c;

    /* renamed from: d */
    public u1 f28219d;

    /* renamed from: e */
    public long f28220e;

    /* renamed from: f */
    public long f28221f;

    /* renamed from: g */
    public long f28222g;

    /* renamed from: h */
    public int f28223h;

    /* renamed from: i */
    public int f28224i;

    /* renamed from: j */
    public a f28225j;
    public long k;
    public boolean l;
    public boolean m;

    public static class a {

        /* renamed from: a */
        public Format f28226a;

        /* renamed from: b */
        public u1 f28227b;
    }

    public static final class b implements u1 {
        @Override // com.vivo.google.android.exoplayer3.u1
        public long a(h0 h0Var) {
            return -1L;
        }

        @Override // com.vivo.google.android.exoplayer3.u1
        public long b(long j2) {
            return 0L;
        }

        @Override // com.vivo.google.android.exoplayer3.u1
        public m0 b() {
            return new m0.a(C.TIME_UNSET);
        }
    }

    public long a(long j2) {
        return (this.f28224i * j2) / C.MICROS_PER_SECOND;
    }

    public abstract long a(n6 n6Var);

    public void a(boolean z) {
        int i2;
        if (z) {
            this.f28225j = new a();
            this.f28221f = 0L;
            i2 = 0;
        } else {
            i2 = 1;
        }
        this.f28223h = i2;
        this.f28220e = -1L;
        this.f28222g = 0L;
    }

    public abstract boolean a(n6 n6Var, long j2, a aVar);

    public void b(long j2) {
        this.f28222g = j2;
    }
}
