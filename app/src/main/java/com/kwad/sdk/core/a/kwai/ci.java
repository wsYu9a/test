package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ci implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo> {
    /* renamed from: a */
    private static void a2(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailTopToolBarInfo.callButtonShowTime = jSONObject.optLong("callButtonShowTime");
        String optString = jSONObject.optString("callButtonDescription");
        detailTopToolBarInfo.callButtonDescription = optString;
        if (optString == JSONObject.NULL) {
            detailTopToolBarInfo.callButtonDescription = "";
        }
        String optString2 = jSONObject.optString("rewardIconUrl");
        detailTopToolBarInfo.rewardIconUrl = optString2;
        if (optString2 == JSONObject.NULL) {
            detailTopToolBarInfo.rewardIconUrl = "";
        }
        String optString3 = jSONObject.optString("rewardCallDescription");
        detailTopToolBarInfo.rewardCallDescription = optString3;
        if (optString3 == JSONObject.NULL) {
            detailTopToolBarInfo.rewardCallDescription = "";
        }
        detailTopToolBarInfo.style = jSONObject.optInt(OapsKey.KEY_STYLE);
        detailTopToolBarInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
    }

    /* renamed from: b */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = detailTopToolBarInfo.callButtonShowTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "callButtonShowTime", j2);
        }
        String str = detailTopToolBarInfo.callButtonDescription;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "callButtonDescription", detailTopToolBarInfo.callButtonDescription);
        }
        String str2 = detailTopToolBarInfo.rewardIconUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rewardIconUrl", detailTopToolBarInfo.rewardIconUrl);
        }
        String str3 = detailTopToolBarInfo.rewardCallDescription;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rewardCallDescription", detailTopToolBarInfo.rewardCallDescription);
        }
        int i2 = detailTopToolBarInfo.style;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, OapsKey.KEY_STYLE, i2);
        }
        long j3 = detailTopToolBarInfo.maxTimeOut;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "maxTimeOut", j3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        a2(detailTopToolBarInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        return b2(detailTopToolBarInfo, jSONObject);
    }
}
