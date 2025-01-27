package com.kwad.sdk.core.a.kwai;

import com.martian.mibook.application.MiConfigSingleton;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class et implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.j> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(MiConfigSingleton.t0);
        jVar.data = optString;
        if (optString == JSONObject.NULL) {
            jVar.data = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = jVar.data;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MiConfigSingleton.t0, jVar.data);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.j jVar, JSONObject jSONObject) {
        a2(jVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.j jVar, JSONObject jSONObject) {
        return b2(jVar, jSONObject);
    }
}
