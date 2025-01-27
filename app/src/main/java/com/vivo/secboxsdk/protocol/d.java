package com.vivo.secboxsdk.protocol;

import com.vivo.secboxsdk.SecBoxCipherException;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    private int f31141a;

    /* renamed from: b */
    private int f31142b;

    /* renamed from: c */
    private byte[] f31143c;

    /* renamed from: d */
    private String f31144d;

    /* renamed from: e */
    private byte[] f31145e;

    /* renamed from: f */
    private byte[] f31146f;

    /* renamed from: g */
    private byte[] f31147g;

    /* renamed from: h */
    private byte[] f31148h;

    /* renamed from: i */
    private byte[] f31149i;

    public d() {
    }

    public final byte[] a() throws SecBoxCipherException {
        b bVar = new b((byte) 0);
        bVar.b(this.f31141a);
        bVar.a(this.f31142b);
        bVar.c(this.f31143c);
        bVar.a(this.f31144d);
        bVar.a(this.f31144d);
        bVar.g(this.f31145e);
        bVar.h(this.f31146f);
        byte[] bArr = this.f31147g;
        if (bArr != null) {
            bVar.d(bArr);
        }
        byte[] bArr2 = this.f31148h;
        if (bArr2 != null) {
            bVar.e(bArr2);
        }
        byte[] bArr3 = this.f31149i;
        if (bArr3 != null) {
            bVar.f(bArr3);
        }
        bVar.g();
        return bVar.c();
    }

    public d(String str, int i2, int i3, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f31141a = i2;
        this.f31142b = i3;
        this.f31143c = bArr;
        this.f31144d = str;
        this.f31145e = bArr2;
        this.f31146f = bArr3;
    }
}
