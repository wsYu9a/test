package com.umeng.analytics.pro;

/* loaded from: classes4.dex */
public final class dt extends du {

    /* renamed from: a */
    private byte[] f23871a;

    /* renamed from: b */
    private int f23872b;

    /* renamed from: c */
    private int f23873c;

    public dt() {
    }

    @Override // com.umeng.analytics.pro.du
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.du
    public void b() throws dv {
    }

    @Override // com.umeng.analytics.pro.du
    public void c() {
    }

    public void e() {
        this.f23871a = null;
    }

    @Override // com.umeng.analytics.pro.du
    public byte[] f() {
        return this.f23871a;
    }

    @Override // com.umeng.analytics.pro.du
    public int g() {
        return this.f23872b;
    }

    @Override // com.umeng.analytics.pro.du
    public int h() {
        return this.f23873c - this.f23872b;
    }

    public dt(byte[] bArr) {
        a(bArr);
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.du
    public void b(byte[] bArr, int i10, int i11) throws dv {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    public void c(byte[] bArr, int i10, int i11) {
        this.f23871a = bArr;
        this.f23872b = i10;
        this.f23873c = i10 + i11;
    }

    @Override // com.umeng.analytics.pro.du
    public int a(byte[] bArr, int i10, int i11) throws dv {
        int h10 = h();
        if (i11 > h10) {
            i11 = h10;
        }
        if (i11 > 0) {
            System.arraycopy(this.f23871a, this.f23872b, bArr, i10, i11);
            a(i11);
        }
        return i11;
    }

    public dt(byte[] bArr, int i10, int i11) {
        c(bArr, i10, i11);
    }

    @Override // com.umeng.analytics.pro.du
    public void a(int i10) {
        this.f23872b += i10;
    }
}
