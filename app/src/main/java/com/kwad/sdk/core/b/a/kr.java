package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class kr implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aEO = jSONObject.optString("pool_name");
        if (JSONObject.NULL.toString().equals(bVar.aEO)) {
            bVar.aEO = "";
        }
        bVar.aEP = jSONObject.optInt("core_pool_size");
        bVar.aEQ = jSONObject.optInt("max_pool_size");
        bVar.aER = jSONObject.optInt("current_pool_size");
        bVar.aES = jSONObject.optInt("active_count");
        bVar.aET = jSONObject.optLong("task_wait_avg_ms");
        bVar.aEU = jSONObject.optLong("task_succ_count");
        bVar.interval = jSONObject.optLong("interval_ms");
        bVar.aEV = jSONObject.optInt("queue_size");
        bVar.aEW = jSONObject.optLong("pass_timestamp");
        bVar.aEX = jSONObject.optInt("func_ratio_count");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aEO;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "pool_name", bVar.aEO);
        }
        int i10 = bVar.aEP;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "core_pool_size", i10);
        }
        int i11 = bVar.aEQ;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "max_pool_size", i11);
        }
        int i12 = bVar.aER;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "current_pool_size", i12);
        }
        int i13 = bVar.aES;
        if (i13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "active_count", i13);
        }
        long j10 = bVar.aET;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "task_wait_avg_ms", j10);
        }
        long j11 = bVar.aEU;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "task_succ_count", j11);
        }
        long j12 = bVar.interval;
        if (j12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "interval_ms", j12);
        }
        int i14 = bVar.aEV;
        if (i14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "queue_size", i14);
        }
        long j13 = bVar.aEW;
        if (j13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "pass_timestamp", j13);
        }
        int i15 = bVar.aEX;
        if (i15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "func_ratio_count", i15);
        }
        return jSONObject;
    }
}
