package com.martian.mibook.data;

/* loaded from: classes3.dex */
public class VipAdInfo {
    public Integer money;
    public Integer productId;

    public int getMoney() {
        Integer num = this.money;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getMoneyString() {
        if (getMoney() <= 0) {
            return "";
        }
        return (this.money.intValue() / 100.0f) + "";
    }

    public Integer getProductId() {
        return this.productId;
    }

    public boolean isValid() {
        return (this.money == null || this.productId == null) ? false : true;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
