package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class Code128Writer extends r {

    /* renamed from: a */
    private static final int f8502a = 104;

    /* renamed from: b */
    private static final int f8503b = 105;

    /* renamed from: c */
    private static final int f8504c = 100;

    /* renamed from: d */
    private static final int f8505d = 99;

    /* renamed from: e */
    private static final int f8506e = 106;

    /* renamed from: f */
    private static final char f8507f = 241;

    /* renamed from: g */
    private static final char f8508g = 242;

    /* renamed from: h */
    private static final char f8509h = 243;

    /* renamed from: i */
    private static final char f8510i = 244;

    /* renamed from: j */
    private static final int f8511j = 102;
    private static final int k = 97;
    private static final int l = 96;
    private static final int m = 100;

    private enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int g(CharSequence charSequence, int i2, int i3) {
        CType cType;
        CType h2;
        CType h3;
        CType h4 = h(charSequence, i2);
        CType cType2 = CType.UNCODABLE;
        if (h4 != cType2 && h4 != (cType = CType.ONE_DIGIT)) {
            if (i3 == 99) {
                return i3;
            }
            if (i3 == 100) {
                CType cType3 = CType.FNC_1;
                if (h4 == cType3 || (h2 = h(charSequence, i2 + 2)) == cType2 || h2 == cType) {
                    return i3;
                }
                if (h2 == cType3) {
                    return h(charSequence, i2 + 3) == CType.TWO_DIGITS ? 99 : 100;
                }
                int i4 = i2 + 4;
                while (true) {
                    h3 = h(charSequence, i4);
                    if (h3 != CType.TWO_DIGITS) {
                        break;
                    }
                    i4 += 2;
                }
                return h3 == CType.ONE_DIGIT ? 100 : 99;
            }
            if (h4 == CType.FNC_1) {
                h4 = h(charSequence, i2 + 1);
            }
            if (h4 == CType.TWO_DIGITS) {
                return 99;
            }
        }
        return 100;
    }

    private static CType h(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        if (i2 >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i2);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i3 = i2 + 1;
        if (i3 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i3);
        return (charAt2 < '0' || charAt2 > '9') ? CType.ONE_DIGIT : CType.TWO_DIGITS;
    }

    @Override // com.google.zxing.oned.r, com.google.zxing.n
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    case org.mozilla.universalchardet.prober.n.c.o /* 241 */:
                    case 242:
                    case 243:
                    case org.mozilla.universalchardet.prober.g.p /* 244 */:
                        break;
                    default:
                        throw new IllegalArgumentException("Bad character in input: " + charAt);
                }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1;
        while (i4 < length) {
            int g2 = g(str, i4, i6);
            int i8 = 100;
            if (g2 == i6) {
                switch (str.charAt(i4)) {
                    case org.mozilla.universalchardet.prober.n.c.o /* 241 */:
                        i8 = 102;
                        break;
                    case 242:
                        i8 = 97;
                        break;
                    case 243:
                        i8 = 96;
                        break;
                    case org.mozilla.universalchardet.prober.g.p /* 244 */:
                        break;
                    default:
                        if (i6 == 100) {
                            i8 = str.charAt(i4) - ' ';
                            break;
                        } else {
                            i8 = Integer.parseInt(str.substring(i4, i4 + 2));
                            i4++;
                            break;
                        }
                }
                i4++;
            } else {
                i8 = i6 == 0 ? g2 == 100 ? 104 : 105 : g2;
                i6 = g2;
            }
            arrayList.add(c.f8551a[i8]);
            i5 += i8 * i7;
            if (i4 != 0) {
                i7++;
            }
        }
        int[][] iArr = c.f8551a;
        arrayList.add(iArr[i5 % 103]);
        arrayList.add(iArr[106]);
        int i9 = 0;
        for (int[] iArr2 : arrayList) {
            for (int i10 : iArr2) {
                i9 += i10;
            }
        }
        boolean[] zArr = new boolean[i9];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            i2 += r.c(zArr, i2, (int[]) it.next(), true);
        }
        return zArr;
    }
}
