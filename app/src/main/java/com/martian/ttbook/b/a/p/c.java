package com.martian.ttbook.b.a.p;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    public static c f15094a = new b().c();

    /* renamed from: b */
    private int f15095b;

    /* renamed from: c */
    private int f15096c;

    /* renamed from: d */
    private int f15097d;

    /* renamed from: e */
    private int f15098e;

    /* renamed from: f */
    private boolean f15099f;

    /* renamed from: g */
    private boolean f15100g;

    /* renamed from: h */
    private boolean f15101h;

    /* renamed from: i */
    private boolean f15102i;

    /* renamed from: j */
    private boolean f15103j;
    private boolean k;

    public static final class b {

        /* renamed from: d */
        private int f15107d;

        /* renamed from: e */
        private int f15108e;

        /* renamed from: a */
        private int f15104a = 1;

        /* renamed from: b */
        private int f15105b = 1;

        /* renamed from: c */
        private boolean f15106c = true;

        /* renamed from: f */
        private boolean f15109f = true;

        /* renamed from: g */
        private boolean f15110g = true;

        /* renamed from: h */
        private boolean f15111h = false;

        /* renamed from: i */
        private boolean f15112i = false;

        /* renamed from: j */
        private boolean f15113j = false;

        public b a(int i2) {
            this.f15105b = i2;
            return this;
        }

        public b b(boolean z) {
            this.f15106c = z;
            return this;
        }

        public c c() {
            c cVar = new c();
            cVar.f15098e = this.f15105b;
            cVar.f15097d = this.f15104a;
            cVar.f15099f = this.f15106c;
            cVar.f15101h = this.f15110g;
            cVar.f15100g = this.f15109f;
            cVar.f15102i = this.f15111h;
            cVar.f15103j = this.f15112i;
            cVar.k = this.f15113j;
            cVar.f15095b = this.f15107d;
            cVar.f15096c = this.f15108e;
            return cVar;
        }

        public b d(boolean z) {
            this.f15111h = z;
            return this;
        }

        public b e(boolean z) {
            this.f15110g = z;
            return this;
        }

        public b f(boolean z) {
            this.f15109f = z;
            return this;
        }
    }

    private c() {
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    public boolean b() {
        return this.f15100g;
    }

    public String toString() {
        return String.format("ViedeoOptions{maxVideoDuration=%s, minVideoDuration=%s, videoPlayPolicy=%s, detailPageMuted=%s, autoPlayPolicy=%s, autoPlayMuted=%s, needProgressBar=%s, needCoverImage=%s, enableDetailPage=%s, enableUserControl=%s}", Integer.valueOf(this.f15095b), Integer.valueOf(this.f15096c), Integer.valueOf(this.f15097d), Boolean.valueOf(this.k), Integer.valueOf(this.f15098e), Boolean.valueOf(this.f15099f), Boolean.valueOf(this.f15100g), Boolean.valueOf(this.f15101h), Boolean.valueOf(this.f15102i), Boolean.valueOf(this.f15103j));
    }
}
