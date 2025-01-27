package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class jh implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.z> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.z zVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        zVar.nZ = jSONObject.optInt("currentTime");
        zVar.Vq = jSONObject.optBoolean(com.alipay.sdk.util.g.f5460a);
        zVar.Vm = jSONObject.optBoolean("finished");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.z zVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = zVar.nZ;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentTime", i2);
        }
        boolean z = zVar.Vq;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.alipay.sdk.util.g.f5460a, z);
        }
        boolean z2 = zVar.Vm;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "finished", z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.z zVar, JSONObject jSONObject) {
        a2(zVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.z zVar, JSONObject jSONObject) {
        return b2(zVar, jSONObject);
    }
}
