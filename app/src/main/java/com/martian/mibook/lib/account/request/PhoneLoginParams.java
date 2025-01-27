package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.a;

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

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "phone_login.do";
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
