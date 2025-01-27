package com.kwad.sdk.core.a.kwai;

import com.baidu.mobads.sdk.api.SplashAd;
import com.kwad.components.ad.adbit.AdBid;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class j implements com.kwad.sdk.core.d<AdBid> {
    /* renamed from: a */
    private static void a2(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBid.creativeId = jSONObject.optLong("creativeId");
        adBid.ecpm = jSONObject.optLong(SplashAd.KEY_BIDFAIL_ECPM);
        adBid.bidEcpm = jSONObject.optInt("bidEcpm");
        String optString = jSONObject.optString("winNoticeUrl");
        adBid.winNoticeUrl = optString;
        if (optString == JSONObject.NULL) {
            adBid.winNoticeUrl = "";
        }
        String optString2 = jSONObject.optString("materialId");
        adBid.materialId = optString2;
        if (optString2 == JSONObject.NULL) {
            adBid.materialId = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = adBid.creativeId;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", j2);
        }
        long j3 = adBid.ecpm;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, SplashAd.KEY_BIDFAIL_ECPM, j3);
        }
        int i2 = adBid.bidEcpm;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bidEcpm", i2);
        }
        String str = adBid.winNoticeUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "winNoticeUrl", adBid.winNoticeUrl);
        }
        String str2 = adBid.materialId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "materialId", adBid.materialId);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdBid adBid, JSONObject jSONObject) {
        a2(adBid, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdBid adBid, JSONObject jSONObject) {
        return b2(adBid, jSONObject);
    }
}
