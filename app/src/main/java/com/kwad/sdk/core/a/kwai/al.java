package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class al implements com.kwad.sdk.core.d<AdInfo.AdvertiserInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        advertiserInfo.userId = jSONObject.optLong("userId");
        String optString = jSONObject.optString("userName");
        advertiserInfo.userName = optString;
        if (optString == JSONObject.NULL) {
            advertiserInfo.userName = "";
        }
        String optString2 = jSONObject.optString("rawUserName");
        advertiserInfo.rawUserName = optString2;
        if (optString2 == JSONObject.NULL) {
            advertiserInfo.rawUserName = "";
        }
        String optString3 = jSONObject.optString("userGender");
        advertiserInfo.userGender = optString3;
        if (optString3 == JSONObject.NULL) {
            advertiserInfo.userGender = "";
        }
        String optString4 = jSONObject.optString("portraitUrl");
        advertiserInfo.portraitUrl = optString4;
        if (optString4 == JSONObject.NULL) {
            advertiserInfo.portraitUrl = "";
        }
        String optString5 = jSONObject.optString("adAuthorText");
        advertiserInfo.adAuthorText = optString5;
        if (optString5 == JSONObject.NULL) {
            advertiserInfo.adAuthorText = "";
        }
        String optString6 = jSONObject.optString("authorIconGuide");
        advertiserInfo.authorIconGuide = optString6;
        if (optString6 == JSONObject.NULL) {
            advertiserInfo.authorIconGuide = "";
        }
        advertiserInfo.followed = jSONObject.optBoolean("followed");
        advertiserInfo.fansCount = jSONObject.optInt("fansCount");
        String optString7 = jSONObject.optString("brief");
        advertiserInfo.brief = optString7;
        if (optString7 == JSONObject.NULL) {
            advertiserInfo.brief = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = advertiserInfo.userId;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userId", j2);
        }
        String str = advertiserInfo.userName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userName", advertiserInfo.userName);
        }
        String str2 = advertiserInfo.rawUserName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rawUserName", advertiserInfo.rawUserName);
        }
        String str3 = advertiserInfo.userGender;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userGender", advertiserInfo.userGender);
        }
        String str4 = advertiserInfo.portraitUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "portraitUrl", advertiserInfo.portraitUrl);
        }
        String str5 = advertiserInfo.adAuthorText;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adAuthorText", advertiserInfo.adAuthorText);
        }
        String str6 = advertiserInfo.authorIconGuide;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "authorIconGuide", advertiserInfo.authorIconGuide);
        }
        boolean z = advertiserInfo.followed;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "followed", z);
        }
        int i2 = advertiserInfo.fansCount;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fansCount", i2);
        }
        String str7 = advertiserInfo.brief;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "brief", advertiserInfo.brief);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        a2(advertiserInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        return b2(advertiserInfo, jSONObject);
    }
}
