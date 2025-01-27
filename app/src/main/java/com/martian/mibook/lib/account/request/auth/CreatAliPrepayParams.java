package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

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

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
