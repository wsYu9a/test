package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class TYCommission {
    private Integer commission;
    private Long createdOn;
    private String type;

    public Integer getCommission() {
        return this.commission;
    }

    public Long getCreatedOn() {
        Long l = this.createdOn;
        return Long.valueOf(l == null ? 0L : l.longValue());
    }

    public String getType() {
        return this.type;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public void setType(String type) {
        this.type = type;
    }
}
