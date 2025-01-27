package com.martian.mibook.lib.account.request;

import v8.a;

/* loaded from: classes3.dex */
public class RechargeParams extends TYBookHttpGetParams {

    @a
    private String bookName;

    @a
    private Integer method;

    @a
    private Boolean night_mode;

    @a
    private Integer price;

    @a
    private String sourceId;

    @a
    private String sourceName;

    public String getBookName() {
        return this.bookName;
    }

    public Integer getMethod() {
        return this.method;
    }

    public Boolean getNight_mode() {
        return this.night_mode;
    }

    public Integer getPrice() {
        return this.price;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "recharge";
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setBookName(String str) {
        this.bookName = str;
    }

    public void setMethod(Integer num) {
        this.method = num;
    }

    public void setNight_mode(Boolean bool) {
        this.night_mode = bool;
    }

    public void setPrice(Integer num) {
        this.price = num;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }
}
