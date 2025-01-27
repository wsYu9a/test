package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class df implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        a2(detailTopToolBarInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        return b2(detailTopToolBarInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailTopToolBarInfo.callButtonShowTime = jSONObject.optLong("callButtonShowTime");
        detailTopToolBarInfo.callButtonDescription = jSONObject.optString("callButtonDescription");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(detailTopToolBarInfo.callButtonDescription)) {
            detailTopToolBarInfo.callButtonDescription = "";
        }
        detailTopToolBarInfo.rewardIconUrl = jSONObject.optString("rewardIconUrl");
        if (obj.toString().equals(detailTopToolBarInfo.rewardIconUrl)) {
            detailTopToolBarInfo.rewardIconUrl = "";
        }
        detailTopToolBarInfo.rewardCallDescription = jSONObject.optString("rewardCallDescription");
        if (obj.toString().equals(detailTopToolBarInfo.rewardCallDescription)) {
            detailTopToolBarInfo.rewardCallDescription = "";
        }
        detailTopToolBarInfo.style = jSONObject.optInt("style");
        detailTopToolBarInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
    }

    /* renamed from: b */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = detailTopToolBarInfo.callButtonShowTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "callButtonShowTime", j10);
        }
        String str = detailTopToolBarInfo.callButtonDescription;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "callButtonDescription", detailTopToolBarInfo.callButtonDescription);
        }
        String str2 = detailTopToolBarInfo.rewardIconUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "rewardIconUrl", detailTopToolBarInfo.rewardIconUrl);
        }
        String str3 = detailTopToolBarInfo.rewardCallDescription;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "rewardCallDescription", detailTopToolBarInfo.rewardCallDescription);
        }
        int i10 = detailTopToolBarInfo.style;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "style", i10);
        }
        long j11 = detailTopToolBarInfo.maxTimeOut;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "maxTimeOut", j11);
        }
        return jSONObject;
    }
}
