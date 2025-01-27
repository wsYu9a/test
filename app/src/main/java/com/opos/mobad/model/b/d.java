package com.opos.mobad.model.b;

import com.opos.mobad.b.a.d;
import com.opos.mobad.b.a.t;
import java.util.List;

/* loaded from: classes4.dex */
public class d extends a {

    /* renamed from: a */
    public static final String f21519a = com.opos.cmn.an.a.b.a("b3Bwb19hZHg=");

    /* renamed from: b */
    public static final String f21520b = com.opos.cmn.an.a.b.a("b3Bwb19mZWVk");

    /* renamed from: c */
    public static final String f21521c = com.opos.cmn.an.a.b.a("b3Bwb19jcGQ=");

    /* renamed from: d */
    private int f21522d;

    /* renamed from: e */
    private String f21523e;

    /* renamed from: f */
    private List<com.opos.mobad.b.a.b> f21524f;

    /* renamed from: g */
    private long f21525g;

    /* renamed from: h */
    private String f21526h;

    /* renamed from: i */
    private t f21527i;

    /* renamed from: j */
    private int f21528j;
    private int k;
    private int l;
    private boolean m;
    private int n;
    private boolean o;
    private com.opos.mobad.b.a.d p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private String u;
    private String v;

    /* renamed from: com.opos.mobad.model.b.d$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f21529a;

        static {
            int[] iArr = new int[d.b.values().length];
            f21529a = iArr;
            try {
                iArr[d.b.NO_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21529a[d.b.GAME_BOX_BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21529a[d.b.GAME_BOX_INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public d() {
        this.o = true;
        this.q = false;
        this.r = 0;
        this.s = 0;
        this.t = 0;
    }

    public d(com.opos.mobad.b.a.d dVar) {
        this(dVar, null, 0L);
    }

    public d(com.opos.mobad.b.a.d dVar, List<com.opos.mobad.b.a.b> list, long j2) {
        this.o = true;
        this.q = false;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        if (dVar == null) {
            return;
        }
        Integer num = dVar.p;
        this.f21522d = num != null ? num.intValue() : -1;
        String str = dVar.q;
        this.f21523e = str == null ? "" : str;
        if (j2 <= 0) {
            Integer num2 = dVar.y;
            int intValue = (num2 == null ? com.opos.mobad.b.a.d.f19672h : num2).intValue();
            if (intValue <= 0) {
                Long l = dVar.t;
                j2 = l != null ? l.longValue() : System.currentTimeMillis();
            } else {
                j2 = intValue + System.currentTimeMillis();
            }
        }
        this.f21525g = j2;
        this.f21528j = dVar.w.intValue();
        Integer num3 = dVar.x;
        this.k = (num3 == null ? com.opos.mobad.b.a.d.f19671g : num3).intValue();
        if (list == null) {
            this.f21524f = dVar.s;
            this.q = false;
        } else {
            this.f21524f = list;
            this.q = true;
        }
        Integer num4 = dVar.A;
        this.r = (num4 == null ? com.opos.mobad.b.a.d.f19674j : num4).intValue();
        String str2 = dVar.u;
        this.f21526h = str2 != null ? str2 : "";
        this.f21527i = dVar.v;
        d.b bVar = dVar.z;
        bVar = bVar == null ? com.opos.mobad.b.a.d.f19673i : bVar;
        Boolean bool = dVar.B;
        this.m = (bool == null ? com.opos.mobad.b.a.d.k : bool).booleanValue();
        this.l = a(bVar);
        Integer num5 = dVar.C;
        this.n = (num5 == null ? com.opos.mobad.b.a.d.l : num5).intValue();
        Boolean bool2 = dVar.D;
        this.o = (bool2 == null ? com.opos.mobad.b.a.b.p : bool2).booleanValue();
        this.p = dVar;
        Integer num6 = dVar.E;
        this.s = (num6 == null ? com.opos.mobad.b.a.d.n : num6).intValue();
        Integer num7 = dVar.F;
        this.t = (num7 == null ? com.opos.mobad.b.a.d.o : num7).intValue();
        this.u = dVar.G;
        this.v = dVar.H;
    }

    private int a(d.b bVar) {
        if (bVar != null) {
            int i2 = AnonymousClass1.f21529a[bVar.ordinal()];
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 3) {
                return 2;
            }
        }
        return 0;
    }

    protected void a(int i2) {
        this.f21522d = i2;
    }

    protected void a(String str) {
        this.f21523e = str;
    }

    public boolean a() {
        return this.q;
    }

    public int b() {
        return this.r;
    }

    public com.opos.mobad.b.a.d c() {
        return this.p;
    }

    public boolean d() {
        return this.o;
    }

    public int e() {
        return this.n;
    }

    public int f() {
        return this.f21522d;
    }

    public String g() {
        return this.f21523e;
    }

    public List<com.opos.mobad.b.a.b> h() {
        return this.f21524f;
    }

    public long i() {
        return this.f21525g;
    }

    public String j() {
        return this.f21526h;
    }

    public t k() {
        return this.f21527i;
    }

    public int l() {
        return this.f21528j;
    }

    public int m() {
        return this.k;
    }

    public int n() {
        return this.l;
    }

    public boolean o() {
        return this.m;
    }

    public boolean p() {
        return (this.s & 1) == 1;
    }

    public boolean q() {
        return this.t == 1;
    }

    public String r() {
        return this.u;
    }

    public String s() {
        return this.v;
    }

    public String toString() {
        return "FetchAdResponse{code=" + this.f21522d + ", msg='" + this.f21523e + "', requestInterval='" + this.f21528j + "', adEntityList=" + this.f21524f + ", expireTime=" + this.f21525g + ", respId='" + this.f21526h + "', instantIdsEntity=" + this.f21527i + ", dispatchMode=" + this.k + ", gameBoxType=" + this.l + "', customSkip=" + this.m + "', cacheNum=" + this.r + "', recordShowEvent=" + this.o + "', cmType=" + this.s + "', strategyState=" + this.t + "'}";
    }
}
