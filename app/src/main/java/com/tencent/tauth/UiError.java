package com.tencent.tauth;

/* loaded from: classes4.dex */
public class UiError {
    public int errorCode;
    public String errorDetail;
    public String errorMessage;

    public UiError(int i10, String str, String str2) {
        this.errorMessage = str;
        this.errorCode = i10;
        this.errorDetail = str2;
    }
}
