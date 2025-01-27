package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class ta extends AbstractC0868m {

    /* renamed from: a */
    static Map<String, String> f22865a;

    /* renamed from: b */
    public long f22866b = 0;

    /* renamed from: c */
    public byte f22867c = 0;

    /* renamed from: d */
    public String f22868d = "";

    /* renamed from: e */
    public String f22869e = "";

    /* renamed from: f */
    public String f22870f = "";

    /* renamed from: g */
    public Map<String, String> f22871g = null;

    /* renamed from: h */
    public String f22872h = "";

    /* renamed from: i */
    public boolean f22873i = true;

    static {
        HashMap hashMap = new HashMap();
        f22865a = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0867l c0867l) {
        c0867l.a(this.f22866b, 0);
        c0867l.a(this.f22867c, 1);
        String str = this.f22868d;
        if (str != null) {
            c0867l.a(str, 2);
        }
        String str2 = this.f22869e;
        if (str2 != null) {
            c0867l.a(str2, 3);
        }
        String str3 = this.f22870f;
        if (str3 != null) {
            c0867l.a(str3, 4);
        }
        Map<String, String> map = this.f22871g;
        if (map != null) {
            c0867l.a((Map) map, 5);
        }
        String str4 = this.f22872h;
        if (str4 != null) {
            c0867l.a(str4, 6);
        }
        c0867l.a(this.f22873i, 7);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        this.f22866b = c0866k.a(this.f22866b, 0, true);
        this.f22867c = c0866k.a(this.f22867c, 1, true);
        this.f22868d = c0866k.a(2, false);
        this.f22869e = c0866k.a(3, false);
        this.f22870f = c0866k.a(4, false);
        this.f22871g = (Map) c0866k.a((C0866k) f22865a, 5, false);
        this.f22872h = c0866k.a(6, false);
        this.f22873i = c0866k.a(this.f22873i, 7, false);
    }
}
