package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class aw implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.d> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.UY = jSONObject.optBoolean("autoPlay");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = dVar.UY;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "autoPlay", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }
}
