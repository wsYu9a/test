package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
final class u {

    /* renamed from: a */
    private final int[] f8631a = new int[4];

    /* renamed from: b */
    private final StringBuilder f8632b = new StringBuilder();

    u() {
    }

    private int a(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f8631a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int l = aVar.l();
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 2 && i2 < l; i4++) {
            int j2 = x.j(aVar, iArr2, i2, x.f8645g);
            sb.append((char) ((j2 % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (j2 >= 10) {
                i3 |= 1 << (1 - i4);
            }
            if (i4 != 1) {
                i2 = aVar.k(aVar.j(i2));
            }
        }
        if (sb.length() != 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (Integer.parseInt(sb.toString()) % 4 == i3) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static Map<ResultMetadataType, Object> c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put((EnumMap) ResultMetadataType.ISSUE_NUMBER, (ResultMetadataType) Integer.valueOf(str));
        return enumMap;
    }

    com.google.zxing.k b(int i2, com.google.zxing.common.a aVar, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.f8632b;
        sb.setLength(0);
        int a2 = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map<ResultMetadataType, Object> c2 = c(sb2);
        float f2 = i2;
        com.google.zxing.k kVar = new com.google.zxing.k(sb2, null, new com.google.zxing.l[]{new com.google.zxing.l((iArr[0] + iArr[1]) / 2.0f, f2), new com.google.zxing.l(a2, f2)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (c2 != null) {
            kVar.i(c2);
        }
        return kVar;
    }
}
