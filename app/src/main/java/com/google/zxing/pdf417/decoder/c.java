package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.l;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a */
    private com.google.zxing.common.b f8675a;

    /* renamed from: b */
    private l f8676b;

    /* renamed from: c */
    private l f8677c;

    /* renamed from: d */
    private l f8678d;

    /* renamed from: e */
    private l f8679e;

    /* renamed from: f */
    private int f8680f;

    /* renamed from: g */
    private int f8681g;

    /* renamed from: h */
    private int f8682h;

    /* renamed from: i */
    private int f8683i;

    c(com.google.zxing.common.b bVar, l lVar, l lVar2, l lVar3, l lVar4) throws NotFoundException {
        if ((lVar == null && lVar3 == null) || ((lVar2 == null && lVar4 == null) || ((lVar != null && lVar2 == null) || (lVar3 != null && lVar4 == null)))) {
            throw NotFoundException.getNotFoundInstance();
        }
        k(bVar, lVar, lVar2, lVar3, lVar4);
    }

    private void b() {
        if (this.f8676b == null) {
            this.f8676b = new l(0.0f, this.f8678d.d());
            this.f8677c = new l(0.0f, this.f8679e.d());
        } else if (this.f8678d == null) {
            this.f8678d = new l(this.f8675a.l() - 1, this.f8676b.d());
            this.f8679e = new l(this.f8675a.l() - 1, this.f8677c.d());
        }
        this.f8680f = (int) Math.min(this.f8676b.c(), this.f8677c.c());
        this.f8681g = (int) Math.max(this.f8678d.c(), this.f8679e.c());
        this.f8682h = (int) Math.min(this.f8676b.d(), this.f8678d.d());
        this.f8683i = (int) Math.max(this.f8677c.d(), this.f8679e.d());
    }

    private void k(com.google.zxing.common.b bVar, l lVar, l lVar2, l lVar3, l lVar4) {
        this.f8675a = bVar;
        this.f8676b = lVar;
        this.f8677c = lVar2;
        this.f8678d = lVar3;
        this.f8679e = lVar4;
        b();
    }

    static c l(c cVar, c cVar2) throws NotFoundException {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.f8675a, cVar.f8676b, cVar.f8677c, cVar2.f8678d, cVar2.f8679e);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.google.zxing.pdf417.decoder.c a(int r13, int r14, boolean r15) throws com.google.zxing.NotFoundException {
        /*
            r12 = this;
            com.google.zxing.l r0 = r12.f8676b
            com.google.zxing.l r1 = r12.f8677c
            com.google.zxing.l r2 = r12.f8678d
            com.google.zxing.l r3 = r12.f8679e
            if (r13 <= 0) goto L29
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.d()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            com.google.zxing.l r13 = new com.google.zxing.l
            float r4 = r4.c()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L26
            r8 = r13
            goto L2a
        L26:
            r10 = r13
            r8 = r0
            goto L2b
        L29:
            r8 = r0
        L2a:
            r10 = r2
        L2b:
            if (r14 <= 0) goto L5b
            if (r15 == 0) goto L32
            com.google.zxing.l r13 = r12.f8677c
            goto L34
        L32:
            com.google.zxing.l r13 = r12.f8679e
        L34:
            float r0 = r13.d()
            int r0 = (int) r0
            int r0 = r0 + r14
            com.google.zxing.common.b r14 = r12.f8675a
            int r14 = r14.h()
            if (r0 < r14) goto L4a
            com.google.zxing.common.b r14 = r12.f8675a
            int r14 = r14.h()
            int r0 = r14 + (-1)
        L4a:
            com.google.zxing.l r14 = new com.google.zxing.l
            float r13 = r13.c()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L58
            r9 = r14
            goto L5c
        L58:
            r11 = r14
            r9 = r1
            goto L5d
        L5b:
            r9 = r1
        L5c:
            r11 = r3
        L5d:
            r12.b()
            com.google.zxing.pdf417.decoder.c r13 = new com.google.zxing.pdf417.decoder.c
            com.google.zxing.common.b r7 = r12.f8675a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.c.a(int, int, boolean):com.google.zxing.pdf417.decoder.c");
    }

    l c() {
        return this.f8677c;
    }

    l d() {
        return this.f8679e;
    }

    int e() {
        return this.f8681g;
    }

    int f() {
        return this.f8683i;
    }

    int g() {
        return this.f8680f;
    }

    int h() {
        return this.f8682h;
    }

    l i() {
        return this.f8676b;
    }

    l j() {
        return this.f8678d;
    }

    c(c cVar) {
        k(cVar.f8675a, cVar.f8676b, cVar.f8677c, cVar.f8678d, cVar.f8679e);
    }
}
