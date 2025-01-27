package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    private static final d[] f8372a = a();

    /* renamed from: b */
    private final int f8373b;

    /* renamed from: c */
    private final int f8374c;

    /* renamed from: d */
    private final int f8375d;

    /* renamed from: e */
    private final int f8376e;

    /* renamed from: f */
    private final int f8377f;

    /* renamed from: g */
    private final c f8378g;

    /* renamed from: h */
    private final int f8379h;

    static final class b {

        /* renamed from: a */
        private final int f8380a;

        /* renamed from: b */
        private final int f8381b;

        /* synthetic */ b(int i2, int i3, a aVar) {
            this(i2, i3);
        }

        int a() {
            return this.f8380a;
        }

        int b() {
            return this.f8381b;
        }

        private b(int i2, int i3) {
            this.f8380a = i2;
            this.f8381b = i3;
        }
    }

    static final class c {

        /* renamed from: a */
        private final int f8382a;

        /* renamed from: b */
        private final b[] f8383b;

        /* synthetic */ c(int i2, b bVar, a aVar) {
            this(i2, bVar);
        }

        b[] a() {
            return this.f8383b;
        }

        int b() {
            return this.f8382a;
        }

        /* synthetic */ c(int i2, b bVar, b bVar2, a aVar) {
            this(i2, bVar, bVar2);
        }

        private c(int i2, b bVar) {
            this.f8382a = i2;
            this.f8383b = new b[]{bVar};
        }

        private c(int i2, b bVar, b bVar2) {
            this.f8382a = i2;
            this.f8383b = new b[]{bVar, bVar2};
        }
    }

    private d(int i2, int i3, int i4, int i5, int i6, c cVar) {
        this.f8373b = i2;
        this.f8374c = i3;
        this.f8375d = i4;
        this.f8376e = i5;
        this.f8377f = i6;
        this.f8378g = cVar;
        int b2 = cVar.b();
        int i7 = 0;
        for (b bVar : cVar.a()) {
            i7 += bVar.a() * (bVar.b() + b2);
        }
        this.f8379h = i7;
    }

    private static d[] a() {
        return new d[]{new d(1, 10, 10, 8, 8, new c(5, new b(1, 3))), new d(2, 12, 12, 10, 10, new c(7, new b(1, 5))), new d(3, 14, 14, 12, 12, new c(10, new b(1, 8))), new d(4, 16, 16, 14, 14, new c(12, new b(1, 12))), new d(5, 18, 18, 16, 16, new c(14, new b(1, 18))), new d(6, 20, 20, 18, 18, new c(18, new b(1, 22))), new d(7, 22, 22, 20, 20, new c(20, new b(1, 30))), new d(8, 24, 24, 22, 22, new c(24, new b(1, 36))), new d(9, 26, 26, 24, 24, new c(28, new b(1, 44))), new d(10, 32, 32, 14, 14, new c(36, new b(1, 62))), new d(11, 36, 36, 16, 16, new c(42, new b(1, 86))), new d(12, 40, 40, 18, 18, new c(48, new b(1, 114))), new d(13, 44, 44, 20, 20, new c(56, new b(1, 144))), new d(14, 48, 48, 22, 22, new c(68, new b(1, 174))), new d(15, 52, 52, 24, 24, new c(42, new b(2, 102))), new d(16, 64, 64, 14, 14, new c(56, new b(2, 140))), new d(17, 72, 72, 16, 16, new c(36, new b(4, 92))), new d(18, 80, 80, 18, 18, new c(48, new b(4, 114))), new d(19, 88, 88, 20, 20, new c(56, new b(4, 144))), new d(20, 96, 96, 22, 22, new c(68, new b(4, 174))), new d(21, 104, 104, 24, 24, new c(56, new b(6, 136))), new d(22, 120, 120, 18, 18, new c(68, new b(6, 175))), new d(23, 132, 132, 20, 20, new c(62, new b(8, 163))), new d(24, 144, 144, 22, 22, new c(62, new b(8, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL), new b(2, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND))), new d(25, 8, 18, 6, 16, new c(7, new b(1, 5))), new d(26, 8, 32, 6, 14, new c(11, new b(1, 10))), new d(27, 12, 26, 10, 24, new c(14, new b(1, 16))), new d(28, 12, 36, 10, 16, new c(18, new b(1, 22))), new d(29, 16, 36, 14, 16, new c(24, new b(1, 32))), new d(30, 16, 48, 14, 22, new c(28, new b(1, 49)))};
    }

    public static d h(int i2, int i3) throws FormatException {
        if ((i2 & 1) != 0 || (i3 & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        for (d dVar : f8372a) {
            if (dVar.f8374c == i2 && dVar.f8375d == i3) {
                return dVar;
            }
        }
        throw FormatException.getFormatInstance();
    }

    public int b() {
        return this.f8377f;
    }

    public int c() {
        return this.f8376e;
    }

    c d() {
        return this.f8378g;
    }

    public int e() {
        return this.f8375d;
    }

    public int f() {
        return this.f8374c;
    }

    public int g() {
        return this.f8379h;
    }

    public int i() {
        return this.f8373b;
    }

    public String toString() {
        return String.valueOf(this.f8373b);
    }
}
