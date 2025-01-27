package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.a;

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

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "book";
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setInviter(String inviter) {
        this.inviter = inviter;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
