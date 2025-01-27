package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.c.l;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public final class c implements com.opos.exoplayer.core.c.e {

    /* renamed from: a */
    public static final com.opos.exoplayer.core.c.h f18097a = new com.opos.exoplayer.core.c.h() { // from class: com.opos.exoplayer.core.c.f.c.1
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new c()};
        }
    };

    /* renamed from: b */
    private static final int f18098b = com.opos.exoplayer.core.i.u.f("ID3");

    /* renamed from: c */
    private final long f18099c;

    /* renamed from: d */
    private final d f18100d;

    /* renamed from: e */
    private final com.opos.exoplayer.core.i.m f18101e;

    /* renamed from: f */
    private boolean f18102f;

    /* renamed from: com.opos.exoplayer.core.c.f.c$1 */
    static final class AnonymousClass1 implements com.opos.exoplayer.core.c.h {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new c()};
        }
    }

    public c() {
        this(0L);
    }

    public c(long j2) {
        this.f18099c = j2;
        this.f18100d = new d(true);
        this.f18101e = new com.opos.exoplayer.core.i.m(200);
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        int a2 = fVar.a(this.f18101e.f19048a, 0, 200);
        if (a2 == -1) {
            return -1;
        }
        this.f18101e.c(0);
        this.f18101e.b(a2);
        if (!this.f18102f) {
            this.f18100d.a(this.f18099c, true);
            this.f18102f = true;
        }
        this.f18100d.a(this.f18101e);
        return 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j2, long j3) {
        this.f18102f = false;
        this.f18100d.a();
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.f18100d.a(gVar, new u.d(0, 1));
        gVar.a();
        gVar.a(new l.b(C.TIME_UNSET));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
    
        r11.a();
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
    
        if ((r5 - r4) < 8192) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return false;
     */
    @Override // com.opos.exoplayer.core.c.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.opos.exoplayer.core.c.f r11) {
        /*
            r10 = this;
            com.opos.exoplayer.core.i.m r0 = new com.opos.exoplayer.core.i.m
            r1 = 10
            r0.<init>(r1)
            com.opos.exoplayer.core.i.l r2 = new com.opos.exoplayer.core.i.l
            byte[] r3 = r0.f19048a
            r2.<init>(r3)
            r3 = 0
            r4 = 0
        L10:
            byte[] r5 = r0.f19048a
            r11.c(r5, r3, r1)
            r0.c(r3)
            int r5 = r0.k()
            int r6 = com.opos.exoplayer.core.c.f.c.f18098b
            if (r5 == r6) goto L75
            r11.a()
            r11.c(r4)
            r5 = r4
        L27:
            r1 = 0
            r6 = 0
        L29:
            byte[] r7 = r0.f19048a
            r8 = 2
            r11.c(r7, r3, r8)
            r0.c(r3)
            int r7 = r0.h()
            r8 = 65526(0xfff6, float:9.1821E-41)
            r7 = r7 & r8
            r8 = 65520(0xfff0, float:9.1813E-41)
            r9 = 1
            if (r7 == r8) goto L50
            r11.a()
            int r5 = r5 + 1
            int r1 = r5 - r4
            r6 = 8192(0x2000, float:1.148E-41)
            if (r1 < r6) goto L4c
            goto L74
        L4c:
            r11.c(r5)
            goto L27
        L50:
            int r1 = r1 + r9
            r7 = 4
            if (r1 < r7) goto L5a
            r8 = 188(0xbc, float:2.63E-43)
            if (r6 <= r8) goto L5a
            r3 = 1
            goto L74
        L5a:
            byte[] r8 = r0.f19048a
            r11.c(r8, r3, r7)
            r7 = 14
            r2.a(r7)
            r7 = 13
            int r7 = r2.c(r7)
            r8 = 6
            if (r7 <= r8) goto L74
            int r8 = r7 + (-6)
            r11.c(r8)
            int r6 = r6 + r7
            goto L29
        L74:
            return r3
        L75:
            r5 = 3
            r0.d(r5)
            int r5 = r0.t()
            int r6 = r5 + 10
            int r4 = r4 + r6
            r11.c(r5)
            goto L10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.c.a(com.opos.exoplayer.core.c.f):boolean");
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
