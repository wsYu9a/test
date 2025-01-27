package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ay implements com.kwad.sdk.core.d<AdVideoPreCacheConfig> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        a2(adVideoPreCacheConfig, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        return b2(adVideoPreCacheConfig, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adVideoPreCacheConfig.adVideoPreCacheSize = jSONObject.optInt("adVideoPreCacheSize", new Integer("800").intValue());
        adVideoPreCacheConfig.continueLoadingAll = jSONObject.optBoolean("continueLoadingAll");
    }

    /* renamed from: b */
    private static JSONObject b2(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "adVideoPreCacheSize", adVideoPreCacheConfig.adVideoPreCacheSize);
        boolean z10 = adVideoPreCacheConfig.continueLoadingAll;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "continueLoadingAll", z10);
        }
        return jSONObject;
    }
}
