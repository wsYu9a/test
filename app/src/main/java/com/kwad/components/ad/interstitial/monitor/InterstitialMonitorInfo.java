package com.kwad.components.ad.interstitial.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

@KsJson
/* loaded from: classes.dex */
public class InterstitialMonitorInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final int DOWNLOAD_STATUS_ERROR = 2;
    public static final int DOWNLOAD_STATUS_START = 1;
    public static final int DOWNLOAD_TYPE_ALL = 2;
    public static final int DOWNLOAD_TYPE_ONLINE = 1;
    public static final int DOWNLOAD_TYPE_PART = 3;
    public static final int LOAD_STATUS_AD_SHOWN = 4;
    public static final int LOAD_STATUS_DATA_FINISH = 2;
    public static final int LOAD_STATUS_FAILED = 5;
    public static final int LOAD_STATUS_LOAD_FINISH = 3;
    public static final int LOAD_STATUS_SHOW_AD_CALL = 6;
    public static final int LOAD_STATUS_START = 1;
    public static final int LOAD_TYPE_CACHE = 2;
    public static final int LOAD_TYPE_ONLINE = 1;
    public static final int TYPE_H5 = 2;
    public static final int TYPE_NATIVE = 1;
    public static final int TYPE_TK = 3;
    public static final int VIDEO_PLAY_ERROR = 2;
    public static final int VIDEO_PLAY_START = 1;
    private static final long serialVersionUID = 6882024284587637114L;
    public long creativeId;
    public long downloadDuration;
    public long downloadSize;
    public int downloadType;
    public int errorCode;
    public String errorMsg;
    public int expectedRenderType;
    public long loadDataTime;
    public int materialType;
    public long posId;
    public long renderDuration;
    public int renderType;
    public int status;
    public int type;
    public long videoDuration;
    public String videoUrl;

    public InterstitialMonitorInfo(long j2) {
        this.posId = j2;
    }

    public InterstitialMonitorInfo setCreativeId(long j2) {
        this.creativeId = j2;
        return this;
    }

    public InterstitialMonitorInfo setDownloadDuration(long j2) {
        this.downloadDuration = j2;
        return this;
    }

    public InterstitialMonitorInfo setDownloadSize(long j2) {
        this.downloadSize = j2;
        return this;
    }

    public InterstitialMonitorInfo setDownloadType(int i2) {
        this.downloadType = i2;
        return this;
    }

    public InterstitialMonitorInfo setErrorCode(int i2) {
        this.errorCode = i2;
        return this;
    }

    public InterstitialMonitorInfo setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public InterstitialMonitorInfo setExpectedRenderType(int i2) {
        int i3;
        if (i2 != 0) {
            i3 = i2 == 1 ? 3 : 2;
            return this;
        }
        this.expectedRenderType = i3;
        return this;
    }

    public InterstitialMonitorInfo setLoadDataTime(long j2) {
        this.loadDataTime = j2;
        return this;
    }

    public InterstitialMonitorInfo setMaterialType(int i2) {
        this.materialType = i2;
        return this;
    }

    public InterstitialMonitorInfo setRenderDuration(long j2) {
        this.renderDuration = j2;
        return this;
    }

    public InterstitialMonitorInfo setRenderType(int i2) {
        this.renderType = i2;
        return this;
    }

    public InterstitialMonitorInfo setStatus(int i2) {
        this.status = i2;
        return this;
    }

    public InterstitialMonitorInfo setType(int i2) {
        this.type = i2;
        return this;
    }

    public InterstitialMonitorInfo setVideoDuration(long j2) {
        this.videoDuration = j2;
        return this;
    }

    public InterstitialMonitorInfo setVideoUrl(String str) {
        this.videoUrl = str;
        return this;
    }
}
