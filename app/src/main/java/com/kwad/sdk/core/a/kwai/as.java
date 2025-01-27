package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class as implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.b> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.UW = jSONObject.optInt("hasInstalled");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = bVar.UW;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "hasInstalled", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
