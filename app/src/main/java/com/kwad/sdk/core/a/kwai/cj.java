package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cj implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailWebCardInfo> {
    /* renamed from: a */
    private static void a2(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailWebCardInfo.style = jSONObject.optInt(OapsKey.KEY_STYLE);
        detailWebCardInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
        detailWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        detailWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        String optString = jSONObject.optString("cardUrl");
        detailWebCardInfo.cardUrl = optString;
        if (optString == JSONObject.NULL) {
            detailWebCardInfo.cardUrl = "";
        }
        String optString2 = jSONObject.optString("cardData");
        detailWebCardInfo.cardData = optString2;
        if (optString2 == JSONObject.NULL) {
            detailWebCardInfo.cardData = "";
        }
        detailWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
        detailWebCardInfo.cardType = jSONObject.optInt("cardType");
    }

    /* renamed from: b */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = detailWebCardInfo.style;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, OapsKey.KEY_STYLE, i2);
        }
        long j2 = detailWebCardInfo.maxTimeOut;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "maxTimeOut", j2);
        }
        long j3 = detailWebCardInfo.typeLandscape;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "typeLandscape", j3);
        }
        long j4 = detailWebCardInfo.typePortrait;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "typePortrait", j4);
        }
        String str = detailWebCardInfo.cardUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardUrl", detailWebCardInfo.cardUrl);
        }
        String str2 = detailWebCardInfo.cardData;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardData", detailWebCardInfo.cardData);
        }
        long j5 = detailWebCardInfo.cardShowTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardShowTime", j5);
        }
        int i3 = detailWebCardInfo.cardType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardType", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        a2(detailWebCardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        return b2(detailWebCardInfo, jSONObject);
    }
}
