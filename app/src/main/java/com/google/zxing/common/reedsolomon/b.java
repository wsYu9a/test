package com.google.zxing.common.reedsolomon;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a */
    private final a f8354a;

    /* renamed from: b */
    private final int[] f8355b;

    b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f8354a = aVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f8355b = iArr;
            return;
        }
        int i2 = 1;
        while (i2 < length && iArr[i2] == 0) {
            i2++;
        }
        if (i2 == length) {
            this.f8355b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i2];
        this.f8355b = iArr2;
        System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
    }

    b a(b bVar) {
        if (!this.f8354a.equals(bVar.f8354a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g()) {
            return bVar;
        }
        if (bVar.g()) {
            return this;
        }
        int[] iArr = this.f8355b;
        int[] iArr2 = bVar.f8355b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i2 = length; i2 < iArr.length; i2++) {
            iArr3[i2] = a.a(iArr2[i2 - length], iArr[i2]);
        }
        return new b(this.f8354a, iArr3);
    }

    b[] b(b bVar) {
        if (!this.f8354a.equals(bVar.f8354a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (bVar.g()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        b g2 = this.f8354a.g();
        int h2 = this.f8354a.h(bVar.d(bVar.f()));
        b bVar2 = this;
        while (bVar2.f() >= bVar.f() && !bVar2.g()) {
            int f2 = bVar2.f() - bVar.f();
            int j2 = this.f8354a.j(bVar2.d(bVar2.f()), h2);
            b j3 = bVar.j(f2, j2);
            g2 = g2.a(this.f8354a.b(f2, j2));
            bVar2 = bVar2.a(j3);
        }
        return new b[]{g2, bVar2};
    }

    int c(int i2) {
        if (i2 == 0) {
            return d(0);
        }
        if (i2 == 1) {
            int i3 = 0;
            for (int i4 : this.f8355b) {
                i3 = a.a(i3, i4);
            }
            return i3;
        }
        int[] iArr = this.f8355b;
        int i5 = iArr[0];
        int length = iArr.length;
        for (int i6 = 1; i6 < length; i6++) {
            i5 = a.a(this.f8354a.j(i2, i5), this.f8355b[i6]);
        }
        return i5;
    }

    int d(int i2) {
        return this.f8355b[(r0.length - 1) - i2];
    }

    int[] e() {
        return this.f8355b;
    }

    int f() {
        return this.f8355b.length - 1;
    }

    boolean g() {
        return this.f8355b[0] == 0;
    }

    b h(int i2) {
        if (i2 == 0) {
            return this.f8354a.g();
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.f8355b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f8354a.j(this.f8355b[i3], i2);
        }
        return new b(this.f8354a, iArr);
    }

    b i(b bVar) {
        if (!this.f8354a.equals(bVar.f8354a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g() || bVar.g()) {
            return this.f8354a.g();
        }
        int[] iArr = this.f8355b;
        int length = iArr.length;
        int[] iArr2 = bVar.f8355b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            for (int i4 = 0; i4 < length2; i4++) {
                int i5 = i2 + i4;
                iArr3[i5] = a.a(iArr3[i5], this.f8354a.j(i3, iArr2[i4]));
            }
        }
        return new b(this.f8354a, iArr3);
    }

    b j(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f8354a.g();
        }
        int length = this.f8355b.length;
        int[] iArr = new int[i2 + length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.f8354a.j(this.f8355b[i4], i3);
        }
        return new b(this.f8354a, iArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(f() * 8);
        for (int f2 = f(); f2 >= 0; f2--) {
            int d2 = d(f2);
            if (d2 != 0) {
                if (d2 < 0) {
                    sb.append(" - ");
                    d2 = -d2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (f2 == 0 || d2 != 1) {
                    int i2 = this.f8354a.i(d2);
                    if (i2 == 0) {
                        sb.append('1');
                    } else if (i2 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i2);
                    }
                }
                if (f2 != 0) {
                    if (f2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(f2);
                    }
                }
            }
        }
        return sb.toString();
    }
}
