package com.martian.libugrowth.adx.request;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class FinishAdsParams extends AdxHttpGetParams {

    @a
    private String adIds;

    @a
    private String planId;

    public String getAdIds() {
        return this.adIds;
    }

    public String getPlanId() {
        return this.planId;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "lm/finish_ads";
    }

    public void setAdIds(String adIds) {
        this.adIds = adIds;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }
}
