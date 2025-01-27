package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import java.util.HashMap;
import java.util.Map;
import t3.a;
import z2.b;

/* loaded from: classes.dex */
public class SecurityClientMobile {
    public static synchronized String GetApdid(Context context, Map<String, String> map) {
        String a10;
        synchronized (SecurityClientMobile.class) {
            HashMap hashMap = new HashMap();
            hashMap.put(b.f33622g, a.b(map, b.f33622g, ""));
            hashMap.put("tid", a.b(map, "tid", ""));
            hashMap.put("userId", a.b(map, "userId", ""));
            APSecuritySdk.getInstance(context).initToken(0, hashMap, null);
            a10 = com.alipay.apmobilesecuritysdk.a.a.a(context);
        }
        return a10;
    }
}
