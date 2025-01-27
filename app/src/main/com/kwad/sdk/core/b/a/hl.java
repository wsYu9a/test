package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class hl implements com.kwad.sdk.core.d<com.kwad.components.core.n.c.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.n.c.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.n.c.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.n.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.PV = jSONObject.optString("load_module");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.PV)) {
            bVar.PV = "";
        }
        bVar.PW = jSONObject.optLong("load_status");
        bVar.PX = jSONObject.optLong("load_duration_ms");
        bVar.PY = jSONObject.optLong("thread_core_size", new Long("0").longValue());
        bVar.PZ = jSONObject.optString("load_source");
        if (obj.toString().equals(bVar.PZ)) {
            bVar.PZ = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.n.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.PV;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "load_module", bVar.PV);
        }
        long j10 = bVar.PW;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "load_status", j10);
        }
        long j11 = bVar.PX;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "load_duration_ms", j11);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "thread_core_size", bVar.PY);
        String str2 = bVar.PZ;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "load_source", bVar.PZ);
        }
        return jSONObject;
    }
}
