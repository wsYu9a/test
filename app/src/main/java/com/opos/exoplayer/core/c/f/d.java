package com.opos.exoplayer.core.c.f;

import android.util.Pair;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class d implements h {

    /* renamed from: a */
    private static final byte[] f18103a = {73, 68, 51};

    /* renamed from: b */
    private final boolean f18104b;

    /* renamed from: c */
    private final com.opos.exoplayer.core.i.l f18105c;

    /* renamed from: d */
    private final com.opos.exoplayer.core.i.m f18106d;

    /* renamed from: e */
    private final String f18107e;

    /* renamed from: f */
    private String f18108f;

    /* renamed from: g */
    private com.opos.exoplayer.core.c.n f18109g;

    /* renamed from: h */
    private com.opos.exoplayer.core.c.n f18110h;

    /* renamed from: i */
    private int f18111i;

    /* renamed from: j */
    private int f18112j;
    private int k;
    private boolean l;
    private boolean m;
    private long n;
    private int o;
    private long p;
    private com.opos.exoplayer.core.c.n q;
    private long r;

    public d(boolean z) {
        this(z, null);
    }

    public d(boolean z, String str) {
        this.f18105c = new com.opos.exoplayer.core.i.l(new byte[7]);
        this.f18106d = new com.opos.exoplayer.core.i.m(Arrays.copyOf(f18103a, 10));
        c();
        this.f18104b = z;
        this.f18107e = str;
    }

    private void a(com.opos.exoplayer.core.c.n nVar, long j2, int i2, int i3) {
        this.f18111i = 3;
        this.f18112j = i2;
        this.q = nVar;
        this.r = j2;
        this.o = i3;
    }

    private boolean a(com.opos.exoplayer.core.i.m mVar, byte[] bArr, int i2) {
        int min = Math.min(mVar.b(), i2 - this.f18112j);
        mVar.a(bArr, this.f18112j, min);
        int i3 = min + this.f18112j;
        this.f18112j = i3;
        return i3 == i2;
    }

    private void b(com.opos.exoplayer.core.i.m mVar) {
        int i2;
        byte[] bArr = mVar.f19048a;
        int d2 = mVar.d();
        int c2 = mVar.c();
        while (d2 < c2) {
            int i3 = d2 + 1;
            int i4 = bArr[d2] & 255;
            int i5 = this.k;
            if (i5 != 512 || i4 < 240 || i4 == 255) {
                int i6 = i4 | i5;
                if (i6 != 329) {
                    if (i6 == 511) {
                        this.k = 512;
                    } else if (i6 == 836) {
                        i2 = 1024;
                    } else if (i6 == 1075) {
                        d();
                    } else if (i5 != 256) {
                        this.k = 256;
                        d2 = i3 - 1;
                    }
                    d2 = i3;
                } else {
                    i2 = 768;
                }
                this.k = i2;
                d2 = i3;
            } else {
                this.l = (i4 & 1) == 0;
                e();
            }
            mVar.c(i3);
            return;
        }
        mVar.c(d2);
    }

    private void c() {
        this.f18111i = 0;
        this.f18112j = 0;
        this.k = 256;
    }

    private void c(com.opos.exoplayer.core.i.m mVar) {
        int min = Math.min(mVar.b(), this.o - this.f18112j);
        this.q.a(mVar, min);
        int i2 = min + this.f18112j;
        this.f18112j = i2;
        int i3 = this.o;
        if (i2 == i3) {
            this.q.a(this.p, 1, i3, 0, null);
            this.p += this.r;
            c();
        }
    }

    private void d() {
        this.f18111i = 1;
        this.f18112j = f18103a.length;
        this.o = 0;
        this.f18106d.c(0);
    }

    private void e() {
        this.f18111i = 2;
        this.f18112j = 0;
    }

    private void f() {
        this.f18110h.a(this.f18106d, 10);
        this.f18106d.c(6);
        a(this.f18110h, 0L, 10, this.f18106d.t() + 10);
    }

    private void g() {
        this.f18105c.a(0);
        if (this.m) {
            this.f18105c.b(10);
        } else {
            int c2 = this.f18105c.c(2) + 1;
            if (c2 != 2) {
                com.opos.cmn.an.f.a.c("AdtsReader", "Detected audio object type: " + c2 + ", but assuming AAC LC.");
                c2 = 2;
            }
            int c3 = this.f18105c.c(4);
            this.f18105c.b(1);
            byte[] a2 = com.opos.exoplayer.core.i.c.a(c2, c3, this.f18105c.c(3));
            Pair<Integer, Integer> a3 = com.opos.exoplayer.core.i.c.a(a2);
            Format a4 = Format.a(this.f18108f, "audio/mp4a-latm", null, -1, -1, ((Integer) a3.second).intValue(), ((Integer) a3.first).intValue(), Collections.singletonList(a2), null, 0, this.f18107e);
            this.n = 1024000000 / a4.s;
            this.f18109g.a(a4);
            this.m = true;
        }
        this.f18105c.b(4);
        int c4 = (this.f18105c.c(13) - 2) - 5;
        if (this.l) {
            c4 -= 2;
        }
        a(this.f18109g, this.n, 0, c4);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        c();
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j2, boolean z) {
        this.p = j2;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.f18108f = dVar.c();
        this.f18109g = gVar.a(dVar.b(), 1);
        if (!this.f18104b) {
            this.f18110h = new com.opos.exoplayer.core.c.d();
            return;
        }
        dVar.a();
        com.opos.exoplayer.core.c.n a2 = gVar.a(dVar.b(), 4);
        this.f18110h = a2;
        a2.a(Format.a(dVar.c(), "application/id3", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        while (mVar.b() > 0) {
            int i2 = this.f18111i;
            if (i2 == 0) {
                b(mVar);
            } else if (i2 != 1) {
                if (i2 == 2) {
                    if (a(mVar, this.f18105c.f19044a, this.l ? 7 : 5)) {
                        g();
                    }
                } else if (i2 == 3) {
                    c(mVar);
                }
            } else if (a(mVar, this.f18106d.f19048a, 10)) {
                f();
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
