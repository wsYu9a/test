package com.martian.appwall.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes2.dex */
public class MartianFinishRewardVideoParams extends MartianAppwallAuthParams {

    /* renamed from: c */
    @a
    private String f9682c;

    @a
    private String extra;

    @a
    private String vendor;

    @Override // com.martian.appwall.request.auth.MartianAppwallAuthParams
    public String getAuthMethod() {
        return "finish_reward_video";
    }

    public String getC() {
        return this.f9682c;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setC(String c2) {
        this.f9682c = c2;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
