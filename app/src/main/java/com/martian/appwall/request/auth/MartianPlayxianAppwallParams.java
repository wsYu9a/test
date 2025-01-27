package com.martian.appwall.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes2.dex */
public class MartianPlayxianAppwallParams extends MartianAppwallAuthParams {

    @a
    private String platform;

    @Override // com.martian.appwall.request.auth.MartianAppwallAuthParams
    public String getAuthMethod() {
        return "xianwan_appwall";
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
