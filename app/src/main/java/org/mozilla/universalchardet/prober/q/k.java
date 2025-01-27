package org.mozilla.universalchardet.prober.q;

/* loaded from: classes5.dex */
public class k {

    /* renamed from: a */
    public static final int f35523a = 3;

    /* renamed from: b */
    public static final int f35524b = 2;

    /* renamed from: c */
    public static final int f35525c = 1;

    /* renamed from: d */
    public static final int f35526d = 7;

    /* renamed from: e */
    public static final int f35527e = 3;

    /* renamed from: f */
    public static final int f35528f = 1;

    /* renamed from: g */
    public static final int f35529g = 2;

    /* renamed from: h */
    public static final int f35530h = 3;

    /* renamed from: i */
    public static final int f35531i = 4;

    /* renamed from: j */
    public static final int f35532j = 15;
    public static final int k = 255;
    public static final int l = 65535;
    private int m;
    private int n;
    private int o;
    private int p;
    private int[] q;

    public k(int i2, int i3, int i4, int i5, int[] iArr) {
        this.m = i2;
        this.n = i3;
        this.o = i4;
        this.p = i5;
        this.q = iArr;
    }

    public static int a(int i2, int i3) {
        return i2 | (i3 << 16);
    }

    public static int b(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return c(i2 | (i3 << 4), (i5 << 4) | i4, (i7 << 4) | i6, (i9 << 4) | i8);
    }

    public static int c(int i2, int i3, int i4, int i5) {
        return a(i2 | (i3 << 8), (i5 << 8) | i4);
    }

    public int d(int i2) {
        return (this.q[i2 >> this.m] >> ((i2 & this.n) << this.o)) & this.p;
    }
}
