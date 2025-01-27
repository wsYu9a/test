package com.vivo.mobilead.b;

import com.tencent.open.SocialConstants;
import com.vivo.mobilead.util.x0;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private String f28669a;

    /* renamed from: b */
    private String f28670b;

    /* renamed from: c */
    private String f28671c = "";

    /* renamed from: d */
    private String f28672d = "";

    public void a(String str) {
        this.f28671c = str;
    }

    public void b(String str) {
        this.f28672d = str;
    }

    public void c(String str) {
        this.f28669a = str;
    }

    public void d(String str) {
        this.f28670b = str;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SocialConstants.PARAM_SOURCE, this.f28669a);
            jSONObject.put("status", this.f28670b);
            jSONObject.put("code", this.f28671c);
            jSONObject.put("reason", this.f28672d);
            return jSONObject;
        } catch (Exception e2) {
            x0.b("ReportParam", "toJsonObject JSONException : " + e2);
            return null;
        }
    }
}
