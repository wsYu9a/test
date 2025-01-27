package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.vivo.ic.dm.Downloads;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ha implements com.kwad.sdk.core.d<RewardMonitorInfo> {
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
        rewardMonitorInfo.downloadType = jSONObject.optInt(Downloads.Column.DOWNLOAD_TYPE);
        rewardMonitorInfo.downloadSize = jSONObject.optLong("download_size");
        rewardMonitorInfo.errorCode = jSONObject.optInt("error_code");
        String optString = jSONObject.optString("error_msg");
        rewardMonitorInfo.errorMsg = optString;
        if (optString == JSONObject.NULL) {
            rewardMonitorInfo.errorMsg = "";
        }
        rewardMonitorInfo.creativeId = jSONObject.optLong("creative_id");
        String optString2 = jSONObject.optString("video_url");
        rewardMonitorInfo.videoUrl = optString2;
        if (optString2 == JSONObject.NULL) {
            rewardMonitorInfo.videoUrl = "";
        }
        rewardMonitorInfo.videoDuration = jSONObject.optLong("video_duration_ms");
        rewardMonitorInfo.dataLoadInterval = jSONObject.optLong("data_load_interval_duration_ms");
        rewardMonitorInfo.dataDownloadInterval = jSONObject.optLong("data_download_interval_duration_ms");
        rewardMonitorInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        rewardMonitorInfo.currentDuration = jSONObject.optLong("video_duration_ms");
        rewardMonitorInfo.pageStatus = jSONObject.optInt("page_status");
        rewardMonitorInfo.rewardType = jSONObject.optInt("reward_type");
        rewardMonitorInfo.taskType = jSONObject.optInt("task_type");
        rewardMonitorInfo.taskStep = jSONObject.optInt("task_step");
        rewardMonitorInfo.posId = jSONObject.optLong("pos_Id");
    }

    /* renamed from: b */
    private static JSONObject b2(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = rewardMonitorInfo.loadType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_type", i2);
        }
        int i3 = rewardMonitorInfo.loadStatus;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_status", i3);
        }
        int i4 = rewardMonitorInfo.adCount;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_count", i4);
        }
        long j2 = rewardMonitorInfo.loadDataDuration;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_data_duration_ms", j2);
        }
        long j3 = rewardMonitorInfo.downloadDuration;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "download_duration_ms", j3);
        }
        long j4 = rewardMonitorInfo.totalDuration;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "total_duration_ms", j4);
        }
        int i5 = rewardMonitorInfo.downloadType;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, Downloads.Column.DOWNLOAD_TYPE, i5);
        }
        long j5 = rewardMonitorInfo.downloadSize;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "download_size", j5);
        }
        int i6 = rewardMonitorInfo.errorCode;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_code", i6);
        }
        String str = rewardMonitorInfo.errorMsg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_msg", rewardMonitorInfo.errorMsg);
        }
        long j6 = rewardMonitorInfo.creativeId;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creative_id", j6);
        }
        String str2 = rewardMonitorInfo.videoUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "video_url", rewardMonitorInfo.videoUrl);
        }
        long j7 = rewardMonitorInfo.videoDuration;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "video_duration_ms", j7);
        }
        long j8 = rewardMonitorInfo.dataLoadInterval;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "data_load_interval_duration_ms", j8);
        }
        long j9 = rewardMonitorInfo.dataDownloadInterval;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "data_download_interval_duration_ms", j9);
        }
        long j10 = rewardMonitorInfo.renderDuration;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "render_duration_ms", j10);
        }
        long j11 = rewardMonitorInfo.currentDuration;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "video_duration_ms", j11);
        }
        int i7 = rewardMonitorInfo.pageStatus;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "page_status", i7);
        }
        int i8 = rewardMonitorInfo.rewardType;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reward_type", i8);
        }
        int i9 = rewardMonitorInfo.taskType;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "task_type", i9);
        }
        int i10 = rewardMonitorInfo.taskStep;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "task_step", i10);
        }
        long j12 = rewardMonitorInfo.posId;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pos_Id", j12);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        a2(rewardMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        return b2(rewardMonitorInfo, jSONObject);
    }
}
