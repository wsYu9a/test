package com.kwad.components.splash.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import java.util.List;

@KsJson
/* loaded from: classes2.dex */
public class SplashMonitorInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final int CHECK_BACKUP_FAILED = 4;
    public static final int CHECK_BACKUP_SUCCESS = 3;
    public static final int CHECK_CACHE = 2;
    public static final int CHECK_INVALID_VIDEO = 5;
    public static final int CHECK_TIME_OUT = 7;
    public static final int ERROR_DOWNLOAD = 4;
    public static final int ERROR_NET = 1;
    public static final String ERROR_NET_MSG = "networkError";
    public static final int ERROR_PRELOAD_ID_INVALID = 3;
    public static final String ERROR_PRELOAD_ID_INVALID_MSG = "preloadIdError";
    public static final int ERROR_URL_INVALID = 2;
    public static final String ERROR_URL_INVALID_MSG = "urlError";
    public static final int LOAD_STATUS_CHECK_FAILED = 5;
    public static final int LOAD_STATUS_CHECK_SUCCESS = 3;
    public static final int LOAD_STATUS_DATA_FINISH = 2;
    public static final int LOAD_STATUS_FAILED = 4;
    public static final int LOAD_STATUS_START = 1;
    public static final int LOAD_TYPE_CACHE = 2;
    public static final int LOAD_TYPE_ONLINE = 1;
    public static final int MATERIAL_IMAGE = 2;
    public static final int MATERIAL_VIDEO = 1;
    public static final int PRE_LOAD_FAIL = 3;
    public static final int PRE_LOAD_START = 1;
    public static final int PRE_LOAD_SUCCESS = 2;
    public static final int SHOW_AD_CALL = 4;
    public static final int SHOW_CALL = 6;
    public static final int SHOW_FAIL = 3;
    public static final int SHOW_START = 1;
    public static final int SHOW_SUCCESS = 2;
    public static final int SHOW_TK_OFFLINE_READY = 5;
    public static final int SINGLE_CACHE_FAIL = 2;
    public static final int SINGLE_CACHE_SUCCESS = 1;
    public static final int TYPE_DOWNLOAD = 1;
    public static final int TYPE_UPDATE = 2;
    private static final long serialVersionUID = 3528420046810658543L;
    public long cacheValidTime;
    public long checkDataTime;
    public int checkStatus;
    public long costTime;
    public int count;
    public long creativeId;
    public List<String> creativeIds;
    public int errorCode;
    public String errorMsg;
    public String failUrl;
    public List<String> ids;
    public long loadAndCheckDataTime;
    public long loadDataTime;
    public int materialType;
    public long posId;
    public String preloadId;
    public List<String> preloadIds;
    public long size;
    public int status;
    public int totalCount;
    public int type;

    public SplashMonitorInfo(long j2) {
        this.posId = j2;
    }

    public SplashMonitorInfo setCacheValidTime(long j2) {
        this.cacheValidTime = j2;
        return this;
    }

    public SplashMonitorInfo setCheckDataTime(long j2) {
        this.checkDataTime = j2;
        return this;
    }

    public SplashMonitorInfo setCheckStatus(int i2) {
        this.checkStatus = i2;
        return this;
    }

    public SplashMonitorInfo setCostTime(long j2) {
        this.costTime = j2;
        return this;
    }

    public SplashMonitorInfo setCount(int i2) {
        this.count = i2;
        return this;
    }

    public SplashMonitorInfo setCreativeId(long j2) {
        this.creativeId = j2;
        return this;
    }

    public SplashMonitorInfo setCreativeIds(List<String> list) {
        this.creativeIds = list;
        return this;
    }

    public SplashMonitorInfo setErrorCode(int i2) {
        this.errorCode = i2;
        return this;
    }

    public SplashMonitorInfo setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public SplashMonitorInfo setFailUrl(String str) {
        this.failUrl = str;
        return this;
    }

    public SplashMonitorInfo setIds(List<String> list) {
        this.ids = list;
        return this;
    }

    public SplashMonitorInfo setLoadAndCheckDataTime(long j2) {
        this.loadAndCheckDataTime = j2;
        return this;
    }

    public SplashMonitorInfo setLoadDataTime(long j2) {
        this.loadDataTime = j2;
        return this;
    }

    public SplashMonitorInfo setMaterialType(int i2) {
        this.materialType = i2;
        return this;
    }

    public SplashMonitorInfo setPreloadId(String str) {
        this.preloadId = str;
        return this;
    }

    public SplashMonitorInfo setPreloadIds(List<String> list) {
        this.preloadIds = list;
        return this;
    }

    public SplashMonitorInfo setSize(long j2) {
        this.size = j2;
        return this;
    }

    public SplashMonitorInfo setStatus(int i2) {
        this.status = i2;
        return this;
    }

    public SplashMonitorInfo setTotalCount(int i2) {
        this.totalCount = i2;
        return this;
    }

    public SplashMonitorInfo setType(int i2) {
        this.type = i2;
        return this;
    }
}
