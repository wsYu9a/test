package com.martian.mibook.lib.account.response;

import java.util.Date;

/* loaded from: classes3.dex */
public class TYConsumeOrder {
    private String bid;
    private Integer bookCoins;
    private Integer coid;
    private Integer cotype;
    private Date createdOn;
    private String extra;
    private Integer sourceType;
    private Integer status;
    private String subject;
    private Long uid;

    public String getBid() {
        return this.bid;
    }

    public Integer getBookCoins() {
        return this.bookCoins;
    }

    public Integer getCoid() {
        return this.coid;
    }

    public Integer getCotype() {
        return this.cotype;
    }

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public String getExtra() {
        return this.extra;
    }

    public Integer getSourceType() {
        Integer num = this.sourceType;
        return Integer.valueOf(num == null ? 1 : num.intValue());
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

    public void setBid(String bid) {
        this.bid = bid;
    }

    public void setBookCoins(Integer bookCoins) {
        this.bookCoins = bookCoins;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public void setCotype(Integer cotype) {
        this.cotype = cotype;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
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
