package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class HistoryMoney {
    private Long createdOn;
    private Integer money;
    private String type;

    public Long getCreatedOn() {
        Long l10 = this.createdOn;
        return Long.valueOf(l10 == null ? 0L : l10.longValue());
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

    public void setCreatedOn(Long l10) {
        this.createdOn = l10;
    }

    public void setMoney(Integer num) {
        this.money = num;
    }

    public void setMoneyType(String str) {
        this.type = str;
    }
}
