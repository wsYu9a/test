package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ae implements com.kwad.sdk.core.d<AdInfo.AdSplashInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adSplashInfo.logoPosition = jSONObject.optInt("logoPosition", new Integer("1").intValue());
        adSplashInfo.mute = jSONObject.optInt("mute", new Integer("1").intValue());
        adSplashInfo.skipType = jSONObject.optInt("skipType");
        String optString = jSONObject.optString("skipTips");
        adSplashInfo.skipTips = optString;
        if (optString == JSONObject.NULL) {
            adSplashInfo.skipTips = "";
        }
        String optString2 = jSONObject.optString("speakerMuteIconUrl");
        adSplashInfo.speakerMuteIconUrl = optString2;
        if (optString2 == JSONObject.NULL) {
            adSplashInfo.speakerMuteIconUrl = "";
        }
        String optString3 = jSONObject.optString("speakerIconUrl");
        adSplashInfo.speakerIconUrl = optString3;
        if (optString3 == JSONObject.NULL) {
            adSplashInfo.speakerIconUrl = "";
        }
        adSplashInfo.imageDisplaySecond = jSONObject.optInt("imageDisplaySecond", new Integer("5").intValue());
        adSplashInfo.videoDisplaySecond = jSONObject.optInt("videoDisplaySecond", new Integer("5").intValue());
        adSplashInfo.countdownShow = jSONObject.optInt("countdownShow");
        adSplashInfo.fullScreenClickSwitch = jSONObject.optInt("fullScreenClickSwitch");
        adSplashInfo.skipButtonPosition = jSONObject.optInt("skipButtonPosition");
        adSplashInfo.splashShowClickButtonSwitch = jSONObject.optInt("splashShowClickButtonSwitch", new Integer("1").intValue());
        adSplashInfo.skipSecond = jSONObject.optInt("skipSecond");
        AdInfo.CutRuleInfo cutRuleInfo = new AdInfo.CutRuleInfo();
        adSplashInfo.cutRuleInfo = cutRuleInfo;
        cutRuleInfo.parseJson(jSONObject.optJSONObject("cutRuleInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "logoPosition", adSplashInfo.logoPosition);
        com.kwad.sdk.utils.t.putValue(jSONObject, "mute", adSplashInfo.mute);
        int i2 = adSplashInfo.skipType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "skipType", i2);
        }
        String str = adSplashInfo.skipTips;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "skipTips", adSplashInfo.skipTips);
        }
        String str2 = adSplashInfo.speakerMuteIconUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "speakerMuteIconUrl", adSplashInfo.speakerMuteIconUrl);
        }
        String str3 = adSplashInfo.speakerIconUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "speakerIconUrl", adSplashInfo.speakerIconUrl);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "imageDisplaySecond", adSplashInfo.imageDisplaySecond);
        com.kwad.sdk.utils.t.putValue(jSONObject, "videoDisplaySecond", adSplashInfo.videoDisplaySecond);
        int i3 = adSplashInfo.countdownShow;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "countdownShow", i3);
        }
        int i4 = adSplashInfo.fullScreenClickSwitch;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fullScreenClickSwitch", i4);
        }
        int i5 = adSplashInfo.skipButtonPosition;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "skipButtonPosition", i5);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "splashShowClickButtonSwitch", adSplashInfo.splashShowClickButtonSwitch);
        int i6 = adSplashInfo.skipSecond;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "skipSecond", i6);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "cutRuleInfo", adSplashInfo.cutRuleInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        a2(adSplashInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        return b2(adSplashInfo, jSONObject);
    }
}
