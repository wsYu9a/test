package j6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class j extends x {

    /* renamed from: k */
    public final int[] f27211k = new int[4];

    @Override // j6.x
    public int l(z5.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f27211k;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int l10 = aVar.l();
        int i10 = iArr[1];
        for (int i11 = 0; i11 < 4 && i10 < l10; i11++) {
            sb2.append((char) (x.j(aVar, iArr2, i10, x.f27243i) + 48));
            for (int i12 : iArr2) {
                i10 += i12;
            }
        }
        int i13 = x.n(aVar, i10, true, x.f27241g)[1];
        for (int i14 = 0; i14 < 4 && i13 < l10; i14++) {
            sb2.append((char) (x.j(aVar, iArr2, i13, x.f27243i) + 48));
            for (int i15 : iArr2) {
                i13 += i15;
            }
        }
        return i13;
    }

    @Override // j6.x
    public BarcodeFormat q() {
        return BarcodeFormat.EAN_8;
    }
}
