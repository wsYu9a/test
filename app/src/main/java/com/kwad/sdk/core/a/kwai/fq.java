package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fq implements com.kwad.sdk.core.d<StatusInfo.NativeAdStyleControl> {
    /* renamed from: a */
    private static void a2(StatusInfo.NativeAdStyleControl nativeAdStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeAdStyleControl.enableShake = jSONObject.optBoolean("enableShake");
    }

    /* renamed from: b */
    private static JSONObject b2(StatusInfo.NativeAdStyleControl nativeAdStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = nativeAdStyleControl.enableShake;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enableShake", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(StatusInfo.NativeAdStyleControl nativeAdStyleControl, JSONObject jSONObject) {
        a2(nativeAdStyleControl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(StatusInfo.NativeAdStyleControl nativeAdStyleControl, JSONObject jSONObject) {
        return b2(nativeAdStyleControl, jSONObject);
    }
}
