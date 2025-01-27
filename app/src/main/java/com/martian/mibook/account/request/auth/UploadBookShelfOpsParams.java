package com.martian.mibook.account.request.auth;

import com.martian.mibook.lib.account.request.auth.TYAuthPostParams;
import v8.c;

/* loaded from: classes3.dex */
public class UploadBookShelfOpsParams extends TYAuthPostParams {

    @c
    private String book_shelf_ops;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthPostParams
    public String getAuthMethod() {
        return "upload_book_shelf";
    }

    public String getBook_shelf_ops() {
        return this.book_shelf_ops;
    }

    public void setBook_shelf_ops(String str) {
        this.book_shelf_ops = str;
    }
}
