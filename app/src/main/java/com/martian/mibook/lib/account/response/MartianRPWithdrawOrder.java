package com.martian.mibook.lib.account.response;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class MartianRPWithdrawOrder {
    private String account;
    private Long createdOn;
    private String header;
    private Long modifiedOn;
    private Integer money;
    private String nickname;
    private Integer orderId;
    private Integer paymentType;
    private String phone;
    private String realname;
    private String transno;
    private Long uid;
    private String womsg;
    private Integer wostatus;
    private Integer wotype;

    public String getAccount() {
        return this.account;
    }

    public long getCreatedOn() {
        Long l = this.createdOn;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public String getHeader() {
        return this.header;
    }

    public long getModifiedOn() {
        Long l = this.modifiedOn;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public int getMoney() {
        Integer num = this.money;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getNickname() {
        return TextUtils.isEmpty(this.nickname) ? this.realname : this.nickname;
    }

    public int getOrderId() {
        Integer num = this.orderId;
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

    public String getWomsg() {
        return this.womsg;
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

    public void setAccount(String account) {
        this.account = account;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setModifiedOn(Long modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public void setWomsg(String womsg) {
        this.womsg = womsg;
    }

    public void setWostatus(Integer wostatus) {
        this.wostatus = wostatus;
    }

    public void setWotype(Integer wotype) {
        this.wotype = wotype;
    }
}
