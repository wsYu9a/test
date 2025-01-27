package u6;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import java.util.Map;
import t5.l;
import t5.m;
import z5.f;
import z5.h;
import z5.j;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a */
    public final z5.b f30956a;

    /* renamed from: b */
    public m f30957b;

    public c(z5.b bVar) {
        this.f30956a = bVar;
    }

    public static int c(l lVar, l lVar2, l lVar3, float f10) throws NotFoundException {
        int c10 = (a6.a.c(l.b(lVar, lVar2) / f10) + a6.a.c(l.b(lVar, lVar3) / f10)) / 2;
        int i10 = c10 + 7;
        int i11 = i10 & 3;
        if (i11 == 0) {
            return c10 + 8;
        }
        if (i11 == 2) {
            return c10 + 6;
        }
        if (i11 != 3) {
            return i10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static j d(l lVar, l lVar2, l lVar3, l lVar4, int i10) {
        float c10;
        float d10;
        float f10;
        float f11 = i10 - 3.5f;
        if (lVar4 != null) {
            c10 = lVar4.c();
            d10 = lVar4.d();
            f10 = f11 - 3.0f;
        } else {
            c10 = (lVar2.c() - lVar.c()) + lVar3.c();
            d10 = (lVar2.d() - lVar.d()) + lVar3.d();
            f10 = f11;
        }
        return j.b(3.5f, 3.5f, f11, 3.5f, f10, f10, 3.5f, f11, lVar.c(), lVar.d(), lVar2.c(), lVar2.d(), c10, d10, lVar3.c(), lVar3.d());
    }

    public static z5.b k(z5.b bVar, j jVar, int i10) throws NotFoundException {
        return h.b().d(bVar, i10, i10, jVar);
    }

    public final float a(l lVar, l lVar2, l lVar3) {
        return (b(lVar, lVar2) + b(lVar, lVar3)) / 2.0f;
    }

    public final float b(l lVar, l lVar2) {
        float m10 = m((int) lVar.c(), (int) lVar.d(), (int) lVar2.c(), (int) lVar2.d());
        float m11 = m((int) lVar2.c(), (int) lVar2.d(), (int) lVar.c(), (int) lVar.d());
        return Float.isNaN(m10) ? m11 / 7.0f : Float.isNaN(m11) ? m10 / 7.0f : (m10 + m11) / 14.0f;
    }

    public f e() throws NotFoundException, FormatException {
        return f(null);
    }

    public final f f(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        m mVar = map == null ? null : (m) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        this.f30957b = mVar;
        return j(new FinderPatternFinder(this.f30956a, mVar).e(map));
    }

    public final a g(float f10, int i10, int i11, float f11) throws NotFoundException {
        int i12 = (int) (f11 * f10);
        int max = Math.max(0, i10 - i12);
        int min = Math.min(this.f30956a.l() - 1, i10 + i12) - max;
        float f12 = 3.0f * f10;
        if (min < f12) {
            throw NotFoundException.getNotFoundInstance();
        }
        int max2 = Math.max(0, i11 - i12);
        int min2 = Math.min(this.f30956a.h() - 1, i11 + i12) - max2;
        if (min2 >= f12) {
            return new b(this.f30956a, max, max2, min, min2, f10, this.f30957b).c();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final z5.b h() {
        return this.f30956a;
    }

    public final m i() {
        return this.f30957b;
    }

    public final f j(e eVar) throws NotFoundException, FormatException {
        a aVar;
        d b10 = eVar.b();
        d c10 = eVar.c();
        d a10 = eVar.a();
        float a11 = a(b10, c10, a10);
        if (a11 < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int c11 = c(b10, c10, a10, a11);
        t6.f g10 = t6.f.g(c11);
        int e10 = g10.e() - 7;
        if (g10.d().length > 0) {
            float c12 = (c10.c() - b10.c()) + a10.c();
            float d10 = (c10.d() - b10.d()) + a10.d();
            float f10 = 1.0f - (3.0f / e10);
            int c13 = (int) (b10.c() + ((c12 - b10.c()) * f10));
            int d11 = (int) (b10.d() + (f10 * (d10 - b10.d())));
            for (int i10 = 4; i10 <= 16; i10 <<= 1) {
                try {
                    aVar = g(a11, c13, d11, i10);
                    break;
                } catch (NotFoundException unused) {
                }
            }
        }
        aVar = null;
        return new f(k(this.f30956a, d(b10, c10, a10, aVar, c11), c11), aVar == null ? new l[]{a10, b10, c10} : new l[]{a10, b10, c10, aVar});
    }

    public final float l(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        c cVar;
        boolean z10;
        boolean z11;
        int i19 = 1;
        boolean z12 = Math.abs(i13 - i11) > Math.abs(i12 - i10);
        if (z12) {
            i15 = i10;
            i14 = i11;
            i17 = i12;
            i16 = i13;
        } else {
            i14 = i10;
            i15 = i11;
            i16 = i12;
            i17 = i13;
        }
        int abs = Math.abs(i16 - i14);
        int abs2 = Math.abs(i17 - i15);
        int i20 = (-abs) / 2;
        int i21 = i14 < i16 ? 1 : -1;
        int i22 = i15 < i17 ? 1 : -1;
        int i23 = i16 + i21;
        int i24 = i14;
        int i25 = i15;
        int i26 = 0;
        while (true) {
            if (i24 == i23) {
                i18 = i23;
                break;
            }
            int i27 = z12 ? i25 : i24;
            int i28 = z12 ? i24 : i25;
            if (i26 == i19) {
                cVar = this;
                z10 = z12;
                i18 = i23;
                z11 = true;
            } else {
                cVar = this;
                z10 = z12;
                i18 = i23;
                z11 = false;
            }
            if (z11 == cVar.f30956a.e(i27, i28)) {
                if (i26 == 2) {
                    return a6.a.b(i24, i25, i14, i15);
                }
                i26++;
            }
            i20 += abs2;
            if (i20 > 0) {
                if (i25 == i17) {
                    break;
                }
                i25 += i22;
                i20 -= abs;
            }
            i24 += i21;
            i23 = i18;
            z12 = z10;
            i19 = 1;
        }
        if (i26 == 2) {
            return a6.a.b(i18, i17, i14, i15);
        }
        return Float.NaN;
    }

    public final float m(int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float l10 = l(i10, i11, i12, i13);
        int i14 = i10 - (i12 - i10);
        int i15 = 0;
        if (i14 < 0) {
            f10 = i10 / (i10 - i14);
            i14 = 0;
        } else if (i14 >= this.f30956a.l()) {
            f10 = ((this.f30956a.l() - 1) - i10) / (i14 - i10);
            i14 = this.f30956a.l() - 1;
        } else {
            f10 = 1.0f;
        }
        float f12 = i11;
        int i16 = (int) (f12 - ((i13 - i11) * f10));
        if (i16 < 0) {
            f11 = f12 / (i11 - i16);
        } else if (i16 >= this.f30956a.h()) {
            f11 = ((this.f30956a.h() - 1) - i11) / (i16 - i11);
            i15 = this.f30956a.h() - 1;
        } else {
            i15 = i16;
            f11 = 1.0f;
        }
        return (l10 + l(i10, i11, (int) (i10 + ((i14 - i10) * f11)), i15)) - 1.0f;
    }
}
