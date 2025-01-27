package com.google.zxing.datamatrix.encoder;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.qq.e.comm.adevent.AdEventType;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.ic.dm.Downloads;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: c */
    private static final int f8404c = 301;

    /* renamed from: a */
    private static final int[] f8402a = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};

    /* renamed from: b */
    private static final int[][] f8403b = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, org.mozilla.universalchardet.prober.g.n, 92, 254}, new int[]{28, 24, 185, TTAdConstant.IMAGE_MODE_LIVE, 223, 248, 116, 255, 110, 61}, new int[]{175, 138, 205, 12, Downloads.Impl.STATUS_WAITING_TO_RETRY, 168, 39, org.mozilla.universalchardet.prober.g.q, 60, 97, 120}, new int[]{41, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 91, 61, 42, org.mozilla.universalchardet.prober.n.a.p, AdEventType.VIDEO_PRELOAD_ERROR, 97, 178, 100, 242}, new int[]{TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, 97, Downloads.Impl.STATUS_RUNNING, TinkerReport.KEY_LOADED_EXCEPTION_DEX, 95, 9, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, Downloads.Impl.STATUS_WAITING_FOR_NETWORK, 100, 39, 188, 75, 66, 61, org.mozilla.universalchardet.prober.n.c.o, AdEventType.VIDEO_PRELOAD_ERROR, 109, 129, 94, 254, 225, 48, 90, 188}, new int[]{15, Downloads.Impl.STATUS_WAITING_FOR_NETWORK, org.mozilla.universalchardet.prober.g.p, 9, 233, 71, 168, 2, 188, 160, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 145, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, Downloads.Impl.STATUS_PENDING, 88, 205, 109, 39, 176, 21, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND, 197, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 223, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND, 21, 5, 172, 254, 124, 12, TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 96, 50, Downloads.Impl.STATUS_PAUSED_BY_APP}, new int[]{AdEventType.VIDEO_LOADING, 231, 43, 97, 71, 96, 103, 174, 37, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META, 170, 53, 75, 34, 249, 121, 17, 138, 110, AdEventType.VIDEO_PRELOAD_ERROR, 141, 136, 120, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META, 233, 168, 93, 255}, new int[]{org.mozilla.universalchardet.prober.g.q, 127, 242, 218, org.mozilla.universalchardet.prober.n.c.m, 250, 162, TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, 102, 120, 84, 179, 220, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 80, TinkerReport.KEY_APPLIED_DEX_EXTRACT, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 59, 25, 225, 98, 81, 112}, new int[]{77, Downloads.Impl.STATUS_PAUSED_BY_APP, 137, 31, 19, 38, 22, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 247, 105, 122, 2, org.mozilla.universalchardet.prober.g.q, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK, 57, 54, 101, 248, 202, 69, 50, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE, 177, 226, 5, 9, 5}, new int[]{org.mozilla.universalchardet.prober.g.q, 132, 172, 223, 96, 32, 117, 22, org.mozilla.universalchardet.prober.g.l, 133, org.mozilla.universalchardet.prober.g.l, 231, 205, 188, org.mozilla.universalchardet.prober.g.k, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, TTAdConstant.IMAGE_MODE_SPLASH, 88, 120, 100, 66, 138, 186, org.mozilla.universalchardet.prober.g.n, 82, 44, 176, 87, 187, 147, 160, 175, 69, AdEventType.VIDEO_PRELOAD_ERROR, 92, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK, 225, 19}, new int[]{175, 9, 223, org.mozilla.universalchardet.prober.g.l, 12, 17, 220, 208, 100, 29, 175, 170, 230, Downloads.Impl.STATUS_RUNNING, 215, org.mozilla.universalchardet.prober.g.f35437j, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, org.mozilla.universalchardet.prober.g.f35436i, 117, 203, 29, 232, 144, org.mozilla.universalchardet.prober.g.l, 22, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE, 201, 117, 62, 207, 164, 13, 137, org.mozilla.universalchardet.prober.g.q, 127, 67, 247, 28, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND, 43, 203, 107, 233, 53, org.mozilla.universalchardet.prober.n.a.q, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, org.mozilla.universalchardet.prober.n.a.q, 108, 196, 37, 185, 112, 134, 230, org.mozilla.universalchardet.prober.g.q, 63, 197, Downloads.Impl.STATUS_PENDING, 250, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, org.mozilla.universalchardet.prober.n.c.m, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, TTAdConstant.IMAGE_MODE_LIVE, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 149, 159, 56, 89, 33, 147, org.mozilla.universalchardet.prober.g.p, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, 36, 73, 127, AdEventType.VIDEO_PRELOAD_ERROR, 136, 248, TinkerReport.KEY_APPLIED_VERSION_CHECK, org.mozilla.universalchardet.prober.g.f35436i, 197, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 177, 68, 122, 93, AdEventType.VIDEO_PRELOAD_ERROR, 15, 160, 227, 236, 66, 139, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, org.mozilla.universalchardet.prober.n.c.o, 59, 52, 172, 25, 49, 232, AdEventType.VIDEO_LOADING, 189, 64, 54, 108, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 132, 63, 96, 103, 82, 186}};

    /* renamed from: d */
    private static final int[] f8405d = new int[256];

    /* renamed from: e */
    private static final int[] f8406e = new int[255];

    static {
        int i2 = 1;
        for (int i3 = 0; i3 < 255; i3++) {
            f8406e[i3] = i2;
            f8405d[i2] = i3;
            i2 <<= 1;
            if (i2 >= 256) {
                i2 ^= 301;
            }
        }
    }

    private i() {
    }

    private static String a(CharSequence charSequence, int i2) {
        return b(charSequence, 0, charSequence.length(), i2);
    }

    private static String b(CharSequence charSequence, int i2, int i3, int i4) {
        int i5 = 0;
        while (true) {
            int[] iArr = f8402a;
            if (i5 >= iArr.length) {
                i5 = -1;
                break;
            }
            if (iArr[i5] == i4) {
                break;
            }
            i5++;
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i4);
        }
        int[] iArr2 = f8403b[i5];
        char[] cArr = new char[i4];
        for (int i6 = 0; i6 < i4; i6++) {
            cArr[i6] = 0;
        }
        for (int i7 = i2; i7 < i2 + i3; i7++) {
            int i8 = i4 - 1;
            int charAt = cArr[i8] ^ charSequence.charAt(i7);
            while (i8 > 0) {
                if (charAt == 0 || iArr2[i8] == 0) {
                    cArr[i8] = cArr[i8 - 1];
                } else {
                    char c2 = cArr[i8 - 1];
                    int[] iArr3 = f8406e;
                    int[] iArr4 = f8405d;
                    cArr[i8] = (char) (c2 ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i8]]) % 255]);
                }
                i8--;
            }
            if (charAt == 0 || iArr2[0] == 0) {
                cArr[0] = 0;
            } else {
                int[] iArr5 = f8406e;
                int[] iArr6 = f8405d;
                cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
            }
        }
        char[] cArr2 = new char[i4];
        for (int i9 = 0; i9 < i4; i9++) {
            cArr2[i9] = cArr[(i4 - i9) - 1];
        }
        return String.valueOf(cArr2);
    }

    public static String c(String str, k kVar) {
        if (str.length() != kVar.b()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(kVar.b() + kVar.d());
        sb.append(str);
        int g2 = kVar.g();
        if (g2 == 1) {
            sb.append(a(str, kVar.d()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[g2];
            int[] iArr2 = new int[g2];
            int[] iArr3 = new int[g2];
            int i2 = 0;
            while (i2 < g2) {
                int i3 = i2 + 1;
                iArr[i2] = kVar.c(i3);
                iArr2[i2] = kVar.e(i3);
                iArr3[i2] = 0;
                if (i2 > 0) {
                    iArr3[i2] = iArr3[i2 - 1] + iArr[i2];
                }
                i2 = i3;
            }
            for (int i4 = 0; i4 < g2; i4++) {
                StringBuilder sb2 = new StringBuilder(iArr[i4]);
                for (int i5 = i4; i5 < kVar.b(); i5 += g2) {
                    sb2.append(str.charAt(i5));
                }
                String a2 = a(sb2.toString(), iArr2[i4]);
                int i6 = i4;
                int i7 = 0;
                while (i6 < iArr2[i4] * g2) {
                    sb.setCharAt(kVar.b() + i6, a2.charAt(i7));
                    i6 += g2;
                    i7++;
                }
            }
        }
        return sb.toString();
    }
}
