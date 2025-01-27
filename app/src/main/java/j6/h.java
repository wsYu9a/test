package j6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class h extends x {

    /* renamed from: l */
    public static final int[] f27208l = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: k */
    public final int[] f27209k = new int[4];

    public static void r(StringBuilder sb2, int i10) throws NotFoundException {
        for (int i11 = 0; i11 < 10; i11++) {
            if (i10 == f27208l[i11]) {
                sb2.insert(0, (char) (i11 + 48));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // j6.x
    public int l(z5.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f27209k;
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
        r(sb2, i11);
        int i14 = x.n(aVar, i10, true, x.f27241g)[1];
        for (int i15 = 0; i15 < 6 && i14 < l10; i15++) {
            sb2.append((char) (x.j(aVar, iArr2, i14, x.f27243i) + 48));
            for (int i16 : iArr2) {
                i14 += i16;
            }
        }
        return i14;
    }

    @Override // j6.x
    public BarcodeFormat q() {
        return BarcodeFormat.EAN_13;
    }
}
