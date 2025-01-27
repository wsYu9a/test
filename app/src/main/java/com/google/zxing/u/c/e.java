package com.google.zxing.u.c;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.g;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes.dex */
final class e {

    /* renamed from: a */
    private static final int[][] f8862a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b */
    private static final int[][] f8863b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c */
    private static final int[][] f8864c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, org.mozilla.universalchardet.prober.o.a.n, -1}, new int[]{6, 26, 52, 78, 104, org.mozilla.universalchardet.prober.n.c.m, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, org.mozilla.universalchardet.prober.n.a.p, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, org.mozilla.universalchardet.prober.o.a.n, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE}, new int[]{6, 24, 50, 76, 102, 128, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND}, new int[]{6, 28, 54, 80, 106, 132, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, TTAdConstant.IMAGE_MODE_LIVE}, new int[]{6, 30, 58, 86, 114, org.mozilla.universalchardet.prober.n.a.p, 170}};

    /* renamed from: d */
    private static final int[][] f8865d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* renamed from: e */
    private static final int f8866e = 7973;

    /* renamed from: f */
    private static final int f8867f = 1335;

    /* renamed from: g */
    private static final int f8868g = 21522;

    private e() {
    }

    static void a(com.google.zxing.common.a aVar, ErrorCorrectionLevel errorCorrectionLevel, g gVar, int i2, b bVar) throws WriterException {
        c(bVar);
        d(gVar, bVar);
        l(errorCorrectionLevel, i2, bVar);
        s(gVar, bVar);
        f(aVar, i2, bVar);
    }

    static int b(int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int n = n(i3);
        int i4 = i2 << (n - 1);
        while (n(i4) >= n) {
            i4 ^= i3 << (n(i4) - n);
        }
        return i4;
    }

    static void c(b bVar) {
        bVar.a((byte) -1);
    }

    static void d(g gVar, b bVar) throws WriterException {
        j(bVar);
        e(bVar);
        r(gVar, bVar);
        k(bVar);
    }

    private static void e(b bVar) throws WriterException {
        if (bVar.b(8, bVar.d() - 8) == 0) {
            throw new WriterException();
        }
        bVar.g(8, bVar.d() - 8, 1);
    }

    static void f(com.google.zxing.common.a aVar, int i2, b bVar) throws WriterException {
        boolean z;
        int e2 = bVar.e() - 1;
        int d2 = bVar.d() - 1;
        int i3 = 0;
        int i4 = -1;
        while (e2 > 0) {
            if (e2 == 6) {
                e2--;
            }
            while (d2 >= 0 && d2 < bVar.d()) {
                for (int i5 = 0; i5 < 2; i5++) {
                    int i6 = e2 - i5;
                    if (o(bVar.b(i6, d2))) {
                        if (i3 < aVar.l()) {
                            z = aVar.h(i3);
                            i3++;
                        } else {
                            z = false;
                        }
                        if (i2 != -1 && d.f(i2, i6, d2)) {
                            z = !z;
                        }
                        bVar.h(i6, d2, z);
                    }
                }
                d2 += i4;
            }
            i4 = -i4;
            d2 += i4;
            e2 -= 2;
        }
        if (i3 == aVar.l()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i3 + '/' + aVar.l());
    }

    private static void g(int i2, int i3, b bVar) throws WriterException {
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = i2 + i4;
            if (!o(bVar.b(i5, i3))) {
                throw new WriterException();
            }
            bVar.g(i5, i3, 0);
        }
    }

    private static void h(int i2, int i3, b bVar) {
        for (int i4 = 0; i4 < 5; i4++) {
            for (int i5 = 0; i5 < 5; i5++) {
                bVar.g(i2 + i5, i3 + i4, f8863b[i4][i5]);
            }
        }
    }

    private static void i(int i2, int i3, b bVar) {
        for (int i4 = 0; i4 < 7; i4++) {
            for (int i5 = 0; i5 < 7; i5++) {
                bVar.g(i2 + i5, i3 + i4, f8862a[i4][i5]);
            }
        }
    }

    private static void j(b bVar) throws WriterException {
        int length = f8862a[0].length;
        i(0, 0, bVar);
        i(bVar.e() - length, 0, bVar);
        i(0, bVar.e() - length, bVar);
        g(0, 7, bVar);
        g(bVar.e() - 8, 7, bVar);
        g(0, bVar.e() - 8, bVar);
        m(7, 0, bVar);
        m((bVar.d() - 7) - 1, 0, bVar);
        m(7, bVar.d() - 7, bVar);
    }

    private static void k(b bVar) {
        int i2 = 8;
        while (i2 < bVar.e() - 8) {
            int i3 = i2 + 1;
            int i4 = i3 % 2;
            if (o(bVar.b(i2, 6))) {
                bVar.g(i2, 6, i4);
            }
            if (o(bVar.b(6, i2))) {
                bVar.g(6, i2, i4);
            }
            i2 = i3;
        }
    }

    static void l(ErrorCorrectionLevel errorCorrectionLevel, int i2, b bVar) throws WriterException {
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        p(errorCorrectionLevel, i2, aVar);
        for (int i3 = 0; i3 < aVar.l(); i3++) {
            boolean h2 = aVar.h((aVar.l() - 1) - i3);
            int[][] iArr = f8865d;
            bVar.h(iArr[i3][0], iArr[i3][1], h2);
            if (i3 < 8) {
                bVar.h((bVar.e() - i3) - 1, 8, h2);
            } else {
                bVar.h(8, (bVar.d() - 7) + (i3 - 8), h2);
            }
        }
    }

    private static void m(int i2, int i3, b bVar) throws WriterException {
        for (int i4 = 0; i4 < 7; i4++) {
            int i5 = i3 + i4;
            if (!o(bVar.b(i2, i5))) {
                throw new WriterException();
            }
            bVar.g(i2, i5, 0);
        }
    }

    static int n(int i2) {
        return 32 - Integer.numberOfLeadingZeros(i2);
    }

    private static boolean o(int i2) {
        return i2 == -1;
    }

    static void p(ErrorCorrectionLevel errorCorrectionLevel, int i2, com.google.zxing.common.a aVar) throws WriterException {
        if (!f.f(i2)) {
            throw new WriterException("Invalid mask pattern");
        }
        int bits = (errorCorrectionLevel.getBits() << 3) | i2;
        aVar.c(bits, 5);
        aVar.c(b(bits, f8867f), 10);
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        aVar2.c(f8868g, 15);
        aVar.u(aVar2);
        if (aVar.l() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar.l());
    }

    static void q(g gVar, com.google.zxing.common.a aVar) throws WriterException {
        aVar.c(gVar.j(), 6);
        aVar.c(b(gVar.j(), f8866e), 12);
        if (aVar.l() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar.l());
    }

    private static void r(g gVar, b bVar) {
        if (gVar.j() < 2) {
            return;
        }
        int j2 = gVar.j() - 1;
        int[][] iArr = f8864c;
        int[] iArr2 = iArr[j2];
        int length = iArr[j2].length;
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = iArr2[i2];
                int i5 = iArr2[i3];
                if (i5 != -1 && i4 != -1 && o(bVar.b(i5, i4))) {
                    h(i5 - 2, i4 - 2, bVar);
                }
            }
        }
    }

    static void s(g gVar, b bVar) throws WriterException {
        if (gVar.j() < 7) {
            return;
        }
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        q(gVar, aVar);
        int i2 = 17;
        for (int i3 = 0; i3 < 6; i3++) {
            for (int i4 = 0; i4 < 3; i4++) {
                boolean h2 = aVar.h(i2);
                i2--;
                bVar.h(i3, (bVar.d() - 11) + i4, h2);
                bVar.h((bVar.d() - 11) + i4, i3, h2);
            }
        }
    }
}
