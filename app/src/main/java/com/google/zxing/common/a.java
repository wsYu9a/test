package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int[] f8286a;

    /* renamed from: b, reason: collision with root package name */
    private int f8287b;

    public a() {
        this.f8287b = 0;
        this.f8286a = new int[1];
    }

    private void f(int i2) {
        if (i2 > (this.f8286a.length << 5)) {
            int[] o = o(i2);
            int[] iArr = this.f8286a;
            System.arraycopy(iArr, 0, o, 0, iArr.length);
            this.f8286a = o;
        }
    }

    private static int[] o(int i2) {
        return new int[(i2 + 31) / 32];
    }

    public void a(boolean z) {
        f(this.f8287b + 1);
        if (z) {
            int[] iArr = this.f8286a;
            int i2 = this.f8287b;
            int i3 = i2 / 32;
            iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
        }
        this.f8287b++;
    }

    public void b(a aVar) {
        int i2 = aVar.f8287b;
        f(this.f8287b + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            a(aVar.h(i3));
        }
    }

    public void c(int i2, int i3) {
        if (i3 < 0 || i3 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        f(this.f8287b + i3);
        while (i3 > 0) {
            boolean z = true;
            if (((i2 >> (i3 - 1)) & 1) != 1) {
                z = false;
            }
            a(z);
            i3--;
        }
    }

    public void d() {
        int length = this.f8286a.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f8286a[i2] = 0;
        }
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a clone() {
        return new a((int[]) this.f8286a.clone(), this.f8287b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f8287b == aVar.f8287b && Arrays.equals(this.f8286a, aVar.f8286a);
    }

    public void g(int i2) {
        int[] iArr = this.f8286a;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) ^ iArr[i3];
    }

    public boolean h(int i2) {
        return ((1 << (i2 & 31)) & this.f8286a[i2 / 32]) != 0;
    }

    public int hashCode() {
        return (this.f8287b * 31) + Arrays.hashCode(this.f8286a);
    }

    public int[] i() {
        return this.f8286a;
    }

    public int j(int i2) {
        int i3 = this.f8287b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (((1 << (i2 & 31)) - 1) ^ (-1)) & this.f8286a[i4];
        while (i5 == 0) {
            i4++;
            int[] iArr = this.f8286a;
            if (i4 == iArr.length) {
                return this.f8287b;
            }
            i5 = iArr[i4];
        }
        int numberOfTrailingZeros = (i4 << 5) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.f8287b;
        return numberOfTrailingZeros > i6 ? i6 : numberOfTrailingZeros;
    }

    public int k(int i2) {
        int i3 = this.f8287b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (((1 << (i2 & 31)) - 1) ^ (-1)) & (this.f8286a[i4] ^ (-1));
        while (i5 == 0) {
            i4++;
            int[] iArr = this.f8286a;
            if (i4 == iArr.length) {
                return this.f8287b;
            }
            i5 = iArr[i4] ^ (-1);
        }
        int numberOfTrailingZeros = (i4 << 5) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.f8287b;
        return numberOfTrailingZeros > i6 ? i6 : numberOfTrailingZeros;
    }

    public int l() {
        return this.f8287b;
    }

    public int m() {
        return (this.f8287b + 7) / 8;
    }

    public boolean n(int i2, int i3, boolean z) {
        if (i3 < i2 || i2 < 0 || i3 > this.f8287b) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return true;
        }
        int i4 = i3 - 1;
        int i5 = i2 / 32;
        int i6 = i4 / 32;
        int i7 = i5;
        while (i7 <= i6) {
            int i8 = (2 << (i7 >= i6 ? 31 & i4 : 31)) - (1 << (i7 > i5 ? 0 : i2 & 31));
            int i9 = this.f8286a[i7] & i8;
            if (!z) {
                i8 = 0;
            }
            if (i9 != i8) {
                return false;
            }
            i7++;
        }
        return true;
    }

    public void p() {
        int[] iArr = new int[this.f8286a.length];
        int i2 = (this.f8287b - 1) / 32;
        int i3 = i2 + 1;
        for (int i4 = 0; i4 < i3; i4++) {
            long j2 = this.f8286a[i4];
            long j3 = ((j2 & 1431655765) << 1) | ((j2 >> 1) & 1431655765);
            long j4 = ((j3 & 858993459) << 2) | ((j3 >> 2) & 858993459);
            long j5 = ((j4 & 252645135) << 4) | ((j4 >> 4) & 252645135);
            long j6 = ((j5 & 16711935) << 8) | ((j5 >> 8) & 16711935);
            iArr[i2 - i4] = (int) (((j6 & 65535) << 16) | ((j6 >> 16) & 65535));
        }
        int i5 = this.f8287b;
        int i6 = i3 << 5;
        if (i5 != i6) {
            int i7 = i6 - i5;
            int i8 = iArr[0] >>> i7;
            for (int i9 = 1; i9 < i3; i9++) {
                int i10 = iArr[i9];
                iArr[i9 - 1] = i8 | (i10 << (32 - i7));
                i8 = i10 >>> i7;
            }
            iArr[i3 - 1] = i8;
        }
        this.f8286a = iArr;
    }

    public void q(int i2) {
        int[] iArr = this.f8286a;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
    }

    public void r(int i2, int i3) {
        this.f8286a[i2 / 32] = i3;
    }

    public void s(int i2, int i3) {
        if (i3 < i2 || i2 < 0 || i3 > this.f8287b) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return;
        }
        int i4 = i3 - 1;
        int i5 = i2 / 32;
        int i6 = i4 / 32;
        int i7 = i5;
        while (i7 <= i6) {
            int i8 = 31;
            int i9 = i7 > i5 ? 0 : i2 & 31;
            if (i7 >= i6) {
                i8 = 31 & i4;
            }
            int i10 = (2 << i8) - (1 << i9);
            int[] iArr = this.f8286a;
            iArr[i7] = i10 | iArr[i7];
            i7++;
        }
    }

    public void t(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (h(i2)) {
                    i6 |= 1 << (7 - i7);
                }
                i2++;
            }
            bArr[i3 + i5] = (byte) i6;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f8287b);
        for (int i2 = 0; i2 < this.f8287b; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(h(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    public void u(a aVar) {
        if (this.f8287b != aVar.f8287b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.f8286a;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = iArr[i2] ^ aVar.f8286a[i2];
            i2++;
        }
    }

    public a(int i2) {
        this.f8287b = i2;
        this.f8286a = o(i2);
    }

    a(int[] iArr, int i2) {
        this.f8286a = iArr;
        this.f8287b = i2;
    }
}
