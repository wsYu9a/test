package com.martian.mibook.lib.account.request;

import v8.a;

/* loaded from: classes3.dex */
public class BookShareParams extends TYBookHttpGetParams {

    @a
    private String inviter;

    @a
    private String sourceId;

    @a
    private String sourceName;

    public String getInviter() {
        return this.inviter;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "book";
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setInviter(String str) {
        this.inviter = str;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }
}
