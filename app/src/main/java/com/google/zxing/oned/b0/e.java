package com.google.zxing.oned.b0;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.k;
import com.google.zxing.l;
import com.google.zxing.m;
import com.google.zxing.oned.q;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class e extends a {
    private static final int[] k = {1, 10, 34, 70, org.mozilla.universalchardet.prober.o.a.n};
    private static final int[] l = {4, 20, 48, 81};
    private static final int[] m = {0, 161, 961, 2015, 2715};
    private static final int[] n = {0, 336, DownloadErrorCode.ERROR_TEMP_FILE_CREATE_FAILED, 1516};
    private static final int[] o = {8, 6, 4, 3, 1};
    private static final int[] p = {2, 4, 6, 8};
    private static final int[][] q = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private final List<d> r = new ArrayList();
    private final List<d> s = new ArrayList();

    private static void s(Collection<d> collection, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean z = false;
        Iterator<d> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d next = it.next();
            if (next.b() == dVar.b()) {
                next.e();
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        collection.add(dVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x003f, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0025, code lost:
    
        if (r1 < 4) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x003d, code lost:
    
        if (r1 < 4) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0041, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        r5 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void t(boolean r10, int r11) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.b0.e.t(boolean, int):void");
    }

    private static boolean u(d dVar, d dVar2) {
        int a2 = (dVar.a() + (dVar2.a() * 16)) % 79;
        int c2 = (dVar.d().c() * 9) + dVar2.d().c();
        if (c2 > 72) {
            c2--;
        }
        if (c2 > 8) {
            c2--;
        }
        return a2 == c2;
    }

    private static k v(d dVar, d dVar2) {
        String valueOf = String.valueOf((dVar.b() * 4537077) + dVar2.b());
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(valueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int charAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                charAt *= 3;
            }
            i2 += charAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        l[] a2 = dVar.d().a();
        l[] a3 = dVar2.d().a();
        return new k(String.valueOf(sb.toString()), null, new l[]{a2[0], a2[1], a3[0], a3[1]}, BarcodeFormat.RSS_14);
    }

    private b w(com.google.zxing.common.a aVar, c cVar, boolean z) throws NotFoundException {
        int[] j2 = j();
        j2[0] = 0;
        j2[1] = 0;
        j2[2] = 0;
        j2[3] = 0;
        j2[4] = 0;
        j2[5] = 0;
        j2[6] = 0;
        j2[7] = 0;
        if (z) {
            q.g(aVar, cVar.b()[0], j2);
        } else {
            q.f(aVar, cVar.b()[1] + 1, j2);
            int i2 = 0;
            for (int length = j2.length - 1; i2 < length; length--) {
                int i3 = j2[i2];
                j2[i2] = j2[length];
                j2[length] = i3;
                i2++;
            }
        }
        int i4 = z ? 16 : 15;
        float d2 = com.google.zxing.common.l.a.d(j2) / i4;
        int[] n2 = n();
        int[] l2 = l();
        float[] o2 = o();
        float[] m2 = m();
        for (int i5 = 0; i5 < j2.length; i5++) {
            float f2 = j2[i5] / d2;
            int i6 = (int) (0.5f + f2);
            if (i6 <= 0) {
                i6 = 1;
            } else if (i6 > 8) {
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                n2[i7] = i6;
                o2[i7] = f2 - i6;
            } else {
                l2[i7] = i6;
                m2[i7] = f2 - i6;
            }
        }
        t(z, i4);
        int i8 = 0;
        int i9 = 0;
        for (int length2 = n2.length - 1; length2 >= 0; length2--) {
            i8 = (i8 * 9) + n2[length2];
            i9 += n2[length2];
        }
        int i10 = 0;
        int i11 = 0;
        for (int length3 = l2.length - 1; length3 >= 0; length3--) {
            i10 = (i10 * 9) + l2[length3];
            i11 += l2[length3];
        }
        int i12 = i8 + (i10 * 3);
        if (!z) {
            if ((i11 & 1) != 0 || i11 > 10 || i11 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i13 = (10 - i11) / 2;
            int i14 = p[i13];
            return new b((f.b(l2, 9 - i14, false) * l[i13]) + f.b(n2, i14, true) + n[i13], i12);
        }
        if ((i9 & 1) != 0 || i9 > 12 || i9 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i15 = (12 - i9) / 2;
        int i16 = o[i15];
        return new b((f.b(n2, i16, false) * k[i15]) + f.b(l2, 9 - i16, true) + m[i15], i12);
    }

    private d x(com.google.zxing.common.a aVar, boolean z, int i2, Map<DecodeHintType, ?> map) {
        try {
            c z2 = z(aVar, i2, z, y(aVar, 0, z));
            m mVar = map == null ? null : (m) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (mVar != null) {
                float f2 = (r2[0] + r2[1]) / 2.0f;
                if (z) {
                    f2 = (aVar.l() - 1) - f2;
                }
                mVar.a(new l(f2, i2));
            }
            b w = w(aVar, z2, true);
            b w2 = w(aVar, z2, false);
            return new d((w.b() * 1597) + w2.b(), w.a() + (w2.a() * 4), z2);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private int[] y(com.google.zxing.common.a aVar, int i2, boolean z) throws NotFoundException {
        int[] k2 = k();
        k2[0] = 0;
        k2[1] = 0;
        k2[2] = 0;
        k2[3] = 0;
        int l2 = aVar.l();
        boolean z2 = false;
        while (i2 < l2) {
            z2 = !aVar.h(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < l2) {
            if (aVar.h(i2) ^ z2) {
                k2[i4] = k2[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else {
                    if (a.q(k2)) {
                        return new int[]{i3, i2};
                    }
                    i3 += k2[0] + k2[1];
                    k2[0] = k2[2];
                    k2[1] = k2[3];
                    k2[2] = 0;
                    k2[3] = 0;
                    i4--;
                }
                k2[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private c z(com.google.zxing.common.a aVar, int i2, boolean z, int[] iArr) throws NotFoundException {
        int i3;
        int i4;
        boolean h2 = aVar.h(iArr[0]);
        int i5 = iArr[0] - 1;
        while (i5 >= 0 && (aVar.h(i5) ^ h2)) {
            i5--;
        }
        int i6 = i5 + 1;
        int i7 = iArr[0] - i6;
        int[] k2 = k();
        System.arraycopy(k2, 0, k2, 1, k2.length - 1);
        k2[0] = i7;
        int r = a.r(k2, q);
        int i8 = iArr[1];
        if (z) {
            int l2 = (aVar.l() - 1) - i6;
            i3 = (aVar.l() - 1) - i8;
            i4 = l2;
        } else {
            i3 = i8;
            i4 = i6;
        }
        return new c(r, new int[]{i6, iArr[1]}, i4, i3, i2);
    }

    @Override // com.google.zxing.oned.q
    public k b(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        s(this.r, x(aVar, false, i2, map));
        aVar.p();
        s(this.s, x(aVar, true, i2, map));
        aVar.p();
        for (d dVar : this.r) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.s) {
                    if (dVar2.c() > 1 && u(dVar, dVar2)) {
                        return v(dVar, dVar2);
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.q, com.google.zxing.j
    public void reset() {
        this.r.clear();
        this.s.clear();
    }
}
