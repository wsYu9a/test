package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hu implements com.kwad.sdk.core.d<StatusInfo.SplashAdInfo> {
    /* renamed from: a */
    private static void a2(StatusInfo.SplashAdInfo splashAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashAdInfo.dailyShowCount = jSONObject.optInt("dailyShowCount");
        StatusInfo.SplashStyleControl splashStyleControl = new StatusInfo.SplashStyleControl();
        splashAdInfo.splashStyleControl = splashStyleControl;
        splashStyleControl.parseJson(jSONObject.optJSONObject("splashStyleControl"));
    }

    /* renamed from: b */
    private static JSONObject b2(StatusInfo.SplashAdInfo splashAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = splashAdInfo.dailyShowCount;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "dailyShowCount", i2);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "splashStyleControl", splashAdInfo.splashStyleControl);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(StatusInfo.SplashAdInfo splashAdInfo, JSONObject jSONObject) {
        a2(splashAdInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(StatusInfo.SplashAdInfo splashAdInfo, JSONObject jSONObject) {
        return b2(splashAdInfo, jSONObject);
    }
}
