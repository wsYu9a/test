package com.martian.libsupport.data;

/* loaded from: classes3.dex */
public class WxBindResultParams extends WebParams {
    private int errcode;

    public int getErrcode() {
        return this.errcode;
    }

    @Override // com.martian.libsupport.data.WebParams
    public String getType() {
        return "wxBindResult";
    }

    public WxBindResultParams setErrcode(int errcode) {
        this.errcode = errcode;
        return this;
    }
}
