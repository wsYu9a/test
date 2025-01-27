package com.opos.exoplayer.core.e;

import com.opos.exoplayer.core.y;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public final class k extends y {

    /* renamed from: b */
    private static final Object f18504b = new Object();

    /* renamed from: c */
    private final long f18505c;

    /* renamed from: d */
    private final long f18506d;

    /* renamed from: e */
    private final long f18507e;

    /* renamed from: f */
    private final long f18508f;

    /* renamed from: g */
    private final long f18509g;

    /* renamed from: h */
    private final long f18510h;

    /* renamed from: i */
    private final boolean f18511i;

    /* renamed from: j */
    private final boolean f18512j;

    public k(long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2) {
        this.f18505c = j2;
        this.f18506d = j3;
        this.f18507e = j4;
        this.f18508f = j5;
        this.f18509g = j6;
        this.f18510h = j7;
        this.f18511i = z;
        this.f18512j = z2;
    }

    public k(long j2, long j3, long j4, long j5, boolean z, boolean z2) {
        this(C.TIME_UNSET, C.TIME_UNSET, j2, j3, j4, j5, z, z2);
    }

    public k(long j2, boolean z, boolean z2) {
        this(j2, j2, 0L, 0L, z, z2);
    }

    @Override // com.opos.exoplayer.core.y
    public int a(Object obj) {
        return f18504b.equals(obj) ? 0 : -1;
    }

    @Override // com.opos.exoplayer.core.y
    public y.a a(int i2, y.a aVar, boolean z) {
        com.opos.exoplayer.core.i.a.a(i2, 0, 1);
        Object obj = z ? f18504b : null;
        return aVar.a(obj, obj, 0, this.f18507e, -this.f18509g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r1 > r6) goto L31;
     */
    @Override // com.opos.exoplayer.core.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.opos.exoplayer.core.y.b a(int r19, com.opos.exoplayer.core.y.b r20, boolean r21, long r22) {
        /*
            r18 = this;
            r0 = r18
            r1 = 0
            r2 = 1
            r3 = r19
            com.opos.exoplayer.core.i.a.a(r3, r1, r2)
            if (r21 == 0) goto Le
            java.lang.Object r1 = com.opos.exoplayer.core.e.k.f18504b
            goto Lf
        Le:
            r1 = 0
        Lf:
            r3 = r1
            long r1 = r0.f18510h
            boolean r9 = r0.f18512j
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r9 == 0) goto L30
            r6 = 0
            int r8 = (r22 > r6 ? 1 : (r22 == r6 ? 0 : -1))
            if (r8 == 0) goto L30
            long r6 = r0.f18508f
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 != 0) goto L29
        L27:
            r10 = r4
            goto L31
        L29:
            long r1 = r1 + r22
            int r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r8 <= 0) goto L30
            goto L27
        L30:
            r10 = r1
        L31:
            long r4 = r0.f18505c
            long r6 = r0.f18506d
            boolean r8 = r0.f18511i
            long r12 = r0.f18508f
            r14 = 0
            r15 = 0
            long r1 = r0.f18509g
            r16 = r1
            r2 = r20
            com.opos.exoplayer.core.y$b r1 = r2.a(r3, r4, r6, r8, r9, r10, r12, r14, r15, r16)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.e.k.a(int, com.opos.exoplayer.core.y$b, boolean, long):com.opos.exoplayer.core.y$b");
    }

    @Override // com.opos.exoplayer.core.y
    public int b() {
        return 1;
    }

    @Override // com.opos.exoplayer.core.y
    public int c() {
        return 1;
    }
}
