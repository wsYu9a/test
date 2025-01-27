package com.vivo.mobilead.unified.base;

import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public class VivoAdError {
    private int code;
    private String msg;

    public VivoAdError(int i2, String str) {
        this.code = i2;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    @NonNull
    public String toString() {
        return "VivoAdError{code=" + this.code + ", msg='" + this.msg + "'}";
    }
}
