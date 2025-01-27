package com.google.zxing.oned;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class q implements com.google.zxing.j {
    /* JADX WARN: Removed duplicated region for block: B:36:0x007d A[Catch: ReaderException -> 0x00c6, TryCatch #0 {ReaderException -> 0x00c6, blocks: (B:34:0x0077, B:36:0x007d, B:38:0x008e), top: B:33:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.zxing.k d(com.google.zxing.b r22, java.util.Map<com.google.zxing.DecodeHintType, ?> r23) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.q.d(com.google.zxing.b, java.util.Map):com.google.zxing.k");
    }

    protected static float e(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f7 = iArr2[i5] * f4;
            float f8 = iArr[i5];
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }

    protected static void f(com.google.zxing.common.a aVar, int i2, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i3 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int l = aVar.l();
        if (i2 >= l) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z = !aVar.h(i2);
        while (i2 < l) {
            if (!(aVar.h(i2) ^ z)) {
                i3++;
                if (i3 == length) {
                    break;
                }
                iArr[i3] = 1;
                z = !z;
            } else {
                iArr[i3] = iArr[i3] + 1;
            }
            i2++;
        }
        if (i3 != length) {
            if (i3 != length - 1 || i2 != l) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    protected static void g(com.google.zxing.common.a aVar, int i2, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean h2 = aVar.h(i2);
        while (i2 > 0 && length >= 0) {
            i2--;
            if (aVar.h(i2) != h2) {
                length--;
                h2 = !h2;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        f(aVar, i2 + 1, iArr);
    }

    @Override // com.google.zxing.j
    public com.google.zxing.k a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return d(bVar, map);
        } catch (NotFoundException e2) {
            if (!(map != null && map.containsKey(DecodeHintType.TRY_HARDER)) || !bVar.g()) {
                throw e2;
            }
            com.google.zxing.b h2 = bVar.h();
            com.google.zxing.k d2 = d(h2, map);
            Map<ResultMetadataType, Object> e3 = d2.e();
            int i2 = 270;
            if (e3 != null) {
                ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
                if (e3.containsKey(resultMetadataType)) {
                    i2 = (((Integer) e3.get(resultMetadataType)).intValue() + 270) % 360;
                }
            }
            d2.j(ResultMetadataType.ORIENTATION, Integer.valueOf(i2));
            com.google.zxing.l[] f2 = d2.f();
            if (f2 != null) {
                int d3 = h2.d();
                for (int i3 = 0; i3 < f2.length; i3++) {
                    f2[i3] = new com.google.zxing.l((d3 - f2[i3].d()) - 1.0f, f2[i3].c());
                }
            }
            return d2;
        }
    }

    public abstract com.google.zxing.k b(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    @Override // com.google.zxing.j
    public com.google.zxing.k c(com.google.zxing.b bVar) throws NotFoundException, FormatException {
        return a(bVar, null);
    }

    @Override // com.google.zxing.j
    public void reset() {
    }
}
