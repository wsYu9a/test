package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.ABParams;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a implements com.kwad.sdk.core.d<ABParams> {
    /* renamed from: a */
    private static void a2(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aBParams.videoBlackAreaClick = jSONObject.optInt("videoBlackAreaClick");
        aBParams.videoBlackAreaNewStyle = jSONObject.optInt("videoBlackAreaNewStyle");
        String optString = jSONObject.optString("drawActionBarTimes");
        aBParams.drawActionBarTimes = optString;
        if (optString == JSONObject.NULL) {
            aBParams.drawActionBarTimes = "";
        }
        aBParams.showVideoAtH5 = jSONObject.optInt("showVideoAtH5");
        aBParams.playableStyle = jSONObject.optInt("playableStyle");
    }

    /* renamed from: b */
    private static JSONObject b2(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aBParams.videoBlackAreaClick;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoBlackAreaClick", i2);
        }
        int i3 = aBParams.videoBlackAreaNewStyle;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoBlackAreaNewStyle", i3);
        }
        String str = aBParams.drawActionBarTimes;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "drawActionBarTimes", aBParams.drawActionBarTimes);
        }
        int i4 = aBParams.showVideoAtH5;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showVideoAtH5", i4);
        }
        int i5 = aBParams.playableStyle;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playableStyle", i5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ABParams aBParams, JSONObject jSONObject) {
        a2(aBParams, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ABParams aBParams, JSONObject jSONObject) {
        return b2(aBParams, jSONObject);
    }
}
