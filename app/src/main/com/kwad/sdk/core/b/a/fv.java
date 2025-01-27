package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kwad.components.ad.interstitial.report.InterstitialReportInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class fv implements com.kwad.sdk.core.d<InterstitialReportInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        a2(interstitialReportInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        return b2(interstitialReportInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        interstitialReportInfo.status = jSONObject.optInt("status");
        interstitialReportInfo.type = jSONObject.optInt("type");
        interstitialReportInfo.loadDataTime = jSONObject.optLong("load_data_duration_ms");
        interstitialReportInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        interstitialReportInfo.renderType = jSONObject.optInt("render_type");
        interstitialReportInfo.expectedRenderType = jSONObject.optInt("expected_render_type");
        interstitialReportInfo.materialType = jSONObject.optInt("material_type");
        interstitialReportInfo.downloadDuration = jSONObject.optLong("download_duration_ms");
        interstitialReportInfo.downloadType = jSONObject.optInt("download_type");
        interstitialReportInfo.downloadSize = jSONObject.optLong("download_size");
        interstitialReportInfo.creativeId = jSONObject.optLong(ExposeManager.UtArgsNames.creativeId);
        interstitialReportInfo.videoUrl = jSONObject.optString("video_url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(interstitialReportInfo.videoUrl)) {
            interstitialReportInfo.videoUrl = "";
        }
        interstitialReportInfo.videoDuration = jSONObject.optLong("video_duration_ms");
        interstitialReportInfo.playStartedDuration = jSONObject.optLong("play_started_duration_ms");
        interstitialReportInfo.abParams = jSONObject.optString("ab_params");
        if (obj.toString().equals(interstitialReportInfo.abParams)) {
            interstitialReportInfo.abParams = "";
        }
        interstitialReportInfo.actionType = jSONObject.optLong("action_type");
        interstitialReportInfo.callbackType = jSONObject.optLong("callback_type");
        interstitialReportInfo.clickSceneType = jSONObject.optLong("click_scene_type");
        interstitialReportInfo.itemClickType = jSONObject.optLong("item_click_type");
        interstitialReportInfo.visiblePercent = jSONObject.optDouble("visible_percent");
    }

    /* renamed from: b */
    private static JSONObject b2(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = interstitialReportInfo.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "status", i10);
        }
        int i11 = interstitialReportInfo.type;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "type", i11);
        }
        long j10 = interstitialReportInfo.loadDataTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "load_data_duration_ms", j10);
        }
        long j11 = interstitialReportInfo.renderDuration;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "render_duration_ms", j11);
        }
        int i12 = interstitialReportInfo.renderType;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "render_type", i12);
        }
        int i13 = interstitialReportInfo.expectedRenderType;
        if (i13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "expected_render_type", i13);
        }
        int i14 = interstitialReportInfo.materialType;
        if (i14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "material_type", i14);
        }
        long j12 = interstitialReportInfo.downloadDuration;
        if (j12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "download_duration_ms", j12);
        }
        int i15 = interstitialReportInfo.downloadType;
        if (i15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "download_type", i15);
        }
        long j13 = interstitialReportInfo.downloadSize;
        if (j13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "download_size", j13);
        }
        long j14 = interstitialReportInfo.creativeId;
        if (j14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, ExposeManager.UtArgsNames.creativeId, j14);
        }
        String str = interstitialReportInfo.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "video_url", interstitialReportInfo.videoUrl);
        }
        long j15 = interstitialReportInfo.videoDuration;
        if (j15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "video_duration_ms", j15);
        }
        long j16 = interstitialReportInfo.playStartedDuration;
        if (j16 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "play_started_duration_ms", j16);
        }
        String str2 = interstitialReportInfo.abParams;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "ab_params", interstitialReportInfo.abParams);
        }
        long j17 = interstitialReportInfo.actionType;
        if (j17 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "action_type", j17);
        }
        long j18 = interstitialReportInfo.callbackType;
        if (j18 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "callback_type", j18);
        }
        long j19 = interstitialReportInfo.clickSceneType;
        if (j19 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "click_scene_type", j19);
        }
        long j20 = interstitialReportInfo.itemClickType;
        if (j20 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "item_click_type", j20);
        }
        double d10 = interstitialReportInfo.visiblePercent;
        if (d10 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "visible_percent", d10);
        }
        return jSONObject;
    }
}
