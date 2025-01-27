package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ex implements com.kwad.sdk.core.d<AdInfo.H5Config> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        a2(h5Config, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        return b2(h5Config, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        h5Config.apiMisTouch = jSONObject.optInt("apiMisTouch");
        h5Config.apiAdTag = jSONObject.optInt("apiAdTag");
        h5Config.apiBreathLamp = jSONObject.optInt("apiBreathLamp");
        h5Config.tagTip = jSONObject.optString("tagTip");
        if (JSONObject.NULL.toString().equals(h5Config.tagTip)) {
            h5Config.tagTip = "";
        }
        h5Config.aggregateMiddlePageShowPathSwitch = jSONObject.optBoolean("aggregateMiddlePageShowPathSwitch");
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = h5Config.apiMisTouch;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "apiMisTouch", i10);
        }
        int i11 = h5Config.apiAdTag;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "apiAdTag", i11);
        }
        int i12 = h5Config.apiBreathLamp;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "apiBreathLamp", i12);
        }
        String str = h5Config.tagTip;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "tagTip", h5Config.tagTip);
        }
        boolean z10 = h5Config.aggregateMiddlePageShowPathSwitch;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "aggregateMiddlePageShowPathSwitch", z10);
        }
        return jSONObject;
    }
}
