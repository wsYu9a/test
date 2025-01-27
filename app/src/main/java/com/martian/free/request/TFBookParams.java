package com.martian.free.request;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
public class TFBookParams extends TYHttpGetParams {

    @a
    private String bid;

    public String getBid() {
        return this.bid;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "tf/book";
    }

    public void setBid(String str) {
        this.bid = str;
    }
}
