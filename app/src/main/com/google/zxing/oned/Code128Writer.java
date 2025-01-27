package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import j6.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.mozilla.universalchardet.prober.g;
import z5.b;
import zi.c;

/* loaded from: classes2.dex */
public final class Code128Writer extends r {

    /* renamed from: a */
    public static final int f10573a = 104;

    /* renamed from: b */
    public static final int f10574b = 105;

    /* renamed from: c */
    public static final int f10575c = 100;

    /* renamed from: d */
    public static final int f10576d = 99;

    /* renamed from: e */
    public static final int f10577e = 106;

    /* renamed from: f */
    public static final char f10578f = 241;

    /* renamed from: g */
    public static final char f10579g = 242;

    /* renamed from: h */
    public static final char f10580h = 243;

    /* renamed from: i */
    public static final char f10581i = 244;

    /* renamed from: j */
    public static final int f10582j = 102;

    /* renamed from: k */
    public static final int f10583k = 97;

    /* renamed from: l */
    public static final int f10584l = 96;

    /* renamed from: m */
    public static final int f10585m = 100;

    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public static int g(CharSequence charSequence, int i10, int i11) {
        CType cType;
        CType h10;
        CType h11 = h(charSequence, i10);
        CType cType2 = CType.UNCODABLE;
        if (h11 != cType2 && h11 != (cType = CType.ONE_DIGIT)) {
            if (i11 == 99) {
                return i11;
            }
            if (i11 == 100) {
                CType cType3 = CType.FNC_1;
                if (h11 == cType3) {
                    return i11;
                }
                CType h12 = h(charSequence, i10 + 2);
                if (h12 == cType2 || h12 == cType) {
                    return i11;
                }
                if (h12 == cType3) {
                    return h(charSequence, i10 + 3) == CType.TWO_DIGITS ? 99 : 100;
                }
                int i12 = i10 + 4;
                while (true) {
                    h10 = h(charSequence, i12);
                    if (h10 != CType.TWO_DIGITS) {
                        break;
                    }
                    i12 += 2;
                }
                return h10 == CType.ONE_DIGIT ? 100 : 99;
            }
            if (h11 == CType.FNC_1) {
                h11 = h(charSequence, i10 + 1);
            }
            if (h11 == CType.TWO_DIGITS) {
                return 99;
            }
        }
        return 100;
    }

    public static CType h(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        if (i10 >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i10);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i11 = i10 + 1;
        if (i11 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i11);
        return (charAt2 < '0' || charAt2 > '9') ? CType.ONE_DIGIT : CType.TWO_DIGITS;
    }

    @Override // j6.r, t5.n
    public b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    @Override // j6.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    case c.f33842o /* 241 */:
                    case 242:
                    case 243:
                    case g.f29296w /* 244 */:
                        break;
                    default:
                        throw new IllegalArgumentException("Bad character in input: " + charAt);
                }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1;
        while (i12 < length) {
            int g10 = g(str, i12, i14);
            int i16 = 100;
            if (g10 == i14) {
                switch (str.charAt(i12)) {
                    case c.f33842o /* 241 */:
                        i16 = 102;
                        break;
                    case 242:
                        i16 = 97;
                        break;
                    case 243:
                        i16 = 96;
                        break;
                    case g.f29296w /* 244 */:
                        break;
                    default:
                        if (i14 == 100) {
                            i16 = str.charAt(i12) - ' ';
                            break;
                        } else {
                            i16 = Integer.parseInt(str.substring(i12, i12 + 2));
                            i12++;
                            break;
                        }
                }
                i12++;
            } else {
                i16 = i14 == 0 ? g10 == 100 ? 104 : 105 : g10;
                i14 = g10;
            }
            arrayList.add(j6.c.f27178a[i16]);
            i13 += i16 * i15;
            if (i12 != 0) {
                i15++;
            }
        }
        int[][] iArr = j6.c.f27178a;
        arrayList.add(iArr[i13 % 103]);
        arrayList.add(iArr[106]);
        int i17 = 0;
        for (int[] iArr2 : arrayList) {
            for (int i18 : iArr2) {
                i17 += i18;
            }
        }
        boolean[] zArr = new boolean[i17];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            i10 += r.c(zArr, i10, (int[]) it.next(), true);
        }
        return zArr;
    }
}
