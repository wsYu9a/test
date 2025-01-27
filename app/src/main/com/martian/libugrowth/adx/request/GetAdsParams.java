package com.martian.libugrowth.adx.request;

import v8.a;

/* loaded from: classes3.dex */
public class GetAdsParams extends AdxHttpGetParams {

    @a
    private Boolean useCache;

    @Override // u8.b
    public String getRequestMethod() {
        return "lm/get_ads";
    }

    public Boolean getUseCache() {
        return this.useCache;
    }

    public void setUseCache(Boolean bool) {
        this.useCache = bool;
    }
}
