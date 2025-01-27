package com.aggmoread.sdk.z.d.a.a.c.t;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private int f5253a;

    /* renamed from: b, reason: collision with root package name */
    private int f5254b;

    /* renamed from: c, reason: collision with root package name */
    private int f5255c;

    /* renamed from: d, reason: collision with root package name */
    private int f5256d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5257e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5258f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5259g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5260h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5261i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5262j;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.c.t.b$b, reason: collision with other inner class name */
    public static final class C0115b {

        /* renamed from: d, reason: collision with root package name */
        private int f5266d;

        /* renamed from: e, reason: collision with root package name */
        private int f5267e;

        /* renamed from: a, reason: collision with root package name */
        private int f5263a = 1;

        /* renamed from: b, reason: collision with root package name */
        private int f5264b = 1;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5265c = true;

        /* renamed from: f, reason: collision with root package name */
        private boolean f5268f = true;

        /* renamed from: g, reason: collision with root package name */
        private boolean f5269g = true;

        /* renamed from: h, reason: collision with root package name */
        private boolean f5270h = false;

        /* renamed from: i, reason: collision with root package name */
        private boolean f5271i = false;

        /* renamed from: j, reason: collision with root package name */
        private boolean f5272j = false;

        public C0115b a(int i10) {
            this.f5264b = i10;
            return this;
        }

        public C0115b b(int i10) {
            this.f5263a = i10;
            return this;
        }

        public C0115b c(boolean z10) {
            this.f5270h = z10;
            return this;
        }

        public C0115b d(boolean z10) {
            this.f5271i = z10;
            return this;
        }

        public C0115b e(boolean z10) {
            this.f5269g = z10;
            return this;
        }

        public C0115b f(boolean z10) {
            this.f5268f = z10;
            return this;
        }

        public C0115b a(boolean z10) {
            this.f5265c = z10;
            return this;
        }

        public C0115b b(boolean z10) {
            this.f5272j = z10;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.f5256d = this.f5264b;
            bVar.f5255c = this.f5263a;
            bVar.f5257e = this.f5265c;
            bVar.f5259g = this.f5269g;
            bVar.f5258f = this.f5268f;
            bVar.f5260h = this.f5270h;
            bVar.f5261i = this.f5271i;
            bVar.f5262j = this.f5272j;
            bVar.f5253a = this.f5266d;
            bVar.f5254b = this.f5267e;
            return bVar;
        }
    }

    static {
        new C0115b().a();
    }

    private b() {
    }

    public int a() {
        return this.f5256d;
    }

    public int b() {
        return this.f5253a;
    }

    public int c() {
        return this.f5254b;
    }

    public boolean e() {
        return this.f5262j;
    }

    public boolean f() {
        return this.f5260h;
    }

    public boolean g() {
        return this.f5259g;
    }

    public boolean h() {
        return this.f5258f;
    }

    public String toString() {
        return String.format("{最大视频时间=%s, 最小视频时间=%s, 视频播放设置=%s, 静音播放=%s, 自动播放设置=%s, 是否自动静音播放=%s, 进度条=%s, 封面=%s, 详情页=%s, 是否点击控制暂停=%s}", Integer.valueOf(this.f5253a), Integer.valueOf(this.f5254b), Integer.valueOf(this.f5255c), Boolean.valueOf(this.f5262j), Integer.valueOf(this.f5256d), Boolean.valueOf(this.f5257e), Boolean.valueOf(this.f5258f), Boolean.valueOf(this.f5259g), Boolean.valueOf(this.f5260h), Boolean.valueOf(this.f5261i));
    }

    public boolean d() {
        return this.f5257e;
    }
}
