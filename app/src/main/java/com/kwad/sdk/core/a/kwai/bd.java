package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bd implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.block.c> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.crash.online.monitor.block.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("printerName");
        cVar.arW = optString;
        if (optString == JSONObject.NULL) {
            cVar.arW = "";
        }
        String optString2 = jSONObject.optString("errorMsg");
        cVar.errorMsg = optString2;
        if (optString2 == JSONObject.NULL) {
            cVar.errorMsg = "";
        }
        cVar.arX = jSONObject.optBoolean("isDisable");
        cVar.arY = jSONObject.optBoolean("hasMatrix");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.block.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.arW;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "printerName", cVar.arW);
        }
        String str2 = cVar.errorMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorMsg", cVar.errorMsg);
        }
        boolean z = cVar.arX;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isDisable", z);
        }
        boolean z2 = cVar.arY;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "hasMatrix", z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.block.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.block.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
