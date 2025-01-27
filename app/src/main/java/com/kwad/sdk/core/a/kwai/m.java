package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class m implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.a> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.UV = jSONObject.optInt("hasConverted");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.UV;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "hasConverted", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
