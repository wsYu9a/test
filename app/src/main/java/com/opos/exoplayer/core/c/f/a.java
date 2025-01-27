package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.c.l;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public final class a implements com.opos.exoplayer.core.c.e {

    /* renamed from: a */
    public static final com.opos.exoplayer.core.c.h f18081a = new com.opos.exoplayer.core.c.h() { // from class: com.opos.exoplayer.core.c.f.a.1
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new a()};
        }
    };

    /* renamed from: b */
    private static final int f18082b = com.opos.exoplayer.core.i.u.f("ID3");

    /* renamed from: c */
    private final long f18083c;

    /* renamed from: d */
    private final b f18084d;

    /* renamed from: e */
    private final com.opos.exoplayer.core.i.m f18085e;

    /* renamed from: f */
    private boolean f18086f;

    /* renamed from: com.opos.exoplayer.core.c.f.a$1 */
    static final class AnonymousClass1 implements com.opos.exoplayer.core.c.h {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new a()};
        }
    }

    public a() {
        this(0L);
    }

    public a(long j2) {
        this.f18083c = j2;
        this.f18084d = new b();
        this.f18085e = new com.opos.exoplayer.core.i.m(2786);
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        int a2 = fVar.a(this.f18085e.f19048a, 0, 2786);
        if (a2 == -1) {
            return -1;
        }
        this.f18085e.c(0);
        this.f18085e.b(a2);
        if (!this.f18086f) {
            this.f18084d.a(this.f18083c, true);
            this.f18086f = true;
        }
        this.f18084d.a(this.f18085e);
        return 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j2, long j3) {
        this.f18086f = false;
        this.f18084d.a();
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.f18084d.a(gVar, new u.d(0, 1));
        gVar.a();
        gVar.a(new l.b(C.TIME_UNSET));
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
    
        r9.a();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
    
        if ((r4 - r3) < 8192) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return false;
     */
    @Override // com.opos.exoplayer.core.c.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.opos.exoplayer.core.c.f r9) {
        /*
            r8 = this;
            com.opos.exoplayer.core.i.m r0 = new com.opos.exoplayer.core.i.m
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.f19048a
            r9.c(r4, r2, r1)
            r0.c(r2)
            int r4 = r0.k()
            int r5 = com.opos.exoplayer.core.c.f.a.f18082b
            if (r4 == r5) goto L59
            r9.a()
            r9.c(r3)
            r4 = r3
        L20:
            r1 = 0
        L21:
            byte[] r5 = r0.f19048a
            r6 = 5
            r9.c(r5, r2, r6)
            r0.c(r2)
            int r5 = r0.h()
            r6 = 2935(0xb77, float:4.113E-42)
            r7 = 1
            if (r5 == r6) goto L43
            r9.a()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.148E-41)
            if (r1 < r5) goto L3f
            goto L58
        L3f:
            r9.c(r4)
            goto L20
        L43:
            int r1 = r1 + r7
            r5 = 4
            if (r1 < r5) goto L49
            r2 = 1
            goto L58
        L49:
            byte[] r5 = r0.f19048a
            int r5 = com.opos.exoplayer.core.a.a.a(r5)
            r6 = -1
            if (r5 == r6) goto L58
            int r5 = r5 + (-5)
            r9.c(r5)
            goto L21
        L58:
            return r2
        L59:
            r4 = 3
            r0.d(r4)
            int r4 = r0.t()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r9.c(r4)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.a.a(com.opos.exoplayer.core.c.f):boolean");
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
