package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class l implements com.kwad.sdk.core.d<AdInfo.AdConversionInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("h5Url");
        adConversionInfo.h5Url = optString;
        if (optString == JSONObject.NULL) {
            adConversionInfo.h5Url = "";
        }
        adConversionInfo.h5Type = jSONObject.optInt("h5Type");
        String optString2 = jSONObject.optString("deeplinkUrl");
        adConversionInfo.deeplinkUrl = optString2;
        if (optString2 == JSONObject.NULL) {
            adConversionInfo.deeplinkUrl = "";
        }
        adConversionInfo.deeplinkConf = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("deeplinkConf");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo = new AdInfo.AdConversionInfo.DeeplinkItemInfo();
                deeplinkItemInfo.parseJson(optJSONArray.optJSONObject(i2));
                adConversionInfo.deeplinkConf.add(deeplinkItemInfo);
            }
        }
        String optString3 = jSONObject.optString("deeplinkExtra");
        adConversionInfo.deeplinkExtra = optString3;
        if (optString3 == JSONObject.NULL) {
            adConversionInfo.deeplinkExtra = "";
        }
        String optString4 = jSONObject.optString("appDownloadUrl");
        adConversionInfo.appDownloadUrl = optString4;
        if (optString4 == JSONObject.NULL) {
            adConversionInfo.appDownloadUrl = "";
        }
        String optString5 = jSONObject.optString("marketUrl");
        adConversionInfo.marketUrl = optString5;
        if (optString5 == JSONObject.NULL) {
            adConversionInfo.marketUrl = "";
        }
        adConversionInfo.supportThirdDownload = jSONObject.optInt("supportThirdDownload");
        adConversionInfo.retryH5TimeStep = jSONObject.optInt("retryH5TimeStep", new Integer("2000").intValue());
        String optString6 = jSONObject.optString("playableUrl");
        adConversionInfo.playableUrl = optString6;
        if (optString6 == JSONObject.NULL) {
            adConversionInfo.playableUrl = "";
        }
        AdInfo.PlayableStyleInfo playableStyleInfo = new AdInfo.PlayableStyleInfo();
        adConversionInfo.playableStyleInfo = playableStyleInfo;
        playableStyleInfo.parseJson(jSONObject.optJSONObject("playableStyleInfo"));
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = new AdInfo.SmallAppJumpInfo();
        adConversionInfo.smallAppJumpInfo = smallAppJumpInfo;
        smallAppJumpInfo.parseJson(jSONObject.optJSONObject("smallAppJumpInfo"));
        adConversionInfo.webUriSourceType = jSONObject.optInt("webUriSourceType");
        String optString7 = jSONObject.optString("callbackUrl");
        adConversionInfo.callbackUrl = optString7;
        if (optString7 == JSONObject.NULL) {
            adConversionInfo.callbackUrl = "";
        }
        String optString8 = jSONObject.optString("callbackUrlInfo");
        adConversionInfo.callbackUrlInfo = optString8;
        if (optString8 == JSONObject.NULL) {
            adConversionInfo.callbackUrlInfo = "";
        }
        adConversionInfo.blockCallbackIfSpam = jSONObject.optBoolean("blockCallbackIfSpam");
        adConversionInfo.needDeeplinkReplaceAdapta = jSONObject.optBoolean("needDeeplinkReplaceAdapta");
        adConversionInfo.h5DeeplinkLimitedTimeMs = jSONObject.optInt("h5DeeplinkLimitedTimeMs", new Integer("0").intValue());
        adConversionInfo.playableDeeplinkLimitedTimeMs = jSONObject.optInt("playableDeeplinkLimitedTimeMs", new Integer("0").intValue());
        adConversionInfo.isSupportKeepPlaying = jSONObject.optBoolean("isSupportKeepPlaying");
        adConversionInfo.keepPlayingBackOffTime = jSONObject.optLong("keepPlayingBackOffTime", new Long("3000").longValue());
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adConversionInfo.h5Url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "h5Url", adConversionInfo.h5Url);
        }
        int i2 = adConversionInfo.h5Type;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "h5Type", i2);
        }
        String str2 = adConversionInfo.deeplinkUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkUrl", adConversionInfo.deeplinkUrl);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkConf", adConversionInfo.deeplinkConf);
        String str3 = adConversionInfo.deeplinkExtra;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkExtra", adConversionInfo.deeplinkExtra);
        }
        String str4 = adConversionInfo.appDownloadUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appDownloadUrl", adConversionInfo.appDownloadUrl);
        }
        String str5 = adConversionInfo.marketUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "marketUrl", adConversionInfo.marketUrl);
        }
        int i3 = adConversionInfo.supportThirdDownload;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "supportThirdDownload", i3);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "retryH5TimeStep", adConversionInfo.retryH5TimeStep);
        String str6 = adConversionInfo.playableUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playableUrl", adConversionInfo.playableUrl);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "playableStyleInfo", adConversionInfo.playableStyleInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "smallAppJumpInfo", adConversionInfo.smallAppJumpInfo);
        int i4 = adConversionInfo.webUriSourceType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "webUriSourceType", i4);
        }
        String str7 = adConversionInfo.callbackUrl;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "callbackUrl", adConversionInfo.callbackUrl);
        }
        String str8 = adConversionInfo.callbackUrlInfo;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "callbackUrlInfo", adConversionInfo.callbackUrlInfo);
        }
        boolean z = adConversionInfo.blockCallbackIfSpam;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockCallbackIfSpam", z);
        }
        boolean z2 = adConversionInfo.needDeeplinkReplaceAdapta;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "needDeeplinkReplaceAdapta", z2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "h5DeeplinkLimitedTimeMs", adConversionInfo.h5DeeplinkLimitedTimeMs);
        com.kwad.sdk.utils.t.putValue(jSONObject, "playableDeeplinkLimitedTimeMs", adConversionInfo.playableDeeplinkLimitedTimeMs);
        boolean z3 = adConversionInfo.isSupportKeepPlaying;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isSupportKeepPlaying", z3);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "keepPlayingBackOffTime", adConversionInfo.keepPlayingBackOffTime);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        a2(adConversionInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        return b2(adConversionInfo, jSONObject);
    }
}
