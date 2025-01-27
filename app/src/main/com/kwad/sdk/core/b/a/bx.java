package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bx implements com.kwad.sdk.core.d<BlockEvent> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(BlockEvent blockEvent, JSONObject jSONObject) {
        a2(blockEvent, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(BlockEvent blockEvent, JSONObject jSONObject) {
        return b2(blockEvent, jSONObject);
    }

    /* renamed from: a */
    private static void a2(BlockEvent blockEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        blockEvent.blockDuration = jSONObject.optLong("blockDuration");
        blockEvent.blockTimeThreshold = jSONObject.optLong("blockTimeThreshold", new Long("1000").longValue());
        blockEvent.blockLoopInterval = jSONObject.optLong("blockLoopInterval", new Long("100").longValue());
        blockEvent.calcBlockOverhead = jSONObject.optLong("calcBlockOverhead");
        blockEvent.currentActivity = jSONObject.optString("currentActivity");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(blockEvent.currentActivity)) {
            blockEvent.currentActivity = "";
        }
        blockEvent.processName = jSONObject.optString("processName");
        if (obj.toString().equals(blockEvent.processName)) {
            blockEvent.processName = "";
        }
        blockEvent.stackTraceSample = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("stackTraceSample");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                BlockEvent.a aVar = new BlockEvent.a();
                aVar.parseJson(optJSONArray.optJSONObject(i10));
                blockEvent.stackTraceSample.add(aVar);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(BlockEvent blockEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = blockEvent.blockDuration;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "blockDuration", j10);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "blockTimeThreshold", blockEvent.blockTimeThreshold);
        com.kwad.sdk.utils.x.putValue(jSONObject, "blockLoopInterval", blockEvent.blockLoopInterval);
        long j11 = blockEvent.calcBlockOverhead;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "calcBlockOverhead", j11);
        }
        String str = blockEvent.currentActivity;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "currentActivity", blockEvent.currentActivity);
        }
        String str2 = blockEvent.processName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "processName", blockEvent.processName);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "stackTraceSample", blockEvent.stackTraceSample);
        return jSONObject;
    }
}
