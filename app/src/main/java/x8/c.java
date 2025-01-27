package x8;

/* loaded from: classes3.dex */
public class c extends k {

    /* renamed from: e */
    public static final int f31876e = 1000;

    /* renamed from: f */
    public static final int f31877f = 100001;

    /* renamed from: g */
    public static final int f31878g = -100002;

    /* renamed from: h */
    public static final int f31879h = -100003;

    /* renamed from: i */
    public static final int f31880i = -100004;

    /* renamed from: b */
    public int f31881b;

    /* renamed from: c */
    public String f31882c;

    /* renamed from: d */
    public String f31883d;

    public c(long j10, int i10, String str, String str2) {
        super(j10);
        this.f31881b = i10;
        this.f31882c = str;
        this.f31883d = str2;
    }

    public int c() {
        return this.f31881b;
    }

    public String d() {
        return this.f31882c;
    }

    public String e() {
        return this.f31883d;
    }

    public void f(int i10) {
        this.f31881b = i10;
    }

    public void g(String str) {
        this.f31882c = str;
    }

    public void h(String str) {
        this.f31883d = str;
    }

    public String toString() {
        return "Error (" + this.f31881b + "): " + this.f31882c;
    }

    public c(int i10, String str) {
        this(System.currentTimeMillis(), i10, str, "");
    }
}
