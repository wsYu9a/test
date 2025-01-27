package com.kwad.sdk.core.videocache;

/* loaded from: classes3.dex */
public final class n {
    public final long aGQ;
    public final String aGR;
    public final String url;

    public n(String str, long j10, String str2) {
        this.url = str;
        this.aGQ = j10;
        this.aGR = str2;
    }

    public final String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.aGQ + ", mime='" + this.aGR + "'}";
    }
}
