package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.m0;
import com.vivo.google.android.exoplayer3.util.Util;
import com.vivo.google.android.exoplayer3.x2;

/* loaded from: classes4.dex */
public final class e2 implements g0 {

    /* renamed from: e */
    public static final int f27360e = Util.getIntegerCodeForString("ID3");

    /* renamed from: a */
    public final long f27361a;

    /* renamed from: b */
    public final n6 f27362b = new n6(200);

    /* renamed from: c */
    public f2 f27363c;

    /* renamed from: d */
    public boolean f27364d;

    public e2(long j2) {
        this.f27361a = j2;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(i0 i0Var) {
        f2 f2Var = new f2(true, null);
        this.f27363c = f2Var;
        f2Var.a(i0Var, new x2.d(Integer.MIN_VALUE, 0, 1));
        l3 l3Var = (l3) i0Var;
        l3Var.f();
        l3Var.q = new m0.a(C.TIME_UNSET);
        l3Var.n.post(l3Var.l);
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void release() {
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public int a(h0 h0Var, l0 l0Var) {
        int a2 = ((d0) h0Var).a(this.f27362b.f27874a, 0, 200);
        if (a2 == -1) {
            return -1;
        }
        this.f27362b.d(0);
        this.f27362b.c(a2);
        if (!this.f27364d) {
            this.f27363c.o = this.f27361a;
            this.f27364d = true;
        }
        this.f27363c.a(this.f27362b);
        return 0;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(long j2, long j3) {
        this.f27364d = false;
        this.f27363c.c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        r6.f27270e = 0;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        if ((r1 - r4) < 8192) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004c, code lost:
    
        return false;
     */
    @Override // com.vivo.google.android.exoplayer3.g0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.vivo.google.android.exoplayer3.h0 r11) {
        /*
            r10 = this;
            com.vivo.google.android.exoplayer3.n6 r0 = new com.vivo.google.android.exoplayer3.n6
            r1 = 10
            r0.<init>(r1)
            com.vivo.google.android.exoplayer3.m6 r2 = new com.vivo.google.android.exoplayer3.m6
            byte[] r3 = r0.f27874a
            int r4 = r3.length
            r2.<init>(r3, r4)
            r3 = 0
            r4 = 0
        L11:
            byte[] r5 = r0.f27874a
            r6 = r11
            com.vivo.google.android.exoplayer3.d0 r6 = (com.vivo.google.android.exoplayer3.d0) r6
            r6.a(r5, r3, r1, r3)
            r0.d(r3)
            int r5 = r0.n()
            int r7 = com.vivo.google.android.exoplayer3.e2.f27360e
            if (r5 == r7) goto L76
            r6.f27270e = r3
            r6.a(r4, r3)
            r1 = r4
        L2a:
            r11 = 0
            r5 = 0
        L2c:
            byte[] r7 = r0.f27874a
            r8 = 2
            r6.a(r7, r3, r8, r3)
            r0.d(r3)
            int r7 = r0.q()
            r8 = 65526(0xfff6, float:9.1821E-41)
            r7 = r7 & r8
            r8 = 65520(0xfff0, float:9.1813E-41)
            if (r7 == r8) goto L51
            r6.f27270e = r3
            int r1 = r1 + 1
            int r11 = r1 - r4
            r5 = 8192(0x2000, float:1.148E-41)
            if (r11 < r5) goto L4d
            return r3
        L4d:
            r6.a(r1, r3)
            goto L2a
        L51:
            r7 = 1
            int r11 = r11 + r7
            r8 = 4
            if (r11 < r8) goto L5b
            r9 = 188(0xbc, float:2.63E-43)
            if (r5 <= r9) goto L5b
            return r7
        L5b:
            byte[] r7 = r0.f27874a
            r6.a(r7, r3, r8, r3)
            r7 = 14
            r2.b(r7)
            r7 = 13
            int r7 = r2.a(r7)
            r8 = 6
            if (r7 > r8) goto L6f
            return r3
        L6f:
            int r8 = r7 + (-6)
            r6.a(r8, r3)
            int r5 = r5 + r7
            goto L2c
        L76:
            r5 = 3
            r0.e(r5)
            int r5 = r0.k()
            int r7 = r5 + 10
            int r4 = r4 + r7
            r6.a(r5, r3)
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.e2.a(com.vivo.google.android.exoplayer3.h0):boolean");
    }
}
