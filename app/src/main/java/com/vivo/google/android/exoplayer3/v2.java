package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.x2;

/* loaded from: classes4.dex */
public final class v2 implements s2 {

    /* renamed from: a */
    public u6 f28149a;

    /* renamed from: b */
    public n0 f28150b;

    /* renamed from: c */
    public boolean f28151c;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
    
        if (r4 != Long.MAX_VALUE) goto L30;
     */
    @Override // com.vivo.google.android.exoplayer3.s2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.vivo.google.android.exoplayer3.n6 r11) {
        /*
            r10 = this;
            boolean r0 = r10.f28151c
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 != 0) goto L29
            com.vivo.google.android.exoplayer3.u6 r0 = r10.f28149a
            long r3 = r0.a()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L14
            return
        L14:
            com.vivo.google.android.exoplayer3.n0 r0 = r10.f28150b
            com.vivo.google.android.exoplayer3.u6 r3 = r10.f28149a
            long r3 = r3.a()
            r5 = 0
            java.lang.String r6 = "application/x-scte35"
            com.vivo.google.android.exoplayer3.Format r3 = com.vivo.google.android.exoplayer3.Format.createSampleFormat(r5, r6, r3)
            r0.a(r3)
            r0 = 1
            r10.f28151c = r0
        L29:
            int r7 = r11.a()
            com.vivo.google.android.exoplayer3.n0 r0 = r10.f28150b
            r0.a(r11, r7)
            com.vivo.google.android.exoplayer3.n0 r3 = r10.f28150b
            com.vivo.google.android.exoplayer3.u6 r11 = r10.f28149a
            long r4 = r11.f28141c
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 == 0) goto L40
            long r1 = r11.f28141c
        L3e:
            r4 = r1
            goto L4b
        L40:
            long r4 = r11.f28139a
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r11 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r11 == 0) goto L3e
        L4b:
            r6 = 1
            r8 = 0
            r9 = 0
            r3.a(r4, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.v2.a(com.vivo.google.android.exoplayer3.n6):void");
    }

    @Override // com.vivo.google.android.exoplayer3.s2
    public void a(u6 u6Var, i0 i0Var, x2.d dVar) {
        this.f28149a = u6Var;
        dVar.a();
        n0 a2 = ((l3) i0Var).a(dVar.c(), 4);
        this.f28150b = a2;
        a2.a(Format.createSampleFormat(dVar.b(), "application/x-scte35", null, -1, null));
    }
}
