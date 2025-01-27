package com.martian.mibook.lib.account.request;

import v8.c;

/* loaded from: classes3.dex */
public class BookUpdateInfoParams extends TYHttpPostParams {

    @c
    private String sourceStrings;

    @Override // u8.b
    public String getRequestMethod() {
        return "ty/books/update_info";
    }

    public String getSourceStrings() {
        return this.sourceStrings;
    }

    public void setSourceStrings(String str) {
        this.sourceStrings = str;
    }
}
