package com.opos.exoplayer.core.c.f;

import android.util.Pair;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.vivo.google.android.exoplayer3.C;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class i implements h {

    /* renamed from: c */
    private static final double[] f18131c = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a */
    private String f18132a;

    /* renamed from: b */
    private com.opos.exoplayer.core.c.n f18133b;

    /* renamed from: d */
    private boolean f18134d;

    /* renamed from: e */
    private long f18135e;

    /* renamed from: f */
    private final boolean[] f18136f = new boolean[4];

    /* renamed from: g */
    private final a f18137g = new a(128);

    /* renamed from: h */
    private long f18138h;

    /* renamed from: i */
    private boolean f18139i;

    /* renamed from: j */
    private long f18140j;
    private long k;
    private long l;
    private boolean m;
    private boolean n;

    private static final class a {

        /* renamed from: d */
        private static final byte[] f18141d = {0, 0, 1};

        /* renamed from: a */
        public int f18142a;

        /* renamed from: b */
        public int f18143b;

        /* renamed from: c */
        public byte[] f18144c;

        /* renamed from: e */
        private boolean f18145e;

        public a(int i2) {
            this.f18144c = new byte[i2];
        }

        public void a() {
            this.f18145e = false;
            this.f18142a = 0;
            this.f18143b = 0;
        }

        public void a(byte[] bArr, int i2, int i3) {
            if (this.f18145e) {
                int i4 = i3 - i2;
                byte[] bArr2 = this.f18144c;
                int length = bArr2.length;
                int i5 = this.f18142a;
                if (length < i5 + i4) {
                    this.f18144c = Arrays.copyOf(bArr2, (i5 + i4) * 2);
                }
                System.arraycopy(bArr, i2, this.f18144c, this.f18142a, i4);
                this.f18142a = i4 + this.f18142a;
            }
        }

        public boolean a(int i2, int i3) {
            if (this.f18145e) {
                int i4 = this.f18142a - i3;
                this.f18142a = i4;
                if (this.f18143b != 0 || i2 != 181) {
                    this.f18145e = false;
                    return true;
                }
                this.f18143b = i4;
            } else if (i2 == 179) {
                this.f18145e = true;
            }
            byte[] bArr = f18141d;
            a(bArr, 0, bArr.length);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.util.Pair<com.opos.exoplayer.core.Format, java.lang.Long> a(com.opos.exoplayer.core.c.f.i.a r20, java.lang.String r21) {
        /*
            r0 = r20
            byte[] r1 = r0.f18144c
            int r2 = r0.f18142a
            byte[] r1 = java.util.Arrays.copyOf(r1, r2)
            r2 = 4
            r3 = r1[r2]
            r4 = 5
            r5 = r1[r4]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r6 = 6
            r6 = r1[r6]
            int r7 = r5 >> 4
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << r2
            r13 = r7 | r3
            r3 = r5 & 15
            int r3 = r3 << 8
            r5 = r6 & 255(0xff, float:3.57E-43)
            r14 = r3 | r5
            r3 = 7
            r5 = r1[r3]
            r5 = r5 & 240(0xf0, float:3.36E-43)
            int r5 = r5 >> r2
            r6 = 2
            if (r5 == r6) goto L43
            r6 = 3
            if (r5 == r6) goto L3d
            if (r5 == r2) goto L37
            r2 = 1065353216(0x3f800000, float:1.0)
            r18 = 1065353216(0x3f800000, float:1.0)
            goto L4c
        L37:
            int r2 = r14 * 121
            float r2 = (float) r2
            int r5 = r13 * 100
            goto L48
        L3d:
            int r2 = r14 * 16
            float r2 = (float) r2
            int r5 = r13 * 9
            goto L48
        L43:
            int r2 = r14 * 4
            float r2 = (float) r2
            int r5 = r13 * 3
        L48:
            float r5 = (float) r5
            float r2 = r2 / r5
            r18 = r2
        L4c:
            r10 = 0
            r11 = -1
            r12 = -1
            r15 = -1082130432(0xffffffffbf800000, float:-1.0)
            java.util.List r16 = java.util.Collections.singletonList(r1)
            r17 = -1
            r19 = 0
            java.lang.String r9 = "video/mpeg2"
            r8 = r21
            com.opos.exoplayer.core.Format r2 = com.opos.exoplayer.core.Format.a(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r5 = 0
            r3 = r1[r3]
            r3 = r3 & 15
            int r3 = r3 + (-1)
            if (r3 < 0) goto L98
            double[] r7 = com.opos.exoplayer.core.c.f.i.f18131c
            int r8 = r7.length
            if (r3 >= r8) goto L98
            r5 = r7[r3]
            int r0 = r0.f18143b
            int r0 = r0 + 9
            r3 = r1[r0]
            r3 = r3 & 96
            int r3 = r3 >> r4
            r0 = r1[r0]
            r0 = r0 & 31
            if (r3 == r0) goto L91
            double r3 = (double) r3
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.Double.isNaN(r3)
            double r3 = r3 + r7
            int r0 = r0 + 1
            double r0 = (double) r0
            java.lang.Double.isNaN(r0)
            double r3 = r3 / r0
            double r5 = r5 * r3
        L91:
            r0 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r0 = r0 / r5
            long r5 = (long) r0
        L98:
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            android.util.Pair r0 = android.util.Pair.create(r2, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.i.a(com.opos.exoplayer.core.c.f.i$a, java.lang.String):android.util.Pair");
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        com.opos.exoplayer.core.i.k.a(this.f18136f);
        this.f18137g.a();
        this.f18138h = 0L;
        this.f18139i = false;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j2, boolean z) {
        this.f18140j = j2;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.f18132a = dVar.c();
        this.f18133b = gVar.a(dVar.b(), 2);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        int d2 = mVar.d();
        int c2 = mVar.c();
        byte[] bArr = mVar.f19048a;
        this.f18138h += mVar.b();
        this.f18133b.a(mVar, mVar.b());
        while (true) {
            int a2 = com.opos.exoplayer.core.i.k.a(bArr, d2, c2, this.f18136f);
            if (a2 == c2) {
                break;
            }
            int i2 = a2 + 3;
            int i3 = mVar.f19048a[i2] & 255;
            if (!this.f18134d) {
                int i4 = a2 - d2;
                if (i4 > 0) {
                    this.f18137g.a(bArr, d2, a2);
                }
                if (this.f18137g.a(i3, i4 < 0 ? -i4 : 0)) {
                    Pair<Format, Long> a3 = a(this.f18137g, this.f18132a);
                    this.f18133b.a((Format) a3.first);
                    this.f18135e = ((Long) a3.second).longValue();
                    this.f18134d = true;
                }
            }
            if (i3 == 0 || i3 == 179) {
                int i5 = c2 - a2;
                if (this.f18139i && this.n && this.f18134d) {
                    this.f18133b.a(this.l, this.m ? 1 : 0, ((int) (this.f18138h - this.k)) - i5, i5, null);
                }
                boolean z = this.f18139i;
                if (!z || this.n) {
                    this.k = this.f18138h - i5;
                    long j2 = this.f18140j;
                    if (j2 == C.TIME_UNSET) {
                        j2 = z ? this.l + this.f18135e : 0L;
                    }
                    this.l = j2;
                    this.m = false;
                    this.f18140j = C.TIME_UNSET;
                    this.f18139i = true;
                }
                this.n = i3 == 0;
            } else if (i3 == 184) {
                this.m = true;
            }
            d2 = i2;
        }
        if (this.f18134d) {
            return;
        }
        this.f18137g.a(bArr, d2, c2);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
