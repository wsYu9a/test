package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class av implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.model.b> {
    /* renamed from: a */
    private static void a2(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.jl = jSONObject.optLong("lastShowCardTimeStamp");
        bVar.jm = jSONObject.optInt("cardShowCount");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = bVar.jl;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "lastShowCardTimeStamp", j2);
        }
        int i2 = bVar.jm;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardShowCount", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
