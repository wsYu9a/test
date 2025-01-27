package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class du implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.i> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        iVar.rewardTime = jSONObject.optInt("rewardTime");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = iVar.rewardTime;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rewardTime", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.i iVar, JSONObject jSONObject) {
        a2(iVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.i iVar, JSONObject jSONObject) {
        return b2(iVar, jSONObject);
    }
}
