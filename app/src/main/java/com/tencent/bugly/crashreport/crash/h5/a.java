package com.tencent.bugly.crashreport.crash.h5;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public String f22493a = null;

    /* renamed from: b */
    public String f22494b = null;

    /* renamed from: c */
    public String f22495c = null;

    /* renamed from: d */
    public String f22496d = null;

    /* renamed from: e */
    public String f22497e = null;

    /* renamed from: f */
    public String f22498f = null;

    /* renamed from: g */
    public String f22499g = null;

    /* renamed from: h */
    public String f22500h = null;

    /* renamed from: i */
    public String f22501i = null;

    /* renamed from: j */
    public long f22502j = 0;

    /* renamed from: k */
    public long f22503k = 0;

    public Map<String, String> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = this.f22493a;
        if (str != null) {
            linkedHashMap.put("[JS] projectRoot", str);
        }
        String str2 = this.f22494b;
        if (str2 != null) {
            linkedHashMap.put("[JS] context", str2);
        }
        String str3 = this.f22495c;
        if (str3 != null) {
            linkedHashMap.put("[JS] url", str3);
        }
        String str4 = this.f22496d;
        if (str4 != null) {
            linkedHashMap.put("[JS] userAgent", str4);
        }
        String str5 = this.f22501i;
        if (str5 != null) {
            linkedHashMap.put("[JS] file", str5);
        }
        long j10 = this.f22502j;
        if (j10 != 0) {
            linkedHashMap.put("[JS] lineNumber", Long.toString(j10));
        }
        return linkedHashMap;
    }
}
