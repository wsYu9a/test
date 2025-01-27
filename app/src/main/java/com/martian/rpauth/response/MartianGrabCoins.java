package com.martian.rpauth.response;

/* loaded from: classes4.dex */
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
        Long l = this.createdOn;
        if (l == null) {
            return -1L;
        }
        return l.longValue();
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

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
