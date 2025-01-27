package com.martian.mibook.lib.account.request;

import v8.a;

/* loaded from: classes3.dex */
public class RequestPhoneCodeParams extends TYHttpGetParams {

    @a
    private String captcha;

    @a
    private String phone;

    public String getCaptcha() {
        return this.captcha;
    }

    public String getPhone() {
        return this.phone;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "request_phone_code.do";
    }

    public void setCaptcha(String str) {
        this.captcha = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }
}
