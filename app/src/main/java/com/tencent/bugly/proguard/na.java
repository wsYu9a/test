package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class na extends AbstractC0868m {

    /* renamed from: a */
    static Map<String, String> f22771a;

    /* renamed from: b */
    static la f22772b;

    /* renamed from: c */
    static ka f22773c;

    /* renamed from: d */
    static ArrayList<ka> f22774d;

    /* renamed from: e */
    static ArrayList<ka> f22775e;

    /* renamed from: f */
    static ArrayList<ma> f22776f;

    /* renamed from: g */
    static Map<String, String> f22777g;

    /* renamed from: h */
    static Map<String, String> f22778h;

    /* renamed from: i */
    public String f22779i = "";

    /* renamed from: j */
    public long f22780j = 0;

    /* renamed from: k */
    public String f22781k = "";

    /* renamed from: l */
    public String f22782l = "";

    /* renamed from: m */
    public String f22783m = "";

    /* renamed from: n */
    public String f22784n = "";

    /* renamed from: o */
    public String f22785o = "";

    /* renamed from: p */
    public Map<String, String> f22786p = null;

    /* renamed from: q */
    public String f22787q = "";

    /* renamed from: r */
    public la f22788r = null;

    /* renamed from: s */
    public int f22789s = 0;

    /* renamed from: t */
    public String f22790t = "";

    /* renamed from: u */
    public String f22791u = "";

    /* renamed from: v */
    public ka f22792v = null;

    /* renamed from: w */
    public ArrayList<ka> f22793w = null;

    /* renamed from: x */
    public ArrayList<ka> f22794x = null;

    /* renamed from: y */
    public ArrayList<ma> f22795y = null;

    /* renamed from: z */
    public Map<String, String> f22796z = null;
    public Map<String, String> A = null;
    public String B = "";
    public boolean C = true;

    static {
        HashMap hashMap = new HashMap();
        f22771a = hashMap;
        hashMap.put("", "");
        f22772b = new la();
        f22773c = new ka();
        f22774d = new ArrayList<>();
        f22774d.add(new ka());
        f22775e = new ArrayList<>();
        f22775e.add(new ka());
        f22776f = new ArrayList<>();
        f22776f.add(new ma());
        HashMap hashMap2 = new HashMap();
        f22777g = hashMap2;
        hashMap2.put("", "");
        HashMap hashMap3 = new HashMap();
        f22778h = hashMap3;
        hashMap3.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0867l c0867l) {
        c0867l.a(this.f22779i, 0);
        c0867l.a(this.f22780j, 1);
        c0867l.a(this.f22781k, 2);
        String str = this.f22782l;
        if (str != null) {
            c0867l.a(str, 3);
        }
        String str2 = this.f22783m;
        if (str2 != null) {
            c0867l.a(str2, 4);
        }
        String str3 = this.f22784n;
        if (str3 != null) {
            c0867l.a(str3, 5);
        }
        String str4 = this.f22785o;
        if (str4 != null) {
            c0867l.a(str4, 6);
        }
        Map<String, String> map = this.f22786p;
        if (map != null) {
            c0867l.a((Map) map, 7);
        }
        String str5 = this.f22787q;
        if (str5 != null) {
            c0867l.a(str5, 8);
        }
        la laVar = this.f22788r;
        if (laVar != null) {
            c0867l.a((AbstractC0868m) laVar, 9);
        }
        c0867l.a(this.f22789s, 10);
        String str6 = this.f22790t;
        if (str6 != null) {
            c0867l.a(str6, 11);
        }
        String str7 = this.f22791u;
        if (str7 != null) {
            c0867l.a(str7, 12);
        }
        ka kaVar = this.f22792v;
        if (kaVar != null) {
            c0867l.a((AbstractC0868m) kaVar, 13);
        }
        ArrayList<ka> arrayList = this.f22793w;
        if (arrayList != null) {
            c0867l.a((Collection) arrayList, 14);
        }
        ArrayList<ka> arrayList2 = this.f22794x;
        if (arrayList2 != null) {
            c0867l.a((Collection) arrayList2, 15);
        }
        ArrayList<ma> arrayList3 = this.f22795y;
        if (arrayList3 != null) {
            c0867l.a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.f22796z;
        if (map2 != null) {
            c0867l.a((Map) map2, 17);
        }
        Map<String, String> map3 = this.A;
        if (map3 != null) {
            c0867l.a((Map) map3, 18);
        }
        String str8 = this.B;
        if (str8 != null) {
            c0867l.a(str8, 19);
        }
        c0867l.a(this.C, 20);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        this.f22779i = c0866k.a(0, true);
        this.f22780j = c0866k.a(this.f22780j, 1, true);
        this.f22781k = c0866k.a(2, true);
        this.f22782l = c0866k.a(3, false);
        this.f22783m = c0866k.a(4, false);
        this.f22784n = c0866k.a(5, false);
        this.f22785o = c0866k.a(6, false);
        this.f22786p = (Map) c0866k.a((C0866k) f22771a, 7, false);
        this.f22787q = c0866k.a(8, false);
        this.f22788r = (la) c0866k.a((AbstractC0868m) f22772b, 9, false);
        this.f22789s = c0866k.a(this.f22789s, 10, false);
        this.f22790t = c0866k.a(11, false);
        this.f22791u = c0866k.a(12, false);
        this.f22792v = (ka) c0866k.a((AbstractC0868m) f22773c, 13, false);
        this.f22793w = (ArrayList) c0866k.a((C0866k) f22774d, 14, false);
        this.f22794x = (ArrayList) c0866k.a((C0866k) f22775e, 15, false);
        this.f22795y = (ArrayList) c0866k.a((C0866k) f22776f, 16, false);
        this.f22796z = (Map) c0866k.a((C0866k) f22777g, 17, false);
        this.A = (Map) c0866k.a((C0866k) f22778h, 18, false);
        this.B = c0866k.a(19, false);
        this.C = c0866k.a(this.C, 20, false);
    }
}
