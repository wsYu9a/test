package com.martian.mibook.lib.account.request;

import v8.a;

/* loaded from: classes3.dex */
public class RequestPhoneCodeCaptchaParams extends TYHttpGetParams {

    @a
    private String phone;

    public String getPhone() {
        return this.phone;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "request_phone_code_captcha.do";
    }

    public void setPhone(String str) {
        this.phone = str;
    }
}
