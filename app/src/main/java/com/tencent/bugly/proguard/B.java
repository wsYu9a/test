package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class B extends AbstractC0868m implements Cloneable {

    /* renamed from: a */
    static C0879y f22553a = null;

    /* renamed from: b */
    static C0878x f22554b = null;

    /* renamed from: c */
    static C0878x f22555c = null;

    /* renamed from: d */
    static Map<String, String> f22556d = null;

    /* renamed from: e */
    static final /* synthetic */ boolean f22557e = true;

    /* renamed from: f */
    public String f22558f;

    /* renamed from: g */
    public String f22559g;

    /* renamed from: h */
    public long f22560h;

    /* renamed from: i */
    public int f22561i;

    /* renamed from: j */
    public C0879y f22562j;

    /* renamed from: k */
    public C0878x f22563k;

    /* renamed from: l */
    public byte f22564l;

    /* renamed from: m */
    public int f22565m;

    /* renamed from: n */
    public long f22566n;

    /* renamed from: o */
    public C0878x f22567o;

    /* renamed from: p */
    public String f22568p;

    /* renamed from: q */
    public Map<String, String> f22569q;

    /* renamed from: r */
    public String f22570r;

    /* renamed from: s */
    public int f22571s;

    /* renamed from: t */
    public long f22572t;

    /* renamed from: u */
    public int f22573u;

    public B() {
        this.f22558f = "";
        this.f22559g = "";
        this.f22560h = 0L;
        this.f22561i = 0;
        this.f22562j = null;
        this.f22563k = null;
        this.f22564l = (byte) 0;
        this.f22565m = 0;
        this.f22566n = 0L;
        this.f22567o = null;
        this.f22568p = "";
        this.f22569q = null;
        this.f22570r = "";
        this.f22571s = 0;
        this.f22572t = 0L;
        this.f22573u = 0;
    }

    public C0878x a() {
        return this.f22563k;
    }

    public long b() {
        return this.f22560h;
    }

    public Map<String, String> c() {
        return this.f22569q;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f22557e) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        B b10 = (B) obj;
        return C0869n.a(this.f22558f, b10.f22558f) && C0869n.a(this.f22559g, b10.f22559g) && C0869n.a(this.f22560h, b10.f22560h) && C0869n.a(this.f22561i, b10.f22561i) && C0869n.a(this.f22562j, b10.f22562j) && C0869n.a(this.f22563k, b10.f22563k) && C0869n.a(this.f22564l, b10.f22564l) && C0869n.a(this.f22565m, b10.f22565m) && C0869n.a(this.f22566n, b10.f22566n) && C0869n.a(this.f22567o, b10.f22567o) && C0869n.a(this.f22568p, b10.f22568p) && C0869n.a(this.f22569q, b10.f22569q) && C0869n.a(this.f22570r, b10.f22570r) && C0869n.a(this.f22571s, b10.f22571s) && C0869n.a(this.f22572t, b10.f22572t) && C0869n.a(this.f22573u, b10.f22573u);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0867l c0867l) {
        c0867l.a(this.f22558f, 0);
        c0867l.a(this.f22559g, 1);
        c0867l.a(this.f22560h, 2);
        c0867l.a(this.f22561i, 3);
        c0867l.a((AbstractC0868m) this.f22562j, 4);
        c0867l.a((AbstractC0868m) this.f22563k, 5);
        c0867l.a(this.f22564l, 6);
        c0867l.a(this.f22565m, 7);
        c0867l.a(this.f22566n, 8);
        C0878x c0878x = this.f22567o;
        if (c0878x != null) {
            c0867l.a((AbstractC0868m) c0878x, 9);
        }
        String str = this.f22568p;
        if (str != null) {
            c0867l.a(str, 10);
        }
        Map<String, String> map = this.f22569q;
        if (map != null) {
            c0867l.a((Map) map, 11);
        }
        String str2 = this.f22570r;
        if (str2 != null) {
            c0867l.a(str2, 12);
        }
        c0867l.a(this.f22571s, 13);
        c0867l.a(this.f22572t, 14);
        c0867l.a(this.f22573u, 15);
    }

    public B(String str, String str2, long j10, int i10, C0879y c0879y, C0878x c0878x, byte b10, int i11, long j11, C0878x c0878x2, String str3, Map<String, String> map, String str4, int i12, long j12, int i13) {
        this.f22558f = str;
        this.f22559g = str2;
        this.f22560h = j10;
        this.f22561i = i10;
        this.f22562j = c0879y;
        this.f22563k = c0878x;
        this.f22564l = b10;
        this.f22565m = i11;
        this.f22566n = j11;
        this.f22567o = c0878x2;
        this.f22568p = str3;
        this.f22569q = map;
        this.f22570r = str4;
        this.f22571s = i12;
        this.f22572t = j12;
        this.f22573u = i13;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        this.f22558f = c0866k.a(0, true);
        this.f22559g = c0866k.a(1, true);
        this.f22560h = c0866k.a(this.f22560h, 2, true);
        this.f22561i = c0866k.a(this.f22561i, 3, true);
        if (f22553a == null) {
            f22553a = new C0879y();
        }
        this.f22562j = (C0879y) c0866k.a((AbstractC0868m) f22553a, 4, true);
        if (f22554b == null) {
            f22554b = new C0878x();
        }
        this.f22563k = (C0878x) c0866k.a((AbstractC0868m) f22554b, 5, true);
        this.f22564l = c0866k.a(this.f22564l, 6, true);
        this.f22565m = c0866k.a(this.f22565m, 7, false);
        this.f22566n = c0866k.a(this.f22566n, 8, false);
        if (f22555c == null) {
            f22555c = new C0878x();
        }
        this.f22567o = (C0878x) c0866k.a((AbstractC0868m) f22555c, 9, false);
        this.f22568p = c0866k.a(10, false);
        if (f22556d == null) {
            HashMap hashMap = new HashMap();
            f22556d = hashMap;
            hashMap.put("", "");
        }
        this.f22569q = (Map) c0866k.a((C0866k) f22556d, 11, false);
        this.f22570r = c0866k.a(12, false);
        this.f22571s = c0866k.a(this.f22571s, 13, false);
        this.f22572t = c0866k.a(this.f22572t, 14, false);
        this.f22573u = c0866k.a(this.f22573u, 15, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(StringBuilder sb2, int i10) {
        C0864i c0864i = new C0864i(sb2, i10);
        c0864i.a(this.f22558f, "title");
        c0864i.a(this.f22559g, "newFeature");
        c0864i.a(this.f22560h, "publishTime");
        c0864i.a(this.f22561i, "publishType");
        c0864i.a((AbstractC0868m) this.f22562j, "appBasicInfo");
        c0864i.a((AbstractC0868m) this.f22563k, "apkBaseInfo");
        c0864i.a(this.f22564l, "updateStrategy");
        c0864i.a(this.f22565m, "popTimes");
        c0864i.a(this.f22566n, "popInterval");
        c0864i.a((AbstractC0868m) this.f22567o, "diffApkInfo");
        c0864i.a(this.f22568p, "netType");
        c0864i.a((Map) this.f22569q, "reserved");
        c0864i.a(this.f22570r, "strategyId");
        c0864i.a(this.f22571s, "status");
        c0864i.a(this.f22572t, "updateTime");
        c0864i.a(this.f22573u, "updateType");
    }
}
