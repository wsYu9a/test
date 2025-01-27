package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class p0 implements g0, m0 {
    public static final int n = Util.getIntegerCodeForString("FLV");

    /* renamed from: e */
    public i0 f27911e;

    /* renamed from: g */
    public int f27913g;

    /* renamed from: h */
    public int f27914h;

    /* renamed from: i */
    public int f27915i;

    /* renamed from: j */
    public long f27916j;
    public o0 k;
    public s0 l;
    public q0 m;

    /* renamed from: a */
    public final n6 f27907a = new n6(4);

    /* renamed from: b */
    public final n6 f27908b = new n6(9);

    /* renamed from: c */
    public final n6 f27909c = new n6(11);

    /* renamed from: d */
    public final n6 f27910d = new n6();

    /* renamed from: f */
    public int f27912f = 1;

    @Override // com.vivo.google.android.exoplayer3.g0
    public int a(h0 h0Var, l0 l0Var) {
        while (true) {
            int i2 = this.f27912f;
            boolean z = true;
            if (i2 == 1) {
                if (((d0) h0Var).b(this.f27908b.f27874a, 0, 9, true)) {
                    this.f27908b.d(0);
                    this.f27908b.e(4);
                    int l = this.f27908b.l();
                    boolean z2 = (l & 4) != 0;
                    boolean z3 = (l & 1) != 0;
                    if (z2 && this.k == null) {
                        this.k = new o0(((l3) this.f27911e).a(8, 1));
                    }
                    if (z3 && this.l == null) {
                        this.l = new s0(((l3) this.f27911e).a(9, 2));
                    }
                    if (this.m == null) {
                        this.m = new q0(null);
                    }
                    ((l3) this.f27911e).f();
                    l3 l3Var = (l3) this.f27911e;
                    l3Var.q = this;
                    l3Var.n.post(l3Var.l);
                    this.f27913g = (this.f27908b.c() - 9) + 4;
                    this.f27912f = 2;
                } else {
                    z = false;
                }
                if (!z) {
                    return -1;
                }
            } else if (i2 == 2) {
                ((d0) h0Var).c(this.f27913g);
                this.f27913g = 0;
                this.f27912f = 3;
            } else if (i2 == 3) {
                if (((d0) h0Var).b(this.f27909c.f27874a, 0, 11, true)) {
                    this.f27909c.d(0);
                    this.f27914h = this.f27909c.l();
                    this.f27915i = this.f27909c.n();
                    this.f27916j = this.f27909c.n();
                    this.f27916j = ((this.f27909c.l() << 24) | this.f27916j) * 1000;
                    this.f27909c.e(3);
                    this.f27912f = 4;
                } else {
                    z = false;
                }
                if (!z) {
                    return -1;
                }
            } else if (i2 == 4 && c(h0Var)) {
                return 0;
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public long a(long j2) {
        return 0L;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(long j2, long j3) {
        this.f27912f = 1;
        this.f27913g = 0;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(i0 i0Var) {
        this.f27911e = i0Var;
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public boolean a() {
        return false;
    }

    public final n6 b(h0 h0Var) {
        if (this.f27915i > this.f27910d.b()) {
            n6 n6Var = this.f27910d;
            n6Var.f27874a = new byte[Math.max(n6Var.b() * 2, this.f27915i)];
            n6Var.f27876c = 0;
            n6Var.f27875b = 0;
        } else {
            this.f27910d.d(0);
        }
        this.f27910d.c(this.f27915i);
        ((d0) h0Var).b(this.f27910d.f27874a, 0, this.f27915i, false);
        return this.f27910d;
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public long c() {
        return this.m.f27943b;
    }

    public final boolean c(h0 h0Var) {
        boolean z;
        r0 r0Var;
        int i2 = this.f27914h;
        if ((i2 != 8 || (r0Var = this.k) == null) && ((i2 != 9 || (r0Var = this.l) == null) && (i2 != 18 || (r0Var = this.m) == null))) {
            ((d0) h0Var).c(this.f27915i);
            z = false;
        } else {
            r0Var.a(b(h0Var), this.f27916j);
            z = true;
        }
        this.f27913g = 4;
        this.f27912f = 2;
        return z;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void release() {
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public boolean a(h0 h0Var) {
        d0 d0Var = (d0) h0Var;
        d0Var.a(this.f27907a.f27874a, 0, 3, false);
        this.f27907a.d(0);
        if (this.f27907a.n() != n) {
            return false;
        }
        d0Var.a(this.f27907a.f27874a, 0, 2, false);
        this.f27907a.d(0);
        if ((this.f27907a.q() & 250) != 0) {
            return false;
        }
        d0Var.a(this.f27907a.f27874a, 0, 4, false);
        this.f27907a.d(0);
        int c2 = this.f27907a.c();
        d0Var.f27270e = 0;
        d0Var.a(c2, false);
        d0Var.a(this.f27907a.f27874a, 0, 4, false);
        this.f27907a.d(0);
        return this.f27907a.c() == 0;
    }
}
