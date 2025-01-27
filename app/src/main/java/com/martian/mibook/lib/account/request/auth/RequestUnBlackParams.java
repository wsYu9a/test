package com.martian.mibook.lib.account.request.auth;

import v8.a;

/* loaded from: classes3.dex */
public class RequestUnBlackParams extends TYAuthParams {

    @a
    private String reason;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "request_unblack.do";
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String str) {
        this.reason = str;
    }
}
