package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class WithdrawCommissionLimitation {
    private String bookCoinsRules;
    private Boolean enableBookCoins;
    private Integer minWXMoney;
    private String moneyRules;

    public String getBookCoinsRules() {
        return this.bookCoinsRules;
    }

    public Boolean getEnableBookCoins() {
        return this.enableBookCoins;
    }

    public Integer getMinWXMoney() {
        return this.minWXMoney;
    }

    public String getMoneyRules() {
        return this.moneyRules;
    }

    public void setBookCoinsRules(String bookCoinsRules) {
        this.bookCoinsRules = bookCoinsRules;
    }

    public void setEnableBookCoins(Boolean enableBookCoins) {
        this.enableBookCoins = enableBookCoins;
    }

    public void setMinWXMoney(Integer minWXMoney) {
        this.minWXMoney = minWXMoney;
    }

    public void setMoneyRules(String moneyRules) {
        this.moneyRules = moneyRules;
    }
}
