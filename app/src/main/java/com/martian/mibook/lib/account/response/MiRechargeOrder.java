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

    public void setBookCoins(Integer bookCoins) {
        this.bookCoins = bookCoins;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setPaymentTime(Long paymentTime) {
        this.paymentTime = paymentTime;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public void setRoid(Integer roid) {
        this.roid = roid;
    }

    public void setRotype(Integer rotype) {
        this.rotype = rotype;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
