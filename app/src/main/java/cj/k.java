package cj;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: f, reason: collision with root package name */
    public static final int f2071f = 3;

    /* renamed from: g, reason: collision with root package name */
    public static final int f2072g = 2;

    /* renamed from: h, reason: collision with root package name */
    public static final int f2073h = 1;

    /* renamed from: i, reason: collision with root package name */
    public static final int f2074i = 7;

    /* renamed from: j, reason: collision with root package name */
    public static final int f2075j = 3;

    /* renamed from: k, reason: collision with root package name */
    public static final int f2076k = 1;

    /* renamed from: l, reason: collision with root package name */
    public static final int f2077l = 2;

    /* renamed from: m, reason: collision with root package name */
    public static final int f2078m = 3;

    /* renamed from: n, reason: collision with root package name */
    public static final int f2079n = 4;

    /* renamed from: o, reason: collision with root package name */
    public static final int f2080o = 15;

    /* renamed from: p, reason: collision with root package name */
    public static final int f2081p = 255;

    /* renamed from: q, reason: collision with root package name */
    public static final int f2082q = 65535;

    /* renamed from: a, reason: collision with root package name */
    public int f2083a;

    /* renamed from: b, reason: collision with root package name */
    public int f2084b;

    /* renamed from: c, reason: collision with root package name */
    public int f2085c;

    /* renamed from: d, reason: collision with root package name */
    public int f2086d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f2087e;

    public k(int i10, int i11, int i12, int i13, int[] iArr) {
        this.f2083a = i10;
        this.f2084b = i11;
        this.f2085c = i12;
        this.f2086d = i13;
        this.f2087e = (int[]) iArr.clone();
    }

    public static int a(int i10, int i11) {
        return i10 | (i11 << 16);
    }

    public static int b(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        return c(i10 | (i11 << 4), (i13 << 4) | i12, (i15 << 4) | i14, (i17 << 4) | i16);
    }

    public static int c(int i10, int i11, int i12, int i13) {
        return a(i10 | (i11 << 8), (i13 << 8) | i12);
    }

    public int d(int i10) {
        return (this.f2087e[i10 >> this.f2083a] >> ((i10 & this.f2084b) << this.f2085c)) & this.f2086d;
    }
}
