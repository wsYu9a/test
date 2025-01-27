package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.model.RewardFraudVerifyRespInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class kj implements com.kwad.sdk.core.d<r.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(r.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(r.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(r.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        RewardFraudVerifyRespInfo.FraudDataInfo fraudDataInfo = new RewardFraudVerifyRespInfo.FraudDataInfo();
        aVar.yS = fraudDataInfo;
        fraudDataInfo.parseJson(jSONObject.optJSONObject("verifyResult"));
    }

    /* renamed from: b */
    private static JSONObject b2(r.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.a(jSONObject, "verifyResult", aVar.yS);
        return jSONObject;
    }
}
