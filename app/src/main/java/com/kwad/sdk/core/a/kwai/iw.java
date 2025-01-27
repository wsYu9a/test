package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class iw implements com.kwad.sdk.core.d<BlockEvent.a> {
    /* renamed from: a */
    private static void a2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.arN = jSONObject.optLong("endTimestamp");
        aVar.repeatCount = jSONObject.optInt("repeatCount", new Integer("1").intValue());
        aVar.arO = jSONObject.optBoolean("runIdle");
        String optString = jSONObject.optString("stackTraceDetail");
        aVar.arP = optString;
        if (optString == JSONObject.NULL) {
            aVar.arP = "";
        }
        aVar.arQ = jSONObject.optLong("startTimestamp");
    }

    /* renamed from: b */
    private static JSONObject b2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = aVar.arN;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "endTimestamp", j2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "repeatCount", aVar.repeatCount);
        boolean z = aVar.arO;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "runIdle", z);
        }
        String str = aVar.arP;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "stackTraceDetail", aVar.arP);
        }
        long j3 = aVar.arQ;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "startTimestamp", j3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(BlockEvent.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(BlockEvent.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
