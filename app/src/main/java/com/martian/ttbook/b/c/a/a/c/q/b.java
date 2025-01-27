package com.martian.ttbook.b.c.a.a.c.q;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    private int f15572a;

    /* renamed from: b */
    private int f15573b;

    /* renamed from: c */
    private int f15574c;

    /* renamed from: d */
    private int f15575d;

    /* renamed from: e */
    private boolean f15576e;

    /* renamed from: f */
    private boolean f15577f;

    /* renamed from: g */
    private boolean f15578g;

    /* renamed from: h */
    private boolean f15579h;

    /* renamed from: i */
    private boolean f15580i;

    /* renamed from: j */
    private boolean f15581j;

    /* renamed from: com.martian.ttbook.b.c.a.a.c.q.b$b */
    public static final class C0342b {

        /* renamed from: d */
        private int f15585d;

        /* renamed from: e */
        private int f15586e;

        /* renamed from: a */
        private int f15582a = 1;

        /* renamed from: b */
        private int f15583b = 1;

        /* renamed from: c */
        private boolean f15584c = true;

        /* renamed from: f */
        private boolean f15587f = true;

        /* renamed from: g */
        private boolean f15588g = true;

        /* renamed from: h */
        private boolean f15589h = false;

        /* renamed from: i */
        private boolean f15590i = false;

        /* renamed from: j */
        private boolean f15591j = false;

        public C0342b a(int i2) {
            this.f15583b = i2;
            return this;
        }

        public C0342b b(boolean z) {
            this.f15584c = z;
            return this;
        }

        public b c() {
            b bVar = new b();
            bVar.f15575d = this.f15583b;
            bVar.f15574c = this.f15582a;
            bVar.f15576e = this.f15584c;
            bVar.f15578g = this.f15588g;
            bVar.f15577f = this.f15587f;
            bVar.f15579h = this.f15589h;
            bVar.f15580i = this.f15590i;
            bVar.f15581j = this.f15591j;
            bVar.f15572a = this.f15585d;
            bVar.f15573b = this.f15586e;
            return bVar;
        }

        public C0342b d(int i2) {
            this.f15585d = i2;
            return this;
        }

        public C0342b e(boolean z) {
            this.f15589h = z;
            return this;
        }

        public C0342b f(int i2) {
            this.f15586e = i2;
            return this;
        }

        public C0342b g(boolean z) {
            this.f15590i = z;
            return this;
        }

        public C0342b h(int i2) {
            this.f15582a = i2;
            return this;
        }

        public C0342b i(boolean z) {
            this.f15588g = z;
            return this;
        }

        public C0342b j(boolean z) {
            this.f15587f = z;
            return this;
        }
    }

    static {
        new C0342b().c();
    }

    private b() {
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public int a() {
        return this.f15575d;
    }

    public int d() {
        return this.f15572a;
    }

    public int g() {
        return this.f15573b;
    }

    public boolean k() {
        return this.f15576e;
    }

    public boolean m() {
        return this.f15579h;
    }

    public boolean o() {
        return this.f15578g;
    }

    public boolean q() {
        return this.f15577f;
    }

    public String toString() {
        return String.format("ViedeoOptions{maxVideoDuration=%s, minVideoDuration=%s, videoPlayPolicy=%s, detailPageMuted=%s, autoPlayPolicy=%s, autoPlayMuted=%s, needProgressBar=%s, needCoverImage=%s, enableDetailPage=%s, enableUserControl=%s}", Integer.valueOf(this.f15572a), Integer.valueOf(this.f15573b), Integer.valueOf(this.f15574c), Boolean.valueOf(this.f15581j), Integer.valueOf(this.f15575d), Boolean.valueOf(this.f15576e), Boolean.valueOf(this.f15577f), Boolean.valueOf(this.f15578g), Boolean.valueOf(this.f15579h), Boolean.valueOf(this.f15580i));
    }
}
