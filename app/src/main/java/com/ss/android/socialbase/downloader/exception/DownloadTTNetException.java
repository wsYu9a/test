package com.ss.android.socialbase.downloader.exception;

/* loaded from: classes4.dex */
public class DownloadTTNetException extends BaseException {
    public DownloadTTNetException(int i10, String str) {
        super(i10, str);
    }

    public String getRequestLog() {
        return getExtraInfo();
    }

    public DownloadTTNetException setRequestLog(String str) {
        setExtraInfo(str);
        return this;
    }

    public DownloadTTNetException(int i10, Throwable th2) {
        super(i10, th2);
    }
}
