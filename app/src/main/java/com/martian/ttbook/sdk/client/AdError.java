package com.martian.ttbook.sdk.client;

/* loaded from: classes4.dex */
public final class AdError {
    public static final AdError EMPTY = new AdError(-1, "");
    private int errorCode;
    private String errorMessage;
    private String extMessage;

    public AdError(int i2, String str) {
        this.errorCode = i2;
        this.errorMessage = str;
    }

    public AdError(int i2, String str, String str2) {
        this.errorCode = i2;
        this.errorMessage = str;
        this.extMessage = str2;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getExtMessage() {
        return this.extMessage;
    }

    public boolean isSelfApiError() {
        int i2 = this.errorCode;
        return i2 >= 10000 && i2 < 20000;
    }

    public String toString() {
        return "AdError{errorCode=" + this.errorCode + ", errorMessage='" + this.errorMessage + "', extMessage='" + this.extMessage + "'}";
    }
}
