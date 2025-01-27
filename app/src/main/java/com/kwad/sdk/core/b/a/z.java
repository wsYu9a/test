package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class z implements com.kwad.sdk.core.d<AdMatrixInfo.AdInteractionInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        a2(adInteractionInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        return b2(adInteractionInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInteractionInfo.interactiveStyle = jSONObject.optInt("interactiveStyle");
        adInteractionInfo.interactivityDefaultStyle = jSONObject.optInt("interactivityDefaultStyle", new Integer("4").intValue());
        adInteractionInfo.isMediaDisable = jSONObject.optBoolean("isMediaDisable");
        adInteractionInfo.switchDefaultTime = jSONObject.optLong("switchDefaultTime", new Long("1500").longValue());
        AdMatrixInfo.ShakeInfo shakeInfo = new AdMatrixInfo.ShakeInfo();
        adInteractionInfo.shakeInfo = shakeInfo;
        shakeInfo.parseJson(jSONObject.optJSONObject("shakeInfo"));
        AdMatrixInfo.RotateInfo rotateInfo = new AdMatrixInfo.RotateInfo();
        adInteractionInfo.rotateInfo = rotateInfo;
        rotateInfo.parseJson(jSONObject.optJSONObject("rotateInfo"));
        AdMatrixInfo.SplashSlideInfo splashSlideInfo = new AdMatrixInfo.SplashSlideInfo();
        adInteractionInfo.slideInfo = splashSlideInfo;
        splashSlideInfo.parseJson(jSONObject.optJSONObject("slideInfo"));
        AdMatrixInfo.SplashActionBarInfo splashActionBarInfo = new AdMatrixInfo.SplashActionBarInfo();
        adInteractionInfo.splashActionBarInfo = splashActionBarInfo;
        splashActionBarInfo.parseJson(jSONObject.optJSONObject("actionBarInfo"));
        adInteractionInfo.tkDefaultTimeout = jSONObject.optLong("tkDefaultTimeout", new Long("1500").longValue());
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = adInteractionInfo.interactiveStyle;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "interactiveStyle", i10);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "interactivityDefaultStyle", adInteractionInfo.interactivityDefaultStyle);
        boolean z10 = adInteractionInfo.isMediaDisable;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "isMediaDisable", z10);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "switchDefaultTime", adInteractionInfo.switchDefaultTime);
        com.kwad.sdk.utils.x.a(jSONObject, "shakeInfo", adInteractionInfo.shakeInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "rotateInfo", adInteractionInfo.rotateInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "slideInfo", adInteractionInfo.slideInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "actionBarInfo", adInteractionInfo.splashActionBarInfo);
        com.kwad.sdk.utils.x.putValue(jSONObject, "tkDefaultTimeout", adInteractionInfo.tkDefaultTimeout);
        return jSONObject;
    }
}
