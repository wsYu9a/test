package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fn implements com.kwad.sdk.core.d<AdInfo.NativeAdInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.NativeAdInfo nativeAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdInfo.NativeAdShakeInfo nativeAdShakeInfo = new AdInfo.NativeAdShakeInfo();
        nativeAdInfo.shakeInfo = nativeAdShakeInfo;
        nativeAdShakeInfo.parseJson(jSONObject.optJSONObject("shakeInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.NativeAdInfo nativeAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "shakeInfo", nativeAdInfo.shakeInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.NativeAdInfo nativeAdInfo, JSONObject jSONObject) {
        a2(nativeAdInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.NativeAdInfo nativeAdInfo, JSONObject jSONObject) {
        return b2(nativeAdInfo, jSONObject);
    }
}
