package com.martian.mibook.lib.account.request.auth;

import v8.a;

/* loaded from: classes3.dex */
public class CheckinNotifyParams extends TYAuthParams {

    @a
    private Boolean enable;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "update_checkin_notify";
    }

    public Boolean getEnable() {
        return this.enable;
    }

    public void setEnable(Boolean bool) {
        this.enable = bool;
    }
}
