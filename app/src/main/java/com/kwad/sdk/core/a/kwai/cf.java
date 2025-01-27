package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cf implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.h> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hVar.Va = jSONObject.optInt("hasDeepReward");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = hVar.Va;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "hasDeepReward", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.h hVar, JSONObject jSONObject) {
        a2(hVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.h hVar, JSONObject jSONObject) {
        return b2(hVar, jSONObject);
    }
}
