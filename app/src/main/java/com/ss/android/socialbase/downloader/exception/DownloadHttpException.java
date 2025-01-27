package com.ss.android.socialbase.downloader.exception;

/* loaded from: classes4.dex */
public class DownloadHttpException extends BaseException {
    private final int httpStatusCode;

    public DownloadHttpException(int i10, int i11, String str) {
        super(i10, str);
        this.httpStatusCode = i11;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }
}
