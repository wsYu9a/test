package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class jh implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.t> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        a2(tVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        return b2(tVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tVar.ady = jSONObject.optBoolean("needPromopt");
        tVar.MG = jSONObject.optBoolean("needReport");
        tVar.showTime = jSONObject.optInt("showTime");
        tVar.YF = jSONObject.optLong("playDuration");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = tVar.ady;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "needPromopt", z10);
        }
        boolean z11 = tVar.MG;
        if (z11) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "needReport", z11);
        }
        int i10 = tVar.showTime;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "showTime", i10);
        }
        long j10 = tVar.YF;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "playDuration", j10);
        }
        return jSONObject;
    }
}
