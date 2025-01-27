package com.martian.mibook.lib.account.request.auth;

import v8.a;

/* loaded from: classes3.dex */
public class BindInviterParams extends TYAuthParams {

    @a
    private String inviteCode;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "bind_inviter.do";
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public void setInviteCode(String str) {
        this.inviteCode = str;
    }
}
