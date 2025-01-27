package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.c.f.u;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public final class o implements u {

    /* renamed from: a */
    private final h f18222a;

    /* renamed from: b */
    private final com.opos.exoplayer.core.i.l f18223b = new com.opos.exoplayer.core.i.l(new byte[10]);

    /* renamed from: c */
    private int f18224c = 0;

    /* renamed from: d */
    private int f18225d;

    /* renamed from: e */
    private com.opos.exoplayer.core.i.s f18226e;

    /* renamed from: f */
    private boolean f18227f;

    /* renamed from: g */
    private boolean f18228g;

    /* renamed from: h */
    private boolean f18229h;

    /* renamed from: i */
    private int f18230i;

    /* renamed from: j */
    private int f18231j;
    private boolean k;
    private long l;

    public o(h hVar) {
        this.f18222a = hVar;
    }

    private void a(int i2) {
        this.f18224c = i2;
        this.f18225d = 0;
    }

    private boolean a(com.opos.exoplayer.core.i.m mVar, byte[] bArr, int i2) {
        int min = Math.min(mVar.b(), i2 - this.f18225d);
        if (min > 0) {
            if (bArr == null) {
                mVar.d(min);
            } else {
                mVar.a(bArr, this.f18225d, min);
            }
            int i3 = min + this.f18225d;
            this.f18225d = i3;
            if (i3 != i2) {
                return false;
            }
        }
        return true;
    }

    private boolean b() {
        this.f18223b.a(0);
        int c2 = this.f18223b.c(24);
        if (c2 != 1) {
            com.opos.cmn.an.f.a.c("PesReader", "Unexpected start code prefix: " + c2);
            this.f18231j = -1;
            return false;
        }
        this.f18223b.b(8);
        int c3 = this.f18223b.c(16);
        this.f18223b.b(5);
        this.k = this.f18223b.e();
        this.f18223b.b(2);
        this.f18227f = this.f18223b.e();
        this.f18228g = this.f18223b.e();
        this.f18223b.b(6);
        int c4 = this.f18223b.c(8);
        this.f18230i = c4;
        if (c3 == 0) {
            this.f18231j = -1;
        } else {
            this.f18231j = ((c3 + 6) - 9) - c4;
        }
        return true;
    }

    private void c() {
        char c2;
        this.f18223b.a(0);
        this.l = C.TIME_UNSET;
        if (this.f18227f) {
            this.f18223b.b(4);
            long c3 = this.f18223b.c(3);
            this.f18223b.b(1);
            long c4 = this.f18223b.c(15) << 15;
            this.f18223b.b(1);
            long c5 = this.f18223b.c(15);
            this.f18223b.b(1);
            if (this.f18229h || !this.f18228g) {
                c2 = 30;
            } else {
                this.f18223b.b(4);
                long c6 = this.f18223b.c(3);
                this.f18223b.b(1);
                long c7 = this.f18223b.c(15) << 15;
                this.f18223b.b(1);
                long c8 = this.f18223b.c(15);
                this.f18223b.b(1);
                c2 = 30;
                this.f18226e.b((c6 << 30) | c7 | c8);
                this.f18229h = true;
            }
            this.l = this.f18226e.b((c3 << c2) | c4 | c5);
        }
    }

    @Override // com.opos.exoplayer.core.c.f.u
    public final void a() {
        this.f18224c = 0;
        this.f18225d = 0;
        this.f18229h = false;
        this.f18222a.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x006b -> B:9:0x006d). Please report as a decompilation issue!!! */
    @Override // com.opos.exoplayer.core.c.f.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.opos.exoplayer.core.i.m r8, boolean r9) {
        /*
            r7 = this;
            r0 = -1
            r1 = 1
            r2 = 3
            r3 = 2
            if (r9 == 0) goto L37
            int r9 = r7.f18224c
            java.lang.String r4 = "PesReader"
            if (r9 == r3) goto L2f
            if (r9 == r2) goto Lf
            goto L34
        Lf:
            int r9 = r7.f18231j
            if (r9 == r0) goto L6d
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r5 = "Unexpected start indicator: expected "
            r9.append(r5)
            int r5 = r7.f18231j
            r9.append(r5)
            java.lang.String r5 = " more bytes"
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            com.opos.cmn.an.f.a.c(r4, r9)
            goto L6d
        L2f:
            java.lang.String r9 = "Unexpected start indicator reading extended header"
            com.opos.cmn.an.f.a.c(r4, r9)
        L34:
            r7.a(r1)
        L37:
            int r9 = r8.b()
            if (r9 <= 0) goto Lbe
            int r9 = r7.f18224c
            if (r9 == 0) goto Lb5
            r4 = 0
            if (r9 == r1) goto L9e
            if (r9 == r3) goto L73
            if (r9 == r2) goto L49
            goto L37
        L49:
            int r9 = r8.b()
            int r5 = r7.f18231j
            if (r5 != r0) goto L52
            goto L54
        L52:
            int r4 = r9 - r5
        L54:
            if (r4 <= 0) goto L5f
            int r9 = r9 - r4
            int r4 = r8.d()
            int r4 = r4 + r9
            r8.b(r4)
        L5f:
            com.opos.exoplayer.core.c.f.h r4 = r7.f18222a
            r4.a(r8)
            int r4 = r7.f18231j
            if (r4 == r0) goto L37
            int r4 = r4 - r9
            r7.f18231j = r4
            if (r4 != 0) goto L37
        L6d:
            com.opos.exoplayer.core.c.f.h r9 = r7.f18222a
            r9.b()
            goto L34
        L73:
            r9 = 10
            int r4 = r7.f18230i
            int r9 = java.lang.Math.min(r9, r4)
            com.opos.exoplayer.core.i.l r4 = r7.f18223b
            byte[] r4 = r4.f19044a
            boolean r9 = r7.a(r8, r4, r9)
            if (r9 == 0) goto L37
            r9 = 0
            int r4 = r7.f18230i
            boolean r9 = r7.a(r8, r9, r4)
            if (r9 == 0) goto L37
            r7.c()
            com.opos.exoplayer.core.c.f.h r9 = r7.f18222a
            long r4 = r7.l
            boolean r6 = r7.k
            r9.a(r4, r6)
            r7.a(r2)
            goto L37
        L9e:
            com.opos.exoplayer.core.i.l r9 = r7.f18223b
            byte[] r9 = r9.f19044a
            r5 = 9
            boolean r9 = r7.a(r8, r9, r5)
            if (r9 == 0) goto L37
            boolean r9 = r7.b()
            if (r9 == 0) goto Lb1
            r4 = 2
        Lb1:
            r7.a(r4)
            goto L37
        Lb5:
            int r9 = r8.b()
            r8.d(r9)
            goto L37
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.o.a(com.opos.exoplayer.core.i.m, boolean):void");
    }

    @Override // com.opos.exoplayer.core.c.f.u
    public void a(com.opos.exoplayer.core.i.s sVar, com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        this.f18226e = sVar;
        this.f18222a.a(gVar, dVar);
    }
}
