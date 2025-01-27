package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.interstitial.monitor.InterstitialMonitorInfo;
import com.vivo.ic.dm.Downloads;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ep implements com.kwad.sdk.core.d<InterstitialMonitorInfo> {
    /* renamed from: a */
    private static void a2(InterstitialMonitorInfo interstitialMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        interstitialMonitorInfo.status = jSONObject.optInt("status");
        interstitialMonitorInfo.type = jSONObject.optInt("type");
        interstitialMonitorInfo.loadDataTime = jSONObject.optLong("load_data_duration_ms");
        interstitialMonitorInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        interstitialMonitorInfo.renderType = jSONObject.optInt("render_type");
        interstitialMonitorInfo.expectedRenderType = jSONObject.optInt("expected_render_type");
        interstitialMonitorInfo.materialType = jSONObject.optInt("material_type");
        interstitialMonitorInfo.downloadDuration = jSONObject.optLong("download_duration_ms");
        interstitialMonitorInfo.downloadType = jSONObject.optInt(Downloads.Column.DOWNLOAD_TYPE);
        interstitialMonitorInfo.downloadSize = jSONObject.optLong("download_size");
        interstitialMonitorInfo.errorCode = jSONObject.optInt("error_code");
        String optString = jSONObject.optString("error_msg");
        interstitialMonitorInfo.errorMsg = optString;
        if (optString == JSONObject.NULL) {
            interstitialMonitorInfo.errorMsg = "";
        }
        interstitialMonitorInfo.creativeId = jSONObject.optLong("creative_id");
        String optString2 = jSONObject.optString("video_url");
        interstitialMonitorInfo.videoUrl = optString2;
        if (optString2 == JSONObject.NULL) {
            interstitialMonitorInfo.videoUrl = "";
        }
        interstitialMonitorInfo.videoDuration = jSONObject.optLong("video_duration_ms");
        interstitialMonitorInfo.posId = jSONObject.optLong("pos_Id");
    }

    /* renamed from: b */
    private static JSONObject b2(InterstitialMonitorInfo interstitialMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = interstitialMonitorInfo.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i2);
        }
        int i3 = interstitialMonitorInfo.type;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i3);
        }
        long j2 = interstitialMonitorInfo.loadDataTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_data_duration_ms", j2);
        }
        long j3 = interstitialMonitorInfo.renderDuration;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "render_duration_ms", j3);
        }
        int i4 = interstitialMonitorInfo.renderType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "render_type", i4);
        }
        int i5 = interstitialMonitorInfo.expectedRenderType;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "expected_render_type", i5);
        }
        int i6 = interstitialMonitorInfo.materialType;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_type", i6);
        }
        long j4 = interstitialMonitorInfo.downloadDuration;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "download_duration_ms", j4);
        }
        int i7 = interstitialMonitorInfo.downloadType;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, Downloads.Column.DOWNLOAD_TYPE, i7);
        }
        long j5 = interstitialMonitorInfo.downloadSize;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "download_size", j5);
        }
        int i8 = interstitialMonitorInfo.errorCode;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_code", i8);
        }
        String str = interstitialMonitorInfo.errorMsg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_msg", interstitialMonitorInfo.errorMsg);
        }
        long j6 = interstitialMonitorInfo.creativeId;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creative_id", j6);
        }
        String str2 = interstitialMonitorInfo.videoUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "video_url", interstitialMonitorInfo.videoUrl);
        }
        long j7 = interstitialMonitorInfo.videoDuration;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "video_duration_ms", j7);
        }
        long j8 = interstitialMonitorInfo.posId;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pos_Id", j8);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(InterstitialMonitorInfo interstitialMonitorInfo, JSONObject jSONObject) {
        a2(interstitialMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(InterstitialMonitorInfo interstitialMonitorInfo, JSONObject jSONObject) {
        return b2(interstitialMonitorInfo, jSONObject);
    }
}
