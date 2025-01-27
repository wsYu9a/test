package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class CheckinResult {
    private BonusPool bonusPool;
    private Integer coins;
    private Integer duration;
    private Integer extraCoins;
    private Integer extraDuration;
    private Long extraId;
    private Integer money;

    public BonusPool getBonusPool() {
        return this.bonusPool;
    }

    public Integer getCoins() {
        Integer num = this.coins;
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

    public long getExtraId() {
        Long l = this.extraId;
        if (l == null) {
            return 0L;
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

    public void setBonusPool(BonusPool bonusPool) {
        this.bonusPool = bonusPool;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
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

    public void setMoney(Integer money) {
        this.money = money;
    }
}
