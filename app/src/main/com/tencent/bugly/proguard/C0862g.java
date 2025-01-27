package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.g */
/* loaded from: classes4.dex */
public final class C0862g extends AbstractC0868m {

    /* renamed from: a */
    static byte[] f22736a = null;

    /* renamed from: b */
    static Map<String, String> f22737b = null;

    /* renamed from: c */
    static final /* synthetic */ boolean f22738c = true;

    /* renamed from: j */
    public byte[] f22745j;

    /* renamed from: l */
    public Map<String, String> f22747l;

    /* renamed from: m */
    public Map<String, String> f22748m;

    /* renamed from: d */
    public short f22739d = 0;

    /* renamed from: e */
    public byte f22740e = 0;

    /* renamed from: f */
    public int f22741f = 0;

    /* renamed from: g */
    public int f22742g = 0;

    /* renamed from: h */
    public String f22743h = null;

    /* renamed from: i */
    public String f22744i = null;

    /* renamed from: k */
    public int f22746k = 0;

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0867l c0867l) {
        c0867l.a(this.f22739d, 1);
        c0867l.a(this.f22740e, 2);
        c0867l.a(this.f22741f, 3);
        c0867l.a(this.f22742g, 4);
        c0867l.a(this.f22743h, 5);
        c0867l.a(this.f22744i, 6);
        c0867l.a(this.f22745j, 7);
        c0867l.a(this.f22746k, 8);
        c0867l.a((Map) this.f22747l, 9);
        c0867l.a((Map) this.f22748m, 10);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f22738c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        C0862g c0862g = (C0862g) obj;
        return C0869n.a(1, (int) c0862g.f22739d) && C0869n.a(1, (int) c0862g.f22740e) && C0869n.a(1, c0862g.f22741f) && C0869n.a(1, c0862g.f22742g) && C0869n.a((Object) 1, (Object) c0862g.f22743h) && C0869n.a((Object) 1, (Object) c0862g.f22744i) && C0869n.a((Object) 1, (Object) c0862g.f22745j) && C0869n.a(1, c0862g.f22746k) && C0869n.a((Object) 1, (Object) c0862g.f22747l) && C0869n.a((Object) 1, (Object) c0862g.f22748m);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        try {
            this.f22739d = c0866k.a(this.f22739d, 1, true);
            this.f22740e = c0866k.a(this.f22740e, 2, true);
            this.f22741f = c0866k.a(this.f22741f, 3, true);
            this.f22742g = c0866k.a(this.f22742g, 4, true);
            this.f22743h = c0866k.a(5, true);
            this.f22744i = c0866k.a(6, true);
            if (f22736a == null) {
                f22736a = new byte[]{0};
            }
            this.f22745j = c0866k.a(f22736a, 7, true);
            this.f22746k = c0866k.a(this.f22746k, 8, true);
            if (f22737b == null) {
                HashMap hashMap = new HashMap();
                f22737b = hashMap;
                hashMap.put("", "");
            }
            this.f22747l = (Map) c0866k.a((C0866k) f22737b, 9, true);
            if (f22737b == null) {
                HashMap hashMap2 = new HashMap();
                f22737b = hashMap2;
                hashMap2.put("", "");
            }
            this.f22748m = (Map) c0866k.a((C0866k) f22737b, 10, true);
        } catch (Exception e10) {
            e10.printStackTrace();
            System.out.println("RequestPacket decode error " + C0861f.a(this.f22745j));
            throw new RuntimeException(e10);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(StringBuilder sb2, int i10) {
        C0864i c0864i = new C0864i(sb2, i10);
        c0864i.a(this.f22739d, "iVersion");
        c0864i.a(this.f22740e, "cPacketType");
        c0864i.a(this.f22741f, "iMessageType");
        c0864i.a(this.f22742g, "iRequestId");
        c0864i.a(this.f22743h, "sServantName");
        c0864i.a(this.f22744i, "sFuncName");
        c0864i.a(this.f22745j, "sBuffer");
        c0864i.a(this.f22746k, "iTimeout");
        c0864i.a((Map) this.f22747l, com.umeng.analytics.pro.f.X);
        c0864i.a((Map) this.f22748m, "status");
    }
}
