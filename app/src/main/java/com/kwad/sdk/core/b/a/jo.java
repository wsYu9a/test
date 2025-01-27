package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class jo implements com.kwad.sdk.core.d<AdMatrixInfo.SplashEndCardTKInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.SplashEndCardTKInfo splashEndCardTKInfo, JSONObject jSONObject) {
        a2(splashEndCardTKInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.SplashEndCardTKInfo splashEndCardTKInfo, JSONObject jSONObject) {
        return b2(splashEndCardTKInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdMatrixInfo.SplashEndCardTKInfo splashEndCardTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashEndCardTKInfo.endCardCountDaily = jSONObject.optInt("endCardCountDaily", new Integer("5").intValue());
        splashEndCardTKInfo.endCardShowSecond = jSONObject.optInt("endCardShowSecond", new Integer("5").intValue());
        splashEndCardTKInfo.endCardFullScreenClick = jSONObject.optBoolean("endCardFullScreenClick", new Boolean("true").booleanValue());
        splashEndCardTKInfo.endCardShowCountDown = jSONObject.optBoolean("endCardShowCountDown", new Boolean("false").booleanValue());
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.SplashEndCardTKInfo splashEndCardTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "endCardCountDaily", splashEndCardTKInfo.endCardCountDaily);
        com.kwad.sdk.utils.x.putValue(jSONObject, "endCardShowSecond", splashEndCardTKInfo.endCardShowSecond);
        com.kwad.sdk.utils.x.putValue(jSONObject, "endCardFullScreenClick", splashEndCardTKInfo.endCardFullScreenClick);
        com.kwad.sdk.utils.x.putValue(jSONObject, "endCardShowCountDown", splashEndCardTKInfo.endCardShowCountDown);
        return jSONObject;
    }
}
