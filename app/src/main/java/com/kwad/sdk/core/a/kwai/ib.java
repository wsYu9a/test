package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ib implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.v> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.v vVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        vVar.nZ = jSONObject.optInt("currentTime");
        vVar.Vm = jSONObject.optBoolean("finished");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.v vVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = vVar.nZ;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentTime", i2);
        }
        boolean z = vVar.Vm;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "finished", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.v vVar, JSONObject jSONObject) {
        a2(vVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.v vVar, JSONObject jSONObject) {
        return b2(vVar, jSONObject);
    }
}
