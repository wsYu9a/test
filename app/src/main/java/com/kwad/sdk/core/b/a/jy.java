package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class jy implements com.kwad.sdk.core.d<StatusInfo.SplashStyleControl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        a2(splashStyleControl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        return b2(splashStyleControl, jSONObject);
    }

    /* renamed from: a */
    private static void a2(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashStyleControl.disableShake = jSONObject.optBoolean("disableShake");
        splashStyleControl.disableRotate = jSONObject.optBoolean("disableRotate");
        splashStyleControl.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    /* renamed from: b */
    private static JSONObject b2(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = splashStyleControl.disableShake;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "disableShake", z10);
        }
        boolean z11 = splashStyleControl.disableRotate;
        if (z11) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "disableRotate", z11);
        }
        boolean z12 = splashStyleControl.disableSlide;
        if (z12) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "disableSlide", z12);
        }
        return jSONObject;
    }
}
