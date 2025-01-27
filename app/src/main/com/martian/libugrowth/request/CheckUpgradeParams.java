package com.martian.libugrowth.request;

import v8.a;

/* loaded from: classes3.dex */
public class CheckUpgradeParams extends UGrowthHttpPostParams {

    @a
    private Boolean force;

    public Boolean getForce() {
        return this.force;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "upgrade/check";
    }

    public void setForce(Boolean bool) {
        this.force = bool;
    }
}
