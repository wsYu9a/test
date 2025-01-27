package com.martian.appwall.request.auth;

import v8.a;

/* loaded from: classes3.dex */
public class MartianFinishRewardVideoParams extends MartianAppwallAuthParams {

    /* renamed from: c */
    @a
    private String f12008c;

    @a
    private String extra;

    @a
    private String vendor;

    @Override // com.martian.appwall.request.auth.MartianAppwallAuthParams
    public String getAuthMethod() {
        return "finish_reward_video";
    }

    public String getC() {
        return this.f12008c;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setC(String str) {
        this.f12008c = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setVendor(String str) {
        this.vendor = str;
    }
}
