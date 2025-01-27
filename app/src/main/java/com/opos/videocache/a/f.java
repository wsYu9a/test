package com.opos.videocache.a;

import java.io.File;

/* loaded from: classes4.dex */
public class f extends d {

    /* renamed from: a */
    private final int f23791a;

    public f(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.f23791a = i2;
    }

    @Override // com.opos.videocache.a.d
    protected boolean a(File file, long j2, int i2) {
        return i2 <= this.f23791a;
    }
}
