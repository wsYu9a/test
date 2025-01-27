package b7;

/* loaded from: classes2.dex */
public abstract class d {
    public static final String A = "distinctBycontent";
    public static final String B = "startDate";
    public static final String C = "endDate";
    public static final String D = "priority";
    public static final String E = "description";
    public static final String F = "appID";
    public static final String G = "globalID";
    public static final int H = 0;
    public static final int I = 1;
    public static final int J = 0;
    public static final int K = 1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f1351d = 4096;

    /* renamed from: e, reason: collision with root package name */
    public static final int f1352e = 4097;

    /* renamed from: f, reason: collision with root package name */
    public static final int f1353f = 4098;

    /* renamed from: g, reason: collision with root package name */
    public static final int f1354g = 4099;

    /* renamed from: h, reason: collision with root package name */
    public static final int f1355h = 4100;

    /* renamed from: i, reason: collision with root package name */
    public static final int f1356i = 4101;

    /* renamed from: j, reason: collision with root package name */
    public static final int f1357j = 4102;

    /* renamed from: k, reason: collision with root package name */
    public static final int f1358k = 4103;

    /* renamed from: l, reason: collision with root package name */
    public static final int f1359l = 4105;

    /* renamed from: m, reason: collision with root package name */
    public static final int f1360m = 4106;

    /* renamed from: n, reason: collision with root package name */
    public static final int f1361n = 4196;

    /* renamed from: o, reason: collision with root package name */
    public static final String f1362o = "message";

    /* renamed from: p, reason: collision with root package name */
    public static final String f1363p = "type";

    /* renamed from: q, reason: collision with root package name */
    public static final String f1364q = "messageID";

    /* renamed from: r, reason: collision with root package name */
    public static final String f1365r = "taskID";

    /* renamed from: s, reason: collision with root package name */
    public static final String f1366s = "appPackage";

    /* renamed from: t, reason: collision with root package name */
    public static final String f1367t = "showMode";

    /* renamed from: u, reason: collision with root package name */
    public static final String f1368u = "title";

    /* renamed from: v, reason: collision with root package name */
    public static final String f1369v = "content";

    /* renamed from: w, reason: collision with root package name */
    public static final String f1370w = "balanceTime";

    /* renamed from: x, reason: collision with root package name */
    public static final String f1371x = "timeRanges";

    /* renamed from: y, reason: collision with root package name */
    public static final String f1372y = "rule";

    /* renamed from: z, reason: collision with root package name */
    public static final String f1373z = "forcedDelivery";

    /* renamed from: a, reason: collision with root package name */
    public int f1374a;

    /* renamed from: b, reason: collision with root package name */
    public String f1375b;

    /* renamed from: c, reason: collision with root package name */
    public String f1376c = "";

    public String a() {
        return this.f1375b;
    }

    public int b() {
        return this.f1374a;
    }

    public String c() {
        return this.f1376c;
    }

    public void d(String str) {
        this.f1375b = str;
    }

    public void e(int i10) {
        this.f1374a = i10;
    }

    public void f(int i10) {
        this.f1376c = String.valueOf(i10);
    }

    public void g(String str) {
        this.f1376c = str;
    }

    public abstract int getType();
}
