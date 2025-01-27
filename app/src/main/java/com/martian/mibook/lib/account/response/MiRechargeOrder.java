package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class MiRechargeOrder {
    public Integer bookCoins;
    public Long createdOn;
    public Integer money;
    public Long paymentTime;
    public Integer paymentType;
    public Integer roid;
    public Integer rotype;
    public Integer status;
    public String subject;
    public Long uid;

    public Integer getBookCoins() {
        return this.bookCoins;
    }

    public Long getCreatOn() {
        return this.createdOn;
    }

    public Long getCreatedOn() {
        return this.createdOn;
    }

    public int getMoney() {
        Integer num = this.money;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Long getPaymentTime() {
        return this.paymentTime;
    }

    public Integer getPaymentType() {
        return this.paymentType;
    }

    public Integer getRoid() {
        return this.roid;
    }

    public Integer getRotype() {
        return this.rotype;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getSubject() {
        return this.subject;
    }

    public Long getUid() {
        return this.uid;
    }

    public void setBookCoins(Integer num) {
        this.bookCoins = num;
    }

    public void setCreatedOn(Long l10) {
        this.createdOn = l10;
    }

    public void setMoney(Integer num) {
        this.money = num;
    }

    public void setPaymentTime(Long l10) {
        this.paymentTime = l10;
    }

    public void setPaymentType(Integer num) {
        this.paymentType = num;
    }

    public void setRoid(Integer num) {
        this.roid = num;
    }

    public void setRotype(Integer num) {
        this.rotype = num;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public void setSubject(String str) {
        this.subject = str;
    }

    public void setUid(Long l10) {
        this.uid = l10;
    }
}
