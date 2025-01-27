package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class fr implements com.kwad.sdk.core.d<com.kwad.components.ad.interstitial.d.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.interstitial.d.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.interstitial.d.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.ad.interstitial.d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.kN = jSONObject.optLong("lastShowCardTimeStamp");
        aVar.kO = jSONObject.optInt("cardShowCount");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.ad.interstitial.d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = aVar.kN;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "lastShowCardTimeStamp", j10);
        }
        int i10 = aVar.kO;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "cardShowCount", i10);
        }
        return jSONObject;
    }
}
