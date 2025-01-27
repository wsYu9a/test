package v5;

import b6.c;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import kotlin.text.Typography;
import t5.l;
import z5.b;
import z5.h;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: g */
    public static final int[] f31223g = {3808, 476, 2107, 1799};

    /* renamed from: a */
    public final b f31224a;

    /* renamed from: b */
    public boolean f31225b;

    /* renamed from: c */
    public int f31226c;

    /* renamed from: d */
    public int f31227d;

    /* renamed from: e */
    public int f31228e;

    /* renamed from: f */
    public int f31229f;

    /* renamed from: v5.a$a */
    public static final class C0795a {

        /* renamed from: a */
        public final int f31230a;

        /* renamed from: b */
        public final int f31231b;

        public C0795a(int i10, int i11) {
            this.f31230a = i10;
            this.f31231b = i11;
        }

        public int a() {
            return this.f31230a;
        }

        public int b() {
            return this.f31231b;
        }

        public l c() {
            return new l(a(), b());
        }

        public String toString() {
            return "<" + this.f31230a + b5.a.O + this.f31231b + Typography.greater;
        }
    }

    public a(b bVar) {
        this.f31224a = bVar;
    }

    public static float c(l lVar, l lVar2) {
        return a6.a.a(lVar.c(), lVar.d(), lVar2.c(), lVar2.d());
    }

    public static float d(C0795a c0795a, C0795a c0795a2) {
        return a6.a.b(c0795a.a(), c0795a.b(), c0795a2.a(), c0795a2.b());
    }

    public static l[] e(l[] lVarArr, float f10, float f11) {
        float f12 = f11 / (f10 * 2.0f);
        float c10 = lVarArr[0].c() - lVarArr[2].c();
        float d10 = lVarArr[0].d() - lVarArr[2].d();
        float c11 = (lVarArr[0].c() + lVarArr[2].c()) / 2.0f;
        float d11 = (lVarArr[0].d() + lVarArr[2].d()) / 2.0f;
        float f13 = c10 * f12;
        float f14 = d10 * f12;
        l lVar = new l(c11 + f13, d11 + f14);
        l lVar2 = new l(c11 - f13, d11 - f14);
        float c12 = lVarArr[1].c() - lVarArr[3].c();
        float d12 = lVarArr[1].d() - lVarArr[3].d();
        float c13 = (lVarArr[1].c() + lVarArr[3].c()) / 2.0f;
        float d13 = (lVarArr[1].d() + lVarArr[3].d()) / 2.0f;
        float f15 = c12 * f12;
        float f16 = f12 * d12;
        return new l[]{lVar, new l(c13 + f15, d13 + f16), lVar2, new l(c13 - f15, d13 - f16)};
    }

    public static int i(long j10, boolean z10) throws NotFoundException {
        int i10;
        int i11;
        if (z10) {
            i10 = 7;
            i11 = 2;
        } else {
            i10 = 10;
            i11 = 4;
        }
        int i12 = i10 - i11;
        int[] iArr = new int[i10];
        for (int i13 = i10 - 1; i13 >= 0; i13--) {
            iArr[i13] = ((int) j10) & 15;
            j10 >>= 4;
        }
        try {
            new c(b6.a.f1287k).a(iArr, i12);
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                i14 = (i14 << 4) + iArr[i15];
            }
            return i14;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public static int n(int[] iArr, int i10) throws NotFoundException {
        int i11 = 0;
        for (int i12 : iArr) {
            i11 = (i11 << 3) + ((i12 >> (i10 - 2)) << 1) + (i12 & 1);
        }
        int i13 = ((i11 & 1) << 11) + (i11 >> 1);
        for (int i14 = 0; i14 < 4; i14++) {
            if (Integer.bitCount(f31223g[i14] ^ i13) <= 2) {
                return i14;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public u5.a a() throws NotFoundException {
        return b(false);
    }

    public u5.a b(boolean z10) throws NotFoundException {
        l[] g10 = g(l());
        if (z10) {
            l lVar = g10[0];
            g10[0] = g10[2];
            g10[2] = lVar;
        }
        f(g10);
        b bVar = this.f31224a;
        int i10 = this.f31229f;
        return new u5.a(r(bVar, g10[i10 % 4], g10[(i10 + 1) % 4], g10[(i10 + 2) % 4], g10[(i10 + 3) % 4]), m(g10), this.f31225b, this.f31227d, this.f31226c);
    }

    public final void f(l[] lVarArr) throws NotFoundException {
        long j10;
        long j11;
        if (!p(lVarArr[0]) || !p(lVarArr[1]) || !p(lVarArr[2]) || !p(lVarArr[3])) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i10 = this.f31228e * 2;
        int[] iArr = {s(lVarArr[0], lVarArr[1], i10), s(lVarArr[1], lVarArr[2], i10), s(lVarArr[2], lVarArr[3], i10), s(lVarArr[3], lVarArr[0], i10)};
        this.f31229f = n(iArr, i10);
        long j12 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = iArr[(this.f31229f + i11) % 4];
            if (this.f31225b) {
                j10 = j12 << 7;
                j11 = (i12 >> 1) & 127;
            } else {
                j10 = j12 << 10;
                j11 = ((i12 >> 2) & 992) + ((i12 >> 1) & 31);
            }
            j12 = j10 + j11;
        }
        int i13 = i(j12, this.f31225b);
        if (this.f31225b) {
            this.f31226c = (i13 >> 6) + 1;
            this.f31227d = (i13 & 63) + 1;
        } else {
            this.f31226c = (i13 >> 11) + 1;
            this.f31227d = (i13 & 2047) + 1;
        }
    }

    public final l[] g(C0795a c0795a) throws NotFoundException {
        this.f31228e = 1;
        C0795a c0795a2 = c0795a;
        C0795a c0795a3 = c0795a2;
        C0795a c0795a4 = c0795a3;
        C0795a c0795a5 = c0795a4;
        boolean z10 = true;
        while (this.f31228e < 9) {
            C0795a k10 = k(c0795a2, z10, 1, -1);
            C0795a k11 = k(c0795a3, z10, 1, 1);
            C0795a k12 = k(c0795a4, z10, -1, 1);
            C0795a k13 = k(c0795a5, z10, -1, -1);
            if (this.f31228e > 2) {
                double d10 = (d(k13, k10) * this.f31228e) / (d(c0795a5, c0795a2) * (this.f31228e + 2));
                if (d10 < 0.75d || d10 > 1.25d || !q(k10, k11, k12, k13)) {
                    break;
                }
            }
            z10 = !z10;
            this.f31228e++;
            c0795a5 = k13;
            c0795a2 = k10;
            c0795a3 = k11;
            c0795a4 = k12;
        }
        int i10 = this.f31228e;
        if (i10 != 5 && i10 != 7) {
            throw NotFoundException.getNotFoundInstance();
        }
        this.f31225b = i10 == 5;
        l[] lVarArr = {new l(c0795a2.a() + 0.5f, c0795a2.b() - 0.5f), new l(c0795a3.a() + 0.5f, c0795a3.b() + 0.5f), new l(c0795a4.a() - 0.5f, c0795a4.b() + 0.5f), new l(c0795a5.a() - 0.5f, c0795a5.b() - 0.5f)};
        int i11 = this.f31228e;
        return e(lVarArr, (i11 * 2) - 3, i11 * 2);
    }

    public final int h(C0795a c0795a, C0795a c0795a2) {
        float d10 = d(c0795a, c0795a2);
        float a10 = (c0795a2.a() - c0795a.a()) / d10;
        float b10 = (c0795a2.b() - c0795a.b()) / d10;
        float a11 = c0795a.a();
        float b11 = c0795a.b();
        boolean e10 = this.f31224a.e(c0795a.a(), c0795a.b());
        int ceil = (int) Math.ceil(d10);
        int i10 = 0;
        for (int i11 = 0; i11 < ceil; i11++) {
            a11 += a10;
            b11 += b10;
            if (this.f31224a.e(a6.a.c(a11), a6.a.c(b11)) != e10) {
                i10++;
            }
        }
        float f10 = i10 / d10;
        if (f10 <= 0.1f || f10 >= 0.9f) {
            return (f10 <= 0.1f) == e10 ? 1 : -1;
        }
        return 0;
    }

    public final int j() {
        if (this.f31225b) {
            return (this.f31226c * 4) + 11;
        }
        int i10 = this.f31226c;
        return i10 <= 4 ? (i10 * 4) + 15 : (i10 * 4) + ((((i10 - 4) / 8) + 1) * 2) + 15;
    }

    public final C0795a k(C0795a c0795a, boolean z10, int i10, int i11) {
        int a10 = c0795a.a() + i10;
        int b10 = c0795a.b();
        while (true) {
            b10 += i11;
            if (!o(a10, b10) || this.f31224a.e(a10, b10) != z10) {
                break;
            }
            a10 += i10;
        }
        int i12 = a10 - i10;
        int i13 = b10 - i11;
        while (o(i12, i13) && this.f31224a.e(i12, i13) == z10) {
            i12 += i10;
        }
        int i14 = i12 - i10;
        while (o(i14, i13) && this.f31224a.e(i14, i13) == z10) {
            i13 += i11;
        }
        return new C0795a(i14, i13 - i11);
    }

    public final C0795a l() {
        l c10;
        l lVar;
        l lVar2;
        l lVar3;
        l c11;
        l c12;
        l c13;
        l c14;
        try {
            l[] c15 = new a6.c(this.f31224a).c();
            lVar2 = c15[0];
            lVar3 = c15[1];
            lVar = c15[2];
            c10 = c15[3];
        } catch (NotFoundException unused) {
            int l10 = this.f31224a.l() / 2;
            int h10 = this.f31224a.h() / 2;
            int i10 = l10 + 7;
            int i11 = h10 - 7;
            l c16 = k(new C0795a(i10, i11), false, 1, -1).c();
            int i12 = h10 + 7;
            l c17 = k(new C0795a(i10, i12), false, 1, 1).c();
            int i13 = l10 - 7;
            l c18 = k(new C0795a(i13, i12), false, -1, 1).c();
            c10 = k(new C0795a(i13, i11), false, -1, -1).c();
            lVar = c18;
            lVar2 = c16;
            lVar3 = c17;
        }
        int c19 = a6.a.c((((lVar2.c() + c10.c()) + lVar3.c()) + lVar.c()) / 4.0f);
        int c20 = a6.a.c((((lVar2.d() + c10.d()) + lVar3.d()) + lVar.d()) / 4.0f);
        try {
            l[] c21 = new a6.c(this.f31224a, 15, c19, c20).c();
            c11 = c21[0];
            c12 = c21[1];
            c13 = c21[2];
            c14 = c21[3];
        } catch (NotFoundException unused2) {
            int i14 = c19 + 7;
            int i15 = c20 - 7;
            c11 = k(new C0795a(i14, i15), false, 1, -1).c();
            int i16 = c20 + 7;
            c12 = k(new C0795a(i14, i16), false, 1, 1).c();
            int i17 = c19 - 7;
            c13 = k(new C0795a(i17, i16), false, -1, 1).c();
            c14 = k(new C0795a(i17, i15), false, -1, -1).c();
        }
        return new C0795a(a6.a.c((((c11.c() + c14.c()) + c12.c()) + c13.c()) / 4.0f), a6.a.c((((c11.d() + c14.d()) + c12.d()) + c13.d()) / 4.0f));
    }

    public final l[] m(l[] lVarArr) {
        return e(lVarArr, this.f31228e * 2, j());
    }

    public final boolean o(int i10, int i11) {
        return i10 >= 0 && i10 < this.f31224a.l() && i11 > 0 && i11 < this.f31224a.h();
    }

    public final boolean p(l lVar) {
        return o(a6.a.c(lVar.c()), a6.a.c(lVar.d()));
    }

    public final boolean q(C0795a c0795a, C0795a c0795a2, C0795a c0795a3, C0795a c0795a4) {
        C0795a c0795a5 = new C0795a(c0795a.a() - 3, c0795a.b() + 3);
        C0795a c0795a6 = new C0795a(c0795a2.a() - 3, c0795a2.b() - 3);
        C0795a c0795a7 = new C0795a(c0795a3.a() + 3, c0795a3.b() - 3);
        C0795a c0795a8 = new C0795a(c0795a4.a() + 3, c0795a4.b() + 3);
        int h10 = h(c0795a8, c0795a5);
        return h10 != 0 && h(c0795a5, c0795a6) == h10 && h(c0795a6, c0795a7) == h10 && h(c0795a7, c0795a8) == h10;
    }

    public final b r(b bVar, l lVar, l lVar2, l lVar3, l lVar4) throws NotFoundException {
        h b10 = h.b();
        int j10 = j();
        float f10 = j10 / 2.0f;
        int i10 = this.f31228e;
        float f11 = f10 - i10;
        float f12 = f10 + i10;
        return b10.c(bVar, j10, j10, f11, f11, f12, f11, f12, f12, f11, f12, lVar.c(), lVar.d(), lVar2.c(), lVar2.d(), lVar3.c(), lVar3.d(), lVar4.c(), lVar4.d());
    }

    public final int s(l lVar, l lVar2, int i10) {
        float c10 = c(lVar, lVar2);
        float f10 = c10 / i10;
        float c11 = lVar.c();
        float d10 = lVar.d();
        float c12 = ((lVar2.c() - lVar.c()) * f10) / c10;
        float d11 = (f10 * (lVar2.d() - lVar.d())) / c10;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            float f11 = i12;
            if (this.f31224a.e(a6.a.c((f11 * c12) + c11), a6.a.c((f11 * d11) + d10))) {
                i11 |= 1 << ((i10 - i12) - 1);
            }
        }
        return i11;
    }
}
