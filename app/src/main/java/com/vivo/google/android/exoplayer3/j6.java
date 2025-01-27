package com.vivo.google.android.exoplayer3;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class j6 {

    /* renamed from: a */
    public int f27546a;

    /* renamed from: b */
    public long[] f27547b;

    public j6(int i2) {
        this.f27547b = new long[i2];
    }

    public long a(int i2) {
        if (i2 >= 0 && i2 < this.f27546a) {
            return this.f27547b[i2];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i2 + ", size is " + this.f27546a);
    }

    public void a(long j2) {
        int i2 = this.f27546a;
        long[] jArr = this.f27547b;
        if (i2 == jArr.length) {
            this.f27547b = Arrays.copyOf(jArr, i2 * 2);
        }
        long[] jArr2 = this.f27547b;
        int i3 = this.f27546a;
        this.f27546a = i3 + 1;
        jArr2[i3] = j2;
    }
}
