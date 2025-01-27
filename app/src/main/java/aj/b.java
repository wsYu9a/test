package aj;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: e, reason: collision with root package name */
    public static final float f182e = 0.01f;

    /* renamed from: f, reason: collision with root package name */
    public static final float f183f = 0.99f;

    /* renamed from: g, reason: collision with root package name */
    public static final int f184g = 1024;

    /* renamed from: h, reason: collision with root package name */
    public static final int f185h = 4;

    /* renamed from: a, reason: collision with root package name */
    public int f186a;

    /* renamed from: b, reason: collision with root package name */
    public int f187b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f188c;

    /* renamed from: d, reason: collision with root package name */
    public float f189d;

    public b() {
        f();
    }

    public float a() {
        int i10;
        int i11 = this.f187b;
        if (i11 <= 0 || (i10 = this.f186a) <= 4) {
            return 0.01f;
        }
        if (i11 != i10) {
            float f10 = i10 / ((i11 - i10) * this.f189d);
            if (f10 < 0.99f) {
                return f10;
            }
        }
        return 0.99f;
    }

    public abstract int b(byte[] bArr, int i10);

    public boolean c() {
        return this.f187b > 1024;
    }

    public void e(byte[] bArr, int i10, int i11) {
        int b10 = i11 == 2 ? b(bArr, i10) : -1;
        if (b10 >= 0) {
            this.f187b++;
            int[] iArr = this.f188c;
            if (b10 >= iArr.length || 512 <= iArr[b10]) {
                return;
            }
            this.f186a++;
        }
    }

    public final void f() {
        this.f187b = 0;
        this.f186a = 0;
    }

    public void g() {
    }

    public void d(byte[] bArr, int i10, int i11) {
    }
}
