package a6;

import com.google.zxing.NotFoundException;
import t5.l;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: h */
    public static final int f75h = 10;

    /* renamed from: i */
    public static final int f76i = 1;

    /* renamed from: a */
    public final z5.b f77a;

    /* renamed from: b */
    public final int f78b;

    /* renamed from: c */
    public final int f79c;

    /* renamed from: d */
    public final int f80d;

    /* renamed from: e */
    public final int f81e;

    /* renamed from: f */
    public final int f82f;

    /* renamed from: g */
    public final int f83g;

    public c(z5.b bVar) throws NotFoundException {
        this(bVar, 10, bVar.l() / 2, bVar.h() / 2);
    }

    public final l[] a(l lVar, l lVar2, l lVar3, l lVar4) {
        float c10 = lVar.c();
        float d10 = lVar.d();
        float c11 = lVar2.c();
        float d11 = lVar2.d();
        float c12 = lVar3.c();
        float d12 = lVar3.d();
        float c13 = lVar4.c();
        float d13 = lVar4.d();
        return c10 < ((float) this.f79c) / 2.0f ? new l[]{new l(c13 - 1.0f, d13 + 1.0f), new l(c11 + 1.0f, d11 + 1.0f), new l(c12 - 1.0f, d12 - 1.0f), new l(c10 + 1.0f, d10 - 1.0f)} : new l[]{new l(c13 + 1.0f, d13 + 1.0f), new l(c11 + 1.0f, d11 - 1.0f), new l(c12 - 1.0f, d12 + 1.0f), new l(c10 - 1.0f, d10 - 1.0f)};
    }

    public final boolean b(int i10, int i11, int i12, boolean z10) {
        if (z10) {
            while (i10 <= i11) {
                if (this.f77a.e(i10, i12)) {
                    return true;
                }
                i10++;
            }
            return false;
        }
        while (i10 <= i11) {
            if (this.f77a.e(i12, i10)) {
                return true;
            }
            i10++;
        }
        return false;
    }

    public l[] c() throws NotFoundException {
        int i10 = this.f80d;
        int i11 = this.f81e;
        int i12 = this.f83g;
        int i13 = this.f82f;
        boolean z10 = false;
        boolean z11 = true;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        while (z11) {
            boolean z17 = true;
            boolean z18 = false;
            while (true) {
                if ((z17 || !z12) && i11 < this.f79c) {
                    z17 = b(i12, i13, i11, false);
                    if (z17) {
                        i11++;
                        z12 = true;
                        z18 = true;
                    } else if (!z12) {
                        i11++;
                    }
                }
            }
            if (i11 < this.f79c) {
                boolean z19 = true;
                while (true) {
                    if ((z19 || !z13) && i13 < this.f78b) {
                        z19 = b(i10, i11, i13, true);
                        if (z19) {
                            i13++;
                            z13 = true;
                            z18 = true;
                        } else if (!z13) {
                            i13++;
                        }
                    }
                }
                if (i13 < this.f78b) {
                    boolean z20 = true;
                    while (true) {
                        if ((z20 || !z14) && i10 >= 0) {
                            z20 = b(i12, i13, i10, false);
                            if (z20) {
                                i10--;
                                z14 = true;
                                z18 = true;
                            } else if (!z14) {
                                i10--;
                            }
                        }
                    }
                    if (i10 >= 0) {
                        z11 = z18;
                        boolean z21 = true;
                        while (true) {
                            if ((z21 || !z16) && i12 >= 0) {
                                z21 = b(i10, i11, i12, true);
                                if (z21) {
                                    i12--;
                                    z11 = true;
                                    z16 = true;
                                } else if (!z16) {
                                    i12--;
                                }
                            }
                        }
                        if (i12 >= 0) {
                            if (z11) {
                                z15 = true;
                            }
                        }
                    }
                }
            }
            z10 = true;
            break;
        }
        if (z10 || !z15) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i14 = i11 - i10;
        l lVar = null;
        l lVar2 = null;
        for (int i15 = 1; lVar2 == null && i15 < i14; i15++) {
            lVar2 = d(i10, i13 - i15, i10 + i15, i13);
        }
        if (lVar2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        l lVar3 = null;
        for (int i16 = 1; lVar3 == null && i16 < i14; i16++) {
            lVar3 = d(i10, i12 + i16, i10 + i16, i12);
        }
        if (lVar3 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        l lVar4 = null;
        for (int i17 = 1; lVar4 == null && i17 < i14; i17++) {
            lVar4 = d(i11, i12 + i17, i11 - i17, i12);
        }
        if (lVar4 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        for (int i18 = 1; lVar == null && i18 < i14; i18++) {
            lVar = d(i11, i13 - i18, i11 - i18, i13);
        }
        if (lVar != null) {
            return a(lVar, lVar2, lVar4, lVar3);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final l d(float f10, float f11, float f12, float f13) {
        int c10 = a.c(a.a(f10, f11, f12, f13));
        float f14 = c10;
        float f15 = (f12 - f10) / f14;
        float f16 = (f13 - f11) / f14;
        for (int i10 = 0; i10 < c10; i10++) {
            float f17 = i10;
            int c11 = a.c((f17 * f15) + f10);
            int c12 = a.c((f17 * f16) + f11);
            if (this.f77a.e(c11, c12)) {
                return new l(c11, c12);
            }
        }
        return null;
    }

    public c(z5.b bVar, int i10, int i11, int i12) throws NotFoundException {
        this.f77a = bVar;
        int h10 = bVar.h();
        this.f78b = h10;
        int l10 = bVar.l();
        this.f79c = l10;
        int i13 = i10 / 2;
        int i14 = i11 - i13;
        this.f80d = i14;
        int i15 = i11 + i13;
        this.f81e = i15;
        int i16 = i12 - i13;
        this.f83g = i16;
        int i17 = i12 + i13;
        this.f82f = i17;
        if (i16 < 0 || i14 < 0 || i17 >= h10 || i15 >= l10) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
