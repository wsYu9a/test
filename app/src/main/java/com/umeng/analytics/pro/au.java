package com.umeng.analytics.pro;

/* loaded from: classes4.dex */
public class au extends bb {

    /* renamed from: a */
    public static final int f25705a = 0;

    /* renamed from: b */
    public static final int f25706b = 1;

    /* renamed from: c */
    public static final int f25707c = 2;

    /* renamed from: d */
    public static final int f25708d = 3;

    /* renamed from: e */
    public static final int f25709e = 4;

    /* renamed from: f */
    public static final int f25710f = 5;

    /* renamed from: g */
    public static final int f25711g = 6;

    /* renamed from: h */
    public static final int f25712h = 7;

    /* renamed from: j */
    private static final bz f25713j = new bz("TApplicationException");
    private static final bp k = new bp(com.heytap.mcssdk.n.d.l, (byte) 11, 1);
    private static final bp l = new bp("type", (byte) 8, 2);
    private static final long m = 1;

    /* renamed from: i */
    protected int f25714i;

    public au() {
        this.f25714i = 0;
    }

    public int a() {
        return this.f25714i;
    }

    public void b(bu buVar) throws bb {
        buVar.a(f25713j);
        if (getMessage() != null) {
            buVar.a(k);
            buVar.a(getMessage());
            buVar.c();
        }
        buVar.a(l);
        buVar.a(this.f25714i);
        buVar.c();
        buVar.d();
        buVar.b();
    }

    public static au a(bu buVar) throws bb {
        buVar.j();
        String str = null;
        int i2 = 0;
        while (true) {
            bp l2 = buVar.l();
            byte b2 = l2.f25780b;
            if (b2 == 0) {
                buVar.k();
                return new au(i2, str);
            }
            short s = l2.f25781c;
            if (s != 1) {
                if (s != 2) {
                    bx.a(buVar, b2);
                } else if (b2 == 8) {
                    i2 = buVar.w();
                } else {
                    bx.a(buVar, b2);
                }
            } else if (b2 == 11) {
                str = buVar.z();
            } else {
                bx.a(buVar, b2);
            }
            buVar.m();
        }
    }

    public au(int i2) {
        this.f25714i = 0;
        this.f25714i = i2;
    }

    public au(int i2, String str) {
        super(str);
        this.f25714i = 0;
        this.f25714i = i2;
    }

    public au(String str) {
        super(str);
        this.f25714i = 0;
    }
}
