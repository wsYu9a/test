package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ld implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.w> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.w wVar, JSONObject jSONObject) {
        a2(wVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.w wVar, JSONObject jSONObject) {
        return b2(wVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.w wVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        wVar.adA = jSONObject.optInt("videoCloseTime", new Integer("0").intValue());
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.w wVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "videoCloseTime", wVar.adA);
        return jSONObject;
    }
}
