package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import com.sigmob.sdk.base.mta.PointType;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class an implements com.kwad.sdk.core.d<AdInfo.AdRewardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        a2(adRewardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        return b2(adRewardInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adRewardInfo.skipShowTime = jSONObject.optInt("skipShowTime", new Integer(PointType.DOWNLOAD_TRACKING).intValue());
        adRewardInfo.rewardTime = jSONObject.optInt("rewardTime", new Integer(PointType.DOWNLOAD_TRACKING).intValue());
        adRewardInfo.showLandingPage = jSONObject.optInt("showLandingPage");
        adRewardInfo.rewardVideoEndCardSwitch = jSONObject.optBoolean("rewardVideoEndCardSwitch");
        adRewardInfo.recommendAggregateSwitch = jSONObject.optBoolean("recommendAggregateSwitch");
        AdInfo.CallBackStrategyInfo callBackStrategyInfo = new AdInfo.CallBackStrategyInfo();
        adRewardInfo.callBackStrategyInfo = callBackStrategyInfo;
        callBackStrategyInfo.parseJson(jSONObject.optJSONObject("callBackStrategyInfo"));
        AdInfo.RewardFraudVerifyInfo rewardFraudVerifyInfo = new AdInfo.RewardFraudVerifyInfo();
        adRewardInfo.rewardFraudVerifyInfo = rewardFraudVerifyInfo;
        rewardFraudVerifyInfo.parseJson(jSONObject.optJSONObject("rewardFraudVerifyInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "skipShowTime", adRewardInfo.skipShowTime);
        com.kwad.sdk.utils.x.putValue(jSONObject, "rewardTime", adRewardInfo.rewardTime);
        int i10 = adRewardInfo.showLandingPage;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "showLandingPage", i10);
        }
        boolean z10 = adRewardInfo.rewardVideoEndCardSwitch;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "rewardVideoEndCardSwitch", z10);
        }
        boolean z11 = adRewardInfo.recommendAggregateSwitch;
        if (z11) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "recommendAggregateSwitch", z11);
        }
        com.kwad.sdk.utils.x.a(jSONObject, "callBackStrategyInfo", adRewardInfo.callBackStrategyInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "rewardFraudVerifyInfo", adRewardInfo.rewardFraudVerifyInfo);
        return jSONObject;
    }
}
