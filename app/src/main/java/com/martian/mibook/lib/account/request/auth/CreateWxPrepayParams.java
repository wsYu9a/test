package com.martian.mibook.lib.account.request.auth;

import v8.a;

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

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setMoney(Integer num) {
        this.money = num;
    }

    public void setProductId(Integer num) {
        this.productId = num;
    }

    public void setWx_appid(String str) {
        this.wx_appid = str;
    }
}
