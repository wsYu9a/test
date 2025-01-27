package com.martian.mibook.lib.account.request.auth;

import v8.a;

/* loaded from: classes3.dex */
public class CreatAliPrepayParams extends TYAuthParams {

    @a
    private String extra;

    @a
    private Integer money;

    @a
    private Integer productId;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "apprepay_recharge.do";
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

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setMoney(Integer num) {
        this.money = num;
    }

    public void setProductId(Integer num) {
        this.productId = num;
    }
}
