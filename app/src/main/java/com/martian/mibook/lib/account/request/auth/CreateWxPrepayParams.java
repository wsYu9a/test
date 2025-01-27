package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class CreateWxPrepayParams extends TYAuthParams {

    @a
    private String extra;

    @a
    private Integer money;

    @a
    private Integer productId;

    @a
    private String wx_appid;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "wxprepay_recharge.do";
    }

    public String getExtra() {
        return this.extra;
    }

    public Integer getMoney() {
        return this.money;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public String getWx_appid() {
        return this.wx_appid;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setWx_appid(String wx_appid) {
        this.wx_appid = wx_appid;
    }
}
