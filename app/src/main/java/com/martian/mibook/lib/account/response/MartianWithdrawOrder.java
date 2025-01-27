package com.martian.mibook.lib.account.response;

import ba.l;

/* loaded from: classes3.dex */
public class MartianWithdrawOrder {
    private String account;
    private Long createdOn;
    private String header;
    private Long modifiedOn;
    private Integer money;
    private String nickname;
    private Integer paymentMoney;
    private Integer paymentType;
    private String phone;
    private String realname;
    private String transno;
    private Long uid;
    private Integer woid;
    private String womsg;
    private String woname;
    private Integer wostatus;
    private Integer wotype;

    public String getAccount() {
        return this.account;
    }

    public long getCreatedOn() {
        Long l10 = this.createdOn;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public String getHeader() {
        return this.header;
    }

    public long getModifiedOn() {
        Long l10 = this.modifiedOn;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public int getMoney() {
        Integer num = this.money;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getNickname() {
        return l.q(this.nickname) ? this.realname : this.nickname;
    }

    public int getPaymentMoney() {
        Integer num = this.paymentMoney;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getPaymentType() {
        Integer num = this.paymentType;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getPhone() {
        return this.phone;
    }

    public String getRealname() {
        return this.realname;
    }

    public Long getUid() {
        return this.uid;
    }

    public Integer getWoid() {
        return this.woid;
    }

    public String getWomsg() {
        return this.womsg;
    }

    public String getWoname() {
        return this.woname;
    }

    public int getWostatus() {
        Integer num = this.wostatus;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getWotype() {
        Integer num = this.wotype;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setCreatedOn(Long l10) {
        this.createdOn = l10;
    }

    public void setHeader(String str) {
        this.header = str;
    }

    public void setModifiedOn(Long l10) {
        this.modifiedOn = l10;
    }

    public void setMoney(Integer num) {
        this.money = num;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setPaymentMoney(Integer num) {
        this.paymentMoney = num;
    }

    public void setPaymentType(Integer num) {
        this.paymentType = num;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setRealname(String str) {
        this.realname = str;
    }

    public void setUid(Long l10) {
        this.uid = l10;
    }

    public void setWoid(Integer num) {
        this.woid = num;
    }

    public void setWomsg(String str) {
        this.womsg = str;
    }

    public void setWoname(String str) {
        this.woname = str;
    }

    public void setWostatus(Integer num) {
        this.wostatus = num;
    }

    public void setWotype(Integer num) {
        this.wotype = num;
    }
}
