package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
final class v {

    /* renamed from: a */
    private static final int[] f8633a = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: b */
    private final int[] f8634b = new int[4];

    /* renamed from: c */
    private final StringBuilder f8635c = new StringBuilder();

    v() {
    }

    private int a(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f8634b;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int l = aVar.l();
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 5 && i2 < l; i4++) {
            int j2 = x.j(aVar, iArr2, i2, x.f8645g);
            sb.append((char) ((j2 % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (j2 >= 10) {
                i3 |= 1 << (4 - i4);
            }
            if (i4 != 4) {
                i2 = aVar.k(aVar.j(i2));
            }
        }
        if (sb.length() != 5) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (d(sb.toString()) == c(i3)) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int c(int i2) throws NotFoundException {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == f8633a[i3]) {
                return i3;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        for (int i3 = length - 2; i3 >= 0; i3 -= 2) {
            i2 += charSequence.charAt(i3) - '0';
        }
        int i4 = i2 * 3;
        for (int i5 = length - 1; i5 >= 0; i5 -= 2) {
            i4 += charSequence.charAt(i5) - '0';
        }
        return (i4 * 3) % 10;
    }

    private static String e(String str) {
        String valueOf;
        char charAt = str.charAt(0);
        String str2 = "";
        if (charAt == '0') {
            str2 = "£";
        } else if (charAt == '5') {
            str2 = "$";
        } else if (charAt == '9') {
            if ("90000".equals(str)) {
                return null;
            }
            if ("99991".equals(str)) {
                return "0.00";
            }
            if ("99990".equals(str)) {
                return "Used";
            }
        }
        int parseInt = Integer.parseInt(str.substring(1));
        String valueOf2 = String.valueOf(parseInt / 100);
        int i2 = parseInt % 100;
        if (i2 < 10) {
            valueOf = "0" + i2;
        } else {
            valueOf = String.valueOf(i2);
        }
        return str2 + valueOf2 + '.' + valueOf;
    }

    private static Map<ResultMetadataType, Object> f(String str) {
        String e2;
        if (str.length() != 5 || (e2 = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put((EnumMap) ResultMetadataType.SUGGESTED_PRICE, (ResultMetadataType) e2);
        return enumMap;
    }

    com.google.zxing.k b(int i2, com.google.zxing.common.a aVar, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.f8635c;
        sb.setLength(0);
        int a2 = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map<ResultMetadataType, Object> f2 = f(sb2);
        float f3 = i2;
        com.google.zxing.k kVar = new com.google.zxing.k(sb2, null, new com.google.zxing.l[]{new com.google.zxing.l((iArr[0] + iArr[1]) / 2.0f, f3), new com.google.zxing.l(a2, f3)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (f2 != null) {
            kVar.i(f2);
        }
        return kVar;
    }
}
