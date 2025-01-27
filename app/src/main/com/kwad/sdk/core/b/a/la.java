package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class la implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.v> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.v vVar, JSONObject jSONObject) {
        a2(vVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.v vVar, JSONObject jSONObject) {
        return b2(vVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.v vVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        vVar.adz = jSONObject.optInt("rewardTaskState");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.v vVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = vVar.adz;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "rewardTaskState", i10);
        }
        return jSONObject;
    }
}
