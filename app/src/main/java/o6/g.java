package o6;

import t5.l;

/* loaded from: classes2.dex */
public final class g extends f {

    /* renamed from: d */
    public final boolean f29094d;

    public g(c cVar, boolean z10) {
        super(cVar);
        this.f29094d = z10;
    }

    public void g(a aVar) {
        d[] d10 = d();
        m();
        l(d10, aVar);
        c a10 = a();
        l i10 = this.f29094d ? a10.i() : a10.j();
        l c10 = this.f29094d ? a10.c() : a10.d();
        int e10 = e((int) i10.d());
        int e11 = e((int) c10.d());
        int i11 = -1;
        int i12 = 0;
        int i13 = 1;
        while (e10 < e11) {
            d dVar = d10[e10];
            if (dVar != null) {
                int c11 = dVar.c() - i11;
                if (c11 == 0) {
                    i12++;
                } else {
                    if (c11 == 1) {
                        i13 = Math.max(i13, i12);
                        i11 = dVar.c();
                    } else if (c11 < 0 || dVar.c() >= aVar.c() || c11 > e10) {
                        d10[e10] = null;
                    } else {
                        if (i13 > 2) {
                            c11 *= i13 - 2;
                        }
                        boolean z10 = c11 >= e10;
                        for (int i14 = 1; i14 <= c11 && !z10; i14++) {
                            z10 = d10[e10 - i14] != null;
                        }
                        if (z10) {
                            d10[e10] = null;
                        } else {
                            i11 = dVar.c();
                        }
                    }
                    i12 = 1;
                }
            }
            e10++;
        }
    }

    public final void h(a aVar) {
        c a10 = a();
        l i10 = this.f29094d ? a10.i() : a10.j();
        l c10 = this.f29094d ? a10.c() : a10.d();
        int e10 = e((int) c10.d());
        d[] d10 = d();
        int i11 = -1;
        int i12 = 0;
        int i13 = 1;
        for (int e11 = e((int) i10.d()); e11 < e10; e11++) {
            d dVar = d10[e11];
            if (dVar != null) {
                dVar.j();
                int c11 = dVar.c() - i11;
                if (c11 == 0) {
                    i12++;
                } else {
                    if (c11 == 1) {
                        i13 = Math.max(i13, i12);
                        i11 = dVar.c();
                    } else if (dVar.c() >= aVar.c()) {
                        d10[e11] = null;
                    } else {
                        i11 = dVar.c();
                    }
                    i12 = 1;
                }
            }
        }
    }

    public a i() {
        d[] d10 = d();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : d10) {
            if (dVar != null) {
                dVar.j();
                int e10 = dVar.e() % 30;
                int c10 = dVar.c();
                if (!this.f29094d) {
                    c10 += 2;
                }
                int i10 = c10 % 3;
                if (i10 == 0) {
                    bVar2.c((e10 * 3) + 1);
                } else if (i10 == 1) {
                    bVar4.c(e10 / 3);
                    bVar3.c(e10 % 3);
                } else if (i10 == 2) {
                    bVar.c(e10 + 1);
                }
            }
        }
        if (bVar.b().length == 0 || bVar2.b().length == 0 || bVar3.b().length == 0 || bVar4.b().length == 0 || bVar.b()[0] <= 0 || bVar2.b()[0] + bVar3.b()[0] < 3 || bVar2.b()[0] + bVar3.b()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.b()[0], bVar2.b()[0], bVar3.b()[0], bVar4.b()[0]);
        l(d10, aVar);
        return aVar;
    }

    public int[] j() {
        int c10;
        a i10 = i();
        if (i10 == null) {
            return null;
        }
        h(i10);
        int c11 = i10.c();
        int[] iArr = new int[c11];
        for (d dVar : d()) {
            if (dVar != null && (c10 = dVar.c()) < c11) {
                iArr[c10] = iArr[c10] + 1;
            }
        }
        return iArr;
    }

    public boolean k() {
        return this.f29094d;
    }

    public final void l(d[] dVarArr, a aVar) {
        for (int i10 = 0; i10 < dVarArr.length; i10++) {
            d dVar = dVarArr[i10];
            if (dVar != null) {
                int e10 = dVar.e() % 30;
                int c10 = dVar.c();
                if (c10 > aVar.c()) {
                    dVarArr[i10] = null;
                } else {
                    if (!this.f29094d) {
                        c10 += 2;
                    }
                    int i11 = c10 % 3;
                    if (i11 != 0) {
                        if (i11 != 1) {
                            if (i11 == 2 && e10 + 1 != aVar.a()) {
                                dVarArr[i10] = null;
                            }
                        } else if (e10 / 3 != aVar.b() || e10 % 3 != aVar.d()) {
                            dVarArr[i10] = null;
                        }
                    } else if ((e10 * 3) + 1 != aVar.e()) {
                        dVarArr[i10] = null;
                    }
                }
            }
        }
    }

    public final void m() {
        for (d dVar : d()) {
            if (dVar != null) {
                dVar.j();
            }
        }
    }

    @Override // o6.f
    public String toString() {
        return "IsLeft: " + this.f29094d + '\n' + super.toString();
    }
}
