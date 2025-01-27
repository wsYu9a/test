package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.f;
import com.google.zxing.common.h;
import com.google.zxing.common.j;
import com.google.zxing.l;
import com.google.zxing.m;
import com.google.zxing.qrcode.decoder.g;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private final com.google.zxing.common.b f8788a;

    /* renamed from: b */
    private m f8789b;

    public c(com.google.zxing.common.b bVar) {
        this.f8788a = bVar;
    }

    private float b(l lVar, l lVar2) {
        float m = m((int) lVar.c(), (int) lVar.d(), (int) lVar2.c(), (int) lVar2.d());
        float m2 = m((int) lVar2.c(), (int) lVar2.d(), (int) lVar.c(), (int) lVar.d());
        return Float.isNaN(m) ? m2 / 7.0f : Float.isNaN(m2) ? m / 7.0f : (m + m2) / 14.0f;
    }

    private static int c(l lVar, l lVar2, l lVar3, float f2) throws NotFoundException {
        int c2 = ((com.google.zxing.common.l.a.c(l.b(lVar, lVar2) / f2) + com.google.zxing.common.l.a.c(l.b(lVar, lVar3) / f2)) / 2) + 7;
        int i2 = c2 & 3;
        if (i2 == 0) {
            return c2 + 1;
        }
        if (i2 == 2) {
            return c2 - 1;
        }
        if (i2 != 3) {
            return c2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static j d(l lVar, l lVar2, l lVar3, l lVar4, int i2) {
        float c2;
        float d2;
        float f2;
        float f3 = i2 - 3.5f;
        if (lVar4 != null) {
            c2 = lVar4.c();
            d2 = lVar4.d();
            f2 = f3 - 3.0f;
        } else {
            c2 = (lVar2.c() - lVar.c()) + lVar3.c();
            d2 = (lVar2.d() - lVar.d()) + lVar3.d();
            f2 = f3;
        }
        return j.b(3.5f, 3.5f, f3, 3.5f, f2, f2, 3.5f, f3, lVar.c(), lVar.d(), lVar2.c(), lVar2.d(), c2, d2, lVar3.c(), lVar3.d());
    }

    private static com.google.zxing.common.b k(com.google.zxing.common.b bVar, j jVar, int i2) throws NotFoundException {
        return h.b().d(bVar, i2, i2, jVar);
    }

    private float l(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        c cVar;
        boolean z;
        boolean z2;
        int i11 = 1;
        boolean z3 = Math.abs(i5 - i3) > Math.abs(i4 - i2);
        if (z3) {
            i7 = i2;
            i6 = i3;
            i9 = i4;
            i8 = i5;
        } else {
            i6 = i2;
            i7 = i3;
            i8 = i4;
            i9 = i5;
        }
        int abs = Math.abs(i8 - i6);
        int abs2 = Math.abs(i9 - i7);
        int i12 = (-abs) / 2;
        int i13 = i6 < i8 ? 1 : -1;
        int i14 = i7 < i9 ? 1 : -1;
        int i15 = i8 + i13;
        int i16 = i6;
        int i17 = i7;
        int i18 = 0;
        while (true) {
            if (i16 == i15) {
                i10 = i15;
                break;
            }
            int i19 = z3 ? i17 : i16;
            int i20 = z3 ? i16 : i17;
            if (i18 == i11) {
                cVar = this;
                z = z3;
                i10 = i15;
                z2 = true;
            } else {
                cVar = this;
                z = z3;
                i10 = i15;
                z2 = false;
            }
            if (z2 == cVar.f8788a.e(i19, i20)) {
                if (i18 == 2) {
                    return com.google.zxing.common.l.a.b(i16, i17, i6, i7);
                }
                i18++;
            }
            i12 += abs2;
            if (i12 > 0) {
                if (i17 == i9) {
                    break;
                }
                i17 += i14;
                i12 -= abs;
            }
            i16 += i13;
            i15 = i10;
            z3 = z;
            i11 = 1;
        }
        if (i18 == 2) {
            return com.google.zxing.common.l.a.b(i10, i9, i6, i7);
        }
        return Float.NaN;
    }

    private float m(int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float l = l(i2, i3, i4, i5);
        int i6 = i2 - (i4 - i2);
        int i7 = 0;
        if (i6 < 0) {
            f2 = i2 / (i2 - i6);
            i6 = 0;
        } else if (i6 >= this.f8788a.l()) {
            f2 = ((this.f8788a.l() - 1) - i2) / (i6 - i2);
            i6 = this.f8788a.l() - 1;
        } else {
            f2 = 1.0f;
        }
        float f4 = i3;
        int i8 = (int) (f4 - ((i5 - i3) * f2));
        if (i8 < 0) {
            f3 = f4 / (i3 - i8);
        } else if (i8 >= this.f8788a.h()) {
            f3 = ((this.f8788a.h() - 1) - i3) / (i8 - i3);
            i7 = this.f8788a.h() - 1;
        } else {
            i7 = i8;
            f3 = 1.0f;
        }
        return (l + l(i2, i3, (int) (i2 + ((i6 - i2) * f3)), i7)) - 1.0f;
    }

    protected final float a(l lVar, l lVar2, l lVar3) {
        return (b(lVar, lVar2) + b(lVar, lVar3)) / 2.0f;
    }

    public f e() throws NotFoundException, FormatException {
        return f(null);
    }

    public final f f(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        m mVar = map == null ? null : (m) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        this.f8789b = mVar;
        return j(new FinderPatternFinder(this.f8788a, mVar).e(map));
    }

    protected final a g(float f2, int i2, int i3, float f3) throws NotFoundException {
        int i4 = (int) (f3 * f2);
        int max = Math.max(0, i2 - i4);
        int min = Math.min(this.f8788a.l() - 1, i2 + i4) - max;
        float f4 = 3.0f * f2;
        if (min < f4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int max2 = Math.max(0, i3 - i4);
        int min2 = Math.min(this.f8788a.h() - 1, i3 + i4) - max2;
        if (min2 >= f4) {
            return new b(this.f8788a, max, max2, min, min2, f2, this.f8789b).c();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected final com.google.zxing.common.b h() {
        return this.f8788a;
    }

    protected final m i() {
        return this.f8789b;
    }

    protected final f j(e eVar) throws NotFoundException, FormatException {
        d b2 = eVar.b();
        d c2 = eVar.c();
        d a2 = eVar.a();
        float a3 = a(b2, c2, a2);
        if (a3 < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int c3 = c(b2, c2, a2, a3);
        g g2 = g.g(c3);
        int e2 = g2.e() - 7;
        a aVar = null;
        if (g2.d().length > 0) {
            float c4 = (c2.c() - b2.c()) + a2.c();
            float d2 = (c2.d() - b2.d()) + a2.d();
            float f2 = 1.0f - (3.0f / e2);
            int c5 = (int) (b2.c() + ((c4 - b2.c()) * f2));
            int d3 = (int) (b2.d() + (f2 * (d2 - b2.d())));
            for (int i2 = 4; i2 <= 16; i2 <<= 1) {
                try {
                    aVar = g(a3, c5, d3, i2);
                    break;
                } catch (NotFoundException unused) {
                }
            }
        }
        return new f(k(this.f8788a, d(b2, c2, a2, aVar, c3), c3), aVar == null ? new l[]{a2, b2, c2} : new l[]{a2, b2, c2, aVar});
    }
}
