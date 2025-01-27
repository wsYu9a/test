package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.sigmob.windad.WindAds;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class iq implements com.kwad.sdk.core.d<RewardMonitorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        a2(rewardMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        return b2(rewardMonitorInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardMonitorInfo.loadType = jSONObject.optInt("load_type");
        rewardMonitorInfo.loadStatus = jSONObject.optInt("load_status");
        rewardMonitorInfo.adCount = jSONObject.optInt("ad_count");
        rewardMonitorInfo.loadDataDuration = jSONObject.optLong("load_data_duration_ms");
        rewardMonitorInfo.downloadDuration = jSONObject.optLong("download_duration_ms");
        rewardMonitorInfo.totalDuration = jSONObject.optLong("total_duration_ms");
        rewardMonitorInfo.downloadType = jSONObject.optInt("download_type");
        rewardMonitorInfo.downloadSize = jSONObject.optLong("download_size");
        rewardMonitorInfo.creativeId = jSONObject.optLong(ExposeManager.UtArgsNames.creativeId);
        rewardMonitorInfo.videoUrl = jSONObject.optString("video_url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(rewardMonitorInfo.videoUrl)) {
            rewardMonitorInfo.videoUrl = "";
        }
        rewardMonitorInfo.videoDuration = jSONObject.optLong("video_duration_ms");
        rewardMonitorInfo.dataLoadInterval = jSONObject.optLong("data_load_interval_duration_ms");
        rewardMonitorInfo.dataDownloadInterval = jSONObject.optLong("data_download_interval_duration_ms");
        rewardMonitorInfo.adSceneType = jSONObject.optInt("ad_scene_type");
        rewardMonitorInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        rewardMonitorInfo.currentDuration = jSONObject.optLong("video_duration_ms");
        rewardMonitorInfo.pageStatus = jSONObject.optInt("page_status");
        rewardMonitorInfo.subStage = jSONObject.optString("sub_stage");
        if (obj.toString().equals(rewardMonitorInfo.subStage)) {
            rewardMonitorInfo.subStage = "";
        }
        rewardMonitorInfo.launchFrom = jSONObject.optString("launch_from");
        if (obj.toString().equals(rewardMonitorInfo.launchFrom)) {
            rewardMonitorInfo.launchFrom = "";
        }
        rewardMonitorInfo.rewardType = jSONObject.optInt(WindAds.REWARD_TYPE);
        rewardMonitorInfo.taskType = jSONObject.optInt("task_type");
        rewardMonitorInfo.taskStep = jSONObject.optInt("task_step");
        rewardMonitorInfo.posId = jSONObject.optLong("pos_Id");
        rewardMonitorInfo.materialType = jSONObject.optInt("material_type");
        rewardMonitorInfo.materialRenderType = jSONObject.optString("material_render_type");
        if (obj.toString().equals(rewardMonitorInfo.materialRenderType)) {
            rewardMonitorInfo.materialRenderType = "";
        }
        rewardMonitorInfo.operationType = jSONObject.optInt("operation_type");
        rewardMonitorInfo.tkRenderType = jSONObject.optInt("tk_render_type");
        rewardMonitorInfo.callbackType = jSONObject.optString("callback_type");
        if (obj.toString().equals(rewardMonitorInfo.callbackType)) {
            rewardMonitorInfo.callbackType = "";
        }
        rewardMonitorInfo.enableRewardLayoutOptimise = jSONObject.optBoolean("enable_reward_layout_optimise");
        rewardMonitorInfo.enableFullscreenLayoutOptimise = jSONObject.optBoolean("enable_fullscreen_layout_optimise");
        rewardMonitorInfo.rewardTaskType = jSONObject.optInt("reward_task_type");
        rewardMonitorInfo.fraudVerifyType = jSONObject.optInt("fraud_verify_type");
        rewardMonitorInfo.fraudVerifyCode = jSONObject.optInt("fraud_verify_code");
        rewardMonitorInfo.interceptReason = jSONObject.optString("intercept_reason");
        if (obj.toString().equals(rewardMonitorInfo.interceptReason)) {
            rewardMonitorInfo.interceptReason = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = rewardMonitorInfo.loadType;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "load_type", i10);
        }
        int i11 = rewardMonitorInfo.loadStatus;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "load_status", i11);
        }
        int i12 = rewardMonitorInfo.adCount;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "ad_count", i12);
        }
        long j10 = rewardMonitorInfo.loadDataDuration;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "load_data_duration_ms", j10);
        }
        long j11 = rewardMonitorInfo.downloadDuration;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "download_duration_ms", j11);
        }
        long j12 = rewardMonitorInfo.totalDuration;
        if (j12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "total_duration_ms", j12);
        }
        int i13 = rewardMonitorInfo.downloadType;
        if (i13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "download_type", i13);
        }
        long j13 = rewardMonitorInfo.downloadSize;
        if (j13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "download_size", j13);
        }
        long j14 = rewardMonitorInfo.creativeId;
        if (j14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, ExposeManager.UtArgsNames.creativeId, j14);
        }
        String str = rewardMonitorInfo.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "video_url", rewardMonitorInfo.videoUrl);
        }
        long j15 = rewardMonitorInfo.videoDuration;
        if (j15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "video_duration_ms", j15);
        }
        long j16 = rewardMonitorInfo.dataLoadInterval;
        if (j16 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "data_load_interval_duration_ms", j16);
        }
        long j17 = rewardMonitorInfo.dataDownloadInterval;
        if (j17 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "data_download_interval_duration_ms", j17);
        }
        int i14 = rewardMonitorInfo.adSceneType;
        if (i14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "ad_scene_type", i14);
        }
        long j18 = rewardMonitorInfo.renderDuration;
        if (j18 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "render_duration_ms", j18);
        }
        long j19 = rewardMonitorInfo.currentDuration;
        if (j19 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "video_duration_ms", j19);
        }
        int i15 = rewardMonitorInfo.pageStatus;
        if (i15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "page_status", i15);
        }
        String str2 = rewardMonitorInfo.subStage;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sub_stage", rewardMonitorInfo.subStage);
        }
        String str3 = rewardMonitorInfo.launchFrom;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "launch_from", rewardMonitorInfo.launchFrom);
        }
        int i16 = rewardMonitorInfo.rewardType;
        if (i16 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, WindAds.REWARD_TYPE, i16);
        }
        int i17 = rewardMonitorInfo.taskType;
        if (i17 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "task_type", i17);
        }
        int i18 = rewardMonitorInfo.taskStep;
        if (i18 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "task_step", i18);
        }
        long j20 = rewardMonitorInfo.posId;
        if (j20 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "pos_Id", j20);
        }
        int i19 = rewardMonitorInfo.materialType;
        if (i19 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "material_type", i19);
        }
        String str4 = rewardMonitorInfo.materialRenderType;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "material_render_type", rewardMonitorInfo.materialRenderType);
        }
        int i20 = rewardMonitorInfo.operationType;
        if (i20 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "operation_type", i20);
        }
        int i21 = rewardMonitorInfo.tkRenderType;
        if (i21 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "tk_render_type", i21);
        }
        String str5 = rewardMonitorInfo.callbackType;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "callback_type", rewardMonitorInfo.callbackType);
        }
        boolean z10 = rewardMonitorInfo.enableRewardLayoutOptimise;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "enable_reward_layout_optimise", z10);
        }
        boolean z11 = rewardMonitorInfo.enableFullscreenLayoutOptimise;
        if (z11) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "enable_fullscreen_layout_optimise", z11);
        }
        int i22 = rewardMonitorInfo.rewardTaskType;
        if (i22 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "reward_task_type", i22);
        }
        int i23 = rewardMonitorInfo.fraudVerifyType;
        if (i23 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "fraud_verify_type", i23);
        }
        int i24 = rewardMonitorInfo.fraudVerifyCode;
        if (i24 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "fraud_verify_code", i24);
        }
        String str6 = rewardMonitorInfo.interceptReason;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "intercept_reason", rewardMonitorInfo.interceptReason);
        }
        return jSONObject;
    }
}
