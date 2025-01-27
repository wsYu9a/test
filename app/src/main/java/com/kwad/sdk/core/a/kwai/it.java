package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class it implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.b> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("pool_name");
        bVar.ams = optString;
        if (optString == JSONObject.NULL) {
            bVar.ams = "";
        }
        bVar.amt = jSONObject.optInt("core_pool_size");
        bVar.amu = jSONObject.optInt("max_pool_size");
        bVar.amv = jSONObject.optInt("current_pool_size");
        bVar.amw = jSONObject.optInt("active_count");
        bVar.amx = jSONObject.optLong("task_wait_avg_ms");
        bVar.amy = jSONObject.optLong("task_succ_count");
        bVar.interval = jSONObject.optLong("interval_ms");
        bVar.amz = jSONObject.optInt("queue_size");
        bVar.amA = jSONObject.optLong("pass_timestamp");
        bVar.amB = jSONObject.optInt("func_ratio_count");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.ams;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pool_name", bVar.ams);
        }
        int i2 = bVar.amt;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "core_pool_size", i2);
        }
        int i3 = bVar.amu;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "max_pool_size", i3);
        }
        int i4 = bVar.amv;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "current_pool_size", i4);
        }
        int i5 = bVar.amw;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "active_count", i5);
        }
        long j2 = bVar.amx;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "task_wait_avg_ms", j2);
        }
        long j3 = bVar.amy;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "task_succ_count", j3);
        }
        long j4 = bVar.interval;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "interval_ms", j4);
        }
        int i6 = bVar.amz;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "queue_size", i6);
        }
        long j5 = bVar.amA;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pass_timestamp", j5);
        }
        int i7 = bVar.amB;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "func_ratio_count", i7);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
