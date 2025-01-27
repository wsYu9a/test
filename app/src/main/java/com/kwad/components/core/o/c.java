package com.kwad.components.core.o;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.vivo.google.android.exoplayer3.upstream.cache.CacheDataSink;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class c extends InputStream {
    private InputStream Pj;
    private int Pk;
    private volatile float Pm;
    private volatile long Pn;
    private int Pg = -1;
    private int Ph = 10000;
    private long Pi = -1;
    private long Pl = -1;
    private int Po = CacheDataSink.DEFAULT_BUFFER_SIZE;

    c(@NonNull InputStream inputStream, int i2) {
        i2 = i2 < 20480 ? CacheDataSink.DEFAULT_BUFFER_SIZE : i2;
        this.Pj = inputStream;
        this.Pm = i2 / 1000.0f;
    }

    private static long d(long j2, long j3) {
        if (j2 <= 0) {
            return 0L;
        }
        if (j3 <= 0) {
            return -1L;
        }
        return j2 / j3;
    }

    private void pr() {
        this.Pg = 0;
        this.Pi = System.currentTimeMillis();
    }

    private void ps() {
        if (this.Pg < this.Ph) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.Pi;
        float f2 = this.Pg / this.Pm;
        this.Pn = d(this.Pk, currentTimeMillis - this.Pl);
        float f3 = j2;
        if (f2 > f3) {
            w((long) (f2 - f3));
        }
        pr();
    }

    @WorkerThread
    private static void w(long j2) {
        try {
            Thread.sleep(j2);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.Pj.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.Pj.close();
        b.a(this);
        this.Pl = -1L;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i2) {
        this.Pj.mark(i2);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.Pj.markSupported();
    }

    public final long pq() {
        return this.Pn;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.Pl <= 0) {
            this.Pl = System.currentTimeMillis();
        }
        this.Pk++;
        if (!(b.Pe && b.Pd)) {
            return this.Pj.read();
        }
        if (this.Pg < 0) {
            pr();
        }
        int read = this.Pj.read();
        this.Pg++;
        ps();
        return read;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.Pj.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j2) {
        return this.Pj.skip(j2);
    }
}
