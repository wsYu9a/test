package com.martian.mibook.lib.account.request;

import v8.a;

/* loaded from: classes3.dex */
public class PhoneLoginParams extends TYHttpGetParams {

    @a
    private String code;

    @a
    private String phone;

    public String getCode() {
        return this.code;
    }

    public String getPhone() {
        return this.phone;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "phone_login.do";
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }
}
