package b6;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    public final a f1299a;

    /* renamed from: b */
    public final int[] f1300b;

    public b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f1299a = aVar;
        int length = iArr.length;
        int i10 = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.f1300b = iArr;
            return;
        }
        while (i10 < length && iArr[i10] == 0) {
            i10++;
        }
        if (i10 == length) {
            this.f1300b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i10];
        this.f1300b = iArr2;
        System.arraycopy(iArr, i10, iArr2, 0, iArr2.length);
    }

    public b a(b bVar) {
        if (!this.f1299a.equals(bVar.f1299a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g()) {
            return bVar;
        }
        if (bVar.g()) {
            return this;
        }
        int[] iArr = this.f1300b;
        int[] iArr2 = bVar.f1300b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i10 = length; i10 < iArr.length; i10++) {
            iArr3[i10] = a.a(iArr2[i10 - length], iArr[i10]);
        }
        return new b(this.f1299a, iArr3);
    }

    public b[] b(b bVar) {
        if (!this.f1299a.equals(bVar.f1299a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (bVar.g()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        b g10 = this.f1299a.g();
        int h10 = this.f1299a.h(bVar.d(bVar.f()));
        b bVar2 = this;
        while (bVar2.f() >= bVar.f() && !bVar2.g()) {
            int f10 = bVar2.f() - bVar.f();
            int j10 = this.f1299a.j(bVar2.d(bVar2.f()), h10);
            b j11 = bVar.j(f10, j10);
            g10 = g10.a(this.f1299a.b(f10, j10));
            bVar2 = bVar2.a(j11);
        }
        return new b[]{g10, bVar2};
    }

    public int c(int i10) {
        if (i10 == 0) {
            return d(0);
        }
        if (i10 == 1) {
            int i11 = 0;
            for (int i12 : this.f1300b) {
                i11 = a.a(i11, i12);
            }
            return i11;
        }
        int[] iArr = this.f1300b;
        int i13 = iArr[0];
        int length = iArr.length;
        for (int i14 = 1; i14 < length; i14++) {
            i13 = a.a(this.f1299a.j(i10, i13), this.f1300b[i14]);
        }
        return i13;
    }

    public int d(int i10) {
        return this.f1300b[(r0.length - 1) - i10];
    }

    public int[] e() {
        return this.f1300b;
    }

    public int f() {
        return this.f1300b.length - 1;
    }

    public boolean g() {
        return this.f1300b[0] == 0;
    }

    public b h(int i10) {
        if (i10 == 0) {
            return this.f1299a.g();
        }
        if (i10 == 1) {
            return this;
        }
        int length = this.f1300b.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = this.f1299a.j(this.f1300b[i11], i10);
        }
        return new b(this.f1299a, iArr);
    }

    public b i(b bVar) {
        if (!this.f1299a.equals(bVar.f1299a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g() || bVar.g()) {
            return this.f1299a.g();
        }
        int[] iArr = this.f1300b;
        int length = iArr.length;
        int[] iArr2 = bVar.f1300b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = iArr[i10];
            for (int i12 = 0; i12 < length2; i12++) {
                int i13 = i10 + i12;
                iArr3[i13] = a.a(iArr3[i13], this.f1299a.j(i11, iArr2[i12]));
            }
        }
        return new b(this.f1299a, iArr3);
    }

    public b j(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f1299a.g();
        }
        int length = this.f1300b.length;
        int[] iArr = new int[i10 + length];
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = this.f1299a.j(this.f1300b[i12], i11);
        }
        return new b(this.f1299a, iArr);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(f() * 8);
        for (int f10 = f(); f10 >= 0; f10--) {
            int d10 = d(f10);
            if (d10 != 0) {
                if (d10 < 0) {
                    sb2.append(" - ");
                    d10 = -d10;
                } else if (sb2.length() > 0) {
                    sb2.append(" + ");
                }
                if (f10 == 0 || d10 != 1) {
                    int i10 = this.f1299a.i(d10);
                    if (i10 == 0) {
                        sb2.append('1');
                    } else if (i10 == 1) {
                        sb2.append('a');
                    } else {
                        sb2.append("a^");
                        sb2.append(i10);
                    }
                }
                if (f10 != 0) {
                    if (f10 == 1) {
                        sb2.append('x');
                    } else {
                        sb2.append("x^");
                        sb2.append(f10);
                    }
                }
            }
        }
        return sb2.toString();
    }
}
