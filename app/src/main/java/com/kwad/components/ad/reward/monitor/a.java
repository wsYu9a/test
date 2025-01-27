package com.kwad.components.ad.reward.monitor;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes.dex */
public final class a {
    public static void K(boolean z) {
        KSLoggerReporter.j(new RewardWebViewInfo().setEvent("ad_show").setSceneId(z ? "ad_reward" : "ad_fullscreen").toJson());
    }

    public static void a(AdTemplate adTemplate, int i2, int i3, boolean z) {
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.k(new RewardMonitorInfo(adTemplate.posId).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setRewardType(!z ? 1 : 0).setTaskType(i2).setTaskStep(i3).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).toJson());
    }

    public static void a(boolean z, int i2, String str, long j2) {
        KSLoggerReporter.a(z, new RewardMonitorInfo(j2).setLoadStatus(4).setErrorCode(i2).setErrorMsg(str).toJson(), com.kwai.adclient.kscommerciallogger.model.a.aEc);
    }

    public static void a(boolean z, long j2) {
        KSLoggerReporter.a(z, new RewardMonitorInfo(j2).setLoadStatus(1).toJson(), com.kwai.adclient.kscommerciallogger.model.a.aEg);
    }

    public static void a(boolean z, AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.b(z, new RewardMonitorInfo(adTemplate.posId).setPageStatus(3).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).toJson());
    }

    public static void a(boolean z, @NonNull AdTemplate adTemplate, int i2, long j2) {
        long loadDataTime = (j2 <= 0 || adTemplate.getLoadDataTime() <= 0) ? -1L : adTemplate.getLoadDataTime() - j2;
        long j3 = a(loadDataTime) ? -1L : loadDataTime;
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.a(z, new RewardMonitorInfo(adTemplate.posId).setLoadStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i2).setLoadDataDuration(j3).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).toJson(), com.kwai.adclient.kscommerciallogger.model.a.aEg);
    }

    public static void a(boolean z, AdTemplate adTemplate, long j2) {
        if (adTemplate.getLoadDataTime() <= 0 || adTemplate.getDownloadFinishTime() <= 0) {
            return;
        }
        long loadDataTime = j2 - adTemplate.getLoadDataTime();
        long downloadFinishTime = j2 - adTemplate.getDownloadFinishTime();
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.b(z, new RewardMonitorInfo(adTemplate.posId).setPageStatus(1).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDataLoadInterval(loadDataTime).setDataDownloadInterval(downloadFinishTime).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).toJson());
    }

    public static void a(boolean z, AdTemplate adTemplate, long j2, int i2, long j3) {
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.c(z, new RewardMonitorInfo(adTemplate.posId).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setCurrentDuration(j2).setErrorCode(i2).setErrorMsg(String.valueOf(j3)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).toJson());
    }

    public static void a(boolean z, AdTemplate adTemplate, String str) {
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.a(z, new RewardMonitorInfo(adTemplate.posId).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).setErrorMsg(str).toJson());
    }

    public static void a(boolean z, String str) {
        KSLoggerReporter.j(new RewardWebViewInfo().setPageType(str).setEvent("webview_init").setSceneId(z ? "ad_reward" : "ad_fullscreen").toJson());
    }

    public static void a(boolean z, String str, String str2) {
        KSLoggerReporter.j(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_url").setSceneId(z ? "ad_reward" : "ad_fullscreen").setUrl(str2).toJson());
    }

    public static void a(boolean z, String str, String str2, long j2) {
        KSLoggerReporter.j(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_finish").setSceneId(z ? "ad_reward" : "ad_fullscreen").setDurationMs(j2).setUrl(str2).toJson());
    }

    public static void a(boolean z, String str, String str2, long j2, int i2) {
        KSLoggerReporter.j(new RewardWebViewInfo().setPageType(str).setEvent("webview_timeout").setSceneId(z ? "ad_reward" : "ad_fullscreen").setDurationMs(j2).setTimeType(i2).setUrl(str2).toJson());
    }

    private static boolean a(long... jArr) {
        for (long j2 : jArr) {
            if (j2 >= 60000) {
                return true;
            }
        }
        return false;
    }

    public static void b(boolean z, AdTemplate adTemplate, int i2, long j2) {
        adTemplate.setDownloadFinishTime(SystemClock.elapsedRealtime());
        AdInfo cb = d.cb(adTemplate);
        long loadDataTime = adTemplate.getLoadDataTime() - j2;
        long downloadFinishTime = adTemplate.getDownloadFinishTime() - adTemplate.getLoadDataTime();
        long downloadFinishTime2 = adTemplate.getDownloadFinishTime() - j2;
        if (a(loadDataTime, downloadFinishTime, downloadFinishTime2)) {
            loadDataTime = -1;
            downloadFinishTime = -1;
            downloadFinishTime2 = -1;
        }
        KSLoggerReporter.a(z, new RewardMonitorInfo(adTemplate.posId).setLoadStatus(3).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i2).setLoadDataDuration(loadDataTime).setDownloadDuration(downloadFinishTime).setTotalDuration(downloadFinishTime2).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).toJson(), com.kwai.adclient.kscommerciallogger.model.a.aEg);
    }

    public static void b(boolean z, AdTemplate adTemplate, long j2) {
        if (j2 == 0 || adTemplate.getLoadDataTime() <= 0 || adTemplate.getDownloadFinishTime() <= 0) {
            return;
        }
        long j3 = -1;
        if (!j(j2)) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - j2;
            if (!a(elapsedRealtime)) {
                j3 = elapsedRealtime;
            }
        }
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.b(z, new RewardMonitorInfo(adTemplate.posId).setPageStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setRenderDuration(j3).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).toJson());
    }

    private static boolean j(long j2) {
        return j2 == -1;
    }
}
