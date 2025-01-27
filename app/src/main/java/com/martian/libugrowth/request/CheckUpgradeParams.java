package com.martian.libugrowth.request;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes.dex */
public class CheckUpgradeParams extends UGrowthHttpPostParams {

    @a
    private Boolean force;

    public Boolean getForce() {
        return this.force;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "upgrade/check";
    }

    public void setForce(Boolean force) {
        this.force = force;
    }
}
