package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ag implements com.kwad.sdk.core.d<AdInfo.AdStyleConfInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStyleConfInfo.fullScreenSkipShowTime = jSONObject.optInt("fullScreenSkipShowTime", new Integer("5").intValue());
        adStyleConfInfo.rewardSkipConfirmSwitch = jSONObject.optInt("rewardSkipConfirmSwitch", new Integer("1").intValue());
        adStyleConfInfo.closeDelaySeconds = jSONObject.optLong("closeDelaySeconds");
        adStyleConfInfo.playableCloseSeconds = jSONObject.optLong("playableCloseSeconds");
        adStyleConfInfo.rewardVideoInteractSwitch = jSONObject.optBoolean("rewardVideoInteractSwitch");
        AdInfo.AdShowVideoH5Info adShowVideoH5Info = new AdInfo.AdShowVideoH5Info();
        adStyleConfInfo.adShowVideoH5Info = adShowVideoH5Info;
        adShowVideoH5Info.parseJson(jSONObject.optJSONObject("adShowVideoH5Info"));
        adStyleConfInfo.adPushSwitch = jSONObject.optBoolean("adPushSwitch");
        adStyleConfInfo.adPushShowAfterTime = jSONObject.optInt("adPushShowAfterTime");
        adStyleConfInfo.adPushIntervalTime = jSONObject.optInt("adPushIntervalTime", new Integer("900").intValue());
        AdInfo.NativeAdInfo nativeAdInfo = new AdInfo.NativeAdInfo();
        adStyleConfInfo.nativeAdInfo = nativeAdInfo;
        nativeAdInfo.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        adStyleConfInfo.useNativeForOuterLiveAd = jSONObject.optBoolean("useNativeForOuterLiveAd");
        adStyleConfInfo.adPushDownloadJumpType = jSONObject.optInt("adPushDownloadJumpType");
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "fullScreenSkipShowTime", adStyleConfInfo.fullScreenSkipShowTime);
        com.kwad.sdk.utils.t.putValue(jSONObject, "rewardSkipConfirmSwitch", adStyleConfInfo.rewardSkipConfirmSwitch);
        long j2 = adStyleConfInfo.closeDelaySeconds;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeDelaySeconds", j2);
        }
        long j3 = adStyleConfInfo.playableCloseSeconds;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playableCloseSeconds", j3);
        }
        boolean z = adStyleConfInfo.rewardVideoInteractSwitch;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rewardVideoInteractSwitch", z);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "adShowVideoH5Info", adStyleConfInfo.adShowVideoH5Info);
        boolean z2 = adStyleConfInfo.adPushSwitch;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adPushSwitch", z2);
        }
        int i2 = adStyleConfInfo.adPushShowAfterTime;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adPushShowAfterTime", i2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "adPushIntervalTime", adStyleConfInfo.adPushIntervalTime);
        com.kwad.sdk.utils.t.a(jSONObject, "nativeAdInfo", adStyleConfInfo.nativeAdInfo);
        boolean z3 = adStyleConfInfo.useNativeForOuterLiveAd;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "useNativeForOuterLiveAd", z3);
        }
        int i3 = adStyleConfInfo.adPushDownloadJumpType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adPushDownloadJumpType", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        a2(adStyleConfInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        return b2(adStyleConfInfo, jSONObject);
    }
}
