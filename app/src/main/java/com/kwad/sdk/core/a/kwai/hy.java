package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hy implements com.kwad.sdk.core.d<com.kwad.components.ad.splashscreen.local.a> {
    /* renamed from: a */
    private static void a2(com.kwad.components.ad.splashscreen.local.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.gq = jSONObject.optLong("lastShowTimestamp");
        String optString = jSONObject.optString("dailyCountMapStr");
        aVar.BU = optString;
        if (optString == JSONObject.NULL) {
            aVar.BU = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.ad.splashscreen.local.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = aVar.gq;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "lastShowTimestamp", j2);
        }
        String str = aVar.BU;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "dailyCountMapStr", aVar.BU);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.splashscreen.local.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.splashscreen.local.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
