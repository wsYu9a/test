package com.google.zxing.pdf417.decoder;

import com.google.zxing.l;

/* loaded from: classes.dex */
final class g extends f {

    /* renamed from: d */
    private final boolean f8698d;

    g(c cVar, boolean z) {
        super(cVar);
        this.f8698d = z;
    }

    private void h(a aVar) {
        c a2 = a();
        l i2 = this.f8698d ? a2.i() : a2.j();
        l c2 = this.f8698d ? a2.c() : a2.d();
        int e2 = e((int) c2.d());
        d[] d2 = d();
        int i3 = -1;
        int i4 = 0;
        int i5 = 1;
        for (int e3 = e((int) i2.d()); e3 < e2; e3++) {
            if (d2[e3] != null) {
                d dVar = d2[e3];
                dVar.j();
                int c3 = dVar.c() - i3;
                if (c3 == 0) {
                    i4++;
                } else {
                    if (c3 == 1) {
                        i5 = Math.max(i5, i4);
                        i3 = dVar.c();
                    } else if (dVar.c() >= aVar.c()) {
                        d2[e3] = null;
                    } else {
                        i3 = dVar.c();
                    }
                    i4 = 1;
                }
            }
        }
    }

    private void l(d[] dVarArr, a aVar) {
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            d dVar = dVarArr[i2];
            if (dVarArr[i2] != null) {
                int e2 = dVar.e() % 30;
                int c2 = dVar.c();
                if (c2 > aVar.c()) {
                    dVarArr[i2] = null;
                } else {
                    if (!this.f8698d) {
                        c2 += 2;
                    }
                    int i3 = c2 % 3;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 == 2 && e2 + 1 != aVar.a()) {
                                dVarArr[i2] = null;
                            }
                        } else if (e2 / 3 != aVar.b() || e2 % 3 != aVar.d()) {
                            dVarArr[i2] = null;
                        }
                    } else if ((e2 * 3) + 1 != aVar.e()) {
                        dVarArr[i2] = null;
                    }
                }
            }
        }
    }

    private void m() {
        for (d dVar : d()) {
            if (dVar != null) {
                dVar.j();
            }
        }
    }

    void g(a aVar) {
        d[] d2 = d();
        m();
        l(d2, aVar);
        c a2 = a();
        l i2 = this.f8698d ? a2.i() : a2.j();
        l c2 = this.f8698d ? a2.c() : a2.d();
        int e2 = e((int) i2.d());
        int e3 = e((int) c2.d());
        int i3 = -1;
        int i4 = 0;
        int i5 = 1;
        while (e2 < e3) {
            if (d2[e2] != null) {
                d dVar = d2[e2];
                int c3 = dVar.c() - i3;
                if (c3 == 0) {
                    i4++;
                } else {
                    if (c3 == 1) {
                        i5 = Math.max(i5, i4);
                        i3 = dVar.c();
                    } else if (c3 < 0 || dVar.c() >= aVar.c() || c3 > e2) {
                        d2[e2] = null;
                    } else {
                        if (i5 > 2) {
                            c3 *= i5 - 2;
                        }
                        boolean z = c3 >= e2;
                        for (int i6 = 1; i6 <= c3 && !z; i6++) {
                            z = d2[e2 - i6] != null;
                        }
                        if (z) {
                            d2[e2] = null;
                        } else {
                            i3 = dVar.c();
                        }
                    }
                    i4 = 1;
                }
            }
            e2++;
        }
    }

    a i() {
        d[] d2 = d();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : d2) {
            if (dVar != null) {
                dVar.j();
                int e2 = dVar.e() % 30;
                int c2 = dVar.c();
                if (!this.f8698d) {
                    c2 += 2;
                }
                int i2 = c2 % 3;
                if (i2 == 0) {
                    bVar2.c((e2 * 3) + 1);
                } else if (i2 == 1) {
                    bVar4.c(e2 / 3);
                    bVar3.c(e2 % 3);
                } else if (i2 == 2) {
                    bVar.c(e2 + 1);
                }
            }
        }
        if (bVar.b().length == 0 || bVar2.b().length == 0 || bVar3.b().length == 0 || bVar4.b().length == 0 || bVar.b()[0] <= 0 || bVar2.b()[0] + bVar3.b()[0] < 3 || bVar2.b()[0] + bVar3.b()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.b()[0], bVar2.b()[0], bVar3.b()[0], bVar4.b()[0]);
        l(d2, aVar);
        return aVar;
    }

    int[] j() {
        int c2;
        a i2 = i();
        if (i2 == null) {
            return null;
        }
        h(i2);
        int c3 = i2.c();
        int[] iArr = new int[c3];
        for (d dVar : d()) {
            if (dVar != null && (c2 = dVar.c()) < c3) {
                iArr[c2] = iArr[c2] + 1;
            }
        }
        return iArr;
    }

    boolean k() {
        return this.f8698d;
    }

    @Override // com.google.zxing.pdf417.decoder.f
    public String toString() {
        return "IsLeft: " + this.f8698d + '\n' + super.toString();
    }
}
