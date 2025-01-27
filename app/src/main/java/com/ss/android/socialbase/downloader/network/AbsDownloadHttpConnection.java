package com.ss.android.socialbase.downloader.network;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class AbsDownloadHttpConnection implements IDownloadHttpConnection {
    public String getHostIp() {
        return "";
    }

    public String getRequestLog() {
        return "";
    }

    public void monitorNetworkInfo(JSONObject jSONObject, boolean z10) {
    }

    public void onThrowable(Throwable th2) {
    }

    public void setThrottleNetSpeedWhenRunning(long j10) {
    }
}
