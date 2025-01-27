package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class jc implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.x> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.x xVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xVar.Vo = jSONObject.optInt("videoCloseTime", new Integer("0").intValue());
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.x xVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "videoCloseTime", xVar.Vo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.x xVar, JSONObject jSONObject) {
        a2(xVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.x xVar, JSONObject jSONObject) {
        return b2(xVar, jSONObject);
    }
}
