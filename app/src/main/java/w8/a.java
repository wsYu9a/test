package w8;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: e */
    public static final int f31670e = -1;

    /* renamed from: b */
    public String f31672b;

    /* renamed from: c */
    public String f31673c;

    /* renamed from: a */
    public int f31671a = -1;

    /* renamed from: d */
    public long f31674d = System.currentTimeMillis();

    public int a() {
        return this.f31671a;
    }

    public String b() {
        return this.f31672b;
    }

    public long c() {
        return this.f31674d;
    }

    public String d() {
        return this.f31673c;
    }

    public boolean e() {
        return !f();
    }

    public boolean f() {
        return this.f31671a == 200;
    }

    public void g(int i10) {
        this.f31671a = i10;
    }

    public void h(String str) {
        this.f31672b = str;
    }

    public void i(long j10) {
        this.f31674d = j10;
    }

    public void j(String str) {
        this.f31673c = str;
    }

    public String toString() {
        return "ResponseCode: " + this.f31671a + "Message:\n" + this.f31672b;
    }
}
