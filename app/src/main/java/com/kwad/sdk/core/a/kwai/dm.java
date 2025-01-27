package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class dm implements com.kwad.sdk.core.d<AdInfo.FullScreenVideoInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.FullScreenVideoInfo fullScreenVideoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fullScreenVideoInfo.fullScreenEndCardSwitch = jSONObject.optBoolean("fullScreenEndCardSwitch");
        fullScreenVideoInfo.showLandingPage = jSONObject.optInt("showLandingPage");
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.FullScreenVideoInfo fullScreenVideoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = fullScreenVideoInfo.fullScreenEndCardSwitch;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fullScreenEndCardSwitch", z);
        }
        int i2 = fullScreenVideoInfo.showLandingPage;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showLandingPage", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.FullScreenVideoInfo fullScreenVideoInfo, JSONObject jSONObject) {
        a2(fullScreenVideoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.FullScreenVideoInfo fullScreenVideoInfo, JSONObject jSONObject) {
        return b2(fullScreenVideoInfo, jSONObject);
    }
}
