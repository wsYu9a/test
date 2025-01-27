package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bc implements com.kwad.sdk.core.d<BlockEvent> {
    /* renamed from: a */
    private static void a2(BlockEvent blockEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        blockEvent.blockDuration = jSONObject.optLong("blockDuration");
        blockEvent.blockTimeThreshold = jSONObject.optLong("blockTimeThreshold", new Long(Constants.DEFAULT_UIN).longValue());
        blockEvent.blockLoopInterval = jSONObject.optLong("blockLoopInterval", new Long("100").longValue());
        blockEvent.calcBlockOverhead = jSONObject.optLong("calcBlockOverhead");
        String optString = jSONObject.optString("currentActivity");
        blockEvent.currentActivity = optString;
        if (optString == JSONObject.NULL) {
            blockEvent.currentActivity = "";
        }
        String optString2 = jSONObject.optString("processName");
        blockEvent.processName = optString2;
        if (optString2 == JSONObject.NULL) {
            blockEvent.processName = "";
        }
        blockEvent.stackTraceSample = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("stackTraceSample");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                BlockEvent.a aVar = new BlockEvent.a();
                aVar.parseJson(optJSONArray.optJSONObject(i2));
                blockEvent.stackTraceSample.add(aVar);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(BlockEvent blockEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = blockEvent.blockDuration;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockDuration", j2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "blockTimeThreshold", blockEvent.blockTimeThreshold);
        com.kwad.sdk.utils.t.putValue(jSONObject, "blockLoopInterval", blockEvent.blockLoopInterval);
        long j3 = blockEvent.calcBlockOverhead;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "calcBlockOverhead", j3);
        }
        String str = blockEvent.currentActivity;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentActivity", blockEvent.currentActivity);
        }
        String str2 = blockEvent.processName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "processName", blockEvent.processName);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "stackTraceSample", blockEvent.stackTraceSample);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(BlockEvent blockEvent, JSONObject jSONObject) {
        a2(blockEvent, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(BlockEvent blockEvent, JSONObject jSONObject) {
        return b2(blockEvent, jSONObject);
    }
}
