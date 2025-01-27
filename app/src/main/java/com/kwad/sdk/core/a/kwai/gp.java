package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gp implements com.kwad.sdk.core.d<AdInfo.PlayableStyleInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        playableStyleInfo.playableOrientation = jSONObject.optInt("playableOrientation");
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = playableStyleInfo.playableOrientation;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playableOrientation", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        a2(playableStyleInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        return b2(playableStyleInfo, jSONObject);
    }
}
