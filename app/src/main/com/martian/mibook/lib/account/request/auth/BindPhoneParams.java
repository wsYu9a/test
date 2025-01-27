package com.martian.mibook.lib.account.request.auth;

import v8.a;

/* loaded from: classes3.dex */
public class BindPhoneParams extends TYAuthParams {

    @a
    private String code;

    @a
    private String phone;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "bind_phone.do";
    }

    public String getCode() {
        return this.code;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }
}
