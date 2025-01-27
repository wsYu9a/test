package com.sigmob.sdk.downloader.core.exception;

import java.io.IOException;

/* loaded from: classes4.dex */
public class f extends IOException {

    /* renamed from: a */
    public final com.sigmob.sdk.downloader.core.cause.b f19270a;

    public f(com.sigmob.sdk.downloader.core.cause.b bVar) {
        super("Resume failed because of " + bVar);
        this.f19270a = bVar;
    }

    public com.sigmob.sdk.downloader.core.cause.b a() {
        return this.f19270a;
    }
}
