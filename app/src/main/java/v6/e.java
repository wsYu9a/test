package v6;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a */
    public static final int[][] f31244a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b */
    public static final int[][] f31245b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c */
    public static final int[][] f31246c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, -1}, new int[]{6, 34, 60, 86, 112, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_PATH, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND}, new int[]{6, 28, 54, 80, 106, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT}, new int[]{6, 32, 58, 84, 110, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 162}, new int[]{6, 26, 54, 82, 110, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, TTAdConstant.IMAGE_MODE_LIVE}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: d */
    public static final int[][] f31247d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* renamed from: e */
    public static final int f31248e = 7973;

    /* renamed from: f */
    public static final int f31249f = 1335;

    /* renamed from: g */
    public static final int f31250g = 21522;

    public static void a(z5.a aVar, ErrorCorrectionLevel errorCorrectionLevel, t6.f fVar, int i10, b bVar) throws WriterException {
        c(bVar);
        d(fVar, bVar);
        l(errorCorrectionLevel, i10, bVar);
        s(fVar, bVar);
        f(aVar, i10, bVar);
    }

    public static int b(int i10, int i11) {
        if (i11 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int n10 = n(i11);
        int i12 = i10 << (n10 - 1);
        while (n(i12) >= n10) {
            i12 ^= i11 << (n(i12) - n10);
        }
        return i12;
    }

    public static void c(b bVar) {
        bVar.a((byte) -1);
    }

    public static void d(t6.f fVar, b bVar) throws WriterException {
        j(bVar);
        e(bVar);
        r(fVar, bVar);
        k(bVar);
    }

    public static void e(b bVar) throws WriterException {
        if (bVar.b(8, bVar.d() - 8) == 0) {
            throw new WriterException();
        }
        bVar.g(8, bVar.d() - 8, 1);
    }

    public static void f(z5.a aVar, int i10, b bVar) throws WriterException {
        boolean z10;
        int e10 = bVar.e() - 1;
        int d10 = bVar.d() - 1;
        int i11 = 0;
        int i12 = -1;
        while (e10 > 0) {
            if (e10 == 6) {
                e10--;
            }
            while (d10 >= 0 && d10 < bVar.d()) {
                for (int i13 = 0; i13 < 2; i13++) {
                    int i14 = e10 - i13;
                    if (o(bVar.b(i14, d10))) {
                        if (i11 < aVar.l()) {
                            z10 = aVar.h(i11);
                            i11++;
                        } else {
                            z10 = false;
                        }
                        if (i10 != -1 && d.f(i10, i14, d10)) {
                            z10 = !z10;
                        }
                        bVar.h(i14, d10, z10);
                    }
                }
                d10 += i12;
            }
            i12 = -i12;
            d10 += i12;
            e10 -= 2;
        }
        if (i11 == aVar.l()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i11 + '/' + aVar.l());
    }

    public static void g(int i10, int i11, b bVar) throws WriterException {
        for (int i12 = 0; i12 < 8; i12++) {
            int i13 = i10 + i12;
            if (!o(bVar.b(i13, i11))) {
                throw new WriterException();
            }
            bVar.g(i13, i11, 0);
        }
    }

    public static void h(int i10, int i11, b bVar) {
        for (int i12 = 0; i12 < 5; i12++) {
            for (int i13 = 0; i13 < 5; i13++) {
                bVar.g(i10 + i13, i11 + i12, f31245b[i12][i13]);
            }
        }
    }

    public static void i(int i10, int i11, b bVar) {
        for (int i12 = 0; i12 < 7; i12++) {
            for (int i13 = 0; i13 < 7; i13++) {
                bVar.g(i10 + i13, i11 + i12, f31244a[i12][i13]);
            }
        }
    }

    public static void j(b bVar) throws WriterException {
        int length = f31244a[0].length;
        i(0, 0, bVar);
        i(bVar.e() - length, 0, bVar);
        i(0, bVar.e() - length, bVar);
        g(0, 7, bVar);
        g(bVar.e() - 8, 7, bVar);
        g(0, bVar.e() - 8, bVar);
        m(7, 0, bVar);
        m(bVar.d() - 8, 0, bVar);
        m(7, bVar.d() - 7, bVar);
    }

    public static void k(b bVar) {
        int i10 = 8;
        while (i10 < bVar.e() - 8) {
            int i11 = i10 + 1;
            int i12 = i11 % 2;
            if (o(bVar.b(i10, 6))) {
                bVar.g(i10, 6, i12);
            }
            if (o(bVar.b(6, i10))) {
                bVar.g(6, i10, i12);
            }
            i10 = i11;
        }
    }

    public static void l(ErrorCorrectionLevel errorCorrectionLevel, int i10, b bVar) throws WriterException {
        z5.a aVar = new z5.a();
        p(errorCorrectionLevel, i10, aVar);
        for (int i11 = 0; i11 < aVar.l(); i11++) {
            boolean h10 = aVar.h((aVar.l() - 1) - i11);
            int[] iArr = f31247d[i11];
            bVar.h(iArr[0], iArr[1], h10);
            if (i11 < 8) {
                bVar.h((bVar.e() - i11) - 1, 8, h10);
            } else {
                bVar.h(8, (bVar.d() - 7) + (i11 - 8), h10);
            }
        }
    }

    public static void m(int i10, int i11, b bVar) throws WriterException {
        for (int i12 = 0; i12 < 7; i12++) {
            int i13 = i11 + i12;
            if (!o(bVar.b(i10, i13))) {
                throw new WriterException();
            }
            bVar.g(i10, i13, 0);
        }
    }

    public static int n(int i10) {
        return 32 - Integer.numberOfLeadingZeros(i10);
    }

    public static boolean o(int i10) {
        return i10 == -1;
    }

    public static void p(ErrorCorrectionLevel errorCorrectionLevel, int i10, z5.a aVar) throws WriterException {
        if (!f.f(i10)) {
            throw new WriterException("Invalid mask pattern");
        }
        int bits = (errorCorrectionLevel.getBits() << 3) | i10;
        aVar.c(bits, 5);
        aVar.c(b(bits, f31249f), 10);
        z5.a aVar2 = new z5.a();
        aVar2.c(21522, 15);
        aVar.u(aVar2);
        if (aVar.l() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar.l());
    }

    public static void q(t6.f fVar, z5.a aVar) throws WriterException {
        aVar.c(fVar.j(), 6);
        aVar.c(b(fVar.j(), f31248e), 12);
        if (aVar.l() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar.l());
    }

    public static void r(t6.f fVar, b bVar) {
        if (fVar.j() < 2) {
            return;
        }
        int[] iArr = f31246c[fVar.j() - 1];
        for (int i10 : iArr) {
            for (int i11 : iArr) {
                if (i11 != -1 && i10 != -1 && o(bVar.b(i11, i10))) {
                    h(i11 - 2, i10 - 2, bVar);
                }
            }
        }
    }

    public static void s(t6.f fVar, b bVar) throws WriterException {
        if (fVar.j() < 7) {
            return;
        }
        z5.a aVar = new z5.a();
        q(fVar, aVar);
        int i10 = 17;
        for (int i11 = 0; i11 < 6; i11++) {
            for (int i12 = 0; i12 < 3; i12++) {
                boolean h10 = aVar.h(i10);
                i10--;
                bVar.h(i11, (bVar.d() - 11) + i12, h10);
                bVar.h((bVar.d() - 11) + i12, i11, h10);
            }
        }
    }
}
