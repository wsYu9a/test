package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.z */
/* loaded from: classes4.dex */
public final class C0921z extends AbstractC0909m implements Cloneable {

    /* renamed from: a */
    static C0920y f25192a;

    /* renamed from: b */
    static Map<String, String> f25193b;

    /* renamed from: c */
    static final /* synthetic */ boolean f25194c = true;

    /* renamed from: d */
    public String f25195d;

    /* renamed from: e */
    public long f25196e;

    /* renamed from: f */
    public byte f25197f;

    /* renamed from: g */
    public long f25198g;

    /* renamed from: h */
    public C0920y f25199h;

    /* renamed from: i */
    public String f25200i;

    /* renamed from: j */
    public int f25201j;
    public Map<String, String> k;

    public C0921z() {
        this.f25195d = "";
        this.f25196e = 0L;
        this.f25197f = (byte) 0;
        this.f25198g = 0L;
        this.f25199h = null;
        this.f25200i = "";
        this.f25201j = 0;
        this.k = null;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0908l c0908l) {
        c0908l.a(this.f25195d, 0);
        c0908l.a(this.f25196e, 1);
        c0908l.a(this.f25197f, 2);
        c0908l.a(this.f25198g, 3);
        C0920y c0920y = this.f25199h;
        if (c0920y != null) {
            c0908l.a((AbstractC0909m) c0920y, 4);
        }
        String str = this.f25200i;
        if (str != null) {
            c0908l.a(str, 5);
        }
        c0908l.a(this.f25201j, 6);
        Map<String, String> map = this.k;
        if (map != null) {
            c0908l.a((Map) map, 7);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f25194c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0921z c0921z = (C0921z) obj;
        return C0910n.a(this.f25195d, c0921z.f25195d) && C0910n.a(this.f25196e, c0921z.f25196e) && C0910n.a(this.f25197f, c0921z.f25197f) && C0910n.a(this.f25198g, c0921z.f25198g) && C0910n.a(this.f25199h, c0921z.f25199h) && C0910n.a(this.f25200i, c0921z.f25200i) && C0910n.a(this.f25201j, c0921z.f25201j) && C0910n.a(this.k, c0921z.k);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public C0921z(String str, long j2, byte b2, long j3, C0920y c0920y, String str2, int i2, Map<String, String> map) {
        this.f25195d = "";
        this.f25196e = 0L;
        this.f25197f = (byte) 0;
        this.f25198g = 0L;
        this.f25199h = null;
        this.f25200i = "";
        this.f25201j = 0;
        this.k = null;
        this.f25195d = str;
        this.f25196e = j2;
        this.f25197f = b2;
        this.f25198g = j3;
        this.f25199h = c0920y;
        this.f25200i = str2;
        this.f25201j = i2;
        this.k = map;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        this.f25195d = c0907k.a(0, true);
        this.f25196e = c0907k.a(this.f25196e, 1, true);
        this.f25197f = c0907k.a(this.f25197f, 2, true);
        this.f25198g = c0907k.a(this.f25198g, 3, false);
        if (f25192a == null) {
            f25192a = new C0920y();
        }
        this.f25199h = (C0920y) c0907k.a((AbstractC0909m) f25192a, 4, false);
        this.f25200i = c0907k.a(5, false);
        this.f25201j = c0907k.a(this.f25201j, 6, false);
        if (f25193b == null) {
            HashMap hashMap = new HashMap();
            f25193b = hashMap;
            hashMap.put("", "");
        }
        this.k = (Map) c0907k.a((C0907k) f25193b, 7, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(StringBuilder sb, int i2) {
        C0905i c0905i = new C0905i(sb, i2);
        c0905i.a(this.f25195d, "eventType");
        c0905i.a(this.f25196e, "eventTime");
        c0905i.a(this.f25197f, "eventResult");
        c0905i.a(this.f25198g, "eventElapse");
        c0905i.a((AbstractC0909m) this.f25199h, "destAppInfo");
        c0905i.a(this.f25200i, "strategyId");
        c0905i.a(this.f25201j, "updateType");
        c0905i.a((Map) this.k, "reserved");
    }
}
