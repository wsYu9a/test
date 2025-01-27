package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class IntervalBonus {
    private Integer coins;
    private Integer commission;
    private Integer duration;
    private Integer extraCoins;
    private Integer extraDuration;
    private Long extraId;
    private Integer leftTime;
    private Integer money;

    public Integer getCoins() {
        Integer num = this.coins;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getCommission() {
        Integer num = this.commission;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public int getDuration() {
        Integer num = this.duration;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getExtraCoins() {
        Integer num = this.extraCoins;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getExtraDuration() {
        Integer num = this.extraDuration;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Long getExtraId() {
        Long l = this.extraId;
        return Long.valueOf(l == null ? 0L : l.longValue());
    }

    public int getLeftTime() {
        Integer num = this.leftTime;
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

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setExtraCoins(Integer extraCoins) {
        this.extraCoins = extraCoins;
    }

    public void setExtraDuration(Integer extraDuration) {
        this.extraDuration = extraDuration;
    }

    public void setExtraId(Long extraId) {
        this.extraId = extraId;
    }

    public void setLeftTime(Integer leftTime) {
        this.leftTime = leftTime;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
