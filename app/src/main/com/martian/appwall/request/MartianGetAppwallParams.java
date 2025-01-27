package com.martian.appwall.request;

import v8.a;

/* loaded from: classes3.dex */
public class MartianGetAppwallParams extends MartianAppwallAuthoptParams {

    @a
    private String awid;

    @Override // com.martian.appwall.request.MartianAppwallAuthoptParams
    public String getAuthMethod() {
        return "/get_appwall_task.do";
    }

    public String getAwid() {
        return this.awid;
    }

    public void setAwid(String str) {
        this.awid = str;
    }
}
