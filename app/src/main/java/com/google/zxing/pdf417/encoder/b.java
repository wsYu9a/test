package com.google.zxing.pdf417.encoder;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f8717a;

    /* renamed from: b, reason: collision with root package name */
    private int f8718b = 0;

    b(int i2) {
        this.f8717a = new byte[i2];
    }

    private void d(int i2, boolean z) {
        this.f8717a[i2] = z ? (byte) 1 : (byte) 0;
    }

    void a(boolean z, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f8718b;
            this.f8718b = i4 + 1;
            d(i4, z);
        }
    }

    byte[] b(int i2) {
        int length = this.f8717a.length * i2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i3] = this.f8717a[i3 / i2];
        }
        return bArr;
    }

    void c(int i2, byte b2) {
        this.f8717a[i2] = b2;
    }
}
