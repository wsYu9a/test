package com.vivo.google.android.exoplayer3;

/* loaded from: classes4.dex */
public final class x1 {

    /* renamed from: a */
    public final byte[] f28258a;

    /* renamed from: b */
    public final int f28259b;

    /* renamed from: c */
    public int f28260c;

    /* renamed from: d */
    public int f28261d;

    public x1(byte[] bArr) {
        this.f28258a = bArr;
        this.f28259b = bArr.length;
    }

    public int a(int i2) {
        int i3 = this.f28260c;
        int min = Math.min(i2, 8 - this.f28261d);
        int i4 = i3 + 1;
        int i5 = ((this.f28258a[i3] & 255) >> this.f28261d) & (255 >> (8 - min));
        while (min < i2) {
            i5 |= (this.f28258a[i4] & 255) << min;
            min += 8;
            i4++;
        }
        int i6 = i5 & ((-1) >>> (32 - i2));
        b(i2);
        return i6;
    }

    public boolean a() {
        boolean z = (((this.f28258a[this.f28260c] & 255) >> this.f28261d) & 1) == 1;
        b(1);
        return z;
    }

    public void b(int i2) {
        int i3;
        int i4 = i2 / 8;
        int i5 = this.f28260c + i4;
        this.f28260c = i5;
        int i6 = this.f28261d + (i2 - (i4 * 8));
        this.f28261d = i6;
        boolean z = true;
        if (i6 > 7) {
            this.f28260c = i5 + 1;
            this.f28261d = i6 - 8;
        }
        int i7 = this.f28260c;
        if (i7 < 0 || (i7 >= (i3 = this.f28259b) && (i7 != i3 || this.f28261d != 0))) {
            z = false;
        }
        g1.b(z);
    }
}
