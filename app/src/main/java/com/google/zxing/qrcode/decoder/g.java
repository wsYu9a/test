package com.google.zxing.qrcode.decoder;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.zxing.FormatException;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a */
    private static final int[] f8760a = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};

    /* renamed from: b */
    private static final g[] f8761b = b();

    /* renamed from: c */
    private final int f8762c;

    /* renamed from: d */
    private final int[] f8763d;

    /* renamed from: e */
    private final b[] f8764e;

    /* renamed from: f */
    private final int f8765f;

    public static final class a {

        /* renamed from: a */
        private final int f8766a;

        /* renamed from: b */
        private final int f8767b;

        a(int i2, int i3) {
            this.f8766a = i2;
            this.f8767b = i3;
        }

        public int a() {
            return this.f8766a;
        }

        public int b() {
            return this.f8767b;
        }
    }

    public static final class b {

        /* renamed from: a */
        private final int f8768a;

        /* renamed from: b */
        private final a[] f8769b;

        b(int i2, a... aVarArr) {
            this.f8768a = i2;
            this.f8769b = aVarArr;
        }

        public a[] a() {
            return this.f8769b;
        }

        public int b() {
            return this.f8768a;
        }

        public int c() {
            int i2 = 0;
            for (a aVar : this.f8769b) {
                i2 += aVar.a();
            }
            return i2;
        }

        public int d() {
            return this.f8768a * c();
        }
    }

    private g(int i2, int[] iArr, b... bVarArr) {
        this.f8762c = i2;
        this.f8763d = iArr;
        this.f8764e = bVarArr;
        int b2 = bVarArr[0].b();
        int i3 = 0;
        for (a aVar : bVarArr[0].a()) {
            i3 += aVar.a() * (aVar.b() + b2);
        }
        this.f8765f = i3;
    }

    private static g[] b() {
        return new g[]{new g(1, new int[0], new b(7, new a(1, 19)), new b(10, new a(1, 16)), new b(13, new a(1, 13)), new b(17, new a(1, 9))), new g(2, new int[]{6, 18}, new b(10, new a(1, 34)), new b(16, new a(1, 28)), new b(22, new a(1, 22)), new b(28, new a(1, 16))), new g(3, new int[]{6, 22}, new b(15, new a(1, 55)), new b(26, new a(1, 44)), new b(18, new a(2, 17)), new b(22, new a(2, 13))), new g(4, new int[]{6, 26}, new b(20, new a(1, 80)), new b(18, new a(2, 32)), new b(26, new a(2, 24)), new b(16, new a(4, 9))), new g(5, new int[]{6, 30}, new b(26, new a(1, 108)), new b(24, new a(2, 43)), new b(18, new a(2, 15), new a(2, 16)), new b(22, new a(2, 11), new a(2, 12))), new g(6, new int[]{6, 34}, new b(18, new a(2, 68)), new b(16, new a(4, 27)), new b(24, new a(4, 19)), new b(28, new a(4, 15))), new g(7, new int[]{6, 22, 38}, new b(20, new a(2, 78)), new b(18, new a(4, 31)), new b(18, new a(2, 14), new a(4, 15)), new b(26, new a(4, 13), new a(1, 14))), new g(8, new int[]{6, 24, 42}, new b(24, new a(2, 97)), new b(22, new a(2, 38), new a(2, 39)), new b(22, new a(4, 18), new a(2, 19)), new b(26, new a(4, 14), new a(2, 15))), new g(9, new int[]{6, 26, 46}, new b(30, new a(2, 116)), new b(22, new a(3, 36), new a(2, 37)), new b(20, new a(4, 16), new a(4, 17)), new b(24, new a(4, 12), new a(4, 13))), new g(10, new int[]{6, 28, 50}, new b(18, new a(2, 68), new a(2, 69)), new b(26, new a(4, 43), new a(1, 44)), new b(24, new a(6, 19), new a(2, 20)), new b(28, new a(6, 15), new a(2, 16))), new g(11, new int[]{6, 30, 54}, new b(20, new a(4, 81)), new b(30, new a(1, 50), new a(4, 51)), new b(28, new a(4, 22), new a(4, 23)), new b(24, new a(3, 12), new a(8, 13))), new g(12, new int[]{6, 32, 58}, new b(24, new a(2, 92), new a(2, 93)), new b(22, new a(6, 36), new a(2, 37)), new b(26, new a(4, 20), new a(6, 21)), new b(28, new a(7, 14), new a(4, 15))), new g(13, new int[]{6, 34, 62}, new b(26, new a(4, 107)), new b(22, new a(8, 37), new a(1, 38)), new b(24, new a(8, 20), new a(4, 21)), new b(22, new a(12, 11), new a(4, 12))), new g(14, new int[]{6, 26, 46, 66}, new b(30, new a(3, 115), new a(1, 116)), new b(24, new a(4, 40), new a(5, 41)), new b(20, new a(11, 16), new a(5, 17)), new b(24, new a(11, 12), new a(5, 13))), new g(15, new int[]{6, 26, 48, 70}, new b(22, new a(5, 87), new a(1, 88)), new b(24, new a(5, 41), new a(5, 42)), new b(30, new a(5, 24), new a(7, 25)), new b(24, new a(11, 12), new a(7, 13))), new g(16, new int[]{6, 26, 50, 74}, new b(24, new a(5, 98), new a(1, 99)), new b(28, new a(7, 45), new a(3, 46)), new b(24, new a(15, 19), new a(2, 20)), new b(30, new a(3, 15), new a(13, 16))), new g(17, new int[]{6, 30, 54, 78}, new b(28, new a(1, 107), new a(5, 108)), new b(28, new a(10, 46), new a(1, 47)), new b(28, new a(1, 22), new a(15, 23)), new b(28, new a(2, 14), new a(17, 15))), new g(18, new int[]{6, 30, 56, 82}, new b(30, new a(5, 120), new a(1, 121)), new b(26, new a(9, 43), new a(4, 44)), new b(28, new a(17, 22), new a(1, 23)), new b(28, new a(2, 14), new a(19, 15))), new g(19, new int[]{6, 30, 58, 86}, new b(28, new a(3, 113), new a(4, 114)), new b(26, new a(3, 44), new a(11, 45)), new b(26, new a(17, 21), new a(4, 22)), new b(26, new a(9, 13), new a(16, 14))), new g(20, new int[]{6, 34, 62, 90}, new b(28, new a(3, 107), new a(5, 108)), new b(26, new a(3, 41), new a(13, 42)), new b(30, new a(15, 24), new a(5, 25)), new b(28, new a(15, 15), new a(10, 16))), new g(21, new int[]{6, 28, 50, 72, 94}, new b(28, new a(4, 116), new a(4, 117)), new b(26, new a(17, 42)), new b(28, new a(17, 22), new a(6, 23)), new b(30, new a(19, 16), new a(6, 17))), new g(22, new int[]{6, 26, 50, 74, 98}, new b(28, new a(2, 111), new a(7, 112)), new b(28, new a(17, 46)), new b(30, new a(7, 24), new a(16, 25)), new b(24, new a(34, 13))), new g(23, new int[]{6, 30, 54, 78, 102}, new b(30, new a(4, 121), new a(5, 122)), new b(28, new a(4, 47), new a(14, 48)), new b(30, new a(11, 24), new a(14, 25)), new b(30, new a(16, 15), new a(14, 16))), new g(24, new int[]{6, 28, 54, 80, 106}, new b(30, new a(6, 117), new a(4, 118)), new b(28, new a(6, 45), new a(14, 46)), new b(30, new a(11, 24), new a(16, 25)), new b(30, new a(30, 16), new a(2, 17))), new g(25, new int[]{6, 32, 58, 84, 110}, new b(26, new a(8, 106), new a(4, 107)), new b(28, new a(8, 47), new a(13, 48)), new b(30, new a(7, 24), new a(22, 25)), new b(30, new a(22, 15), new a(13, 16))), new g(26, new int[]{6, 30, 58, 86, 114}, new b(28, new a(10, 114), new a(2, 115)), new b(28, new a(19, 46), new a(4, 47)), new b(28, new a(28, 22), new a(6, 23)), new b(30, new a(33, 16), new a(4, 17))), new g(27, new int[]{6, 34, 62, 90, 118}, new b(30, new a(8, 122), new a(4, 123)), new b(28, new a(22, 45), new a(3, 46)), new b(30, new a(8, 23), new a(26, 24)), new b(30, new a(12, 15), new a(28, 16))), new g(28, new int[]{6, 26, 50, 74, 98, 122}, new b(30, new a(3, 117), new a(10, 118)), new b(28, new a(3, 45), new a(23, 46)), new b(30, new a(4, 24), new a(31, 25)), new b(30, new a(11, 15), new a(31, 16))), new g(29, new int[]{6, 30, 54, 78, 102, org.mozilla.universalchardet.prober.o.a.n}, new b(30, new a(7, 116), new a(7, 117)), new b(28, new a(21, 45), new a(7, 46)), new b(30, new a(1, 23), new a(37, 24)), new b(30, new a(19, 15), new a(26, 16))), new g(30, new int[]{6, 26, 52, 78, 104, org.mozilla.universalchardet.prober.n.c.m}, new b(30, new a(5, 115), new a(10, 116)), new b(28, new a(19, 47), new a(10, 48)), new b(30, new a(15, 24), new a(25, 25)), new b(30, new a(23, 15), new a(25, 16))), new g(31, new int[]{6, 30, 56, 82, 108, 134}, new b(30, new a(13, 115), new a(3, 116)), new b(28, new a(2, 46), new a(29, 47)), new b(30, new a(42, 24), new a(1, 25)), new b(30, new a(23, 15), new a(28, 16))), new g(32, new int[]{6, 34, 60, 86, 112, 138}, new b(30, new a(17, 115)), new b(28, new a(10, 46), new a(23, 47)), new b(30, new a(10, 24), new a(35, 25)), new b(30, new a(19, 15), new a(35, 16))), new g(33, new int[]{6, 30, 58, 86, 114, org.mozilla.universalchardet.prober.n.a.p}, new b(30, new a(17, 115), new a(1, 116)), new b(28, new a(14, 46), new a(21, 47)), new b(30, new a(29, 24), new a(19, 25)), new b(30, new a(11, 15), new a(46, 16))), new g(34, new int[]{6, 34, 62, 90, 118, 146}, new b(30, new a(13, 115), new a(6, 116)), new b(28, new a(14, 46), new a(23, 47)), new b(30, new a(44, 24), new a(7, 25)), new b(30, new a(59, 16), new a(1, 17))), new g(35, new int[]{6, 30, 54, 78, 102, org.mozilla.universalchardet.prober.o.a.n, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE}, new b(30, new a(12, 121), new a(7, 122)), new b(28, new a(12, 47), new a(26, 48)), new b(30, new a(39, 24), new a(14, 25)), new b(30, new a(22, 15), new a(41, 16))), new g(36, new int[]{6, 24, 50, 76, 102, 128, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND}, new b(30, new a(6, 121), new a(14, 122)), new b(28, new a(6, 47), new a(34, 48)), new b(30, new a(46, 24), new a(10, 25)), new b(30, new a(2, 15), new a(64, 16))), new g(37, new int[]{6, 28, 54, 80, 106, 132, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT}, new b(30, new a(17, 122), new a(4, 123)), new b(28, new a(29, 46), new a(14, 47)), new b(30, new a(49, 24), new a(10, 25)), new b(30, new a(24, 15), new a(46, 16))), new g(38, new int[]{6, 32, 58, 84, 110, 136, 162}, new b(30, new a(4, 122), new a(18, 123)), new b(28, new a(13, 46), new a(32, 47)), new b(30, new a(48, 24), new a(14, 25)), new b(30, new a(42, 15), new a(32, 16))), new g(39, new int[]{6, 26, 54, 82, 110, 138, TTAdConstant.IMAGE_MODE_LIVE}, new b(30, new a(20, 117), new a(4, 118)), new b(28, new a(40, 47), new a(7, 48)), new b(30, new a(43, 24), new a(22, 25)), new b(30, new a(10, 15), new a(67, 16))), new g(40, new int[]{6, 30, 58, 86, 114, org.mozilla.universalchardet.prober.n.a.p, 170}, new b(30, new a(19, 118), new a(6, 119)), new b(28, new a(18, 47), new a(31, 48)), new b(30, new a(34, 24), new a(34, 25)), new b(30, new a(20, 15), new a(61, 16)))};
    }

    static g c(int i2) {
        int i3 = 0;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        while (true) {
            int[] iArr = f8760a;
            if (i3 >= iArr.length) {
                if (i5 <= 3) {
                    return i(i4);
                }
                return null;
            }
            int i6 = iArr[i3];
            if (i6 == i2) {
                return i(i3 + 7);
            }
            int e2 = e.e(i2, i6);
            if (e2 < i5) {
                i4 = i3 + 7;
                i5 = e2;
            }
            i3++;
        }
    }

    public static g g(int i2) throws FormatException {
        if (i2 % 4 != 1) {
            throw FormatException.getFormatInstance();
        }
        try {
            return i((i2 - 17) / 4);
        } catch (IllegalArgumentException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    public static g i(int i2) {
        if (i2 <= 0 || i2 > 40) {
            throw new IllegalArgumentException();
        }
        return f8761b[i2 - 1];
    }

    com.google.zxing.common.b a() {
        int e2 = e();
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(e2);
        bVar.p(0, 0, 9, 9);
        int i2 = e2 - 8;
        bVar.p(i2, 0, 8, 9);
        bVar.p(0, i2, 9, 8);
        int length = this.f8763d.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = this.f8763d[i3] - 2;
            for (int i5 = 0; i5 < length; i5++) {
                if ((i3 != 0 || (i5 != 0 && i5 != length - 1)) && (i3 != length - 1 || i5 != 0)) {
                    bVar.p(this.f8763d[i5] - 2, i4, 5, 5);
                }
            }
        }
        int i6 = e2 - 17;
        bVar.p(6, 9, 1, i6);
        bVar.p(9, 6, i6, 1);
        if (this.f8762c > 6) {
            int i7 = e2 - 11;
            bVar.p(i7, 0, 3, 6);
            bVar.p(0, i7, 6, 3);
        }
        return bVar;
    }

    public int[] d() {
        return this.f8763d;
    }

    public int e() {
        return (this.f8762c * 4) + 17;
    }

    public b f(ErrorCorrectionLevel errorCorrectionLevel) {
        return this.f8764e[errorCorrectionLevel.ordinal()];
    }

    public int h() {
        return this.f8765f;
    }

    public int j() {
        return this.f8762c;
    }

    public String toString() {
        return String.valueOf(this.f8762c);
    }
}
