package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class x extends q {

    /* renamed from: a */
    private static final float f8639a = 0.48f;

    /* renamed from: b */
    private static final float f8640b = 0.7f;

    /* renamed from: c */
    static final int[] f8641c = {1, 1, 1};

    /* renamed from: d */
    static final int[] f8642d = {1, 1, 1, 1, 1};

    /* renamed from: e */
    static final int[] f8643e = {1, 1, 1, 1, 1, 1};

    /* renamed from: f */
    static final int[][] f8644f;

    /* renamed from: g */
    static final int[][] f8645g;

    /* renamed from: h */
    private final StringBuilder f8646h = new StringBuilder(20);

    /* renamed from: i */
    private final w f8647i = new w();

    /* renamed from: j */
    private final l f8648j = new l();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f8644f = iArr;
        int[][] iArr2 = new int[20][];
        f8645g = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i2 = 10; i2 < 20; i2++) {
            int[] iArr3 = f8644f[i2 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i3 = 0; i3 < iArr3.length; i3++) {
                iArr4[i3] = iArr3[(iArr3.length - i3) - 1];
            }
            f8645g[i2] = iArr4;
        }
    }

    protected x() {
    }

    static boolean i(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i2 = 0;
        for (int i3 = length - 2; i3 >= 0; i3 -= 2) {
            int charAt = charSequence.charAt(i3) - '0';
            if (charAt < 0 || charAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i2 += charAt;
        }
        int i4 = i2 * 3;
        for (int i5 = length - 1; i5 >= 0; i5 -= 2) {
            int charAt2 = charSequence.charAt(i5) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i4 += charAt2;
        }
        return i4 % 10 == 0;
    }

    static int j(com.google.zxing.common.a aVar, int[] iArr, int i2, int[][] iArr2) throws NotFoundException {
        q.f(aVar, i2, iArr);
        int length = iArr2.length;
        float f2 = f8639a;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            float e2 = q.e(iArr, iArr2[i4], f8640b);
            if (e2 < f2) {
                i3 = i4;
                f2 = e2;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    static int[] n(com.google.zxing.common.a aVar, int i2, boolean z, int[] iArr) throws NotFoundException {
        return o(aVar, i2, z, iArr, new int[iArr.length]);
    }

    private static int[] o(com.google.zxing.common.a aVar, int i2, boolean z, int[] iArr, int[] iArr2) throws NotFoundException {
        int l = aVar.l();
        int k = z ? aVar.k(i2) : aVar.j(i2);
        int length = iArr.length;
        boolean z2 = z;
        int i3 = 0;
        int i4 = k;
        while (k < l) {
            if (aVar.h(k) ^ z2) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                int i5 = length - 1;
                if (i3 != i5) {
                    i3++;
                } else {
                    if (q.e(iArr2, iArr, f8640b) < f8639a) {
                        return new int[]{i4, k};
                    }
                    i4 += iArr2[0] + iArr2[1];
                    int i6 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i5] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z2 = !z2;
            }
            k++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    static int[] p(com.google.zxing.common.a aVar) throws NotFoundException {
        int[] iArr = new int[f8641c.length];
        int[] iArr2 = null;
        boolean z = false;
        int i2 = 0;
        while (!z) {
            int[] iArr3 = f8641c;
            Arrays.fill(iArr, 0, iArr3.length, 0);
            iArr2 = o(aVar, i2, false, iArr3, iArr);
            int i3 = iArr2[0];
            int i4 = iArr2[1];
            int i5 = i3 - (i4 - i3);
            if (i5 >= 0) {
                z = aVar.n(i5, i3, false);
            }
            i2 = i4;
        }
        return iArr2;
    }

    @Override // com.google.zxing.oned.q
    public com.google.zxing.k b(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return m(i2, aVar, p(aVar), map);
    }

    boolean h(String str) throws FormatException {
        return i(str);
    }

    int[] k(com.google.zxing.common.a aVar, int i2) throws NotFoundException {
        return n(aVar, i2, false, f8641c);
    }

    protected abstract int l(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException;

    public com.google.zxing.k m(int i2, com.google.zxing.common.a aVar, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int i3;
        String c2;
        com.google.zxing.m mVar = map == null ? null : (com.google.zxing.m) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        boolean z = true;
        if (mVar != null) {
            mVar.a(new com.google.zxing.l((iArr[0] + iArr[1]) / 2.0f, i2));
        }
        StringBuilder sb = this.f8646h;
        sb.setLength(0);
        int l = l(aVar, iArr, sb);
        if (mVar != null) {
            mVar.a(new com.google.zxing.l(l, i2));
        }
        int[] k = k(aVar, l);
        if (mVar != null) {
            mVar.a(new com.google.zxing.l((k[0] + k[1]) / 2.0f, i2));
        }
        int i4 = k[1];
        int i5 = (i4 - k[0]) + i4;
        if (i5 >= aVar.l() || !aVar.n(i4, i5, false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        String sb2 = sb.toString();
        if (sb2.length() < 8) {
            throw FormatException.getFormatInstance();
        }
        if (!h(sb2)) {
            throw ChecksumException.getChecksumInstance();
        }
        BarcodeFormat q = q();
        float f2 = i2;
        com.google.zxing.k kVar = new com.google.zxing.k(sb2, null, new com.google.zxing.l[]{new com.google.zxing.l((iArr[1] + iArr[0]) / 2.0f, f2), new com.google.zxing.l((k[1] + k[0]) / 2.0f, f2)}, q);
        try {
            com.google.zxing.k a2 = this.f8647i.a(i2, aVar, k[1]);
            kVar.j(ResultMetadataType.UPC_EAN_EXTENSION, a2.g());
            kVar.i(a2.e());
            kVar.a(a2.f());
            i3 = a2.g().length();
        } catch (ReaderException unused) {
            i3 = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            int length = iArr2.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    z = false;
                    break;
                }
                if (i3 == iArr2[i6]) {
                    break;
                }
                i6++;
            }
            if (!z) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        if ((q == BarcodeFormat.EAN_13 || q == BarcodeFormat.UPC_A) && (c2 = this.f8648j.c(sb2)) != null) {
            kVar.j(ResultMetadataType.POSSIBLE_COUNTRY, c2);
        }
        return kVar;
    }

    abstract BarcodeFormat q();
}
