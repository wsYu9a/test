package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ci implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.f> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.f fVar, JSONObject jSONObject) {
        a2(fVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.f fVar, JSONObject jSONObject) {
        return b2(fVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.ado = jSONObject.optInt("closeDelaySeconds");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = fVar.ado;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "closeDelaySeconds", i10);
        }
        return jSONObject;
    }
}
