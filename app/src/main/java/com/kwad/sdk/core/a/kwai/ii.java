package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.request.model.StatusInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ii implements com.kwad.sdk.core.d<StatusInfo> {
    /* renamed from: a */
    private static void a2(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        statusInfo.alF = jSONObject.optInt("personalRecommend");
        statusInfo.alG = jSONObject.optInt("programmaticRecommend");
        StatusInfo.SplashAdInfo splashAdInfo = new StatusInfo.SplashAdInfo();
        statusInfo.alH = splashAdInfo;
        splashAdInfo.parseJson(jSONObject.optJSONObject("splashAdInfo"));
        StatusInfo.NativeAdRequestInfo nativeAdRequestInfo = new StatusInfo.NativeAdRequestInfo();
        statusInfo.alI = nativeAdRequestInfo;
        nativeAdRequestInfo.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        statusInfo.alJ = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("taskStats");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                com.kwad.sdk.core.request.model.f fVar = new com.kwad.sdk.core.request.model.f();
                fVar.parseJson(optJSONArray.optJSONObject(i2));
                statusInfo.alJ.add(fVar);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = statusInfo.alF;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "personalRecommend", i2);
        }
        int i3 = statusInfo.alG;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "programmaticRecommend", i3);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "splashAdInfo", statusInfo.alH);
        com.kwad.sdk.utils.t.a(jSONObject, "nativeAdInfo", statusInfo.alI);
        com.kwad.sdk.utils.t.putValue(jSONObject, "taskStats", statusInfo.alJ);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(StatusInfo statusInfo, JSONObject jSONObject) {
        a2(statusInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(StatusInfo statusInfo, JSONObject jSONObject) {
        return b2(statusInfo, jSONObject);
    }
}
