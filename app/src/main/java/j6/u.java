package j6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class u {

    /* renamed from: a */
    public final int[] f27230a = new int[4];

    /* renamed from: b */
    public final StringBuilder f27231b = new StringBuilder();

    public static Map<ResultMetadataType, Object> c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put((EnumMap) ResultMetadataType.ISSUE_NUMBER, (ResultMetadataType) Integer.valueOf(str));
        return enumMap;
    }

    public final int a(z5.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f27230a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int l10 = aVar.l();
        int i10 = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 2 && i10 < l10; i12++) {
            int j10 = x.j(aVar, iArr2, i10, x.f27244j);
            sb2.append((char) ((j10 % 10) + 48));
            for (int i13 : iArr2) {
                i10 += i13;
            }
            if (j10 >= 10) {
                i11 |= 1 << (1 - i12);
            }
            if (i12 != 1) {
                i10 = aVar.k(aVar.j(i10));
            }
        }
        if (sb2.length() != 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (Integer.parseInt(sb2.toString()) % 4 == i11) {
            return i10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public t5.k b(int i10, z5.a aVar, int[] iArr) throws NotFoundException {
        StringBuilder sb2 = this.f27231b;
        sb2.setLength(0);
        int a10 = a(aVar, iArr, sb2);
        String sb3 = sb2.toString();
        Map<ResultMetadataType, Object> c10 = c(sb3);
        float f10 = i10;
        t5.k kVar = new t5.k(sb3, null, new t5.l[]{new t5.l((iArr[0] + iArr[1]) / 2.0f, f10), new t5.l(a10, f10)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (c10 != null) {
            kVar.i(c10);
        }
        return kVar;
    }
}
