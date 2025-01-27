package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class qa extends AbstractC0909m {

    /* renamed from: a */
    static byte[] f25124a = {0};

    /* renamed from: b */
    static Map<String, String> f25125b;

    /* renamed from: c */
    public byte f25126c = 0;

    /* renamed from: d */
    public int f25127d = 0;

    /* renamed from: e */
    public byte[] f25128e = null;

    /* renamed from: f */
    public String f25129f = "";

    /* renamed from: g */
    public long f25130g = 0;

    /* renamed from: h */
    public String f25131h = "";

    /* renamed from: i */
    public String f25132i = "";

    /* renamed from: j */
    public Map<String, String> f25133j = null;

    static {
        HashMap hashMap = new HashMap();
        f25125b = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0908l c0908l) {
        c0908l.a(this.f25126c, 0);
        c0908l.a(this.f25127d, 1);
        byte[] bArr = this.f25128e;
        if (bArr != null) {
            c0908l.a(bArr, 2);
        }
        String str = this.f25129f;
        if (str != null) {
            c0908l.a(str, 3);
        }
        c0908l.a(this.f25130g, 4);
        String str2 = this.f25131h;
        if (str2 != null) {
            c0908l.a(str2, 5);
        }
        String str3 = this.f25132i;
        if (str3 != null) {
            c0908l.a(str3, 6);
        }
        Map<String, String> map = this.f25133j;
        if (map != null) {
            c0908l.a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        this.f25126c = c0907k.a(this.f25126c, 0, true);
        this.f25127d = c0907k.a(this.f25127d, 1, true);
        this.f25128e = c0907k.a(f25124a, 2, false);
        this.f25129f = c0907k.a(3, false);
        this.f25130g = c0907k.a(this.f25130g, 4, false);
        this.f25131h = c0907k.a(5, false);
        this.f25132i = c0907k.a(6, false);
        this.f25133j = (Map) c0907k.a((C0907k) f25125b, 7, false);
    }
}
