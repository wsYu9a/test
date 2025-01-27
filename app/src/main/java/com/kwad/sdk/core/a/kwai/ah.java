package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ah implements com.kwad.sdk.core.d<AdStyleInfo> {
    /* renamed from: a */
    private static void a2(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdStyleInfo.PlayDetailInfo playDetailInfo = new AdStyleInfo.PlayDetailInfo();
        adStyleInfo.playDetailInfo = playDetailInfo;
        playDetailInfo.parseJson(jSONObject.optJSONObject("playDetailInfo"));
        AdStyleInfo.PlayEndInfo playEndInfo = new AdStyleInfo.PlayEndInfo();
        adStyleInfo.playEndInfo = playEndInfo;
        playEndInfo.parseJson(jSONObject.optJSONObject("playEndInfo"));
        AdStyleInfo.FeedAdInfo feedAdInfo = new AdStyleInfo.FeedAdInfo();
        adStyleInfo.feedAdInfo = feedAdInfo;
        feedAdInfo.parseJson(jSONObject.optJSONObject("feedAdInfo"));
        AdStyleInfo.AdBrowseInfo adBrowseInfo = new AdStyleInfo.AdBrowseInfo();
        adStyleInfo.adBrowseInfo = adBrowseInfo;
        adBrowseInfo.parseJson(jSONObject.optJSONObject("adBrowseInfo"));
        AdStyleInfo.ExtraDisplayInfo extraDisplayInfo = new AdStyleInfo.ExtraDisplayInfo();
        adStyleInfo.extraDisplayInfo = extraDisplayInfo;
        extraDisplayInfo.parseJson(jSONObject.optJSONObject("extraDisplayInfo"));
        String optString = jSONObject.optString("playableExtraData");
        adStyleInfo.playableExtraData = optString;
        if (optString == JSONObject.NULL) {
            adStyleInfo.playableExtraData = "";
        }
        adStyleInfo.slideClick = jSONObject.optBoolean("slideClick");
    }

    /* renamed from: b */
    private static JSONObject b2(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "playDetailInfo", adStyleInfo.playDetailInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "playEndInfo", adStyleInfo.playEndInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "feedAdInfo", adStyleInfo.feedAdInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "adBrowseInfo", adStyleInfo.adBrowseInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "extraDisplayInfo", adStyleInfo.extraDisplayInfo);
        String str = adStyleInfo.playableExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playableExtraData", adStyleInfo.playableExtraData);
        }
        boolean z = adStyleInfo.slideClick;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "slideClick", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        a2(adStyleInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        return b2(adStyleInfo, jSONObject);
    }
}
