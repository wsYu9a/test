package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class iu implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.d> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.amD = jSONObject.optInt("rate_reciprocal");
        dVar.amJ = jSONObject.optInt("threshold");
        dVar.interval = jSONObject.optLong(com.umeng.analytics.pro.am.aU);
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = dVar.amD;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rate_reciprocal", i2);
        }
        int i3 = dVar.amJ;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "threshold", i3);
        }
        long j2 = dVar.interval;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.umeng.analytics.pro.am.aU, j2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }
}
