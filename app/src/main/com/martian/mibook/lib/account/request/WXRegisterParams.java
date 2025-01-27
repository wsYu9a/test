package com.martian.mibook.lib.account.request;

import v8.a;

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

    @Override // u8.b
    public String getRequestMethod() {
        return "wx_register.do";
    }

    public String getWx_appid() {
        return this.wx_appid;
    }

    public String getWx_code() {
        return this.wx_code;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setWx_appid(String str) {
        this.wx_appid = str;
    }

    public void setWx_code(String str) {
        this.wx_code = str;
    }
}
