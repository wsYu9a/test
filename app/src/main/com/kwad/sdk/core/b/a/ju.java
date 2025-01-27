package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ju implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.u> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.u uVar, JSONObject jSONObject) {
        a2(uVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.u uVar, JSONObject jSONObject) {
        return b2(uVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uVar.oZ = jSONObject.optInt("currentTime");
        uVar.Tz = jSONObject.optBoolean("finished");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = uVar.oZ;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "currentTime", i10);
        }
        boolean z10 = uVar.Tz;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "finished", z10);
        }
        return jSONObject;
    }
}
