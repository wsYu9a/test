package com.alipay.sdk.protocol;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.exception.NetErrorException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class g {
    public static h a(c cVar) throws NetErrorException {
        b.b.a.c.e eVar = cVar.f5417a;
        b.b.a.c.f fVar = cVar.f5418b;
        JSONObject jSONObject = cVar.f5419c;
        if (jSONObject.has(b.b.a.b.c.f4210c)) {
            h hVar = new h(eVar, fVar);
            hVar.b(cVar.f5419c);
            return hVar;
        }
        if (jSONObject.has("status")) {
            int i2 = e.f5420a[f.a(jSONObject.optString("status")).ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                h hVar2 = new h(eVar, fVar);
                hVar2.b(jSONObject);
                return hVar2;
            }
            if (i2 == 4) {
                Context context = b.b.a.f.a.a().f4274b;
                String b2 = com.alipay.sdk.util.c.a(context).b();
                String e2 = com.alipay.sdk.util.c.a(context).e();
                com.alipay.sdk.tid.a aVar = new com.alipay.sdk.tid.a(context);
                aVar.e(b2, e2);
                aVar.close();
            }
        }
        return null;
    }

    private static void b(c cVar) throws NetErrorException {
        b.b.a.c.f fVar = cVar.f5418b;
        JSONObject jSONObject = cVar.f5419c;
        b.b.a.c.a aVar = cVar.f5417a.f4235a;
        b.b.a.c.a aVar2 = fVar.l;
        if (TextUtils.isEmpty(aVar2.f4220c)) {
            aVar2.f4220c = aVar.f4220c;
        }
        if (TextUtils.isEmpty(aVar2.f4221d)) {
            aVar2.f4221d = aVar.f4221d;
        }
        if (TextUtils.isEmpty(aVar2.f4219b)) {
            aVar2.f4219b = aVar.f4219b;
        }
        if (TextUtils.isEmpty(aVar2.f4218a)) {
            aVar2.f4218a = aVar.f4218a;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("reflected_data");
        if (optJSONObject != null) {
            String str = "session = " + optJSONObject.optString(com.umeng.analytics.pro.d.aw, "");
            cVar.f5418b.f4250i = optJSONObject;
        } else if (jSONObject.has(com.umeng.analytics.pro.d.aw)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(com.umeng.analytics.pro.d.aw, jSONObject.optString(com.umeng.analytics.pro.d.aw));
                String str2 = com.alipay.sdk.tid.b.a().f5438b;
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject2.put(b.b.a.b.b.f4200c, str2);
                }
                fVar.f4250i = jSONObject2;
            } catch (JSONException unused) {
            }
        }
        fVar.f4247f = jSONObject.optString("end_code", "0");
        fVar.f4251j = jSONObject.optString("user_id", "");
        String optString = jSONObject.optString("result");
        try {
            optString = URLDecoder.decode(jSONObject.optString("result"), "UTF-8");
        } catch (UnsupportedEncodingException unused2) {
        }
        fVar.f4248g = optString;
        fVar.f4249h = jSONObject.optString("memo", "");
    }
}
