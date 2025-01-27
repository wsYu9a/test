package com.martian.appwall.request;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes2.dex */
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

    public void setAwid(String awid) {
        this.awid = awid;
    }
}
