package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class HistoryDuration {
    private Integer coins;
    private Long createdOn;
    private Integer duration;
    private String durationType;

    public Integer getCoins() {
        Integer num = this.coins;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Long getCreatedOn() {
        Long l = this.createdOn;
        return Long.valueOf(l == null ? 0L : l.longValue());
    }

    public int getDuration() {
        Integer num = this.duration;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getType() {
        return this.durationType;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setType(String durationType) {
        this.durationType = durationType;
    }
}
