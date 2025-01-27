package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class jd implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.q> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.q qVar, JSONObject jSONObject) {
        a2(qVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.q qVar, JSONObject jSONObject) {
        return b2(qVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        qVar.adx = jSONObject.optBoolean("userForce");
        qVar.type = jSONObject.optInt("type");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = qVar.adx;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "userForce", z10);
        }
        int i10 = qVar.type;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "type", i10);
        }
        return jSONObject;
    }
}
