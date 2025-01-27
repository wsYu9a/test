package com.umeng.analytics.pro;

import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ad extends ab {

    /* renamed from: a */
    private String f23392a;

    /* renamed from: b */
    private String f23393b;

    public ad(String str, ArrayList<ac> arrayList) {
        super(str, arrayList);
        this.f23392a = "";
        this.f23393b = "";
    }

    @Override // com.umeng.analytics.pro.ab, com.umeng.analytics.pro.aj
    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject a10 = super.a(str, jSONObject);
        if (a10 != null) {
            try {
                a10.put(com.umeng.ccg.a.f24245v, this.f23392a);
                a10.put("action", this.f23393b);
            } catch (Throwable unused) {
            }
        }
        return a10;
    }

    @Override // com.umeng.analytics.pro.ab, com.umeng.analytics.pro.aj
    public void b(String str, JSONObject jSONObject) {
        super.b(str, jSONObject);
        if (jSONObject.has("action")) {
            d(jSONObject.optString("action"));
        }
        if (jSONObject.has(com.umeng.ccg.a.f24245v)) {
            c(jSONObject.optString(com.umeng.ccg.a.f24245v));
        }
    }

    public void c(String str) {
        this.f23392a = str;
    }

    public String d() {
        return this.f23392a;
    }

    public String e() {
        return this.f23393b;
    }

    public void d(String str) {
        this.f23393b = str;
    }
}
