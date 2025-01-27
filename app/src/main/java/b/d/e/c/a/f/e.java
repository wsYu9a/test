package b.d.e.c.a.f;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f4604a = new e(50005, "容器已销毁！");

    /* renamed from: b, reason: collision with root package name */
    public static final e f4605b = new e(50005, "未指定广告容器！");

    /* renamed from: c, reason: collision with root package name */
    public static final e f4606c = new e(50006, "图片加载失败！");

    /* renamed from: d, reason: collision with root package name */
    public static final e f4607d = new e(50007, "图片加载失败！");

    /* renamed from: e, reason: collision with root package name */
    public static final e f4608e = new e(50008, "activity is null！");

    /* renamed from: f, reason: collision with root package name */
    public static final e f4609f = new e(50001, "广告未初始化！");

    /* renamed from: g, reason: collision with root package name */
    private int f4610g;

    /* renamed from: h, reason: collision with root package name */
    private String f4611h;

    public e(int i2, String str) {
        this.f4610g = -1;
        this.f4610g = i2;
        this.f4611h = str;
    }

    public int a() {
        return this.f4610g;
    }

    public String b() {
        return this.f4611h;
    }

    public String toString() {
        return "JuHeApiError{errorCode=" + this.f4610g + ", errorMessage='" + this.f4611h + "'}";
    }
}
