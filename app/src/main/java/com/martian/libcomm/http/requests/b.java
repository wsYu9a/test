package com.martian.libcomm.http.requests;

import okhttp3.RequestBody;

/* loaded from: classes.dex */
public abstract class b {
    private static final String DEFAULT_CHARSET = "UTF-8";
    protected c mProvider;

    public b(c provider) {
        this.mProvider = provider;
    }

    public boolean enableCookie() {
        return false;
    }

    public c getProvider() {
        return this.mProvider;
    }

    public abstract String getRequestMethod();

    protected void setProvider(c mProvider) {
        this.mProvider = mProvider;
    }

    public String toHttpUrl(String charset) {
        return getProvider().getRequestUrl(this, charset);
    }

    public RequestBody toPostContent(String charset) {
        return a.i(this, charset);
    }

    public String toHttpUrl() {
        return getProvider().getRequestUrl(this, "UTF-8");
    }
}
