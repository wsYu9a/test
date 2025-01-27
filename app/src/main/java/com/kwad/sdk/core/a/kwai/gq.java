package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gq implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.posId = jSONObject.optLong("posId");
        aVar.alO = jSONObject.optInt("adPhotoCountForMedia");
        aVar.alP = jSONObject.optBoolean("enablePreload");
        aVar.alQ = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        aVar.alR = jSONObject.optInt("adLoadStrategy");
        aVar.alS = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = aVar.posId;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j2);
        }
        int i2 = aVar.alO;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adPhotoCountForMedia", i2);
        }
        boolean z = aVar.alP;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enablePreload", z);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "increaseAdLoadTime", aVar.alQ);
        int i3 = aVar.alR;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adLoadStrategy", i3);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "drawAdForcedWatchTimes", aVar.alS);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
