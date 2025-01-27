package org.mozilla.universalchardet.prober.q;

/* loaded from: classes5.dex */
public abstract class m {

    /* renamed from: a */
    public static final int f35535a = 0;

    /* renamed from: b */
    public static final int f35536b = 1;

    /* renamed from: c */
    public static final int f35537c = 2;

    /* renamed from: d */
    protected k f35538d;

    /* renamed from: e */
    protected int f35539e;

    /* renamed from: f */
    protected k f35540f;

    /* renamed from: g */
    protected int[] f35541g;

    /* renamed from: h */
    protected String f35542h;

    public m(k kVar, int i2, k kVar2, int[] iArr, String str) {
        this.f35538d = kVar;
        this.f35539e = i2;
        this.f35540f = kVar2;
        this.f35541g = iArr;
        this.f35542h = str;
    }

    public int a(int i2) {
        return this.f35541g[i2];
    }

    public int b(byte b2) {
        return this.f35538d.d(b2 & 255);
    }

    public String c() {
        return this.f35542h;
    }

    public int d(int i2, int i3) {
        return this.f35540f.d((i3 * this.f35539e) + i2);
    }
}
