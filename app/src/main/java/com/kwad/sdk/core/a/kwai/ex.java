package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ex implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.b.b> {
    /* renamed from: a */
    private static void a2(com.kwad.components.ad.reward.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.rs = jSONObject.optInt("extraRewardType", new Integer("2").intValue());
        bVar.rt = jSONObject.optInt("extraRewardStatus");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.ad.reward.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "extraRewardType", bVar.rs);
        int i2 = bVar.rt;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "extraRewardStatus", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.reward.b.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.reward.b.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
