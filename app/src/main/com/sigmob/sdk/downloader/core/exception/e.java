package com.sigmob.sdk.downloader.core.exception;

import java.io.IOException;

/* loaded from: classes4.dex */
public class e extends IOException {

    /* renamed from: a */
    public final long f19268a;

    /* renamed from: b */
    public final long f19269b;

    public e(long j10, long j11) {
        super("There is Free space less than Require space: " + j11 + " < " + j10);
        this.f19268a = j10;
        this.f19269b = j11;
    }

    public long a() {
        return this.f19269b;
    }

    public long b() {
        return this.f19268a;
    }
}
