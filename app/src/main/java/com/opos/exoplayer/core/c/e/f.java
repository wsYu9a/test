package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.o;
import java.io.EOFException;

/* loaded from: classes4.dex */
final class f {
    private static final int k = u.f("OggS");

    /* renamed from: a */
    public int f18042a;

    /* renamed from: b */
    public int f18043b;

    /* renamed from: c */
    public long f18044c;

    /* renamed from: d */
    public long f18045d;

    /* renamed from: e */
    public long f18046e;

    /* renamed from: f */
    public long f18047f;

    /* renamed from: g */
    public int f18048g;

    /* renamed from: h */
    public int f18049h;

    /* renamed from: i */
    public int f18050i;

    /* renamed from: j */
    public final int[] f18051j = new int[255];
    private final m l = new m(255);

    f() {
    }

    public void a() {
        this.f18042a = 0;
        this.f18043b = 0;
        this.f18044c = 0L;
        this.f18045d = 0L;
        this.f18046e = 0L;
        this.f18047f = 0L;
        this.f18048g = 0;
        this.f18049h = 0;
        this.f18050i = 0;
    }

    public boolean a(com.opos.exoplayer.core.c.f fVar, boolean z) {
        this.l.a();
        a();
        if ((fVar.d() == -1 || fVar.d() - fVar.b() >= 27) && fVar.b(this.l.f19048a, 0, 27, true)) {
            if (this.l.m() == k) {
                int g2 = this.l.g();
                this.f18042a = g2;
                if (g2 == 0) {
                    this.f18043b = this.l.g();
                    this.f18044c = this.l.r();
                    this.f18045d = this.l.n();
                    this.f18046e = this.l.n();
                    this.f18047f = this.l.n();
                    int g3 = this.l.g();
                    this.f18048g = g3;
                    this.f18049h = g3 + 27;
                    this.l.a();
                    fVar.c(this.l.f19048a, 0, this.f18048g);
                    for (int i2 = 0; i2 < this.f18048g; i2++) {
                        this.f18051j[i2] = this.l.g();
                        this.f18050i += this.f18051j[i2];
                    }
                    return true;
                }
                if (!z) {
                    throw new o("unsupported bit stream revision");
                }
            } else if (!z) {
                throw new o("expected OggS capture pattern at begin of page");
            }
        } else if (!z) {
            throw new EOFException();
        }
        return false;
    }
}
