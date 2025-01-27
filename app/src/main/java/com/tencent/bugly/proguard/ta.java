package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class ta extends AbstractC0909m {

    /* renamed from: a */
    static Map<String, String> f25156a;

    /* renamed from: b */
    public long f25157b = 0;

    /* renamed from: c */
    public byte f25158c = 0;

    /* renamed from: d */
    public String f25159d = "";

    /* renamed from: e */
    public String f25160e = "";

    /* renamed from: f */
    public String f25161f = "";

    /* renamed from: g */
    public Map<String, String> f25162g = null;

    /* renamed from: h */
    public String f25163h = "";

    /* renamed from: i */
    public boolean f25164i = true;

    static {
        HashMap hashMap = new HashMap();
        f25156a = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0908l c0908l) {
        c0908l.a(this.f25157b, 0);
        c0908l.a(this.f25158c, 1);
        String str = this.f25159d;
        if (str != null) {
            c0908l.a(str, 2);
        }
        String str2 = this.f25160e;
        if (str2 != null) {
            c0908l.a(str2, 3);
        }
        String str3 = this.f25161f;
        if (str3 != null) {
            c0908l.a(str3, 4);
        }
        Map<String, String> map = this.f25162g;
        if (map != null) {
            c0908l.a((Map) map, 5);
        }
        String str4 = this.f25163h;
        if (str4 != null) {
            c0908l.a(str4, 6);
        }
        c0908l.a(this.f25164i, 7);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        this.f25157b = c0907k.a(this.f25157b, 0, true);
        this.f25158c = c0907k.a(this.f25158c, 1, true);
        this.f25159d = c0907k.a(2, false);
        this.f25160e = c0907k.a(3, false);
        this.f25161f = c0907k.a(4, false);
        this.f25162g = (Map) c0907k.a((C0907k) f25156a, 5, false);
        this.f25163h = c0907k.a(6, false);
        this.f25164i = c0907k.a(this.f25164i, 7, false);
    }
}
