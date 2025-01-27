package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.h.f;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bo implements com.kwad.sdk.core.d<f.a> {
    /* renamed from: a */
    private static void a2(f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.wW = jSONObject.optBoolean("forceClose");
    }

    /* renamed from: b */
    private static JSONObject b2(f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.wW;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "forceClose", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(f.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(f.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
