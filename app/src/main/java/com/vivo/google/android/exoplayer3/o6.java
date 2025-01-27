package com.vivo.google.android.exoplayer3;

/* loaded from: classes4.dex */
public final class o6 {

    /* renamed from: a */
    public byte[] f27902a;

    /* renamed from: b */
    public int f27903b;

    /* renamed from: c */
    public int f27904c;

    /* renamed from: d */
    public int f27905d;

    public o6(byte[] bArr, int i2, int i3) {
        a(bArr, i2, i3);
    }

    public final void a() {
        int i2;
        int i3 = this.f27904c;
        g1.b(i3 >= 0 && (i3 < (i2 = this.f27903b) || (i3 == i2 && this.f27905d == 0)));
    }

    public void a(byte[] bArr, int i2, int i3) {
        this.f27902a = bArr;
        this.f27904c = i2;
        this.f27903b = i3;
        this.f27905d = 0;
        a();
    }

    public boolean a(int i2) {
        int i3 = this.f27904c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        int i6 = (this.f27905d + i2) - (i4 * 8);
        if (i6 > 7) {
            i5++;
            i6 -= 8;
        }
        while (true) {
            i3++;
            if (i3 > i5 || i5 >= this.f27903b) {
                break;
            }
            if (c(i3)) {
                i5++;
                i3 += 2;
            }
        }
        int i7 = this.f27903b;
        if (i5 >= i7) {
            return i5 == i7 && i6 == 0;
        }
        return true;
    }

    public int b(int i2) {
        int i3;
        this.f27905d += i2;
        int i4 = 0;
        while (true) {
            i3 = this.f27905d;
            if (i3 <= 8) {
                break;
            }
            int i5 = i3 - 8;
            this.f27905d = i5;
            byte[] bArr = this.f27902a;
            int i6 = this.f27904c;
            i4 |= (bArr[i6] & 255) << i5;
            if (!c(i6 + 1)) {
                r3 = 1;
            }
            this.f27904c = i6 + r3;
        }
        byte[] bArr2 = this.f27902a;
        int i7 = this.f27904c;
        int i8 = ((-1) >>> (32 - i2)) & (i4 | ((bArr2[i7] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f27905d = 0;
            this.f27904c = i7 + (c(i7 + 1) ? 2 : 1);
        }
        a();
        return i8;
    }

    public boolean b() {
        int i2 = this.f27904c;
        int i3 = this.f27905d;
        int i4 = 0;
        while (this.f27904c < this.f27903b && !c()) {
            i4++;
        }
        boolean z = this.f27904c == this.f27903b;
        this.f27904c = i2;
        this.f27905d = i3;
        return !z && a((i4 * 2) + 1);
    }

    public boolean c() {
        boolean z = (this.f27902a[this.f27904c] & (128 >> this.f27905d)) != 0;
        f();
        return z;
    }

    public final boolean c(int i2) {
        if (2 <= i2 && i2 < this.f27903b) {
            byte[] bArr = this.f27902a;
            if (bArr[i2] == 3 && bArr[i2 - 2] == 0 && bArr[i2 - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final int d() {
        int i2 = 0;
        while (!c()) {
            i2++;
        }
        return ((1 << i2) - 1) + (i2 > 0 ? b(i2) : 0);
    }

    public void d(int i2) {
        int i3 = this.f27904c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        this.f27904c = i5;
        int i6 = this.f27905d + (i2 - (i4 * 8));
        this.f27905d = i6;
        if (i6 > 7) {
            this.f27904c = i5 + 1;
            this.f27905d = i6 - 8;
        }
        while (true) {
            i3++;
            if (i3 > this.f27904c) {
                a();
                return;
            } else if (c(i3)) {
                this.f27904c++;
                i3 += 2;
            }
        }
    }

    public int e() {
        int d2 = d();
        return (d2 % 2 == 0 ? -1 : 1) * ((d2 + 1) / 2);
    }

    public void f() {
        int i2 = this.f27905d + 1;
        this.f27905d = i2;
        if (i2 == 8) {
            this.f27905d = 0;
            int i3 = this.f27904c;
            this.f27904c = i3 + (c(i3 + 1) ? 2 : 1);
        }
        a();
    }
}
