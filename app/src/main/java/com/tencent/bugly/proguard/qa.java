package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class qa extends AbstractC0868m {

    /* renamed from: a */
    static byte[] f22828a = {0};

    /* renamed from: b */
    static Map<String, String> f22829b;

    /* renamed from: c */
    public byte f22830c = 0;

    /* renamed from: d */
    public int f22831d = 0;

    /* renamed from: e */
    public byte[] f22832e = null;

    /* renamed from: f */
    public String f22833f = "";

    /* renamed from: g */
    public long f22834g = 0;

    /* renamed from: h */
    public String f22835h = "";

    /* renamed from: i */
    public String f22836i = "";

    /* renamed from: j */
    public Map<String, String> f22837j = null;

    static {
        HashMap hashMap = new HashMap();
        f22829b = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0867l c0867l) {
        c0867l.a(this.f22830c, 0);
        c0867l.a(this.f22831d, 1);
        byte[] bArr = this.f22832e;
        if (bArr != null) {
            c0867l.a(bArr, 2);
        }
        String str = this.f22833f;
        if (str != null) {
            c0867l.a(str, 3);
        }
        c0867l.a(this.f22834g, 4);
        String str2 = this.f22835h;
        if (str2 != null) {
            c0867l.a(str2, 5);
        }
        String str3 = this.f22836i;
        if (str3 != null) {
            c0867l.a(str3, 6);
        }
        Map<String, String> map = this.f22837j;
        if (map != null) {
            c0867l.a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        this.f22830c = c0866k.a(this.f22830c, 0, true);
        this.f22831d = c0866k.a(this.f22831d, 1, true);
        this.f22832e = c0866k.a(f22828a, 2, false);
        this.f22833f = c0866k.a(3, false);
        this.f22834g = c0866k.a(this.f22834g, 4, false);
        this.f22835h = c0866k.a(5, false);
        this.f22836i = c0866k.a(6, false);
        this.f22837j = (Map) c0866k.a((C0866k) f22829b, 7, false);
    }
}
