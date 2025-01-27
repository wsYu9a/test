package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.z */
/* loaded from: classes4.dex */
public final class C0880z extends AbstractC0868m implements Cloneable {

    /* renamed from: a */
    static C0879y f22906a = null;

    /* renamed from: b */
    static Map<String, String> f22907b = null;

    /* renamed from: c */
    static final /* synthetic */ boolean f22908c = true;

    /* renamed from: d */
    public String f22909d;

    /* renamed from: e */
    public long f22910e;

    /* renamed from: f */
    public byte f22911f;

    /* renamed from: g */
    public long f22912g;

    /* renamed from: h */
    public C0879y f22913h;

    /* renamed from: i */
    public String f22914i;

    /* renamed from: j */
    public int f22915j;

    /* renamed from: k */
    public Map<String, String> f22916k;

    public C0880z() {
        this.f22909d = "";
        this.f22910e = 0L;
        this.f22911f = (byte) 0;
        this.f22912g = 0L;
        this.f22913h = null;
        this.f22914i = "";
        this.f22915j = 0;
        this.f22916k = null;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0867l c0867l) {
        c0867l.a(this.f22909d, 0);
        c0867l.a(this.f22910e, 1);
        c0867l.a(this.f22911f, 2);
        c0867l.a(this.f22912g, 3);
        C0879y c0879y = this.f22913h;
        if (c0879y != null) {
            c0867l.a((AbstractC0868m) c0879y, 4);
        }
        String str = this.f22914i;
        if (str != null) {
            c0867l.a(str, 5);
        }
        c0867l.a(this.f22915j, 6);
        Map<String, String> map = this.f22916k;
        if (map != null) {
            c0867l.a((Map) map, 7);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f22908c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0880z c0880z = (C0880z) obj;
        return C0869n.a(this.f22909d, c0880z.f22909d) && C0869n.a(this.f22910e, c0880z.f22910e) && C0869n.a(this.f22911f, c0880z.f22911f) && C0869n.a(this.f22912g, c0880z.f22912g) && C0869n.a(this.f22913h, c0880z.f22913h) && C0869n.a(this.f22914i, c0880z.f22914i) && C0869n.a(this.f22915j, c0880z.f22915j) && C0869n.a(this.f22916k, c0880z.f22916k);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public C0880z(String str, long j10, byte b10, long j11, C0879y c0879y, String str2, int i10, Map<String, String> map) {
        this.f22909d = str;
        this.f22910e = j10;
        this.f22911f = b10;
        this.f22912g = j11;
        this.f22913h = c0879y;
        this.f22914i = str2;
        this.f22915j = i10;
        this.f22916k = map;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        this.f22909d = c0866k.a(0, true);
        this.f22910e = c0866k.a(this.f22910e, 1, true);
        this.f22911f = c0866k.a(this.f22911f, 2, true);
        this.f22912g = c0866k.a(this.f22912g, 3, false);
        if (f22906a == null) {
            f22906a = new C0879y();
        }
        this.f22913h = (C0879y) c0866k.a((AbstractC0868m) f22906a, 4, false);
        this.f22914i = c0866k.a(5, false);
        this.f22915j = c0866k.a(this.f22915j, 6, false);
        if (f22907b == null) {
            HashMap hashMap = new HashMap();
            f22907b = hashMap;
            hashMap.put("", "");
        }
        this.f22916k = (Map) c0866k.a((C0866k) f22907b, 7, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(StringBuilder sb2, int i10) {
        C0864i c0864i = new C0864i(sb2, i10);
        c0864i.a(this.f22909d, "eventType");
        c0864i.a(this.f22910e, b7.e.f1383n);
        c0864i.a(this.f22911f, "eventResult");
        c0864i.a(this.f22912g, "eventElapse");
        c0864i.a((AbstractC0868m) this.f22913h, "destAppInfo");
        c0864i.a(this.f22914i, "strategyId");
        c0864i.a(this.f22915j, "updateType");
        c0864i.a((Map) this.f22916k, "reserved");
    }
}
