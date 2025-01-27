package com.vivo.google.android.exoplayer3;

/* loaded from: classes4.dex */
public final class m6 {

    /* renamed from: a */
    public byte[] f27770a;

    /* renamed from: b */
    public int f27771b;

    /* renamed from: c */
    public int f27772c;

    /* renamed from: d */
    public int f27773d;

    public m6() {
    }

    public m6(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public m6(byte[] bArr, int i2) {
        this.f27770a = bArr;
        this.f27773d = i2;
    }

    public int a(int i2) {
        int i3;
        this.f27772c += i2;
        int i4 = 0;
        while (true) {
            i3 = this.f27772c;
            if (i3 <= 8) {
                break;
            }
            int i5 = i3 - 8;
            this.f27772c = i5;
            byte[] bArr = this.f27770a;
            int i6 = this.f27771b;
            this.f27771b = i6 + 1;
            i4 |= (bArr[i6] & 255) << i5;
        }
        byte[] bArr2 = this.f27770a;
        int i7 = this.f27771b;
        int i8 = ((-1) >>> (32 - i2)) & (i4 | ((bArr2[i7] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f27772c = 0;
            this.f27771b = i7 + 1;
        }
        a();
        return i8;
    }

    public final void a() {
        int i2;
        int i3 = this.f27771b;
        g1.b(i3 >= 0 && (i3 < (i2 = this.f27773d) || (i3 == i2 && this.f27772c == 0)));
    }

    public void a(byte[] bArr, int i2, int i3) {
        g1.b(this.f27772c == 0);
        System.arraycopy(this.f27770a, this.f27771b, bArr, i2, i3);
        this.f27771b += i3;
        a();
    }

    public int b() {
        return ((this.f27773d - this.f27771b) * 8) - this.f27772c;
    }

    public void b(int i2) {
        int i3 = i2 / 8;
        this.f27771b = i3;
        this.f27772c = i2 - (i3 * 8);
        a();
    }

    public void c() {
        if (this.f27772c == 0) {
            return;
        }
        this.f27772c = 0;
        this.f27771b++;
        a();
    }

    public void c(int i2) {
        int i3 = i2 / 8;
        int i4 = this.f27771b + i3;
        this.f27771b = i4;
        int i5 = this.f27772c + (i2 - (i3 * 8));
        this.f27772c = i5;
        if (i5 > 7) {
            this.f27771b = i4 + 1;
            this.f27772c = i5 - 8;
        }
        a();
    }

    public boolean d() {
        byte[] bArr = this.f27770a;
        int i2 = this.f27771b;
        byte b2 = bArr[i2];
        int i3 = this.f27772c;
        boolean z = (b2 & (128 >> i3)) != 0;
        int i4 = i3 + 1;
        this.f27772c = i4;
        if (i4 == 8) {
            this.f27772c = 0;
            this.f27771b = i2 + 1;
        }
        a();
        return z;
    }
}
