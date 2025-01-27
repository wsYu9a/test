package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fm implements com.kwad.sdk.core.d<NativeAdExtraDataImpl> {
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
        boolean z = nativeAdExtraDataImpl.enableShake;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enableShake", z);
        }
        int i2 = nativeAdExtraDataImpl.showLiveStatus;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showLiveStatus", i2);
        }
        int i3 = nativeAdExtraDataImpl.showLiveStyle;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showLiveStyle", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        a2(nativeAdExtraDataImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        return b2(nativeAdExtraDataImpl, jSONObject);
    }
}
