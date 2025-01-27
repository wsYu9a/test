package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.a1;
import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class b1 implements a1.a {

    /* renamed from: a */
    public final long[] f27202a;

    /* renamed from: b */
    public final long[] f27203b;

    /* renamed from: c */
    public final long f27204c;

    public b1(long[] jArr, long[] jArr2, long j2) {
        this.f27202a = jArr;
        this.f27203b = jArr2;
        this.f27204c = j2;
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public long a(long j2) {
        return this.f27203b[Util.binarySearchFloor(this.f27202a, j2, true, true)];
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public boolean a() {
        return true;
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public long c() {
        return this.f27204c;
    }

    @Override // com.vivo.google.android.exoplayer3.a1.a
    public long c(long j2) {
        return this.f27202a[Util.binarySearchFloor(this.f27203b, j2, true, true)];
    }
}
