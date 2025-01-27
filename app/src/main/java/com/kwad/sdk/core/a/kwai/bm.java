package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bm implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.f> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.UZ = jSONObject.optInt("closeDelaySeconds");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = fVar.UZ;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeDelaySeconds", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.f fVar, JSONObject jSONObject) {
        a2(fVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.f fVar, JSONObject jSONObject) {
        return b2(fVar, jSONObject);
    }
}
