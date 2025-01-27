package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fo implements com.kwad.sdk.core.d<StatusInfo.NativeAdRequestInfo> {
    /* renamed from: a */
    private static void a2(StatusInfo.NativeAdRequestInfo nativeAdRequestInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        StatusInfo.NativeAdStyleControl nativeAdStyleControl = new StatusInfo.NativeAdStyleControl();
        nativeAdRequestInfo.nativeAdStyleControl = nativeAdStyleControl;
        nativeAdStyleControl.parseJson(jSONObject.optJSONObject("nativeAdStyleControl"));
    }

    /* renamed from: b */
    private static JSONObject b2(StatusInfo.NativeAdRequestInfo nativeAdRequestInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "nativeAdStyleControl", nativeAdRequestInfo.nativeAdStyleControl);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(StatusInfo.NativeAdRequestInfo nativeAdRequestInfo, JSONObject jSONObject) {
        a2(nativeAdRequestInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(StatusInfo.NativeAdRequestInfo nativeAdRequestInfo, JSONObject jSONObject) {
        return b2(nativeAdRequestInfo, jSONObject);
    }
}
