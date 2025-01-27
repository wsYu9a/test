package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class t implements com.kwad.sdk.core.d<AdInfo.AdFeedInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        a2(adFeedInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        return b2(adFeedInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adFeedInfo.videoSoundType = jSONObject.optInt("videoSoundType");
        adFeedInfo.videoAutoPlayType = jSONObject.optInt("videoAutoPlayType");
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = adFeedInfo.videoSoundType;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "videoSoundType", i10);
        }
        int i11 = adFeedInfo.videoAutoPlayType;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "videoAutoPlayType", i11);
        }
        return jSONObject;
    }
}
