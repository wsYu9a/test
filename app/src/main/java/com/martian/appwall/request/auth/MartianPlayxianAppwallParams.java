package com.martian.appwall.request.auth;

import v8.a;

/* loaded from: classes3.dex */
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

    public void setPlatform(String str) {
        this.platform = str;
    }
}
