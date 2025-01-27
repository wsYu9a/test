package o6;

import com.google.zxing.NotFoundException;
import t5.l;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a */
    public z5.b f29071a;

    /* renamed from: b */
    public l f29072b;

    /* renamed from: c */
    public l f29073c;

    /* renamed from: d */
    public l f29074d;

    /* renamed from: e */
    public l f29075e;

    /* renamed from: f */
    public int f29076f;

    /* renamed from: g */
    public int f29077g;

    /* renamed from: h */
    public int f29078h;

    /* renamed from: i */
    public int f29079i;

    public c(z5.b bVar, l lVar, l lVar2, l lVar3, l lVar4) throws NotFoundException {
        if ((lVar == null && lVar3 == null) || ((lVar2 == null && lVar4 == null) || ((lVar != null && lVar2 == null) || (lVar3 != null && lVar4 == null)))) {
            throw NotFoundException.getNotFoundInstance();
        }
        k(bVar, lVar, lVar2, lVar3, lVar4);
    }

    public static c l(c cVar, c cVar2) throws NotFoundException {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.f29071a, cVar.f29072b, cVar.f29073c, cVar2.f29074d, cVar2.f29075e);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public o6.c a(int r13, int r14, boolean r15) throws com.google.zxing.NotFoundException {
        /*
            r12 = this;
            t5.l r0 = r12.f29072b
            t5.l r1 = r12.f29073c
            t5.l r2 = r12.f29074d
            t5.l r3 = r12.f29075e
            if (r13 <= 0) goto L2a
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
            t5.l r13 = new t5.l
            float r4 = r4.c()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L27
            r8 = r13
        L25:
            r10 = r2
            goto L2c
        L27:
            r10 = r13
            r8 = r0
            goto L2c
        L2a:
            r8 = r0
            goto L25
        L2c:
            if (r14 <= 0) goto L5d
            if (r15 == 0) goto L33
            t5.l r13 = r12.f29073c
            goto L35
        L33:
            t5.l r13 = r12.f29075e
        L35:
            float r0 = r13.d()
            int r0 = (int) r0
            int r0 = r0 + r14
            z5.b r14 = r12.f29071a
            int r14 = r14.h()
            if (r0 < r14) goto L4b
            z5.b r14 = r12.f29071a
            int r14 = r14.h()
            int r0 = r14 + (-1)
        L4b:
            t5.l r14 = new t5.l
            float r13 = r13.c()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L5a
            r9 = r14
        L58:
            r11 = r3
            goto L5f
        L5a:
            r11 = r14
            r9 = r1
            goto L5f
        L5d:
            r9 = r1
            goto L58
        L5f:
            r12.b()
            o6.c r13 = new o6.c
            z5.b r7 = r12.f29071a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: o6.c.a(int, int, boolean):o6.c");
    }

    public final void b() {
        if (this.f29072b == null) {
            this.f29072b = new l(0.0f, this.f29074d.d());
            this.f29073c = new l(0.0f, this.f29075e.d());
        } else if (this.f29074d == null) {
            this.f29074d = new l(this.f29071a.l() - 1, this.f29072b.d());
            this.f29075e = new l(this.f29071a.l() - 1, this.f29073c.d());
        }
        this.f29076f = (int) Math.min(this.f29072b.c(), this.f29073c.c());
        this.f29077g = (int) Math.max(this.f29074d.c(), this.f29075e.c());
        this.f29078h = (int) Math.min(this.f29072b.d(), this.f29074d.d());
        this.f29079i = (int) Math.max(this.f29073c.d(), this.f29075e.d());
    }

    public l c() {
        return this.f29073c;
    }

    public l d() {
        return this.f29075e;
    }

    public int e() {
        return this.f29077g;
    }

    public int f() {
        return this.f29079i;
    }

    public int g() {
        return this.f29076f;
    }

    public int h() {
        return this.f29078h;
    }

    public l i() {
        return this.f29072b;
    }

    public l j() {
        return this.f29074d;
    }

    public final void k(z5.b bVar, l lVar, l lVar2, l lVar3, l lVar4) {
        this.f29071a = bVar;
        this.f29072b = lVar;
        this.f29073c = lVar2;
        this.f29074d = lVar3;
        this.f29075e = lVar4;
        b();
    }

    public c(c cVar) {
        k(cVar.f29071a, cVar.f29072b, cVar.f29073c, cVar.f29074d, cVar.f29075e);
    }
}
