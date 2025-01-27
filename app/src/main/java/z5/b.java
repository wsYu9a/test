package z5;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class b implements Cloneable {

    /* renamed from: b */
    public final int f33649b;

    /* renamed from: c */
    public final int f33650c;

    /* renamed from: d */
    public final int f33651d;

    /* renamed from: e */
    public final int[] f33652e;

    public b(int i10) {
        this(i10, i10);
    }

    public static b m(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = -1;
        int i14 = 0;
        while (i10 < str.length()) {
            if (str.charAt(i10) == '\n' || str.charAt(i10) == '\r') {
                if (i11 > i12) {
                    if (i13 == -1) {
                        i13 = i11 - i12;
                    } else if (i11 - i12 != i13) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i14++;
                    i12 = i11;
                }
                i10++;
            } else {
                if (str.substring(i10, str2.length() + i10).equals(str2)) {
                    i10 += str2.length();
                    zArr[i11] = true;
                } else {
                    if (!str.substring(i10, str3.length() + i10).equals(str3)) {
                        throw new IllegalArgumentException("illegal character encountered: " + str.substring(i10));
                    }
                    i10 += str3.length();
                    zArr[i11] = false;
                }
                i11++;
            }
        }
        if (i11 > i12) {
            if (i13 == -1) {
                i13 = i11 - i12;
            } else if (i11 - i12 != i13) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i14++;
        }
        b bVar = new b(i13, i14);
        for (int i15 = 0; i15 < i11; i15++) {
            if (zArr[i15]) {
                bVar.o(i15 % i13, i15 / i13);
            }
        }
        return bVar;
    }

    public final String a(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(this.f33650c * (this.f33649b + 1));
        for (int i10 = 0; i10 < this.f33650c; i10++) {
            for (int i11 = 0; i11 < this.f33649b; i11++) {
                sb2.append(e(i11, i10) ? str : str2);
            }
            sb2.append(str3);
        }
        return sb2.toString();
    }

    public void b() {
        int length = this.f33652e.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f33652e[i10] = 0;
        }
    }

    /* renamed from: c */
    public b clone() {
        return new b(this.f33649b, this.f33650c, this.f33651d, (int[]) this.f33652e.clone());
    }

    public void d(int i10, int i11) {
        int i12 = (i11 * this.f33651d) + (i10 / 32);
        int[] iArr = this.f33652e;
        iArr[i12] = (1 << (i10 & 31)) ^ iArr[i12];
    }

    public boolean e(int i10, int i11) {
        return ((this.f33652e[(i11 * this.f33651d) + (i10 / 32)] >>> (i10 & 31)) & 1) != 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f33649b == bVar.f33649b && this.f33650c == bVar.f33650c && this.f33651d == bVar.f33651d && Arrays.equals(this.f33652e, bVar.f33652e);
    }

    public int[] f() {
        int length = this.f33652e.length - 1;
        while (length >= 0 && this.f33652e[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i10 = this.f33651d;
        int i11 = length / i10;
        int i12 = (length % i10) << 5;
        int i13 = 31;
        while ((this.f33652e[length] >>> i13) == 0) {
            i13--;
        }
        return new int[]{i12 + i13, i11};
    }

    public int[] g() {
        int i10 = this.f33649b;
        int i11 = this.f33650c;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < this.f33650c; i14++) {
            int i15 = 0;
            while (true) {
                int i16 = this.f33651d;
                if (i15 < i16) {
                    int i17 = this.f33652e[(i16 * i14) + i15];
                    if (i17 != 0) {
                        if (i14 < i11) {
                            i11 = i14;
                        }
                        if (i14 > i13) {
                            i13 = i14;
                        }
                        int i18 = i15 << 5;
                        if (i18 < i10) {
                            int i19 = 0;
                            while ((i17 << (31 - i19)) == 0) {
                                i19++;
                            }
                            int i20 = i19 + i18;
                            if (i20 < i10) {
                                i10 = i20;
                            }
                        }
                        if (i18 + 31 > i12) {
                            int i21 = 31;
                            while ((i17 >>> i21) == 0) {
                                i21--;
                            }
                            int i22 = i18 + i21;
                            if (i22 > i12) {
                                i12 = i22;
                            }
                        }
                    }
                    i15++;
                }
            }
        }
        if (i12 < i10 || i13 < i11) {
            return null;
        }
        return new int[]{i10, i11, (i12 - i10) + 1, (i13 - i11) + 1};
    }

    public int h() {
        return this.f33650c;
    }

    public int hashCode() {
        int i10 = this.f33649b;
        return (((((((i10 * 31) + i10) * 31) + this.f33650c) * 31) + this.f33651d) * 31) + Arrays.hashCode(this.f33652e);
    }

    public a i(int i10, a aVar) {
        if (aVar == null || aVar.l() < this.f33649b) {
            aVar = new a(this.f33649b);
        } else {
            aVar.d();
        }
        int i11 = i10 * this.f33651d;
        for (int i12 = 0; i12 < this.f33651d; i12++) {
            aVar.r(i12 << 5, this.f33652e[i11 + i12]);
        }
        return aVar;
    }

    public int j() {
        return this.f33651d;
    }

    public int[] k() {
        int[] iArr;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            iArr = this.f33652e;
            if (i11 >= iArr.length || iArr[i11] != 0) {
                break;
            }
            i11++;
        }
        if (i11 == iArr.length) {
            return null;
        }
        int i12 = this.f33651d;
        int i13 = i11 / i12;
        int i14 = (i11 % i12) << 5;
        while ((iArr[i11] << (31 - i10)) == 0) {
            i10++;
        }
        return new int[]{i14 + i10, i13};
    }

    public int l() {
        return this.f33649b;
    }

    public void n() {
        int l10 = l();
        int h10 = h();
        a aVar = new a(l10);
        a aVar2 = new a(l10);
        for (int i10 = 0; i10 < (h10 + 1) / 2; i10++) {
            aVar = i(i10, aVar);
            int i11 = (h10 - 1) - i10;
            aVar2 = i(i11, aVar2);
            aVar.p();
            aVar2.p();
            q(i10, aVar2);
            q(i11, aVar);
        }
    }

    public void o(int i10, int i11) {
        int i12 = (i11 * this.f33651d) + (i10 / 32);
        int[] iArr = this.f33652e;
        iArr[i12] = (1 << (i10 & 31)) | iArr[i12];
    }

    public void p(int i10, int i11, int i12, int i13) {
        if (i11 < 0 || i10 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i13 <= 0 || i12 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i14 = i12 + i10;
        int i15 = i13 + i11;
        if (i15 > this.f33650c || i14 > this.f33649b) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i11 < i15) {
            int i16 = this.f33651d * i11;
            for (int i17 = i10; i17 < i14; i17++) {
                int[] iArr = this.f33652e;
                int i18 = (i17 / 32) + i16;
                iArr[i18] = iArr[i18] | (1 << (i17 & 31));
            }
            i11++;
        }
    }

    public void q(int i10, a aVar) {
        int[] i11 = aVar.i();
        int[] iArr = this.f33652e;
        int i12 = this.f33651d;
        System.arraycopy(i11, 0, iArr, i10 * i12, i12);
    }

    public String r(String str, String str2) {
        return a(str, str2, "\n");
    }

    @Deprecated
    public String s(String str, String str2, String str3) {
        return a(str, str2, str3);
    }

    public void t(int i10, int i11) {
        int i12 = (i11 * this.f33651d) + (i10 / 32);
        int[] iArr = this.f33652e;
        iArr[i12] = (~(1 << (i10 & 31))) & iArr[i12];
    }

    public String toString() {
        return r("X ", "  ");
    }

    public void u(b bVar) {
        if (this.f33649b != bVar.l() || this.f33650c != bVar.h() || this.f33651d != bVar.j()) {
            throw new IllegalArgumentException("input matrix dimensions do not match");
        }
        a aVar = new a((this.f33649b / 32) + 1);
        for (int i10 = 0; i10 < this.f33650c; i10++) {
            int i11 = this.f33651d * i10;
            int[] i12 = bVar.i(i10, aVar).i();
            for (int i13 = 0; i13 < this.f33651d; i13++) {
                int[] iArr = this.f33652e;
                int i14 = i11 + i13;
                iArr[i14] = iArr[i14] ^ i12[i13];
            }
        }
    }

    public b(int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f33649b = i10;
        this.f33650c = i11;
        int i12 = (i10 + 31) / 32;
        this.f33651d = i12;
        this.f33652e = new int[i12 * i11];
    }

    public b(int i10, int i11, int i12, int[] iArr) {
        this.f33649b = i10;
        this.f33650c = i11;
        this.f33651d = i12;
        this.f33652e = iArr;
    }
}
