package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.request.model.StatusInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ke implements com.kwad.sdk.core.d<StatusInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(StatusInfo statusInfo, JSONObject jSONObject) {
        a2(statusInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(StatusInfo statusInfo, JSONObject jSONObject) {
        return b2(statusInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        statusInfo.aDW = jSONObject.optInt("personalRecommend");
        statusInfo.aDX = jSONObject.optInt("programmaticRecommend");
        StatusInfo.SplashAdInfo splashAdInfo = new StatusInfo.SplashAdInfo();
        statusInfo.aDY = splashAdInfo;
        splashAdInfo.parseJson(jSONObject.optJSONObject("splashAdInfo"));
        StatusInfo.NativeAdRequestInfo nativeAdRequestInfo = new StatusInfo.NativeAdRequestInfo();
        statusInfo.aDZ = nativeAdRequestInfo;
        nativeAdRequestInfo.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        statusInfo.aEa = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("taskStats");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                com.kwad.sdk.core.request.model.f fVar = new com.kwad.sdk.core.request.model.f();
                fVar.parseJson(optJSONArray.optJSONObject(i10));
                statusInfo.aEa.add(fVar);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = statusInfo.aDW;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "personalRecommend", i10);
        }
        int i11 = statusInfo.aDX;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "programmaticRecommend", i11);
        }
        com.kwad.sdk.utils.x.a(jSONObject, "splashAdInfo", statusInfo.aDY);
        com.kwad.sdk.utils.x.a(jSONObject, "nativeAdInfo", statusInfo.aDZ);
        com.kwad.sdk.utils.x.putValue(jSONObject, "taskStats", statusInfo.aEa);
        return jSONObject;
    }
}
