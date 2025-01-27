package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cu implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.l> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.report.l lVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("log");
        lVar.air = optString;
        if (optString == JSONObject.NULL) {
            lVar.air = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.report.l lVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = lVar.air;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "log", lVar.air);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.l lVar, JSONObject jSONObject) {
        a2(lVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.l lVar, JSONObject jSONObject) {
        return b2(lVar, jSONObject);
    }
}
