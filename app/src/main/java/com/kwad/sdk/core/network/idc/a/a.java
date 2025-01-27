package com.kwad.sdk.core.network.idc.a;

/* loaded from: classes3.dex */
public final class a {
    private final long aAN;
    private volatile boolean aAO = false;

    public a(long j10, boolean z10) {
        this.aAN = j10;
    }

    public final boolean FD() {
        return this.aAO;
    }

    public final long FE() {
        return this.aAN;
    }

    public final a bn(boolean z10) {
        this.aAO = true;
        return this;
    }
}
