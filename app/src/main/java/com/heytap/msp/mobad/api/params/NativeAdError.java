package com.heytap.msp.mobad.api.params;

/* loaded from: classes.dex */
public class NativeAdError {
    public int code;
    public String msg;

    public NativeAdError(int i2, String str) {
        this.code = i2;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "NativeAdError{code=" + this.code + ", msg='" + this.msg + "'}";
    }
}
