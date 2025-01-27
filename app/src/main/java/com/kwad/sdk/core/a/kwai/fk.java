package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fk implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.kwai.c> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.crash.online.monitor.kwai.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.kwad.sdk.crash.online.monitor.kwai.a aVar = new com.kwad.sdk.crash.online.monitor.kwai.a();
        cVar.ast = aVar;
        aVar.parseJson(jSONObject.optJSONObject("blockConfig"));
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.kwai.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "blockConfig", cVar.ast);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.kwai.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.kwai.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
