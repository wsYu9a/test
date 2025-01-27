package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class MartianExchangeRecord {
    private Integer coins;
    private Integer money;
    private Double rate;

    public int getCoins() {
        Integer num = this.coins;
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

    public Double getRate() {
        Double d2 = this.rate;
        return Double.valueOf(d2 == null ? 0.0d : d2.doubleValue());
    }

    public void setCoins(Integer money) {
        this.coins = money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
