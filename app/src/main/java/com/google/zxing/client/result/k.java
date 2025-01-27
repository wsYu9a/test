package com.google.zxing.client.result;

import java.util.Map;

/* loaded from: classes.dex */
public final class k extends q {

    /* renamed from: b */
    public static final String f8256b = "KG";

    /* renamed from: c */
    public static final String f8257c = "LB";

    /* renamed from: d */
    private final String f8258d;

    /* renamed from: e */
    private final String f8259e;

    /* renamed from: f */
    private final String f8260f;

    /* renamed from: g */
    private final String f8261g;

    /* renamed from: h */
    private final String f8262h;

    /* renamed from: i */
    private final String f8263i;

    /* renamed from: j */
    private final String f8264j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final Map<String, String> r;

    public k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(ParsedResultType.PRODUCT);
        this.f8258d = str;
        this.f8259e = str2;
        this.f8260f = str3;
        this.f8261g = str4;
        this.f8262h = str5;
        this.f8263i = str6;
        this.f8264j = str7;
        this.k = str8;
        this.l = str9;
        this.m = str10;
        this.n = str11;
        this.o = str12;
        this.p = str13;
        this.q = str14;
        this.r = map;
    }

    private static boolean d(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static int t(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        return String.valueOf(this.f8258d);
    }

    public String e() {
        return this.f8264j;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return d(this.f8259e, kVar.f8259e) && d(this.f8260f, kVar.f8260f) && d(this.f8261g, kVar.f8261g) && d(this.f8262h, kVar.f8262h) && d(this.f8264j, kVar.f8264j) && d(this.k, kVar.k) && d(this.l, kVar.l) && d(this.m, kVar.m) && d(this.n, kVar.n) && d(this.o, kVar.o) && d(this.p, kVar.p) && d(this.q, kVar.q) && d(this.r, kVar.r);
    }

    public String f() {
        return this.k;
    }

    public String g() {
        return this.f8261g;
    }

    public String h() {
        return this.f8263i;
    }

    public int hashCode() {
        return ((((((((((((t(this.f8259e) ^ 0) ^ t(this.f8260f)) ^ t(this.f8261g)) ^ t(this.f8262h)) ^ t(this.f8264j)) ^ t(this.k)) ^ t(this.l)) ^ t(this.m)) ^ t(this.n)) ^ t(this.o)) ^ t(this.p)) ^ t(this.q)) ^ t(this.r);
    }

    public String i() {
        return this.o;
    }

    public String j() {
        return this.q;
    }

    public String k() {
        return this.p;
    }

    public String l() {
        return this.f8259e;
    }

    public String m() {
        return this.f8262h;
    }

    public String n() {
        return this.f8258d;
    }

    public String o() {
        return this.f8260f;
    }

    public Map<String, String> p() {
        return this.r;
    }

    public String q() {
        return this.l;
    }

    public String r() {
        return this.n;
    }

    public String s() {
        return this.m;
    }
}
