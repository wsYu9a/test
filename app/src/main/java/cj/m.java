package cj;

/* loaded from: classes4.dex */
public abstract class m {

    /* renamed from: f */
    public static final int f2092f = 0;

    /* renamed from: g */
    public static final int f2093g = 1;

    /* renamed from: h */
    public static final int f2094h = 2;

    /* renamed from: a */
    public k f2095a;

    /* renamed from: b */
    public int f2096b;

    /* renamed from: c */
    public k f2097c;

    /* renamed from: d */
    public int[] f2098d;

    /* renamed from: e */
    public String f2099e;

    public m(k kVar, int i10, k kVar2, int[] iArr, String str) {
        this.f2095a = kVar;
        this.f2096b = i10;
        this.f2097c = kVar2;
        this.f2098d = (int[]) iArr.clone();
        this.f2099e = str;
    }

    public int a(int i10) {
        return this.f2098d[i10];
    }

    public int b(byte b10) {
        return this.f2095a.d(b10 & 255);
    }

    public String c() {
        return this.f2099e;
    }

    public int d(int i10, int i11) {
        return this.f2097c.d((i11 * this.f2096b) + i10);
    }
}
