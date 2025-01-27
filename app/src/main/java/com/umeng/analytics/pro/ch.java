package com.umeng.analytics.pro;

/* loaded from: classes4.dex */
public final class ch extends ci {

    /* renamed from: a */
    private byte[] f25820a;

    /* renamed from: b */
    private int f25821b;

    /* renamed from: c */
    private int f25822c;

    public ch() {
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.ci
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.ci
    public void b() throws cj {
    }

    @Override // com.umeng.analytics.pro.ci
    public void b(byte[] bArr, int i2, int i3) throws cj {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.ci
    public void c() {
    }

    public void c(byte[] bArr, int i2, int i3) {
        this.f25820a = bArr;
        this.f25821b = i2;
        this.f25822c = i2 + i3;
    }

    public void e() {
        this.f25820a = null;
    }

    @Override // com.umeng.analytics.pro.ci
    public byte[] f() {
        return this.f25820a;
    }

    @Override // com.umeng.analytics.pro.ci
    public int g() {
        return this.f25821b;
    }

    @Override // com.umeng.analytics.pro.ci
    public int h() {
        return this.f25822c - this.f25821b;
    }

    public ch(byte[] bArr) {
        a(bArr);
    }

    @Override // com.umeng.analytics.pro.ci
    public int a(byte[] bArr, int i2, int i3) throws cj {
        int h2 = h();
        if (i3 > h2) {
            i3 = h2;
        }
        if (i3 > 0) {
            System.arraycopy(this.f25820a, this.f25821b, bArr, i2, i3);
            a(i3);
        }
        return i3;
    }

    public ch(byte[] bArr, int i2, int i3) {
        c(bArr, i2, i3);
    }

    @Override // com.umeng.analytics.pro.ci
    public void a(int i2) {
        this.f25821b += i2;
    }
}
