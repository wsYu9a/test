package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.commercial.model.SDKInitMsg;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hh implements com.kwad.sdk.core.d<SDKInitMsg> {
    /* renamed from: a */
    private static void a2(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sDKInitMsg.launchIntervalTime = jSONObject.optLong("init_launch_interval_time");
        sDKInitMsg.totalDurationTime = jSONObject.optLong("init_total_duration_time");
        sDKInitMsg.initStatus = jSONObject.optInt("init_status", new Integer("0").intValue());
        String optString = jSONObject.optString("error_reason");
        sDKInitMsg.errorReason = optString;
        if (optString == JSONObject.NULL) {
            sDKInitMsg.errorReason = "";
        }
        sDKInitMsg.initCount = jSONObject.optInt("init_count");
        sDKInitMsg.initProcess = jSONObject.optInt("init_process");
        sDKInitMsg.initThread = jSONObject.optInt("init_thread");
        sDKInitMsg.intDynamicSDK = jSONObject.optInt("init_dynamic_sdk");
        sDKInitMsg.intBuildNumber = jSONObject.optInt("init_build_number");
    }

    /* renamed from: b */
    private static JSONObject b2(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = sDKInitMsg.launchIntervalTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_launch_interval_time", j2);
        }
        long j3 = sDKInitMsg.totalDurationTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_total_duration_time", j3);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "init_status", sDKInitMsg.initStatus);
        String str = sDKInitMsg.errorReason;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_reason", sDKInitMsg.errorReason);
        }
        int i2 = sDKInitMsg.initCount;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_count", i2);
        }
        int i3 = sDKInitMsg.initProcess;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_process", i3);
        }
        int i4 = sDKInitMsg.initThread;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_thread", i4);
        }
        int i5 = sDKInitMsg.intDynamicSDK;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_dynamic_sdk", i5);
        }
        int i6 = sDKInitMsg.intBuildNumber;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_build_number", i6);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        a2(sDKInitMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        return b2(sDKInitMsg, jSONObject);
    }
}
