package com.ss.android.socialbase.downloader.exception;

/* loaded from: classes4.dex */
public class RetryThrowable extends Throwable {
    private String errorMsg;

    public RetryThrowable(String str) {
        super(str);
        this.errorMsg = str;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }
}
