package p3;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import x2.a;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public static final String f29719a = "ap_req";

    /* renamed from: b */
    public static final String f29720b = "ap_args";

    /* renamed from: c */
    public static final String f29721c = "ap_resp";

    public static HashMap<String, String> a(n3.a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            p2.a c10 = c();
            JSONObject jSONObject = new JSONObject();
            Context a10 = aVar != null ? aVar.a() : null;
            if (a10 == null) {
                a10 = n3.b.e().c().getApplicationContext();
            }
            String l10 = k.l(aVar, a10);
            String c11 = com.alipay.sdk.m.w.b.c(aVar, a10);
            jSONObject.put("ap_q", c10 != null ? c10.a() : "");
            jSONObject.put(n3.a.f28760z, aVar != null ? aVar.f28764d : "");
            jSONObject.put("u_pd", String.valueOf(k.Z()));
            jSONObject.put("u_lk", String.valueOf(k.S(k.D())));
            jSONObject.put("u_pi", String.valueOf(aVar != null ? aVar.f28767g : hf.e.f26694a));
            jSONObject.put("u_fu", l10);
            jSONObject.put("u_oi", c11);
            hashMap.put(f29719a, jSONObject.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c10 != null ? c10.a() : "");
            sb2.append("|");
            sb2.append(l10);
            x2.a.d(aVar, x2.b.f31789l, "ap_q", sb2.toString());
        } catch (Exception e10) {
            x2.a.e(aVar, x2.b.f31789l, "APMEx1", e10);
        }
        return hashMap;
    }

    public static JSONObject b(n3.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString(f29721c);
        try {
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            return new JSONObject(optString);
        } catch (JSONException e10) {
            x2.a.e(aVar, x2.b.f31789l, "APMEx2", e10);
            return null;
        }
    }

    public static p2.a c() {
        try {
            try {
                return r2.a.c("NP", System.currentTimeMillis(), new r2.c(n3.b.e().d()), (short) a.c.a(n3.b.e().c()), new r2.f());
            } catch (Exception unused) {
                return r2.a.d();
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static void d(n3.a aVar, HashMap<String, String> hashMap) {
        JSONObject b10 = b3.a.J().b();
        if (hashMap == null || b10 == null) {
            return;
        }
        x2.a.d(aVar, x2.b.f31789l, "ap_r", b10.optString("ap_r"));
        hashMap.putAll(k.p(b10));
    }

    public static void e(n3.a aVar, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            jSONObject.putOpt(f29720b, jSONObject2);
        } catch (JSONException e10) {
            x2.a.e(aVar, x2.b.f31789l, "APMEx2", e10);
        }
    }
}
