package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class be implements com.kwad.sdk.core.d<AdMatrixInfo.BottomBannerInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bottomBannerInfo.bannerSizeType = jSONObject.optInt("bannerSizeType");
        bottomBannerInfo.bannerAdType = jSONObject.optInt("bannerAdType");
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = bottomBannerInfo.bannerSizeType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bannerSizeType", i2);
        }
        int i3 = bottomBannerInfo.bannerAdType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bannerAdType", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        a2(bottomBannerInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        return b2(bottomBannerInfo, jSONObject);
    }
}
