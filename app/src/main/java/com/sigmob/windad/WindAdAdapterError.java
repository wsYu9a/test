package com.sigmob.windad;

/* loaded from: classes4.dex */
public class WindAdAdapterError {

    /* renamed from: a */
    public int f20860a;
    String message;

    public WindAdAdapterError(int i10, String str) {
        this.f20860a = i10;
        this.message = str;
    }

    public int getErrorCode() {
        return this.f20860a;
    }

    public String getMessage() {
        return this.message;
    }

    public void setErrorCode(int i10) {
        this.f20860a = i10;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "{errorCode:" + this.f20860a + ", message:'" + this.message + "'}";
    }
}
