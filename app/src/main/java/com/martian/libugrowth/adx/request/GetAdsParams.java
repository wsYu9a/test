package com.martian.libugrowth.adx.request;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class GetAdsParams extends AdxHttpGetParams {

    @a
    private Boolean useCache;

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "lm/get_ads";
    }

    public Boolean getUseCache() {
        return this.useCache;
    }

    public void setUseCache(Boolean useCache) {
        this.useCache = useCache;
    }
}
