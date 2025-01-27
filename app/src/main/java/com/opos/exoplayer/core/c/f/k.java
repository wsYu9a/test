package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes4.dex */
public final class k implements h {

    /* renamed from: a */
    private final w f18176a;

    /* renamed from: b */
    private String f18177b;

    /* renamed from: c */
    private com.opos.exoplayer.core.c.n f18178c;

    /* renamed from: d */
    private a f18179d;

    /* renamed from: e */
    private boolean f18180e;
    private long l;
    private long m;

    /* renamed from: f */
    private final boolean[] f18181f = new boolean[3];

    /* renamed from: g */
    private final v f18182g = new v(32, 128);

    /* renamed from: h */
    private final v f18183h = new v(33, 128);

    /* renamed from: i */
    private final v f18184i = new v(34, 128);

    /* renamed from: j */
    private final v f18185j = new v(39, 128);
    private final v k = new v(40, 128);
    private final com.opos.exoplayer.core.i.m n = new com.opos.exoplayer.core.i.m();

    private static final class a {

        /* renamed from: a */
        private final com.opos.exoplayer.core.c.n f18186a;

        /* renamed from: b */
        private long f18187b;

        /* renamed from: c */
        private boolean f18188c;

        /* renamed from: d */
        private int f18189d;

        /* renamed from: e */
        private long f18190e;

        /* renamed from: f */
        private boolean f18191f;

        /* renamed from: g */
        private boolean f18192g;

        /* renamed from: h */
        private boolean f18193h;

        /* renamed from: i */
        private boolean f18194i;

        /* renamed from: j */
        private boolean f18195j;
        private long k;
        private long l;
        private boolean m;

        public a(com.opos.exoplayer.core.c.n nVar) {
            this.f18186a = nVar;
        }

        private void a(int i2) {
            boolean z = this.m;
            this.f18186a.a(this.l, z ? 1 : 0, (int) (this.f18187b - this.k), i2, null);
        }

        public void a() {
            this.f18191f = false;
            this.f18192g = false;
            this.f18193h = false;
            this.f18194i = false;
            this.f18195j = false;
        }

        public void a(long j2, int i2) {
            if (this.f18195j && this.f18192g) {
                this.m = this.f18188c;
                this.f18195j = false;
            } else if (this.f18193h || this.f18192g) {
                if (this.f18194i) {
                    a(((int) (j2 - this.f18187b)) + i2);
                }
                this.k = this.f18187b;
                this.l = this.f18190e;
                this.f18194i = true;
                this.m = this.f18188c;
            }
        }

        public void a(long j2, int i2, int i3, long j3) {
            this.f18192g = false;
            this.f18193h = false;
            this.f18190e = j3;
            this.f18189d = 0;
            this.f18187b = j2;
            if (i3 >= 32) {
                if (!this.f18195j && this.f18194i) {
                    a(i2);
                    this.f18194i = false;
                }
                if (i3 <= 34) {
                    this.f18193h = !this.f18195j;
                    this.f18195j = true;
                }
            }
            boolean z = i3 >= 16 && i3 <= 21;
            this.f18188c = z;
            this.f18191f = z || i3 <= 9;
        }

        public void a(byte[] bArr, int i2, int i3) {
            if (this.f18191f) {
                int i4 = this.f18189d;
                int i5 = (i2 + 2) - i4;
                if (i5 >= i3) {
                    this.f18189d = i4 + (i3 - i2);
                } else {
                    this.f18192g = (bArr[i5] & ByteCompanionObject.MIN_VALUE) != 0;
                    this.f18191f = false;
                }
            }
        }
    }

    public k(w wVar) {
        this.f18176a = wVar;
    }

    private static Format a(String str, v vVar, v vVar2, v vVar3) {
        float f2;
        int i2 = vVar.f18287b;
        byte[] bArr = new byte[vVar2.f18287b + i2 + vVar3.f18287b];
        System.arraycopy(vVar.f18286a, 0, bArr, 0, i2);
        System.arraycopy(vVar2.f18286a, 0, bArr, vVar.f18287b, vVar2.f18287b);
        System.arraycopy(vVar3.f18286a, 0, bArr, vVar.f18287b + vVar2.f18287b, vVar3.f18287b);
        com.opos.exoplayer.core.i.n nVar = new com.opos.exoplayer.core.i.n(vVar2.f18286a, 0, vVar2.f18287b);
        nVar.a(44);
        int c2 = nVar.c(3);
        nVar.a();
        nVar.a(88);
        nVar.a(8);
        int i3 = 0;
        for (int i4 = 0; i4 < c2; i4++) {
            if (nVar.b()) {
                i3 += 89;
            }
            if (nVar.b()) {
                i3 += 8;
            }
        }
        nVar.a(i3);
        if (c2 > 0) {
            nVar.a((8 - c2) * 2);
        }
        nVar.d();
        int d2 = nVar.d();
        if (d2 == 3) {
            nVar.a();
        }
        int d3 = nVar.d();
        int d4 = nVar.d();
        if (nVar.b()) {
            int d5 = nVar.d();
            int d6 = nVar.d();
            int d7 = nVar.d();
            int d8 = nVar.d();
            d3 -= ((d2 == 1 || d2 == 2) ? 2 : 1) * (d5 + d6);
            d4 -= (d2 == 1 ? 2 : 1) * (d7 + d8);
        }
        int i5 = d3;
        int i6 = d4;
        nVar.d();
        nVar.d();
        int d9 = nVar.d();
        int i7 = nVar.b() ? 0 : c2;
        while (true) {
            nVar.d();
            nVar.d();
            nVar.d();
            if (i7 > c2) {
                break;
            }
            i7++;
        }
        nVar.d();
        nVar.d();
        nVar.d();
        if (nVar.b() && nVar.b()) {
            a(nVar);
        }
        nVar.a(2);
        if (nVar.b()) {
            nVar.a(8);
            nVar.d();
            nVar.d();
            nVar.a();
        }
        b(nVar);
        if (nVar.b()) {
            for (int i8 = 0; i8 < nVar.d(); i8++) {
                nVar.a(d9 + 4 + 1);
            }
        }
        nVar.a(2);
        if (nVar.b() && nVar.b()) {
            int c3 = nVar.c(8);
            if (c3 == 255) {
                int c4 = nVar.c(16);
                int c5 = nVar.c(16);
                if (c4 != 0 && c5 != 0) {
                    f2 = c4 / c5;
                }
            } else {
                float[] fArr = com.opos.exoplayer.core.i.k.f19028b;
                if (c3 < fArr.length) {
                    f2 = fArr[c3];
                } else {
                    com.opos.cmn.an.f.a.c("H265Reader", "Unexpected aspect_ratio_idc value: " + c3);
                }
            }
            return Format.a(str, "video/hevc", (String) null, -1, -1, i5, i6, -1.0f, (List<byte[]>) Collections.singletonList(bArr), -1, f2, (DrmInitData) null);
        }
        f2 = 1.0f;
        return Format.a(str, "video/hevc", (String) null, -1, -1, i5, i6, -1.0f, (List<byte[]>) Collections.singletonList(bArr), -1, f2, (DrmInitData) null);
    }

    private void a(long j2, int i2, int i3, long j3) {
        if (this.f18180e) {
            this.f18179d.a(j2, i2, i3, j3);
        } else {
            this.f18182g.a(i3);
            this.f18183h.a(i3);
            this.f18184i.a(i3);
        }
        this.f18185j.a(i3);
        this.k.a(i3);
    }

    private static void a(com.opos.exoplayer.core.i.n nVar) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = 0;
            while (i3 < 6) {
                int i4 = 1;
                if (nVar.b()) {
                    int min = Math.min(64, 1 << ((i2 << 1) + 4));
                    if (i2 > 1) {
                        nVar.e();
                    }
                    for (int i5 = 0; i5 < min; i5++) {
                        nVar.e();
                    }
                } else {
                    nVar.d();
                }
                if (i2 == 3) {
                    i4 = 3;
                }
                i3 += i4;
            }
        }
    }

    private void a(byte[] bArr, int i2, int i3) {
        if (this.f18180e) {
            this.f18179d.a(bArr, i2, i3);
        } else {
            this.f18182g.a(bArr, i2, i3);
            this.f18183h.a(bArr, i2, i3);
            this.f18184i.a(bArr, i2, i3);
        }
        this.f18185j.a(bArr, i2, i3);
        this.k.a(bArr, i2, i3);
    }

    private void b(long j2, int i2, int i3, long j3) {
        if (this.f18180e) {
            this.f18179d.a(j2, i2);
        } else {
            this.f18182g.b(i3);
            this.f18183h.b(i3);
            this.f18184i.b(i3);
            if (this.f18182g.b() && this.f18183h.b() && this.f18184i.b()) {
                this.f18178c.a(a(this.f18177b, this.f18182g, this.f18183h, this.f18184i));
                this.f18180e = true;
            }
        }
        if (this.f18185j.b(i3)) {
            v vVar = this.f18185j;
            this.n.a(this.f18185j.f18286a, com.opos.exoplayer.core.i.k.a(vVar.f18286a, vVar.f18287b));
            this.n.d(5);
            this.f18176a.a(j3, this.n);
        }
        if (this.k.b(i3)) {
            v vVar2 = this.k;
            this.n.a(this.k.f18286a, com.opos.exoplayer.core.i.k.a(vVar2.f18286a, vVar2.f18287b));
            this.n.d(5);
            this.f18176a.a(j3, this.n);
        }
    }

    private static void b(com.opos.exoplayer.core.i.n nVar) {
        int d2 = nVar.d();
        boolean z = false;
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            if (i3 != 0) {
                z = nVar.b();
            }
            if (z) {
                nVar.a();
                nVar.d();
                for (int i4 = 0; i4 <= i2; i4++) {
                    if (nVar.b()) {
                        nVar.a();
                    }
                }
            } else {
                int d3 = nVar.d();
                int d4 = nVar.d();
                int i5 = d3 + d4;
                for (int i6 = 0; i6 < d3; i6++) {
                    nVar.d();
                    nVar.a();
                }
                for (int i7 = 0; i7 < d4; i7++) {
                    nVar.d();
                    nVar.a();
                }
                i2 = i5;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        com.opos.exoplayer.core.i.k.a(this.f18181f);
        this.f18182g.a();
        this.f18183h.a();
        this.f18184i.a();
        this.f18185j.a();
        this.k.a();
        this.f18179d.a();
        this.l = 0L;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j2, boolean z) {
        this.m = j2;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.f18177b = dVar.c();
        com.opos.exoplayer.core.c.n a2 = gVar.a(dVar.b(), 2);
        this.f18178c = a2;
        this.f18179d = new a(a2);
        this.f18176a.a(gVar, dVar);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        while (mVar.b() > 0) {
            int d2 = mVar.d();
            int c2 = mVar.c();
            byte[] bArr = mVar.f19048a;
            this.l += mVar.b();
            this.f18178c.a(mVar, mVar.b());
            while (d2 < c2) {
                int a2 = com.opos.exoplayer.core.i.k.a(bArr, d2, c2, this.f18181f);
                if (a2 == c2) {
                    a(bArr, d2, c2);
                    return;
                }
                int c3 = com.opos.exoplayer.core.i.k.c(bArr, a2);
                int i2 = a2 - d2;
                if (i2 > 0) {
                    a(bArr, d2, a2);
                }
                int i3 = c2 - a2;
                long j2 = this.l - i3;
                b(j2, i3, i2 < 0 ? -i2 : 0, this.m);
                a(j2, i3, c3, this.m);
                d2 = a2 + 3;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
