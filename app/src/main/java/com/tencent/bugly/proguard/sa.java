package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class sa extends AbstractC0909m implements Cloneable {

    /* renamed from: b */
    static Map<String, String> f25147b;

    /* renamed from: d */
    public boolean f25149d = true;

    /* renamed from: e */
    public boolean f25150e = true;

    /* renamed from: f */
    public boolean f25151f = true;

    /* renamed from: g */
    public String f25152g = "";

    /* renamed from: h */
    public String f25153h = "";

    /* renamed from: i */
    public ra f25154i = null;

    /* renamed from: j */
    public Map<String, String> f25155j = null;
    public long k = 0;
    public String l = "";
    public String m = "";
    public int n = 0;
    public int o = 0;

    /* renamed from: c */
    static final /* synthetic */ boolean f25148c = true;

    /* renamed from: a */
    static ra f25146a = new ra();

    static {
        HashMap hashMap = new HashMap();
        f25147b = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0908l c0908l) {
        c0908l.a(this.f25149d, 0);
        c0908l.a(this.f25150e, 1);
        c0908l.a(this.f25151f, 2);
        String str = this.f25152g;
        if (str != null) {
            c0908l.a(str, 3);
        }
        String str2 = this.f25153h;
        if (str2 != null) {
            c0908l.a(str2, 4);
        }
        ra raVar = this.f25154i;
        if (raVar != null) {
            c0908l.a((AbstractC0909m) raVar, 5);
        }
        Map<String, String> map = this.f25155j;
        if (map != null) {
            c0908l.a((Map) map, 6);
        }
        c0908l.a(this.k, 7);
        String str3 = this.l;
        if (str3 != null) {
            c0908l.a(str3, 8);
        }
        String str4 = this.m;
        if (str4 != null) {
            c0908l.a(str4, 9);
        }
        c0908l.a(this.n, 10);
        c0908l.a(this.o, 11);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f25148c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        sa saVar = (sa) obj;
        return C0910n.a(this.f25149d, saVar.f25149d) && C0910n.a(this.f25150e, saVar.f25150e) && C0910n.a(this.f25151f, saVar.f25151f) && C0910n.a(this.f25152g, saVar.f25152g) && C0910n.a(this.f25153h, saVar.f25153h) && C0910n.a(this.f25154i, saVar.f25154i) && C0910n.a(this.f25155j, saVar.f25155j) && C0910n.a(this.k, saVar.k) && C0910n.a(this.l, saVar.l) && C0910n.a(this.m, saVar.m) && C0910n.a(this.n, saVar.n) && C0910n.a(this.o, saVar.o);
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
    public void a(C0907k c0907k) {
        this.f25149d = c0907k.a(this.f25149d, 0, true);
        this.f25150e = c0907k.a(this.f25150e, 1, true);
        this.f25151f = c0907k.a(this.f25151f, 2, true);
        this.f25152g = c0907k.a(3, false);
        this.f25153h = c0907k.a(4, false);
        this.f25154i = (ra) c0907k.a((AbstractC0909m) f25146a, 5, false);
        this.f25155j = (Map) c0907k.a((C0907k) f25147b, 6, false);
        this.k = c0907k.a(this.k, 7, false);
        this.l = c0907k.a(8, false);
        this.m = c0907k.a(9, false);
        this.n = c0907k.a(this.n, 10, false);
        this.o = c0907k.a(this.o, 11, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(StringBuilder sb, int i2) {
        C0905i c0905i = new C0905i(sb, i2);
        c0905i.a(this.f25149d, "enable");
        c0905i.a(this.f25150e, "enableUserInfo");
        c0905i.a(this.f25151f, "enableQuery");
        c0905i.a(this.f25152g, "url");
        c0905i.a(this.f25153h, "expUrl");
        c0905i.a((AbstractC0909m) this.f25154i, "security");
        c0905i.a((Map) this.f25155j, "valueMap");
        c0905i.a(this.k, "strategylastUpdateTime");
        c0905i.a(this.l, "httpsUrl");
        c0905i.a(this.m, "httpsExpUrl");
        c0905i.a(this.n, "eventRecordCount");
        c0905i.a(this.o, "eventTimeInterval");
    }
}
