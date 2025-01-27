package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class hz implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.p> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.p pVar, JSONObject jSONObject) {
        a2(pVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.p pVar, JSONObject jSONObject) {
        return b2(pVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.p pVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pVar.adw = jSONObject.optBoolean("isEnd");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.p pVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = pVar.adw;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "isEnd", z10);
        }
        return jSONObject;
    }
}
