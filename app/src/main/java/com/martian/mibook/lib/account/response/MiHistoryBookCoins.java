package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class MiHistoryBookCoins {
    public Integer bookCoins;
    public String bookCoinsType;
    public Boolean consume;
    public Long createdOn;

    public Integer getBookCoins() {
        return this.bookCoins;
    }

    public String getBookCoinsType() {
        return this.bookCoinsType;
    }

    public boolean getConsume() {
        Boolean bool = this.consume;
        return bool != null && bool.booleanValue();
    }

    public Long getCreatedOn() {
        return this.createdOn;
    }

    public void setBookCoins(Integer num) {
        this.bookCoins = num;
    }

    public void setBookCoinsType(String str) {
        this.bookCoinsType = str;
    }

    public void setConsume(Boolean bool) {
        this.consume = bool;
    }

    public void setCreatedOn(Long l10) {
        this.createdOn = l10;
    }
}
