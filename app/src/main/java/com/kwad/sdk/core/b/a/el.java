package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.model.RewardFraudVerifyRespInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class el implements com.kwad.sdk.core.d<RewardFraudVerifyRespInfo.FraudDataInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(RewardFraudVerifyRespInfo.FraudDataInfo fraudDataInfo, JSONObject jSONObject) {
        a2(fraudDataInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(RewardFraudVerifyRespInfo.FraudDataInfo fraudDataInfo, JSONObject jSONObject) {
        return b2(fraudDataInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(RewardFraudVerifyRespInfo.FraudDataInfo fraudDataInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fraudDataInfo.fraud = jSONObject.optBoolean("fraud");
        fraudDataInfo.code = jSONObject.optInt("code");
    }

    /* renamed from: b */
    private static JSONObject b2(RewardFraudVerifyRespInfo.FraudDataInfo fraudDataInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = fraudDataInfo.fraud;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "fraud", z10);
        }
        int i10 = fraudDataInfo.code;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "code", i10);
        }
        return jSONObject;
    }
}
