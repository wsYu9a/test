package com.alipay.sdk.protocol;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    String f5407a;

    /* renamed from: b */
    String f5408b;

    /* renamed from: c */
    String f5409c;

    /* renamed from: d */
    String f5410d;

    /* renamed from: e */
    String f5411e;

    /* renamed from: f */
    boolean f5412f;

    /* renamed from: g */
    boolean f5413g = true;

    /* renamed from: h */
    boolean f5414h = true;

    /* renamed from: i */
    String f5415i;

    /* renamed from: j */
    String f5416j;
    String k;
    JSONObject l;

    private b(String str) {
        this.f5407a = str;
    }

    private static b a(String str, a aVar) {
        return b(str, aVar.f(), aVar.l(), aVar.g(), aVar.h(), aVar.i(), aVar.j(), aVar.k(), aVar.c(), aVar.d(), aVar.b(), aVar.a());
    }

    private static b b(String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, boolean z3, String str6, String str7, String str8, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b(str);
        bVar.f5407a = str;
        bVar.f5408b = TextUtils.isEmpty(str2) ? null : str2.trim();
        bVar.f5409c = str3;
        bVar.f5410d = str4;
        bVar.f5411e = str5;
        bVar.f5412f = z;
        bVar.f5413g = z2;
        bVar.f5414h = z3;
        bVar.f5415i = str6;
        bVar.f5416j = str7;
        bVar.k = str8;
        bVar.l = jSONObject;
        return bVar;
    }

    private static b c(JSONObject jSONObject) {
        String str = null;
        String optString = (jSONObject == null || !jSONObject.has("name")) ? null : jSONObject.optString("name");
        String optString2 = (jSONObject == null || !jSONObject.has("host")) ? null : jSONObject.optString("host");
        String optString3 = (jSONObject == null || !jSONObject.has("params")) ? null : jSONObject.optString("params");
        String optString4 = (jSONObject == null || !jSONObject.has(b.b.a.b.c.f4215h)) ? null : jSONObject.optString(b.b.a.b.c.f4215h);
        if (jSONObject != null && jSONObject.has(b.b.a.b.c.f4216i)) {
            str = jSONObject.optString(b.b.a.b.c.f4216i);
        }
        String str2 = str;
        boolean optBoolean = (jSONObject == null || !jSONObject.has(b.b.a.b.c.f4217j)) ? true : jSONObject.optBoolean(b.b.a.b.c.f4217j, true);
        boolean z = (jSONObject == null || !jSONObject.has(b.b.a.b.b.f4198a)) ? true : !jSONObject.optBoolean(b.b.a.b.b.f4198a);
        boolean optBoolean2 = (jSONObject == null || !jSONObject.has(b.b.a.b.c.k)) ? true : jSONObject.optBoolean(b.b.a.b.c.k);
        String str3 = "";
        String optString5 = (jSONObject == null || !jSONObject.has(b.b.a.b.c.l)) ? "" : jSONObject.optString(b.b.a.b.c.l);
        String optString6 = (jSONObject == null || !jSONObject.has(b.b.a.b.c.m)) ? "" : jSONObject.optString(b.b.a.b.c.m);
        if (jSONObject != null && jSONObject.has(b.b.a.b.c.n)) {
            str3 = jSONObject.optString(b.b.a.b.c.n);
        }
        return b(optString, optString2, optString3, optString4, str2, optBoolean, z, optBoolean2, optString5, optString6, str3, jSONObject);
    }

    public static b d(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        String str2 = null;
        String optString = (optJSONObject == null || !optJSONObject.has("name")) ? null : optJSONObject.optString("name");
        String optString2 = (optJSONObject == null || !optJSONObject.has("host")) ? null : optJSONObject.optString("host");
        String optString3 = (optJSONObject == null || !optJSONObject.has("params")) ? null : optJSONObject.optString("params");
        String optString4 = (optJSONObject == null || !optJSONObject.has(b.b.a.b.c.f4215h)) ? null : optJSONObject.optString(b.b.a.b.c.f4215h);
        if (optJSONObject != null && optJSONObject.has(b.b.a.b.c.f4216i)) {
            str2 = optJSONObject.optString(b.b.a.b.c.f4216i);
        }
        String str3 = str2;
        boolean optBoolean = (optJSONObject == null || !optJSONObject.has(b.b.a.b.c.f4217j)) ? true : optJSONObject.optBoolean(b.b.a.b.c.f4217j, true);
        boolean z = (optJSONObject == null || !optJSONObject.has(b.b.a.b.b.f4198a)) ? true : !optJSONObject.optBoolean(b.b.a.b.b.f4198a);
        boolean optBoolean2 = (optJSONObject == null || !optJSONObject.has(b.b.a.b.c.k)) ? true : optJSONObject.optBoolean(b.b.a.b.c.k);
        String str4 = "";
        String optString5 = (optJSONObject == null || !optJSONObject.has(b.b.a.b.c.l)) ? "" : optJSONObject.optString(b.b.a.b.c.l);
        String optString6 = (optJSONObject == null || !optJSONObject.has(b.b.a.b.c.m)) ? "" : optJSONObject.optString(b.b.a.b.c.m);
        if (optJSONObject != null && optJSONObject.has(b.b.a.b.c.n)) {
            str4 = optJSONObject.optString(b.b.a.b.c.n);
        }
        return b(optString, optString2, optString3, optString4, str3, optBoolean, z, optBoolean2, optString5, optString6, str4, optJSONObject);
    }

    private JSONObject f() {
        return this.l;
    }

    private String g() {
        return this.k;
    }

    private String h() {
        return this.f5415i;
    }

    private String i() {
        return this.f5416j;
    }

    private String j() {
        return this.f5407a;
    }

    private String k() {
        if (TextUtils.isEmpty(this.f5408b)) {
            this.f5408b = b.b.a.b.a.f4189b;
        }
        return this.f5408b;
    }

    private String l() {
        return this.f5409c;
    }

    private String m() {
        return this.f5410d;
    }

    private String n() {
        return this.f5411e;
    }

    private boolean o() {
        return this.f5412f;
    }

    private boolean p() {
        return this.f5413g;
    }

    private boolean q() {
        return this.f5414h;
    }

    public final JSONObject e() {
        try {
            return new JSONObject(this.f5409c);
        } catch (Exception unused) {
            return null;
        }
    }
}
