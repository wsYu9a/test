package com.aggmoread.sdk.client;

/* loaded from: classes.dex */
public class AMError {
    public int code;
    public Exception exception;
    public String msg;

    public AMError(int i10, String str) {
        this.code = i10;
        this.msg = str;
    }

    public String toString() {
        return "AMError{code=" + this.code + ", msg='" + this.msg + "', exception=" + this.exception + '}';
    }
}
