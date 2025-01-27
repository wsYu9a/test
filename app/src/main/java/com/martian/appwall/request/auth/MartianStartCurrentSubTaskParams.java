package com.martian.appwall.request.auth;

import v8.a;

/* loaded from: classes3.dex */
public class MartianStartCurrentSubTaskParams extends MartianAppwallAuthParams {

    @a
    private String awid;

    @Override // com.martian.appwall.request.auth.MartianAppwallAuthParams
    public String getAuthMethod() {
        return "/start_current_subtask.do";
    }

    public String getAwid() {
        return this.awid;
    }

    public void setAwid(String str) {
        this.awid = str;
    }
}
