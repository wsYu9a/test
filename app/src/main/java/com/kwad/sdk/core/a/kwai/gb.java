package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gb implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.o> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.o oVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        oVar.Vg = jSONObject.optInt("scene");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.o oVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = oVar.Vg;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "scene", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.o oVar, JSONObject jSONObject) {
        a2(oVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.o oVar, JSONObject jSONObject) {
        return b2(oVar, jSONObject);
    }
}
