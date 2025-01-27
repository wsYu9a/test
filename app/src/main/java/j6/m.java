package j6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class m extends q {

    /* renamed from: b */
    public static final float f27215b = 0.38f;

    /* renamed from: c */
    public static final float f27216c = 0.78f;

    /* renamed from: d */
    public static final int f27217d = 3;

    /* renamed from: e */
    public static final int f27218e = 1;

    /* renamed from: f */
    public static final int[] f27219f = {6, 8, 10, 12, 14};

    /* renamed from: g */
    public static final int[] f27220g = {1, 1, 1, 1};

    /* renamed from: h */
    public static final int[] f27221h = {1, 1, 3};

    /* renamed from: i */
    public static final int[][] f27222i = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: a */
    public int f27223a = -1;

    public static int h(int[] iArr) throws NotFoundException {
        int length = f27222i.length;
        float f10 = 0.38f;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            float e10 = q.e(iArr, f27222i[i11], 0.78f);
            if (e10 < f10) {
                i10 = i11;
                f10 = e10;
            }
        }
        if (i10 >= 0) {
            return i10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static void j(z5.a aVar, int i10, int i11, StringBuilder sb2) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i10 < i11) {
            q.f(aVar, i10, iArr);
            for (int i12 = 0; i12 < 5; i12++) {
                int i13 = i12 * 2;
                iArr2[i12] = iArr[i13];
                iArr3[i12] = iArr[i13 + 1];
            }
            sb2.append((char) (h(iArr2) + 48));
            sb2.append((char) (h(iArr3) + 48));
            for (int i14 = 0; i14 < 10; i14++) {
                i10 += iArr[i14];
            }
        }
    }

    public static int[] l(z5.a aVar, int i10, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int l10 = aVar.l();
        int i11 = i10;
        boolean z10 = false;
        int i12 = 0;
        while (i10 < l10) {
            if (aVar.h(i10) ^ z10) {
                iArr2[i12] = iArr2[i12] + 1;
            } else {
                int i13 = length - 1;
                if (i12 != i13) {
                    i12++;
                } else {
                    if (q.e(iArr2, iArr, 0.78f) < 0.38f) {
                        return new int[]{i11, i10};
                    }
                    i11 += iArr2[0] + iArr2[1];
                    int i14 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i14);
                    iArr2[i14] = 0;
                    iArr2[i13] = 0;
                    i12--;
                }
                iArr2[i12] = 1;
                z10 = !z10;
            }
            i10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int m(z5.a aVar) throws NotFoundException {
        int l10 = aVar.l();
        int j10 = aVar.j(0);
        if (j10 != l10) {
            return j10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // j6.q
    public t5.k c(int i10, z5.a aVar, Map<DecodeHintType, ?> map) throws FormatException, NotFoundException {
        boolean z10;
        int[] k10 = k(aVar);
        int[] i11 = i(aVar);
        StringBuilder sb2 = new StringBuilder(20);
        j(aVar, k10[1], i11[0], sb2);
        String sb3 = sb2.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f27219f;
        }
        int length = sb3.length();
        int length2 = iArr.length;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i12 >= length2) {
                z10 = false;
                break;
            }
            int i14 = iArr[i12];
            if (length == i14) {
                z10 = true;
                break;
            }
            if (i14 > i13) {
                i13 = i14;
            }
            i12++;
        }
        if (!z10 && length > i13) {
            z10 = true;
        }
        if (!z10) {
            throw FormatException.getFormatInstance();
        }
        float f10 = i10;
        return new t5.k(sb3, null, new t5.l[]{new t5.l(k10[1], f10), new t5.l(i11[0], f10)}, BarcodeFormat.ITF);
    }

    public final int[] i(z5.a aVar) throws NotFoundException {
        aVar.p();
        try {
            int[] l10 = l(aVar, m(aVar), f27221h);
            n(aVar, l10[0]);
            int i10 = l10[0];
            l10[0] = aVar.l() - l10[1];
            l10[1] = aVar.l() - i10;
            return l10;
        } finally {
            aVar.p();
        }
    }

    public final int[] k(z5.a aVar) throws NotFoundException {
        int[] l10 = l(aVar, m(aVar), f27220g);
        int i10 = l10[1];
        int i11 = l10[0];
        this.f27223a = (i10 - i11) / 4;
        n(aVar, i11);
        return l10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void n(z5.a r3, int r4) throws com.google.zxing.NotFoundException {
        /*
            r2 = this;
            int r0 = r2.f27223a
            int r0 = r0 * 10
            if (r0 >= r4) goto L7
            goto L8
        L7:
            r0 = r4
        L8:
            int r4 = r4 + (-1)
        La:
            if (r0 <= 0) goto L19
            if (r4 < 0) goto L19
            boolean r1 = r3.h(r4)
            if (r1 != 0) goto L19
            int r0 = r0 + (-1)
            int r4 = r4 + (-1)
            goto La
        L19:
            if (r0 != 0) goto L1c
            return
        L1c:
            com.google.zxing.NotFoundException r3 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j6.m.n(z5.a, int):void");
    }
}
