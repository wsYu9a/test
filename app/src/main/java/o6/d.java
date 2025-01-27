package o6;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: f */
    public static final int f29080f = -1;

    /* renamed from: a */
    public final int f29081a;

    /* renamed from: b */
    public final int f29082b;

    /* renamed from: c */
    public final int f29083c;

    /* renamed from: d */
    public final int f29084d;

    /* renamed from: e */
    public int f29085e = -1;

    public d(int i10, int i11, int i12, int i13) {
        this.f29081a = i10;
        this.f29082b = i11;
        this.f29083c = i12;
        this.f29084d = i13;
    }

    public int a() {
        return this.f29083c;
    }

    public int b() {
        return this.f29082b;
    }

    public int c() {
        return this.f29085e;
    }

    public int d() {
        return this.f29081a;
    }

    public int e() {
        return this.f29084d;
    }

    public int f() {
        return this.f29082b - this.f29081a;
    }

    public boolean g() {
        return h(this.f29085e);
    }

    public boolean h(int i10) {
        return i10 != -1 && this.f29083c == (i10 % 3) * 3;
    }

    public void i(int i10) {
        this.f29085e = i10;
    }

    public void j() {
        this.f29085e = ((this.f29084d / 30) * 3) + (this.f29083c / 3);
    }

    public String toString() {
        return this.f29085e + "|" + this.f29084d;
    }
}
