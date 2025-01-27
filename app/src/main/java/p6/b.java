package p6;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: f */
    public static final b f29846f = new b(n6.a.f28782a, 3);

    /* renamed from: a */
    public final int[] f29847a;

    /* renamed from: b */
    public final int[] f29848b;

    /* renamed from: c */
    public final c f29849c;

    /* renamed from: d */
    public final c f29850d;

    /* renamed from: e */
    public final int f29851e;

    public b(int i10, int i11) {
        this.f29851e = i10;
        this.f29847a = new int[i10];
        this.f29848b = new int[i10];
        int i12 = 1;
        for (int i13 = 0; i13 < i10; i13++) {
            this.f29847a[i13] = i12;
            i12 = (i12 * i11) % i10;
        }
        for (int i14 = 0; i14 < i10 - 1; i14++) {
            this.f29848b[this.f29847a[i14]] = i14;
        }
        this.f29849c = new c(this, new int[]{0});
        this.f29850d = new c(this, new int[]{1});
    }

    public int a(int i10, int i11) {
        return (i10 + i11) % this.f29851e;
    }

    public c b(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f29849c;
        }
        int[] iArr = new int[i10 + 1];
        iArr[0] = i11;
        return new c(this, iArr);
    }

    public int c(int i10) {
        return this.f29847a[i10];
    }

    public c d() {
        return this.f29850d;
    }

    public int e() {
        return this.f29851e;
    }

    public c f() {
        return this.f29849c;
    }

    public int g(int i10) {
        if (i10 != 0) {
            return this.f29847a[(this.f29851e - this.f29848b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    public int h(int i10) {
        if (i10 != 0) {
            return this.f29848b[i10];
        }
        throw new IllegalArgumentException();
    }

    public int i(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        int[] iArr = this.f29847a;
        int[] iArr2 = this.f29848b;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f29851e - 1)];
    }

    public int j(int i10, int i11) {
        int i12 = this.f29851e;
        return ((i10 + i12) - i11) % i12;
    }
}
