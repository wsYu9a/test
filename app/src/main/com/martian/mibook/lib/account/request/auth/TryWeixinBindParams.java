package com.martian.mibook.lib.account.request.auth;

import v8.a;

/* loaded from: classes3.dex */
public class TryWeixinBindParams extends TYAuthParams {

    @a
    private String wx_appid;

    @a
    private String wx_code;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "try_wx_bind_v2";
    }

    public String getWx_appid() {
        return this.wx_appid;
    }

    public String getWx_code() {
        return this.wx_code;
    }

    public void setWx_appid(String str) {
        this.wx_appid = str;
    }

    public void setWx_code(String str) {
        this.wx_code = str;
    }
}
