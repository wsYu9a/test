package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bz implements com.kwad.sdk.core.d<AdMatrixInfo.BottomBannerInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        a2(bottomBannerInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        return b2(bottomBannerInfo, jSONObject);
    }

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
        int i10 = bottomBannerInfo.bannerSizeType;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "bannerSizeType", i10);
        }
        int i11 = bottomBannerInfo.bannerAdType;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "bannerAdType", i11);
        }
        return jSONObject;
    }
}
