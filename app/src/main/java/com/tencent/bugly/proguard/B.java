package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class B extends AbstractC0909m implements Cloneable {

    /* renamed from: a */
    static C0920y f24923a;

    /* renamed from: b */
    static C0919x f24924b;

    /* renamed from: c */
    static C0919x f24925c;

    /* renamed from: d */
    static Map<String, String> f24926d;

    /* renamed from: e */
    static final /* synthetic */ boolean f24927e = true;

    /* renamed from: f */
    public String f24928f;

    /* renamed from: g */
    public String f24929g;

    /* renamed from: h */
    public long f24930h;

    /* renamed from: i */
    public int f24931i;

    /* renamed from: j */
    public C0920y f24932j;
    public C0919x k;
    public byte l;
    public int m;
    public long n;
    public C0919x o;
    public String p;
    public Map<String, String> q;
    public String r;
    public int s;
    public long t;
    public int u;

    public B() {
        this.f24928f = "";
        this.f24929g = "";
        this.f24930h = 0L;
        this.f24931i = 0;
        this.f24932j = null;
        this.k = null;
        this.l = (byte) 0;
        this.m = 0;
        this.n = 0L;
        this.o = null;
        this.p = "";
        this.q = null;
        this.r = "";
        this.s = 0;
        this.t = 0L;
        this.u = 0;
    }

    public C0919x a() {
        return this.k;
    }

    public long b() {
        return this.f24930h;
    }

    public Map<String, String> c() {
        return this.q;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f24927e) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        B b2 = (B) obj;
        return C0910n.a(this.f24928f, b2.f24928f) && C0910n.a(this.f24929g, b2.f24929g) && C0910n.a(this.f24930h, b2.f24930h) && C0910n.a(this.f24931i, b2.f24931i) && C0910n.a(this.f24932j, b2.f24932j) && C0910n.a(this.k, b2.k) && C0910n.a(this.l, b2.l) && C0910n.a(this.m, b2.m) && C0910n.a(this.n, b2.n) && C0910n.a(this.o, b2.o) && C0910n.a(this.p, b2.p) && C0910n.a(this.q, b2.q) && C0910n.a(this.r, b2.r) && C0910n.a(this.s, b2.s) && C0910n.a(this.t, b2.t) && C0910n.a(this.u, b2.u);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0908l c0908l) {
        c0908l.a(this.f24928f, 0);
        c0908l.a(this.f24929g, 1);
        c0908l.a(this.f24930h, 2);
        c0908l.a(this.f24931i, 3);
        c0908l.a((AbstractC0909m) this.f24932j, 4);
        c0908l.a((AbstractC0909m) this.k, 5);
        c0908l.a(this.l, 6);
        c0908l.a(this.m, 7);
        c0908l.a(this.n, 8);
        C0919x c0919x = this.o;
        if (c0919x != null) {
            c0908l.a((AbstractC0909m) c0919x, 9);
        }
        String str = this.p;
        if (str != null) {
            c0908l.a(str, 10);
        }
        Map<String, String> map = this.q;
        if (map != null) {
            c0908l.a((Map) map, 11);
        }
        String str2 = this.r;
        if (str2 != null) {
            c0908l.a(str2, 12);
        }
        c0908l.a(this.s, 13);
        c0908l.a(this.t, 14);
        c0908l.a(this.u, 15);
    }

    public B(String str, String str2, long j2, int i2, C0920y c0920y, C0919x c0919x, byte b2, int i3, long j3, C0919x c0919x2, String str3, Map<String, String> map, String str4, int i4, long j4, int i5) {
        this.f24928f = "";
        this.f24929g = "";
        this.f24930h = 0L;
        this.f24931i = 0;
        this.f24932j = null;
        this.k = null;
        this.l = (byte) 0;
        this.m = 0;
        this.n = 0L;
        this.o = null;
        this.p = "";
        this.q = null;
        this.r = "";
        this.s = 0;
        this.t = 0L;
        this.u = 0;
        this.f24928f = str;
        this.f24929g = str2;
        this.f24930h = j2;
        this.f24931i = i2;
        this.f24932j = c0920y;
        this.k = c0919x;
        this.l = b2;
        this.m = i3;
        this.n = j3;
        this.o = c0919x2;
        this.p = str3;
        this.q = map;
        this.r = str4;
        this.s = i4;
        this.t = j4;
        this.u = i5;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        this.f24928f = c0907k.a(0, true);
        this.f24929g = c0907k.a(1, true);
        this.f24930h = c0907k.a(this.f24930h, 2, true);
        this.f24931i = c0907k.a(this.f24931i, 3, true);
        if (f24923a == null) {
            f24923a = new C0920y();
        }
        this.f24932j = (C0920y) c0907k.a((AbstractC0909m) f24923a, 4, true);
        if (f24924b == null) {
            f24924b = new C0919x();
        }
        this.k = (C0919x) c0907k.a((AbstractC0909m) f24924b, 5, true);
        this.l = c0907k.a(this.l, 6, true);
        this.m = c0907k.a(this.m, 7, false);
        this.n = c0907k.a(this.n, 8, false);
        if (f24925c == null) {
            f24925c = new C0919x();
        }
        this.o = (C0919x) c0907k.a((AbstractC0909m) f24925c, 9, false);
        this.p = c0907k.a(10, false);
        if (f24926d == null) {
            HashMap hashMap = new HashMap();
            f24926d = hashMap;
            hashMap.put("", "");
        }
        this.q = (Map) c0907k.a((C0907k) f24926d, 11, false);
        this.r = c0907k.a(12, false);
        this.s = c0907k.a(this.s, 13, false);
        this.t = c0907k.a(this.t, 14, false);
        this.u = c0907k.a(this.u, 15, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(StringBuilder sb, int i2) {
        C0905i c0905i = new C0905i(sb, i2);
        c0905i.a(this.f24928f, "title");
        c0905i.a(this.f24929g, "newFeature");
        c0905i.a(this.f24930h, "publishTime");
        c0905i.a(this.f24931i, "publishType");
        c0905i.a((AbstractC0909m) this.f24932j, "appBasicInfo");
        c0905i.a((AbstractC0909m) this.k, "apkBaseInfo");
        c0905i.a(this.l, "updateStrategy");
        c0905i.a(this.m, "popTimes");
        c0905i.a(this.n, "popInterval");
        c0905i.a((AbstractC0909m) this.o, "diffApkInfo");
        c0905i.a(this.p, "netType");
        c0905i.a((Map) this.q, "reserved");
        c0905i.a(this.r, "strategyId");
        c0905i.a(this.s, "status");
        c0905i.a(this.t, "updateTime");
        c0905i.a(this.u, "updateType");
    }
}
