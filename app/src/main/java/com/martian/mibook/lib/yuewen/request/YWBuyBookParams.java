package com.martian.mibook.lib.yuewen.request;

import com.martian.mibook.lib.account.request.auth.TYAuthParams;
import v8.a;

/* loaded from: classes3.dex */
public class YWBuyBookParams extends TYAuthParams {

    @a
    private String bookName;

    @a
    private String cbid;

    @a
    private Integer price;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "yw/buy_book";
    }

    public String getBookName() {
        return this.bookName;
    }

    public String getCbid() {
        return this.cbid;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setBookName(String str) {
        this.bookName = str;
    }

    public void setCbid(String str) {
        this.cbid = str;
    }

    public void setPrice(Integer num) {
        this.price = num;
    }
}
