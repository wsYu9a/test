package com.google.zxing.common.reedsolomon;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    private final a f8356a;

    public c(a aVar) {
        this.f8356a = aVar;
    }

    private int[] b(b bVar) throws ReedSolomonException {
        int f2 = bVar.f();
        int i2 = 0;
        if (f2 == 1) {
            return new int[]{bVar.d(1)};
        }
        int[] iArr = new int[f2];
        for (int i3 = 1; i3 < this.f8356a.f() && i2 < f2; i3++) {
            if (bVar.c(i3) == 0) {
                iArr[i2] = this.f8356a.h(i3);
                i2++;
            }
        }
        if (i2 == f2) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    private int[] c(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int h2 = this.f8356a.h(iArr[i2]);
            int i3 = 1;
            for (int i4 = 0; i4 < length; i4++) {
                if (i2 != i4) {
                    int j2 = this.f8356a.j(iArr[i4], h2);
                    i3 = this.f8356a.j(i3, (j2 & 1) == 0 ? j2 | 1 : j2 & (-2));
                }
            }
            iArr2[i2] = this.f8356a.j(bVar.c(h2), this.f8356a.h(i3));
            if (this.f8356a.d() != 0) {
                iArr2[i2] = this.f8356a.j(iArr2[i2], h2);
            }
        }
        return iArr2;
    }

    private b[] d(b bVar, b bVar2, int i2) throws ReedSolomonException {
        if (bVar.f() < bVar2.f()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        b g2 = this.f8356a.g();
        b e2 = this.f8356a.e();
        do {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
            b bVar4 = e2;
            b bVar5 = g2;
            g2 = bVar4;
            if (bVar.f() < i2 / 2) {
                int d2 = g2.d(0);
                if (d2 == 0) {
                    throw new ReedSolomonException("sigmaTilde(0) was zero");
                }
                int h2 = this.f8356a.h(d2);
                return new b[]{g2.h(h2), bVar.h(h2)};
            }
            if (bVar.g()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            b g3 = this.f8356a.g();
            int h3 = this.f8356a.h(bVar.d(bVar.f()));
            while (bVar2.f() >= bVar.f() && !bVar2.g()) {
                int f2 = bVar2.f() - bVar.f();
                int j2 = this.f8356a.j(bVar2.d(bVar2.f()), h3);
                g3 = g3.a(this.f8356a.b(f2, j2));
                bVar2 = bVar2.a(bVar.j(f2, j2));
            }
            e2 = g3.i(g2).a(bVar5);
        } while (bVar2.f() < bVar.f());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    public void a(int[] iArr, int i2) throws ReedSolomonException {
        b bVar = new b(this.f8356a, iArr);
        int[] iArr2 = new int[i2];
        boolean z = true;
        for (int i3 = 0; i3 < i2; i3++) {
            a aVar = this.f8356a;
            int c2 = bVar.c(aVar.c(aVar.d() + i3));
            iArr2[(i2 - 1) - i3] = c2;
            if (c2 != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        b[] d2 = d(this.f8356a.b(i2, 1), new b(this.f8356a, iArr2), i2);
        b bVar2 = d2[0];
        b bVar3 = d2[1];
        int[] b2 = b(bVar2);
        int[] c3 = c(bVar3, b2);
        for (int i4 = 0; i4 < b2.length; i4++) {
            int length = (iArr.length - 1) - this.f8356a.i(b2[i4]);
            if (length < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[length] = a.a(iArr[length], c3[i4]);
        }
    }
}
