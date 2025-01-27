package com.google.zxing;

/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: c */
    private final e f8359c;

    public d(e eVar) {
        super(eVar.e(), eVar.b());
        this.f8359c = eVar;
    }

    @Override // com.google.zxing.e
    public e a(int i2, int i3, int i4, int i5) {
        return new d(this.f8359c.a(i2, i3, i4, i5));
    }

    @Override // com.google.zxing.e
    public byte[] c() {
        byte[] c2 = this.f8359c.c();
        int e2 = e() * b();
        byte[] bArr = new byte[e2];
        for (int i2 = 0; i2 < e2; i2++) {
            bArr[i2] = (byte) (255 - (c2[i2] & 255));
        }
        return bArr;
    }

    @Override // com.google.zxing.e
    public byte[] d(int i2, byte[] bArr) {
        byte[] d2 = this.f8359c.d(i2, bArr);
        int e2 = e();
        for (int i3 = 0; i3 < e2; i3++) {
            d2[i3] = (byte) (255 - (d2[i3] & 255));
        }
        return d2;
    }

    @Override // com.google.zxing.e
    public e f() {
        return this.f8359c;
    }

    @Override // com.google.zxing.e
    public boolean g() {
        return this.f8359c.g();
    }

    @Override // com.google.zxing.e
    public boolean h() {
        return this.f8359c.h();
    }

    @Override // com.google.zxing.e
    public e i() {
        return new d(this.f8359c.i());
    }

    @Override // com.google.zxing.e
    public e j() {
        return new d(this.f8359c.j());
    }
}
