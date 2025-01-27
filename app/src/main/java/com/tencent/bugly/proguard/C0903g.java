package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.g */
/* loaded from: classes4.dex */
public final class C0903g extends AbstractC0909m {

    /* renamed from: j */
    public byte[] f25076j;
    public Map<String, String> l;
    public Map<String, String> m;

    /* renamed from: c */
    static final /* synthetic */ boolean f25069c = true;

    /* renamed from: a */
    static byte[] f25067a = null;

    /* renamed from: b */
    static Map<String, String> f25068b = null;

    /* renamed from: d */
    public short f25070d = 0;

    /* renamed from: e */
    public byte f25071e = 0;

    /* renamed from: f */
    public int f25072f = 0;

    /* renamed from: g */
    public int f25073g = 0;

    /* renamed from: h */
    public String f25074h = null;

    /* renamed from: i */
    public String f25075i = null;
    public int k = 0;

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0908l c0908l) {
        c0908l.a(this.f25070d, 1);
        c0908l.a(this.f25071e, 2);
        c0908l.a(this.f25072f, 3);
        c0908l.a(this.f25073g, 4);
        c0908l.a(this.f25074h, 5);
        c0908l.a(this.f25075i, 6);
        c0908l.a(this.f25076j, 7);
        c0908l.a(this.k, 8);
        c0908l.a((Map) this.l, 9);
        c0908l.a((Map) this.m, 10);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f25069c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        C0903g c0903g = (C0903g) obj;
        return C0910n.a(1, (int) c0903g.f25070d) && C0910n.a(1, (int) c0903g.f25071e) && C0910n.a(1, c0903g.f25072f) && C0910n.a(1, c0903g.f25073g) && C0910n.a((Object) 1, (Object) c0903g.f25074h) && C0910n.a((Object) 1, (Object) c0903g.f25075i) && C0910n.a((Object) 1, (Object) c0903g.f25076j) && C0910n.a(1, c0903g.k) && C0910n.a((Object) 1, (Object) c0903g.l) && C0910n.a((Object) 1, (Object) c0903g.m);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        try {
            this.f25070d = c0907k.a(this.f25070d, 1, true);
            this.f25071e = c0907k.a(this.f25071e, 2, true);
            this.f25072f = c0907k.a(this.f25072f, 3, true);
            this.f25073g = c0907k.a(this.f25073g, 4, true);
            this.f25074h = c0907k.a(5, true);
            this.f25075i = c0907k.a(6, true);
            if (f25067a == null) {
                f25067a = new byte[]{0};
            }
            this.f25076j = c0907k.a(f25067a, 7, true);
            this.k = c0907k.a(this.k, 8, true);
            if (f25068b == null) {
                HashMap hashMap = new HashMap();
                f25068b = hashMap;
                hashMap.put("", "");
            }
            this.l = (Map) c0907k.a((C0907k) f25068b, 9, true);
            if (f25068b == null) {
                HashMap hashMap2 = new HashMap();
                f25068b = hashMap2;
                hashMap2.put("", "");
            }
            this.m = (Map) c0907k.a((C0907k) f25068b, 10, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            System.out.println("RequestPacket decode error " + C0902f.a(this.f25076j));
            throw new RuntimeException(e2);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(StringBuilder sb, int i2) {
        C0905i c0905i = new C0905i(sb, i2);
        c0905i.a(this.f25070d, "iVersion");
        c0905i.a(this.f25071e, "cPacketType");
        c0905i.a(this.f25072f, "iMessageType");
        c0905i.a(this.f25073g, "iRequestId");
        c0905i.a(this.f25074h, "sServantName");
        c0905i.a(this.f25075i, "sFuncName");
        c0905i.a(this.f25076j, "sBuffer");
        c0905i.a(this.k, "iTimeout");
        c0905i.a((Map) this.l, "context");
        c0905i.a((Map) this.m, "status");
    }
}
