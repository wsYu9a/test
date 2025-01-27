package com.umeng.analytics.pro;

/* loaded from: classes4.dex */
public class cg extends cn {

    /* renamed from: a */
    public static final int f23733a = 0;

    /* renamed from: b */
    public static final int f23734b = 1;

    /* renamed from: c */
    public static final int f23735c = 2;

    /* renamed from: d */
    public static final int f23736d = 3;

    /* renamed from: e */
    public static final int f23737e = 4;

    /* renamed from: f */
    public static final int f23738f = 5;

    /* renamed from: g */
    public static final int f23739g = 6;

    /* renamed from: h */
    public static final int f23740h = 7;

    /* renamed from: j */
    private static final dl f23741j = new dl("TApplicationException");

    /* renamed from: k */
    private static final db f23742k = new db(b7.d.f1362o, (byte) 11, 1);

    /* renamed from: l */
    private static final db f23743l = new db("type", (byte) 8, 2);

    /* renamed from: m */
    private static final long f23744m = 1;

    /* renamed from: i */
    protected int f23745i;

    public cg() {
        this.f23745i = 0;
    }

    public int a() {
        return this.f23745i;
    }

    public void b(dg dgVar) throws cn {
        dgVar.a(f23741j);
        if (getMessage() != null) {
            dgVar.a(f23742k);
            dgVar.a(getMessage());
            dgVar.c();
        }
        dgVar.a(f23743l);
        dgVar.a(this.f23745i);
        dgVar.c();
        dgVar.d();
        dgVar.b();
    }

    public static cg a(dg dgVar) throws cn {
        dgVar.j();
        String str = null;
        int i10 = 0;
        while (true) {
            db l10 = dgVar.l();
            byte b10 = l10.f23828b;
            if (b10 == 0) {
                dgVar.k();
                return new cg(i10, str);
            }
            short s10 = l10.f23829c;
            if (s10 != 1) {
                if (s10 != 2) {
                    dj.a(dgVar, b10);
                } else if (b10 == 8) {
                    i10 = dgVar.w();
                } else {
                    dj.a(dgVar, b10);
                }
            } else if (b10 == 11) {
                str = dgVar.z();
            } else {
                dj.a(dgVar, b10);
            }
            dgVar.m();
        }
    }

    public cg(int i10) {
        this.f23745i = i10;
    }

    public cg(int i10, String str) {
        super(str);
        this.f23745i = i10;
    }

    public cg(String str) {
        super(str);
        this.f23745i = 0;
    }
}
