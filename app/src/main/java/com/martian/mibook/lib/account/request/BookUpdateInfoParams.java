package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.c;

/* loaded from: classes3.dex */
public class BookUpdateInfoParams extends TYHttpPostParams {

    @c
    private String sourceStrings;

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "ty/books/update_info";
    }

    public String getSourceStrings() {
        return this.sourceStrings;
    }

    public void setSourceStrings(String sourceStrings) {
        this.sourceStrings = sourceStrings;
    }
}
