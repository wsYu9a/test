package com.opos.exoplayer.core.i;

/* loaded from: classes4.dex */
public final class n {

    /* renamed from: a */
    private byte[] f19051a;

    /* renamed from: b */
    private int f19052b;

    /* renamed from: c */
    private int f19053c;

    /* renamed from: d */
    private int f19054d;

    public n(byte[] bArr, int i2, int i3) {
        a(bArr, i2, i3);
    }

    private boolean d(int i2) {
        if (2 <= i2 && i2 < this.f19052b) {
            byte[] bArr = this.f19051a;
            if (bArr[i2] == 3 && bArr[i2 - 2] == 0 && bArr[i2 - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    private int f() {
        int i2 = 0;
        while (!b()) {
            i2++;
        }
        return ((1 << i2) - 1) + (i2 > 0 ? c(i2) : 0);
    }

    private void g() {
        int i2;
        int i3 = this.f19053c;
        a.b(i3 >= 0 && (i3 < (i2 = this.f19052b) || (i3 == i2 && this.f19054d == 0)));
    }

    public void a() {
        int i2 = this.f19054d + 1;
        this.f19054d = i2;
        if (i2 == 8) {
            this.f19054d = 0;
            int i3 = this.f19053c;
            this.f19053c = (d(i3 + 1) ? 2 : 1) + i3;
        }
        g();
    }

    public void a(int i2) {
        int i3 = this.f19053c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        this.f19053c = i5;
        int i6 = (i2 - (i4 * 8)) + this.f19054d;
        this.f19054d = i6;
        if (i6 > 7) {
            this.f19053c = i5 + 1;
            this.f19054d = i6 - 8;
        }
        while (true) {
            i3++;
            if (i3 > this.f19053c) {
                g();
                return;
            } else if (d(i3)) {
                this.f19053c++;
                i3 += 2;
            }
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        this.f19051a = bArr;
        this.f19053c = i2;
        this.f19052b = i3;
        this.f19054d = 0;
        g();
    }

    public boolean b() {
        boolean z = (this.f19051a[this.f19053c] & (128 >> this.f19054d)) != 0;
        a();
        return z;
    }

    public boolean b(int i2) {
        int i3 = this.f19053c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        int i6 = (this.f19054d + i2) - (i4 * 8);
        if (i6 > 7) {
            i5++;
            i6 -= 8;
        }
        while (true) {
            i3++;
            if (i3 > i5 || i5 >= this.f19052b) {
                break;
            }
            if (d(i3)) {
                i5++;
                i3 += 2;
            }
        }
        int i7 = this.f19052b;
        if (i5 >= i7) {
            return i5 == i7 && i6 == 0;
        }
        return true;
    }

    public int c(int i2) {
        int i3;
        this.f19054d += i2;
        int i4 = 0;
        while (true) {
            i3 = this.f19054d;
            if (i3 <= 8) {
                break;
            }
            int i5 = i3 - 8;
            this.f19054d = i5;
            byte[] bArr = this.f19051a;
            int i6 = this.f19053c;
            i4 |= (bArr[i6] & 255) << i5;
            if (!d(i6 + 1)) {
                r3 = 1;
            }
            this.f19053c = r3 + i6;
        }
        byte[] bArr2 = this.f19051a;
        int i7 = this.f19053c;
        byte b2 = bArr2[i7];
        if (i3 == 8) {
            this.f19054d = 0;
            this.f19053c = i7 + (d(i7 + 1) ? 2 : 1);
        }
        g();
        return ((-1) >>> (32 - i2)) & (((b2 & 255) >> (8 - i3)) | i4);
    }

    public boolean c() {
        int i2 = this.f19053c;
        int i3 = this.f19054d;
        int i4 = 0;
        while (this.f19053c < this.f19052b && !b()) {
            i4++;
        }
        boolean z = this.f19053c == this.f19052b;
        this.f19053c = i2;
        this.f19054d = i3;
        return !z && b((i4 * 2) + 1);
    }

    public int d() {
        return f();
    }

    public int e() {
        int f2 = f();
        return (f2 % 2 == 0 ? -1 : 1) * ((f2 + 1) / 2);
    }
}
