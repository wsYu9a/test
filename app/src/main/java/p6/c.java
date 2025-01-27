package p6;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a */
    public final b f29852a;

    /* renamed from: b */
    public final int[] f29853b;

    public c(b bVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f29852a = bVar;
        int length = iArr.length;
        int i10 = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.f29853b = iArr;
            return;
        }
        while (i10 < length && iArr[i10] == 0) {
            i10++;
        }
        if (i10 == length) {
            this.f29853b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i10];
        this.f29853b = iArr2;
        System.arraycopy(iArr, i10, iArr2, 0, iArr2.length);
    }

    public c a(c cVar) {
        if (!this.f29852a.equals(cVar.f29852a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (f()) {
            return cVar;
        }
        if (cVar.f()) {
            return this;
        }
        int[] iArr = this.f29853b;
        int[] iArr2 = cVar.f29853b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i10 = length; i10 < iArr.length; i10++) {
            iArr3[i10] = this.f29852a.a(iArr2[i10 - length], iArr[i10]);
        }
        return new c(this.f29852a, iArr3);
    }

    public int b(int i10) {
        if (i10 == 0) {
            return c(0);
        }
        if (i10 == 1) {
            int i11 = 0;
            for (int i12 : this.f29853b) {
                i11 = this.f29852a.a(i11, i12);
            }
            return i11;
        }
        int[] iArr = this.f29853b;
        int i13 = iArr[0];
        int length = iArr.length;
        for (int i14 = 1; i14 < length; i14++) {
            b bVar = this.f29852a;
            i13 = bVar.a(bVar.i(i10, i13), this.f29853b[i14]);
        }
        return i13;
    }

    public int c(int i10) {
        return this.f29853b[(r0.length - 1) - i10];
    }

    public int[] d() {
        return this.f29853b;
    }

    public int e() {
        return this.f29853b.length - 1;
    }

    public boolean f() {
        return this.f29853b[0] == 0;
    }

    public c g(int i10) {
        if (i10 == 0) {
            return this.f29852a.f();
        }
        if (i10 == 1) {
            return this;
        }
        int length = this.f29853b.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = this.f29852a.i(this.f29853b[i11], i10);
        }
        return new c(this.f29852a, iArr);
    }

    public c h(c cVar) {
        if (!this.f29852a.equals(cVar.f29852a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (f() || cVar.f()) {
            return this.f29852a.f();
        }
        int[] iArr = this.f29853b;
        int length = iArr.length;
        int[] iArr2 = cVar.f29853b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = iArr[i10];
            for (int i12 = 0; i12 < length2; i12++) {
                int i13 = i10 + i12;
                b bVar = this.f29852a;
                iArr3[i13] = bVar.a(iArr3[i13], bVar.i(i11, iArr2[i12]));
            }
        }
        return new c(this.f29852a, iArr3);
    }

    public c i(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f29852a.f();
        }
        int length = this.f29853b.length;
        int[] iArr = new int[i10 + length];
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = this.f29852a.i(this.f29853b[i12], i11);
        }
        return new c(this.f29852a, iArr);
    }

    public c j() {
        int length = this.f29853b.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = this.f29852a.j(0, this.f29853b[i10]);
        }
        return new c(this.f29852a, iArr);
    }

    public c k(c cVar) {
        if (this.f29852a.equals(cVar.f29852a)) {
            return cVar.f() ? this : a(cVar.j());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(e() * 8);
        for (int e10 = e(); e10 >= 0; e10--) {
            int c10 = c(e10);
            if (c10 != 0) {
                if (c10 < 0) {
                    sb2.append(" - ");
                    c10 = -c10;
                } else if (sb2.length() > 0) {
                    sb2.append(" + ");
                }
                if (e10 == 0 || c10 != 1) {
                    sb2.append(c10);
                }
                if (e10 != 0) {
                    if (e10 == 1) {
                        sb2.append('x');
                    } else {
                        sb2.append("x^");
                        sb2.append(e10);
                    }
                }
            }
        }
        return sb2.toString();
    }
}
