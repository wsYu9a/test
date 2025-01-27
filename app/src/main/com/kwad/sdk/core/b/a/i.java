package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class i implements com.kwad.sdk.core.d<AdInfo.AdBannerInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdBannerInfo adBannerInfo, JSONObject jSONObject) {
        a2(adBannerInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdBannerInfo adBannerInfo, JSONObject jSONObject) {
        return b2(adBannerInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdInfo.AdBannerInfo adBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBannerInfo.videoSoundType = jSONObject.optInt("videoSoundType");
        adBannerInfo.videoAutoPlayType = jSONObject.optInt("videoAutoPlayType");
        adBannerInfo.isSupportCarousel = jSONObject.optBoolean("isSupportCarousel");
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdBannerInfo adBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = adBannerInfo.videoSoundType;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "videoSoundType", i10);
        }
        int i11 = adBannerInfo.videoAutoPlayType;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "videoAutoPlayType", i11);
        }
        boolean z10 = adBannerInfo.isSupportCarousel;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "isSupportCarousel", z10);
        }
        return jSONObject;
    }
}
