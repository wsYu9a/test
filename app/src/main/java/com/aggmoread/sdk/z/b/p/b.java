package com.aggmoread.sdk.z.b.p;

/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f4777b = new a(99);

    /* renamed from: c, reason: collision with root package name */
    public static final b f4778c = new C0087b(1);

    /* renamed from: d, reason: collision with root package name */
    public static final b f4779d = new c(2);

    /* renamed from: e, reason: collision with root package name */
    public static final b f4780e = new d(3);

    /* renamed from: a, reason: collision with root package name */
    private int f4781a;

    public static class a extends b {
        public a(int i10) {
            super(i10, null);
        }

        public String toString() {
            return "UNKNOWN";
        }
    }

    /* renamed from: com.aggmoread.sdk.z.b.p.b$b, reason: collision with other inner class name */
    public static class C0087b extends b {
        public C0087b(int i10) {
            super(i10, null);
        }

        public String toString() {
            return "CMCC";
        }
    }

    public static class c extends b {
        public c(int i10) {
            super(i10, null);
        }

        public String toString() {
            return "TELECOM";
        }
    }

    public static class d extends b {
        public d(int i10) {
            super(i10, null);
        }

        public String toString() {
            return "UNICOM";
        }
    }

    private b(int i10) {
        this.f4781a = i10;
    }

    public final int a() {
        return this.f4781a;
    }

    public /* synthetic */ b(int i10, a aVar) {
        this(i10);
    }
}
