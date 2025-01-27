package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class cb implements com.kwad.sdk.core.d<AdInfo.CallBackStrategyInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.CallBackStrategyInfo callBackStrategyInfo, JSONObject jSONObject) {
        a2(callBackStrategyInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.CallBackStrategyInfo callBackStrategyInfo, JSONObject jSONObject) {
        return b2(callBackStrategyInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdInfo.CallBackStrategyInfo callBackStrategyInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        callBackStrategyInfo.impressionCheckMs = jSONObject.optInt("impressionCheckMs", new Integer("5000").intValue());
        callBackStrategyInfo.callBackAdvanceMs = jSONObject.optInt("callBackAdvanceMs", new Integer("2000").intValue());
        callBackStrategyInfo.serverCheckSwitch = jSONObject.optBoolean("serverCheckSwitch");
        callBackStrategyInfo.rewardAdvanceSwitch = jSONObject.optBoolean("rewardAdvanceSwitch");
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.CallBackStrategyInfo callBackStrategyInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "impressionCheckMs", callBackStrategyInfo.impressionCheckMs);
        com.kwad.sdk.utils.x.putValue(jSONObject, "callBackAdvanceMs", callBackStrategyInfo.callBackAdvanceMs);
        boolean z10 = callBackStrategyInfo.serverCheckSwitch;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "serverCheckSwitch", z10);
        }
        boolean z11 = callBackStrategyInfo.rewardAdvanceSwitch;
        if (z11) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "rewardAdvanceSwitch", z11);
        }
        return jSONObject;
    }
}
