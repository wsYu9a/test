package org.mozilla.universalchardet.prober.o;

/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a */
    public static final float f35464a = 0.01f;

    /* renamed from: b */
    public static final float f35465b = 0.99f;

    /* renamed from: c */
    public static final int f35466c = 1024;

    /* renamed from: d */
    public static final int f35467d = 4;

    /* renamed from: e */
    private int f35468e;

    /* renamed from: f */
    private int f35469f;

    /* renamed from: g */
    protected int[] f35470g;

    /* renamed from: h */
    protected float f35471h;

    /* renamed from: i */
    protected boolean f35472i;

    public b() {
        f();
    }

    public float a() {
        int i2;
        int i3 = this.f35469f;
        if (i3 <= 0 || (i2 = this.f35468e) <= 4) {
            return 0.01f;
        }
        if (i3 != i2) {
            float f2 = (i2 / (i3 - i2)) * this.f35471h;
            if (f2 < 0.99f) {
                return f2;
            }
        }
        return 0.99f;
    }

    protected abstract int b(byte[] bArr, int i2);

    public boolean c() {
        return this.f35469f > 1024;
    }

    public void d(byte[] bArr, int i2, int i3) {
    }

    public void e(byte[] bArr, int i2, int i3) {
        int b2 = i3 == 2 ? b(bArr, i2) : -1;
        if (b2 >= 0) {
            this.f35469f++;
            int[] iArr = this.f35470g;
            if (b2 >= iArr.length || 512 <= iArr[b2]) {
                return;
            }
            this.f35468e++;
        }
    }

    public void f() {
        this.f35472i = false;
        this.f35469f = 0;
        this.f35468e = 0;
    }

    public void g() {
    }
}
