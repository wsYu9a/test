package u6;

import com.google.zxing.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import t5.m;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    public final z5.b f30947a;

    /* renamed from: c */
    public final int f30949c;

    /* renamed from: d */
    public final int f30950d;

    /* renamed from: e */
    public final int f30951e;

    /* renamed from: f */
    public final int f30952f;

    /* renamed from: g */
    public final float f30953g;

    /* renamed from: i */
    public final m f30955i;

    /* renamed from: b */
    public final List<a> f30948b = new ArrayList(5);

    /* renamed from: h */
    public final int[] f30954h = new int[3];

    public b(z5.b bVar, int i10, int i11, int i12, int i13, float f10, m mVar) {
        this.f30947a = bVar;
        this.f30949c = i10;
        this.f30950d = i11;
        this.f30951e = i12;
        this.f30952f = i13;
        this.f30953g = f10;
        this.f30955i = mVar;
    }

    public static float a(int[] iArr, int i10) {
        return (i10 - iArr[2]) - (iArr[1] / 2.0f);
    }

    public final float b(int i10, int i11, int i12, int i13) {
        z5.b bVar = this.f30947a;
        int h10 = bVar.h();
        int[] iArr = this.f30954h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i14 = i10;
        while (i14 >= 0 && bVar.e(i11, i14)) {
            int i15 = iArr[1];
            if (i15 > i12) {
                break;
            }
            iArr[1] = i15 + 1;
            i14--;
        }
        if (i14 >= 0 && iArr[1] <= i12) {
            while (i14 >= 0 && !bVar.e(i11, i14)) {
                int i16 = iArr[0];
                if (i16 > i12) {
                    break;
                }
                iArr[0] = i16 + 1;
                i14--;
            }
            if (iArr[0] > i12) {
                return Float.NaN;
            }
            int i17 = i10 + 1;
            while (i17 < h10 && bVar.e(i11, i17)) {
                int i18 = iArr[1];
                if (i18 > i12) {
                    break;
                }
                iArr[1] = i18 + 1;
                i17++;
            }
            if (i17 != h10 && iArr[1] <= i12) {
                while (i17 < h10 && !bVar.e(i11, i17)) {
                    int i19 = iArr[2];
                    if (i19 > i12) {
                        break;
                    }
                    iArr[2] = i19 + 1;
                    i17++;
                }
                int i20 = iArr[2];
                if (i20 <= i12 && Math.abs(((iArr[0] + iArr[1]) + i20) - i13) * 5 < i13 * 2 && d(iArr)) {
                    return a(iArr, i17);
                }
            }
        }
        return Float.NaN;
    }

    public a c() throws NotFoundException {
        a e10;
        a e11;
        int i10 = this.f30949c;
        int i11 = this.f30952f;
        int i12 = this.f30951e + i10;
        int i13 = this.f30950d + (i11 / 2);
        int[] iArr = new int[3];
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = ((i14 & 1) == 0 ? (i14 + 1) / 2 : -((i14 + 1) / 2)) + i13;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i16 = i10;
            while (i16 < i12 && !this.f30947a.e(i16, i15)) {
                i16++;
            }
            int i17 = 0;
            while (i16 < i12) {
                if (!this.f30947a.e(i16, i15)) {
                    if (i17 == 1) {
                        i17++;
                    }
                    iArr[i17] = iArr[i17] + 1;
                } else if (i17 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i17 != 2) {
                    i17++;
                    iArr[i17] = iArr[i17] + 1;
                } else {
                    if (d(iArr) && (e11 = e(iArr, i15, i16)) != null) {
                        return e11;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i17 = 1;
                }
                i16++;
            }
            if (d(iArr) && (e10 = e(iArr, i15, i12)) != null) {
                return e10;
            }
        }
        if (this.f30948b.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return this.f30948b.get(0);
    }

    public final boolean d(int[] iArr) {
        float f10 = this.f30953g;
        float f11 = f10 / 2.0f;
        for (int i10 = 0; i10 < 3; i10++) {
            if (Math.abs(f10 - iArr[i10]) >= f11) {
                return false;
            }
        }
        return true;
    }

    public final a e(int[] iArr, int i10, int i11) {
        int i12 = iArr[0] + iArr[1] + iArr[2];
        float a10 = a(iArr, i11);
        float b10 = b(i10, (int) a10, iArr[1] * 2, i12);
        if (Float.isNaN(b10)) {
            return null;
        }
        float f10 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (a aVar : this.f30948b) {
            if (aVar.f(f10, b10, a10)) {
                return aVar.g(b10, a10, f10);
            }
        }
        a aVar2 = new a(a10, b10, f10);
        this.f30948b.add(aVar2);
        m mVar = this.f30955i;
        if (mVar == null) {
            return null;
        }
        mVar.a(aVar2);
        return null;
    }
}
