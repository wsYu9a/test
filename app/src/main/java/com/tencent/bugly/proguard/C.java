package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class C extends AbstractC0909m implements Cloneable {

    /* renamed from: a */
    static Map<String, String> f24933a;

    /* renamed from: b */
    static final /* synthetic */ boolean f24934b = true;

    /* renamed from: c */
    public int f24935c;

    /* renamed from: d */
    public String f24936d;

    /* renamed from: e */
    public long f24937e;

    /* renamed from: f */
    public Map<String, String> f24938f;

    public C() {
        this.f24935c = 0;
        this.f24936d = "";
        this.f24937e = 0L;
        this.f24938f = null;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0908l c0908l) {
        c0908l.a(this.f24935c, 0);
        String str = this.f24936d;
        if (str != null) {
            c0908l.a(str, 1);
        }
        c0908l.a(this.f24937e, 2);
        Map<String, String> map = this.f24938f;
        if (map != null) {
            c0908l.a((Map) map, 3);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f24934b) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C c2 = (C) obj;
        return C0910n.a(this.f24935c, c2.f24935c) && C0910n.a(this.f24936d, c2.f24936d) && C0910n.a(this.f24937e, c2.f24937e) && C0910n.a(this.f24938f, c2.f24938f);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public C(int i2, String str, long j2, Map<String, String> map) {
        this.f24935c = 0;
        this.f24936d = "";
        this.f24937e = 0L;
        this.f24938f = null;
        this.f24935c = i2;
        this.f24936d = str;
        this.f24937e = j2;
        this.f24938f = map;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        this.f24935c = c0907k.a(this.f24935c, 0, false);
        this.f24936d = c0907k.a(1, false);
        this.f24937e = c0907k.a(this.f24937e, 2, false);
        if (f24933a == null) {
            HashMap hashMap = new HashMap();
            f24933a = hashMap;
            hashMap.put("", "");
        }
        this.f24938f = (Map) c0907k.a((C0907k) f24933a, 3, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(StringBuilder sb, int i2) {
        C0905i c0905i = new C0905i(sb, i2);
        c0905i.a(this.f24935c, "flag");
        c0905i.a(this.f24936d, "localStrategyId");
        c0905i.a(this.f24937e, "localStrategyTime");
        c0905i.a((Map) this.f24938f, "reserved");
    }
}
