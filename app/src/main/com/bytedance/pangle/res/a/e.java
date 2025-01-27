package com.bytedance.pangle.res.a;

import java.io.InputStream;

/* loaded from: classes2.dex */
public final class e extends j {

    /* renamed from: a */
    private long f7783a;

    public e(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.bytedance.pangle.res.a.j
    public final synchronized void a(int i10) {
        if (i10 != -1) {
            this.f7783a += i10;
        }
    }

    public final synchronized long b() {
        return this.f7783a;
    }

    @Override // com.bytedance.pangle.res.a.j, java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j10) {
        long skip;
        skip = super.skip(j10);
        this.f7783a += skip;
        return skip;
    }

    public final int a() {
        long b10 = b();
        if (b10 <= 2147483647L) {
            return (int) b10;
        }
        throw new ArithmeticException("The byte count " + b10 + " is too large to be converted to an int");
    }
}
