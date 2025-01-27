package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.a;

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

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "request_phone_code.do";
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
