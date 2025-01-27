package b.d.c.b;

/* loaded from: classes2.dex */
public class c extends k {

    /* renamed from: b */
    public static final int f4431b = 1000;

    /* renamed from: c */
    public static final int f4432c = 100001;

    /* renamed from: d */
    public static final int f4433d = -100002;

    /* renamed from: e */
    private int f4434e;

    /* renamed from: f */
    private String f4435f;

    /* renamed from: g */
    private String f4436g;

    public c(long time, int errorCode, String errorMsg, String stackTrace) {
        super(time);
        this.f4434e = errorCode;
        this.f4435f = errorMsg;
        this.f4436g = stackTrace;
    }

    public int c() {
        return this.f4434e;
    }

    public String d() {
        return this.f4435f;
    }

    public String e() {
        return this.f4436g;
    }

    public void f(int errorCode) {
        this.f4434e = errorCode;
    }

    public void g(String errorMsg) {
        this.f4435f = errorMsg;
    }

    public void h(String stackTrace) {
        this.f4436g = stackTrace;
    }

    public String toString() {
        return "Error (" + this.f4434e + "): " + this.f4435f;
    }

    public c(int errorCode, String errorMsg) {
        this(System.currentTimeMillis(), errorCode, errorMsg, "");
    }
}
