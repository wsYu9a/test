package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.a;

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

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "recharge";
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setMethod(Integer method) {
        this.method = method;
    }

    public void setNight_mode(Boolean night_mode) {
        this.night_mode = night_mode;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
