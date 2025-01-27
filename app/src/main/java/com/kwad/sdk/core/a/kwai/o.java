package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class o implements com.kwad.sdk.core.d<AdInfo.AdFeedInfo> {
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
        int i2 = adFeedInfo.videoSoundType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoSoundType", i2);
        }
        int i3 = adFeedInfo.videoAutoPlayType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoAutoPlayType", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        a2(adFeedInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        return b2(adFeedInfo, jSONObject);
    }
}
