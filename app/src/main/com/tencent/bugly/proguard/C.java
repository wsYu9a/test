package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class C extends AbstractC0868m implements Cloneable {

    /* renamed from: a */
    static Map<String, String> f22574a = null;

    /* renamed from: b */
    static final /* synthetic */ boolean f22575b = true;

    /* renamed from: c */
    public int f22576c;

    /* renamed from: d */
    public String f22577d;

    /* renamed from: e */
    public long f22578e;

    /* renamed from: f */
    public Map<String, String> f22579f;

    public C() {
        this.f22576c = 0;
        this.f22577d = "";
        this.f22578e = 0L;
        this.f22579f = null;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0867l c0867l) {
        c0867l.a(this.f22576c, 0);
        String str = this.f22577d;
        if (str != null) {
            c0867l.a(str, 1);
        }
        c0867l.a(this.f22578e, 2);
        Map<String, String> map = this.f22579f;
        if (map != null) {
            c0867l.a((Map) map, 3);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f22575b) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C c10 = (C) obj;
        return C0869n.a(this.f22576c, c10.f22576c) && C0869n.a(this.f22577d, c10.f22577d) && C0869n.a(this.f22578e, c10.f22578e) && C0869n.a(this.f22579f, c10.f22579f);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public C(int i10, String str, long j10, Map<String, String> map) {
        this.f22576c = i10;
        this.f22577d = str;
        this.f22578e = j10;
        this.f22579f = map;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        this.f22576c = c0866k.a(this.f22576c, 0, false);
        this.f22577d = c0866k.a(1, false);
        this.f22578e = c0866k.a(this.f22578e, 2, false);
        if (f22574a == null) {
            HashMap hashMap = new HashMap();
            f22574a = hashMap;
            hashMap.put("", "");
        }
        this.f22579f = (Map) c0866k.a((C0866k) f22574a, 3, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(StringBuilder sb2, int i10) {
        C0864i c0864i = new C0864i(sb2, i10);
        c0864i.a(this.f22576c, "flag");
        c0864i.a(this.f22577d, "localStrategyId");
        c0864i.a(this.f22578e, "localStrategyTime");
        c0864i.a((Map) this.f22579f, "reserved");
    }
}
