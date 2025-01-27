package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class c0 implements m0 {

    /* renamed from: a */
    public final int f27232a;

    /* renamed from: b */
    public final long[] f27233b;

    /* renamed from: c */
    public final long[] f27234c;

    /* renamed from: d */
    public final long f27235d;

    public c0(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f27233b = jArr;
        this.f27234c = jArr3;
        int length = iArr.length;
        this.f27232a = length;
        if (length <= 0) {
            this.f27235d = 0L;
        } else {
            int i2 = length - 1;
            this.f27235d = jArr2[i2] + jArr3[i2];
        }
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public long a(long j2) {
        return this.f27233b[Util.binarySearchFloor(this.f27234c, j2, true, true)];
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public boolean a() {
        return true;
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public long c() {
        return this.f27235d;
    }
}
