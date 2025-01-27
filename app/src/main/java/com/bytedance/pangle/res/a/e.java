package com.bytedance.pangle.res.a;

import java.io.InputStream;

/* loaded from: classes.dex */
public final class e extends j {

    /* renamed from: a */
    private long f6269a;

    public e(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.bytedance.pangle.res.a.j
    protected final synchronized void a(int i2) {
        if (i2 != -1) {
            this.f6269a += i2;
        }
    }

    public final synchronized long b() {
        return this.f6269a;
    }

    @Override // com.bytedance.pangle.res.a.j, java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j2) {
        long skip;
        skip = super.skip(j2);
        this.f6269a += skip;
        return skip;
    }

    public final int a() {
        long b2 = b();
        if (b2 <= 2147483647L) {
            return (int) b2;
        }
        throw new ArithmeticException("The byte count " + b2 + " is too large to be converted to an int");
    }
}
