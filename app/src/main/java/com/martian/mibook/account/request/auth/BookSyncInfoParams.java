package com.martian.mibook.account.request.auth;

import com.martian.libcomm.http.requests.d.c;
import com.martian.mibook.lib.account.request.auth.TYAuthPostParams;

/* loaded from: classes.dex */
public class BookSyncInfoParams extends TYAuthPostParams {

    @c
    private String book_shelf_ops;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthPostParams
    public String getAuthMethod() {
        return "sync_book_shelf.do";
    }

    public String getBook_shelf_ops() {
        return this.book_shelf_ops;
    }

    public void setBook_shelf_ops(String book_shelf_ops) {
        this.book_shelf_ops = book_shelf_ops;
    }
}
