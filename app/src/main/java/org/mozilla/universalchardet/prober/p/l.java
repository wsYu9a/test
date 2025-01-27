package org.mozilla.universalchardet.prober.p;

/* loaded from: classes5.dex */
public abstract class l {

    /* renamed from: a */
    protected short[] f35493a;

    /* renamed from: b */
    protected byte[] f35494b;

    /* renamed from: c */
    protected float f35495c;

    /* renamed from: d */
    protected boolean f35496d;

    /* renamed from: e */
    protected String f35497e;

    public l(short[] sArr, byte[] bArr, float f2, boolean z, String str) {
        this.f35493a = sArr;
        this.f35494b = bArr;
        this.f35495c = f2;
        this.f35496d = z;
        this.f35497e = str;
    }

    public String a() {
        return this.f35497e;
    }

    public boolean b() {
        return this.f35496d;
    }

    public short c(byte b2) {
        return this.f35493a[b2 & 255];
    }

    public byte d(int i2) {
        return this.f35494b[i2];
    }

    public float e() {
        return this.f35495c;
    }
}
