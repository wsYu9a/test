package com.opos.exoplayer.core.c.f;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class m implements h {

    /* renamed from: a */
    private final String f18202a;

    /* renamed from: b */
    private final com.opos.exoplayer.core.i.m f18203b;

    /* renamed from: c */
    private final com.opos.exoplayer.core.i.l f18204c;

    /* renamed from: d */
    private com.opos.exoplayer.core.c.n f18205d;

    /* renamed from: e */
    private Format f18206e;

    /* renamed from: f */
    private String f18207f;

    /* renamed from: g */
    private int f18208g;

    /* renamed from: h */
    private int f18209h;

    /* renamed from: i */
    private int f18210i;

    /* renamed from: j */
    private int f18211j;
    private long k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private int t;

    public m(@Nullable String str) {
        this.f18202a = str;
        com.opos.exoplayer.core.i.m mVar = new com.opos.exoplayer.core.i.m(1024);
        this.f18203b = mVar;
        this.f18204c = new com.opos.exoplayer.core.i.l(mVar.f19048a);
    }

    private void a(int i2) {
        this.f18203b.a(i2);
        this.f18204c.a(this.f18203b.f19048a);
    }

    private void a(com.opos.exoplayer.core.i.l lVar) {
        if (!lVar.e()) {
            this.l = true;
            b(lVar);
        } else if (!this.l) {
            return;
        }
        if (this.m != 0) {
            throw new com.opos.exoplayer.core.o();
        }
        if (this.n != 0) {
            throw new com.opos.exoplayer.core.o();
        }
        a(lVar, e(lVar));
        if (this.p) {
            lVar.b((int) this.q);
        }
    }

    private void a(com.opos.exoplayer.core.i.l lVar, int i2) {
        int b2 = lVar.b();
        if ((b2 & 7) == 0) {
            this.f18203b.c(b2 >> 3);
        } else {
            lVar.a(this.f18203b.f19048a, 0, i2 * 8);
            this.f18203b.c(0);
        }
        this.f18205d.a(this.f18203b, i2);
        this.f18205d.a(this.k, 1, i2, 0, null);
        this.k += this.s;
    }

    private void b(com.opos.exoplayer.core.i.l lVar) {
        boolean e2;
        int c2 = lVar.c(1);
        int c3 = c2 == 1 ? lVar.c(1) : 0;
        this.m = c3;
        if (c3 != 0) {
            throw new com.opos.exoplayer.core.o();
        }
        if (c2 == 1) {
            f(lVar);
        }
        if (!lVar.e()) {
            throw new com.opos.exoplayer.core.o();
        }
        this.n = lVar.c(6);
        int c4 = lVar.c(4);
        int c5 = lVar.c(3);
        if (c4 != 0 || c5 != 0) {
            throw new com.opos.exoplayer.core.o();
        }
        if (c2 == 0) {
            int b2 = lVar.b();
            int d2 = d(lVar);
            lVar.a(b2);
            byte[] bArr = new byte[(d2 + 7) / 8];
            lVar.a(bArr, 0, d2);
            Format a2 = Format.a(this.f18207f, "audio/mp4a-latm", null, -1, -1, this.t, this.r, Collections.singletonList(bArr), null, 0, this.f18202a);
            if (!a2.equals(this.f18206e)) {
                this.f18206e = a2;
                this.s = 1024000000 / a2.s;
                this.f18205d.a(a2);
            }
        } else {
            lVar.b(((int) f(lVar)) - d(lVar));
        }
        c(lVar);
        boolean e3 = lVar.e();
        this.p = e3;
        this.q = 0L;
        if (e3) {
            if (c2 == 1) {
                this.q = f(lVar);
            } else {
                do {
                    e2 = lVar.e();
                    this.q = (this.q << 8) + lVar.c(8);
                } while (e2);
            }
        }
        if (lVar.e()) {
            lVar.b(8);
        }
    }

    private void c(com.opos.exoplayer.core.i.l lVar) {
        int i2;
        int c2 = lVar.c(3);
        this.o = c2;
        if (c2 == 0) {
            i2 = 8;
        } else {
            if (c2 != 1) {
                if (c2 == 3 || c2 == 4 || c2 == 5) {
                    lVar.b(6);
                    return;
                } else {
                    if (c2 == 6 || c2 == 7) {
                        lVar.b(1);
                        return;
                    }
                    return;
                }
            }
            i2 = 9;
        }
        lVar.b(i2);
    }

    private int d(com.opos.exoplayer.core.i.l lVar) {
        int a2 = lVar.a();
        Pair<Integer, Integer> a3 = com.opos.exoplayer.core.i.c.a(lVar, true);
        this.r = ((Integer) a3.first).intValue();
        this.t = ((Integer) a3.second).intValue();
        return a2 - lVar.a();
    }

    private int e(com.opos.exoplayer.core.i.l lVar) {
        int c2;
        if (this.o != 0) {
            throw new com.opos.exoplayer.core.o();
        }
        int i2 = 0;
        do {
            c2 = lVar.c(8);
            i2 += c2;
        } while (c2 == 255);
        return i2;
    }

    private static long f(com.opos.exoplayer.core.i.l lVar) {
        return lVar.c((lVar.c(2) + 1) * 8);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        this.f18208g = 0;
        this.l = false;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j2, boolean z) {
        this.k = j2;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.f18205d = gVar.a(dVar.b(), 1);
        this.f18207f = dVar.c();
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        while (mVar.b() > 0) {
            int i2 = this.f18208g;
            if (i2 != 0) {
                if (i2 == 1) {
                    int g2 = mVar.g();
                    if ((g2 & 224) == 224) {
                        this.f18211j = g2;
                        this.f18208g = 2;
                    } else if (g2 != 86) {
                        this.f18208g = 0;
                    }
                } else if (i2 == 2) {
                    int g3 = ((this.f18211j & (-225)) << 8) | mVar.g();
                    this.f18210i = g3;
                    if (g3 > this.f18203b.f19048a.length) {
                        a(g3);
                    }
                    this.f18209h = 0;
                    this.f18208g = 3;
                } else if (i2 == 3) {
                    int min = Math.min(mVar.b(), this.f18210i - this.f18209h);
                    mVar.a(this.f18204c.f19044a, this.f18209h, min);
                    int i3 = min + this.f18209h;
                    this.f18209h = i3;
                    if (i3 == this.f18210i) {
                        this.f18204c.a(0);
                        a(this.f18204c);
                        this.f18208g = 0;
                    }
                }
            } else if (mVar.g() == 86) {
                this.f18208g = 1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
