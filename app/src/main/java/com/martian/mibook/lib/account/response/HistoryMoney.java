package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class HistoryMoney {
    private Long createdOn;
    private Integer money;
    private String type;

    public Long getCreatedOn() {
        Long l = this.createdOn;
        return Long.valueOf(l == null ? 0L : l.longValue());
    }

    public int getMoney() {
        Integer num = this.money;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getMoneyType() {
        return this.type;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setMoneyType(String type) {
        this.type = type;
    }
}
