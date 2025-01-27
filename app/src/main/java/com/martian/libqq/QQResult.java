package com.martian.libqq;

/* loaded from: classes3.dex */
public class QQResult {
    private String msg;
    private int ret;

    public String getErrMsg() {
        return this.msg;
    }

    public int getErrcode() {
        return this.ret;
    }

    public boolean hasError() {
        return this.ret != 0;
    }
}
