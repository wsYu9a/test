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

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setMethod(Integer num) {
        this.method = num;
    }

    public void setMoney(Integer num) {
        this.money = num;
    }

    public void setProductId(String str) {
        this.productId = str;
    }
}
