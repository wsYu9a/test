package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.check.RewardCheckMonitorInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gx implements com.kwad.sdk.core.d<RewardCheckMonitorInfo> {
    /* renamed from: a */
    private static void a2(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardCheckMonitorInfo.checkType = jSONObject.optInt("check_type");
        rewardCheckMonitorInfo.requestStatus = jSONObject.optInt("request_state");
        rewardCheckMonitorInfo.code = jSONObject.optInt("code");
        String optString = jSONObject.optString("error_msg");
        rewardCheckMonitorInfo.errorMsg = optString;
        if (optString == JSONObject.NULL) {
            rewardCheckMonitorInfo.errorMsg = "";
        }
        rewardCheckMonitorInfo.creativeId = jSONObject.optLong("creative_id");
        rewardCheckMonitorInfo.dataLoadInterval = jSONObject.optLong("data_load_interval_duration_ms");
        rewardCheckMonitorInfo.posId = jSONObject.optLong("pos_Id");
        rewardCheckMonitorInfo.enviType = jSONObject.optInt("enviType");
    }

    /* renamed from: b */
    private static JSONObject b2(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = rewardCheckMonitorInfo.checkType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "check_type", i2);
        }
        int i3 = rewardCheckMonitorInfo.requestStatus;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_state", i3);
        }
        int i4 = rewardCheckMonitorInfo.code;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "code", i4);
        }
        String str = rewardCheckMonitorInfo.errorMsg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_msg", rewardCheckMonitorInfo.errorMsg);
        }
        long j2 = rewardCheckMonitorInfo.creativeId;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creative_id", j2);
        }
        long j3 = rewardCheckMonitorInfo.dataLoadInterval;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "data_load_interval_duration_ms", j3);
        }
        long j4 = rewardCheckMonitorInfo.posId;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pos_Id", j4);
        }
        int i5 = rewardCheckMonitorInfo.enviType;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enviType", i5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        a2(rewardCheckMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        return b2(rewardCheckMonitorInfo, jSONObject);
    }
}
