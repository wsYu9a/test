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
        Long l10 = this.createdOn;
        return Long.valueOf(l10 == null ? 0L : l10.longValue());
    }

    public String getCtype() {
        return this.coinsType;
    }

    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setCreatedOn(Long l10) {
        this.createdOn = l10;
    }

    public void setCtype(String str) {
        this.coinsType = str;
    }
}
