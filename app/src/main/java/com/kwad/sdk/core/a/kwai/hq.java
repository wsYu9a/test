package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hq implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.u> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uVar.Vk = jSONObject.optBoolean("needPromopt");
        uVar.IQ = jSONObject.optBoolean("needReport");
        uVar.showTime = jSONObject.optInt("showTime");
        uVar.Vl = jSONObject.optLong("playDuration");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = uVar.Vk;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "needPromopt", z);
        }
        boolean z2 = uVar.IQ;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "needReport", z2);
        }
        int i2 = uVar.showTime;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showTime", i2);
        }
        long j2 = uVar.Vl;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playDuration", j2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.u uVar, JSONObject jSONObject) {
        a2(uVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.u uVar, JSONObject jSONObject) {
        return b2(uVar, jSONObject);
    }
}
