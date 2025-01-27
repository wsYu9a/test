package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* loaded from: classes.dex */
public final class z extends x {
    static final int[] k = {56, 52, 50, 49, 44, 38, 35, 42, 41, 37};
    private static final int[] l = {1, 1, 1, 1, 1, 1};
    private static final int[][] m = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    private final int[] n = new int[4];

    public static String r(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c2 = cArr[5];
        switch (c2) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c2);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c2);
                break;
        }
        sb.append(str.charAt(7));
        return sb.toString();
    }

    private static void s(StringBuilder sb, int i2) throws NotFoundException {
        for (int i3 = 0; i3 <= 1; i3++) {
            for (int i4 = 0; i4 < 10; i4++) {
                if (i2 == m[i3][i4]) {
                    sb.insert(0, (char) (i3 + 48));
                    sb.append((char) (i4 + 48));
                    return;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.x
    protected boolean h(String str) throws FormatException {
        return super.h(r(str));
    }

    @Override // com.google.zxing.oned.x
    protected int[] k(com.google.zxing.common.a aVar, int i2) throws NotFoundException {
        return x.n(aVar, i2, true, l);
    }

    @Override // com.google.zxing.oned.x
    protected int l(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.n;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int l2 = aVar.l();
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 6 && i2 < l2; i4++) {
            int j2 = x.j(aVar, iArr2, i2, x.f8645g);
            sb.append((char) ((j2 % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (j2 >= 10) {
                i3 |= 1 << (5 - i4);
            }
        }
        s(sb, i3);
        return i2;
    }

    @Override // com.google.zxing.oned.x
    BarcodeFormat q() {
        return BarcodeFormat.UPC_E;
    }
}
