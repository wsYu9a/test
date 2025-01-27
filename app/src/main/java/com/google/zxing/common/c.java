package com.google.zxing.common;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f8292a;

    /* renamed from: b, reason: collision with root package name */
    private int f8293b;

    /* renamed from: c, reason: collision with root package name */
    private int f8294c;

    public c(byte[] bArr) {
        this.f8292a = bArr;
    }

    public int a() {
        return ((this.f8292a.length - this.f8293b) * 8) - this.f8294c;
    }

    public int b() {
        return this.f8294c;
    }

    public int c() {
        return this.f8293b;
    }

    public int d(int i2) {
        if (i2 <= 0 || i2 > 32 || i2 > a()) {
            throw new IllegalArgumentException(String.valueOf(i2));
        }
        int i3 = this.f8294c;
        int i4 = 0;
        if (i3 > 0) {
            int i5 = 8 - i3;
            int i6 = i2 < i5 ? i2 : i5;
            int i7 = i5 - i6;
            byte[] bArr = this.f8292a;
            int i8 = this.f8293b;
            int i9 = (((255 >> (8 - i6)) << i7) & bArr[i8]) >> i7;
            i2 -= i6;
            int i10 = i3 + i6;
            this.f8294c = i10;
            if (i10 == 8) {
                this.f8294c = 0;
                this.f8293b = i8 + 1;
            }
            i4 = i9;
        }
        if (i2 <= 0) {
            return i4;
        }
        while (i2 >= 8) {
            int i11 = i4 << 8;
            byte[] bArr2 = this.f8292a;
            int i12 = this.f8293b;
            i4 = (bArr2[i12] & 255) | i11;
            this.f8293b = i12 + 1;
            i2 -= 8;
        }
        if (i2 <= 0) {
            return i4;
        }
        int i13 = 8 - i2;
        int i14 = (i4 << i2) | ((((255 >> i13) << i13) & this.f8292a[this.f8293b]) >> i13);
        this.f8294c += i2;
        return i14;
    }
}
