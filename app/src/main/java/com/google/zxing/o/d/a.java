package com.google.zxing.o.d;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.b;
import com.google.zxing.common.h;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.common.reedsolomon.c;
import com.google.zxing.l;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private static final int[] f8461a = {3808, 476, 2107, 1799};

    /* renamed from: b */
    private final b f8462b;

    /* renamed from: c */
    private boolean f8463c;

    /* renamed from: d */
    private int f8464d;

    /* renamed from: e */
    private int f8465e;

    /* renamed from: f */
    private int f8466f;

    /* renamed from: g */
    private int f8467g;

    /* renamed from: com.google.zxing.o.d.a$a */
    static final class C0112a {

        /* renamed from: a */
        private final int f8468a;

        /* renamed from: b */
        private final int f8469b;

        C0112a(int i2, int i3) {
            this.f8468a = i2;
            this.f8469b = i3;
        }

        int a() {
            return this.f8468a;
        }

        int b() {
            return this.f8469b;
        }

        l c() {
            return new l(a(), b());
        }

        public String toString() {
            return "<" + this.f8468a + ' ' + this.f8469b + Typography.greater;
        }
    }

    public a(b bVar) {
        this.f8462b = bVar;
    }

    private static float c(l lVar, l lVar2) {
        return com.google.zxing.common.l.a.a(lVar.c(), lVar.d(), lVar2.c(), lVar2.d());
    }

    private static float d(C0112a c0112a, C0112a c0112a2) {
        return com.google.zxing.common.l.a.b(c0112a.a(), c0112a.b(), c0112a2.a(), c0112a2.b());
    }

    private static l[] e(l[] lVarArr, float f2, float f3) {
        float f4 = f3 / (f2 * 2.0f);
        float c2 = lVarArr[0].c() - lVarArr[2].c();
        float d2 = lVarArr[0].d() - lVarArr[2].d();
        float c3 = (lVarArr[0].c() + lVarArr[2].c()) / 2.0f;
        float d3 = (lVarArr[0].d() + lVarArr[2].d()) / 2.0f;
        float f5 = c2 * f4;
        float f6 = d2 * f4;
        l lVar = new l(c3 + f5, d3 + f6);
        l lVar2 = new l(c3 - f5, d3 - f6);
        float c4 = lVarArr[1].c() - lVarArr[3].c();
        float d4 = lVarArr[1].d() - lVarArr[3].d();
        float c5 = (lVarArr[1].c() + lVarArr[3].c()) / 2.0f;
        float d5 = (lVarArr[1].d() + lVarArr[3].d()) / 2.0f;
        float f7 = c4 * f4;
        float f8 = f4 * d4;
        return new l[]{lVar, new l(c5 + f7, d5 + f8), lVar2, new l(c5 - f7, d5 - f8)};
    }

    private void f(l[] lVarArr) throws NotFoundException {
        long j2;
        long j3;
        if (!p(lVarArr[0]) || !p(lVarArr[1]) || !p(lVarArr[2]) || !p(lVarArr[3])) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i2 = this.f8466f * 2;
        int[] iArr = {s(lVarArr[0], lVarArr[1], i2), s(lVarArr[1], lVarArr[2], i2), s(lVarArr[2], lVarArr[3], i2), s(lVarArr[3], lVarArr[0], i2)};
        this.f8467g = n(iArr, i2);
        long j4 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = iArr[(this.f8467g + i3) % 4];
            if (this.f8463c) {
                j2 = j4 << 7;
                j3 = (i4 >> 1) & 127;
            } else {
                j2 = j4 << 10;
                j3 = ((i4 >> 2) & 992) + ((i4 >> 1) & 31);
            }
            j4 = j2 + j3;
        }
        int i5 = i(j4, this.f8463c);
        if (this.f8463c) {
            this.f8464d = (i5 >> 6) + 1;
            this.f8465e = (i5 & 63) + 1;
        } else {
            this.f8464d = (i5 >> 11) + 1;
            this.f8465e = (i5 & 2047) + 1;
        }
    }

    private l[] g(C0112a c0112a) throws NotFoundException {
        this.f8466f = 1;
        C0112a c0112a2 = c0112a;
        C0112a c0112a3 = c0112a2;
        C0112a c0112a4 = c0112a3;
        C0112a c0112a5 = c0112a4;
        boolean z = true;
        while (this.f8466f < 9) {
            C0112a k = k(c0112a2, z, 1, -1);
            C0112a k2 = k(c0112a3, z, 1, 1);
            C0112a k3 = k(c0112a4, z, -1, 1);
            C0112a k4 = k(c0112a5, z, -1, -1);
            if (this.f8466f > 2) {
                double d2 = (d(k4, k) * this.f8466f) / (d(c0112a5, c0112a2) * (this.f8466f + 2));
                if (d2 < 0.75d || d2 > 1.25d || !q(k, k2, k3, k4)) {
                    break;
                }
            }
            z = !z;
            this.f8466f++;
            c0112a5 = k4;
            c0112a2 = k;
            c0112a3 = k2;
            c0112a4 = k3;
        }
        int i2 = this.f8466f;
        if (i2 != 5 && i2 != 7) {
            throw NotFoundException.getNotFoundInstance();
        }
        this.f8463c = i2 == 5;
        l[] lVarArr = {new l(c0112a2.a() + 0.5f, c0112a2.b() - 0.5f), new l(c0112a3.a() + 0.5f, c0112a3.b() + 0.5f), new l(c0112a4.a() - 0.5f, c0112a4.b() + 0.5f), new l(c0112a5.a() - 0.5f, c0112a5.b() - 0.5f)};
        int i3 = this.f8466f;
        return e(lVarArr, (i3 * 2) - 3, i3 * 2);
    }

    private int h(C0112a c0112a, C0112a c0112a2) {
        float d2 = d(c0112a, c0112a2);
        float a2 = (c0112a2.a() - c0112a.a()) / d2;
        float b2 = (c0112a2.b() - c0112a.b()) / d2;
        float a3 = c0112a.a();
        float b3 = c0112a.b();
        boolean e2 = this.f8462b.e(c0112a.a(), c0112a.b());
        int ceil = (int) Math.ceil(d2);
        int i2 = 0;
        for (int i3 = 0; i3 < ceil; i3++) {
            a3 += a2;
            b3 += b2;
            if (this.f8462b.e(com.google.zxing.common.l.a.c(a3), com.google.zxing.common.l.a.c(b3)) != e2) {
                i2++;
            }
        }
        float f2 = i2 / d2;
        if (f2 <= 0.1f || f2 >= 0.9f) {
            return (f2 <= 0.1f) == e2 ? 1 : -1;
        }
        return 0;
    }

    private static int i(long j2, boolean z) throws NotFoundException {
        int i2;
        int i3;
        if (z) {
            i2 = 7;
            i3 = 2;
        } else {
            i2 = 10;
            i3 = 4;
        }
        int i4 = i2 - i3;
        int[] iArr = new int[i2];
        for (int i5 = i2 - 1; i5 >= 0; i5--) {
            iArr[i5] = ((int) j2) & 15;
            j2 >>= 4;
        }
        try {
            new c(com.google.zxing.common.reedsolomon.a.f8347d).a(iArr, i4);
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                i6 = (i6 << 4) + iArr[i7];
            }
            return i6;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private int j() {
        if (this.f8463c) {
            return (this.f8464d * 4) + 11;
        }
        int i2 = this.f8464d;
        return i2 <= 4 ? (i2 * 4) + 15 : (i2 * 4) + ((((i2 - 4) / 8) + 1) * 2) + 15;
    }

    private C0112a k(C0112a c0112a, boolean z, int i2, int i3) {
        int a2 = c0112a.a() + i2;
        int b2 = c0112a.b();
        while (true) {
            b2 += i3;
            if (!o(a2, b2) || this.f8462b.e(a2, b2) != z) {
                break;
            }
            a2 += i2;
        }
        int i4 = a2 - i2;
        int i5 = b2 - i3;
        while (o(i4, i5) && this.f8462b.e(i4, i5) == z) {
            i4 += i2;
        }
        int i6 = i4 - i2;
        while (o(i6, i5) && this.f8462b.e(i6, i5) == z) {
            i5 += i3;
        }
        return new C0112a(i6, i5 - i3);
    }

    private C0112a l() {
        l c2;
        l lVar;
        l lVar2;
        l lVar3;
        l c3;
        l c4;
        l c5;
        l c6;
        try {
            l[] c7 = new com.google.zxing.common.l.c(this.f8462b).c();
            lVar2 = c7[0];
            lVar3 = c7[1];
            lVar = c7[2];
            c2 = c7[3];
        } catch (NotFoundException unused) {
            int l = this.f8462b.l() / 2;
            int h2 = this.f8462b.h() / 2;
            int i2 = l + 7;
            int i3 = h2 - 7;
            l c8 = k(new C0112a(i2, i3), false, 1, -1).c();
            int i4 = h2 + 7;
            l c9 = k(new C0112a(i2, i4), false, 1, 1).c();
            int i5 = l - 7;
            l c10 = k(new C0112a(i5, i4), false, -1, 1).c();
            c2 = k(new C0112a(i5, i3), false, -1, -1).c();
            lVar = c10;
            lVar2 = c8;
            lVar3 = c9;
        }
        int c11 = com.google.zxing.common.l.a.c((((lVar2.c() + c2.c()) + lVar3.c()) + lVar.c()) / 4.0f);
        int c12 = com.google.zxing.common.l.a.c((((lVar2.d() + c2.d()) + lVar3.d()) + lVar.d()) / 4.0f);
        try {
            l[] c13 = new com.google.zxing.common.l.c(this.f8462b, 15, c11, c12).c();
            c3 = c13[0];
            c4 = c13[1];
            c5 = c13[2];
            c6 = c13[3];
        } catch (NotFoundException unused2) {
            int i6 = c11 + 7;
            int i7 = c12 - 7;
            c3 = k(new C0112a(i6, i7), false, 1, -1).c();
            int i8 = c12 + 7;
            c4 = k(new C0112a(i6, i8), false, 1, 1).c();
            int i9 = c11 - 7;
            c5 = k(new C0112a(i9, i8), false, -1, 1).c();
            c6 = k(new C0112a(i9, i7), false, -1, -1).c();
        }
        return new C0112a(com.google.zxing.common.l.a.c((((c3.c() + c6.c()) + c4.c()) + c5.c()) / 4.0f), com.google.zxing.common.l.a.c((((c3.d() + c6.d()) + c4.d()) + c5.d()) / 4.0f));
    }

    private l[] m(l[] lVarArr) {
        return e(lVarArr, this.f8466f * 2, j());
    }

    private static int n(int[] iArr, int i2) throws NotFoundException {
        int i3 = 0;
        for (int i4 : iArr) {
            i3 = (i3 << 3) + ((i4 >> (i2 - 2)) << 1) + (i4 & 1);
        }
        int i5 = ((i3 & 1) << 11) + (i3 >> 1);
        for (int i6 = 0; i6 < 4; i6++) {
            if (Integer.bitCount(f8461a[i6] ^ i5) <= 2) {
                return i6;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private boolean o(int i2, int i3) {
        return i2 >= 0 && i2 < this.f8462b.l() && i3 > 0 && i3 < this.f8462b.h();
    }

    private boolean p(l lVar) {
        return o(com.google.zxing.common.l.a.c(lVar.c()), com.google.zxing.common.l.a.c(lVar.d()));
    }

    private boolean q(C0112a c0112a, C0112a c0112a2, C0112a c0112a3, C0112a c0112a4) {
        C0112a c0112a5 = new C0112a(c0112a.a() - 3, c0112a.b() + 3);
        C0112a c0112a6 = new C0112a(c0112a2.a() - 3, c0112a2.b() - 3);
        C0112a c0112a7 = new C0112a(c0112a3.a() + 3, c0112a3.b() - 3);
        C0112a c0112a8 = new C0112a(c0112a4.a() + 3, c0112a4.b() + 3);
        int h2 = h(c0112a8, c0112a5);
        return h2 != 0 && h(c0112a5, c0112a6) == h2 && h(c0112a6, c0112a7) == h2 && h(c0112a7, c0112a8) == h2;
    }

    private b r(b bVar, l lVar, l lVar2, l lVar3, l lVar4) throws NotFoundException {
        h b2 = h.b();
        int j2 = j();
        float f2 = j2 / 2.0f;
        int i2 = this.f8466f;
        float f3 = f2 - i2;
        float f4 = f2 + i2;
        return b2.c(bVar, j2, j2, f3, f3, f4, f3, f4, f4, f3, f4, lVar.c(), lVar.d(), lVar2.c(), lVar2.d(), lVar3.c(), lVar3.d(), lVar4.c(), lVar4.d());
    }

    private int s(l lVar, l lVar2, int i2) {
        float c2 = c(lVar, lVar2);
        float f2 = c2 / i2;
        float c3 = lVar.c();
        float d2 = lVar.d();
        float c4 = ((lVar2.c() - lVar.c()) * f2) / c2;
        float d3 = (f2 * (lVar2.d() - lVar.d())) / c2;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            float f3 = i4;
            if (this.f8462b.e(com.google.zxing.common.l.a.c((f3 * c4) + c3), com.google.zxing.common.l.a.c((f3 * d3) + d2))) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    public com.google.zxing.o.a a() throws NotFoundException {
        return b(false);
    }

    public com.google.zxing.o.a b(boolean z) throws NotFoundException {
        l[] g2 = g(l());
        if (z) {
            l lVar = g2[0];
            g2[0] = g2[2];
            g2[2] = lVar;
        }
        f(g2);
        b bVar = this.f8462b;
        int i2 = this.f8467g;
        return new com.google.zxing.o.a(r(bVar, g2[i2 % 4], g2[(i2 + 1) % 4], g2[(i2 + 2) % 4], g2[(i2 + 3) % 4]), m(g2), this.f8463c, this.f8465e, this.f8464d);
    }
}
