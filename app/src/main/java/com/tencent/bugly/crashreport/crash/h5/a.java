package com.tencent.bugly.crashreport.crash.h5;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public String f24870a = null;

    /* renamed from: b */
    public String f24871b = null;

    /* renamed from: c */
    public String f24872c = null;

    /* renamed from: d */
    public String f24873d = null;

    /* renamed from: e */
    public String f24874e = null;

    /* renamed from: f */
    public String f24875f = null;

    /* renamed from: g */
    public String f24876g = null;

    /* renamed from: h */
    public String f24877h = null;

    /* renamed from: i */
    public String f24878i = null;

    /* renamed from: j */
    public long f24879j = 0;
    public long k = 0;

    public Map<String, String> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = this.f24870a;
        if (str != null) {
            linkedHashMap.put("[JS] projectRoot", str);
        }
        String str2 = this.f24871b;
        if (str2 != null) {
            linkedHashMap.put("[JS] context", str2);
        }
        String str3 = this.f24872c;
        if (str3 != null) {
            linkedHashMap.put("[JS] url", str3);
        }
        String str4 = this.f24873d;
        if (str4 != null) {
            linkedHashMap.put("[JS] userAgent", str4);
        }
        String str5 = this.f24878i;
        if (str5 != null) {
            linkedHashMap.put("[JS] file", str5);
        }
        long j2 = this.f24879j;
        if (j2 != 0) {
            linkedHashMap.put("[JS] lineNumber", Long.toString(j2));
        }
        return linkedHashMap;
    }
}
