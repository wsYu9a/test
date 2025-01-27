package com.kwad.sdk.core.a.kwai;

import com.kwad.components.splash.SplashPreloadManager;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gs implements com.kwad.sdk.core.d<SplashPreloadManager.PreLoadItem> {
    /* renamed from: a */
    private static void a2(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLoadItem.cacheTime = jSONObject.optLong("cacheTime");
        preLoadItem.expiredTime = jSONObject.optLong("expiredTime");
        String optString = jSONObject.optString("preloadId");
        preLoadItem.preloadId = optString;
        if (optString == JSONObject.NULL) {
            preLoadItem.preloadId = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = preLoadItem.cacheTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cacheTime", j2);
        }
        long j3 = preLoadItem.expiredTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "expiredTime", j3);
        }
        String str = preLoadItem.preloadId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "preloadId", preLoadItem.preloadId);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        a2(preLoadItem, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        return b2(preLoadItem, jSONObject);
    }
}
