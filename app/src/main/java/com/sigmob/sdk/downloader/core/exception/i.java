package com.sigmob.sdk.downloader.core.exception;

import java.io.IOException;

/* loaded from: classes4.dex */
public class i extends IOException {

    /* renamed from: a */
    public final int f19271a;

    public i(int i10, long j10) {
        super("Response code can't handled on internal " + i10 + " with current offset " + j10);
        this.f19271a = i10;
    }

    public int a() {
        return this.f19271a;
    }
}
