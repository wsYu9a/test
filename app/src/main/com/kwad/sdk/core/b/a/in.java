package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class in implements com.kwad.sdk.core.d<AdInfo.RewardFraudVerifyInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.RewardFraudVerifyInfo rewardFraudVerifyInfo, JSONObject jSONObject) {
        a2(rewardFraudVerifyInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.RewardFraudVerifyInfo rewardFraudVerifyInfo, JSONObject jSONObject) {
        return b2(rewardFraudVerifyInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdInfo.RewardFraudVerifyInfo rewardFraudVerifyInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardFraudVerifyInfo.fraudVerifyAdvanceMs = jSONObject.optInt("fraudVerifyAdvanceMs", new Integer("2000").intValue());
        rewardFraudVerifyInfo.fraudVerifySwitch = jSONObject.optBoolean("fraudVerifySwitch");
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.RewardFraudVerifyInfo rewardFraudVerifyInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "fraudVerifyAdvanceMs", rewardFraudVerifyInfo.fraudVerifyAdvanceMs);
        boolean z10 = rewardFraudVerifyInfo.fraudVerifySwitch;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "fraudVerifySwitch", z10);
        }
        return jSONObject;
    }
}
