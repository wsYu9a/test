package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class TryWeixinBindParams extends TYAuthParams {

    @a
    private String wx_appid;

    @a
    private String wx_code;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "try_wx_bind";
    }

    public String getWx_appid() {
        return this.wx_appid;
    }

    public String getWx_code() {
        return this.wx_code;
    }

    public void setWx_appid(String wx_appid) {
        this.wx_appid = wx_appid;
    }

    public void setWx_code(String wx_code) {
        this.wx_code = wx_code;
    }
}
