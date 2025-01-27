package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ku implements com.kwad.sdk.core.d<BlockEvent.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(BlockEvent.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(BlockEvent.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aKX = jSONObject.optLong("endTimestamp");
        aVar.repeatCount = jSONObject.optInt("repeatCount", new Integer("1").intValue());
        aVar.aKY = jSONObject.optBoolean("runIdle");
        aVar.aKZ = jSONObject.optString("stackTraceDetail");
        if (JSONObject.NULL.toString().equals(aVar.aKZ)) {
            aVar.aKZ = "";
        }
        aVar.aLa = jSONObject.optLong("startTimestamp");
    }

    /* renamed from: b */
    private static JSONObject b2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = aVar.aKX;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "endTimestamp", j10);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "repeatCount", aVar.repeatCount);
        boolean z10 = aVar.aKY;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "runIdle", z10);
        }
        String str = aVar.aKZ;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "stackTraceDetail", aVar.aKZ);
        }
        long j11 = aVar.aLa;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "startTimestamp", j11);
        }
        return jSONObject;
    }
}
