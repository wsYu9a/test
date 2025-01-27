package j6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class z extends x {

    /* renamed from: l */
    public static final int[] f27248l = {56, 52, 50, 49, 44, 38, 35, 42, 41, 37};

    /* renamed from: m */
    public static final int[] f27249m = {1, 1, 1, 1, 1, 1};

    /* renamed from: n */
    public static final int[][] f27250n = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* renamed from: k */
    public final int[] f27251k = new int[4];

    public static String r(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb2 = new StringBuilder(12);
        sb2.append(str.charAt(0));
        char c10 = cArr[5];
        switch (c10) {
            case '0':
            case '1':
            case '2':
                sb2.append(cArr, 0, 2);
                sb2.append(c10);
                sb2.append("0000");
                sb2.append(cArr, 2, 3);
                break;
            case '3':
                sb2.append(cArr, 0, 3);
                sb2.append("00000");
                sb2.append(cArr, 3, 2);
                break;
            case '4':
                sb2.append(cArr, 0, 4);
                sb2.append("00000");
                sb2.append(cArr[4]);
                break;
            default:
                sb2.append(cArr, 0, 5);
                sb2.append("0000");
                sb2.append(c10);
                break;
        }
        sb2.append(str.charAt(7));
        return sb2.toString();
    }

    public static void s(StringBuilder sb2, int i10) throws NotFoundException {
        for (int i11 = 0; i11 <= 1; i11++) {
            for (int i12 = 0; i12 < 10; i12++) {
                if (i10 == f27250n[i11][i12]) {
                    sb2.insert(0, (char) (i11 + 48));
                    sb2.append((char) (i12 + 48));
                    return;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // j6.x
    public boolean h(String str) throws FormatException {
        return super.h(r(str));
    }

    @Override // j6.x
    public int[] k(z5.a aVar, int i10) throws NotFoundException {
        return x.n(aVar, i10, true, f27249m);
    }

    @Override // j6.x
    public int l(z5.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f27251k;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int l10 = aVar.l();
        int i10 = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 6 && i10 < l10; i12++) {
            int j10 = x.j(aVar, iArr2, i10, x.f27244j);
            sb2.append((char) ((j10 % 10) + 48));
            for (int i13 : iArr2) {
                i10 += i13;
            }
            if (j10 >= 10) {
                i11 |= 1 << (5 - i12);
            }
        }
        s(sb2, i11);
        return i10;
    }

    @Override // j6.x
    public BarcodeFormat q() {
        return BarcodeFormat.UPC_E;
    }
}
