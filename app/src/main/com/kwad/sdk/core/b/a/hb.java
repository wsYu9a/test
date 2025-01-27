package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class hb implements com.kwad.sdk.core.d<AdInfo.NativeAdShakeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.NativeAdShakeInfo nativeAdShakeInfo, JSONObject jSONObject) {
        a2(nativeAdShakeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.NativeAdShakeInfo nativeAdShakeInfo, JSONObject jSONObject) {
        return b2(nativeAdShakeInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdInfo.NativeAdShakeInfo nativeAdShakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeAdShakeInfo.acceleration = jSONObject.optInt("acceleration");
        nativeAdShakeInfo.enableShake = jSONObject.optBoolean("enableShake");
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.NativeAdShakeInfo nativeAdShakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = nativeAdShakeInfo.acceleration;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "acceleration", i10);
        }
        boolean z10 = nativeAdShakeInfo.enableShake;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "enableShake", z10);
        }
        return jSONObject;
    }
}
