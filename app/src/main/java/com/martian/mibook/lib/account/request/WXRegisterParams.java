package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class WXRegisterParams extends TYHttpGetParams {

    @a
    private String phone;

    @a
    private String wx_appid;

    @a
    private String wx_code;

    public String getPhone() {
        return this.phone;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "wx_register.do";
    }

    public String getWx_appid() {
        return this.wx_appid;
    }

    public String getWx_code() {
        return this.wx_code;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWx_appid(String wx_appid) {
        this.wx_appid = wx_appid;
    }

    public void setWx_code(String wx_code) {
        this.wx_code = wx_code;
    }
}
