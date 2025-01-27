package com.opos.exoplayer.core.c.e;

/* loaded from: classes4.dex */
final class j {

    /* renamed from: a */
    private final byte[] f18067a;

    /* renamed from: b */
    private final int f18068b;

    /* renamed from: c */
    private int f18069c;

    /* renamed from: d */
    private int f18070d;

    public j(byte[] bArr) {
        this.f18067a = bArr;
        this.f18068b = bArr.length;
    }

    private void c() {
        int i2;
        int i3 = this.f18069c;
        com.opos.exoplayer.core.i.a.b(i3 >= 0 && (i3 < (i2 = this.f18068b) || (i3 == i2 && this.f18070d == 0)));
    }

    public int a(int i2) {
        int i3 = this.f18069c;
        int min = Math.min(i2, 8 - this.f18070d);
        int i4 = i3 + 1;
        int i5 = ((this.f18067a[i3] & 255) >> this.f18070d) & (255 >> (8 - min));
        while (min < i2) {
            i5 |= (this.f18067a[i4] & 255) << min;
            min += 8;
            i4++;
        }
        b(i2);
        return ((-1) >>> (32 - i2)) & i5;
    }

    public boolean a() {
        boolean z = (((this.f18067a[this.f18069c] & 255) >> this.f18070d) & 1) == 1;
        b(1);
        return z;
    }

    public int b() {
        return (this.f18069c * 8) + this.f18070d;
    }

    public void b(int i2) {
        int i3 = i2 / 8;
        int i4 = this.f18069c + i3;
        this.f18069c = i4;
        int i5 = (i2 - (i3 * 8)) + this.f18070d;
        this.f18070d = i5;
        if (i5 > 7) {
            this.f18069c = i4 + 1;
            this.f18070d = i5 - 8;
        }
        c();
    }
}
