package k6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import j6.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import t5.k;
import t5.l;
import t5.m;

/* loaded from: classes2.dex */
public final class e extends a {

    /* renamed from: m */
    public static final int[] f27717m = {1, 10, 34, 70, 126};

    /* renamed from: n */
    public static final int[] f27718n = {4, 20, 48, 81};

    /* renamed from: o */
    public static final int[] f27719o = {0, 161, 961, 2015, 2715};

    /* renamed from: p */
    public static final int[] f27720p = {0, 336, DownloadErrorCode.ERROR_TEMP_FILE_CREATE_FAILED, 1516};

    /* renamed from: q */
    public static final int[] f27721q = {8, 6, 4, 3, 1};

    /* renamed from: r */
    public static final int[] f27722r = {2, 4, 6, 8};

    /* renamed from: s */
    public static final int[][] f27723s = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* renamed from: k */
    public final List<d> f27724k = new ArrayList();

    /* renamed from: l */
    public final List<d> f27725l = new ArrayList();

    public static void s(Collection<d> collection, d dVar) {
        if (dVar == null) {
            return;
        }
        for (d dVar2 : collection) {
            if (dVar2.b() == dVar.b()) {
                dVar2.e();
                return;
            }
        }
        collection.add(dVar);
    }

    public static boolean u(d dVar, d dVar2) {
        int a10 = (dVar.a() + (dVar2.a() * 16)) % 79;
        int c10 = (dVar.d().c() * 9) + dVar2.d().c();
        if (c10 > 72) {
            c10--;
        }
        if (c10 > 8) {
            c10--;
        }
        return a10 == c10;
    }

    public static k v(d dVar, d dVar2) {
        String valueOf = String.valueOf((dVar.b() * 4537077) + dVar2.b());
        StringBuilder sb2 = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb2.append('0');
        }
        sb2.append(valueOf);
        int i10 = 0;
        for (int i11 = 0; i11 < 13; i11++) {
            int charAt = sb2.charAt(i11) - '0';
            if ((i11 & 1) == 0) {
                charAt *= 3;
            }
            i10 += charAt;
        }
        int i12 = 10 - (i10 % 10);
        if (i12 == 10) {
            i12 = 0;
        }
        sb2.append(i12);
        l[] a10 = dVar.d().a();
        l[] a11 = dVar2.d().a();
        return new k(String.valueOf(sb2.toString()), null, new l[]{a10[0], a10[1], a11[0], a11[1]}, BarcodeFormat.RSS_14);
    }

    @Override // j6.q
    public k c(int i10, z5.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        s(this.f27724k, x(aVar, false, i10, map));
        aVar.p();
        s(this.f27725l, x(aVar, true, i10, map));
        aVar.p();
        for (d dVar : this.f27724k) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.f27725l) {
                    if (dVar2.c() > 1 && u(dVar, dVar2)) {
                        return v(dVar, dVar2);
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // j6.q, t5.j
    public void reset() {
        this.f27724k.clear();
        this.f27725l.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0028, code lost:
    
        if (r1 < 4) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x002a, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x002b, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x002d, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0043, code lost:
    
        if (r1 < 4) goto L194;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void t(boolean r10, int r11) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.e.t(boolean, int):void");
    }

    public final b w(z5.a aVar, c cVar, boolean z10) throws NotFoundException {
        int[] j10 = j();
        j10[0] = 0;
        j10[1] = 0;
        j10[2] = 0;
        j10[3] = 0;
        j10[4] = 0;
        j10[5] = 0;
        j10[6] = 0;
        j10[7] = 0;
        if (z10) {
            q.g(aVar, cVar.b()[0], j10);
        } else {
            q.f(aVar, cVar.b()[1] + 1, j10);
            int i10 = 0;
            for (int length = j10.length - 1; i10 < length; length--) {
                int i11 = j10[i10];
                j10[i10] = j10[length];
                j10[length] = i11;
                i10++;
            }
        }
        int i12 = z10 ? 16 : 15;
        float d10 = a6.a.d(j10) / i12;
        int[] n10 = n();
        int[] l10 = l();
        float[] o10 = o();
        float[] m10 = m();
        for (int i13 = 0; i13 < j10.length; i13++) {
            float f10 = j10[i13] / d10;
            int i14 = (int) (0.5f + f10);
            if (i14 <= 0) {
                i14 = 1;
            } else if (i14 > 8) {
                i14 = 8;
            }
            int i15 = i13 / 2;
            if ((i13 & 1) == 0) {
                n10[i15] = i14;
                o10[i15] = f10 - i14;
            } else {
                l10[i15] = i14;
                m10[i15] = f10 - i14;
            }
        }
        t(z10, i12);
        int i16 = 0;
        int i17 = 0;
        for (int length2 = n10.length - 1; length2 >= 0; length2--) {
            int i18 = n10[length2];
            i16 = (i16 * 9) + i18;
            i17 += i18;
        }
        int i19 = 0;
        int i20 = 0;
        for (int length3 = l10.length - 1; length3 >= 0; length3--) {
            int i21 = l10[length3];
            i19 = (i19 * 9) + i21;
            i20 += i21;
        }
        int i22 = i16 + (i19 * 3);
        if (!z10) {
            if ((i20 & 1) != 0 || i20 > 10 || i20 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i23 = (10 - i20) / 2;
            int i24 = f27722r[i23];
            return new b((f.b(l10, 9 - i24, false) * f27718n[i23]) + f.b(n10, i24, true) + f27720p[i23], i22);
        }
        if ((i17 & 1) != 0 || i17 > 12 || i17 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i25 = (12 - i17) / 2;
        int i26 = f27721q[i25];
        return new b((f.b(n10, i26, false) * f27717m[i25]) + f.b(l10, 9 - i26, true) + f27719o[i25], i22);
    }

    public final d x(z5.a aVar, boolean z10, int i10, Map<DecodeHintType, ?> map) {
        try {
            c z11 = z(aVar, i10, z10, y(aVar, 0, z10));
            m mVar = map == null ? null : (m) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (mVar != null) {
                float f10 = (r2[0] + r2[1]) / 2.0f;
                if (z10) {
                    f10 = (aVar.l() - 1) - f10;
                }
                mVar.a(new l(f10, i10));
            }
            b w10 = w(aVar, z11, true);
            b w11 = w(aVar, z11, false);
            return new d((w10.b() * 1597) + w11.b(), w10.a() + (w11.a() * 4), z11);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    public final int[] y(z5.a aVar, int i10, boolean z10) throws NotFoundException {
        int[] k10 = k();
        k10[0] = 0;
        k10[1] = 0;
        k10[2] = 0;
        k10[3] = 0;
        int l10 = aVar.l();
        boolean z11 = false;
        while (i10 < l10) {
            z11 = !aVar.h(i10);
            if (z10 == z11) {
                break;
            }
            i10++;
        }
        int i11 = i10;
        int i12 = 0;
        while (i10 < l10) {
            if (aVar.h(i10) ^ z11) {
                k10[i12] = k10[i12] + 1;
            } else {
                if (i12 != 3) {
                    i12++;
                } else {
                    if (a.q(k10)) {
                        return new int[]{i11, i10};
                    }
                    i11 += k10[0] + k10[1];
                    k10[0] = k10[2];
                    k10[1] = k10[3];
                    k10[2] = 0;
                    k10[3] = 0;
                    i12--;
                }
                k10[i12] = 1;
                z11 = !z11;
            }
            i10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final c z(z5.a aVar, int i10, boolean z10, int[] iArr) throws NotFoundException {
        int i11;
        int i12;
        boolean h10 = aVar.h(iArr[0]);
        int i13 = iArr[0] - 1;
        while (i13 >= 0 && (aVar.h(i13) ^ h10)) {
            i13--;
        }
        int i14 = i13 + 1;
        int i15 = iArr[0] - i14;
        int[] k10 = k();
        System.arraycopy(k10, 0, k10, 1, k10.length - 1);
        k10[0] = i15;
        int r10 = a.r(k10, f27723s);
        int i16 = iArr[1];
        if (z10) {
            int l10 = (aVar.l() - 1) - i14;
            i11 = (aVar.l() - 1) - i16;
            i12 = l10;
        } else {
            i11 = i16;
            i12 = i14;
        }
        return new c(r10, new int[]{i14, iArr[1]}, i12, i11, i10);
    }
}
