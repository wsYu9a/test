package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class RechargeItem {
    public int money;
    public int txsCoins;

    public RechargeItem(int i10, int i11) {
        this.money = i10;
        this.txsCoins = i11;
    }

    public int getMoney() {
        return this.money;
    }

    public int getTxsCoins() {
        return this.txsCoins;
    }

    public void setMoney(int i10) {
        this.money = i10;
    }

    public void setTxsCoins(int i10) {
        this.txsCoins = i10;
    }
}
