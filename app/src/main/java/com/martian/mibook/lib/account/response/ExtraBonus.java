package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class ExtraBonus {
    private Integer coins;
    private Integer duration;

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

    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }
}
