package com.kwad.sdk.core.videocache;

/* loaded from: classes3.dex */
public abstract class p implements m {
    protected volatile String aGR;
    protected volatile int length = Integer.MIN_VALUE;
    protected String url;

    public abstract String In();

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "UrlSource{url='" + this.url + "', length=" + this.length + ", mime='" + this.aGR + "'}";
    }
}
