package com.tencent.bugly.proguard;

/* loaded from: classes4.dex */
public final class ma extends AbstractC0909m implements Cloneable {

    /* renamed from: a */
    static byte[] f25093a;

    /* renamed from: b */
    public byte f25094b;

    /* renamed from: c */
    public String f25095c;

    /* renamed from: d */
    public byte[] f25096d;

    public ma() {
        this.f25094b = (byte) 0;
        this.f25095c = "";
        this.f25096d = null;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0908l c0908l) {
        c0908l.a(this.f25094b, 0);
        c0908l.a(this.f25095c, 1);
        byte[] bArr = this.f25096d;
        if (bArr != null) {
            c0908l.a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(StringBuilder sb, int i2) {
    }

    public ma(byte b2, String str, byte[] bArr) {
        this.f25094b = (byte) 0;
        this.f25095c = "";
        this.f25096d = null;
        this.f25094b = b2;
        this.f25095c = str;
        this.f25096d = bArr;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        this.f25094b = c0907k.a(this.f25094b, 0, true);
        this.f25095c = c0907k.a(1, true);
        if (f25093a == null) {
            f25093a = new byte[]{0};
        }
        this.f25096d = c0907k.a(f25093a, 2, false);
    }
}
