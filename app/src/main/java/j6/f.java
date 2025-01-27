package j6;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
public final class f extends q {

    /* renamed from: c */
    public static final String f27202c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";

    /* renamed from: d */
    public static final char[] f27203d = f27202c.toCharArray();

    /* renamed from: e */
    public static final int[] f27204e;

    /* renamed from: f */
    public static final int f27205f;

    /* renamed from: a */
    public final StringBuilder f27206a = new StringBuilder(20);

    /* renamed from: b */
    public final int[] f27207b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, TypedValues.CycleType.TYPE_WAVE_OFFSET, TypedValues.CycleType.TYPE_EASING, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 404, 402, 394, qe.c.f30025o, TinkerReport.KEY_LOADED_PACKAGE_CHECK_PACKAGE_META_NOT_FOUND, TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, 406, TTAdConstant.IMAGE_LIST_SIZE_CODE, 364, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE};
        f27204e = iArr;
        f27205f = iArr[47];
    }

    public static void h(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        i(charSequence, length - 2, 20);
        i(charSequence, length - 1, 15);
    }

    public static void i(CharSequence charSequence, int i10, int i11) throws ChecksumException {
        int i12 = 0;
        int i13 = 1;
        for (int i14 = i10 - 1; i14 >= 0; i14--) {
            i12 += f27202c.indexOf(charSequence.charAt(i14)) * i13;
            i13++;
            if (i13 > i11) {
                i13 = 1;
            }
        }
        if (charSequence.charAt(i10) != f27203d[i12 % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    private static String j(CharSequence charSequence) throws FormatException {
        int i10;
        char c10;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i11 = 0;
        while (i11 < length) {
            char charAt = charSequence.charAt(i11);
            if (charAt < 'a' || charAt > 'd') {
                sb2.append(charAt);
            } else {
                if (i11 >= length - 1) {
                    throw FormatException.getFormatInstance();
                }
                i11++;
                char charAt2 = charSequence.charAt(i11);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i10 = charAt2 - '@';
                            c10 = (char) i10;
                            sb2.append(c10);
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    case 'b':
                        if (charAt2 >= 'A' && charAt2 <= 'E') {
                            i10 = charAt2 - '&';
                        } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                            i10 = charAt2 + g6.b.f26162f;
                        } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                            i10 = charAt2 + 16;
                        } else if (charAt2 >= 'P' && charAt2 <= 'S') {
                            i10 = charAt2 + '+';
                        } else if (charAt2 >= 'T' && charAt2 <= 'Z') {
                            c10 = b5.a.N;
                            sb2.append(c10);
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        c10 = (char) i10;
                        sb2.append(c10);
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            i10 = charAt2 - ' ';
                            c10 = (char) i10;
                            sb2.append(c10);
                        } else {
                            if (charAt2 != 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            c10 = m5.d.f28378d;
                            sb2.append(c10);
                            break;
                        }
                    case 'd':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i10 = charAt2 + b5.a.O;
                            c10 = (char) i10;
                            sb2.append(c10);
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    default:
                        c10 = 0;
                        sb2.append(c10);
                        break;
                }
            }
            i11++;
        }
        return sb2.toString();
    }

    private static char l(int i10) throws NotFoundException {
        int i11 = 0;
        while (true) {
            int[] iArr = f27204e;
            if (i11 >= iArr.length) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (iArr[i11] == i10) {
                return f27203d[i11];
            }
            i11++;
        }
    }

    public static int m(int[] iArr) {
        int i10 = 0;
        for (int i11 : iArr) {
            i10 += i11;
        }
        int length = iArr.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            int round = Math.round((iArr[i13] * 9.0f) / i10);
            if (round <= 0 || round > 4) {
                return -1;
            }
            if ((i13 & 1) == 0) {
                for (int i14 = 0; i14 < round; i14++) {
                    i12 = (i12 << 1) | 1;
                }
            } else {
                i12 <<= round;
            }
        }
        return i12;
    }

    @Override // j6.q
    public t5.k c(int i10, z5.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int j10 = aVar.j(k(aVar)[1]);
        int l10 = aVar.l();
        int[] iArr = this.f27207b;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f27206a;
        sb2.setLength(0);
        while (true) {
            q.f(aVar, j10, iArr);
            int m10 = m(iArr);
            if (m10 < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char l11 = l(m10);
            sb2.append(l11);
            int i11 = j10;
            for (int i12 : iArr) {
                i11 += i12;
            }
            int j11 = aVar.j(i11);
            if (l11 == '*') {
                sb2.deleteCharAt(sb2.length() - 1);
                int i13 = 0;
                for (int i14 : iArr) {
                    i13 += i14;
                }
                if (j11 == l10 || !aVar.h(j11)) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sb2.length() < 2) {
                    throw NotFoundException.getNotFoundInstance();
                }
                h(sb2);
                sb2.setLength(sb2.length() - 2);
                float f10 = i10;
                return new t5.k(j(sb2), null, new t5.l[]{new t5.l((r0[1] + r0[0]) / 2.0f, f10), new t5.l(j10 + (i13 / 2.0f), f10)}, BarcodeFormat.CODE_93);
            }
            j10 = j11;
        }
    }

    public final int[] k(z5.a aVar) throws NotFoundException {
        int l10 = aVar.l();
        int j10 = aVar.j(0);
        Arrays.fill(this.f27207b, 0);
        int[] iArr = this.f27207b;
        int length = iArr.length;
        int i10 = j10;
        boolean z10 = false;
        int i11 = 0;
        while (j10 < l10) {
            if (aVar.h(j10) ^ z10) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                int i12 = length - 1;
                if (i11 != i12) {
                    i11++;
                } else {
                    if (m(iArr) == f27205f) {
                        return new int[]{i10, j10};
                    }
                    i10 += iArr[0] + iArr[1];
                    int i13 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i13);
                    iArr[i13] = 0;
                    iArr[i12] = 0;
                    i11--;
                }
                iArr[i11] = 1;
                z10 = !z10;
            }
            j10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
