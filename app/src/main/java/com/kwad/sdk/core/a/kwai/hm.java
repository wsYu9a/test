package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hm implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.r> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.r rVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rVar.Vj = jSONObject.optBoolean("userForce");
        rVar.type = jSONObject.optInt("type");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.r rVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = rVar.Vj;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userForce", z);
        }
        int i2 = rVar.type;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.r rVar, JSONObject jSONObject) {
        a2(rVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.r rVar, JSONObject jSONObject) {
        return b2(rVar, jSONObject);
    }
}
