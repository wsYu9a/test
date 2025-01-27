package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class Bonus {
    public Integer coins;
    private Integer extraCoins;
    private Long extraId;
    public Integer money;

    public int getCoins() {
        Integer num = this.coins;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getExtraCoins() {
        Integer num = this.extraCoins;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Long getExtraId() {
        Long l = this.extraId;
        return Long.valueOf(l == null ? 0L : l.longValue());
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

    public void setExtraCoins(Integer extraCoins) {
        this.extraCoins = extraCoins;
    }

    public void setExtraId(Long extraId) {
        this.extraId = extraId;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
