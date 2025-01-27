package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ca implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.e> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.e eVar, JSONObject jSONObject) {
        a2(eVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.e eVar, JSONObject jSONObject) {
        return b2(eVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.height = jSONObject.optInt("height");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = eVar.height;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "height", i10);
        }
        return jSONObject;
    }
}
