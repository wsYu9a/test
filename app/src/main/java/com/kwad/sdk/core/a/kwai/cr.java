package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.g.a;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cr implements com.kwad.sdk.core.d<a.C0227a> {
    /* renamed from: a */
    private static void a2(a.C0227a c0227a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("run_sdk_version");
        c0227a.sdkVersion = optString;
        if (optString == JSONObject.NULL) {
            c0227a.sdkVersion = "";
        }
        c0227a.aud = jSONObject.optLong("trigger_count", new Long("0").longValue());
        c0227a.aue = jSONObject.optLong("fail_count", new Long("0").longValue());
        c0227a.auf = jSONObject.optLong("real_fail_count", new Long("0").longValue());
        String optString2 = jSONObject.optString("business");
        c0227a.aug = optString2;
        if (optString2 == JSONObject.NULL) {
            c0227a.aug = "";
        }
        String optString3 = jSONObject.optString("stage");
        c0227a.auh = optString3;
        if (optString3 == JSONObject.NULL) {
            c0227a.auh = "";
        }
        String optString4 = jSONObject.optString("function");
        c0227a.aui = optString4;
        if (optString4 == JSONObject.NULL) {
            c0227a.aui = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(a.C0227a c0227a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0227a.sdkVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "run_sdk_version", c0227a.sdkVersion);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "trigger_count", c0227a.aud);
        com.kwad.sdk.utils.t.putValue(jSONObject, "fail_count", c0227a.aue);
        com.kwad.sdk.utils.t.putValue(jSONObject, "real_fail_count", c0227a.auf);
        String str2 = c0227a.aug;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "business", c0227a.aug);
        }
        String str3 = c0227a.auh;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "stage", c0227a.auh);
        }
        String str4 = c0227a.aui;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "function", c0227a.aui);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0227a c0227a, JSONObject jSONObject) {
        a2(c0227a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0227a c0227a, JSONObject jSONObject) {
        return b2(c0227a, jSONObject);
    }
}
