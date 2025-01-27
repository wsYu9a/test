package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ac implements com.kwad.sdk.core.d<AdInfo.AdRewardInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adRewardInfo.skipShowTime = jSONObject.optInt("skipShowTime", new Integer(BaseWrapper.ENTER_ID_TOOLKIT).intValue());
        adRewardInfo.rewardTime = jSONObject.optInt("rewardTime", new Integer(BaseWrapper.ENTER_ID_TOOLKIT).intValue());
        adRewardInfo.showLandingPage = jSONObject.optInt("showLandingPage");
        adRewardInfo.rewardVideoEndCardSwitch = jSONObject.optBoolean("rewardVideoEndCardSwitch");
        adRewardInfo.recommendAggregateSwitch = jSONObject.optBoolean("recommendAggregateSwitch");
        AdInfo.CallBackStrategyInfo callBackStrategyInfo = new AdInfo.CallBackStrategyInfo();
        adRewardInfo.callBackStrategyInfo = callBackStrategyInfo;
        callBackStrategyInfo.parseJson(jSONObject.optJSONObject("callBackStrategyInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "skipShowTime", adRewardInfo.skipShowTime);
        com.kwad.sdk.utils.t.putValue(jSONObject, "rewardTime", adRewardInfo.rewardTime);
        int i2 = adRewardInfo.showLandingPage;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showLandingPage", i2);
        }
        boolean z = adRewardInfo.rewardVideoEndCardSwitch;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rewardVideoEndCardSwitch", z);
        }
        boolean z2 = adRewardInfo.recommendAggregateSwitch;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "recommendAggregateSwitch", z2);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "callBackStrategyInfo", adRewardInfo.callBackStrategyInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        a2(adRewardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        return b2(adRewardInfo, jSONObject);
    }
}
