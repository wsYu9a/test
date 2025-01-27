package com.kwad.sdk.core.videocache;

/* loaded from: classes2.dex */
public final class m {
    public final long aoh;
    public final String aoi;
    public final String url;

    public m(String str, long j2, String str2) {
        this.url = str;
        this.aoh = j2;
        this.aoi = str2;
    }

    public final String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.aoh + ", mime='" + this.aoi + "'}";
    }
}
