package b.h.a.h;

/* loaded from: classes4.dex */
public abstract class b implements b.h.a.b {

    /* renamed from: a */
    private int f4996a = 1;

    /* renamed from: b */
    private int f4997b = 1;

    @Override // b.h.a.b
    public void a(String str, String str2) {
        h(str, str2, this.f4997b != -1, (byte) 2);
    }

    @Override // b.h.a.b
    public void a(String str, String str2, boolean z) {
        h(str, str2, z, (byte) 1);
    }

    @Override // b.h.a.b
    public void b(String str, String str2) {
        h(str, str2, this.f4997b != -1, (byte) 4);
    }

    @Override // b.h.a.b
    public void b(String str, String str2, boolean z) {
        h(str, str2, z, (byte) 3);
    }

    @Override // b.h.a.b
    public void c(String str, String str2) {
        h(str, str2, this.f4997b != -1, (byte) 5);
    }

    @Override // b.h.a.b
    public void c(String str, String str2, boolean z) {
        h(str, str2, z, (byte) 4);
    }

    @Override // b.h.a.b
    public void d(String str, String str2, boolean z) {
        h(str, str2, z, (byte) 5);
    }

    @Override // b.h.a.b
    public void e(String str, String str2, boolean z) {
        h(str, str2, z, (byte) 2);
    }

    public int f() {
        return this.f4996a;
    }

    public void g(int i2) {
        this.f4996a = i2;
    }

    public abstract void h(String str, String str2, boolean z, byte b2);

    public int i() {
        return this.f4997b;
    }

    public void j(int i2) {
        this.f4997b = i2;
    }

    public int k() {
        return 101;
    }
}
