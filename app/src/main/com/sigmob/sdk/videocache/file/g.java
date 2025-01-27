package com.sigmob.sdk.videocache.file;

import java.io.File;

/* loaded from: classes4.dex */
public class g extends e {

    /* renamed from: b */
    public final int f20600b;

    public g(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.f20600b = i10;
    }

    @Override // com.sigmob.sdk.videocache.file.e
    public boolean a(File file, long j10, int i10) {
        return i10 <= this.f20600b;
    }
}
