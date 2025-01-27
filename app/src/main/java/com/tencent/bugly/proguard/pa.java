package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class pa extends AbstractC0909m {

    /* renamed from: a */
    static byte[] f25112a = {0};

    /* renamed from: b */
    static Map<String, String> f25113b;

    /* renamed from: c */
    public int f25114c = 0;

    /* renamed from: d */
    public String f25115d = "";

    /* renamed from: e */
    public String f25116e = "";

    /* renamed from: f */
    public String f25117f = "";

    /* renamed from: g */
    public String f25118g = "";

    /* renamed from: h */
    public String f25119h = "";

    /* renamed from: i */
    public int f25120i = 0;

    /* renamed from: j */
    public byte[] f25121j = null;
    public String k = "";
    public String l = "";
    public Map<String, String> m = null;
    public String n = "";
    public long o = 0;
    public String p = "";
    public String q = "";
    public String r = "";
    public long s = 0;
    public String t = "";
    public String u = "";
    public String v = "";
    public String w = "";
    public String x = "";
    public String y = "";
    public String z = "";

    static {
        HashMap hashMap = new HashMap();
        f25113b = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0908l c0908l) {
        c0908l.a(this.f25114c, 0);
        c0908l.a(this.f25115d, 1);
        c0908l.a(this.f25116e, 2);
        c0908l.a(this.f25117f, 3);
        String str = this.f25118g;
        if (str != null) {
            c0908l.a(str, 4);
        }
        c0908l.a(this.f25119h, 5);
        c0908l.a(this.f25120i, 6);
        c0908l.a(this.f25121j, 7);
        String str2 = this.k;
        if (str2 != null) {
            c0908l.a(str2, 8);
        }
        String str3 = this.l;
        if (str3 != null) {
            c0908l.a(str3, 9);
        }
        Map<String, String> map = this.m;
        if (map != null) {
            c0908l.a((Map) map, 10);
        }
        String str4 = this.n;
        if (str4 != null) {
            c0908l.a(str4, 11);
        }
        c0908l.a(this.o, 12);
        String str5 = this.p;
        if (str5 != null) {
            c0908l.a(str5, 13);
        }
        String str6 = this.q;
        if (str6 != null) {
            c0908l.a(str6, 14);
        }
        String str7 = this.r;
        if (str7 != null) {
            c0908l.a(str7, 15);
        }
        c0908l.a(this.s, 16);
        String str8 = this.t;
        if (str8 != null) {
            c0908l.a(str8, 17);
        }
        String str9 = this.u;
        if (str9 != null) {
            c0908l.a(str9, 18);
        }
        String str10 = this.v;
        if (str10 != null) {
            c0908l.a(str10, 19);
        }
        String str11 = this.w;
        if (str11 != null) {
            c0908l.a(str11, 20);
        }
        String str12 = this.x;
        if (str12 != null) {
            c0908l.a(str12, 21);
        }
        String str13 = this.y;
        if (str13 != null) {
            c0908l.a(str13, 22);
        }
        String str14 = this.z;
        if (str14 != null) {
            c0908l.a(str14, 23);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        this.f25114c = c0907k.a(this.f25114c, 0, true);
        this.f25115d = c0907k.a(1, true);
        this.f25116e = c0907k.a(2, true);
        this.f25117f = c0907k.a(3, true);
        this.f25118g = c0907k.a(4, false);
        this.f25119h = c0907k.a(5, true);
        this.f25120i = c0907k.a(this.f25120i, 6, true);
        this.f25121j = c0907k.a(f25112a, 7, true);
        this.k = c0907k.a(8, false);
        this.l = c0907k.a(9, false);
        this.m = (Map) c0907k.a((C0907k) f25113b, 10, false);
        this.n = c0907k.a(11, false);
        this.o = c0907k.a(this.o, 12, false);
        this.p = c0907k.a(13, false);
        this.q = c0907k.a(14, false);
        this.r = c0907k.a(15, false);
        this.s = c0907k.a(this.s, 16, false);
        this.t = c0907k.a(17, false);
        this.u = c0907k.a(18, false);
        this.v = c0907k.a(19, false);
        this.w = c0907k.a(20, false);
        this.x = c0907k.a(21, false);
        this.y = c0907k.a(22, false);
        this.z = c0907k.a(23, false);
    }
}
