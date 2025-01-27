package t5;

/* loaded from: classes2.dex */
public final class d extends e {

    /* renamed from: c */
    public final e f30703c;

    public d(e eVar) {
        super(eVar.e(), eVar.b());
        this.f30703c = eVar;
    }

    @Override // t5.e
    public e a(int i10, int i11, int i12, int i13) {
        return new d(this.f30703c.a(i10, i11, i12, i13));
    }

    @Override // t5.e
    public byte[] c() {
        byte[] c10 = this.f30703c.c();
        int e10 = e() * b();
        byte[] bArr = new byte[e10];
        for (int i10 = 0; i10 < e10; i10++) {
            bArr[i10] = (byte) (255 - (c10[i10] & 255));
        }
        return bArr;
    }

    @Override // t5.e
    public byte[] d(int i10, byte[] bArr) {
        byte[] d10 = this.f30703c.d(i10, bArr);
        int e10 = e();
        for (int i11 = 0; i11 < e10; i11++) {
            d10[i11] = (byte) (255 - (d10[i11] & 255));
        }
        return d10;
    }

    @Override // t5.e
    public e f() {
        return this.f30703c;
    }

    @Override // t5.e
    public boolean g() {
        return this.f30703c.g();
    }

    @Override // t5.e
    public boolean h() {
        return this.f30703c.h();
    }

    @Override // t5.e
    public e i() {
        return new d(this.f30703c.i());
    }

    @Override // t5.e
    public e j() {
        return new d(this.f30703c.j());
    }
}
