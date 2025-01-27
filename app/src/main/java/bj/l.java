package bj;

/* loaded from: classes4.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public short[] f1673a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f1674b;

    /* renamed from: c, reason: collision with root package name */
    public float f1675c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1676d;

    /* renamed from: e, reason: collision with root package name */
    public String f1677e;

    public l(short[] sArr, byte[] bArr, float f10, boolean z10, String str) {
        this.f1673a = (short[]) sArr.clone();
        this.f1674b = (byte[]) bArr.clone();
        this.f1675c = f10;
        this.f1676d = z10;
        this.f1677e = str;
    }

    public String a() {
        return this.f1677e;
    }

    public boolean b() {
        return this.f1676d;
    }

    public short c(byte b10) {
        return this.f1673a[b10 & 255];
    }

    public byte d(int i10) {
        return this.f1674b[i10];
    }

    public float e() {
        return this.f1675c;
    }
}
