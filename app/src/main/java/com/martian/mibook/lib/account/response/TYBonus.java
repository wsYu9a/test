package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class TYBonus {
    public Integer coins;
    public Integer duration;
    public Integer money;

    public int getCoins() {
        Integer num = this.coins;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getDuration() {
        Integer num = this.duration;
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

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
