package com.martian.mibook.lib.original.http.request;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
public class ORBookParams extends TYHttpGetParams {

    @a
    private String bookId;

    public String getBookId() {
        return this.bookId;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "or/book";
    }

    public void setBookId(String str) {
        this.bookId = str;
    }
}
