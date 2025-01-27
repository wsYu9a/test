package com.google.zxing;

/* loaded from: classes.dex */
public final class h extends e {

    /* renamed from: c */
    private static final int f8432c = 2;

    /* renamed from: d */
    private final byte[] f8433d;

    /* renamed from: e */
    private final int f8434e;

    /* renamed from: f */
    private final int f8435f;

    /* renamed from: g */
    private final int f8436g;

    /* renamed from: h */
    private final int f8437h;

    public h(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        super(i6, i7);
        if (i4 + i6 > i2 || i5 + i7 > i3) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f8433d = bArr;
        this.f8434e = i2;
        this.f8435f = i3;
        this.f8436g = i4;
        this.f8437h = i5;
        if (z) {
            n(i6, i7);
        }
    }

    private void n(int i2, int i3) {
        byte[] bArr = this.f8433d;
        int i4 = (this.f8437h * this.f8434e) + this.f8436g;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = (i2 / 2) + i4;
            int i7 = (i4 + i2) - 1;
            int i8 = i4;
            while (i8 < i6) {
                byte b2 = bArr[i8];
                bArr[i8] = bArr[i7];
                bArr[i7] = b2;
                i8++;
                i7--;
            }
            i5++;
            i4 += this.f8434e;
        }
    }

    @Override // com.google.zxing.e
    public e a(int i2, int i3, int i4, int i5) {
        return new h(this.f8433d, this.f8434e, this.f8435f, this.f8436g + i2, this.f8437h + i3, i4, i5, false);
    }

    @Override // com.google.zxing.e
    public byte[] c() {
        int e2 = e();
        int b2 = b();
        int i2 = this.f8434e;
        if (e2 == i2 && b2 == this.f8435f) {
            return this.f8433d;
        }
        int i3 = e2 * b2;
        byte[] bArr = new byte[i3];
        int i4 = (this.f8437h * i2) + this.f8436g;
        if (e2 == i2) {
            System.arraycopy(this.f8433d, i4, bArr, 0, i3);
            return bArr;
        }
        for (int i5 = 0; i5 < b2; i5++) {
            System.arraycopy(this.f8433d, i4, bArr, i5 * e2, e2);
            i4 += this.f8434e;
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
        System.arraycopy(this.f8433d, ((i2 + this.f8437h) * this.f8434e) + this.f8436g, bArr, 0, e2);
        return bArr;
    }

    @Override // com.google.zxing.e
    public boolean g() {
        return true;
    }

    public int k() {
        return b() / 2;
    }

    public int l() {
        return e() / 2;
    }

    public int[] m() {
        int e2 = e() / 2;
        int b2 = b() / 2;
        int[] iArr = new int[e2 * b2];
        byte[] bArr = this.f8433d;
        int i2 = (this.f8437h * this.f8434e) + this.f8436g;
        for (int i3 = 0; i3 < b2; i3++) {
            int i4 = i3 * e2;
            for (int i5 = 0; i5 < e2; i5++) {
                iArr[i4 + i5] = ((bArr[(i5 << 1) + i2] & 255) * 65793) | (-16777216);
            }
            i2 += this.f8434e << 1;
        }
        return iArr;
    }
}
