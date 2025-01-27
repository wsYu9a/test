package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.m0;
import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class c2 implements g0 {

    /* renamed from: e */
    public static final int f27242e = Util.getIntegerCodeForString("ID3");

    /* renamed from: a */
    public final long f27243a;

    /* renamed from: b */
    public final n6 f27244b = new n6(2786);

    /* renamed from: c */
    public d2 f27245c;

    /* renamed from: d */
    public boolean f27246d;

    public c2(long j2) {
        this.f27243a = j2;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(long j2, long j3) {
        this.f27246d = false;
        this.f27245c.a();
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(i0 i0Var) {
        d2 d2Var = new d2(null);
        this.f27245c = d2Var;
        d2Var.f27285d = "0";
        l3 l3Var = (l3) i0Var;
        d2Var.f27286e = l3Var.a(0, 1);
        l3Var.f();
        l3Var.q = new m0.a(C.TIME_UNSET);
        l3Var.n.post(l3Var.l);
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void release() {
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public int a(h0 h0Var, l0 l0Var) {
        int a2 = ((d0) h0Var).a(this.f27244b.f27874a, 0, 2786);
        if (a2 == -1) {
            return -1;
        }
        this.f27244b.d(0);
        this.f27244b.c(a2);
        if (!this.f27246d) {
            this.f27245c.l = this.f27243a;
            this.f27246d = true;
        }
        this.f27245c.a(this.f27244b);
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
    
        r5.f27270e = 0;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
    
        if ((r1 - r3) < 8192) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003e, code lost:
    
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
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.f27874a
            r5 = r11
            com.vivo.google.android.exoplayer3.d0 r5 = (com.vivo.google.android.exoplayer3.d0) r5
            r5.a(r4, r2, r1, r2)
            r0.d(r2)
            int r4 = r0.n()
            int r6 = com.vivo.google.android.exoplayer3.c2.f27242e
            if (r4 == r6) goto L68
            r5.f27270e = r2
            r5.a(r3, r2)
            r1 = r3
        L22:
            r11 = 0
        L23:
            byte[] r4 = r0.f27874a
            r6 = 5
            r5.a(r4, r2, r6, r2)
            r0.d(r2)
            int r4 = r0.q()
            r7 = 2935(0xb77, float:4.113E-42)
            if (r4 == r7) goto L43
            r5.f27270e = r2
            int r1 = r1 + 1
            int r11 = r1 - r3
            r4 = 8192(0x2000, float:1.148E-41)
            if (r11 < r4) goto L3f
            return r2
        L3f:
            r5.a(r1, r2)
            goto L22
        L43:
            r4 = 1
            int r11 = r11 + r4
            r7 = 4
            if (r11 < r7) goto L49
            return r4
        L49:
            byte[] r4 = r0.f27874a
            int r8 = r4.length
            r9 = -1
            if (r8 >= r6) goto L51
            r4 = -1
            goto L5f
        L51:
            r6 = r4[r7]
            r6 = r6 & 192(0xc0, float:2.69E-43)
            int r6 = r6 >> 6
            r4 = r4[r7]
            r4 = r4 & 63
            int r4 = com.vivo.google.android.exoplayer3.i.a(r6, r4)
        L5f:
            if (r4 != r9) goto L62
            return r2
        L62:
            int r4 = r4 + (-5)
            r5.a(r4, r2)
            goto L23
        L68:
            r4 = 3
            r0.e(r4)
            int r4 = r0.k()
            int r6 = r4 + 10
            int r3 = r3 + r6
            r5.a(r4, r2)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.c2.a(com.vivo.google.android.exoplayer3.h0):boolean");
    }
}
