package com.opos.exoplayer.core.e;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.e.d;
import com.opos.exoplayer.core.w;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public final class a implements d, d.a {

    /* renamed from: a */
    public final d f18388a;

    /* renamed from: b */
    long f18389b;

    /* renamed from: c */
    long f18390c;

    /* renamed from: d */
    private d.a f18391d;

    /* renamed from: e */
    private C0407a[] f18392e = new C0407a[0];

    /* renamed from: f */
    private long f18393f;

    /* renamed from: com.opos.exoplayer.core.e.a$a */
    private final class C0407a implements i {

        /* renamed from: a */
        public final i f18400a;

        /* renamed from: c */
        private boolean f18402c;

        public C0407a(i iVar) {
            this.f18400a = iVar;
        }

        @Override // com.opos.exoplayer.core.e.i
        public int a(long j2) {
            if (a.this.f()) {
                return -3;
            }
            return this.f18400a.a(a.this.f18389b + j2);
        }

        @Override // com.opos.exoplayer.core.e.i
        public int a(com.opos.exoplayer.core.l lVar, com.opos.exoplayer.core.b.e eVar, boolean z) {
            if (a.this.f()) {
                return -3;
            }
            if (this.f18402c) {
                eVar.a_(4);
            } else {
                int a2 = this.f18400a.a(lVar, eVar, z);
                if (a2 == -5) {
                    Format format = lVar.f19091a;
                    int i2 = format.u;
                    if (i2 == -1 && format.v == -1) {
                        return -5;
                    }
                    a aVar = a.this;
                    if (aVar.f18389b != 0) {
                        i2 = 0;
                    }
                    lVar.f19091a = format.a(i2, aVar.f18390c == Long.MIN_VALUE ? format.v : 0);
                    return -5;
                }
                a aVar2 = a.this;
                long j2 = aVar2.f18390c;
                if (j2 == Long.MIN_VALUE || ((a2 != -4 || eVar.f17740c < j2) && !(a2 == -3 && aVar2.d() == Long.MIN_VALUE))) {
                    if (a2 == -4 && !eVar.c()) {
                        eVar.f17740c -= a.this.f18389b;
                    }
                    return a2;
                }
                eVar.a();
                eVar.a_(4);
                this.f18402c = true;
            }
            return -4;
        }

        public void a() {
            this.f18402c = false;
        }

        @Override // com.opos.exoplayer.core.e.i
        public boolean b() {
            return !a.this.f() && this.f18400a.b();
        }

        @Override // com.opos.exoplayer.core.e.i
        public void c() {
            this.f18400a.c();
        }
    }

    public a(d dVar, boolean z) {
        this.f18388a = dVar;
        this.f18393f = z ? 0L : -9223372036854775807L;
        this.f18389b = C.TIME_UNSET;
        this.f18390c = C.TIME_UNSET;
    }

    private static boolean a(long j2, com.opos.exoplayer.core.g.f[] fVarArr) {
        if (j2 == 0) {
            return false;
        }
        for (com.opos.exoplayer.core.g.f fVar : fVarArr) {
            if (fVar != null && !com.opos.exoplayer.core.i.j.a(fVar.f().f17496f)) {
                return true;
            }
        }
        return false;
    }

    private w b(long j2, w wVar) {
        long min = Math.min(j2 - this.f18389b, wVar.f19284f);
        long j3 = this.f18390c;
        long min2 = j3 == Long.MIN_VALUE ? wVar.f19285g : Math.min(j3 - j2, wVar.f19285g);
        return (min == wVar.f19284f && min2 == wVar.f19285g) ? wVar : new w(min, min2);
    }

    @Override // com.opos.exoplayer.core.e.d
    public long a(long j2, w wVar) {
        long j3 = this.f18389b;
        if (j2 == j3) {
            return 0L;
        }
        long j4 = j3 + j2;
        return this.f18388a.a(j4, b(j4, wVar)) - this.f18389b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
    
        if ((r12.f18389b + r3) > r5) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
    @Override // com.opos.exoplayer.core.e.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(com.opos.exoplayer.core.g.f[] r13, boolean[] r14, com.opos.exoplayer.core.e.i[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            com.opos.exoplayer.core.e.a$a[] r2 = new com.opos.exoplayer.core.e.a.C0407a[r2]
            r0.f18392e = r2
            int r2 = r1.length
            com.opos.exoplayer.core.e.i[] r2 = new com.opos.exoplayer.core.e.i[r2]
            r10 = 0
            r3 = 0
        Lc:
            int r4 = r1.length
            r11 = 0
            if (r3 >= r4) goto L25
            com.opos.exoplayer.core.e.a$a[] r4 = r0.f18392e
            r5 = r1[r3]
            com.opos.exoplayer.core.e.a$a r5 = (com.opos.exoplayer.core.e.a.C0407a) r5
            r4[r3] = r5
            r5 = r4[r3]
            if (r5 == 0) goto L20
            r4 = r4[r3]
            com.opos.exoplayer.core.e.i r11 = r4.f18400a
        L20:
            r2[r3] = r11
            int r3 = r3 + 1
            goto Lc
        L25:
            com.opos.exoplayer.core.e.d r3 = r0.f18388a
            long r4 = r0.f18389b
            long r8 = r17 + r4
            r4 = r13
            r5 = r14
            r6 = r2
            r7 = r16
            long r3 = r3.a(r4, r5, r6, r7, r8)
            long r5 = r0.f18389b
            long r3 = r3 - r5
            boolean r5 = r12.f()
            r6 = 0
            if (r5 == 0) goto L4e
            int r5 = (r17 > r6 ? 1 : (r17 == r6 ? 0 : -1))
            if (r5 != 0) goto L4e
            long r8 = r0.f18389b
            r5 = r13
            boolean r5 = a(r8, r13)
            if (r5 == 0) goto L4e
            r8 = r3
            goto L53
        L4e:
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L53:
            r0.f18393f = r8
            int r5 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r5 == 0) goto L6f
            int r5 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r5 < 0) goto L6d
            long r5 = r0.f18390c
            r7 = -9223372036854775808
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L6f
            long r7 = r0.f18389b
            long r7 = r7 + r3
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 > 0) goto L6d
            goto L6f
        L6d:
            r5 = 0
            goto L70
        L6f:
            r5 = 1
        L70:
            com.opos.exoplayer.core.i.a.b(r5)
        L73:
            int r5 = r1.length
            if (r10 >= r5) goto La1
            r5 = r2[r10]
            if (r5 != 0) goto L7f
            com.opos.exoplayer.core.e.a$a[] r5 = r0.f18392e
            r5[r10] = r11
            goto L98
        L7f:
            r5 = r1[r10]
            if (r5 == 0) goto L8d
            com.opos.exoplayer.core.e.a$a[] r5 = r0.f18392e
            r5 = r5[r10]
            com.opos.exoplayer.core.e.i r5 = r5.f18400a
            r6 = r2[r10]
            if (r5 == r6) goto L98
        L8d:
            com.opos.exoplayer.core.e.a$a[] r5 = r0.f18392e
            com.opos.exoplayer.core.e.a$a r6 = new com.opos.exoplayer.core.e.a$a
            r7 = r2[r10]
            r6.<init>(r7)
            r5[r10] = r6
        L98:
            com.opos.exoplayer.core.e.a$a[] r5 = r0.f18392e
            r5 = r5[r10]
            r1[r10] = r5
            int r10 = r10 + 1
            goto L73
        La1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.e.a.a(com.opos.exoplayer.core.g.f[], boolean[], com.opos.exoplayer.core.e.i[], boolean[], long):long");
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(long j2) {
        this.f18388a.a(this.f18389b + j2);
    }

    public void a(long j2, long j3) {
        this.f18389b = j2;
        this.f18390c = j3;
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(long j2, boolean z) {
        this.f18388a.a(this.f18389b + j2, z);
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(d.a aVar, long j2) {
        this.f18391d = aVar;
        this.f18388a.a(this, this.f18389b + j2);
    }

    @Override // com.opos.exoplayer.core.e.d.a
    public void a(d dVar) {
        com.opos.exoplayer.core.i.a.b((this.f18389b == C.TIME_UNSET || this.f18390c == C.TIME_UNSET) ? false : true);
        this.f18391d.a((d) this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        if (r7 > r0) goto L39;
     */
    @Override // com.opos.exoplayer.core.e.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long b(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.f18393f = r0
            com.opos.exoplayer.core.e.a$a[] r0 = r6.f18392e
            int r1 = r0.length
            r2 = 0
            r3 = 0
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            r4.a()
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            long r0 = r6.f18389b
            long r0 = r0 + r7
            com.opos.exoplayer.core.e.d r7 = r6.f18388a
            long r7 = r7.b(r0)
            int r3 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r3 == 0) goto L37
            long r0 = r6.f18389b
            int r3 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r3 < 0) goto L38
            long r0 = r6.f18390c
            r3 = -9223372036854775808
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 == 0) goto L37
            int r3 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r3 > 0) goto L38
        L37:
            r2 = 1
        L38:
            com.opos.exoplayer.core.i.a.b(r2)
            long r0 = r6.f18389b
            long r7 = r7 - r0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.e.a.b(long):long");
    }

    @Override // com.opos.exoplayer.core.e.d
    public m b() {
        return this.f18388a.b();
    }

    @Override // com.opos.exoplayer.core.e.j.a
    /* renamed from: b */
    public void a(d dVar) {
        this.f18391d.a((d.a) this);
    }

    @Override // com.opos.exoplayer.core.e.d
    public long c() {
        if (f()) {
            long j2 = this.f18393f;
            this.f18393f = C.TIME_UNSET;
            long c2 = c();
            return c2 != C.TIME_UNSET ? c2 : j2;
        }
        long c3 = this.f18388a.c();
        if (c3 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        boolean z = true;
        com.opos.exoplayer.core.i.a.b(c3 >= this.f18389b);
        long j3 = this.f18390c;
        if (j3 != Long.MIN_VALUE && c3 > j3) {
            z = false;
        }
        com.opos.exoplayer.core.i.a.b(z);
        return c3 - this.f18389b;
    }

    @Override // com.opos.exoplayer.core.e.d
    public boolean c(long j2) {
        return this.f18388a.c(this.f18389b + j2);
    }

    @Override // com.opos.exoplayer.core.e.d
    public void c_() {
        this.f18388a.c_();
    }

    @Override // com.opos.exoplayer.core.e.d
    public long d() {
        long d2 = this.f18388a.d();
        if (d2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        long j2 = this.f18390c;
        if (j2 == Long.MIN_VALUE || d2 < j2) {
            return Math.max(0L, d2 - this.f18389b);
        }
        return Long.MIN_VALUE;
    }

    @Override // com.opos.exoplayer.core.e.d
    public long e() {
        long e2 = this.f18388a.e();
        if (e2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        long j2 = this.f18390c;
        if (j2 == Long.MIN_VALUE || e2 < j2) {
            return e2 - this.f18389b;
        }
        return Long.MIN_VALUE;
    }

    boolean f() {
        return this.f18393f != C.TIME_UNSET;
    }
}
