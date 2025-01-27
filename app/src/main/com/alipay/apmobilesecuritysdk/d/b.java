package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.h;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class b {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        HashMap hashMap;
        synchronized (b.class) {
            hashMap = new HashMap();
            String b10 = t3.a.b(map, "tid", "");
            String b11 = t3.a.b(map, z2.b.f33622g, "");
            String b12 = t3.a.b(map, "userId", "");
            String b13 = t3.a.b(map, "appName", "");
            String b14 = t3.a.b(map, "appKeyClient", "");
            String b15 = t3.a.b(map, "tmxSessionId", "");
            String f10 = h.f(context);
            String b16 = t3.a.b(map, "sessionId", "");
            hashMap.put("AC1", b10);
            hashMap.put("AC2", b11);
            hashMap.put("AC3", "");
            hashMap.put("AC4", f10);
            hashMap.put("AC5", b12);
            hashMap.put("AC6", b15);
            hashMap.put("AC7", "");
            hashMap.put("AC8", b13);
            hashMap.put("AC9", b14);
            if (t3.a.f(b16)) {
                hashMap.put("AC10", b16);
            }
        }
        return hashMap;
    }
}
