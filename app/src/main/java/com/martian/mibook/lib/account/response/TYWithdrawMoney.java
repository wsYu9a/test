package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class TYWithdrawMoney {
    private Integer count;
    private Integer money;

    public int getCount() {
        Integer num = this.count;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getMoney() {
        Integer num = this.money;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
