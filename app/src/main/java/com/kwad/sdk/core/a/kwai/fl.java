package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fl implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.m> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        mVar.Vf = jSONObject.optBoolean("muted");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = mVar.Vf;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "muted", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.m mVar, JSONObject jSONObject) {
        a2(mVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.m mVar, JSONObject jSONObject) {
        return b2(mVar, jSONObject);
    }
}
