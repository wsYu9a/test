package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.c;
import com.martian.libmars.comm.request.MTHttpPostParams;

/* loaded from: classes3.dex */
public class BookshelfInfoPushParams extends MTHttpPostParams {

    @c
    private String sourceStrings;

    public BookshelfInfoPushParams() {
        super(new TYUrlProvider());
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "push/bookshelf";
    }

    public String getSourceStrings() {
        return this.sourceStrings;
    }

    public void setSourceStrings(String sourceStrings) {
        this.sourceStrings = sourceStrings;
    }
}
