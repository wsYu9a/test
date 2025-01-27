package b.d.e.c.a.j;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f4655a = new a(99);

    /* renamed from: b, reason: collision with root package name */
    public static final b f4656b = new C0029b(1);

    /* renamed from: c, reason: collision with root package name */
    public static final b f4657c = new c(2);

    /* renamed from: d, reason: collision with root package name */
    public static final b f4658d = new d(3);

    /* renamed from: e, reason: collision with root package name */
    private int f4659e;

    static class a extends b {
        a(int i2) {
            super(i2, null);
        }

        public String toString() {
            return "UNKNOWN";
        }
    }

    /* renamed from: b.d.e.c.a.j.b$b, reason: collision with other inner class name */
    static class C0029b extends b {
        C0029b(int i2) {
            super(i2, null);
        }

        public String toString() {
            return "CMCC";
        }
    }

    static class c extends b {
        c(int i2) {
            super(i2, null);
        }

        public String toString() {
            return "TELECOM";
        }
    }

    static class d extends b {
        d(int i2) {
            super(i2, null);
        }

        public String toString() {
            return "UNICOM";
        }
    }

    private b(int i2) {
        this.f4659e = i2;
    }

    /* synthetic */ b(int i2, a aVar) {
        this(i2);
    }

    public final int a() {
        return this.f4659e;
    }
}
