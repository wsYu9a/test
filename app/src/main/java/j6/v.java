package j6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class v {

    /* renamed from: c */
    public static final int[] f27232c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: a */
    public final int[] f27233a = new int[4];

    /* renamed from: b */
    public final StringBuilder f27234b = new StringBuilder();

    public static int c(int i10) throws NotFoundException {
        for (int i11 = 0; i11 < 10; i11++) {
            if (i10 == f27232c[i11]) {
                return i11;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        for (int i11 = length - 2; i11 >= 0; i11 -= 2) {
            i10 += charSequence.charAt(i11) - '0';
        }
        int i12 = i10 * 3;
        for (int i13 = length - 1; i13 >= 0; i13 -= 2) {
            i12 += charSequence.charAt(i13) - '0';
        }
        return (i12 * 3) % 10;
    }

    public static String e(String str) {
        String str2;
        String valueOf;
        char charAt = str.charAt(0);
        if (charAt == '0') {
            str2 = "£";
        } else if (charAt != '5') {
            str2 = "";
            if (charAt == '9') {
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
        } else {
            str2 = "$";
        }
        int parseInt = Integer.parseInt(str.substring(1));
        String valueOf2 = String.valueOf(parseInt / 100);
        int i10 = parseInt % 100;
        if (i10 < 10) {
            valueOf = "0" + i10;
        } else {
            valueOf = String.valueOf(i10);
        }
        return str2 + valueOf2 + '.' + valueOf;
    }

    public static Map<ResultMetadataType, Object> f(String str) {
        String e10;
        if (str.length() != 5 || (e10 = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put((EnumMap) ResultMetadataType.SUGGESTED_PRICE, (ResultMetadataType) e10);
        return enumMap;
    }

    public final int a(z5.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f27233a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int l10 = aVar.l();
        int i10 = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 5 && i10 < l10; i12++) {
            int j10 = x.j(aVar, iArr2, i10, x.f27244j);
            sb2.append((char) ((j10 % 10) + 48));
            for (int i13 : iArr2) {
                i10 += i13;
            }
            if (j10 >= 10) {
                i11 |= 1 << (4 - i12);
            }
            if (i12 != 4) {
                i10 = aVar.k(aVar.j(i10));
            }
        }
        if (sb2.length() != 5) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (d(sb2.toString()) == c(i11)) {
            return i10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public t5.k b(int i10, z5.a aVar, int[] iArr) throws NotFoundException {
        StringBuilder sb2 = this.f27234b;
        sb2.setLength(0);
        int a10 = a(aVar, iArr, sb2);
        String sb3 = sb2.toString();
        Map<ResultMetadataType, Object> f10 = f(sb3);
        float f11 = i10;
        t5.k kVar = new t5.k(sb3, null, new t5.l[]{new t5.l((iArr[0] + iArr[1]) / 2.0f, f11), new t5.l(a10, f11)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (f10 != null) {
            kVar.i(f10);
        }
        return kVar;
    }
}
