package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class kz implements com.kwad.sdk.core.d<com.kwad.components.core.n.c.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.n.c.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.n.c.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.n.c.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.PV = jSONObject.optString("load_module");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(dVar.PV)) {
            dVar.PV = "";
        }
        dVar.PW = jSONObject.optLong("load_status");
        dVar.PX = jSONObject.optLong("load_duration_ms");
        dVar.Qa = jSONObject.optLong("update_duration_ms");
        dVar.PZ = jSONObject.optString("load_source");
        if (obj.toString().equals(dVar.PZ)) {
            dVar.PZ = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.n.c.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.PV;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "load_module", dVar.PV);
        }
        long j10 = dVar.PW;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "load_status", j10);
        }
        long j11 = dVar.PX;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "load_duration_ms", j11);
        }
        long j12 = dVar.Qa;
        if (j12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "update_duration_ms", j12);
        }
        String str2 = dVar.PZ;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "load_source", dVar.PZ);
        }
        return jSONObject;
    }
}
