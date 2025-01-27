package b.d.c.a.c;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f4424a = -1;

    /* renamed from: c, reason: collision with root package name */
    private String f4426c;

    /* renamed from: d, reason: collision with root package name */
    private String f4427d;

    /* renamed from: b, reason: collision with root package name */
    private int f4425b = -1;

    /* renamed from: e, reason: collision with root package name */
    private long f4428e = System.currentTimeMillis();

    public int a() {
        return this.f4425b;
    }

    public String b() {
        return this.f4426c;
    }

    public long c() {
        return this.f4428e;
    }

    public String d() {
        return this.f4427d;
    }

    public boolean e() {
        return !f();
    }

    public boolean f() {
        return this.f4425b == 200;
    }

    public void g(int respCode) {
        this.f4425b = respCode;
    }

    public void h(String respMsg) {
        this.f4426c = respMsg;
    }

    public void i(long serverTime) {
        this.f4428e = serverTime;
    }

    public void j(String stackTrace) {
        this.f4427d = stackTrace;
    }

    public String toString() {
        return "ResponseCode: " + this.f4425b + "Message:\n" + this.f4426c;
    }
}
