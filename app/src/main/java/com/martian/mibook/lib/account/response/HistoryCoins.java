package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class HistoryCoins {
    private Integer coins;
    private String coinsType;
    private Long createdOn;

    public int getCoins() {
        Integer num = this.coins;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Long getCreatedOn() {
        Long l = this.createdOn;
        return Long.valueOf(l == null ? 0L : l.longValue());
    }

    public String getCtype() {
        return this.coinsType;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public void setCtype(String coinsType) {
        this.coinsType = coinsType;
    }
}
