package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hw implements com.kwad.sdk.core.d<com.kwad.sdk.internal.api.b> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.internal.api.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.disableShake = jSONObject.optBoolean("disableShake");
        bVar.disableRotate = jSONObject.optBoolean("disableRotate");
        bVar.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.internal.api.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = bVar.disableShake;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableShake", z);
        }
        boolean z2 = bVar.disableRotate;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableRotate", z2);
        }
        boolean z3 = bVar.disableSlide;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableSlide", z3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.internal.api.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.internal.api.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
