package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hb implements com.kwad.sdk.core.d<AdMatrixInfo.RewardVideoInteractInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("templateId");
        rewardVideoInteractInfo.templateId = optString;
        if (optString == JSONObject.NULL) {
            rewardVideoInteractInfo.templateId = "";
        }
        rewardVideoInteractInfo.showTime = jSONObject.optInt("showTime", new Integer("15").intValue());
        rewardVideoInteractInfo.duration = jSONObject.optInt("duration", new Integer("10").intValue());
        rewardVideoInteractInfo.rewardTime = jSONObject.optInt("rewardTime", new Integer("5").intValue());
        rewardVideoInteractInfo.intervalShow = jSONObject.optInt("intervalShow", new Integer("3").intValue());
        rewardVideoInteractInfo.dayMaxLimit = jSONObject.optInt("dayMaxLimit", new Integer("2").intValue());
        rewardVideoInteractInfo.style = jSONObject.optInt(OapsKey.KEY_STYLE);
        String optString2 = jSONObject.optString("successfulMsg");
        rewardVideoInteractInfo.successfulMsg = optString2;
        if (optString2 == JSONObject.NULL) {
            rewardVideoInteractInfo.successfulMsg = "";
        }
        String optString3 = jSONObject.optString("errorMsg");
        rewardVideoInteractInfo.errorMsg = optString3;
        if (optString3 == JSONObject.NULL) {
            rewardVideoInteractInfo.errorMsg = "";
        }
        AdMatrixInfo.StyleInfo styleInfo = new AdMatrixInfo.StyleInfo();
        rewardVideoInteractInfo.styleInfo = styleInfo;
        styleInfo.parseJson(jSONObject.optJSONObject("styleInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rewardVideoInteractInfo.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "templateId", rewardVideoInteractInfo.templateId);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "showTime", rewardVideoInteractInfo.showTime);
        com.kwad.sdk.utils.t.putValue(jSONObject, "duration", rewardVideoInteractInfo.duration);
        com.kwad.sdk.utils.t.putValue(jSONObject, "rewardTime", rewardVideoInteractInfo.rewardTime);
        com.kwad.sdk.utils.t.putValue(jSONObject, "intervalShow", rewardVideoInteractInfo.intervalShow);
        com.kwad.sdk.utils.t.putValue(jSONObject, "dayMaxLimit", rewardVideoInteractInfo.dayMaxLimit);
        int i2 = rewardVideoInteractInfo.style;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, OapsKey.KEY_STYLE, i2);
        }
        String str2 = rewardVideoInteractInfo.successfulMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "successfulMsg", rewardVideoInteractInfo.successfulMsg);
        }
        String str3 = rewardVideoInteractInfo.errorMsg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorMsg", rewardVideoInteractInfo.errorMsg);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "styleInfo", rewardVideoInteractInfo.styleInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo, JSONObject jSONObject) {
        a2(rewardVideoInteractInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo, JSONObject jSONObject) {
        return b2(rewardVideoInteractInfo, jSONObject);
    }
}
