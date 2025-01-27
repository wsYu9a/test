package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class b implements Cloneable {

    /* renamed from: a */
    private final int f8288a;

    /* renamed from: b */
    private final int f8289b;

    /* renamed from: c */
    private final int f8290c;

    /* renamed from: d */
    private final int[] f8291d;

    public b(int i2) {
        this(i2, i2);
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f8289b * (this.f8288a + 1));
        for (int i2 = 0; i2 < this.f8289b; i2++) {
            for (int i3 = 0; i3 < this.f8288a; i3++) {
                sb.append(e(i3, i2) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public static b m(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        int i6 = 0;
        while (i2 < str.length()) {
            if (str.charAt(i2) == '\n' || str.charAt(i2) == '\r') {
                if (i3 > i4) {
                    if (i5 == -1) {
                        i5 = i3 - i4;
                    } else if (i3 - i4 != i5) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i6++;
                    i4 = i3;
                }
                i2++;
            } else {
                if (str.substring(i2, str2.length() + i2).equals(str2)) {
                    i2 += str2.length();
                    zArr[i3] = true;
                } else {
                    if (!str.substring(i2, str3.length() + i2).equals(str3)) {
                        throw new IllegalArgumentException("illegal character encountered: " + str.substring(i2));
                    }
                    i2 += str3.length();
                    zArr[i3] = false;
                }
                i3++;
            }
        }
        if (i3 > i4) {
            if (i5 == -1) {
                i5 = i3 - i4;
            } else if (i3 - i4 != i5) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i6++;
        }
        b bVar = new b(i5, i6);
        for (int i7 = 0; i7 < i3; i7++) {
            if (zArr[i7]) {
                bVar.o(i7 % i5, i7 / i5);
            }
        }
        return bVar;
    }

    public void b() {
        int length = this.f8291d.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f8291d[i2] = 0;
        }
    }

    /* renamed from: c */
    public b clone() {
        return new b(this.f8288a, this.f8289b, this.f8290c, (int[]) this.f8291d.clone());
    }

    public void d(int i2, int i3) {
        int i4 = (i3 * this.f8290c) + (i2 / 32);
        int[] iArr = this.f8291d;
        iArr[i4] = (1 << (i2 & 31)) ^ iArr[i4];
    }

    public boolean e(int i2, int i3) {
        return ((this.f8291d[(i3 * this.f8290c) + (i2 / 32)] >>> (i2 & 31)) & 1) != 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f8288a == bVar.f8288a && this.f8289b == bVar.f8289b && this.f8290c == bVar.f8290c && Arrays.equals(this.f8291d, bVar.f8291d);
    }

    public int[] f() {
        int length = this.f8291d.length - 1;
        while (length >= 0 && this.f8291d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i2 = this.f8290c;
        int i3 = length / i2;
        int i4 = (length % i2) << 5;
        int i5 = 31;
        while ((this.f8291d[length] >>> i5) == 0) {
            i5--;
        }
        return new int[]{i4 + i5, i3};
    }

    public int[] g() {
        int i2 = this.f8288a;
        int i3 = this.f8289b;
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < this.f8289b; i6++) {
            int i7 = 0;
            while (true) {
                int i8 = this.f8290c;
                if (i7 < i8) {
                    int i9 = this.f8291d[(i8 * i6) + i7];
                    if (i9 != 0) {
                        if (i6 < i3) {
                            i3 = i6;
                        }
                        if (i6 > i5) {
                            i5 = i6;
                        }
                        int i10 = i7 << 5;
                        if (i10 < i2) {
                            int i11 = 0;
                            while ((i9 << (31 - i11)) == 0) {
                                i11++;
                            }
                            int i12 = i11 + i10;
                            if (i12 < i2) {
                                i2 = i12;
                            }
                        }
                        if (i10 + 31 > i4) {
                            int i13 = 31;
                            while ((i9 >>> i13) == 0) {
                                i13--;
                            }
                            int i14 = i10 + i13;
                            if (i14 > i4) {
                                i4 = i14;
                            }
                        }
                    }
                    i7++;
                }
            }
        }
        if (i4 < i2 || i5 < i3) {
            return null;
        }
        return new int[]{i2, i3, (i4 - i2) + 1, (i5 - i3) + 1};
    }

    public int h() {
        return this.f8289b;
    }

    public int hashCode() {
        int i2 = this.f8288a;
        return (((((((i2 * 31) + i2) * 31) + this.f8289b) * 31) + this.f8290c) * 31) + Arrays.hashCode(this.f8291d);
    }

    public a i(int i2, a aVar) {
        if (aVar == null || aVar.l() < this.f8288a) {
            aVar = new a(this.f8288a);
        } else {
            aVar.d();
        }
        int i3 = i2 * this.f8290c;
        for (int i4 = 0; i4 < this.f8290c; i4++) {
            aVar.r(i4 << 5, this.f8291d[i3 + i4]);
        }
        return aVar;
    }

    public int j() {
        return this.f8290c;
    }

    public int[] k() {
        int[] iArr;
        int i2 = 0;
        while (true) {
            iArr = this.f8291d;
            if (i2 >= iArr.length || iArr[i2] != 0) {
                break;
            }
            i2++;
        }
        if (i2 == iArr.length) {
            return null;
        }
        int i3 = this.f8290c;
        int i4 = i2 / i3;
        int i5 = (i2 % i3) << 5;
        int i6 = iArr[i2];
        int i7 = 0;
        while ((i6 << (31 - i7)) == 0) {
            i7++;
        }
        return new int[]{i5 + i7, i4};
    }

    public int l() {
        return this.f8288a;
    }

    public void n() {
        int l = l();
        int h2 = h();
        a aVar = new a(l);
        a aVar2 = new a(l);
        for (int i2 = 0; i2 < (h2 + 1) / 2; i2++) {
            aVar = i(i2, aVar);
            int i3 = (h2 - 1) - i2;
            aVar2 = i(i3, aVar2);
            aVar.p();
            aVar2.p();
            q(i2, aVar2);
            q(i3, aVar);
        }
    }

    public void o(int i2, int i3) {
        int i4 = (i3 * this.f8290c) + (i2 / 32);
        int[] iArr = this.f8291d;
        iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
    }

    public void p(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i5 <= 0 || i4 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i6 = i4 + i2;
        int i7 = i5 + i3;
        if (i7 > this.f8289b || i6 > this.f8288a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i3 < i7) {
            int i8 = this.f8290c * i3;
            for (int i9 = i2; i9 < i6; i9++) {
                int[] iArr = this.f8291d;
                int i10 = (i9 / 32) + i8;
                iArr[i10] = iArr[i10] | (1 << (i9 & 31));
            }
            i3++;
        }
    }

    public void q(int i2, a aVar) {
        int[] i3 = aVar.i();
        int[] iArr = this.f8291d;
        int i4 = this.f8290c;
        System.arraycopy(i3, 0, iArr, i2 * i4, i4);
    }

    public String r(String str, String str2) {
        return a(str, str2, "\n");
    }

    @Deprecated
    public String s(String str, String str2, String str3) {
        return a(str, str2, str3);
    }

    public void t(int i2, int i3) {
        int i4 = (i3 * this.f8290c) + (i2 / 32);
        int[] iArr = this.f8291d;
        iArr[i4] = ((1 << (i2 & 31)) ^ (-1)) & iArr[i4];
    }

    public String toString() {
        return r("X ", "  ");
    }

    public void u(b bVar) {
        if (this.f8288a != bVar.l() || this.f8289b != bVar.h() || this.f8290c != bVar.j()) {
            throw new IllegalArgumentException("input matrix dimensions do not match");
        }
        a aVar = new a((this.f8288a / 32) + 1);
        for (int i2 = 0; i2 < this.f8289b; i2++) {
            int i3 = this.f8290c * i2;
            int[] i4 = bVar.i(i2, aVar).i();
            for (int i5 = 0; i5 < this.f8290c; i5++) {
                int[] iArr = this.f8291d;
                int i6 = i3 + i5;
                iArr[i6] = iArr[i6] ^ i4[i5];
            }
        }
    }

    public b(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f8288a = i2;
        this.f8289b = i3;
        int i4 = (i2 + 31) / 32;
        this.f8290c = i4;
        this.f8291d = new int[i4 * i3];
    }

    private b(int i2, int i3, int i4, int[] iArr) {
        this.f8288a = i2;
        this.f8289b = i3;
        this.f8290c = i4;
        this.f8291d = iArr;
    }
}
