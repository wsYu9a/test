package com.tencent.bugly.proguard;

/* loaded from: classes4.dex */
public final class ma extends AbstractC0868m implements Cloneable {

    /* renamed from: a */
    static byte[] f22765a;

    /* renamed from: b */
    public byte f22766b;

    /* renamed from: c */
    public String f22767c;

    /* renamed from: d */
    public byte[] f22768d;

    public ma() {
        this.f22766b = (byte) 0;
        this.f22767c = "";
        this.f22768d = null;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0867l c0867l) {
        c0867l.a(this.f22766b, 0);
        c0867l.a(this.f22767c, 1);
        byte[] bArr = this.f22768d;
        if (bArr != null) {
            c0867l.a(bArr, 2);
        }
    }

    public ma(byte b10, String str, byte[] bArr) {
        this.f22766b = b10;
        this.f22767c = str;
        this.f22768d = bArr;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        this.f22766b = c0866k.a(this.f22766b, 0, true);
        this.f22767c = c0866k.a(1, true);
        if (f22765a == null) {
            f22765a = new byte[]{0};
        }
        this.f22768d = c0866k.a(f22765a, 2, false);
    }
}
