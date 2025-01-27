package com.martian.appwall.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes2.dex */
public class MartianFinishNextSubTaskParams extends MartianAppwallAuthParams {

    @a
    private String awid;

    @Override // com.martian.appwall.request.auth.MartianAppwallAuthParams
    public String getAuthMethod() {
        return "/complete_current_subtask.do";
    }

    public String getAwid() {
        return this.awid;
    }

    public void setAwid(String awid) {
        this.awid = awid;
    }
}
