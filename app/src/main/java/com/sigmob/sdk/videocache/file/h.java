package com.sigmob.sdk.videocache.file;

import java.io.File;

/* loaded from: classes4.dex */
public class h extends e {

    /* renamed from: b */
    public final long f20601b;

    public h(long j10) {
        if (j10 <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.f20601b = j10;
    }

    @Override // com.sigmob.sdk.videocache.file.e
    public boolean a(File file, long j10, int i10) {
        return j10 <= this.f20601b;
    }
}
