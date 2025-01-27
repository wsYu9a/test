package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fv implements com.kwad.sdk.core.d<com.kwad.components.core.offline.b> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.offline.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.JX = jSONObject.optInt("load_module");
        bVar.JY = jSONObject.optLong("load_status");
        bVar.JZ = jSONObject.optLong("load_duration_ms");
        bVar.Ka = jSONObject.optLong("error_code");
        bVar.Kb = jSONObject.optLong("error_msg");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.offline.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = bVar.JX;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_module", i2);
        }
        long j2 = bVar.JY;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_status", j2);
        }
        long j3 = bVar.JZ;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_duration_ms", j3);
        }
        long j4 = bVar.Ka;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_code", j4);
        }
        long j5 = bVar.Kb;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_msg", j5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.offline.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.offline.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
