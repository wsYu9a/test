package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class dv implements com.kwad.sdk.core.d<AdInfo.H5Config> {
    /* renamed from: a */
    private static void a2(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        h5Config.apiMisTouch = jSONObject.optInt("apiMisTouch");
        h5Config.apiAdTag = jSONObject.optInt("apiAdTag");
        h5Config.apiBreathLamp = jSONObject.optInt("apiBreathLamp");
        String optString = jSONObject.optString("tagTip");
        h5Config.tagTip = optString;
        if (optString == JSONObject.NULL) {
            h5Config.tagTip = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = h5Config.apiMisTouch;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apiMisTouch", i2);
        }
        int i3 = h5Config.apiAdTag;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apiAdTag", i3);
        }
        int i4 = h5Config.apiBreathLamp;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apiBreathLamp", i4);
        }
        String str = h5Config.tagTip;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tagTip", h5Config.tagTip);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        a2(h5Config, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        return b2(h5Config, jSONObject);
    }
}
