package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class na extends AbstractC0909m {

    /* renamed from: a */
    static Map<String, String> f25099a;

    /* renamed from: b */
    static la f25100b;

    /* renamed from: c */
    static ka f25101c;

    /* renamed from: d */
    static ArrayList<ka> f25102d;

    /* renamed from: e */
    static ArrayList<ka> f25103e;

    /* renamed from: f */
    static ArrayList<ma> f25104f;

    /* renamed from: g */
    static Map<String, String> f25105g;

    /* renamed from: h */
    static Map<String, String> f25106h;

    /* renamed from: i */
    public String f25107i = "";

    /* renamed from: j */
    public long f25108j = 0;
    public String k = "";
    public String l = "";
    public String m = "";
    public String n = "";
    public String o = "";
    public Map<String, String> p = null;
    public String q = "";
    public la r = null;
    public int s = 0;
    public String t = "";
    public String u = "";
    public ka v = null;
    public ArrayList<ka> w = null;
    public ArrayList<ka> x = null;
    public ArrayList<ma> y = null;
    public Map<String, String> z = null;
    public Map<String, String> A = null;
    public String B = "";
    public boolean C = true;

    static {
        HashMap hashMap = new HashMap();
        f25099a = hashMap;
        hashMap.put("", "");
        f25100b = new la();
        f25101c = new ka();
        f25102d = new ArrayList<>();
        f25102d.add(new ka());
        f25103e = new ArrayList<>();
        f25103e.add(new ka());
        f25104f = new ArrayList<>();
        f25104f.add(new ma());
        HashMap hashMap2 = new HashMap();
        f25105g = hashMap2;
        hashMap2.put("", "");
        HashMap hashMap3 = new HashMap();
        f25106h = hashMap3;
        hashMap3.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0908l c0908l) {
        c0908l.a(this.f25107i, 0);
        c0908l.a(this.f25108j, 1);
        c0908l.a(this.k, 2);
        String str = this.l;
        if (str != null) {
            c0908l.a(str, 3);
        }
        String str2 = this.m;
        if (str2 != null) {
            c0908l.a(str2, 4);
        }
        String str3 = this.n;
        if (str3 != null) {
            c0908l.a(str3, 5);
        }
        String str4 = this.o;
        if (str4 != null) {
            c0908l.a(str4, 6);
        }
        Map<String, String> map = this.p;
        if (map != null) {
            c0908l.a((Map) map, 7);
        }
        String str5 = this.q;
        if (str5 != null) {
            c0908l.a(str5, 8);
        }
        la laVar = this.r;
        if (laVar != null) {
            c0908l.a((AbstractC0909m) laVar, 9);
        }
        c0908l.a(this.s, 10);
        String str6 = this.t;
        if (str6 != null) {
            c0908l.a(str6, 11);
        }
        String str7 = this.u;
        if (str7 != null) {
            c0908l.a(str7, 12);
        }
        ka kaVar = this.v;
        if (kaVar != null) {
            c0908l.a((AbstractC0909m) kaVar, 13);
        }
        ArrayList<ka> arrayList = this.w;
        if (arrayList != null) {
            c0908l.a((Collection) arrayList, 14);
        }
        ArrayList<ka> arrayList2 = this.x;
        if (arrayList2 != null) {
            c0908l.a((Collection) arrayList2, 15);
        }
        ArrayList<ma> arrayList3 = this.y;
        if (arrayList3 != null) {
            c0908l.a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.z;
        if (map2 != null) {
            c0908l.a((Map) map2, 17);
        }
        Map<String, String> map3 = this.A;
        if (map3 != null) {
            c0908l.a((Map) map3, 18);
        }
        String str8 = this.B;
        if (str8 != null) {
            c0908l.a(str8, 19);
        }
        c0908l.a(this.C, 20);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        this.f25107i = c0907k.a(0, true);
        this.f25108j = c0907k.a(this.f25108j, 1, true);
        this.k = c0907k.a(2, true);
        this.l = c0907k.a(3, false);
        this.m = c0907k.a(4, false);
        this.n = c0907k.a(5, false);
        this.o = c0907k.a(6, false);
        this.p = (Map) c0907k.a((C0907k) f25099a, 7, false);
        this.q = c0907k.a(8, false);
        this.r = (la) c0907k.a((AbstractC0909m) f25100b, 9, false);
        this.s = c0907k.a(this.s, 10, false);
        this.t = c0907k.a(11, false);
        this.u = c0907k.a(12, false);
        this.v = (ka) c0907k.a((AbstractC0909m) f25101c, 13, false);
        this.w = (ArrayList) c0907k.a((C0907k) f25102d, 14, false);
        this.x = (ArrayList) c0907k.a((C0907k) f25103e, 15, false);
        this.y = (ArrayList) c0907k.a((C0907k) f25104f, 16, false);
        this.z = (Map) c0907k.a((C0907k) f25105g, 17, false);
        this.A = (Map) c0907k.a((C0907k) f25106h, 18, false);
        this.B = c0907k.a(19, false);
        this.C = c0907k.a(this.C, 20, false);
    }
}
