package com.kwad.sdk.core.b.a;

import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class gy implements com.kwad.sdk.core.d<NativeAdExtraDataImpl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        a2(nativeAdExtraDataImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        return b2(nativeAdExtraDataImpl, jSONObject);
    }

    /* renamed from: a */
    private static void a2(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeAdExtraDataImpl.enableShake = jSONObject.optBoolean("enableShake");
        nativeAdExtraDataImpl.showLiveStatus = jSONObject.optInt("showLiveStatus");
        nativeAdExtraDataImpl.showLiveStyle = jSONObject.optInt("showLiveStyle");
    }

    /* renamed from: b */
    private static JSONObject b2(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = nativeAdExtraDataImpl.enableShake;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "enableShake", z10);
        }
        int i10 = nativeAdExtraDataImpl.showLiveStatus;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "showLiveStatus", i10);
        }
        int i11 = nativeAdExtraDataImpl.showLiveStyle;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "showLiveStyle", i11);
        }
        return jSONObject;
    }
}
