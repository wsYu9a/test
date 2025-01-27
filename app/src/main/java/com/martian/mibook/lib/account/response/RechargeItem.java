package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class RechargeItem {
    public int money;
    public int txsCoins;

    public RechargeItem(int money, int txsCoins) {
        this.money = money;
        this.txsCoins = txsCoins;
    }

    public int getMoney() {
        return this.money;
    }

    public int getTxsCoins() {
        return this.txsCoins;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setTxsCoins(int txsCoins) {
        this.txsCoins = txsCoins;
    }
}
