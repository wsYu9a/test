package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.ic.dm.Downloads;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public final class d extends q {

    /* renamed from: a */
    static final String f8561a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";

    /* renamed from: b */
    private static final String f8562b = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";

    /* renamed from: c */
    static final int[] f8563c;

    /* renamed from: d */
    static final int f8564d;

    /* renamed from: e */
    private final boolean f8565e;

    /* renamed from: f */
    private final boolean f8566f;

    /* renamed from: g */
    private final StringBuilder f8567g;

    /* renamed from: h */
    private final int[] f8568h;

    static {
        int[] iArr = {52, 289, 97, TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, Downloads.Impl.STATUS_PAUSED_BY_APP, 448, 145, 400, 208, 133, 388, 196, 148, 168, 162, 138, 42};
        f8563c = iArr;
        f8564d = iArr[39];
    }

    public d() {
        this(false);
    }

    private static String h(CharSequence charSequence) throws FormatException {
        int i2;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                i3++;
                char charAt2 = charSequence.charAt(i3);
                if (charAt != '$') {
                    if (charAt != '%') {
                        if (charAt != '+') {
                            if (charAt != '/') {
                                c2 = 0;
                            } else if (charAt2 >= 'A' && charAt2 <= 'O') {
                                i2 = charAt2 - ' ';
                            } else {
                                if (charAt2 != 'Z') {
                                    throw FormatException.getFormatInstance();
                                }
                                c2 = ':';
                            }
                            sb.append(c2);
                        } else {
                            if (charAt2 < 'A' || charAt2 > 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            i2 = charAt2 + ' ';
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                        i2 = charAt2 - '&';
                    } else {
                        if (charAt2 < 'F' || charAt2 > 'W') {
                            throw FormatException.getFormatInstance();
                        }
                        i2 = charAt2 - 11;
                    }
                } else {
                    if (charAt2 < 'A' || charAt2 > 'Z') {
                        throw FormatException.getFormatInstance();
                    }
                    i2 = charAt2 - '@';
                }
                c2 = (char) i2;
                sb.append(c2);
            } else {
                sb.append(charAt);
            }
            i3++;
        }
        return sb.toString();
    }

    private static int[] i(com.google.zxing.common.a aVar, int[] iArr) throws NotFoundException {
        int l = aVar.l();
        int j2 = aVar.j(0);
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
                    if (k(iArr) == f8564d && aVar.n(Math.max(0, i2 - ((j2 - i2) / 2)), i2, false)) {
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

    private static char j(int i2) throws NotFoundException {
        int i3 = 0;
        while (true) {
            int[] iArr = f8563c;
            if (i3 >= iArr.length) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (iArr[i3] == i2) {
                return f8561a.charAt(i3);
            }
            i3++;
        }
    }

    private static int k(int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > i2) {
                    i3 = i4;
                }
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                int i9 = iArr[i8];
                if (i9 > i3) {
                    i6 |= 1 << ((length - 1) - i8);
                    i5++;
                    i7 += i9;
                }
            }
            if (i5 == 3) {
                for (int i10 = 0; i10 < length && i5 > 0; i10++) {
                    int i11 = iArr[i10];
                    if (i11 > i3) {
                        i5--;
                        if ((i11 << 1) >= i7) {
                            return -1;
                        }
                    }
                }
                return i6;
            }
            if (i5 <= 3) {
                return -1;
            }
            i2 = i3;
        }
    }

    @Override // com.google.zxing.oned.q
    public com.google.zxing.k b(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] iArr = this.f8568h;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f8567g;
        sb.setLength(0);
        int j2 = aVar.j(i(aVar, iArr)[1]);
        int l = aVar.l();
        while (true) {
            q.f(aVar, j2, iArr);
            int k = k(iArr);
            if (k < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char j3 = j(k);
            sb.append(j3);
            int i3 = j2;
            for (int i4 : iArr) {
                i3 += i4;
            }
            int j4 = aVar.j(i3);
            if (j3 == '*') {
                sb.setLength(sb.length() - 1);
                int i5 = 0;
                for (int i6 : iArr) {
                    i5 += i6;
                }
                int i7 = (j4 - j2) - i5;
                if (j4 != l && (i7 << 1) < i5) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (this.f8565e) {
                    int length = sb.length() - 1;
                    int i8 = 0;
                    for (int i9 = 0; i9 < length; i9++) {
                        i8 += f8562b.indexOf(this.f8567g.charAt(i9));
                    }
                    if (sb.charAt(length) != f8562b.charAt(i8 % 43)) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                float f2 = i2;
                return new com.google.zxing.k(this.f8566f ? h(sb) : sb.toString(), null, new com.google.zxing.l[]{new com.google.zxing.l((r2[1] + r2[0]) / 2.0f, f2), new com.google.zxing.l(j2 + (i5 / 2.0f), f2)}, BarcodeFormat.CODE_39);
            }
            j2 = j4;
        }
    }

    public d(boolean z) {
        this(z, false);
    }

    public d(boolean z, boolean z2) {
        this.f8565e = z;
        this.f8566f = z2;
        this.f8567g = new StringBuilder(20);
        this.f8568h = new int[9];
    }
}
