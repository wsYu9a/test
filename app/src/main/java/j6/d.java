package j6;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
public final class d extends q {

    /* renamed from: e */
    public static final String f27194e = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";

    /* renamed from: f */
    public static final String f27195f = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";

    /* renamed from: g */
    public static final int[] f27196g;

    /* renamed from: h */
    public static final int f27197h;

    /* renamed from: a */
    public final boolean f27198a;

    /* renamed from: b */
    public final boolean f27199b;

    /* renamed from: c */
    public final StringBuilder f27200c;

    /* renamed from: d */
    public final int[] f27201d;

    static {
        int[] iArr = {52, 289, 97, TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_NOTIFICATION, 400, 208, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD, 388, aj.e.f201j, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_INDEPENDENT_PROCESS, 168, 162, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, 42};
        f27196g = iArr;
        f27197h = iArr[39];
    }

    public d() {
        this(false);
    }

    public static String h(CharSequence charSequence) throws FormatException {
        int i10;
        char c10;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i11 = 0;
        while (i11 < length) {
            char charAt = charSequence.charAt(i11);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                i11++;
                char charAt2 = charSequence.charAt(i11);
                if (charAt != '$') {
                    if (charAt != '%') {
                        if (charAt != '+') {
                            if (charAt != '/') {
                                c10 = 0;
                            } else if (charAt2 >= 'A' && charAt2 <= 'O') {
                                i10 = charAt2 - ' ';
                            } else {
                                if (charAt2 != 'Z') {
                                    throw FormatException.getFormatInstance();
                                }
                                c10 = m5.d.f28378d;
                            }
                            sb2.append(c10);
                        } else {
                            if (charAt2 < 'A' || charAt2 > 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            i10 = charAt2 + b5.a.O;
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                        i10 = charAt2 - '&';
                    } else {
                        if (charAt2 < 'F' || charAt2 > 'W') {
                            throw FormatException.getFormatInstance();
                        }
                        i10 = charAt2 + g6.b.f26162f;
                    }
                } else {
                    if (charAt2 < 'A' || charAt2 > 'Z') {
                        throw FormatException.getFormatInstance();
                    }
                    i10 = charAt2 - '@';
                }
                c10 = (char) i10;
                sb2.append(c10);
            } else {
                sb2.append(charAt);
            }
            i11++;
        }
        return sb2.toString();
    }

    public static int[] i(z5.a aVar, int[] iArr) throws NotFoundException {
        int l10 = aVar.l();
        int j10 = aVar.j(0);
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
                    if (k(iArr) == f27197h && aVar.n(Math.max(0, i10 - ((j10 - i10) / 2)), i10, false)) {
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

    public static char j(int i10) throws NotFoundException {
        int i11 = 0;
        while (true) {
            int[] iArr = f27196g;
            if (i11 >= iArr.length) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (iArr[i11] == i10) {
                return f27194e.charAt(i11);
            }
            i11++;
        }
    }

    public static int k(int[] iArr) {
        int length = iArr.length;
        int i10 = 0;
        while (true) {
            int i11 = Integer.MAX_VALUE;
            for (int i12 : iArr) {
                if (i12 < i11 && i12 > i10) {
                    i11 = i12;
                }
            }
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                int i17 = iArr[i16];
                if (i17 > i11) {
                    i14 |= 1 << ((length - 1) - i16);
                    i13++;
                    i15 += i17;
                }
            }
            if (i13 == 3) {
                for (int i18 = 0; i18 < length && i13 > 0; i18++) {
                    int i19 = iArr[i18];
                    if (i19 > i11) {
                        i13--;
                        if ((i19 << 1) >= i15) {
                            return -1;
                        }
                    }
                }
                return i14;
            }
            if (i13 <= 3) {
                return -1;
            }
            i10 = i11;
        }
    }

    @Override // j6.q
    public t5.k c(int i10, z5.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] iArr = this.f27201d;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f27200c;
        sb2.setLength(0);
        int j10 = aVar.j(i(aVar, iArr)[1]);
        int l10 = aVar.l();
        while (true) {
            q.f(aVar, j10, iArr);
            int k10 = k(iArr);
            if (k10 < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char j11 = j(k10);
            sb2.append(j11);
            int i11 = j10;
            for (int i12 : iArr) {
                i11 += i12;
            }
            int j12 = aVar.j(i11);
            if (j11 == '*') {
                sb2.setLength(sb2.length() - 1);
                int i13 = 0;
                for (int i14 : iArr) {
                    i13 += i14;
                }
                int i15 = (j12 - j10) - i13;
                if (j12 != l10 && (i15 << 1) < i13) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (this.f27198a) {
                    int length = sb2.length() - 1;
                    int i16 = 0;
                    for (int i17 = 0; i17 < length; i17++) {
                        i16 += f27195f.indexOf(this.f27200c.charAt(i17));
                    }
                    if (sb2.charAt(length) != f27195f.charAt(i16 % 43)) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    sb2.setLength(length);
                }
                if (sb2.length() == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                float f10 = i10;
                return new t5.k(this.f27199b ? h(sb2) : sb2.toString(), null, new t5.l[]{new t5.l((r2[1] + r2[0]) / 2.0f, f10), new t5.l(j10 + (i13 / 2.0f), f10)}, BarcodeFormat.CODE_39);
            }
            j10 = j12;
        }
    }

    public d(boolean z10) {
        this(z10, false);
    }

    public d(boolean z10, boolean z11) {
        this.f27198a = z10;
        this.f27199b = z11;
        this.f27200c = new StringBuilder(20);
        this.f27201d = new int[9];
    }
}
