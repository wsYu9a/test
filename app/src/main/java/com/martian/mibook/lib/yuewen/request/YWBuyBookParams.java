package com.martian.mibook.lib.yuewen.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.auth.TYAuthParams;

/* loaded from: classes4.dex */
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

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setCbid(String cbid) {
        this.cbid = cbid;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
