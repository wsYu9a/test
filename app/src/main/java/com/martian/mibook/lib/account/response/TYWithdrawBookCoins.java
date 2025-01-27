package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class TYWithdrawBookCoins {
    private Integer bookCoins;
    private String desc;
    private Integer money;
    private String promotion;

    public Integer getBookCoins() {
        return this.bookCoins;
    }

    public String getDesc() {
        return this.desc;
    }

    public Integer getMoney() {
        return this.money;
    }

    public String getPromotion() {
        return this.promotion;
    }

    public void setBookCoins(Integer num) {
        this.bookCoins = num;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setMoney(Integer num) {
        this.money = num;
    }

    public void setPromotion(String str) {
        this.promotion = str;
    }
}
