package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.f;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c {
    public static Map<String, String> a(Context context) {
        e2.b a10 = e2.b.a(APSecuritySdk.getInstance(context));
        HashMap hashMap = new HashMap();
        f a11 = com.alipay.apmobilesecuritysdk.e.e.a(context);
        String c10 = a10.c(context);
        String j10 = a10.j(context);
        if (a11 != null) {
            if (t3.a.c(c10)) {
                c10 = a11.b();
            }
            if (t3.a.c(j10)) {
                j10 = a11.e();
            }
        }
        f fVar = new f("", c10, "", "", j10);
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", fVar.a());
                jSONObject.put("imsi", fVar.b());
                jSONObject.put("mac", fVar.c());
                jSONObject.put("bluetoothmac", fVar.d());
                jSONObject.put("gsi", fVar.e());
                String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key", jSONObject2);
                com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key", jSONObject2);
            } catch (Exception e10) {
                com.alipay.apmobilesecuritysdk.c.a.a(e10);
            }
        }
        hashMap.put("AD1", "");
        hashMap.put("AD2", c10);
        hashMap.put("AD3", e2.b.r(context));
        hashMap.put("AD5", e2.b.v(context));
        hashMap.put("AD6", e2.b.x(context));
        hashMap.put("AD7", e2.b.z(context));
        hashMap.put("AD9", a10.h(context));
        hashMap.put("AD10", j10);
        hashMap.put("AD11", e2.b.i());
        hashMap.put("AD12", a10.b());
        hashMap.put("AD13", e2.b.k());
        hashMap.put("AD14", e2.b.o());
        hashMap.put("AD15", e2.b.q());
        hashMap.put("AD16", e2.b.s());
        hashMap.put("AD17", "");
        hashMap.put("AD19", e2.b.B(context));
        hashMap.put("AD20", e2.b.u());
        hashMap.put("AD22", "");
        hashMap.put("AD24", t3.a.k(e2.b.t(context)));
        hashMap.put("AD26", a10.f(context));
        hashMap.put("AD27", e2.b.E());
        hashMap.put("AD28", e2.b.I());
        hashMap.put("AD29", e2.b.K());
        hashMap.put("AD30", e2.b.G());
        hashMap.put("AD31", e2.b.J());
        hashMap.put("AD32", e2.b.A());
        hashMap.put("AD33", e2.b.C());
        hashMap.put("AD34", e2.b.D(context));
        hashMap.put("AD35", e2.b.F(context));
        hashMap.put("AD36", a10.l(context));
        hashMap.put("AD37", e2.b.y());
        hashMap.put("AD38", e2.b.w());
        hashMap.put("AD39", e2.b.n(context));
        hashMap.put("AD40", e2.b.p(context));
        hashMap.put("AD41", e2.b.e());
        hashMap.put("AD42", e2.b.g());
        return hashMap;
    }
}
