package com.kwad.components.offline.api.tk.model.report;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TKDownloadMsg extends BaseOfflineCompoJsonParse<TKDownloadMsg> implements Serializable {
    public static final int ENV_SUCCESS = 3;
    public static final int FAIL = 2;
    private static final int INVALID_DOWNLOAD_STATE = -1;
    public static final int START = 0;
    public static final int SUCCESS = 1;
    private static final long serialVersionUID = -8872909341685100922L;
    public int downloadState = -1;
    public long downloadTime;
    public String errorDetail;
    public String errorReason;
    public int loadingTimes;
    public long offlineLoadTime;
    public int offlineSource;
    public int preload;
    public int retryCount;
    public long soLoadTime;
    public int soSource;
    public String templateId;
    public String versionCode;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(TKDownloadMsg tKDownloadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKDownloadMsg.downloadState = jSONObject.optInt("download_state");
        tKDownloadMsg.downloadTime = jSONObject.optLong(MonitorConstants.EXTRA_DOWNLOAD_TIME);
        tKDownloadMsg.preload = jSONObject.optInt("preload");
        tKDownloadMsg.errorReason = jSONObject.optString("error_reason");
        if (jSONObject.opt("error_reason") == JSONObject.NULL) {
            tKDownloadMsg.errorReason = "";
        }
        tKDownloadMsg.templateId = jSONObject.optString("template_id");
        if (jSONObject.opt("template_id") == JSONObject.NULL) {
            tKDownloadMsg.templateId = "";
        }
        tKDownloadMsg.versionCode = jSONObject.optString("version_code");
        if (jSONObject.opt("version_code") == JSONObject.NULL) {
            tKDownloadMsg.versionCode = "";
        }
        tKDownloadMsg.retryCount = jSONObject.optInt(MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT);
        tKDownloadMsg.loadingTimes = jSONObject.optInt("loading_times");
        tKDownloadMsg.offlineSource = jSONObject.optInt("offline_source");
        tKDownloadMsg.soSource = jSONObject.optInt("so_source");
        tKDownloadMsg.offlineLoadTime = jSONObject.optLong("offline_load_time");
        tKDownloadMsg.soLoadTime = jSONObject.optLong("so_load_time");
        tKDownloadMsg.errorDetail = jSONObject.optString("error_detail");
        if (jSONObject.opt("error_detail") == JSONObject.NULL) {
            tKDownloadMsg.errorDetail = "";
        }
    }

    public TKDownloadMsg setDownloadState(int i2) {
        this.downloadState = i2;
        return this;
    }

    public TKDownloadMsg setDownloadTime(long j2) {
        this.downloadTime = j2;
        return this;
    }

    public TKDownloadMsg setErrorDetail(String str) {
        this.errorDetail = str;
        return this;
    }

    public TKDownloadMsg setErrorReason(String str) {
        this.errorReason = str;
        return this;
    }

    public TKDownloadMsg setLoadingTimes(int i2) {
        this.loadingTimes = i2;
        return this;
    }

    public TKDownloadMsg setOfflineLoadTime(long j2) {
        this.offlineLoadTime = j2;
        return this;
    }

    public TKDownloadMsg setOfflineSource(int i2) {
        this.offlineSource = i2;
        return this;
    }

    public TKDownloadMsg setPreload(int i2) {
        this.preload = i2;
        return this;
    }

    public TKDownloadMsg setRetryCount(int i2) {
        this.retryCount = i2;
        return this;
    }

    public TKDownloadMsg setSoLoadTime(long j2) {
        this.soLoadTime = j2;
        return this;
    }

    public TKDownloadMsg setSoSource(int i2) {
        this.soSource = i2;
        return this;
    }

    public TKDownloadMsg setTemplateId(String str) {
        this.templateId = str;
        return this;
    }

    public TKDownloadMsg setVersionCode(String str) {
        this.versionCode = str;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKDownloadMsg tKDownloadMsg) {
        return toJson(tKDownloadMsg, (JSONObject) null);
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKDownloadMsg tKDownloadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JsonHelper.putValue(jSONObject, "download_state", tKDownloadMsg.downloadState);
        long j2 = tKDownloadMsg.downloadTime;
        if (j2 != 0) {
            JsonHelper.putValue(jSONObject, MonitorConstants.EXTRA_DOWNLOAD_TIME, j2);
        }
        int i2 = tKDownloadMsg.preload;
        if (i2 != 0) {
            JsonHelper.putValue(jSONObject, "preload", i2);
        }
        String str = tKDownloadMsg.errorReason;
        if (str != null && !str.equals("")) {
            JsonHelper.putValue(jSONObject, "error_reason", tKDownloadMsg.errorReason);
        }
        String str2 = tKDownloadMsg.templateId;
        if (str2 != null && !str2.equals("")) {
            JsonHelper.putValue(jSONObject, "template_id", tKDownloadMsg.templateId);
        }
        String str3 = tKDownloadMsg.versionCode;
        if (str3 != null && !str3.equals("")) {
            JsonHelper.putValue(jSONObject, "version_code", tKDownloadMsg.versionCode);
        }
        int i3 = tKDownloadMsg.retryCount;
        if (i3 != 0) {
            JsonHelper.putValue(jSONObject, MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT, i3);
        }
        int i4 = tKDownloadMsg.loadingTimes;
        if (i4 != 0) {
            JsonHelper.putValue(jSONObject, "loading_times", i4);
        }
        int i5 = tKDownloadMsg.offlineSource;
        if (i5 != 0) {
            JsonHelper.putValue(jSONObject, "offline_source", i5);
        }
        int i6 = tKDownloadMsg.soSource;
        if (i6 != 0) {
            JsonHelper.putValue(jSONObject, "so_source", i6);
        }
        long j3 = tKDownloadMsg.offlineLoadTime;
        if (j3 != 0) {
            JsonHelper.putValue(jSONObject, "offline_load_time", j3);
        }
        long j4 = tKDownloadMsg.soLoadTime;
        if (j4 != 0) {
            JsonHelper.putValue(jSONObject, "so_load_time", j4);
        }
        String str4 = tKDownloadMsg.errorDetail;
        if (str4 != null && !str4.equals("")) {
            JsonHelper.putValue(jSONObject, "error_detail", tKDownloadMsg.errorDetail);
        }
        return jSONObject;
    }
}
