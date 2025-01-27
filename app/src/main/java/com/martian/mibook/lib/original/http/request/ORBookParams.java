package com.martian.mibook.lib.original.http.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes2.dex */
public class ORBookParams extends TYHttpGetParams {

    @a
    private String bookId;

    public String getBookId() {
        return this.bookId;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "or/book";
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
