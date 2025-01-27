package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class WebRechargeParams {
    private String extra;
    private Integer method;
    private Integer money;
    private String productId;

    public String getExtra() {
        return this.extra;
    }

    public int getMethod() {
        Integer num = this.method;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getMoney() {
        return this.money;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setMethod(Integer method) {
        this.method = method;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
