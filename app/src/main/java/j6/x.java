package j6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class x extends q {

    /* renamed from: d */
    public static final float f27238d = 0.48f;

    /* renamed from: e */
    public static final float f27239e = 0.7f;

    /* renamed from: f */
    public static final int[] f27240f = {1, 1, 1};

    /* renamed from: g */
    public static final int[] f27241g = {1, 1, 1, 1, 1};

    /* renamed from: h */
    public static final int[] f27242h = {1, 1, 1, 1, 1, 1};

    /* renamed from: i */
    public static final int[][] f27243i;

    /* renamed from: j */
    public static final int[][] f27244j;

    /* renamed from: a */
    public final StringBuilder f27245a = new StringBuilder(20);

    /* renamed from: b */
    public final w f27246b = new w();

    /* renamed from: c */
    public final l f27247c = new l();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f27243i = iArr;
        int[][] iArr2 = new int[20][];
        f27244j = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i10 = 10; i10 < 20; i10++) {
            int[] iArr3 = f27243i[i10 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i11 = 0; i11 < iArr3.length; i11++) {
                iArr4[i11] = iArr3[(iArr3.length - i11) - 1];
            }
            f27244j[i10] = iArr4;
        }
    }

    public static boolean i(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i10 = 0;
        for (int i11 = length - 2; i11 >= 0; i11 -= 2) {
            int charAt = charSequence.charAt(i11) - '0';
            if (charAt < 0 || charAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i10 += charAt;
        }
        int i12 = i10 * 3;
        for (int i13 = length - 1; i13 >= 0; i13 -= 2) {
            int charAt2 = charSequence.charAt(i13) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i12 += charAt2;
        }
        return i12 % 10 == 0;
    }

    public static int j(z5.a aVar, int[] iArr, int i10, int[][] iArr2) throws NotFoundException {
        q.f(aVar, i10, iArr);
        int length = iArr2.length;
        float f10 = 0.48f;
        int i11 = -1;
        for (int i12 = 0; i12 < length; i12++) {
            float e10 = q.e(iArr, iArr2[i12], 0.7f);
            if (e10 < f10) {
                i11 = i12;
                f10 = e10;
            }
        }
        if (i11 >= 0) {
            return i11;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] n(z5.a aVar, int i10, boolean z10, int[] iArr) throws NotFoundException {
        return o(aVar, i10, z10, iArr, new int[iArr.length]);
    }

    public static int[] o(z5.a aVar, int i10, boolean z10, int[] iArr, int[] iArr2) throws NotFoundException {
        int l10 = aVar.l();
        int k10 = z10 ? aVar.k(i10) : aVar.j(i10);
        int length = iArr.length;
        boolean z11 = z10;
        int i11 = 0;
        int i12 = k10;
        while (k10 < l10) {
            if (aVar.h(k10) ^ z11) {
                iArr2[i11] = iArr2[i11] + 1;
            } else {
                int i13 = length - 1;
                if (i11 != i13) {
                    i11++;
                } else {
                    if (q.e(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i12, k10};
                    }
                    i12 += iArr2[0] + iArr2[1];
                    int i14 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i14);
                    iArr2[i14] = 0;
                    iArr2[i13] = 0;
                    i11--;
                }
                iArr2[i11] = 1;
                z11 = !z11;
            }
            k10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] p(z5.a aVar) throws NotFoundException {
        int[] iArr = new int[f27240f.length];
        int[] iArr2 = null;
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            int[] iArr3 = f27240f;
            Arrays.fill(iArr, 0, iArr3.length, 0);
            iArr2 = o(aVar, i10, false, iArr3, iArr);
            int i11 = iArr2[0];
            int i12 = iArr2[1];
            int i13 = i11 - (i12 - i11);
            if (i13 >= 0) {
                z10 = aVar.n(i13, i11, false);
            }
            i10 = i12;
        }
        return iArr2;
    }

    @Override // j6.q
    public t5.k c(int i10, z5.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return m(i10, aVar, p(aVar), map);
    }

    public boolean h(String str) throws FormatException {
        return i(str);
    }

    public int[] k(z5.a aVar, int i10) throws NotFoundException {
        return n(aVar, i10, false, f27240f);
    }

    public abstract int l(z5.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException;

    public t5.k m(int i10, z5.a aVar, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int i11;
        String c10;
        t5.m mVar = map == null ? null : (t5.m) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        if (mVar != null) {
            mVar.a(new t5.l((iArr[0] + iArr[1]) / 2.0f, i10));
        }
        StringBuilder sb2 = this.f27245a;
        sb2.setLength(0);
        int l10 = l(aVar, iArr, sb2);
        if (mVar != null) {
            mVar.a(new t5.l(l10, i10));
        }
        int[] k10 = k(aVar, l10);
        if (mVar != null) {
            mVar.a(new t5.l((k10[0] + k10[1]) / 2.0f, i10));
        }
        int i12 = k10[1];
        int i13 = (i12 - k10[0]) + i12;
        if (i13 >= aVar.l() || !aVar.n(i12, i13, false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        String sb3 = sb2.toString();
        if (sb3.length() < 8) {
            throw FormatException.getFormatInstance();
        }
        if (!h(sb3)) {
            throw ChecksumException.getChecksumInstance();
        }
        BarcodeFormat q10 = q();
        float f10 = i10;
        t5.k kVar = new t5.k(sb3, null, new t5.l[]{new t5.l((iArr[1] + iArr[0]) / 2.0f, f10), new t5.l((k10[1] + k10[0]) / 2.0f, f10)}, q10);
        try {
            t5.k a10 = this.f27246b.a(i10, aVar, k10[1]);
            kVar.j(ResultMetadataType.UPC_EAN_EXTENSION, a10.g());
            kVar.i(a10.e());
            kVar.a(a10.f());
            i11 = a10.g().length();
        } catch (ReaderException unused) {
            i11 = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            for (int i14 : iArr2) {
                if (i11 != i14) {
                }
            }
            throw NotFoundException.getNotFoundInstance();
        }
        if ((q10 == BarcodeFormat.EAN_13 || q10 == BarcodeFormat.UPC_A) && (c10 = this.f27247c.c(sb3)) != null) {
            kVar.j(ResultMetadataType.POSSIBLE_COUNTRY, c10);
        }
        return kVar;
    }

    public abstract BarcodeFormat q();
}
