package com.czhj.wire.okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes2.dex */
public final class InflaterSource implements Source {

    /* renamed from: a */
    public final BufferedSource f8933a;

    /* renamed from: b */
    public final Inflater f8934b;

    /* renamed from: c */
    public int f8935c;

    /* renamed from: d */
    public boolean f8936d;

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f8933a = bufferedSource;
        this.f8934b = inflater;
    }

    public final void a() throws IOException {
        int i10 = this.f8935c;
        if (i10 == 0) {
            return;
        }
        int remaining = i10 - this.f8934b.getRemaining();
        this.f8935c -= remaining;
        this.f8933a.skip(remaining);
    }

    @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f8936d) {
            return;
        }
        this.f8934b.end();
        this.f8936d = true;
        this.f8933a.close();
    }

    @Override // com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j10) throws IOException {
        boolean refill;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.f8936d) {
            throw new IllegalStateException("closed");
        }
        if (j10 == 0) {
            return 0L;
        }
        do {
            refill = refill();
            try {
                Segment a10 = buffer.a(1);
                Inflater inflater = this.f8934b;
                byte[] bArr = a10.f8950a;
                int i10 = a10.f8952c;
                int inflate = inflater.inflate(bArr, i10, 8192 - i10);
                if (inflate > 0) {
                    a10.f8952c += inflate;
                    long j11 = inflate;
                    buffer.f8900b += j11;
                    return j11;
                }
                if (!this.f8934b.finished() && !this.f8934b.needsDictionary()) {
                }
                a();
                if (a10.f8951b != a10.f8952c) {
                    return -1L;
                }
                buffer.f8899a = a10.pop();
                SegmentPool.a(a10);
                return -1L;
            } catch (DataFormatException e10) {
                throw new IOException(e10);
            }
        } while (!refill);
        throw new EOFException("source exhausted prematurely");
    }

    public boolean refill() throws IOException {
        if (!this.f8934b.needsInput()) {
            return false;
        }
        a();
        if (this.f8934b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f8933a.exhausted()) {
            return true;
        }
        Segment segment = this.f8933a.buffer().f8899a;
        int i10 = segment.f8952c;
        int i11 = segment.f8951b;
        int i12 = i10 - i11;
        this.f8935c = i12;
        this.f8934b.setInput(segment.f8950a, i11, i12);
        return false;
    }

    @Override // com.czhj.wire.okio.Source
    public Timeout timeout() {
        return this.f8933a.timeout();
    }

    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.buffer(source), inflater);
    }
}
