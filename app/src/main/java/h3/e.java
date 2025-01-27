package h3;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import f3.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p3.j;
import p3.k;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: c */
    public static final String f26398c = "msp-gzip";

    /* renamed from: d */
    public static final String f26399d = "Msp-Param";

    /* renamed from: e */
    public static final String f26400e = "Operation-Type";

    /* renamed from: f */
    public static final String f26401f = "content-type";

    /* renamed from: g */
    public static final String f26402g = "Version";

    /* renamed from: h */
    public static final String f26403h = "AppId";

    /* renamed from: i */
    public static final String f26404i = "des-mode";

    /* renamed from: j */
    public static final String f26405j = "namespace";

    /* renamed from: k */
    public static final String f26406k = "api_name";

    /* renamed from: l */
    public static final String f26407l = "api_version";

    /* renamed from: m */
    public static final String f26408m = "data";

    /* renamed from: n */
    public static final String f26409n = "params";

    /* renamed from: o */
    public static final String f26410o = "public_key";

    /* renamed from: p */
    public static final String f26411p = "device";

    /* renamed from: q */
    public static final String f26412q = "action";

    /* renamed from: r */
    public static final String f26413r = "type";

    /* renamed from: s */
    public static final String f26414s = "method";

    /* renamed from: a */
    public boolean f26415a = true;

    /* renamed from: b */
    public boolean f26416b = true;

    public static String e(a.b bVar, String str) {
        Map<String, List<String>> map;
        List<String> list;
        if (bVar == null || str == null || (map = bVar.f25967a) == null || (list = map.get(str)) == null) {
            return null;
        }
        return TextUtils.join(",", list);
    }

    public static JSONObject k(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put(f26414s, str2);
        jSONObject.put("action", jSONObject2);
        return jSONObject;
    }

    public static boolean l(a.b bVar) {
        return Boolean.valueOf(e(bVar, f26398c)).booleanValue();
    }

    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(f26408m);
            if (!jSONObject.has("params")) {
                return false;
            }
            String optString = jSONObject.getJSONObject("params").optString(f26410o, null);
            if (TextUtils.isEmpty(optString)) {
                return false;
            }
            b3.b.d(optString);
            return true;
        } catch (JSONException e10) {
            p3.d.e(e10);
            return false;
        }
    }

    public b a(n3.a aVar, Context context) throws Throwable {
        return b(aVar, context, "");
    }

    public b b(n3.a aVar, Context context, String str) throws Throwable {
        return c(aVar, context, str, j.b(context));
    }

    public b c(n3.a aVar, Context context, String str, String str2) throws Throwable {
        return d(aVar, context, str, str2, true);
    }

    public b d(n3.a aVar, Context context, String str, String str2, boolean z10) throws Throwable {
        p3.d.g(z2.a.A, "Packet: " + str2);
        c cVar = new c(this.f26416b);
        b bVar = new b(f(aVar), g(aVar, str, j()));
        Map<String, String> i10 = i(false, str);
        d c10 = cVar.c(bVar, this.f26415a, i10.get("iSr"));
        a.b a10 = f3.a.a(context, new a.C0696a(str2, i(c10.b(), str), c10.a()));
        if (a10 == null) {
            throw new RuntimeException("Response is null.");
        }
        b b10 = cVar.b(new d(l(a10), a10.f25969c), i10.get("iSr"));
        return (b10 != null && m(b10.b()) && z10) ? d(aVar, context, str, str2, false) : b10;
    }

    public String f(n3.a aVar) throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(f26411p, Build.MODEL);
        hashMap.put("namespace", "com.alipay.mobilecashier");
        hashMap.put(f26406k, "com.alipay.mcpay");
        hashMap.put(f26407l, n());
        return h(aVar, hashMap, new HashMap<>());
    }

    public String g(n3.a aVar, String str, JSONObject jSONObject) {
        n3.b e10 = n3.b.e();
        o3.a a10 = o3.a.a(e10.c());
        JSONObject a11 = p3.c.a(new JSONObject(), jSONObject);
        try {
            a11.put(z2.b.f33619d, str);
            a11.put("tid", a10.i());
            a11.put(z2.b.f33617b, e10.a().c(aVar, a10, o()));
            a11.put(z2.b.f33620e, k.y(aVar, e10.c(), v2.a.f31216d, false));
            a11.put(z2.b.f33621f, k.e0(e10.c()));
            a11.put(z2.b.f33623h, z2.a.f33596g);
            a11.put(z2.b.f33622g, e10.d());
            a11.put(z2.b.f33625j, a10.h());
            a11.put(z2.b.f33626k, b3.b.f(e10.c()));
        } catch (Throwable th2) {
            x2.a.e(aVar, x2.b.f31789l, "BodyErr", th2);
            p3.d.e(th2);
        }
        return a11.toString();
    }

    public String h(n3.a aVar, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
        if (hashMap2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> entry2 : hashMap2.entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject2.put("params", jSONObject3);
        }
        jSONObject.put(f26408m, jSONObject2);
        return jSONObject.toString();
    }

    public Map<String, String> i(boolean z10, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(f26398c, String.valueOf(z10));
        hashMap.put(f26400e, "alipay.msp.cashier.dispatch.bytes");
        hashMap.put(f26401f, "application/octet-stream");
        hashMap.put(f26402g, "2.0");
        hashMap.put(f26403h, "TAOBAO");
        hashMap.put(f26399d, a.a(str));
        hashMap.put(f26404i, "CBC");
        return hashMap;
    }

    public abstract JSONObject j() throws JSONException;

    public String n() {
        return "4.9.0";
    }

    public abstract boolean o();
}
