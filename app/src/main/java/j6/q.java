package j6;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class q implements t5.j {
    public static float e(int[] iArr, int[] iArr2, float f10) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i10 += iArr[i12];
            i11 += iArr2[i12];
        }
        if (i10 < i11) {
            return Float.POSITIVE_INFINITY;
        }
        float f11 = i10;
        float f12 = f11 / i11;
        float f13 = f10 * f12;
        float f14 = 0.0f;
        for (int i13 = 0; i13 < length; i13++) {
            float f15 = iArr2[i13] * f12;
            float f16 = iArr[i13];
            float f17 = f16 > f15 ? f16 - f15 : f15 - f16;
            if (f17 > f13) {
                return Float.POSITIVE_INFINITY;
            }
            f14 += f17;
        }
        return f14 / f11;
    }

    public static void f(z5.a aVar, int i10, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i11 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int l10 = aVar.l();
        if (i10 >= l10) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z10 = !aVar.h(i10);
        while (i10 < l10) {
            if (!(aVar.h(i10) ^ z10)) {
                i11++;
                if (i11 == length) {
                    break;
                }
                iArr[i11] = 1;
                z10 = !z10;
            } else {
                iArr[i11] = iArr[i11] + 1;
            }
            i10++;
        }
        if (i11 != length) {
            if (i11 != length - 1 || i10 != l10) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public static void g(z5.a aVar, int i10, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean h10 = aVar.h(i10);
        while (i10 > 0 && length >= 0) {
            i10--;
            if (aVar.h(i10) != h10) {
                length--;
                h10 = !h10;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        f(aVar, i10 + 1, iArr);
    }

    @Override // t5.j
    public t5.k a(t5.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return d(bVar, map);
        } catch (NotFoundException e10) {
            if (map == null || !map.containsKey(DecodeHintType.TRY_HARDER) || !bVar.g()) {
                throw e10;
            }
            t5.b h10 = bVar.h();
            t5.k d10 = d(h10, map);
            Map<ResultMetadataType, Object> e11 = d10.e();
            int i10 = 270;
            if (e11 != null) {
                ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
                if (e11.containsKey(resultMetadataType)) {
                    i10 = (((Integer) e11.get(resultMetadataType)).intValue() + 270) % qe.c.f30025o;
                }
            }
            d10.j(ResultMetadataType.ORIENTATION, Integer.valueOf(i10));
            t5.l[] f10 = d10.f();
            if (f10 != null) {
                int d11 = h10.d();
                for (int i11 = 0; i11 < f10.length; i11++) {
                    f10[i11] = new t5.l((d11 - f10[i11].d()) - 1.0f, f10[i11].c());
                }
            }
            return d10;
        }
    }

    @Override // t5.j
    public t5.k b(t5.b bVar) throws NotFoundException, FormatException {
        return a(bVar, null);
    }

    public abstract t5.k c(int i10, z5.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        r3 = r22.c(r11, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e0, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0078 A[Catch: ReaderException -> 0x00c6, TryCatch #2 {ReaderException -> 0x00c6, blocks: (B:35:0x0072, B:37:0x0078, B:39:0x0089), top: B:34:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final t5.k d(t5.b r22, java.util.Map<com.google.zxing.DecodeHintType, ?> r23) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j6.q.d(t5.b, java.util.Map):t5.k");
    }

    @Override // t5.j
    public void reset() {
    }
}
