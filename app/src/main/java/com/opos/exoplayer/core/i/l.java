package com.opos.exoplayer.core.i;

/* loaded from: classes4.dex */
public final class l {

    /* renamed from: a */
    public byte[] f19044a;

    /* renamed from: b */
    private int f19045b;

    /* renamed from: c */
    private int f19046c;

    /* renamed from: d */
    private int f19047d;

    public l() {
    }

    public l(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public l(byte[] bArr, int i2) {
        this.f19044a = bArr;
        this.f19047d = i2;
    }

    private void g() {
        int i2;
        int i3 = this.f19045b;
        a.b(i3 >= 0 && (i3 < (i2 = this.f19047d) || (i3 == i2 && this.f19046c == 0)));
    }

    public int a() {
        return ((this.f19047d - this.f19045b) * 8) - this.f19046c;
    }

    public void a(int i2) {
        int i3 = i2 / 8;
        this.f19045b = i3;
        this.f19046c = i2 - (i3 * 8);
        g();
    }

    public void a(int i2, int i3) {
        if (i3 < 32) {
            i2 &= (1 << i3) - 1;
        }
        int min = Math.min(8 - this.f19046c, i3);
        int i4 = (8 - this.f19046c) - min;
        byte[] bArr = this.f19044a;
        int i5 = this.f19045b;
        bArr[i5] = (byte) (((65280 >> r3) | ((1 << i4) - 1)) & bArr[i5]);
        int i6 = i3 - min;
        bArr[i5] = (byte) (((i2 >>> i6) << i4) | bArr[i5]);
        int i7 = i5 + 1;
        while (i6 > 8) {
            this.f19044a[i7] = (byte) (i2 >>> (i6 - 8));
            i6 -= 8;
            i7++;
        }
        int i8 = 8 - i6;
        byte[] bArr2 = this.f19044a;
        bArr2[i7] = (byte) (bArr2[i7] & ((1 << i8) - 1));
        bArr2[i7] = (byte) (((i2 & ((1 << i6) - 1)) << i8) | bArr2[i7]);
        b(i3);
        g();
    }

    public void a(byte[] bArr) {
        a(bArr, bArr.length);
    }

    public void a(byte[] bArr, int i2) {
        this.f19044a = bArr;
        this.f19045b = 0;
        this.f19046c = 0;
        this.f19047d = i2;
    }

    public void a(byte[] bArr, int i2, int i3) {
        int i4 = (i3 >> 3) + i2;
        while (i2 < i4) {
            byte[] bArr2 = this.f19044a;
            int i5 = this.f19045b;
            this.f19045b = i5 + 1;
            byte b2 = bArr2[i5];
            int i6 = this.f19046c;
            bArr[i2] = (byte) (b2 << i6);
            bArr[i2] = (byte) (((255 & bArr2[r5]) >> (8 - i6)) | bArr[i2]);
            i2++;
        }
        int i7 = i3 & 7;
        if (i7 == 0) {
            return;
        }
        bArr[i4] = (byte) (bArr[i4] & (255 >> i7));
        int i8 = this.f19046c;
        if (i8 + i7 > 8) {
            byte b3 = bArr[i4];
            byte[] bArr3 = this.f19044a;
            this.f19045b = this.f19045b + 1;
            bArr[i4] = (byte) (b3 | ((byte) ((bArr3[r5] & 255) << i8)));
            this.f19046c = i8 - 8;
        }
        int i9 = this.f19046c + i7;
        this.f19046c = i9;
        byte[] bArr4 = this.f19044a;
        int i10 = this.f19045b;
        bArr[i4] = (byte) (((byte) (((255 & bArr4[i10]) >> (8 - i9)) << (8 - i7))) | bArr[i4]);
        if (i9 == 8) {
            this.f19046c = 0;
            this.f19045b = i10 + 1;
        }
        g();
    }

    public int b() {
        return (this.f19045b * 8) + this.f19046c;
    }

    public void b(int i2) {
        int i3 = i2 / 8;
        int i4 = this.f19045b + i3;
        this.f19045b = i4;
        int i5 = (i2 - (i3 * 8)) + this.f19046c;
        this.f19046c = i5;
        if (i5 > 7) {
            this.f19045b = i4 + 1;
            this.f19046c = i5 - 8;
        }
        g();
    }

    public void b(byte[] bArr, int i2, int i3) {
        a.b(this.f19046c == 0);
        System.arraycopy(this.f19044a, this.f19045b, bArr, i2, i3);
        this.f19045b += i3;
        g();
    }

    public int c() {
        a.b(this.f19046c == 0);
        return this.f19045b;
    }

    public int c(int i2) {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        this.f19046c += i2;
        int i4 = 0;
        while (true) {
            i3 = this.f19046c;
            if (i3 <= 8) {
                break;
            }
            int i5 = i3 - 8;
            this.f19046c = i5;
            byte[] bArr = this.f19044a;
            int i6 = this.f19045b;
            this.f19045b = i6 + 1;
            i4 |= (bArr[i6] & 255) << i5;
        }
        byte[] bArr2 = this.f19044a;
        int i7 = this.f19045b;
        byte b2 = bArr2[i7];
        if (i3 == 8) {
            this.f19046c = 0;
            this.f19045b = i7 + 1;
        }
        g();
        return (((b2 & 255) >> (8 - i3)) | i4) & ((-1) >>> (32 - i2));
    }

    public void d() {
        int i2 = this.f19046c + 1;
        this.f19046c = i2;
        if (i2 == 8) {
            this.f19046c = 0;
            this.f19045b++;
        }
        g();
    }

    public void d(int i2) {
        a.b(this.f19046c == 0);
        this.f19045b += i2;
        g();
    }

    public boolean e() {
        boolean z = (this.f19044a[this.f19045b] & (128 >> this.f19046c)) != 0;
        d();
        return z;
    }

    public void f() {
        if (this.f19046c == 0) {
            return;
        }
        this.f19046c = 0;
        this.f19045b++;
        g();
    }
}
