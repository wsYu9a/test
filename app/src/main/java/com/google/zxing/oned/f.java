package com.google.zxing.oned;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.ic.dm.Downloads;
import java.util.Arrays;
import java.util.Map;
import org.apache.http.HttpStatus;

/* loaded from: classes.dex */
public final class f extends q {

    /* renamed from: a */
    static final String f8569a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";

    /* renamed from: b */
    private static final char[] f8570b = f8569a.toCharArray();

    /* renamed from: c */
    static final int[] f8571c;

    /* renamed from: d */
    private static final int f8572d;

    /* renamed from: e */
    private final StringBuilder f8573e = new StringBuilder(20);

    /* renamed from: f */
    private final int[] f8574f = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, HttpStatus.SC_FAILED_DEPENDENCY, 420, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 404, 402, 394, 360, TinkerReport.KEY_LOADED_PACKAGE_CHECK_PACKAGE_META_NOT_FOUND, TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, HttpStatus.SC_UNPROCESSABLE_ENTITY, 406, 410, 364, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, Downloads.Impl.STATUS_UNKNOW_FILE_ERROR, TinkerReport.KEY_LOADED_MISSING_PATCH_INFO, TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE};
        f8571c = iArr;
        f8572d = iArr[47];
    }

    private static void h(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        i(charSequence, length - 2, 20);
        i(charSequence, length - 1, 15);
    }

    private static void i(CharSequence charSequence, int i2, int i3) throws ChecksumException {
        int i4 = 0;
        int i5 = 1;
        for (int i6 = i2 - 1; i6 >= 0; i6--) {
            i4 += f8569a.indexOf(charSequence.charAt(i6)) * i5;
            i5++;
            if (i5 > i3) {
                i5 = 1;
            }
        }
        if (charSequence.charAt(i2) != f8570b[i4 % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    private static String j(CharSequence charSequence) throws FormatException {
        int i2;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 'a' || charAt > 'd') {
                sb.append(charAt);
            } else {
                if (i3 >= length - 1) {
                    throw FormatException.getFormatInstance();
                }
                i3++;
                char charAt2 = charSequence.charAt(i3);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i2 = charAt2 - '@';
                            c2 = (char) i2;
                            sb.append(c2);
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    case 'b':
                        if (charAt2 >= 'A' && charAt2 <= 'E') {
                            i2 = charAt2 - '&';
                        } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                            i2 = charAt2 - 11;
                        } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                            i2 = charAt2 + 16;
                        } else if (charAt2 >= 'P' && charAt2 <= 'S') {
                            i2 = charAt2 + '+';
                        } else if (charAt2 >= 'T' && charAt2 <= 'Z') {
                            c2 = 127;
                            sb.append(c2);
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        c2 = (char) i2;
                        sb.append(c2);
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            i2 = charAt2 - ' ';
                            c2 = (char) i2;
                            sb.append(c2);
                        } else {
                            if (charAt2 != 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            c2 = ':';
                            sb.append(c2);
                            break;
                        }
                    case 'd':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i2 = charAt2 + ' ';
                            c2 = (char) i2;
                            sb.append(c2);
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    default:
                        c2 = 0;
                        sb.append(c2);
                        break;
                }
            }
            i3++;
        }
        return sb.toString();
    }

    private int[] k(com.google.zxing.common.a aVar) throws NotFoundException {
        int l = aVar.l();
        int j2 = aVar.j(0);
        Arrays.fill(this.f8574f, 0);
        int[] iArr = this.f8574f;
        int length = iArr.length;
        int i2 = j2;
        boolean z = false;
        int i3 = 0;
        while (j2 < l) {
            if (aVar.h(j2) ^ z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                int i4 = length - 1;
                if (i3 != i4) {
                    i3++;
                } else {
                    if (m(iArr) == f8572d) {
                        return new int[]{i2, j2};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i5 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i5);
                    iArr[i5] = 0;
                    iArr[i4] = 0;
                    i3--;
                }
                iArr[i3] = 1;
                z = !z;
            }
            j2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static char l(int i2) throws NotFoundException {
        int i3 = 0;
        while (true) {
            int[] iArr = f8571c;
            if (i3 >= iArr.length) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (iArr[i3] == i2) {
                return f8570b[i3];
            }
            i3++;
        }
    }

    private static int m(int[] iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        int length = iArr.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int round = Math.round((iArr[i5] * 9.0f) / i2);
            if (round <= 0 || round > 4) {
                return -1;
            }
            if ((i5 & 1) == 0) {
                for (int i6 = 0; i6 < round; i6++) {
                    i4 = (i4 << 1) | 1;
                }
            } else {
                i4 <<= round;
            }
        }
        return i4;
    }

    @Override // com.google.zxing.oned.q
    public com.google.zxing.k b(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int j2 = aVar.j(k(aVar)[1]);
        int l = aVar.l();
        int[] iArr = this.f8574f;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f8573e;
        sb.setLength(0);
        while (true) {
            q.f(aVar, j2, iArr);
            int m = m(iArr);
            if (m < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char l2 = l(m);
            sb.append(l2);
            int i3 = j2;
            for (int i4 : iArr) {
                i3 += i4;
            }
            int j3 = aVar.j(i3);
            if (l2 == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i5 = 0;
                for (int i6 : iArr) {
                    i5 += i6;
                }
                if (j3 == l || !aVar.h(j3)) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sb.length() < 2) {
                    throw NotFoundException.getNotFoundInstance();
                }
                h(sb);
                sb.setLength(sb.length() - 2);
                float f2 = i2;
                return new com.google.zxing.k(j(sb), null, new com.google.zxing.l[]{new com.google.zxing.l((r14[1] + r14[0]) / 2.0f, f2), new com.google.zxing.l(j2 + (i5 / 2.0f), f2)}, BarcodeFormat.CODE_93);
            }
            j2 = j3;
        }
    }
}
