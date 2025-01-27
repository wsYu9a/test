package com.umeng.analytics.pro;

/* loaded from: classes4.dex */
public abstract class du {
    public abstract int a(byte[] bArr, int i10, int i11) throws dv;

    public void a(int i10) {
    }

    public abstract boolean a();

    public abstract void b() throws dv;

    public void b(byte[] bArr) throws dv {
        b(bArr, 0, bArr.length);
    }

    public abstract void b(byte[] bArr, int i10, int i11) throws dv;

    public abstract void c();

    public void d() throws dv {
    }

    public byte[] f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return -1;
    }

    public boolean i() {
        return a();
    }

    public int d(byte[] bArr, int i10, int i11) throws dv {
        int i12 = 0;
        while (i12 < i11) {
            int a10 = a(bArr, i10 + i12, i11 - i12);
            if (a10 <= 0) {
                throw new dv("Cannot read. Remote side has closed. Tried to read " + i11 + " bytes, but only got " + i12 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i12 += a10;
        }
        return i12;
    }
}
