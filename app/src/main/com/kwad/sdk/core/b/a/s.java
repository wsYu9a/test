package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class s implements com.kwad.sdk.core.d<AdInfo.AdDrawInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdDrawInfo adDrawInfo, JSONObject jSONObject) {
        a2(adDrawInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdDrawInfo adDrawInfo, JSONObject jSONObject) {
        return b2(adDrawInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdInfo.AdDrawInfo adDrawInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adDrawInfo.videoSoundType = jSONObject.optInt("videoSoundType");
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdDrawInfo adDrawInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = adDrawInfo.videoSoundType;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "videoSoundType", i10);
        }
        return jSONObject;
    }
}
