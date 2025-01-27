package com.kwad.sdk.core.a.kwai;

import com.baidu.mobads.sdk.api.SplashAd;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdInfo;
import com.qq.e.comm.constants.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class i implements com.kwad.sdk.core.d<AdInfo.AdBaseInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBaseInfo.creativeId = jSONObject.optLong("creativeId");
        adBaseInfo.adSourceType = jSONObject.optInt("adSourceType");
        String optString = jSONObject.optString("liveStreamId");
        adBaseInfo.liveStreamId = optString;
        if (optString == JSONObject.NULL) {
            adBaseInfo.liveStreamId = "";
        }
        adBaseInfo.universeLiveType = jSONObject.optInt("universeLiveType");
        adBaseInfo.viewCount = jSONObject.optLong("viewCount");
        String optString2 = jSONObject.optString("sdkExtraData");
        adBaseInfo.sdkExtraData = optString2;
        if (optString2 == JSONObject.NULL) {
            adBaseInfo.sdkExtraData = "";
        }
        String optString3 = jSONObject.optString("adDescription");
        adBaseInfo.adDescription = optString3;
        if (optString3 == JSONObject.NULL) {
            adBaseInfo.adDescription = "";
        }
        String optString4 = jSONObject.optString("installAppLabel");
        adBaseInfo.installAppLabel = optString4;
        if (optString4 == JSONObject.NULL) {
            adBaseInfo.installAppLabel = "";
        }
        String optString5 = jSONObject.optString("openAppLabel");
        adBaseInfo.openAppLabel = optString5;
        if (optString5 == JSONObject.NULL) {
            adBaseInfo.openAppLabel = "";
        }
        String optString6 = jSONObject.optString("adMarkIcon");
        adBaseInfo.adMarkIcon = optString6;
        if (optString6 == JSONObject.NULL) {
            adBaseInfo.adMarkIcon = "";
        }
        String optString7 = jSONObject.optString("adGrayMarkIcon");
        adBaseInfo.adGrayMarkIcon = optString7;
        if (optString7 == JSONObject.NULL) {
            adBaseInfo.adGrayMarkIcon = "";
        }
        String optString8 = jSONObject.optString("adSourceDescription");
        adBaseInfo.adSourceDescription = optString8;
        if (optString8 == JSONObject.NULL) {
            adBaseInfo.adSourceDescription = "";
        }
        adBaseInfo.adOperationType = jSONObject.optInt("adOperationType");
        String optString9 = jSONObject.optString("adActionDescription");
        adBaseInfo.adActionDescription = optString9;
        if (optString9 == JSONObject.NULL) {
            adBaseInfo.adActionDescription = "";
        }
        String optString10 = jSONObject.optString("adActionBarColor");
        adBaseInfo.adActionBarColor = optString10;
        if (optString10 == JSONObject.NULL) {
            adBaseInfo.adActionBarColor = "";
        }
        adBaseInfo.adShowDuration = jSONObject.optInt("adShowDuration");
        String optString11 = jSONObject.optString("appName");
        adBaseInfo.appName = optString11;
        if (optString11 == JSONObject.NULL) {
            adBaseInfo.appName = "";
        }
        String optString12 = jSONObject.optString("appIconUrl");
        adBaseInfo.appIconUrl = optString12;
        if (optString12 == JSONObject.NULL) {
            adBaseInfo.appIconUrl = "";
        }
        String optString13 = jSONObject.optString("appPackageName");
        adBaseInfo.appPackageName = optString13;
        if (optString13 == JSONObject.NULL) {
            adBaseInfo.appPackageName = "";
        }
        adBaseInfo.appScore = jSONObject.optInt("appScore");
        String optString14 = jSONObject.optString("appDownloadCountDesc");
        adBaseInfo.appDownloadCountDesc = optString14;
        if (optString14 == JSONObject.NULL) {
            adBaseInfo.appDownloadCountDesc = "";
        }
        String optString15 = jSONObject.optString("appCategory");
        adBaseInfo.appCategory = optString15;
        if (optString15 == JSONObject.NULL) {
            adBaseInfo.appCategory = "";
        }
        String optString16 = jSONObject.optString("appVersion");
        adBaseInfo.appVersion = optString16;
        if (optString16 == JSONObject.NULL) {
            adBaseInfo.appVersion = "";
        }
        String optString17 = jSONObject.optString("corporationName");
        adBaseInfo.corporationName = optString17;
        if (optString17 == JSONObject.NULL) {
            adBaseInfo.corporationName = "";
        }
        adBaseInfo.packageSize = jSONObject.optLong("packageSize");
        adBaseInfo.appImageUrl = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("appImageUrl");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                adBaseInfo.appImageUrl.add((String) optJSONArray.opt(i2));
            }
        }
        AdInfo.MaterialSize materialSize = new AdInfo.MaterialSize();
        adBaseInfo.appImageSize = materialSize;
        materialSize.parseJson(jSONObject.optJSONObject("appImageSize"));
        String optString18 = jSONObject.optString("appDescription");
        adBaseInfo.appDescription = optString18;
        if (optString18 == JSONObject.NULL) {
            adBaseInfo.appDescription = "";
        }
        adBaseInfo.enableSkipAd = jSONObject.optInt("enableSkipAd");
        adBaseInfo.adCacheSwitch = jSONObject.optInt("adCacheSwitch", new Integer("0").intValue());
        adBaseInfo.adCacheSecond = jSONObject.optLong("adCacheSecond", new Long("1800").longValue());
        adBaseInfo.adCacheStrategy = jSONObject.optInt("adCacheStrategy", new Integer("1").intValue());
        adBaseInfo.adCacheSize = jSONObject.optInt("adCacheSize", new Integer("1").intValue());
        adBaseInfo.skipSecond = jSONObject.optInt("skipSecond");
        adBaseInfo.ecpm = jSONObject.optInt(SplashAd.KEY_BIDFAIL_ECPM);
        String optString19 = jSONObject.optString("videoPlayedNS");
        adBaseInfo.videoPlayedNS = optString19;
        if (optString19 == JSONObject.NULL) {
            adBaseInfo.videoPlayedNS = "";
        }
        String optString20 = jSONObject.optString("productName");
        adBaseInfo.productName = optString20;
        if (optString20 == JSONObject.NULL) {
            adBaseInfo.productName = "";
        }
        ABParams aBParams = new ABParams();
        adBaseInfo.mABParams = aBParams;
        try {
            aBParams.parseJson(new JSONObject(jSONObject.optString("expParam")));
        } catch (Exception unused) {
        }
        String optString21 = jSONObject.optString("showUrl");
        adBaseInfo.showUrl = optString21;
        if (optString21 == JSONObject.NULL) {
            adBaseInfo.showUrl = "";
        }
        String optString22 = jSONObject.optString(Constants.KEYS.EXPOSED_CLICK_URL_KEY);
        adBaseInfo.clickUrl = optString22;
        if (optString22 == JSONObject.NULL) {
            adBaseInfo.clickUrl = "";
        }
        String optString23 = jSONObject.optString("convUrl");
        adBaseInfo.convUrl = optString23;
        if (optString23 == JSONObject.NULL) {
            adBaseInfo.convUrl = "";
        }
        adBaseInfo.adAttributeType = jSONObject.optInt("adAttributeType");
        AdInfo.H5Config h5Config = new AdInfo.H5Config();
        adBaseInfo.apiExpParam = h5Config;
        h5Config.parseJson(jSONObject.optJSONObject("apiExpParam"));
        adBaseInfo.taskType = jSONObject.optInt("taskType");
        adBaseInfo.campaignType = jSONObject.optInt("campaignType");
        adBaseInfo.itemType = jSONObject.optInt("itemType");
        adBaseInfo.industryFirstLevelId = jSONObject.optInt("industryFirstLevelId");
        adBaseInfo.extraClickReward = jSONObject.optBoolean("extraClickReward");
        adBaseInfo.enableClientProofreadTime = jSONObject.optBoolean("enableClientProofreadTime");
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = adBaseInfo.creativeId;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", j2);
        }
        int i2 = adBaseInfo.adSourceType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adSourceType", i2);
        }
        String str = adBaseInfo.liveStreamId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "liveStreamId", adBaseInfo.liveStreamId);
        }
        int i3 = adBaseInfo.universeLiveType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "universeLiveType", i3);
        }
        long j3 = adBaseInfo.viewCount;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "viewCount", j3);
        }
        String str2 = adBaseInfo.sdkExtraData;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkExtraData", adBaseInfo.sdkExtraData);
        }
        String str3 = adBaseInfo.adDescription;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adDescription", adBaseInfo.adDescription);
        }
        String str4 = adBaseInfo.installAppLabel;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installAppLabel", adBaseInfo.installAppLabel);
        }
        String str5 = adBaseInfo.openAppLabel;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "openAppLabel", adBaseInfo.openAppLabel);
        }
        String str6 = adBaseInfo.adMarkIcon;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adMarkIcon", adBaseInfo.adMarkIcon);
        }
        String str7 = adBaseInfo.adGrayMarkIcon;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adGrayMarkIcon", adBaseInfo.adGrayMarkIcon);
        }
        String str8 = adBaseInfo.adSourceDescription;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adSourceDescription", adBaseInfo.adSourceDescription);
        }
        int i4 = adBaseInfo.adOperationType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adOperationType", i4);
        }
        String str9 = adBaseInfo.adActionDescription;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adActionDescription", adBaseInfo.adActionDescription);
        }
        String str10 = adBaseInfo.adActionBarColor;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adActionBarColor", adBaseInfo.adActionBarColor);
        }
        int i5 = adBaseInfo.adShowDuration;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adShowDuration", i5);
        }
        String str11 = adBaseInfo.appName;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", adBaseInfo.appName);
        }
        String str12 = adBaseInfo.appIconUrl;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appIconUrl", adBaseInfo.appIconUrl);
        }
        String str13 = adBaseInfo.appPackageName;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appPackageName", adBaseInfo.appPackageName);
        }
        int i6 = adBaseInfo.appScore;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appScore", i6);
        }
        String str14 = adBaseInfo.appDownloadCountDesc;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appDownloadCountDesc", adBaseInfo.appDownloadCountDesc);
        }
        String str15 = adBaseInfo.appCategory;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appCategory", adBaseInfo.appCategory);
        }
        String str16 = adBaseInfo.appVersion;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appVersion", adBaseInfo.appVersion);
        }
        String str17 = adBaseInfo.corporationName;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "corporationName", adBaseInfo.corporationName);
        }
        long j4 = adBaseInfo.packageSize;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageSize", j4);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appImageUrl", adBaseInfo.appImageUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "appImageSize", adBaseInfo.appImageSize);
        String str18 = adBaseInfo.appDescription;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appDescription", adBaseInfo.appDescription);
        }
        int i7 = adBaseInfo.enableSkipAd;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enableSkipAd", i7);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "adCacheSwitch", adBaseInfo.adCacheSwitch);
        com.kwad.sdk.utils.t.putValue(jSONObject, "adCacheSecond", adBaseInfo.adCacheSecond);
        com.kwad.sdk.utils.t.putValue(jSONObject, "adCacheStrategy", adBaseInfo.adCacheStrategy);
        com.kwad.sdk.utils.t.putValue(jSONObject, "adCacheSize", adBaseInfo.adCacheSize);
        int i8 = adBaseInfo.skipSecond;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "skipSecond", i8);
        }
        int i9 = adBaseInfo.ecpm;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, SplashAd.KEY_BIDFAIL_ECPM, i9);
        }
        String str19 = adBaseInfo.videoPlayedNS;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoPlayedNS", adBaseInfo.videoPlayedNS);
        }
        String str20 = adBaseInfo.productName;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "productName", adBaseInfo.productName);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "expParam", adBaseInfo.mABParams.toJson().toString());
        String str21 = adBaseInfo.showUrl;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showUrl", adBaseInfo.showUrl);
        }
        String str22 = adBaseInfo.clickUrl;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, Constants.KEYS.EXPOSED_CLICK_URL_KEY, adBaseInfo.clickUrl);
        }
        String str23 = adBaseInfo.convUrl;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "convUrl", adBaseInfo.convUrl);
        }
        int i10 = adBaseInfo.adAttributeType;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adAttributeType", i10);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "apiExpParam", adBaseInfo.apiExpParam);
        int i11 = adBaseInfo.taskType;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "taskType", i11);
        }
        int i12 = adBaseInfo.campaignType;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "campaignType", i12);
        }
        int i13 = adBaseInfo.itemType;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemType", i13);
        }
        int i14 = adBaseInfo.industryFirstLevelId;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "industryFirstLevelId", i14);
        }
        boolean z = adBaseInfo.extraClickReward;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "extraClickReward", z);
        }
        boolean z2 = adBaseInfo.enableClientProofreadTime;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enableClientProofreadTime", z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        a2(adBaseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        return b2(adBaseInfo, jSONObject);
    }
}
