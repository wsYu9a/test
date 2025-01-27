package com.martian.mibook.lib.account.request;

import v8.a;

/* loaded from: classes3.dex */
public class MiGuestUserLoginParams extends TYHttpGetParams {

    @a
    private String sourceId;

    @a
    private String sourceName;

    @Override // u8.b
    public String getRequestMethod() {
        return "guest_user_login";
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }
}
