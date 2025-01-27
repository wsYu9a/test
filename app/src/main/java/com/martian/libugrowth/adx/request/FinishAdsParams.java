package com.martian.libugrowth.adx.request;

import v8.a;

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

    @Override // u8.b
    public String getRequestMethod() {
        return "lm/finish_ads";
    }

    public void setAdIds(String str) {
        this.adIds = str;
    }

    public void setPlanId(String str) {
        this.planId = str;
    }
}
