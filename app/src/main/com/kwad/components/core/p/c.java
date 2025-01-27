package com.kwad.components.core.p;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class c extends InputStream {
    private InputStream UT;
    private int UU;
    private volatile float UW;
    private volatile long UX;
    private int UQ = -1;
    private int UR = 10000;
    private long US = -1;
    private long UV = -1;
    private int UY = 20480;

    public c(@NonNull InputStream inputStream, int i10) {
        i10 = i10 < 20480 ? 20480 : i10;
        this.UT = inputStream;
        this.UW = i10 / 1000.0f;
    }

    @WorkerThread
    private static void I(long j10) {
        try {
            Thread.sleep(j10);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
    }

    private static long g(long j10, long j11) {
        if (j10 <= 0) {
            return 0L;
        }
        if (j11 <= 0) {
            return -1L;
        }
        return j10 / j11;
    }

    private void rH() {
        this.UQ = 0;
        this.US = System.currentTimeMillis();
    }

    private void rI() {
        if (this.UQ < this.UR) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = currentTimeMillis - this.US;
        float f10 = this.UQ / this.UW;
        this.UX = g(this.UU, currentTimeMillis - this.UV);
        float f11 = j10;
        if (f10 > f11) {
            I((long) (f10 - f11));
        }
        rH();
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.UT.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.UT.close();
        b.a(this);
        this.UV = -1L;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i10) {
        this.UT.mark(i10);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.UT.markSupported();
    }

    public final long rG() {
        return this.UX;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.UV <= 0) {
            this.UV = System.currentTimeMillis();
        }
        this.UU++;
        if (!b.UO || !b.UN) {
            return this.UT.read();
        }
        if (this.UQ < 0) {
            rH();
        }
        int read = this.UT.read();
        this.UQ++;
        rI();
        return read;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.UT.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j10) {
        return this.UT.skip(j10);
    }
}
