package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gi implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.p> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.p pVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pVar.Vh = jSONObject.optBoolean("isPlayAgainScene");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.p pVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = pVar.Vh;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isPlayAgainScene", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.p pVar, JSONObject jSONObject) {
        a2(pVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.p pVar, JSONObject jSONObject) {
        return b2(pVar, jSONObject);
    }
}
