package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class db implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.h> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.h hVar, JSONObject jSONObject) {
        a2(hVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.h hVar, JSONObject jSONObject) {
        return b2(hVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hVar.adp = jSONObject.optInt("hasDeepReward");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = hVar.adp;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "hasDeepReward", i10);
        }
        return jSONObject;
    }
}
