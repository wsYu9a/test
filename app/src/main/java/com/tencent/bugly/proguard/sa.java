package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class sa extends AbstractC0868m implements Cloneable {

    /* renamed from: a */
    static ra f22850a = new ra();

    /* renamed from: b */
    static Map<String, String> f22851b = null;

    /* renamed from: c */
    static final /* synthetic */ boolean f22852c = true;

    /* renamed from: d */
    public boolean f22853d = true;

    /* renamed from: e */
    public boolean f22854e = true;

    /* renamed from: f */
    public boolean f22855f = true;

    /* renamed from: g */
    public String f22856g = "";

    /* renamed from: h */
    public String f22857h = "";

    /* renamed from: i */
    public ra f22858i = null;

    /* renamed from: j */
    public Map<String, String> f22859j = null;

    /* renamed from: k */
    public long f22860k = 0;

    /* renamed from: l */
    public String f22861l = "";

    /* renamed from: m */
    public String f22862m = "";

    /* renamed from: n */
    public int f22863n = 0;

    /* renamed from: o */
    public int f22864o = 0;

    static {
        HashMap hashMap = new HashMap();
        f22851b = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0867l c0867l) {
        c0867l.a(this.f22853d, 0);
        c0867l.a(this.f22854e, 1);
        c0867l.a(this.f22855f, 2);
        String str = this.f22856g;
        if (str != null) {
            c0867l.a(str, 3);
        }
        String str2 = this.f22857h;
        if (str2 != null) {
            c0867l.a(str2, 4);
        }
        ra raVar = this.f22858i;
        if (raVar != null) {
            c0867l.a((AbstractC0868m) raVar, 5);
        }
        Map<String, String> map = this.f22859j;
        if (map != null) {
            c0867l.a((Map) map, 6);
        }
        c0867l.a(this.f22860k, 7);
        String str3 = this.f22861l;
        if (str3 != null) {
            c0867l.a(str3, 8);
        }
        String str4 = this.f22862m;
        if (str4 != null) {
            c0867l.a(str4, 9);
        }
        c0867l.a(this.f22863n, 10);
        c0867l.a(this.f22864o, 11);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f22852c) {
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
        return C0869n.a(this.f22853d, saVar.f22853d) && C0869n.a(this.f22854e, saVar.f22854e) && C0869n.a(this.f22855f, saVar.f22855f) && C0869n.a(this.f22856g, saVar.f22856g) && C0869n.a(this.f22857h, saVar.f22857h) && C0869n.a(this.f22858i, saVar.f22858i) && C0869n.a(this.f22859j, saVar.f22859j) && C0869n.a(this.f22860k, saVar.f22860k) && C0869n.a(this.f22861l, saVar.f22861l) && C0869n.a(this.f22862m, saVar.f22862m) && C0869n.a(this.f22863n, saVar.f22863n) && C0869n.a(this.f22864o, saVar.f22864o);
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
    public void a(C0866k c0866k) {
        this.f22853d = c0866k.a(this.f22853d, 0, true);
        this.f22854e = c0866k.a(this.f22854e, 1, true);
        this.f22855f = c0866k.a(this.f22855f, 2, true);
        this.f22856g = c0866k.a(3, false);
        this.f22857h = c0866k.a(4, false);
        this.f22858i = (ra) c0866k.a((AbstractC0868m) f22850a, 5, false);
        this.f22859j = (Map) c0866k.a((C0866k) f22851b, 6, false);
        this.f22860k = c0866k.a(this.f22860k, 7, false);
        this.f22861l = c0866k.a(8, false);
        this.f22862m = c0866k.a(9, false);
        this.f22863n = c0866k.a(this.f22863n, 10, false);
        this.f22864o = c0866k.a(this.f22864o, 11, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(StringBuilder sb2, int i10) {
        C0864i c0864i = new C0864i(sb2, i10);
        c0864i.a(this.f22853d, "enable");
        c0864i.a(this.f22854e, "enableUserInfo");
        c0864i.a(this.f22855f, "enableQuery");
        c0864i.a(this.f22856g, "url");
        c0864i.a(this.f22857h, "expUrl");
        c0864i.a((AbstractC0868m) this.f22858i, "security");
        c0864i.a((Map) this.f22859j, "valueMap");
        c0864i.a(this.f22860k, "strategylastUpdateTime");
        c0864i.a(this.f22861l, "httpsUrl");
        c0864i.a(this.f22862m, "httpsExpUrl");
        c0864i.a(this.f22863n, "eventRecordCount");
        c0864i.a(this.f22864o, "eventTimeInterval");
    }
}
