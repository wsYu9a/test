package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

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

    public void setCode(String code) {
        this.code = code;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
