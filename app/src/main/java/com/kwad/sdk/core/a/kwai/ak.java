package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ak implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo.AdWebCardInfo> {
    /* renamed from: a */
    private static void a2(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        adWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        String optString = jSONObject.optString("cardUrl");
        adWebCardInfo.cardUrl = optString;
        if (optString == JSONObject.NULL) {
            adWebCardInfo.cardUrl = "";
        }
        String optString2 = jSONObject.optString("cardData");
        adWebCardInfo.cardData = optString2;
        if (optString2 == JSONObject.NULL) {
            adWebCardInfo.cardData = "";
        }
        adWebCardInfo.cardShowPlayCount = jSONObject.optInt("cardShowPlayCount");
        adWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
        adWebCardInfo.cardDelayTime = jSONObject.optLong("cardDelayTime");
    }

    /* renamed from: b */
    private static JSONObject b2(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = adWebCardInfo.typeLandscape;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "typeLandscape", j2);
        }
        long j3 = adWebCardInfo.typePortrait;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "typePortrait", j3);
        }
        String str = adWebCardInfo.cardUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardUrl", adWebCardInfo.cardUrl);
        }
        String str2 = adWebCardInfo.cardData;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardData", adWebCardInfo.cardData);
        }
        int i2 = adWebCardInfo.cardShowPlayCount;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardShowPlayCount", i2);
        }
        long j4 = adWebCardInfo.cardShowTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardShowTime", j4);
        }
        long j5 = adWebCardInfo.cardDelayTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardDelayTime", j5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        a2(adWebCardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        return b2(adWebCardInfo, jSONObject);
    }
}
