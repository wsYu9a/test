package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.if */
/* loaded from: classes3.dex */
public final class Cif implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.posId = jSONObject.optLong("posId");
        aVar.aEh = jSONObject.optInt("adPhotoCountForMedia");
        aVar.aEi = jSONObject.optBoolean("enablePreload");
        aVar.aEj = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        aVar.aEk = jSONObject.optInt("adLoadStrategy");
        aVar.aEl = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = aVar.posId;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "posId", j10);
        }
        int i10 = aVar.aEh;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adPhotoCountForMedia", i10);
        }
        boolean z10 = aVar.aEi;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "enablePreload", z10);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "increaseAdLoadTime", aVar.aEj);
        int i11 = aVar.aEk;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adLoadStrategy", i11);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "drawAdForcedWatchTimes", aVar.aEl);
        return jSONObject;
    }
}
