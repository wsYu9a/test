package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gk implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.q> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        qVar.Vi = jSONObject.optBoolean("isEnd");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = qVar.Vi;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isEnd", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.q qVar, JSONObject jSONObject) {
        a2(qVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.q qVar, JSONObject jSONObject) {
        return b2(qVar, jSONObject);
    }
}
