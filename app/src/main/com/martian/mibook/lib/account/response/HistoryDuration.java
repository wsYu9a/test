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
        Long l10 = this.createdOn;
        return Long.valueOf(l10 == null ? 0L : l10.longValue());
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

    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setCreatedOn(Long l10) {
        this.createdOn = l10;
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }

    public void setType(String str) {
        this.durationType = str;
    }
}
