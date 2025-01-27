package com.opos.videocache.a;

import java.io.File;

/* loaded from: classes4.dex */
public class g extends d {

    /* renamed from: a */
    private final long f23792a;

    public g(long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.f23792a = j2;
    }

    @Override // com.opos.videocache.a.d
    protected boolean a(File file, long j2, int i2) {
        return j2 <= this.f23792a;
    }
}
