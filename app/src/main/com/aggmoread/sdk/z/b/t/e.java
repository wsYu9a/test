package com.aggmoread.sdk.z.b.t;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: k, reason: collision with root package name */
    public static e f4958k = new b().a();

    /* renamed from: a, reason: collision with root package name */
    private int f4959a;

    /* renamed from: b, reason: collision with root package name */
    private int f4960b;

    /* renamed from: c, reason: collision with root package name */
    private int f4961c;

    /* renamed from: d, reason: collision with root package name */
    private int f4962d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4963e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f4964f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4965g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4966h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4967i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4968j;

    public static final class b {

        /* renamed from: d, reason: collision with root package name */
        private int f4972d;

        /* renamed from: e, reason: collision with root package name */
        private int f4973e;

        /* renamed from: a, reason: collision with root package name */
        private int f4969a = 1;

        /* renamed from: b, reason: collision with root package name */
        private int f4970b = 1;

        /* renamed from: c, reason: collision with root package name */
        private boolean f4971c = true;

        /* renamed from: f, reason: collision with root package name */
        private boolean f4974f = true;

        /* renamed from: g, reason: collision with root package name */
        private boolean f4975g = true;

        /* renamed from: h, reason: collision with root package name */
        private boolean f4976h = false;

        /* renamed from: i, reason: collision with root package name */
        private boolean f4977i = false;

        /* renamed from: j, reason: collision with root package name */
        private boolean f4978j = false;

        public b a(int i10) {
            this.f4970b = i10;
            return this;
        }

        public b b(boolean z10) {
            this.f4976h = z10;
            return this;
        }

        public b c(boolean z10) {
            this.f4975g = z10;
            return this;
        }

        public b d(boolean z10) {
            this.f4974f = z10;
            return this;
        }

        public b a(boolean z10) {
            this.f4971c = z10;
            return this;
        }

        public e a() {
            e eVar = new e();
            eVar.f4962d = this.f4970b;
            eVar.f4961c = this.f4969a;
            eVar.f4963e = this.f4971c;
            eVar.f4965g = this.f4975g;
            eVar.f4964f = this.f4974f;
            eVar.f4966h = this.f4976h;
            eVar.f4967i = this.f4977i;
            eVar.f4968j = this.f4978j;
            eVar.f4959a = this.f4972d;
            eVar.f4960b = this.f4973e;
            return eVar;
        }
    }

    private e() {
    }

    public String toString() {
        return String.format("{最大视频时间=%s, 最小视频时间=%s, 视频播放设置=%s, 静音播放=%s, 自动播放设置=%s, 是否自动静音播放=%s, 进度条=%s, 封面=%s, 详情页=%s, 是否点击控制暂停=%s}", Integer.valueOf(this.f4959a), Integer.valueOf(this.f4960b), Integer.valueOf(this.f4961c), Boolean.valueOf(this.f4968j), Integer.valueOf(this.f4962d), Boolean.valueOf(this.f4963e), Boolean.valueOf(this.f4964f), Boolean.valueOf(this.f4965g), Boolean.valueOf(this.f4966h), Boolean.valueOf(this.f4967i));
    }

    public boolean a() {
        return this.f4964f;
    }
}
