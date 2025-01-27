package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class je implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.y> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("status");
        yVar.Vp = optString;
        if (optString == JSONObject.NULL) {
            yVar.Vp = "";
        }
        yVar.errorCode = jSONObject.optInt("errorCode");
        String optString2 = jSONObject.optString("errorReason");
        yVar.errorReason = optString2;
        if (optString2 == JSONObject.NULL) {
            yVar.errorReason = "";
        }
        yVar.nZ = jSONObject.optInt("currentTime");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = yVar.Vp;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", yVar.Vp);
        }
        int i2 = yVar.errorCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorCode", i2);
        }
        String str2 = yVar.errorReason;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorReason", yVar.errorReason);
        }
        int i3 = yVar.nZ;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentTime", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.y yVar, JSONObject jSONObject) {
        a2(yVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.y yVar, JSONObject jSONObject) {
        return b2(yVar, jSONObject);
    }
}
