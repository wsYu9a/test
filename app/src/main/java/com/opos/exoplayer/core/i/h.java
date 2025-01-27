package com.opos.exoplayer.core.i;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a */
    private int f19025a;

    /* renamed from: b */
    private long[] f19026b;

    public h() {
        this(32);
    }

    public h(int i2) {
        this.f19026b = new long[i2];
    }

    public int a() {
        return this.f19025a;
    }

    public long a(int i2) {
        if (i2 >= 0 && i2 < this.f19025a) {
            return this.f19026b[i2];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i2 + ", size is " + this.f19025a);
    }

    public void a(long j2) {
        int i2 = this.f19025a;
        long[] jArr = this.f19026b;
        if (i2 == jArr.length) {
            this.f19026b = Arrays.copyOf(jArr, i2 * 2);
        }
        long[] jArr2 = this.f19026b;
        int i3 = this.f19025a;
        this.f19025a = i3 + 1;
        jArr2[i3] = j2;
    }

    public long[] b() {
        return Arrays.copyOf(this.f19026b, this.f19025a);
    }
}
