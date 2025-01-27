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
        Long l10 = this.createdOn;
        return Long.valueOf(l10 == null ? 0L : l10.longValue());
    }

    public String getType() {
        return this.type;
    }

    public void setCommission(Integer num) {
        this.commission = num;
    }

    public void setCreatedOn(Long l10) {
        this.createdOn = l10;
    }

    public void setType(String str) {
        this.type = str;
    }
}
