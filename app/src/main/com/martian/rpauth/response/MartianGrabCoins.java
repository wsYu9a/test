package com.martian.rpauth.response;

/* loaded from: classes3.dex */
public class MartianGrabCoins {
    private Integer coins;
    private Long createdOn;
    private Integer money;

    public int getCoins() {
        Integer num = this.coins;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public long getCreateOn() {
        Long l10 = this.createdOn;
        if (l10 == null) {
            return -1L;
        }
        return l10.longValue();
    }

    public int getMoney() {
        Integer num = this.money;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setCreatedOn(Long l10) {
        this.createdOn = l10;
    }

    public void setMoney(Integer num) {
        this.money = num;
    }
}
