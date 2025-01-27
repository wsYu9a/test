package com.heytap.mcssdk.n;

/* loaded from: classes.dex */
public abstract class d {
    public static final String A = "priority";
    public static final String B = "description";
    public static final String C = "appID";
    public static final String D = "globalID";
    public static final int E = 0;
    public static final int F = 1;
    public static final int G = 0;
    public static final int H = 1;

    /* renamed from: a, reason: collision with root package name */
    public static final int f8905a = 4096;

    /* renamed from: b, reason: collision with root package name */
    public static final int f8906b = 4097;

    /* renamed from: c, reason: collision with root package name */
    public static final int f8907c = 4098;

    /* renamed from: d, reason: collision with root package name */
    public static final int f8908d = 4099;

    /* renamed from: e, reason: collision with root package name */
    public static final int f8909e = 4100;

    /* renamed from: f, reason: collision with root package name */
    public static final int f8910f = 4101;

    /* renamed from: g, reason: collision with root package name */
    public static final int f8911g = 4102;

    /* renamed from: h, reason: collision with root package name */
    public static final int f8912h = 4103;

    /* renamed from: i, reason: collision with root package name */
    public static final int f8913i = 4105;

    /* renamed from: j, reason: collision with root package name */
    public static final int f8914j = 4106;
    public static final int k = 4196;
    public static final String l = "message";
    public static final String m = "type";
    public static final String n = "messageID";
    public static final String o = "taskID";
    public static final String p = "appPackage";
    public static final String q = "showMode";
    public static final String r = "title";
    public static final String s = "content";
    public static final String t = "balanceTime";
    public static final String u = "timeRanges";
    public static final String v = "rule";
    public static final String w = "forcedDelivery";
    public static final String x = "distinctBycontent";
    public static final String y = "startDate";
    public static final String z = "endDate";
    private int I;
    private String J;
    private String K = "";

    public String a() {
        return this.J;
    }

    public int b() {
        return this.I;
    }

    public String c() {
        return this.K;
    }

    public void d(String str) {
        this.J = str;
    }

    public void e(int i2) {
        this.I = i2;
    }

    public void f(int i2) {
        this.K = String.valueOf(i2);
    }

    public void g(String str) {
        this.K = str;
    }

    public abstract int getType();
}
