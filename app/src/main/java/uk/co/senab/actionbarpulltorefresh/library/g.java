package uk.co.senab.actionbarpulltorefresh.library;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a */
    private static final int f37160a = R.layout.default_header;

    /* renamed from: b */
    private static final float f37161b = 0.5f;

    /* renamed from: c */
    private static final boolean f37162c = false;

    /* renamed from: d */
    private static final int f37163d = 1000;

    /* renamed from: e */
    private static final boolean f37164e = true;

    /* renamed from: f */
    d f37165f = null;

    /* renamed from: g */
    int f37166g = f37160a;

    /* renamed from: h */
    e f37167h = null;

    /* renamed from: i */
    float f37168i = 0.5f;

    /* renamed from: j */
    boolean f37169j = false;
    int k = 1000;
    boolean l = true;

    public static class a {

        /* renamed from: a */
        final g f37170a = new g();

        public g a() {
            return this.f37170a;
        }

        public a b(d dVar) {
            this.f37170a.f37165f = dVar;
            return this;
        }

        public a c(int i2) {
            this.f37170a.f37166g = i2;
            return this;
        }

        public a d(e eVar) {
            this.f37170a.f37167h = eVar;
            return this;
        }

        public a e() {
            return f(1000);
        }

        public a f(int i2) {
            g gVar = this.f37170a;
            gVar.k = i2;
            gVar.l = true;
            return this;
        }

        public a g() {
            this.f37170a.l = false;
            return this;
        }

        public a h(boolean z) {
            this.f37170a.f37169j = z;
            return this;
        }

        public a i(float f2) {
            this.f37170a.f37168i = f2;
            return this;
        }
    }

    g() {
    }

    public static a a() {
        return new a();
    }
}
