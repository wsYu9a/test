package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class au implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.c> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.UX = jSONObject.optInt("showCount", new Integer("0").intValue());
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "showCount", cVar.UX);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
