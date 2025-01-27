package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.adbit.AdBid;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class k implements com.kwad.sdk.core.d<AdBid> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdBid adBid, JSONObject jSONObject) {
        a2(adBid, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdBid adBid, JSONObject jSONObject) {
        return b2(adBid, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBid.creativeId = jSONObject.optLong("creativeId");
        adBid.ecpm = jSONObject.optLong("ecpm");
        adBid.bidEcpm = jSONObject.optInt("bidEcpm");
        adBid.winNoticeUrl = jSONObject.optString("winNoticeUrl");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(adBid.winNoticeUrl)) {
            adBid.winNoticeUrl = "";
        }
        adBid.materialId = jSONObject.optString("materialId");
        if (obj.toString().equals(adBid.materialId)) {
            adBid.materialId = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = adBid.creativeId;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "creativeId", j10);
        }
        long j11 = adBid.ecpm;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "ecpm", j11);
        }
        int i10 = adBid.bidEcpm;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "bidEcpm", i10);
        }
        String str = adBid.winNoticeUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "winNoticeUrl", adBid.winNoticeUrl);
        }
        String str2 = adBid.materialId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "materialId", adBid.materialId);
        }
        return jSONObject;
    }
}
