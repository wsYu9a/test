package com.google.zxing;

/* loaded from: classes.dex */
public final class i extends e {

    /* renamed from: c */
    private final byte[] f8438c;

    /* renamed from: d */
    private final int f8439d;

    /* renamed from: e */
    private final int f8440e;

    /* renamed from: f */
    private final int f8441f;

    /* renamed from: g */
    private final int f8442g;

    public i(int i2, int i3, int[] iArr) {
        super(i2, i3);
        this.f8439d = i2;
        this.f8440e = i3;
        this.f8441f = 0;
        this.f8442g = 0;
        int i4 = i2 * i3;
        this.f8438c = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = iArr[i5];
            this.f8438c[i5] = (byte) (((((i6 >> 16) & 255) + ((i6 >> 7) & 510)) + (i6 & 255)) / 4);
        }
    }

    @Override // com.google.zxing.e
    public e a(int i2, int i3, int i4, int i5) {
        return new i(this.f8438c, this.f8439d, this.f8440e, this.f8441f + i2, this.f8442g + i3, i4, i5);
    }

    @Override // com.google.zxing.e
    public byte[] c() {
        int e2 = e();
        int b2 = b();
        int i2 = this.f8439d;
        if (e2 == i2 && b2 == this.f8440e) {
            return this.f8438c;
        }
        int i3 = e2 * b2;
        byte[] bArr = new byte[i3];
        int i4 = (this.f8442g * i2) + this.f8441f;
        if (e2 == i2) {
            System.arraycopy(this.f8438c, i4, bArr, 0, i3);
            return bArr;
        }
        for (int i5 = 0; i5 < b2; i5++) {
            System.arraycopy(this.f8438c, i4, bArr, i5 * e2, e2);
            i4 += this.f8439d;
        }
        return bArr;
    }

    @Override // com.google.zxing.e
    public byte[] d(int i2, byte[] bArr) {
        if (i2 < 0 || i2 >= b()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i2);
        }
        int e2 = e();
        if (bArr == null || bArr.length < e2) {
            bArr = new byte[e2];
        }
        System.arraycopy(this.f8438c, ((i2 + this.f8442g) * this.f8439d) + this.f8441f, bArr, 0, e2);
        return bArr;
    }

    @Override // com.google.zxing.e
    public boolean g() {
        return true;
    }

    private i(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i6, i7);
        if (i6 + i4 <= i2 && i7 + i5 <= i3) {
            this.f8438c = bArr;
            this.f8439d = i2;
            this.f8440e = i3;
            this.f8441f = i4;
            this.f8442g = i5;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
}
