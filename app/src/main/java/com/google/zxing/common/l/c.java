package com.google.zxing.common.l;

import com.google.zxing.NotFoundException;
import com.google.zxing.l;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    private static final int f8335a = 10;

    /* renamed from: b */
    private static final int f8336b = 1;

    /* renamed from: c */
    private final com.google.zxing.common.b f8337c;

    /* renamed from: d */
    private final int f8338d;

    /* renamed from: e */
    private final int f8339e;

    /* renamed from: f */
    private final int f8340f;

    /* renamed from: g */
    private final int f8341g;

    /* renamed from: h */
    private final int f8342h;

    /* renamed from: i */
    private final int f8343i;

    public c(com.google.zxing.common.b bVar) throws NotFoundException {
        this(bVar, 10, bVar.l() / 2, bVar.h() / 2);
    }

    private l[] a(l lVar, l lVar2, l lVar3, l lVar4) {
        float c2 = lVar.c();
        float d2 = lVar.d();
        float c3 = lVar2.c();
        float d3 = lVar2.d();
        float c4 = lVar3.c();
        float d4 = lVar3.d();
        float c5 = lVar4.c();
        float d5 = lVar4.d();
        return c2 < ((float) this.f8339e) / 2.0f ? new l[]{new l(c5 - 1.0f, d5 + 1.0f), new l(c3 + 1.0f, d3 + 1.0f), new l(c4 - 1.0f, d4 - 1.0f), new l(c2 + 1.0f, d2 - 1.0f)} : new l[]{new l(c5 + 1.0f, d5 + 1.0f), new l(c3 + 1.0f, d3 - 1.0f), new l(c4 - 1.0f, d4 + 1.0f), new l(c2 - 1.0f, d2 - 1.0f)};
    }

    private boolean b(int i2, int i3, int i4, boolean z) {
        if (z) {
            while (i2 <= i3) {
                if (this.f8337c.e(i2, i4)) {
                    return true;
                }
                i2++;
            }
            return false;
        }
        while (i2 <= i3) {
            if (this.f8337c.e(i4, i2)) {
                return true;
            }
            i2++;
        }
        return false;
    }

    private l d(float f2, float f3, float f4, float f5) {
        int c2 = a.c(a.a(f2, f3, f4, f5));
        float f6 = c2;
        float f7 = (f4 - f2) / f6;
        float f8 = (f5 - f3) / f6;
        for (int i2 = 0; i2 < c2; i2++) {
            float f9 = i2;
            int c3 = a.c((f9 * f7) + f2);
            int c4 = a.c((f9 * f8) + f3);
            if (this.f8337c.e(c3, c4)) {
                return new l(c3, c4);
            }
        }
        return null;
    }

    public l[] c() throws NotFoundException {
        int i2 = this.f8340f;
        int i3 = this.f8341g;
        int i4 = this.f8343i;
        int i5 = this.f8342h;
        boolean z = false;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (z2) {
            boolean z8 = true;
            boolean z9 = false;
            while (true) {
                if ((z8 || !z3) && i3 < this.f8339e) {
                    z8 = b(i4, i5, i3, false);
                    if (z8) {
                        i3++;
                        z3 = true;
                        z9 = true;
                    } else if (!z3) {
                        i3++;
                    }
                }
            }
            if (i3 < this.f8339e) {
                boolean z10 = true;
                while (true) {
                    if ((z10 || !z4) && i5 < this.f8338d) {
                        z10 = b(i2, i3, i5, true);
                        if (z10) {
                            i5++;
                            z4 = true;
                            z9 = true;
                        } else if (!z4) {
                            i5++;
                        }
                    }
                }
                if (i5 < this.f8338d) {
                    boolean z11 = true;
                    while (true) {
                        if ((z11 || !z5) && i2 >= 0) {
                            z11 = b(i4, i5, i2, false);
                            if (z11) {
                                i2--;
                                z5 = true;
                                z9 = true;
                            } else if (!z5) {
                                i2--;
                            }
                        }
                    }
                    if (i2 >= 0) {
                        z2 = z9;
                        boolean z12 = true;
                        while (true) {
                            if ((z12 || !z7) && i4 >= 0) {
                                z12 = b(i2, i3, i4, true);
                                if (z12) {
                                    i4--;
                                    z2 = true;
                                    z7 = true;
                                } else if (!z7) {
                                    i4--;
                                }
                            }
                        }
                        if (i4 >= 0) {
                            if (z2) {
                                z6 = true;
                            }
                        }
                    }
                }
            }
            z = true;
            break;
        }
        if (z || !z6) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = i3 - i2;
        l lVar = null;
        l lVar2 = null;
        for (int i7 = 1; lVar2 == null && i7 < i6; i7++) {
            lVar2 = d(i2, i5 - i7, i2 + i7, i5);
        }
        if (lVar2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        l lVar3 = null;
        for (int i8 = 1; lVar3 == null && i8 < i6; i8++) {
            lVar3 = d(i2, i4 + i8, i2 + i8, i4);
        }
        if (lVar3 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        l lVar4 = null;
        for (int i9 = 1; lVar4 == null && i9 < i6; i9++) {
            lVar4 = d(i3, i4 + i9, i3 - i9, i4);
        }
        if (lVar4 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        for (int i10 = 1; lVar == null && i10 < i6; i10++) {
            lVar = d(i3, i5 - i10, i3 - i10, i5);
        }
        if (lVar != null) {
            return a(lVar, lVar2, lVar4, lVar3);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public c(com.google.zxing.common.b bVar, int i2, int i3, int i4) throws NotFoundException {
        this.f8337c = bVar;
        int h2 = bVar.h();
        this.f8338d = h2;
        int l = bVar.l();
        this.f8339e = l;
        int i5 = i2 / 2;
        int i6 = i3 - i5;
        this.f8340f = i6;
        int i7 = i3 + i5;
        this.f8341g = i7;
        int i8 = i4 - i5;
        this.f8343i = i8;
        int i9 = i4 + i5;
        this.f8342h = i9;
        if (i8 < 0 || i6 < 0 || i9 >= h2 || i7 >= l) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
