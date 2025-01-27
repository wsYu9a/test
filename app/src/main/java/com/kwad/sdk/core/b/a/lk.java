package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class lk implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.y> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        a2(yVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        return b2(yVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        yVar.oZ = jSONObject.optInt("currentTime");
        yVar.adC = jSONObject.optBoolean(p3.e.f29726i);
        yVar.Tz = jSONObject.optBoolean("finished");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = yVar.oZ;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "currentTime", i10);
        }
        boolean z10 = yVar.adC;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, p3.e.f29726i, z10);
        }
        boolean z11 = yVar.Tz;
        if (z11) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "finished", z11);
        }
        return jSONObject;
    }
}
