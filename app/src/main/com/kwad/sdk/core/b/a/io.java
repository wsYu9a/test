package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class io implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.h.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.reward.h.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.reward.h.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.ad.reward.h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.hY = jSONObject.optLong("lastShowTimestamp");
        bVar.tr = jSONObject.optInt("jumpDirectCount");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.ad.reward.h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = bVar.hY;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "lastShowTimestamp", j10);
        }
        int i10 = bVar.tr;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "jumpDirectCount", i10);
        }
        return jSONObject;
    }
}
