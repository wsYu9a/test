package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class RequestPhoneCodeCaptchaParams extends TYHttpGetParams {

    @a
    private String phone;

    public String getPhone() {
        return this.phone;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "request_phone_code_captcha.do";
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
