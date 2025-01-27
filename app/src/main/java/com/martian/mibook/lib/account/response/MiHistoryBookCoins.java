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

    public void setBookCoins(Integer bookCoins) {
        this.bookCoins = bookCoins;
    }

    public void setBookCoinsType(String bookCoinsType) {
        this.bookCoinsType = bookCoinsType;
    }

    public void setConsume(Boolean consume) {
        this.consume = consume;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }
}
