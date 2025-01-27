package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ks implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aEZ = jSONObject.optInt("rate_reciprocal");
        dVar.aFf = jSONObject.optInt("threshold");
        dVar.interval = jSONObject.optLong(com.umeng.analytics.pro.bt.f23596ba);
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = dVar.aEZ;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "rate_reciprocal", i10);
        }
        int i11 = dVar.aFf;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "threshold", i11);
        }
        long j10 = dVar.interval;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, com.umeng.analytics.pro.bt.f23596ba, j10);
        }
        return jSONObject;
    }
}
