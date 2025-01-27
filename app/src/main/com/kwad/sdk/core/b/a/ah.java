package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ah implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.ata = jSONObject.optBoolean("retrySwitch");
        cVar.atb = jSONObject.optInt("retryCountConfig", new Integer("1").intValue());
        cVar.atc = jSONObject.optLong("cacheExpireTime", new Long("600").longValue());
        cVar.atd = jSONObject.optInt("retryQueueSize", new Integer("10").intValue());
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = cVar.ata;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "retrySwitch", z10);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "retryCountConfig", cVar.atb);
        com.kwad.sdk.utils.x.putValue(jSONObject, "cacheExpireTime", cVar.atc);
        com.kwad.sdk.utils.x.putValue(jSONObject, "retryQueueSize", cVar.atd);
        return jSONObject;
    }
}
