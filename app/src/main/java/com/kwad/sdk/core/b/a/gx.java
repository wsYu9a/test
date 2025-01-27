package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class gx implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.m> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.m mVar, JSONObject jSONObject) {
        a2(mVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.m mVar, JSONObject jSONObject) {
        return b2(mVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        mVar.adu = jSONObject.optBoolean("muted");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = mVar.adu;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "muted", z10);
        }
        return jSONObject;
    }
}
